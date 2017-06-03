package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable_parking {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();
		stmt.execute( "create table parking(" + // Result Set�� �ǹ� ���� executeQuery ->execute
						"pId varchar(15) not null ,"+	// ������ ������ȣ  1
						"pName varchar(50) not null," +	// �������  2
						"pCartegory	varchar(10)," +		// ������ ���� 3
						"pType	varchar(10)," +			// ������ ���� 4 
						"pAdd1	varchar(100)," +			// �����������ּ� 5
						"pAdd2 varchar(100),"+	// ���������θ��ּ� 6
						"pNum int,"		+		// ������ȹ�� 7
						"pMoney varchar(10),"+	// �������  17
						"pAdminName varchar(50),"	+// ��������� 27
						"pAdminTel varchar(20),"+	// ������� ����ó 28
						"plat decimal(10, 5),"+	// ���� 32
						"plng decimal(10, 5),"+
						"CONSTRAINT PK_park primary key(pId, pName, pAdd1)) "+ 
						"DEFAULT CHARSET=utf8;");	// �浵 33
						
		stmt.close();
		conn.close();
	}
}
