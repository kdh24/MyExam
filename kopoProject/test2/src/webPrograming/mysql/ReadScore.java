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
	// �ѱ� ����ó���� ���� Ŭ����
	public static String HanBlackBackword(String Han, int num){
		// �ѱ� ���麯��
		String k07_HanBlack="";
		// �ѱ۸Ű������� ���� ����Ʈ ���̸� ��ü ���̿��� ���� �װ��� �ִ밪���� ���ϴ� ����		
		int max= num -Han.getBytes().length;
		//�ѱ� ������ ����Ʈ�� ���� ����Ʈ���� ������ ����
		if(Han.getBytes().length > num ){
			// �ѱ� ����Ʈ�� 2�� ���������� 1�̸� �ѱ��� �������� �����Ƿ� �Ʒ��� ���� ó�����ش�
			if(Han.getBytes().length % 2 == 1)
				k07_HanBlack = new String(Han.getBytes(), 0, num-1) + " ";
			else 
				k07_HanBlack = new String(Han.getBytes(), 0, num);
		}else // �ѱۺ����� ���ϴ� ���� �����϶� ����
		{
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

	// ���θ޼ҵ� ����κ� ����ó���� throws�� �̿��� java�� ó���ϰ� �������
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat df = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");
		// ����̹� �̸��� �����ϴ� Ŭ������ �޸𸮿� �ε��Ѵ�
		Class.forName("com.mysql.jdbc.Driver");
		// ���̵�� �н����� �� ���� ������ �̿��ؼ� Mysql DB�� �������ش�
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL���� ó���ϱ� ���� Statement ��ü�� ����
		Statement stmt = conn.createStatement();
		// SQL���� ó���ϱ� ���� PreparedStatement ��ü�� ����
		PreparedStatement psmt1 = null;
		PreparedStatement psmt2 = null;
		PreparedStatement psmt3 = null;
		
		// sql�� ó���� ���� String ����
		String QueryTxt;
		String sqlStr;
		// ���������� ���� 
		int PageCnt = 1;
		// �������� ����ο� ����
		int pageNum = 30;
		// ���� ������ ����
		int dataStart = 1;
		// ���� ������ ����
		int dataEnd = pageNum;
		// �ִ� ������ ����
		int maxPage = 0;
		// �� ����� �ִ��� �����ϴ� ����
		int maxNum = 0;
		
//		// ���� ����� ��� ���ϱ�
		QueryTxt = "select count(*) from score;";
		// ��ü �� �ο��� ResultSet ����� �޾ƿ´�
		ResultSet rset = stmt.executeQuery(QueryTxt);
		// ������ ���� ������ ����
		while(rset.next()){
			// �ִ� �ο��� maxNum ������ �־��ش�
			maxNum = rset.getInt(1);
		}

		// �ִ� �ο� / �������� ����ο� == 0 �̸�  �ִ� �������� maxNum / pageNum ���� �ʱ�ȭ �ϰ� �ƴϸ� 1�� �����ش�
		if(maxNum % pageNum == 0){
			maxPage = maxNum / pageNum;
		}else{
			maxPage = maxNum / pageNum + 1;
		}
		// ���κ� ���� ��� ���ϱ�
		sqlStr = "select sId, sName, kor, eng, mat, sum(kor+eng+mat) as sum, sum(kor+eng+mat)/3 from (select @rnum:=@rnum +1 as no, a.* "
				+ "from (select * from score order by sId) a, (select @rnum:=0) b ) c where c.no >= ? and c.no <= ? "
				+ "group by sId;";
//		sqlStr = "select a.* from ("
//				+ "select @rownum := @rownum + 1 as rownum,"
//				+ "score.* from score,"
//				+ "(select @rownum := 0) R) a "
//				+ "group by sId where a.rownum >= ? and a.rownum <= ? ";
		
		// sql���� PreparedStatement ��ü�� ����Ų��
		psmt1 = conn.prepareStatement(sqlStr);
		
		// ���� ������ ���� ��� ���ϱ�
		sqlStr = "select sum(kor), sum(eng), sum(mat), sum(kor)+sum(eng)+sum(mat), sum(kor+eng+mat)/3, "
				+ "avg(kor), avg(eng), avg(mat), avg(kor)+avg(eng)+avg(mat), (avg(kor)+avg(eng)+avg(mat))/3 from (select @rnum:=@rnum +1 as no, a.* "
				+ "from (select * from score order by sId) a, (select @rnum:=0) b ) c where c.no >= ? and c.no <= ?;";
		// sql���� PreparedStatement ��ü�� ����Ų��
		psmt2 = conn.prepareStatement(sqlStr);
		
		// ���� ������ ���� ��� ���ϱ�
		sqlStr = "select sum(kor), sum(eng), sum(mat), sum(kor)+sum(eng)+sum(mat), sum(kor+eng+mat)/3, "
				+ "avg(kor), avg(eng), avg(mat), avg(kor)+avg(eng)+avg(mat), (avg(kor)+avg(eng)+avg(mat))/3 from (select @rnum:=@rnum +1 as no, a.* "
				+ "from (select * from score order by sId) a, (select @rnum:=0) b ) c where c.no <= ?";
		// sql���� PreparedStatement ��ü�� ����Ų��
		psmt3 = conn.prepareStatement(sqlStr);

		// ���� ��� �������� �ִ� ������������ �۰ų� ������ ����
		while(PageCnt <= maxPage){
			// �������� ���� �������� ���� ���� ������, �� ������ ���� 
			psmt1.setInt(1, dataStart);
			psmt1.setInt(2, dataEnd);
			// �������� �հ�, ����� �������� ���� ���� ������, �� ������ ���� 
			psmt2.setInt(1, dataStart);
			psmt2.setInt(2, dataEnd);
			// ���� �հ�, ����� �������� ���� ���� ������, �� ������ ���� 
			psmt3.setInt(1, dataEnd);
		
			// ���� ������ ���� ���
			System.out.printf("���� ������ : %d  ", PageCnt);
			// ������ڰ� �������� Ȯ��
			System.out.printf("������� : %s\n", df.format(cal.getTime()));
			// ����κ� ���
			System.out.printf("================================================\n");
			System.out.printf("%-5.5s%-5.5s %3.3s %3.3s %3.3s %4.4s %5.5s\n",
								"�й�", "�̸�", "����", "����", "����", "����", "���");
			System.out.printf("================================================\n");
			// �������� DB�� ������ ����� ResultSet�� �޾ƿ´�
			rset = psmt1.executeQuery();
			// �޾ƿ� ����� ������ �ݺ� ����
			while(rset.next()){
				// ���������� �޾ƿ� �������� �ο����� ���
				System.out.printf("%04d  %s %2.2s %5.5s %5.5s %7.7s %6.6s\n", //rset.getInt(1) +
						Integer.parseInt(rset.getString(1)), HanBlackBackword(rset.getString(2), 10),
						rset.getString(3), rset.getString(4), rset.getInt(5), rset.getInt(6), rset.getInt(7));
			}
			// �������� DB�� ������ ����� ResultSet�� �޾ƿ´�
			rset = psmt2.executeQuery();
			// �޾ƿ� ����� ������ �ݺ� ����			
			while(rset.next()){
				// ���������� �޾ƿ� ���� ������ �հ� ��� ���
				System.out.printf("================================================\n");
				System.out.println("����������");
				System.out.printf("�հ�  %13d %5d %5d %7d %6d\n",
						rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
				System.out.printf("���  %13d %5d %5d %7d %6d\n",
						rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getInt(9), rset.getInt(10));
			}
			// �������� DB�� ������ ����� ResultSet�� �޾ƿ´�
			rset = psmt3.executeQuery();
			// �޾ƿ� ����� ������ �ݺ� ����			
			while(rset.next()){
				// ���������� �޾ƿ� ���� ������ �հ� ��� ���
				System.out.printf("================================================\n");
				System.out.println("����������");
				System.out.printf("�հ�  %13d %5d %5d %7d %6d\n",
						rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
				System.out.printf("���  %13d %5d %5d %7d %6d\n",
						rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getInt(9), rset.getInt(10));
			}
			System.out.println();
					
			// ������ �� ����
			PageCnt ++;
			// �������� ������ ���� ���� ����
			dataStart = dataEnd+1;
			// �������� ������ �������� ����
			dataEnd = PageCnt * pageNum ;
			// ������ ���������� �ִ� �ο����� �Ѿ�� �ִ��ο����� ����
			if(dataEnd > maxNum)
				dataEnd = maxNum;
		}
		// ResultSet ��ü ����	
		rset.close();
		// PreparedStatement ��ü ����	
		psmt1.close();
		psmt2.close();
		psmt3.close();
		// Statement ��ü ����	
		stmt.close();
		// Connection ��ü ����
		conn.close();
	}
}
