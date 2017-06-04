package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	// ���θ޼ҵ� ����κ� ����ó���� throws�� �̿��� java�� ó���ϰ� �������
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ����̹� �̸��� �����ϴ� Ŭ������ �޸𸮿� �������� �ε�
		Class.forName("com.mysql.jdbc.Driver");
		// ���̵�� �н�����, ���� ������ �̿��ؼ� Mysql DB�� �������ش�
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24", "root", "ehdgus24");
		// SQL���� ó���ϱ� ���� Statement ��ü�� ����
		Statement stmt = conn.createStatement();
		// Statement ��ü�� �̿��ؼ� show databases ��� sql���� ó���ϰ� ResultSet ��ü�� ����� �޾ƿ´�
		ResultSet rset = stmt.executeQuery("show databases;");
		
		// ResultSet ��ü�� ���� �ִٸ� ��� �ݺ��ؼ� ����
		while(rset.next()){
			// ResultSet ��ü�� �޾ƿ� ù��° ���� ȭ�鿡 ������ش�.
			System.out.println("�� : " + rset.getString(1));
		}
		//ResultSet ��ü �ڿ���ȯ
		rset.close();
		// Statement ��ü �ڿ���ȯ
		stmt.close();
		// Connection ��ü �ڿ���ȯ
		conn.close();
	}
}
