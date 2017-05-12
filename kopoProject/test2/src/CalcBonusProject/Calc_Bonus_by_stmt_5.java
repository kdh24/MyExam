package CalcBonusProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Calc_Bonus_by_stmt_5 {
	public static void main(String[] args) {
		try {
			// 오라클 DB에 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.136.128:1521:orasparta", "SCOTT",
					"tiger");

			// 자동 commit 기능 해제
			conn.setAutoCommit(false);
			// 작업 처리를 위한 Statement 객체 생성
			Statement stmt = conn.createStatement();
			Statement stmt_ins = conn.createStatement();
			PreparedStatement psmt = null;

			// 작업 처리를 위한 각종 변수 생성
			String resultData = "";
			String sqlStr = "";
			String queryText= "";
			long startTime = 0;
			long endTime = 0;
			int BONUS = 0;
			int count = 1;
			boolean debugStatus = false;
			
//////////////////////////////////////  디버깅 부분     /////////////////////////////////////////////////
			/*

			String rowNum = "5000";
			// SELECT 문을 보내 값을 ResultSet 변수에 받아온다
			queryText = String.format("SELECT EMPNO, JOB, DEPTNO, SAL FROM EMP_LARGE "
					+ "WHERE JOB NOT LIKE '%s' AND ROWNUM <= %s", "PRESIDENT", rowNum);
			
			ResultSet rs = stmt.executeQuery(queryText);
			
			// 디버깅 시간 측정을 위한 StartTime 변수
			startTime = System.currentTimeMillis();
			
			while (rs.next()) {
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

				// BONUS_LARGE 테이블에 값을 저장하기 위한 Insert문  
				sqlStr = String.format("INSERT INTO BONUS_LARGE(YYYYMM,EMPNO,JOB,DEPTNO,SAL,BONUS) "
						+ "VALUES(%s, '%s', '%s', '%s', '%s', '%s')", 
						"to_char(sysdate,'yyyymm')", rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), BONUS);   

				// 몇 행 작업을 처리중인지 보여주는 count 변수와 작업내용을 보여주는 sqlStr 출력
				System.out.println("디버깅 " +count + "row 처리 : " + sqlStr);
				
				stmt_ins.executeUpdate(sqlStr);

				count++;
			}

			// 디버깅 시간 측정을 위한 endTime 변수
			endTime = System.currentTimeMillis();

			// 디버깅 총 작업 시간 출력
			System.out.println("디버깅 경과 시간 : " + (endTime - startTime) + "ms");
			
			rs = stmt.executeQuery("SELECT COUNT(*) FROM BONUS_LARGE");

			if(rs.next()){
				String data = rs.getString(1);
				
				if(data.equals(rowNum) || data.equals(rowNum)){
					debugStatus = true;
					System.out.println("디버그 작업을 성공했습니다.");
					System.out.println("롤백합니다.");
					stmt_ins.execute("ROLLBACK");
				}else{
					debugStatus = false;
					System.out.println("디버그 작업 중 문제가 발생했습니다.");
					System.out.println("프로그램을 종료합니다.");
					stmt_ins.execute("ROLLBACK");
					return;
				}
			}
			


//////////////////////////////////////    디버깅 종료      /////////////////////////////////////////////////

			
			// 디버그 작업이 성공했을 때 작업이 시작함
			if(debugStatus){
			*/

				// SELECT 문을 보내 값을 ResultSet 변수에 받아온다
				queryText = String.format("SELECT EMPNO, JOB, DEPTNO, SAL FROM EMP_LARGE "
						+ "WHERE JOB NOT LIKE '%s'", "PRESIDENT");
				
				sqlStr = "INSERT INTO BONUS_LARGE(YYYYMM,EMPNO,JOB,DEPTNO,SAL,BONUS) "
						+ "VALUES(to_char(sysdate,'yyyymm'), ?, ?, ?, ?, ?)";   
				
			
				ResultSet rs = stmt.executeQuery(queryText);
				psmt = conn.prepareStatement(sqlStr);
	
				
				// 시간 측정을 위한 StartTime 변수
				startTime = System.currentTimeMillis();
				
				//SELECT 문으로 가져온 row를 한줄씩 반복해서 처리해준다.
				while (rs.next()) {
					// ResultSet 으로 가져온 2번째 값  JOB에 대한 값이 PRESIDENT 문자열이면 작업하지 않고 넘어간다
	//				if (rs.getString(2).equals("PRESIDENT")) {
	//					continue;
	//				}
	
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

					// BONUS_LARGE 테이블에 값을 저장하기 위한 Insert문 설정
					psmt.setString(1, rs.getString(1));
					psmt.setString(2, rs.getString(2));
					psmt.setString(3, rs.getString(3));
					psmt.setString(4, rs.getString(4));
					psmt.setInt(5, BONUS);
					
					
					// 몇 행 작업을 처리중인지 보여주는 count 변수와 작업내용을 보여주는 sqlStr 출력
					System.out.println(count + "row 처리 ");
	
					// 매번 객체 생성하는 것을 하지 않는다
	//				stmt_ins = conn.createStatement();
//					stmt_ins.executeUpdate(sqlStr);
//					commit 처리를 모든 작업이 끝나고 한번 수행하는 것으로 바꿔준다
//					stmt_ins.execute("COMMIT");
	//				stmt_ins.close();
					
					psmt.executeUpdate();
					psmt.clearParameters();
	
					count++;
				}
	//			 System.out.println(resultData);

				psmt.execute("COMMIT");
				psmt.close();
				// 시간 측정을 위한 endTime 변수
				endTime = System.currentTimeMillis();
	
				// 총 작업 시간 출력
				System.out.println("경과 시간 : " + (endTime - startTime) + "ms");
//			}
			
			
			// 작업이 끝난 후에 객체를 전부 종료해 준다
			rs.close();
//			stmt_ins.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
