package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReadParking {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();
		
		double lat=37.3860521; double lng=127.1214038;
		
		String QueryTxt;
//		// 가장 먼 장소 구하기
//		QueryTxt = String.format("select * from parking where " +
//		"SQRT(POWER( plat-%f,2) + POWER( plng-%f,2) ) = " +
//		"(select MAX(SQRT(POWER(plat-%f,2) + POWER(plng-%f,2))) from parking);",
//		lat, lng, lat, lng);
//		// 가장 가까운 장소 구하기
		QueryTxt = String.format("select * from parking where " +
				"SQRT(POWER( plat-%f,2) + POWER( plng-%f,2) ) = " +
				"(select MIN(SQRT(POWER(plat-%f,2) + POWER(plng-%f,2))) from parking);",
				lat, lng, lat, lng);
		
		ResultSet rset = stmt.executeQuery(QueryTxt);
		
		System.out.printf("  관리번호      주차장명                주  소           위도       경도 \n");
		while(rset.next()){
			System.out.printf("%4s %6s %5s %6s %4s\n",
					rset.getString(1), rset.getString(2), rset.getString(5), rset.getString(11),
					rset.getString(12));
		}
		rset.close();
		stmt.close();
		conn.close();
	}
}
