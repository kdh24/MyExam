package CalcBonusProject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Calc_Bonus_by_stmt_7_1 {
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
			CallableStatement cstmt = null;

			// 작업 처리를 위한 각종 변수 생성
			String resultData = "";
			String sqlStr = "";
			String queryText = "";
			long startTime = 0;
			long endTime = 0;
			int BONUS = 0;
			int count = 1;
			boolean debugStatus = false;

			// SELECT 문을 보내 값을 ResultSet 변수에 받아온다
//			queryText = String.format("SELECT EMPNO, JOB, DEPTNO, SAL FROM EMP_LARGE " + "WHERE JOB NOT LIKE '%s'",
//					"PRESIDENT");
			// INSERT 작업을 위한 sql문 설정
//			sqlStr = "INSERT INTO BONUS_LARGE(YYYYMM,EMPNO,JOB,DEPTNO,SAL,BONUS) "
//					+ "VALUES(to_char(sysdate,'yyyymm'), ?, ?, ?, ?, ?)";
			
			sqlStr = "DECLARE  "
					+ "CURSOR CUR_BONUS IS  SELECT EMPNO, JOB, DEPTNO, SAL FROM EMP_LARGE WHERE JOB NOT LIKE 'PRESIDENT';"
					+ "R_CUR_BONUS CUR_BONUS%ROWTYPE;"
					+ "D_BONUS NUMBER;"
					+ "V_COUNT NUMBER;"
					+ "SQL_CODE NUMBER;"
					+ "SQL_ERRM VARCHAR2(200);"
					+ "BEGIN "
					+ "OPEN CUR_BONUS;"
					+ "V_COUNT := 1;"
					+ "LOOP"
					+ " FETCH CUR_BONUS INTO R_CUR_BONUS;"
					+ "EXIT WHEN CUR_BONUS%NOTFOUND;"
					+ "CASE WHEN R_CUR_BONUS.DEPTNO >= 40 THEN D_BONUS := R_CUR_BONUS.SAL * 0.2;"
					+ "WHEN R_CUR_BONUS.DEPTNO >= 30 THEN D_BONUS := R_CUR_BONUS.SAL * 0.05;"
					+ "WHEN R_CUR_BONUS.DEPTNO >= 20 THEN D_BONUS := R_CUR_BONUS.SAL * 0.1;"
					+ "WHEN R_CUR_BONUS.DEPTNO >= 10 THEN D_BONUS := R_CUR_BONUS.SAL * 0.3;"
					+ ""
					+ "END CASE;"
					+ "INSERT INTO BONUS_LARGE(YYYYMM,EMPNO,JOB,DEPTNO,SAL,BONUS)"
					+ " VALUES(?, R_CUR_BONUS.EMPNO, R_CUR_BONUS.JOB, R_CUR_BONUS.DEPTNO, R_CUR_BONUS.SAL, D_BONUS);"
					+ "IF MOD(V_COUNT, 100) = 0"
					+ " THEN INSERT INTO DATA_LOGGING_TBL(PROGRAM_NAME, START_DATE, DATA_COUNT, NOTE)"
					+ " VALUES('BATCH 프로그램', SYSDATE, V_COUNT,  '기타');"
					+ "END IF;"
					+ "V_COUNT := V_COUNT+1;"
					+ "END LOOP;"
					+ "CLOSE CUR_BONUS;"
					+ "COMMIT;"
					+ "EXCEPTION"
					+ " WHEN OTHERS THEN"
					+ " SQL_ERRM:= SQLERRM;"
					+ "SQL_CODE:= SUBSTR(SQLCODE,1,200);"
					+ "INSERT INTO ERROR_LOG_TBL(ERROR_TIME, PROGRAM_NAME, ERROR_CODE, ERROR_MESSAGE, ETC)"
					+ " VALUES(SYSDATE, '프로그램 에러',SQL_CODE, SQL_ERRM, '비고');"
					+ "END;";
			
			
			
			
//   -- INSERT INTO BONUS_LARGE(DEPTNO) VALUES(1111);
        
//			ResultSet rs = stmt.executeQuery(queryText);
//			psmt = conn.prepareStatement(sqlStr);
			cstmt = conn.prepareCall(sqlStr);

			// 시간 측정을 위한 StartTime 변수
			startTime = System.currentTimeMillis();

			// SELECT 문으로 가져온 row를 한줄씩 반복해서 처리해준다.
//			while (rs.next()) {
				// ResultSet 으로 가져온 2번째 값 JOB에 대한 값이 PRESIDENT 문자열이면 작업하지 않고
				// 넘어간다
				// if (rs.getString(2).equals("PRESIDENT")) {
				// continue;
				// }

//				// ResultSet 으로 가져온 3번째 값 DEPTNO 에 따른 BONUS 처리
//				switch (rs.getString(3)) {
//				case "10":
//					BONUS = (int) (Integer.parseInt(rs.getString(4)) * 0.3);
//					break;
//				case "20":
//					BONUS = (int) (Integer.parseInt(rs.getString(4)) * 0.1);
//					break;
//				case "30":
//					BONUS = (int) (Integer.parseInt(rs.getString(4)) * 0.05);
//					break;
//				case "40":
//					BONUS = (int) (Integer.parseInt(rs.getString(4)) * 0.2);
//					break;
//				default:
//					break;
//				}

				// 중간 확인을 위해 보너스 값 출력
				// System.out.printf("월급 값 = %s\n", rs.getString(4));
				// System.out.printf("보너스의 값 = %d\n", BONUS);

				// ResultSet 값 각각의 값을 보기위한 중간 출력 변수
				// resultData += rs.getString(1) + "\t" + rs.getString(2) + "\t"
				// + rs.getString(3) + "\t" + rs.getString(4)
				// + "\t" + "\n";

				// BONUS_LARGE 테이블에 값을 저장하기 위한 Insert문
				// sqlStr = String.format("INSERT INTO
				// BONUS_LARGE(YYYYMM,EMPNO,JOB,DEPTNO,SAL,BONUS) "
				// + "VALUES(%s, '%s', '%s', '%s', '%s', '%s')",
				// "to_char(sysdate,'yyyymm')", rs.getString(1),
				// rs.getString(2), rs.getString(3),
				// rs.getString(4), BONUS);

//				// BONUS_LARGE 테이블에 값을 저장하기 위한 Insert문 설정
//				psmt.setString(1, rs.getString(1));
//				psmt.setString(2, rs.getString(2));
//				psmt.setString(3, rs.getString(3));
//				psmt.setString(4, rs.getString(4));
//				psmt.setInt(5, BONUS);
				
				
				// CallableStatement 사용?
				cstmt.setString(1, "201705");
				cstmt.execute();
				
				// 몇 행 작업을 처리중인지 보여주는 count 변수와 작업내용을 보여주는 sqlStr 출력
//				System.out.println(count + "row 처리 ");

				// 매번 객체 생성하는 것을 하지 않는다
				// stmt_ins = conn.createStatement();
				// stmt_ins.executeUpdate(sqlStr);
				// commit 처리를 모든 작업이 끝나고 한번 수행하는 것으로 바꿔준다
				// stmt_ins.execute("COMMIT");
				// stmt_ins.close();

				// 다수의 쿼리를 한번에 처리하기 위한 배치처리
//				psmt.addBatch();
				
//				// 모아서 처리하는 작업 횟수를 100번마다 한번씩으로 설정해준다.
//				if (count % 10 == 0) {
//					psmt.executeBatch();
////				}
//
//				psmt.clearParameters();
//				count++;
//			}
//			// System.out.println(resultData);
//
//			psmt.executeBatch();
//
//			psmt.execute("COMMIT");
//			psmt.close();
			// 시간 측정을 위한 endTime 변수
			endTime = System.currentTimeMillis();

			// 총 작업 시간 출력
			System.out.println("경과 시간 : " + (endTime - startTime) + "ms");

			// 작업이 끝난 후에 객체를 전부 종료해 준다
//			rs.close();
			// stmt_ins.close();
//			stmt.close();
			cstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
