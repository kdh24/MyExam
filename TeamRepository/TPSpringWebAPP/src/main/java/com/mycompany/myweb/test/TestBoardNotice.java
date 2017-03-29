package com.mycompany.myweb.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestBoardNotice {
	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@106.253.56.123:1521:orcl", "kosauser11", "kosa12345");
		String sql = "insert into BOARD_NOTICE(bno, btitle, bcontent, bwriter, bdate, bhitcount) values(SEQ_BOARDNOTICE_BNO.nextval, ?, ?, ?, sysdate, 0)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(int i=1; i<=100; i++) {
			pstmt.setString(1, "제목" + i);
			pstmt.setString(2, "내용"+i);
			pstmt.setString(3, "user1");
			pstmt.executeUpdate();
		}
		pstmt.close();
		conn.close();
	}
}
