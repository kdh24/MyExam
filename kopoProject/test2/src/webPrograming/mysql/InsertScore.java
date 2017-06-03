package webPrograming.mysql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import webPrograming.stringBuffer.OneRec;

public class InsertScore {
	static ArrayList<OneRec> ArrayOneRec = new ArrayList<>();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();

		// 버퍼 클래스를 이용해서 한줄씩 가져와 저장할 String 변수
		String QueryTxt;
		int iPerson = 1000;

		// 한 줄을 먼저 읽어야 필드명을 알 수 있다.

		// 반복 횟수를 알기위한 int 변수
		int LineCnt = 1;
		int eCnt=0;

		// 파일이 비어있지 않으면 가져와서 반복처리
		while (LineCnt<= iPerson) {
			// 탭(\t)을 구분자로 버퍼에서 가져온 한줄의 값(readtxt)를 field 배열에 나눠서 저장해준다
			try{
				String name = String.format("홍길%02d", LineCnt);
				int kor = (int)(Math.random()*100);	//국어점수 만들기
				int eng = (int)(Math.random()*100);	//영어점수 만들기
				int mat = (int)(Math.random()*100);	//수학점수 만들기
				
				QueryTxt = String.format("insert into score(sId,sName,kor,eng,mat)"+
																	" values("
																	+ "%02d,'%s',%d,%d,%d);",
																	LineCnt, name, kor, eng, mat
																);
				stmt.execute(QueryTxt);
				System.out.printf("%d번재 항목 Insert OK [%s]\n", LineCnt,QueryTxt );
			}catch(Exception e){
				e.printStackTrace();
				eCnt++;
			}
			// 한번 실행될때마다 반복횟수 증가
			LineCnt++;
		}
		System.out.printf("에러 Data 총 갯수 : %d\n", eCnt);
		
		stmt.close();
		conn.close();
	}
}
