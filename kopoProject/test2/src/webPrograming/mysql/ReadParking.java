package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReadParking {
	// ���θ޼ҵ� ����κ� ����ó���� throws�� �̿��� java�� ó���ϰ� �������
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ����̹� �̸��� �����ϴ� Ŭ������ �޸𸮿� �ε��Ѵ�
		Class.forName("com.mysql.jdbc.Driver");
		// ���̵�� �н�����, ���� ������ �̿��ؼ� Mysql DB�� �������ش�
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL���� ó���ϱ� ���� Statement ��ü�� ����
		Statement stmt = conn.createStatement();
		
		// ������ �Ǵ� ����� ����, �浵
		double lat=37.3860521; double lng=127.1214038;
		// QueryTxt ������ ����Ÿ�, �ִܰŸ� ���ϴ� sql���� �������ش�
		String QueryTxt;
//		// ���� �� ��� ���ϱ�
		QueryTxt = String.format("select * from parking where " +
		"SQRT(POWER( plat-%f,2) + POWER( plng-%f,2) ) = " +
		"(select MAX(SQRT(POWER(plat-%f,2) + POWER(plng-%f,2))) from parking);",
		lat, lng, lat, lng);
//		// ���� ����� ��� ���ϱ�
//		QueryTxt = String.format("select * from parking where " +
//				"SQRT(POWER( plat-%f,2) + POWER( plng-%f,2) ) = " +
//				"(select MIN(SQRT(POWER(plat-%f,2) + POWER(plng-%f,2))) from parking);",
//				lat, lng, lat, lng);
		// DB�� sql���� ������ ������� ResultSet ������ �޾ƿ´�
		ResultSet rset = stmt.executeQuery(QueryTxt);
		// ������ �����͸� ����ϱ� ���� �ش��ϴ� ��ġ�� ������ ���
		System.out.printf("  ������ȣ      �������                ��  ��           ����       �浵 \n");
		// rset ��ü�� ������ �ݺ�
		while(rset.next()){
			// DB���� ��ȸ�� ������ ������ ���������� ȭ�鿡 ������ش�
			System.out.printf("%4s %6s %5s %6s %4s\n",
					rset.getString(1), rset.getString(2), rset.getString(5), rset.getString(11),
					rset.getString(12));
		}
		// ResultSet ��ü ����
		rset.close();
		// Statement ��ü ����
		stmt.close();
		// Connection ��ü ����
		conn.close();
	}
}
