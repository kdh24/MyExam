package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable_Stock {
	// 메인메소드 실행부분 예외처리를 throws를 이용해 java가 처리하게 만들었다
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 드라이버 이름이 존재하는 클래스를 메모리에 로딩한다
		Class.forName("com.mysql.jdbc.Driver");
		// 아이디와 패스워드 등 접속 정보를 이용해서 Mysql DB에 연결해준다
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL문을 처리하기 위해 Statement 객체를 생성
		Statement stmt = conn.createStatement();
		// ""안의 sql문을 DB로 보내어 stock 테이블 생성 
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
						// primary key 설정을 위한 제약조건 (3가지 컬럼을 이용한 복합키 지정)
						"CONSTRAINT PK_stock_code_Day primary key(st_code, sDay, sItemCode)) "+ 
						// 기본 CHARSET을 utf8로 설정해준다
						"DEFAULT CHARSET=utf8;");	

		// Statement 객체 종료	
		stmt.close();
		// Connection 객체 종료
		conn.close();
	}
}
