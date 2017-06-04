package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteParking {
	// 메인메소드 실행부분 예외처리를 throws를 이용해 java가 처리하게 만들었다
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 드라이버 이름이 존재하는 클래스를 메모리에 로딩한다
		Class.forName("com.mysql.jdbc.Driver");
		// 아이디와 패스워드 등 접속 정보를 이용해서 Mysql DB에 연결해준다
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL문을 처리하기 위해 Statement 객체를 생성
		Statement stmt = conn.createStatement();
		// ""안에 있는  sql문장을 DB로 보내어 parking table을 삭제해준다.
		stmt.execute("delete from parking;");

		// 테이블 자체를 지우는 drop sql문
//		stmt.execute("drop table parking;");
		
		// Statement 객체 종료	
		stmt.close();
		// Connection 객체 종료
		conn.close();
	}
}
