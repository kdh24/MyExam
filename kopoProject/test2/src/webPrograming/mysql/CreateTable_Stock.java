package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable_Stock {
	// ���θ޼ҵ� ����κ� ����ó���� throws�� �̿��� java�� ó���ϰ� �������
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ����̹� �̸��� �����ϴ� Ŭ������ �޸𸮿� �ε��Ѵ�
		Class.forName("com.mysql.jdbc.Driver");
		// ���̵�� �н����� �� ���� ������ �̿��ؼ� Mysql DB�� �������ش�
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL���� ó���ϱ� ���� Statement ��ü�� ����
		Statement stmt = conn.createStatement();
		// ""���� sql���� DB�� ������ stock ���̺� ���� 
		stmt.execute( "create table stock(" + 
						"st_code varchar(20) not null ,"+	// �����ڵ�
						"sDay date not null," +			// ����
						"sItemCode varchar(20) not null," +	// ����
						"endMoney	int(15)," +				// ����
						"sMoney		int(15)," +				// �ð�
						"topMoney	int(15)," +				// �� 
						"lowMoney	int(15)," +				// ����
						"tradeNum	int(15)," +				// �ŷ���
						"tradeMoney	bigint," +				// �ŷ����
						// primary key ������ ���� �������� (3���� �÷��� �̿��� ����Ű ����)
						"CONSTRAINT PK_stock_code_Day primary key(st_code, sDay, sItemCode)) "+ 
						// �⺻ CHARSET�� utf8�� �������ش�
						"DEFAULT CHARSET=utf8;");	

		// Statement ��ü ����	
		stmt.close();
		// Connection ��ü ����
		conn.close();
	}
}
