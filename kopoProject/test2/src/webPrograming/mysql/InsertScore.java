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
	static ArrayList<OneRec> ArrayOneRec = new ArrayList<>();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();

		// ���� Ŭ������ �̿��ؼ� ���پ� ������ ������ String ����
		String QueryTxt;
		int iPerson = 1000;

		// �� ���� ���� �о�� �ʵ���� �� �� �ִ�.

		// �ݺ� Ƚ���� �˱����� int ����
		int LineCnt = 1;
		int eCnt=0;

		// ������ ������� ������ �����ͼ� �ݺ�ó��
		while (LineCnt<= iPerson) {
			// ��(\t)�� �����ڷ� ���ۿ��� ������ ������ ��(readtxt)�� field �迭�� ������ �������ش�
			try{
				String name = String.format("ȫ��%02d", LineCnt);
				int kor = (int)(Math.random()*100);	//�������� �����
				int eng = (int)(Math.random()*100);	//�������� �����
				int mat = (int)(Math.random()*100);	//�������� �����
				
				QueryTxt = String.format("insert into score(sId,sName,kor,eng,mat)"+
																	" values("
																	+ "%02d,'%s',%d,%d,%d);",
																	LineCnt, name, kor, eng, mat
																);
				stmt.execute(QueryTxt);
				System.out.printf("%d���� �׸� Insert OK [%s]\n", LineCnt,QueryTxt );
			}catch(Exception e){
				e.printStackTrace();
				eCnt++;
			}
			// �ѹ� ����ɶ����� �ݺ�Ƚ�� ����
			LineCnt++;
		}
		System.out.printf("���� Data �� ���� : %d\n", eCnt);
		
		stmt.close();
		conn.close();
	}
}
