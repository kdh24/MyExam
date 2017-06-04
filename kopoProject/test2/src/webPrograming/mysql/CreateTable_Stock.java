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
						"st_code varchar(20) not null ,"+	// 단축코드
						"sDay date not null," +			// 일자
						"sItemCode varchar(20) not null," +	// 일자
						"endMoney	int(15)," +				// 종가
						"sMoney		int(15)," +				// 시가
						"topMoney	int(15)," +				// 고가 
						"lowMoney	int(15)," +				// 저가
						"tradeNum	int(15)," +				// 거래량
						"tradeMoney	bigint," +				// 거래대금
						"CONSTRAINT PK_stock_code_Day primary key(st_code, sDay, sItemCode)) "+ 
						"DEFAULT CHARSET=utf8;");	
						
		stmt.close();
		conn.close();
	}
}
