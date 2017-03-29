package com.mycompany.myweb.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestMember {

	public static void main(String[] args) throws Exception{
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@106.253.56.123:1521:orcl", "kosauser11", "kosa12345");
		String sql = "insert into member(mid, mpassword, mname, memail, maddress, mtel, mlevel) values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(int i=1; i<=100; i++) {
			pstmt.setString(1, "user"+i);
			pstmt.setString(2, "12345");
			pstmt.setString(3, "사용자"+i);
			pstmt.setString(4, "qwe"+i+"@asd.com");
			pstmt.setString(5, "우리집"+i);
			pstmt.setString(6, "010-1212-1231");
			pstmt.setString(7, "노예");
			pstmt.executeUpdate();
		}
		pstmt.close();
		conn.close();

	}

}
