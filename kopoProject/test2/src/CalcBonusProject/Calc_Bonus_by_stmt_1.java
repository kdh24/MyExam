package CalcBonusProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Calc_Bonus_by_stmt_1 {
	public static void main(String[] args) {
		try {
			// 오라클 DB에 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.136.128:1521:orasparta", "SCOTT",
					"tiger");

			// 작업 처리를 위한 Statement 객체 생성
			Statement stmt = conn.createStatement();
			Statement stmt_ins = null;
			conn.setAutoCommit(false);

			// 작업 처리를 위한 각종 변수 생성
			String resultData = "";
			String sqlStr = "";
			long startTime = 0;
			long endTime = 0;
			int BONUS = 0;
			int count = 0;

			// SELECT 문을 보내 값을 ResultSet 변수에 받아온다
			ResultSet rs = stmt.executeQuery("SELECT EMPNO, JOB, DEPTNO, SAL " 
													+ "FROM EMP_LARGE ");

			// 시간 측정을 위한 StartTime 변수
			startTime = System.currentTimeMillis();
			
			//SELECT 문으로 가져온 row를 한줄씩 반복해서 처리해준다.
			while (rs.next()) {
				// ResultSet 으로 가져온 2번째 값  JOB에 대한 값이 PRESIDENT 문자열이면 작업하지 않고 넘어간다
				if (rs.getString(2).equals("PRESIDENT")) {
					continue;
				}

				// ResultSet 으로 가져온 3번째 값 DEPTNO 에 따른 BONUS 처리
				switch (rs.getString(3)) {
					case "10":
						BONUS = (int)(Integer.parseInt(rs.getString(4)) * 0.3); 
						break;
					case "20":
						BONUS = (int)(Integer.parseInt(rs.getString(4)) * 0.1); 
						break;
					case "30":
						BONUS = (int)(Integer.parseInt(rs.getString(4)) * 0.05); 
						break;
					case "40":
						BONUS = (int)(Integer.parseInt(rs.getString(4)) * 0.2); 
						break;
					default:
						break;
				}
				
//				중간 확인을 위해 보너스 값 출력
//				System.out.printf("월급 값 = %s\n", rs.getString(4));
//				System.out.printf("보너스의 값 = %d\n", BONUS);
				
				// ResultSet 값 각각의 값을 보기위한 중간 출력 변수
//				resultData += rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)
//						+ "\t" + "\n";
				
				// BONUS_LARGE 테이블에 값을 저장하기 위한 Insert문  
				sqlStr = String.format("INSERT INTO BONUS_LARGE(YYYYMM,EMPNO,JOB,DEPTNO,SAL,BONUS) "
						+ "VALUES(%s, '%s', '%s', '%s', '%s', '%s')", 
						"to_char(sysdate,'yyyymm')", rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), String.valueOf(BONUS));   

				// 몇 행 작업을 처리중인지 보여주는 count 변수와 작업내용을 보여주는 sqlStr 출력
//				System.out.println(count + "row 처리 : " + sqlStr);
				
				
				stmt_ins = conn.createStatement();
				stmt_ins.executeUpdate(sqlStr);
				stmt_ins.execute("COMMIT");
				stmt_ins.close();

				count++;
			}
//			 System.out.println(resultData);
			 
			// 시간 측정을 위한 endTime 변수
			endTime = System.currentTimeMillis();

			// 총 작업 시간 출력
			System.out.println("경과 시간 : " + (endTime - startTime) + "ms");
			
			// 작업이 끝난 후에 객체를 전부 종료해 준다
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
