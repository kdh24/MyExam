package webPrograming.mysql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import webPrograming.stringBuffer.OneRec;

public class InsertScore {
	// ���θ޼ҵ� ����κ� ����ó���� throws�� �̿��� java�� ó���ϰ� �������
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// ����̹� �̸��� �����ϴ� Ŭ������ �޸𸮿� �ε��Ѵ�
		Class.forName("com.mysql.jdbc.Driver");
		// ���̵�� �н�����, ���� ������ �̿��ؼ� Mysql DB�� �������ش�
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL���� ó���ϱ� ���� Statement ��ü�� ����
		Statement stmt = conn.createStatement();

		// ���� Ŭ������ �̿��ؼ� ���پ� ������ ������ String ����
		String QueryTxt;
		// ��ü �л��� ����
		int iPerson = 1000;

		// �ݺ� Ƚ���� �˱����� int ����
		int LineCnt = 1;
		// ���� Ƚ��
		int eCnt=0;

		// ������ ������� ������ �����ͼ� �ݺ�ó��
		while (LineCnt<= iPerson) {
			// ���� ó���� ���� try - catch ��
			try{
				// �̸��� ��ȣ�� �߰��� ����������  ����, ����, ���� ������ �����ϰ� �������ش�
				String name = String.format("ȫ��%02d", LineCnt);
				int kor = (int)(Math.random()*100);	//�������� �����
				int eng = (int)(Math.random()*100);	//�������� �����
				int mat = (int)(Math.random()*100);	//�������� �����
				
				// ������ �����͸� sql�� �ݿ��ϱ� ���� String ������ �����ϴ� �κ�
				QueryTxt = String.format("insert into score(sId,sName,kor,eng,mat)"+
															" values("
															+ "%02d,'%s',%d,%d,%d);",
															LineCnt, name, kor, eng, mat
															);
				// sql���� ������ DB���� ó���Ѵ�
				stmt.execute(QueryTxt);
				// ���ܾ��� ���� �۵��� ���
				System.out.printf("%d��° �׸� Insert OK [%s]\n", LineCnt,QueryTxt );
			}catch(Exception e){
				// ���ܰ� �߻��ϸ� ���� ������ ȭ�鿡 ���
				e.printStackTrace();
				// ���� Ƚ�� ����
				eCnt++;
			}
			// �ѹ� ����ɶ����� �ݺ�Ƚ�� ����
			LineCnt++;
		}
		// ���� �߻�Ƚ���� ȭ�鿡 ���
		System.out.printf("���� Data �� ���� : %d\n", eCnt);

		// Statement ��ü ����
		stmt.close();
		// Connection ��ü ����
		conn.close();
	}
}
