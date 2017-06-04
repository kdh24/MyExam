package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReadTable {
	// 메인메소드 실행부분 예외처리를 throws를 이용해 java가 처리하게 만들었다
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 드라이버 이름이 존재하는 클래스를 메모리에 로딩한다
		Class.forName("com.mysql.jdbc.Driver");
		// 아이디와 패스워드, 접속 정보를 이용해서 Mysql DB에 연결해준다
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL문을 처리하기 위해 Statement 객체를 생성
		Statement stmt = conn.createStatement();
		// DB에서 자료를 조회하는 select 문을 Statement 객체로 DB에 보내어 ResultSet 객체에 결과를 받아온다
		ResultSet rset = stmt.executeQuery("select * from examtable;");
		// 이름 학번 국어 영어 수학을 문자와 공백 그대로 화면에 출력해준다
		System.out.printf("  이름  학번  국어  영어  수학 \n");
		// ResultSet 객체 rset에 값이 있으면 반복처리
		while(rset.next()){
			// 위에 제목에 따라 값을 맞추어 1~5째까지 각각의 데이터를 순서대로 화면에 출력해준다
			System.out.printf("%4s %6d %3d %3d %3d \n",
					rset.getString(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
		}
		//ResultSet 객체 종료
		rset.close();
		// Statement 객체 종료
		stmt.close();
		// Connection 객체 종료
		conn.close();
	}
}
