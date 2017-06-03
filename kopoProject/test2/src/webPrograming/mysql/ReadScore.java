package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReadScore {
	public static String HanBlackBackword(String Han, int num){
		// �ѱ� ���麯��
		String k07_HanBlack="";
		// �ѱ۸Ű������� ���� ����Ʈ ���̸� ��ü ���̿��� ���� �װ��� �ִ밪���� ���ϴ� ����		
		int max= num -Han.getBytes().length;
		
		if(Han.getBytes().length > num ){
			if(Han.getBytes().length % 2 == 1)
				k07_HanBlack = new String(Han.getBytes(), 0, num-1) + " ";
			else 
				k07_HanBlack = new String(Han.getBytes(), 0, num);
		}else
		{
//			k07_HanBlack = new String(k07_Han.getBytes(), 0, 20);
			
			// �ѱ� ����ó�������� �̸� �Ѱܹ��� �ѱ۰��� �־��ش�
			k07_HanBlack += Han;
			// max ������ ����ŭ ������ �߰��� �����ش�
			for (int i = 0; i < max; i++) {
				k07_HanBlack += " ";
			}
		}
		// �ѱ۰� ������ ���� k07_HanBlack ������ ���ϰ����� �����ش�.
		return k07_HanBlack;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat df = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();
		PreparedStatement psmt1 = null;
		PreparedStatement psmt2 = null;
		PreparedStatement psmt3 = null;
		
		String QueryTxt;
		String sqlStr;
		int PageCnt = 1;
		int pageNum = 30;
		int dataStart = 1;
		int dataEnd = pageNum;
		int maxPage = 0;
		int maxNum = 0;
		
//		// ���� ����� ��� ���ϱ�
		QueryTxt = "select count(*) from score;";
		
		ResultSet rset = stmt.executeQuery(QueryTxt);
		while(rset.next()){
			maxNum = rset.getInt(1);
		}
//		maxNum = 100;
		if(maxNum % pageNum == 0){
			maxPage = maxNum / pageNum;
		}else{
			maxPage = maxNum / pageNum + 1;
		}
		// ���κ� ���� ��� ���ϱ�
		sqlStr = "select sId, sName, kor, eng, mat, sum(kor+eng+mat) as sum, sum(kor+eng+mat)/3 from (" 
				+ "select * "
				+ "from score where sId >= ? && sId <= ?) as pageScore "
				+ " group by sId order by sId;";
		psmt1 = conn.prepareStatement(sqlStr);
		
		// ���� ������ ���� ��� ���ϱ�
		sqlStr = "select sum(k), sum(e), sum(m), sum(k+e+m), sum(k+e+m)/3, "
				+ "avg(k), avg(e), avg(m), avg(k)+avg(e)+avg(m), (avg(k)+avg(e)+avg(m))/3 from ("
				 + "select sId, kor k, eng e, mat m "
				 + "from score where sId >= ? && sId <= ?) as pageScore"
				 + " order by sId;";
		psmt2 = conn.prepareStatement(sqlStr);
		
		// ���� ������ ���� ��� ���ϱ�
		sqlStr = "select sum(k), sum(e), sum(m), sum(k+e+m), sum(k+e+m)/3, "
				+ "avg(k), avg(e), avg(m), avg(k)+avg(e)+avg(m), (avg(k)+avg(e)+avg(m))/3 from ("
				+ "select sId, kor k, eng e, mat m "
				+ "from score where sId <= ?) as pageScore "
				+ " order by sId;";
		psmt3 = conn.prepareStatement(sqlStr);

		
		while(PageCnt <= maxPage){
			// �������� ���� �������� ���� ���� ������, �� ������ ���� 
			psmt1.setInt(1, dataStart);
			psmt1.setInt(2, dataEnd);
			// �������� �հ�, ����� �������� ���� ���� ������, �� ������ ���� 
			psmt2.setInt(1, dataStart);
			psmt2.setInt(2, dataEnd);
			// ���� �հ�, ����� �������� ���� ���� ������, �� ������ ���� 
			psmt3.setInt(1, dataEnd);
		
			System.out.printf("���� ������ : %d  ", PageCnt);
			System.out.printf("������� : %s\n", df.format(cal.getTime()));
			System.out.printf("================================================\n");
			System.out.printf("%-5.5s%-5.5s %3.3s %3.3s %3.3s %4.4s %5.5s\n",
								"�й�", "�̸�", "����", "����", "����", "����", "���");
			System.out.printf("================================================\n");
			rset = psmt1.executeQuery();
			while(rset.next()){
				System.out.printf("%04d  %s %2.2s %5.5s %5.5s %7.7s %6.6s\n", //rset.getInt(1) +
						Integer.parseInt(rset.getString(1)), HanBlackBackword(rset.getString(2), 10),
						rset.getString(3), rset.getString(4), rset.getInt(5), rset.getInt(6), rset.getInt(7));
			}
			rset = psmt2.executeQuery();
			while(rset.next()){
				System.out.printf("================================================\n");
				System.out.println("����������");
				System.out.printf("�հ�  %13d %5d %5d %7d %6d\n",
						rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
				System.out.printf("���  %13d %5d %5d %7d %6d\n",
						rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getInt(9), rset.getInt(10));
			}
			rset = psmt3.executeQuery();
			while(rset.next()){
				System.out.printf("================================================\n");
				System.out.println("����������");
				System.out.printf("�հ�  %13d %5d %5d %7d %6d\n",
						rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
				System.out.printf("���  %13d %5d %5d %7d %6d\n",
						rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getInt(9), rset.getInt(10));
			}
			System.out.println();
					
			PageCnt ++;
			dataStart = dataEnd+1;
			dataEnd = PageCnt * pageNum ;
			if(dataEnd > maxNum)
				dataEnd = maxNum;
		}
		rset.close();
		psmt1.close();
		psmt2.close();
		psmt3.close();
		stmt.close();
		conn.close();
		
	}
}
