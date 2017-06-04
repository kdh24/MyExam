package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReadTable {
	// ���θ޼ҵ� ����κ� ����ó���� throws�� �̿��� java�� ó���ϰ� �������
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ����̹� �̸��� �����ϴ� Ŭ������ �޸𸮿� �ε��Ѵ�
		Class.forName("com.mysql.jdbc.Driver");
		// ���̵�� �н�����, ���� ������ �̿��ؼ� Mysql DB�� �������ش�
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL���� ó���ϱ� ���� Statement ��ü�� ����
		Statement stmt = conn.createStatement();
		// DB���� �ڷḦ ��ȸ�ϴ� select ���� Statement ��ü�� DB�� ������ ResultSet ��ü�� ����� �޾ƿ´�
		ResultSet rset = stmt.executeQuery("select * from examtable;");
		// �̸� �й� ���� ���� ������ ���ڿ� ���� �״�� ȭ�鿡 ������ش�
		System.out.printf("  �̸�  �й�  ����  ����  ���� \n");
		// ResultSet ��ü rset�� ���� ������ �ݺ�ó��
		while(rset.next()){
			// ���� ���� ���� ���� ���߾� 1~5°���� ������ �����͸� ������� ȭ�鿡 ������ش�
			System.out.printf("%4s %6d %3d %3d %3d \n",
					rset.getString(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
		}
		//ResultSet ��ü ����
		rset.close();
		// Statement ��ü ����
		stmt.close();
		// Connection ��ü ����
		conn.close();
	}
}
