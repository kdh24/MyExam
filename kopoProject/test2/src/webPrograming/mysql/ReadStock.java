package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReadStock {
	// 메인메소드 실행부분 예외처리를 throws를 이용해 java가 처리하게 만들었다
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 드라이버 이름이 존재하는 클래스를 메모리에 로딩한다
		Class.forName("com.mysql.jdbc.Driver");
		// 아이디와 패스워드, 접속 정보를 이용해서 Mysql DB에 연결해준다
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL문을 처리하기 위해 Statement 객체를 생성
		Statement stmt = conn.createStatement();
		PreparedStatement psmt = null;
		
		// QueryTxt 변수에 최장거리, 최단거리 구하는 sql문을 저장해준다
		String QueryTxt;
//		// 특정 일자 조회하기
		QueryTxt = "select * from stock where " +
				"sDay = ?;";
////		// 삼성 주식 조회하기
//		QueryTxt = "select * from stock where " +
//				"sItemCode = ?;";
		// DB에 sql문을 보내어 결과값을 ResultSet 변수에 받아온다
//		ResultSet rset = stmt.executeQuery(QueryTxt);
		psmt = conn.prepareStatement(QueryTxt);
		
//		psmt.setString(1, "A005930");
		psmt.setString(1, "20070302");
		
		ResultSet rset = psmt.executeQuery();
		// 가져온 데이터를 출력하기 전에 해당하는 위치의 제목을 출력
		System.out.printf("  종목코드      일자                상품코드          위도       경도 \n");
		// rset 객체가 있으면 반복
		while(rset.next()){
			// DB에서 조회한 각각의 값들을 순차적으로 화면에 출력해준다
			System.out.printf("%4s %6s %5s %6s %4s\n",
					rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(7),
					rset.getString(6));
		}
		// ResultSet 객체 종료
		rset.close();
		// Statement 객체 종료
		stmt.close();
		// Connection 객체 종료
		conn.close();
	}
}
