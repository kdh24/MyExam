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
						"st_code varchar(20) not null ,"+	// �����ڵ�
						"sDay date not null," +			// ����
						"sItemCode varchar(20) not null," +	// ����
						"endMoney	int(15)," +				// ����
						"sMoney		int(15)," +				// �ð�
						"topMoney	int(15)," +				// �� 
						"lowMoney	int(15)," +				// ����
						"tradeNum	int(15)," +				// �ŷ���
						"tradeMoney	bigint," +				// �ŷ����
						"CONSTRAINT PK_stock_code_Day primary key(st_code, sDay, sItemCode)) "+ 
						"DEFAULT CHARSET=utf8;");	
						
		stmt.close();
		conn.close();
	}
}
