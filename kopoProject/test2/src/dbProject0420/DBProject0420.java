package dbProject0420;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBProject0420 {
	public static void main(String[] args) {
		try {
			// 오라클 DB에 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.136.128:1521:orasparta", "SCOTT", "tiger");
			Statement stmt = conn.createStatement();
			
			// 자동으로 commit을 해주는 기능을 해제해준다.
			conn.setAutoCommit(false);
			
			// sql문을 한번에 입력하기 위한 String 변수 생성
			String sql = null;

			// zipcode 파일을 읽어들인다.
			InputStream f = new FileInputStream("C:\\dbex\\zipcode_20130201.csv");
			BufferedInputStream bis = new BufferedInputStream(f);
			BufferedReader br = new BufferedReader(new InputStreamReader(bis, "ms949"));
			
			// 파일 에러가 발생할 경우 zipcode_error.log 에 에러 내용을 저장시켜준다.
			FileWriter out = new FileWriter("C:\\dbex\\zipcode_error.log");

			//파일 한줄씩 데이터를 읽어와 저장하는 변수 
			String value;
			
			//불러온 파일값이 없을경우 빈파일입니다. 라고 출력 후 종료
			if((value = br.readLine()) == null){
				System.out.println("빈파일입니다.");
				return;
			}

			int LineCnt = 0;
			
			// 파일에서 읽어온 값이 빈파일이 아닐경우 처리
			while((value = br.readLine()) != null){
				try{
					// csv 파일에 , 구분자로 구분되어 있는 값들을  구분해서 하나씩 String 배열에 저장
					String[] filed = value.split(",");
				
//					System.out.println("원래 값" + value + " ");
					
					// sql 변수에 입력하고 싶은 쿼리문은 완성시켜 저장해준다.
					sql = String.format("INSERT INTO zipcode(zipcode, sido, gugun, "
					 + "dong, ri, bunji, seq) "
					 + " VALUES("
					 + "'%s', '%s', '%s', '%s', '%s',"
					 + "'%s', '%s')",
					 filed[0], filed[1], filed[2], filed[3], filed[4],
					 filed[5], filed[6]);
	
					// 완성된 쿼리문 sql변수에 넣어 DBMS에 보내 처리하게 해준다.
					stmt.execute(sql);
					
					// 한번 실행할 때마다 몇번째 실행중인지 알려주는 변수로 1개씩 값을 증가시켜준다.
					LineCnt++;
					
					// 어느 부분을 처리하는지 육안으로 확인할 수 있게 해준다.
					System.out.printf("%d번째 항목 Insert OK [%s]\n",LineCnt, sql);
					
				}catch(SQLException e){
					System.out.println("\nsql 에러입니다.");
					LineCnt++;
					System.out.println(LineCnt + "번 째 줄에 문제가 생겼습니다.");
					System.out.println("해당값 : " + sql);
					
					// 에러난 부분에 대한 정보를 errorMessage 변수에 넣어준다. 
					String errorMessage = LineCnt + " 번째 에러\n";
					errorMessage += "해당값 : " + sql;
					errorMessage += "\n" + e.getMessage();
					
					// 에러난 부분에 대한 정보를 가지고 있는 errorMessage 변수를 파일에 저장한다.
					out.write(errorMessage);
					out.flush();

					// 에러가 나면 ROLLBACK 처리를 해준다 AutoCommit을 하지 않기때문에 꼭 필요하지는 않다
					stmt.execute("ROLLBACK");
					// 에러 메세지 출력
					e.printStackTrace();
					break;
				}
			}
			// 값이 문제가 없을경우 commit 처리를 해주어 값을 저장
			if((value = br.readLine()) == null){
				System.out.println("문제가 되는 부분이 없습니다. commit 합니다.");
				stmt.execute("commit");
				return;
			}

			// 접속 및 파일처리에 관한 부분들을 닫아준다
			f.close();
			bis.close();
			br.close();
			out.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
