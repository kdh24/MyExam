package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteStock {
	// ���θ޼ҵ� ����κ� ����ó���� throws�� �̿��� java�� ó���ϰ� �������
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ����̹� �̸��� �����ϴ� Ŭ������ �޸𸮿� �ε��Ѵ�
		Class.forName("com.mysql.jdbc.Driver");
		// ���̵�� �н����� �� ���� ������ �̿��ؼ� Mysql DB�� �������ش�
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL���� ó���ϱ� ���� Statement ��ü�� ����
		Statement stmt = conn.createStatement();
		// ""�ȿ� �ִ�  sql������ DB�� ������ score table ������ �������ش�.
//		stmt.execute("delete from stock;");
		// ""�ȿ� �ִ�  sql������ DB�� ������ score table�� �������ش�.
		stmt.execute("drop table stock;");

		// Statement ��ü ����	
		stmt.close();
		// Connection ��ü ����
		conn.close();
	}
}
