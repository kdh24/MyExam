package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReadTable {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();
		
		ResultSet rset = stmt.executeQuery("select * from examtable;");
		
		System.out.printf("  이름  학번  국어  영어  수학 \n");
		while(rset.next()){
			System.out.printf("%4s %6d %3d %3d %3d \n",
					rset.getString(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
		}
		rset.close();
		stmt.close();
		conn.close();
	}
}
