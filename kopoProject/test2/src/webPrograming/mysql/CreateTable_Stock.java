package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable_Stock {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();
		stmt.execute( "create table stock(" + 
						"sId int not null ,"+	// 단축코드
						"sName varchar(20) not null," +	// 일자
						"kor	int," +			// 시가
						"eng	int," +			// 고가 
						"mat	int," +			// 저가
						"mat	int," +			// 종가
						"mat	int," +			// 거래량
						"mat	int," +			// 거래대금
						"CONSTRAINT PK_score_sId primary key(sId)) "+ 
						"DEFAULT CHARSET=utf8;");	
						
		stmt.close();
		conn.close();
	}
}
