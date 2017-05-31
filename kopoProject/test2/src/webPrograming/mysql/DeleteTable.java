package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteTable {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();
		
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('효민',209901,95,100,95);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('보람',209902,95,95,95);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('은정',209903,100,100,100);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('지연',209904,100,95,90);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('소연',209905,80,100,70);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('큐리',209906,100,100,70);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('화영',209907,70,70,70);");
		
		stmt.close();
		conn.close();
	}
}
