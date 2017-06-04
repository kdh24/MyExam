package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable_parking {
	// ���θ޼ҵ� ����κ� ����ó���� throws�� �̿��� java�� ó���ϰ� �������
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ����̹� �̸��� �����ϴ� Ŭ������ �޸𸮿� �ε��Ѵ�
		Class.forName("com.mysql.jdbc.Driver");
		// ���̵�� �н����� �� ���� ������ �̿��ؼ� Mysql DB�� �������ش�
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL���� ó���ϱ� ���� Statement ��ü�� ����
		Statement stmt = conn.createStatement();
		// ""�ȿ� �ִ�  sql������ DB�� ������ table�� �������ش�.
		stmt.execute( "create table parking(" + // Result Set�� �ǹ� ���� executeQuery ->execute
						"pId varchar(15) not null ,"+	// ������ ������ȣ  1
						"pName varchar(50) not null," +	// �������  2
						"pCartegory	varchar(10)," +		// ������ ���� 3
						"pType	varchar(10)," +			// ������ ���� 4 
						"pAdd1	varchar(100)," +		// �����������ּ� 5
						"pAdd2 varchar(100),"+		// ���������θ��ּ� 6
						"pNum int,"		+			// ������ȹ�� 7
						"pMoney varchar(10),"+		// �������  17
						"pAdminName varchar(50),"	+// ��������� 27
						"pAdminTel varchar(20),"+	// ������� ����ó 28
						"plat decimal(10, 5),"+		// ���� 32
						"plng decimal(10, 5),"+ 	// �浵 33
						// ���̺��� primary key ������ ���� ���������� PK_park ��� �̸����� ����(pId �� 3���� �÷� ����Ű)
						"CONSTRAINT PK_park primary key(pId, pName, pAdd1)) "+ 
						"DEFAULT CHARSET=utf8;");	// �⺻ charset�� utf8�� �������ش�

		// Statement ��ü ����	
		stmt.close();
		// Connection ��ü ����
		conn.close();
	}
}
