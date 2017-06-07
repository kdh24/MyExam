package webPrograming.mysql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InsertStock {

	// Error �߻��� �޼��� ������ ���� Class ����(���� �޼���, �����߻� ���� ���� ����)
	public static class ErrorCheck{
		static String eMessage;
		static int eCount;
		// ���� �޼����� �����ͼ� �ʱ�ȭ���ִ� ������ �κ�
		ErrorCheck(String eMessage, int eCount){
			this.eMessage= eMessage;
			this.eCount= eCount;
		}
	}

	// ���θ޼ҵ� ����κ� ����ó���� throws�� �̿��� java�� ó���ϰ� �������
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// ����̹� �̸��� �����ϴ� Ŭ������ �޸𸮿� �ε��Ѵ�
		Class.forName("com.mysql.jdbc.Driver");
		// ���̵�� �н����� �� ���� ������ �̿��ؼ� Mysql DB�� �������ش�
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL���� ó���ϱ� ���� PreparedStatement ��ü�� ����
		PreparedStatement psmt = null;
		// �ڵ� commit ��� ���� 
		conn.setAutoCommit(false);
		// \�� Ư�������̹Ƿ� \\ �� ���� ����Ѵ�
		File f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
		// ������ ���� ���� ���� Ŭ���� ���� �� ����
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		ArrayList<ErrorCheck> alError = new ArrayList<>();

		// ���� Ŭ������ �̿��ؼ� ���پ� ������ ������ String ����
		String readtxt;
		String QueryTxt;
		String sqlStr;
		// ���� �����͸� DB�� �����ϱ� ���� sql���� String ������ ����
		sqlStr = "insert into stock(st_code,sDay,sItemCode,endMoney,sMoney,topMoney, "
				+ "lowMoney,tradeNum,tradeMoney) values("
				+ "?,?,?,?,?,"
				+ "?,?,?,?);";
		// ���� �����͸� DB�� �����ϱ� ���� sql���� PreparedStatement ��ü�� ����Ų��
		psmt = conn.prepareStatement(sqlStr);
		// �� ���� ���� �о�� �ʵ���� �� �� �ִ�.
		// ���Ͽ��� �о�� ���� ���� ��� �� �����̶�� �˷��ְ� ����
		if ((readtxt = br.readLine()) == null) {
			System.out.printf("�� �����Դϴ�.\n");
			return;
		}
		// �ݺ� Ƚ���� �˱����� int ����
		int LineCnt = 1;
		// ���� �ݺ� Ƚ�� üũ
		int eCnt=0;

		// ������ ������� ������ �����ͼ� �ݺ�ó��
		while ((readtxt = br.readLine()) != null ) {
			// ��(\t)�� �����ڷ� ���ۿ��� ������ ������ ��(readtxt)�� field �迭�� ������ �������ش�
			try{ // ����ó���� ���� try - catch ��
				// ���Ͽ��� ������ readtxt ���ڿ���  "%_%" �����ڷ� ������ field �迭�� �����´�
				String[] field = readtxt.split("%_%");
				// field ���̸�ŭ �ݺ�ó��
				for(int i=0; i<field.length; i++){
					// field �迭������ ^ ���ڸ� �����ְ� ���鵵 �������ش�
					field[i] = field[i].replace("^", "").trim();
					//field �迭���� ������ "0" ���� �־��ش�
					if(field[i].equals(""))
						field[i] = "0";
				}
				// �ʵ� ���̰� 2�� �̻��϶��� ������ insrt ���ش�
				if(field.length>2 ){
					psmt.setString(1, field[0]); // ǥ�� �����ڵ� ����
					psmt.setString(2, field[1]); // ���� ����
					psmt.setString(3, field[2]); // ���� �����ڵ�
					psmt.setString(4, field[3]); // ����
					psmt.setString(5, field[4]); // �ð�
					psmt.setString(6, field[5]); // �ְ�
					psmt.setString(7, field[6]); // ������
					psmt.setString(8, field[11]); // ���� �ŷ���
					psmt.setString(9, field[12]); // ���� �ŷ����
					
					psmt.addBatch(); // Batch ó���� ���� Batch�� ���������ش�

					// ���μ� ������ ���� ����
					if(LineCnt % 10000 == 0){
						// �׾Ƴ��� Batch�� DB�� ������ ó��
						psmt.executeBatch();
						// Batch ������ ����ش�
						psmt.clearBatch();
						// ������ commit �Ѵ�
						conn.commit();
					}
					// ����� PreparedStatement ��ü�� ���������ش�
					psmt.clearParameters();
					// ����� ������ Ȯ�κκ� ���� ó���� ���� �ּ�ó��
//					System.out.printf("%d���� �׸� Insert OK [%s %s %s]\n", LineCnt, field[0], field[1], field[2]);
					// �ݺ�Ƚ�� ����
					LineCnt++;
				}
			}catch(Exception e){
				e.getMessage();  // ���� �޽��� ���
				// ���� �޼����� ErrorCheck ArrayList�� �߰������ش�
				alError.add(new ErrorCheck(e.getMessage(), LineCnt));
				// ���� Ƚ�� ����
				eCnt++;
			}
			// �ѹ� ����ɶ����� �ݺ�Ƚ�� ����
		}
		// �����ִ� Batch �� ó��
		psmt.executeBatch();
		// Batch�� ���� ���� commit
		conn.commit();
		// ����� PreparedStatement ��ü�� ���������ش�
		psmt.clearParameters();
		// ���� ���̸�ŭ �ݺ�����
		for(int i=0; i<alError.size(); i++){
			//���� ���μ��� �����޼����� ȭ�鿡 ���
			System.out.printf("���� ���� �� : %d - ���� �޼��� : %s \n ",
					alError.get(i).eCount, alError.get(i).eMessage );
		}
		// ���� �������� �� ������ ȭ�鿡 ���
		System.out.printf("���� Data �� ���� : %d\n", eCnt);

		// PreparedStatement ��ü ����	
		psmt.close();
		// Connection ��ü ����
		conn.close();
	}
}
