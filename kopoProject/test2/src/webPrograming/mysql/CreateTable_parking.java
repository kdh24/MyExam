package webPrograming.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable_parking {
	// 메인메소드 실행부분 예외처리를 throws를 이용해 java가 처리하게 만들었다
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 드라이버 이름이 존재하는 클래스를 메모리에 로딩한다
		Class.forName("com.mysql.jdbc.Driver");
		// 아이디와 패스워드 등 접속 정보를 이용해서 Mysql DB에 연결해준다
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL문을 처리하기 위해 Statement 객체를 생성
		Statement stmt = conn.createStatement();
		// ""안에 있는  sql문장을 DB로 보내어 table을 생성해준다.
		stmt.execute( "create table parking(" + // Result Set이 의미 없음 executeQuery ->execute
						"pId varchar(15) not null ,"+	// 주차장 관리번호  1
						"pName varchar(50) not null," +	// 주차장명  2
						"pCartegory	varchar(10)," +		// 주차장 구분 3
						"pType	varchar(10)," +			// 주차장 유형 4 
						"pAdd1	varchar(100)," +		// 소재지지번주소 5
						"pAdd2 varchar(100),"+		// 소재지도로명주소 6
						"pNum int,"		+			// 주차구획수 7
						"pMoney varchar(10),"+		// 요금정보  17
						"pAdminName varchar(50),"	+// 관리기관명 27
						"pAdminTel varchar(20),"+	// 관리기관 연락처 28
						"plat decimal(10, 5),"+		// 위도 32
						"plng decimal(10, 5),"+ 	// 경도 33
						// 테이블의 primary key 설정을 위해 제약조건을 PK_park 라는 이름으로 생성(pId 등 3가지 컬럼 복합키)
						"CONSTRAINT PK_park primary key(pId, pName, pAdd1)) "+ 
						"DEFAULT CHARSET=utf8;");	// 기본 charset을 utf8로 설정해준다

		// Statement 객체 종료	
		stmt.close();
		// Connection 객체 종료
		conn.close();
	}
}
