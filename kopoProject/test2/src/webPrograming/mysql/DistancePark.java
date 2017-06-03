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

public class DistancePark {
	
	public static class ErrorCheck{
		static String eMessage;
		static int eCount;
//		String eName;
		
		ErrorCheck(String eMessage, int eCount){
			this.eMessage= eMessage;
			this.eCount= eCount;
//			this.eName= eName;
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
		// �ִ� �Ÿ� �ּҰŸ� ����
		double distMax=0.0;
		double distMin=0.0;
		double dist=0.0;
		String[] MaxInfo = new String[3];
		String[] MinInfo = new String[3];

		// �ݺ� Ƚ���� �˱����� int ����
		int LineCnt = 1;
		int eCnt=0;

		// ������ ������� ������ �����ͼ� �ݺ�ó��
		while ((readtxt = br.readLine()) != null) {
			// ��(\t)�� �����ڷ� ���ۿ��� ������ ������ ��(readtxt)�� field �迭�� ������ �������ش�
			try{
				String[] field = readtxt.split("\t");
					
				QueryTxt = String.format("insert into parking(pId,pName,pCartegory,pType,pAdd1,"
															+ "pAdd2,pNum,pMoney, pAdminName, pAdminTel,"
															+ "plat,plng) values("
																	+ "'%s','%s','%s','%s','%s',"
																	+ "'%s',%d,'%s','%s','%s',"
																	+ "%f,%f);",
																	field[0],field[1],field[2],field[3],field[4] == null? "":field[4].trim(),
																	field[5],Integer.parseInt(field[6]),field[16],field[26],field[27],
																	field.length > 31 ? Double.parseDouble(field[31]) : 0.0, field.length > 32 ? Double.parseDouble(field[32]) : 0.0);
				stmt.execute(QueryTxt);
				System.out.printf("%d���� �׸� Insert OK [%s]\n", LineCnt,QueryTxt );
				if(field.length > 31 || !(field[31].trim().equals("") || field[31].trim().equals(""))){
					dist = Math.sqrt(Math.pow(Double.parseDouble(field[31]) - k07_lat, 2)
							+ Math.pow(Double.parseDouble(field[32]) - k07_lng, 2));
					if(LineCnt == 1){
						distMax = dist;
						distMin = dist;
					}else{
						if(distMax < dist){
							distMax = dist;
							MaxInfo[0] = field[0];
							MaxInfo[1] = field[1];
							MaxInfo[2] = field[4];
						}
						if(distMin > dist){
							distMin = dist;
							MinInfo[0] = field[0];
							MinInfo[1] = field[1];
							MinInfo[2] = field[4];
						}
					}
				}
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
		
//		for(int i=0; i<alError.size(); i++){
//			System.out.printf("���� ���� �� : %d - ���� �޼��� : %s \n ", alError.get(i).eCount, alError.get(i).eMessage );
//		}
		System.out.printf("���� Data �� ���� : %d\n", eCnt);
		
		System.out.println("���� ����� �Ÿ� : " + distMin);
		System.out.printf("���� ����� ������  ������ȣ : %s  \n ������� : %s  \n �������ּ� : %s \n", MinInfo[0], MinInfo[1], MinInfo[2]);
		System.out.println("���� �� �Ÿ� : " + distMax);
		System.out.printf("���� ����� ������  ������ȣ : %s  \n ������� : %s  \n �������ּ� : %s \n", MaxInfo[0], MaxInfo[1], MaxInfo[2]);
		
		stmt.close();
		conn.close();
	}
}
