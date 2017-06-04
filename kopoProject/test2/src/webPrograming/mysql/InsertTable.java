package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertTable {
	// 메인메소드 실행부분 예외처리를 throws를 이용해 java가 처리하게 만들었다
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 드라이버 이름이 존재하는 클래스를 메모리에 로딩한다
		Class.forName("com.mysql.jdbc.Driver");
		// 아이디와 패스워드, 접속 정보를 이용해서 Mysql DB에 연결해준다
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL문을 처리하기 위해 Statement 객체를 생성
		Statement stmt = conn.createStatement();
		
		// 각각의 값을 삽입하는 sql문을 ""로 묶어 Statement객체를 이용해서 DB에 보내 값을 examtable에 넣어준다
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('효민',209901,95,100,95);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('보람',209902,95,95,95);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('은정',209903,100,100,100);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('지연',209904,100,95,90);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('소연',209905,80,100,70);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('큐리',209906,100,100,70);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('화영',209907,70,70,70);");

		// Statement 객체 종료
		stmt.close();
		// Connection 객체 종료
		conn.close();
	}
}
