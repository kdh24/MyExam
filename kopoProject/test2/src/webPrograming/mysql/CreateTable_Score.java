package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable_Score {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();
		stmt.execute( "create table score(" + // Result Set�� �ǹ� ���� executeQuery ->execute
						"sId int not null ,"+	// ������ ������ȣ  1
						"sName varchar(20) not null," +	// �������  2
						"kor	int," +		// ������ ���� 3
						"eng	int," +			// ������ ���� 4 
						"mat	int," +			// �����������ּ� 5
						"CONSTRAINT PK_score_sId primary key(sId)) "+ 
						"DEFAULT CHARSET=utf8;");	// �浵 33
						
		stmt.close();
		conn.close();
	}
}
