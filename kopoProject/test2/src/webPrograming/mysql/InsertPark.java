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
	
	public static class ErrorCheck{
		static String eMessage;
		static int eCount;
		
		ErrorCheck(String eMessage, int eCount){
			this.eMessage= eMessage;
			this.eCount= eCount;
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();

		// \�� Ư�������̹Ƿ� \\ �� ���� ����Ѵ�
		File f = new File("C:\\test\\����������ǥ�ص�����.txt");
		// ������ ���� ���� ���� Ŭ���� ���� �� ����
		BufferedReader br = new BufferedReader(new FileReader(f));
		

		ArrayList<ErrorCheck> alError = new ArrayList<>();

		// ���� Ŭ������ �̿��ؼ� ���پ� ������ ������ String ����
		String readtxt;
		String QueryTxt;

		// �� ���� ���� �о�� �ʵ���� �� �� �ִ�.
		// ���Ͽ��� �о�� ���� ���� ��� �� �����̶�� �˷��ش�
		if ((readtxt = br.readLine()) == null) {
			System.out.printf("�� �����Դϴ�.\n");
			return;
		}
		// �� ������ �ƴҶ� ó������ ������ ���� �׸��� ����κ��̹Ƿ� field_name �迭�� ������ ����
		String[] field_name = readtxt.split("\t");

		// ���ձ�� �츮�� �����浵, �������� �˾ƺ���
		double k07_lat = 37.3860521;
		double k07_lng = 127.1214038;

		// �ݺ� Ƚ���� �˱����� int ����
		int LineCnt = 1;
		int eCnt=1;

		// ������ ������� ������ �����ͼ� �ݺ�ó��
		while ((readtxt = br.readLine()) != null) {
			// ��(\t)�� �����ڷ� ���ۿ��� ������ ������ ��(readtxt)�� field �迭�� ������ �������ش�
			try{
				String[] field = readtxt.split("\t");
				
				if(Double.parseDouble(field[31]) > 120){
					String temp=null;
					temp = field[31].trim();
					field[31] = field[32].trim();
					field[32] = temp;
				}
				if(Double.parseDouble(field[32]) < 40.0)
					field[32] = String.valueOf(Double.parseDouble(field[32]) + 100.0);
				
				QueryTxt = String.format("insert into parking(pId,pName,pCartegory,pType,pAdd1,"
															+ "pAdd2,pNum,pMoney, pAdminName, pAdminTel,"
															+ "plat,plng) values("
																	+ "'%s','%s','%s','%s','%s',"
																	+ "'%s',%d,'%s','%s','%s',"
																	+ "%f,%f);",
																	field[0],field[1],field[2],field[3],field[4] == null? "":field[4].trim(),
																	field[5],Integer.parseInt(field[6]),field[16],field[26],field[27],
																	field.length > 31 ? Double.parseDouble(field[31]) : null, field.length > 32 ? Double.parseDouble(field[32]) : null);
				stmt.execute(QueryTxt);
				System.out.printf("%d���� �׸� Insert OK [%s]\n", LineCnt,QueryTxt );
			}catch(Exception e){
//				System.out.println(e.getMessage());
				
				alError.add(new ErrorCheck(e.getMessage(), LineCnt));
				if(e.getMessage().equals("empty String"))
					System.out.println(LineCnt + " " + readtxt);
//				alError.add(new ErrorCheck(e.getMessage(), LineCnt));
				eCnt++;
			}
			// �ѹ� ����ɶ����� �ݺ�Ƚ�� ����
			LineCnt++;
		}
		
		for(int i=0; i<alError.size(); i++){
			System.out.printf("���� ���� �� : %d - ���� �޼��� : %s \n ", alError.get(i).eCount, alError.get(i).eMessage );
			
		}
		System.out.printf("���� Data �� ���� : %d\n", eCnt);
		
		stmt.close();
		conn.close();
	}
}
