package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable {
	// ���θ޼ҵ� ����κ� ����ó���� throws�� �̿��� java�� ó���ϰ� �������
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ����̹� �̸��� �����ϴ� Ŭ������ �޸𸮿� �ε��Ѵ�
		Class.forName("com.mysql.jdbc.Driver");
		// ���̵�� �н�����, ���� ������ �̿��ؼ� Mysql DB�� �������ش�
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL���� ó���ϱ� ���� Statement ��ü�� ����
		Statement stmt = conn.createStatement();
		// ""�ȿ� �ִ�  sql������ DB�� ������ table�� �������ش�.
		stmt.execute( "create table examtable(" + // Result Set�� �ǹ� ���� executeQuery ->execute
						"name varchar(20),"+	// name �÷��� varchar �������� 20�� �Ҵ�
						"studentid int not null primary key," +	// studentid �÷��� null�� ������� �ʰ� primary key �����Ѵ�
						"kor	int," +			// kor �÷��� int������ ����
						"eng	int," +			// eng �÷��� int������ ����
						"mat	int)" +			// mat �÷��� int������ ����
						"DEFAULT CHARSET=utf8;");	// ���̺��� �⺻ charset�� utf8�� �����Ѵ�

		// Statement ��ü ����
		stmt.close();
		// Connection ��ü ����
		conn.close();
	}
}
