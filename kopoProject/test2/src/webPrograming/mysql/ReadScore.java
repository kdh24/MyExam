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
		// 한글 공백변수
		String k07_HanBlack="";
		// 한글매개변수의 값의 바이트 길이를 전체 길이에서 빼서 그것을 최대값으로 정하는 변수		
		int max= num -Han.getBytes().length;
		
		if(Han.getBytes().length > num ){
			if(Han.getBytes().length % 2 == 1)
				k07_HanBlack = new String(Han.getBytes(), 0, num-1) + " ";
			else 
				k07_HanBlack = new String(Han.getBytes(), 0, num);
		}else
		{
//			k07_HanBlack = new String(k07_Han.getBytes(), 0, 20);
			
			// 한글 공백처리변수에 미리 넘겨받은 한글값을 넣어준다
			k07_HanBlack += Han;
			// max 변수의 값만큼 공백을 추가로 더해준다
			for (int i = 0; i < max; i++) {
				k07_HanBlack += " ";
			}
		}
		// 한글과 공백을 더한 k07_HanBlack 변수를 리턴값으로 돌려준다.
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
		
//		// 가장 가까운 장소 구하기
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
		// 개인별 총점 평균 구하기
		sqlStr = "select sId, sName, kor, eng, mat, sum(kor+eng+mat) as sum, sum(kor+eng+mat)/3 from (" 
				+ "select * "
				+ "from score where sId >= ? && sId <= ?) as pageScore "
				+ " group by sId order by sId;";
		psmt1 = conn.prepareStatement(sqlStr);
		
		// 현재 페이지 총점 평균 구하기
		sqlStr = "select sum(k), sum(e), sum(m), sum(k+e+m), sum(k+e+m)/3, "
				+ "avg(k), avg(e), avg(m), avg(k)+avg(e)+avg(m), (avg(k)+avg(e)+avg(m))/3 from ("
				 + "select sId, kor k, eng e, mat m "
				 + "from score where sId >= ? && sId <= ?) as pageScore"
				 + " order by sId;";
		psmt2 = conn.prepareStatement(sqlStr);
		
		// 누적 페이지 총점 평균 구하기
		sqlStr = "select sum(k), sum(e), sum(m), sum(k+e+m), sum(k+e+m)/3, "
				+ "avg(k), avg(e), avg(m), avg(k)+avg(e)+avg(m), (avg(k)+avg(e)+avg(m))/3 from ("
				+ "select sId, kor k, eng e, mat m "
				+ "from score where sId <= ?) as pageScore "
				+ " order by sId;";
		psmt3 = conn.prepareStatement(sqlStr);

		
		while(PageCnt <= maxPage){
			// 페이지별 정보 가져오기 위해 시작 페이지, 끝 페이지 지정 
			psmt1.setInt(1, dataStart);
			psmt1.setInt(2, dataEnd);
			// 페이지별 합계, 평균을 기져오기 위해 시작 페이지, 끝 페이지 지정 
			psmt2.setInt(1, dataStart);
			psmt2.setInt(2, dataEnd);
			// 누적 합계, 평균을 기져오기 위해 시작 페이지, 끝 페이지 지정 
			psmt3.setInt(1, dataEnd);
		
			System.out.printf("현재 페이지 : %d  ", PageCnt);
			System.out.printf("출력일자 : %s\n", df.format(cal.getTime()));
			System.out.printf("================================================\n");
			System.out.printf("%-5.5s%-5.5s %3.3s %3.3s %3.3s %4.4s %5.5s\n",
								"학번", "이름", "국어", "영어", "수학", "총점", "평균");
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
				System.out.println("현재페이지");
				System.out.printf("합계  %13d %5d %5d %7d %6d\n",
						rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
				System.out.printf("평균  %13d %5d %5d %7d %6d\n",
						rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getInt(9), rset.getInt(10));
			}
			rset = psmt3.executeQuery();
			while(rset.next()){
				System.out.printf("================================================\n");
				System.out.println("누적페이지");
				System.out.printf("합계  %13d %5d %5d %7d %6d\n",
						rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
				System.out.printf("평균  %13d %5d %5d %7d %6d\n",
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
