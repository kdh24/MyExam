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
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();
		PreparedStatement psmt = null;

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
		sqlStr = "insert into stock(st_code,sDay,sItemCode,endMoney,sMoney,topMoney, "
				+ "lowMoney,tradeNum,tradeMoney) values("
				+ "?,?,?,?,?,"
				+ "?,?,?,?);";
		
		psmt = conn.prepareStatement(sqlStr);
		// �� ���� ���� �о�� �ʵ���� �� �� �ִ�.
		// ���Ͽ��� �о�� ���� ���� ��� �� �����̶�� �˷��ش�
		if ((readtxt = br.readLine()) == null) {
			System.out.printf("�� �����Դϴ�.\n");
			return;
		}
		// �� ������ �ƴҶ� ó������ ������ ���� �׸��� ����κ��̹Ƿ� field_name �迭�� ������ ����
		// �ݺ� Ƚ���� �˱����� int ����
		int LineCnt = 1;
		int eCnt=0;

		// ������ ������� ������ �����ͼ� �ݺ�ó��
		while ((readtxt = br.readLine()) != null ) {
			// ��(\t)�� �����ڷ� ���ۿ��� ������ ������ ��(readtxt)�� field �迭�� ������ �������ش�
			try{
				String[] field = readtxt.split("%_%");
				for(int i=0; i<field.length; i++){
					field[i] = field[i].replace("^", "").trim();
					if(field[i].equals(""))
						field[i] = "0";
//					System.out.println(field[i]);
				}
				if(field.length>2 ){
					psmt.setString(1, field[0]);
					psmt.setString(2, field[1]);
					psmt.setString(3, field[2]);
					psmt.setString(4, field[3]);
					psmt.setString(5, field[4]);
					psmt.setString(6, field[5]);
					psmt.setString(7, field[6]);
					psmt.setString(8, field[11]);
					psmt.setString(9, field[12]);
					
					psmt.addBatch();
//					psmt.execute();
					if(LineCnt % 10000 == 0){
						psmt.executeBatch();
						psmt.clearBatch();
						conn.commit();
					}
					psmt.clearParameters();
//					System.out.printf("%d���� �׸� Insert OK [%s %s %s]\n", LineCnt, field[0], field[1], field[2]);

					LineCnt++;
				}
			}catch(Exception e){
				e.getMessage();
				alError.add(new ErrorCheck(e.getMessage(), LineCnt));
				eCnt++;
			}
			// �ѹ� ����ɶ����� �ݺ�Ƚ�� ����
		}
		psmt.executeBatch();
		conn.commit();
		psmt.clearParameters();
		for(int i=0; i<alError.size(); i++){
			System.out.printf("���� ���� �� : %d - ���� �޼��� : %s \n ",
					alError.get(i).eCount, alError.get(i).eMessage );
		}
		System.out.printf("���� Data �� ���� : %d\n", eCnt);
		
		psmt.close();
		conn.close();
	}
}
