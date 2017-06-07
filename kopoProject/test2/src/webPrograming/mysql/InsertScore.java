package webPrograming.mysql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import webPrograming.stringBuffer.OneRec;

public class InsertScore {
	// 메인메소드 실행부분 예외처리를 throws를 이용해 java가 처리하게 만들었다
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// 드라이버 이름이 존재하는 클래스를 메모리에 로딩한다
		Class.forName("com.mysql.jdbc.Driver");
		// 아이디와 패스워드, 접속 정보를 이용해서 Mysql DB에 연결해준다
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL문을 처리하기 위해 Statement 객체를 생성
		Statement stmt = conn.createStatement();

		// 버퍼 클래스를 이용해서 한줄씩 가져와 저장할 String 변수
		String QueryTxt;
		// 전체 학생수 제한
		int iPerson = 1000;

		// 반복 횟수를 알기위한 int 변수
		int LineCnt = 1;
		// 에러 횟수
		int eCnt=0;

		// 파일이 비어있지 않으면 가져와서 반복처리
		while (LineCnt<= iPerson) {
			// 예외 처리를 위한 try - catch 문
			try{
				// 이름은 번호를 추가해 순차적으로  국어, 영어, 수학 성적은 랜덤하게 생성해준다
				String name = String.format("홍길%02d", LineCnt);
				int kor = (int)(Math.random()*100);	//국어점수 만들기
				int eng = (int)(Math.random()*100);	//영어점수 만들기
				int mat = (int)(Math.random()*100);	//수학점수 만들기
				
				// 생성한 데이터를 sql에 반영하기 위해 String 변수에 저장하는 부분
				QueryTxt = String.format("insert into score(sId,sName,kor,eng,mat)"+
															" values("
															+ "%02d,'%s',%d,%d,%d);",
															LineCnt, name, kor, eng, mat
															);
				// sql문을 보내어 DB에서 처리한다
				stmt.execute(QueryTxt);
				// 예외없이 정상 작동시 출력
				System.out.printf("%d번째 항목 Insert OK [%s]\n", LineCnt,QueryTxt );
			}catch(Exception e){
				// 예외가 발생하면 에러 내용을 화면에 출력
				e.printStackTrace();
				// 에러 횟수 증가
				eCnt++;
			}
			// 한번 실행될때마다 반복횟수 증가
			LineCnt++;
		}
		// 에러 발생횟수를 화면에 출력
		System.out.printf("에러 Data 총 갯수 : %d\n", eCnt);

		// Statement 객체 종료
		stmt.close();
		// Connection 객체 종료
		conn.close();
	}
}
