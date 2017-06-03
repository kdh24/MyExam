package webPrograming.mysql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InsertPark {
	
	public static class ErrorCheck{
		static String eMessage;
		static int eCount;
		
		ErrorCheck(String eMessage, int eCount){
			this.eMessage= eMessage;
			this.eCount= eCount;
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();

		// \은 특수문자이므로 \\ 두 개를 써야한다
		File f = new File("C:\\test\\전국주차장표준데이터.txt");
		// 파일을 읽이 위한 버퍼 클래스 생성 및 선언
		BufferedReader br = new BufferedReader(new FileReader(f));
		

		ArrayList<ErrorCheck> alError = new ArrayList<>();

		// 버퍼 클래스를 이용해서 한줄씩 가져와 저장할 String 변수
		String readtxt;
		String QueryTxt;

		// 한 줄을 먼저 읽어야 필드명을 알 수 있다.
		// 파일에서 읽어온 값이 없을 경우 빈 파일이라고 알려준다
		if ((readtxt = br.readLine()) == null) {
			System.out.printf("빈 파일입니다.\n");
			return;
		}
		// 빈 파일이 아닐때 처음으로 가져온 값은 항목의 제목부분이므로 field_name 배열에 순차로 저장
		String[] field_name = readtxt.split("\t");

		// 융합기술 우리집 위도경도, 지도에서 알아보기
		double k07_lat = 37.3860521;
		double k07_lng = 127.1214038;

		// 반복 횟수를 알기위한 int 변수
		int LineCnt = 1;
		int eCnt=1;

		// 파일이 비어있지 않으면 가져와서 반복처리
		while ((readtxt = br.readLine()) != null) {
			// 탭(\t)을 구분자로 버퍼에서 가져온 한줄의 값(readtxt)를 field 배열에 나눠서 저장해준다
			try{
				String[] field = readtxt.split("\t");
				
				if(Double.parseDouble(field[31]) > 120){
					String temp=null;
					temp = field[31].trim();
					field[31] = field[32].trim();
					field[32] = temp;
				}
				if(Double.parseDouble(field[32]) < 40.0)
					field[32] = String.valueOf(Double.parseDouble(field[32]) + 100.0);
				
				QueryTxt = String.format("insert into parking(pId,pName,pCartegory,pType,pAdd1,"
															+ "pAdd2,pNum,pMoney, pAdminName, pAdminTel,"
															+ "plat,plng) values("
																	+ "'%s','%s','%s','%s','%s',"
																	+ "'%s',%d,'%s','%s','%s',"
																	+ "%f,%f);",
																	field[0],field[1],field[2],field[3],field[4] == null? "":field[4].trim(),
																	field[5],Integer.parseInt(field[6]),field[16],field[26],field[27],
																	field.length > 31 ? Double.parseDouble(field[31]) : null, field.length > 32 ? Double.parseDouble(field[32]) : null);
				stmt.execute(QueryTxt);
				System.out.printf("%d번재 항목 Insert OK [%s]\n", LineCnt,QueryTxt );
			}catch(Exception e){
//				System.out.println(e.getMessage());
				
				alError.add(new ErrorCheck(e.getMessage(), LineCnt));
				if(e.getMessage().equals("empty String"))
					System.out.println(LineCnt + " " + readtxt);
//				alError.add(new ErrorCheck(e.getMessage(), LineCnt));
				eCnt++;
			}
			// 한번 실행될때마다 반복횟수 증가
			LineCnt++;
		}
		
		for(int i=0; i<alError.size(); i++){
			System.out.printf("에러 라인 수 : %d - 에러 메세지 : %s \n ", alError.get(i).eCount, alError.get(i).eMessage );
			
		}
		System.out.printf("에러 Data 총 갯수 : %d\n", eCnt);
		
		stmt.close();
		conn.close();
	}
}
