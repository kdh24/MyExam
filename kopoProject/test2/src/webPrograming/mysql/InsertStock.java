package webPrograming.mysql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InsertStock {

	// Error 발생시 메세지 저장을 위한 Class 생성(에러 메세지, 에러발생 라인 정보 저장)
	public static class ErrorCheck{
		static String eMessage;
		static int eCount;
		// 에러 메세지를 가져와서 초기화해주는 생성자 부분
		ErrorCheck(String eMessage, int eCount){
			this.eMessage= eMessage;
			this.eCount= eCount;
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();
		PreparedStatement psmt = null;

		conn.setAutoCommit(false);
		// \은 특수문자이므로 \\ 두 개를 써야한다
		File f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
		// 파일을 읽이 위한 버퍼 클래스 생성 및 선언
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		ArrayList<ErrorCheck> alError = new ArrayList<>();

		// 버퍼 클래스를 이용해서 한줄씩 가져와 저장할 String 변수
		String readtxt;
		String QueryTxt;
		String sqlStr;
		sqlStr = "insert into stock(st_code,sDay,sItemCode,endMoney,sMoney,topMoney, "
				+ "lowMoney,tradeNum,tradeMoney) values("
				+ "?,?,?,?,?,"
				+ "?,?,?,?);";
		
		psmt = conn.prepareStatement(sqlStr);
		// 한 줄을 먼저 읽어야 필드명을 알 수 있다.
		// 파일에서 읽어온 값이 없을 경우 빈 파일이라고 알려준다
		if ((readtxt = br.readLine()) == null) {
			System.out.printf("빈 파일입니다.\n");
			return;
		}
		// 빈 파일이 아닐때 처음으로 가져온 값은 항목의 제목부분이므로 field_name 배열에 순차로 저장
		// 반복 횟수를 알기위한 int 변수
		int LineCnt = 1;
		int eCnt=0;

		// 파일이 비어있지 않으면 가져와서 반복처리
		while ((readtxt = br.readLine()) != null ) {
			// 탭(\t)을 구분자로 버퍼에서 가져온 한줄의 값(readtxt)를 field 배열에 나눠서 저장해준다
			try{
				String[] field = readtxt.split("%_%");
				for(int i=0; i<field.length; i++){
					field[i] = field[i].replace("^", "").trim();
					if(field[i].equals(""))
						field[i] = "0";
//					System.out.println(field[i]);
				}
				if(field.length>2 ){
					psmt.setString(1, field[0]);
					psmt.setString(2, field[1]);
					psmt.setString(3, field[2]);
					psmt.setString(4, field[3]);
					psmt.setString(5, field[4]);
					psmt.setString(6, field[5]);
					psmt.setString(7, field[6]);
					psmt.setString(8, field[11]);
					psmt.setString(9, field[12]);
					
					psmt.addBatch();
//					psmt.execute();
					if(LineCnt % 10000 == 0){
						psmt.executeBatch();
						psmt.clearBatch();
						conn.commit();
					}
					psmt.clearParameters();
//					System.out.printf("%d번재 항목 Insert OK [%s %s %s]\n", LineCnt, field[0], field[1], field[2]);

					LineCnt++;
				}
			}catch(Exception e){
				e.getMessage();
				alError.add(new ErrorCheck(e.getMessage(), LineCnt));
				eCnt++;
			}
			// 한번 실행될때마다 반복횟수 증가
		}
		psmt.executeBatch();
		conn.commit();
		psmt.clearParameters();
		for(int i=0; i<alError.size(); i++){
			System.out.printf("에러 라인 수 : %d - 에러 메세지 : %s \n ",
					alError.get(i).eCount, alError.get(i).eMessage );
		}
		System.out.printf("에러 Data 총 갯수 : %d\n", eCnt);
		
		psmt.close();
		conn.close();
	}
}
