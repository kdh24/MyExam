package webPrograming.mysql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InsertPark {
	
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
		// ����̹� �̸��� �����ϴ� Ŭ������ �޸𸮿� �������� �ε�
		Class.forName("com.mysql.jdbc.Driver");
		// ���̵�� �н�����, ���� ������ �̿��ؼ� Mysql DB�� �������ش�
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL���� ó���ϱ� ���� Statement ��ü�� ����
		Statement stmt = conn.createStatement();

		// \�� Ư�������̹Ƿ� \\ �� ���� ����Ѵ�
		// ���� ������ ǥ�ص�����.txt ������ �о�´�
		File f = new File("C:\\test\\����������ǥ�ص�����.txt");
		// ������ �б� ���� ���� Ŭ���� ���� �� ����
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		// ErrorCheck Ŭ���� ����� ���� ArrayList ���� �� ����
		ArrayList<ErrorCheck> alError = new ArrayList<>();

		// ���� Ŭ������ �̿��ؼ� ���پ� ������ ������ String ����
		String readtxt;
		// Sql���� ������ String ����
		String QueryTxt;

		// �� ���� ���� �о�� �ʵ���� �� �� �ִ�.
		// ���Ͽ��� �о�� ���� ���� ��� �� �����̶�� �˷��ְ� ����
		if ((readtxt = br.readLine()) == null) {
			System.out.printf("�� �����Դϴ�.\n");
			return;
		}
		// �� ������ �ƴҶ� ó������ ������ ���� �׸��� ����κ��̹Ƿ� field_name �迭�� ������ ����
		String[] field_name = readtxt.split("\t");

		// �ݺ� Ƚ���� �˱����� int ����
		int LineCnt = 1;
		// ���� �߻� Ƚ���� üũ�ϱ� ���� int�� ����
		int eCnt=1;

		// ������ ������� ������ �����ͼ� �ݺ�ó��
		while ((readtxt = br.readLine()) != null) {
			try{
				// ��(\t)�� �����ڷ� ���ۿ��� ������ ������ ��(readtxt)�� field �迭�� ������ �������ش�
				String[] field = readtxt.split("\t");
				// ������ �ش��ϴ� field[31]�� ���� 120�� ������ �浵�� �ٲ� ���̱� ������ ���� �ٲ��ش� 
				if(Double.parseDouble(field[31]) > 120){
					String temp=null;
					temp = field[31].trim();
					field[31] = field[32].trim();
					field[32] = temp;
				}// �浵�κ��� 40���� ������ �߸��� ������ �Ǵ��ؼ� 100�� �����ش�
				if(Double.parseDouble(field[32]) < 40.0)
					field[32] = String.valueOf(Double.parseDouble(field[32]) + 100.0);
				
				// QueryTxt������ ���̺� insert ���ֱ� ���� sql���� �ۼ��ϰ� ������ �÷��� ���� ���� ���� �ش��ϴ� field ������ �־��༭ �������ش�
				QueryTxt = String.format("insert into parking(pId,pName,pCartegory,pType,pAdd1,"
										+ "pAdd2,pNum,pMoney, pAdminName, pAdminTel,"
										+ "plat,plng) values("
										+ "'%s','%s','%s','%s','%s',"
										+ "'%s',%d,'%s','%s','%s',"
										+ "%f,%f);",
										// ������ �ڷ����� ���缭 �ش��ϴ� �ʵ��� ������ �����ؼ� �־��ش� 
										field[0],field[1],field[2],field[3],field[4] == null? "":field[4].trim(),
										field[5],Integer.parseInt(field[6]),field[16],field[26],field[27],
										// ������ �ش��ϴ� �κ��� field[31] �̰� field ���̰� 31���� ũ�� �ʴٸ� null ������ ó���Ѵ�
										field.length > 31 ? Double.parseDouble(field[31]) : null,
												// �浵�� �ش��ϴ� �κ��� field[32] �̰� field ���̰� 32���� ũ�� �ʴٸ� null ������ ó���Ѵ�
												field.length > 32 ? Double.parseDouble(field[32]) : null);

				// QueryTxt ���� �ȿ� �ִ�  sql������ DB�� ������ ���̺� ���� �־��ش�.
				stmt.execute(QueryTxt);
				// ���ܰ� �߻����� �ʰ� ���������� ����Ǿ��� �� ���° ���ΰ� ���� ���� ����ó�� �Ǿ����� ������ش�
				System.out.printf("%d���� �׸� Insert OK [%s]\n", LineCnt,QueryTxt );
			}catch(Exception e){ // ���� �߻��� ó���κ�
				// ���� �߻��� �����޼��� ����ؼ� Ȯ�� - ��������� �ʴ´�
//				System.out.println(e.getMessage());
				// ���� �޼��� ó���� ���� ArrayList alError�� ���� �޼����� ���� �߻��� ���μ��� ���� �������ش�
				alError.add(new ErrorCheck(e.getMessage(), LineCnt));

				// ���� �߻� ���μ� ����
				eCnt++;
			}
			// �ѹ� ����ɶ����� �ݺ�Ƚ�� ����
			LineCnt++;
		}
		
		// ���� �߻� ũ�⸸ŭ �ݺ�ó�����ִ� for �ݺ���
		for(int i=0; i<alError.size(); i++){
			// ������ �߻��� ���μ��� �ش��ϴ� ���� �߻� �޼�����  ȭ�鿡 ������ش�
			System.out.printf("���� ���� �� : %d - ���� �޼��� : %s \n ",
					alError.get(i).eCount, alError.get(i).eMessage );
		}
		// ���� �߻� ������ �� ���� Ȯ��
		System.out.printf("���� Data �� ���� : %d\n", eCnt);
		
		// Statement ��ü ����
		stmt.close();
		// Connection ��ü ����
		conn.close();
	}
}
