package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	// 메인메소드 실행부분 예외처리를 throws를 이용해 java가 처리하게 만들었다
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 드라이버 이름이 존재하는 클래스를 메모리에 동적으로 로딩
		Class.forName("com.mysql.jdbc.Driver");
		// 아이디와 패스워드, 접속 정보를 이용해서 Mysql DB에 연결해준다
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24", "root", "ehdgus24");
		// SQL문을 처리하기 위해 Statement 객체를 생성
		Statement stmt = conn.createStatement();
		// Statement 객체를 이용해서 show databases 라는 sql문을 처리하고 ResultSet 객체에 결과를 받아온다
		ResultSet rset = stmt.executeQuery("show databases;");
		
		// ResultSet 객체에 값이 있다면 계속 반복해서 실행
		while(rset.next()){
			// ResultSet 객체로 받아온 첫번째 값을 화면에 출력해준다.
			System.out.println("값 : " + rset.getString(1));
		}
		//ResultSet 객체 자원반환
		rset.close();
		// Statement 객체 자원반환
		stmt.close();
		// Connection 객체 자원반환
		conn.close();
	}
}
