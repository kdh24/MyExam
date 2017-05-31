package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24", "root", "ehdgus24");
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("show databases;");
		
		while(rset.next()){
			System.out.println("°ª : " + rset.getString(1));
		}
		rset.close();
		stmt.close();
		conn.close();
	}
}
