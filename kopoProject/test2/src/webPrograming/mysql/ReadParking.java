package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReadParking {
	// 메인메소드 실행부분 예외처리를 throws를 이용해 java가 처리하게 만들었다
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 드라이버 이름이 존재하는 클래스를 메모리에 로딩한다
		Class.forName("com.mysql.jdbc.Driver");
		// 아이디와 패스워드, 접속 정보를 이용해서 Mysql DB에 연결해준다
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL문을 처리하기 위해 Statement 객체를 생성
		Statement stmt = conn.createStatement();
		
		// 기준이 되는 장소의 위도, 경도
		double lat=37.3860521; double lng=127.1214038;
		// QueryTxt 변수에 최장거리, 최단거리 구하는 sql문을 저장해준다
		String QueryTxt;
//		// 가장 먼 장소 구하기
		QueryTxt = String.format("select * from parking where " +
		"SQRT(POWER( plat-%f,2) + POWER( plng-%f,2) ) = " +
		"(select MAX(SQRT(POWER(plat-%f,2) + POWER(plng-%f,2))) from parking);",
		lat, lng, lat, lng);
//		// 가장 가까운 장소 구하기
//		QueryTxt = String.format("select * from parking where " +
//				"SQRT(POWER( plat-%f,2) + POWER( plng-%f,2) ) = " +
//				"(select MIN(SQRT(POWER(plat-%f,2) + POWER(plng-%f,2))) from parking);",
//				lat, lng, lat, lng);
		// DB에 sql문을 보내어 결과값을 ResultSet 변수에 받아온다
		ResultSet rset = stmt.executeQuery(QueryTxt);
		// 가져온 데이터를 출력하기 전에 해당하는 위치의 제목을 출력
		System.out.printf("  관리번호      주차장명                주  소           위도       경도 \n");
		// rset 객체가 있으면 반복
		while(rset.next()){
			// DB에서 조회한 각각의 값들을 순차적으로 화면에 출력해준다
			System.out.printf("%4s %6s %5s %6s %4s\n",
					rset.getString(1), rset.getString(2), rset.getString(5), rset.getString(11),
					rset.getString(12));
		}
		// ResultSet 객체 종료
		rset.close();
		// Statement 객체 종료
		stmt.close();
		// Connection 객체 종료
		conn.close();
	}
}
