package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReadStock {
	// ���θ޼ҵ� ����κ� ����ó���� throws�� �̿��� java�� ó���ϰ� �������
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ����̹� �̸��� �����ϴ� Ŭ������ �޸𸮿� �ε��Ѵ�
		Class.forName("com.mysql.jdbc.Driver");
		// ���̵�� �н�����, ���� ������ �̿��ؼ� Mysql DB�� �������ش�
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL���� ó���ϱ� ���� Statement ��ü�� ����
		Statement stmt = conn.createStatement();
		PreparedStatement psmt = null;
		
		// QueryTxt ������ ����Ÿ�, �ִܰŸ� ���ϴ� sql���� �������ش�
		String QueryTxt;
//		// Ư�� ���� ��ȸ�ϱ�
		QueryTxt = "select * from stock where " +
				"sDay = ?;";
////		// �Ｚ �ֽ� ��ȸ�ϱ�
//		QueryTxt = "select * from stock where " +
//				"sItemCode = ?;";
		// DB�� sql���� ������ ������� ResultSet ������ �޾ƿ´�
//		ResultSet rset = stmt.executeQuery(QueryTxt);
		psmt = conn.prepareStatement(QueryTxt);
		
//		psmt.setString(1, "A005930");
		psmt.setString(1, "20070302");
		
		ResultSet rset = psmt.executeQuery();
		// ������ �����͸� ����ϱ� ���� �ش��ϴ� ��ġ�� ������ ���
		System.out.printf("  �����ڵ�      ����                ��ǰ�ڵ�          ����       �浵 \n");
		// rset ��ü�� ������ �ݺ�
		while(rset.next()){
			// DB���� ��ȸ�� ������ ������ ���������� ȭ�鿡 ������ش�
			System.out.printf("%4s %6s %5s %6s %4s\n",
					rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(7),
					rset.getString(6));
		}
		// ResultSet ��ü ����
		rset.close();
		// Statement ��ü ����
		stmt.close();
		// Connection ��ü ����
		conn.close();
	}
}
