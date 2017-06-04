package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class InsertTable {
	// ���θ޼ҵ� ����κ� ����ó���� throws�� �̿��� java�� ó���ϰ� �������
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ����̹� �̸��� �����ϴ� Ŭ������ �޸𸮿� �ε��Ѵ�
		Class.forName("com.mysql.jdbc.Driver");
		// ���̵�� �н�����, ���� ������ �̿��ؼ� Mysql DB�� �������ش�
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL���� ó���ϱ� ���� Statement ��ü�� ����
		Statement stmt = conn.createStatement();
		
		// ������ ���� �����ϴ� sql���� ""�� ���� Statement��ü�� �̿��ؼ� DB�� ���� ���� examtable�� �־��ش�
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('ȿ��',209901,95,100,95);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('����',209902,95,95,95);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('����',209903,100,100,100);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('����',209904,100,95,90);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('�ҿ�',209905,80,100,70);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('ť��',209906,100,100,70);");
		stmt.execute( "insert into examtable (name, studentid, kor, eng, mat) values ('ȭ��',209907,70,70,70);");

		// Statement ��ü ����
		stmt.close();
		// Connection ��ü ����
		conn.close();
	}
}
