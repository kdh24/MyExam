package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();
		stmt.execute( "create table examtable(" + // Result Set이 의미 없음 executeQuery ->execute
						"name varchar(20),"+
						"studentid int not null primary key," +
						"kor	int," +
						"eng	int," +
						"mat	int)" +
						"DEFAULT CHARSET=utf8;");
		
		stmt.close();
		conn.close();
	}
}
