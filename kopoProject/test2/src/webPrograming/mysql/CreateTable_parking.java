package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable_parking {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();
		stmt.execute( "create table parking(" + // Result Set이 의미 없음 executeQuery ->execute
						"pId varchar(15) not null ,"+	// 주차장 관리번호  1
						"pName varchar(50) not null," +	// 주차장명  2
						"pCartegory	varchar(10)," +		// 주차장 구분 3
						"pType	varchar(10)," +			// 주차장 유형 4 
						"pAdd1	varchar(100)," +			// 소재지지번주소 5
						"pAdd2 varchar(100),"+	// 소재지도로명주소 6
						"pNum int,"		+		// 주차구획수 7
						"pMoney varchar(10),"+	// 요금정보  17
						"pAdminName varchar(50),"	+// 관리기관명 27
						"pAdminTel varchar(20),"+	// 관리기관 연락처 28
						"plat decimal(10, 5),"+	// 위도 32
						"plng decimal(10, 5),"+
						"CONSTRAINT PK_park primary key(pId, pName, pAdd1)) "+ 
						"DEFAULT CHARSET=utf8;");	// 경도 33
						
		stmt.close();
		conn.close();
	}
}
