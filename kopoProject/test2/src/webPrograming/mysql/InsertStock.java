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

	// 메인메소드 실행부분 예외처리를 throws를 이용해 java가 처리하게 만들었다
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// 드라이버 이름이 존재하는 클래스를 메모리에 로딩한다
		Class.forName("com.mysql.jdbc.Driver");
		// 아이디와 패스워드 등 접속 정보를 이용해서 Mysql DB에 연결해준다
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL문을 처리하기 위해 PreparedStatement 객체를 생성
		PreparedStatement psmt = null;
		// 자동 commit 기능 해제 
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
		// 파일 데이터를 DB에 저장하기 위한 sql문을 String 변수에 저장
		sqlStr = "insert into stock(st_code,sDay,sItemCode,endMoney,sMoney,topMoney, "
				+ "lowMoney,tradeNum,tradeMoney) values("
				+ "?,?,?,?,?,"
				+ "?,?,?,?);";
		// 파일 데이터를 DB에 저장하기 위한 sql문을 PreparedStatement 객체에 기억시킨다
		psmt = conn.prepareStatement(sqlStr);
		// 한 줄을 먼저 읽어야 필드명을 알 수 있다.
		// 파일에서 읽어온 값이 없을 경우 빈 파일이라고 알려주고 종료
		if ((readtxt = br.readLine()) == null) {
			System.out.printf("빈 파일입니다.\n");
			return;
		}
		// 반복 횟수를 알기위한 int 변수
		int LineCnt = 1;
		// 에러 반복 횟수 체크
		int eCnt=0;

		// 파일이 비어있지 않으면 가져와서 반복처리
		while ((readtxt = br.readLine()) != null ) {
			// 탭(\t)을 구분자로 버퍼에서 가져온 한줄의 값(readtxt)를 field 배열에 나눠서 저장해준다
			try{ // 예외처리를 위한 try - catch 문
				// 파일에서 가져온 readtxt 문자열을  "%_%" 구분자로 나눠서 field 배열에 가져온다
				String[] field = readtxt.split("%_%");
				// field 길이만큼 반복처리
				for(int i=0; i<field.length; i++){
					// field 배열값에서 ^ 문자를 없애주고 공백도 제거해준다
					field[i] = field[i].replace("^", "").trim();
					//field 배열값이 없으면 "0" 으로 넣어준다
					if(field[i].equals(""))
						field[i] = "0";
				}
				// 필드 길이가 2가 이상일때만 값들을 insrt 해준다
				if(field.length>2 ){
					psmt.setString(1, field[0]); // 표준 종목코드 셋팅
					psmt.setString(2, field[1]); // 일자 셋팅
					psmt.setString(3, field[2]); // 단축 종목코드
					psmt.setString(4, field[3]); // 종가
					psmt.setString(5, field[4]); // 시가
					psmt.setString(6, field[5]); // 최고가
					psmt.setString(7, field[6]); // 최저가
					psmt.setString(8, field[11]); // 누적 거래량
					psmt.setString(9, field[12]); // 누적 거래대금
					
					psmt.addBatch(); // Batch 처리를 위해 Batch에 누적시켜준다

					// 라인수 만단위 마다 실행
					if(LineCnt % 10000 == 0){
						// 쌓아놓은 Batch를 DB로 보내어 처리
						psmt.executeBatch();
						// Batch 값들을 비워준다
						psmt.clearBatch();
						// 내용을 commit 한다
						conn.commit();
					}
					// 사용한 PreparedStatement 객체를 해제시켜준다
					psmt.clearParameters();
					// 저장된 데이터 확인부분 빠른 처리를 위해 주석처리
//					System.out.printf("%d번재 항목 Insert OK [%s %s %s]\n", LineCnt, field[0], field[1], field[2]);
					// 반복횟수 증가
					LineCnt++;
				}
			}catch(Exception e){
				e.getMessage();  // 에러 메시지 출력
				// 에러 메세지를 ErrorCheck ArrayList에 추가시켜준다
				alError.add(new ErrorCheck(e.getMessage(), LineCnt));
				// 에러 횟수 증가
				eCnt++;
			}
			// 한번 실행될때마다 반복횟수 증가
		}
		// 남아있는 Batch 값 처리
		psmt.executeBatch();
		// Batch로 보낸 내용 commit
		conn.commit();
		// 사용한 PreparedStatement 객체를 해제시켜준다
		psmt.clearParameters();
		// 에러 길이만큼 반복실행
		for(int i=0; i<alError.size(); i++){
			//에러 라인수와 에러메세지를 화면에 출력
			System.out.printf("에러 라인 수 : %d - 에러 메세지 : %s \n ",
					alError.get(i).eCount, alError.get(i).eMessage );
		}
		// 에러 데이터의 총 갯수를 화면에 출력
		System.out.printf("에러 Data 총 갯수 : %d\n", eCnt);

		// PreparedStatement 객체 종료	
		psmt.close();
		// Connection 객체 종료
		conn.close();
	}
}
