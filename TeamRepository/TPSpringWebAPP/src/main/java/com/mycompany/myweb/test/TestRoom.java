package com.mycompany.myweb.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestRoom {
	public static void main(String[] ar) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@106.253.56.125:1521:orcl", "kosauser11", "kosa12345");
		String sql = "insert into room(rid, rname, rmid, rempty) values(seq_room_rid.nextval, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(int i=5; i<=10; i++) {
			pstmt.setString(1, "방" + i);
			pstmt.setString(2, "user5");
			pstmt.setString(3, "0");
			pstmt.executeUpdate();
		}
		pstmt.close();
		conn.close();
	}
}
