package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable {
	// 메인메소드 실행부분 예외처리를 throws를 이용해 java가 처리하게 만들었다
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 드라이버 이름이 존재하는 클래스를 메모리에 로딩한다
		Class.forName("com.mysql.jdbc.Driver");
		// 아이디와 패스워드, 접속 정보를 이용해서 Mysql DB에 연결해준다
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL문을 처리하기 위해 Statement 객체를 생성
		Statement stmt = conn.createStatement();
		// ""안에 있는  sql문장을 DB로 보내어 table을 생성해준다.
		stmt.execute( "create table examtable(" + // Result Set이 의미 없음 executeQuery ->execute
						"name varchar(20),"+	// name 컬럼을 varchar 형식으로 20을 할당
						"studentid int not null primary key," +	// studentid 컬럼에 null을 허용하지 않고 primary key 설정한다
						"kor	int," +			// kor 컬럼을 int형으로 설정
						"eng	int," +			// eng 컬럼을 int형으로 설정
						"mat	int)" +			// mat 컬럼을 int형으로 설정
						"DEFAULT CHARSET=utf8;");	// 테이블의 기본 charset을 utf8로 설정한다

		// Statement 객체 종료
		stmt.close();
		// Connection 객체 종료
		conn.close();
	}
}
