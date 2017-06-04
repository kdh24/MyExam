package webPrograming.mysql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InsertPark {
	
	// Error 발생시 메세지 저장을 위한 Class 생성(에러 메세지, 에러발생 라인 정보 저장)
	public static class ErrorCheck{
		static String eMessage;
		static int eCount;
		// 에러 메세지를 가져와서 초기화해주는 생성자 부분
		ErrorCheck(String eMessage, int eCount){
			this.eMessage= eMessage;
			this.eCount= eCount;
		}
	}

	// 메인메소드 실행부분 예외처리를 throws를 이용해 java가 처리하게 만들었다
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// 드라이버 이름이 존재하는 클래스를 메모리에 동적으로 로딩
		Class.forName("com.mysql.jdbc.Driver");
		// 아이디와 패스워드, 접속 정보를 이용해서 Mysql DB에 연결해준다
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		// SQL문을 처리하기 위해 Statement 객체를 생성
		Statement stmt = conn.createStatement();

		// \은 특수문자이므로 \\ 두 개를 써야한다
		// 전국 주차장 표준데이터.txt 파일을 읽어온다
		File f = new File("C:\\test\\전국주차장표준데이터.txt");
		// 파일을 읽기 위한 버퍼 클래스 생성 및 선언
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		// ErrorCheck 클래스 사용을 위한 ArrayList 생성 및 선언
		ArrayList<ErrorCheck> alError = new ArrayList<>();

		// 버퍼 클래스를 이용해서 한줄씩 가져와 저장할 String 변수
		String readtxt;
		// Sql문을 저장할 String 변수
		String QueryTxt;

		// 한 줄을 먼저 읽어야 필드명을 알 수 있다.
		// 파일에서 읽어온 값이 없을 경우 빈 파일이라고 알려주고 종료
		if ((readtxt = br.readLine()) == null) {
			System.out.printf("빈 파일입니다.\n");
			return;
		}
		// 빈 파일이 아닐때 처음으로 가져온 값은 항목의 제목부분이므로 field_name 배열에 순차로 저장
		String[] field_name = readtxt.split("\t");

		// 반복 횟수를 알기위한 int 변수
		int LineCnt = 1;
		// 에러 발생 횟수를 체크하기 위한 int형 변수
		int eCnt=1;

		// 파일이 비어있지 않으면 가져와서 반복처리
		while ((readtxt = br.readLine()) != null) {
			try{
				// 탭(\t)을 구분자로 버퍼에서 가져온 한줄의 값(readtxt)를 field 배열에 나눠서 저장해준다
				String[] field = readtxt.split("\t");
				// 위도에 해당하는 field[31]의 값이 120을 넘으면 경도와 바뀐 것이기 때문에 서로 바꿔준다 
				if(Double.parseDouble(field[31]) > 120){
					String temp=null;
					temp = field[31].trim();
					field[31] = field[32].trim();
					field[32] = temp;
				}// 경도부분이 40보다 작으면 잘못된 값으로 판단해서 100을 더해준다
				if(Double.parseDouble(field[32]) < 40.0)
					field[32] = String.valueOf(Double.parseDouble(field[32]) + 100.0);
				
				// QueryTxt변수에 테이블에 insert 해주기 위한 sql문을 작성하고 각각의 컬럼에 대한 값은 각각 해당하는 field 값으로 넣어줘서 저장해준다
				QueryTxt = String.format("insert into parking(pId,pName,pCartegory,pType,pAdd1,"
										+ "pAdd2,pNum,pMoney, pAdminName, pAdminTel,"
										+ "plat,plng) values("
										+ "'%s','%s','%s','%s','%s',"
										+ "'%s',%d,'%s','%s','%s',"
										+ "%f,%f);",
										// 각각의 자료형에 맞춰서 해당하는 필드의 값들을 지정해서 넣어준다 
										field[0],field[1],field[2],field[3],field[4] == null? "":field[4].trim(),
										field[5],Integer.parseInt(field[6]),field[16],field[26],field[27],
										// 위도에 해당하는 부분은 field[31] 이고 field 길이가 31보다 크지 않다면 null 값으로 처리한다
										field.length > 31 ? Double.parseDouble(field[31]) : null,
												// 경도에 해당하는 부분은 field[32] 이고 field 길이가 32보다 크지 않다면 null 값으로 처리한다
												field.length > 32 ? Double.parseDouble(field[32]) : null);

				// QueryTxt 변수 안에 있는  sql문장을 DB로 보내어 테이블에 값을 넣어준다.
				stmt.execute(QueryTxt);
				// 예외가 발생하지 않고 정상적으로 실행되었을 때 몇번째 라인과 무슨 값이 정상처리 되었는지 출력해준다
				System.out.printf("%d번재 항목 Insert OK [%s]\n", LineCnt,QueryTxt );
			}catch(Exception e){ // 예외 발생시 처리부분
				// 예외 발생시 에러메세지 출력해서 확인 - 종료되지는 않는다
//				System.out.println(e.getMessage());
				// 에러 메세지 처리를 위한 ArrayList alError에 에러 메세지와 에러 발생한 라인수를 각각 저장해준다
				alError.add(new ErrorCheck(e.getMessage(), LineCnt));

				// 에러 발생 라인수 증가
				eCnt++;
			}
			// 한번 실행될때마다 반복횟수 증가
			LineCnt++;
		}
		
		// 에러 발생 크기만큼 반복처리해주는 for 반복문
		for(int i=0; i<alError.size(); i++){
			// 에러가 발생한 라인수와 해당하는 에러 발생 메세지를  화면에 출력해준다
			System.out.printf("에러 라인 수 : %d - 에러 메세지 : %s \n ",
					alError.get(i).eCount, alError.get(i).eMessage );
		}
		// 에러 발생 데이터 총 갯수 확인
		System.out.printf("에러 Data 총 갯수 : %d\n", eCnt);
		
		// Statement 객체 종료
		stmt.close();
		// Connection 객체 종료
		conn.close();
	}
}
