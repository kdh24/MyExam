package CalcBonusProject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Calc_Bonus_by_stmt_7 {
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

			sqlStr = "DECLARE  "
					+ "CURSOR CUR_BONUS IS  SELECT EMPNO, JOB, DEPTNO, SAL FROM EMP_LARGE WHERE JOB NOT LIKE 'PRESIDENT';"
					+ "R_CUR_BONUS CUR_BONUS%ROWTYPE;" + "D_BONUS NUMBER;" + "V_COUNT NUMBER;" + "SQL_CODE NUMBER;"
					+ "SQL_ERRM VARCHAR2(200);" + "BEGIN " + "OPEN CUR_BONUS;" + "V_COUNT := 1;" + "LOOP"
					+ " FETCH CUR_BONUS INTO R_CUR_BONUS;" + "EXIT WHEN CUR_BONUS%NOTFOUND;"
					+ "CASE WHEN R_CUR_BONUS.DEPTNO >= 40 THEN D_BONUS := R_CUR_BONUS.SAL * 0.2;"
					+ "WHEN R_CUR_BONUS.DEPTNO >= 30 THEN D_BONUS := R_CUR_BONUS.SAL * 0.05;"
					+ "WHEN R_CUR_BONUS.DEPTNO >= 20 THEN D_BONUS := R_CUR_BONUS.SAL * 0.1;"
					+ "WHEN R_CUR_BONUS.DEPTNO >= 10 THEN D_BONUS := R_CUR_BONUS.SAL * 0.3;" + "" + "END CASE;"
					+ "INSERT INTO BONUS_LARGE(YYYYMM,EMPNO,JOB,DEPTNO,SAL,BONUS)"
					+ " VALUES(?, R_CUR_BONUS.EMPNO, R_CUR_BONUS.JOB, R_CUR_BONUS.DEPTNO, R_CUR_BONUS.SAL, D_BONUS);"
					+ "IF MOD(V_COUNT, 100) = 0"
					+ " THEN INSERT INTO DATA_LOGGING_TBL(PROGRAM_NAME, START_DATE, DATA_COUNT, NOTE)"
					+ " VALUES('BATCH 프로그램', SYSDATE, V_COUNT,  '기타');" + "END IF;" + "V_COUNT := V_COUNT+1;"
					+ "END LOOP;" + "CLOSE CUR_BONUS;" + "COMMIT;" + "EXCEPTION" + " WHEN OTHERS THEN"
					+ " SQL_ERRM:= SQLERRM;" + "SQL_CODE:= SUBSTR(SQLCODE,1,200);"
					+ "INSERT INTO ERROR_LOG_TBL(ERROR_TIME, PROGRAM_NAME, ERROR_CODE, ERROR_MESSAGE, ETC)"
					+ " VALUES(SYSDATE, '프로그램 에러',SQL_CODE, SQL_ERRM, '비고');" + "END;";
			
			// 작업 처리를 위한 Statement 객체  생성
			cstmt = conn.prepareCall(sqlStr);

			// 시간 측정을 위한 StartTime 변수
			startTime = System.currentTimeMillis();

			// CallableStatement 에 저장된 sql위치에 값을 할당해준다
			cstmt.setString(1, "201705");
			cstmt.execute();

			// 시간 측정을 위한 endTime 변수
			endTime = System.currentTimeMillis();

			// 총 작업 시간 출력
			System.out.println("경과 시간 : " + (endTime - startTime) + "ms");

			// 작업이 끝난 후에 객체를 전부 종료해 준다
			cstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
