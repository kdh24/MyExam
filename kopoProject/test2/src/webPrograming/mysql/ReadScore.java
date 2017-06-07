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
	// 한글 공백처리를 위한 클래스
	public static String HanBlackBackword(String Han, int num){
		// 한글 공백변수
		String k07_HanBlack="";
		// 한글매개변수의 값의 바이트 길이를 전체 길이에서 빼서 그것을 최대값으로 정하는 변수		
		int max= num -Han.getBytes().length;
		//한글 변수의 바이트가 제한 바이트보다 높으면 실행
		if(Han.getBytes().length > num ){
			// 한글 바이트를 2로 나누었을때 1이면 한글이 깨질수도 있으므로 아래와 같이 처리해준다
			if(Han.getBytes().length % 2 == 1)
				k07_HanBlack = new String(Han.getBytes(), 0, num-1) + " ";
			else 
				k07_HanBlack = new String(Han.getBytes(), 0, num);
		}else // 한글변수가 원하는 길이 이하일때 실행
		{
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

	// 메인메소드 실행부분 예외처리를 throws를 이용해 java가 처리하게 만들었다
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat df = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");
		// 드라이버 이름이 존재하는 클래스를 메모리에 로딩한다
		Class.forName("com.mysql.jdbc.Driver");
		// 아이디와 패스워드 등 접속 정보를 이용해서 Mysql DB에 연결해준다
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL문을 처리하기 위해 Statement 객체를 생성
		Statement stmt = conn.createStatement();
		// SQL문을 처리하기 위해 PreparedStatement 객체를 생성
		PreparedStatement psmt1 = null;
		PreparedStatement psmt2 = null;
		PreparedStatement psmt3 = null;
		
		// sql문 처리를 위한 String 변수
		String QueryTxt;
		String sqlStr;
		// 현재페이지 변수 
		int PageCnt = 1;
		// 페이지별 출력인원 변수
		int pageNum = 30;
		// 시작 데이터 기준
		int dataStart = 1;
		// 종료 데이터 기준
		int dataEnd = pageNum;
		// 최대 페이지 갯수
		int maxPage = 0;
		// 총 몇명이 있는지 저장하는 변수
		int maxNum = 0;
		
//		// 가장 가까운 장소 구하기
		QueryTxt = "select count(*) from score;";
		// 전체 총 인원을 ResultSet 결과로 받아온다
		ResultSet rset = stmt.executeQuery(QueryTxt);
		// 가져온 값이 있으면 실행
		while(rset.next()){
			// 최대 인원을 maxNum 변수에 넣어준다
			maxNum = rset.getInt(1);
		}

		// 최대 인원 / 페이지당 출력인원 == 0 이면  최대 페이지는 maxNum / pageNum 으로 초기화 하고 아니면 1을 더해준다
		if(maxNum % pageNum == 0){
			maxPage = maxNum / pageNum;
		}else{
			maxPage = maxNum / pageNum + 1;
		}
		// 개인별 총점 평균 구하기
		sqlStr = "select sId, sName, kor, eng, mat, sum(kor+eng+mat) as sum, sum(kor+eng+mat)/3 from (select @rnum:=@rnum +1 as no, a.* "
				+ "from (select * from score order by sId) a, (select @rnum:=0) b ) c where c.no >= ? and c.no <= ? "
				+ "group by sId;";
//		sqlStr = "select a.* from ("
//				+ "select @rownum := @rownum + 1 as rownum,"
//				+ "score.* from score,"
//				+ "(select @rownum := 0) R) a "
//				+ "group by sId where a.rownum >= ? and a.rownum <= ? ";
		
		// sql문을 PreparedStatement 객체에 기억시킨다
		psmt1 = conn.prepareStatement(sqlStr);
		
		// 현재 페이지 총점 평균 구하기
		sqlStr = "select sum(kor), sum(eng), sum(mat), sum(kor)+sum(eng)+sum(mat), sum(kor+eng+mat)/3, "
				+ "avg(kor), avg(eng), avg(mat), avg(kor)+avg(eng)+avg(mat), (avg(kor)+avg(eng)+avg(mat))/3 from (select @rnum:=@rnum +1 as no, a.* "
				+ "from (select * from score order by sId) a, (select @rnum:=0) b ) c where c.no >= ? and c.no <= ?;";
		// sql문을 PreparedStatement 객체에 기억시킨다
		psmt2 = conn.prepareStatement(sqlStr);
		
		// 누적 페이지 총점 평균 구하기
		sqlStr = "select sum(kor), sum(eng), sum(mat), sum(kor)+sum(eng)+sum(mat), sum(kor+eng+mat)/3, "
				+ "avg(kor), avg(eng), avg(mat), avg(kor)+avg(eng)+avg(mat), (avg(kor)+avg(eng)+avg(mat))/3 from (select @rnum:=@rnum +1 as no, a.* "
				+ "from (select * from score order by sId) a, (select @rnum:=0) b ) c where c.no <= ?";
		// sql문을 PreparedStatement 객체에 기억시킨다
		psmt3 = conn.prepareStatement(sqlStr);

		// 현재 출력 페이지가 최대 페이지수보다 작거나 같으면 실행
		while(PageCnt <= maxPage){
			// 페이지별 정보 가져오기 위해 시작 페이지, 끝 페이지 지정 
			psmt1.setInt(1, dataStart);
			psmt1.setInt(2, dataEnd);
			// 페이지별 합계, 평균을 기져오기 위해 시작 페이지, 끝 페이지 지정 
			psmt2.setInt(1, dataStart);
			psmt2.setInt(2, dataEnd);
			// 누적 합계, 평균을 기져오기 위해 시작 페이지, 끝 페이지 지정 
			psmt3.setInt(1, dataEnd);
		
			// 현재 페이지 숫자 출력
			System.out.printf("현재 페이지 : %d  ", PageCnt);
			// 출력일자가 언제인지 확인
			System.out.printf("출력일자 : %s\n", df.format(cal.getTime()));
			// 제목부분 출력
			System.out.printf("================================================\n");
			System.out.printf("%-5.5s%-5.5s %3.3s %3.3s %3.3s %4.4s %5.5s\n",
								"학번", "이름", "국어", "영어", "수학", "총점", "평균");
			System.out.printf("================================================\n");
			// 쿼리문을 DB에 보내어 결과를 ResultSet에 받아온다
			rset = psmt1.executeQuery();
			// 받아온 결과가 있으면 반복 실행
			while(rset.next()){
				// 쿼리문으로 받아온 페이지당 인원정보 출력
				System.out.printf("%04d  %s %2.2s %5.5s %5.5s %7.7s %6.6s\n", //rset.getInt(1) +
						Integer.parseInt(rset.getString(1)), HanBlackBackword(rset.getString(2), 10),
						rset.getString(3), rset.getString(4), rset.getInt(5), rset.getInt(6), rset.getInt(7));
			}
			// 쿼리문을 DB에 보내어 결과를 ResultSet에 받아온다
			rset = psmt2.executeQuery();
			// 받아온 결과가 있으면 반복 실행			
			while(rset.next()){
				// 쿼리문으로 받아온 현재 페이지 합계 평균 출력
				System.out.printf("================================================\n");
				System.out.println("현재페이지");
				System.out.printf("합계  %13d %5d %5d %7d %6d\n",
						rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
				System.out.printf("평균  %13d %5d %5d %7d %6d\n",
						rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getInt(9), rset.getInt(10));
			}
			// 쿼리문을 DB에 보내어 결과를 ResultSet에 받아온다
			rset = psmt3.executeQuery();
			// 받아온 결과가 있으면 반복 실행			
			while(rset.next()){
				// 쿼리문으로 받아온 누적 페이지 합계 평균 출력
				System.out.printf("================================================\n");
				System.out.println("누적페이지");
				System.out.printf("합계  %13d %5d %5d %7d %6d\n",
						rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5));
				System.out.printf("평균  %13d %5d %5d %7d %6d\n",
						rset.getInt(6), rset.getInt(7), rset.getInt(8), rset.getInt(9), rset.getInt(10));
			}
			System.out.println();
					
			// 페이지 수 증가
			PageCnt ++;
			// 페이지별 데이터 시작 지점 변경
			dataStart = dataEnd+1;
			// 페이지별 데이터 종료지점 변경
			dataEnd = PageCnt * pageNum ;
			// 데이터 종료지점이 최대 인원수를 넘어가면 최대인원수로 변경
			if(dataEnd > maxNum)
				dataEnd = maxNum;
		}
		// ResultSet 객체 종료	
		rset.close();
		// PreparedStatement 객체 종료	
		psmt1.close();
		psmt2.close();
		psmt3.close();
		// Statement 객체 종료	
		stmt.close();
		// Connection 객체 종료
		conn.close();
	}
}
