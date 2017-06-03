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

public class DistancePark {
	
	public static class ErrorCheck{
		static String eMessage;
		static int eCount;
//		String eName;
		
		ErrorCheck(String eMessage, int eCount){
			this.eMessage= eMessage;
			this.eCount= eCount;
//			this.eName= eName;
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/kdh24?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();

		// \은 특수문자이므로 \\ 두 개를 써야한다
		File f = new File("C:\\test\\전국주차장표준데이터.txt");
		// 파일을 읽이 위한 버퍼 클래스 생성 및 선언
		BufferedReader br = new BufferedReader(new FileReader(f));
		

		ArrayList<ErrorCheck> alError = new ArrayList<>();

		// 버퍼 클래스를 이용해서 한줄씩 가져와 저장할 String 변수
		String readtxt;
		String QueryTxt;

		// 한 줄을 먼저 읽어야 필드명을 알 수 있다.
		// 파일에서 읽어온 값이 없을 경우 빈 파일이라고 알려준다
		if ((readtxt = br.readLine()) == null) {
			System.out.printf("빈 파일입니다.\n");
			return;
		}
		// 빈 파일이 아닐때 처음으로 가져온 값은 항목의 제목부분이므로 field_name 배열에 순차로 저장
		String[] field_name = readtxt.split("\t");

		// 융합기술 우리집 위도경도, 지도에서 알아보기
		double k07_lat = 37.3860521;
		double k07_lng = 127.1214038;
		// 최대 거리 최소거리 변수
		double distMax=0.0;
		double distMin=0.0;
		double dist=0.0;
		String[] MaxInfo = new String[3];
		String[] MinInfo = new String[3];

		// 반복 횟수를 알기위한 int 변수
		int LineCnt = 1;
		int eCnt=0;

		// 파일이 비어있지 않으면 가져와서 반복처리
		while ((readtxt = br.readLine()) != null) {
			// 탭(\t)을 구분자로 버퍼에서 가져온 한줄의 값(readtxt)를 field 배열에 나눠서 저장해준다
			try{
				String[] field = readtxt.split("\t");
					
				QueryTxt = String.format("insert into parking(pId,pName,pCartegory,pType,pAdd1,"
															+ "pAdd2,pNum,pMoney, pAdminName, pAdminTel,"
															+ "plat,plng) values("
																	+ "'%s','%s','%s','%s','%s',"
																	+ "'%s',%d,'%s','%s','%s',"
																	+ "%f,%f);",
																	field[0],field[1],field[2],field[3],field[4] == null? "":field[4].trim(),
																	field[5],Integer.parseInt(field[6]),field[16],field[26],field[27],
																	field.length > 31 ? Double.parseDouble(field[31]) : 0.0, field.length > 32 ? Double.parseDouble(field[32]) : 0.0);
				stmt.execute(QueryTxt);
				System.out.printf("%d번재 항목 Insert OK [%s]\n", LineCnt,QueryTxt );
				if(field.length > 31 || !(field[31].trim().equals("") || field[31].trim().equals(""))){
					dist = Math.sqrt(Math.pow(Double.parseDouble(field[31]) - k07_lat, 2)
							+ Math.pow(Double.parseDouble(field[32]) - k07_lng, 2));
					if(LineCnt == 1){
						distMax = dist;
						distMin = dist;
					}else{
						if(distMax < dist){
							distMax = dist;
							MaxInfo[0] = field[0];
							MaxInfo[1] = field[1];
							MaxInfo[2] = field[4];
						}
						if(distMin > dist){
							distMin = dist;
							MinInfo[0] = field[0];
							MinInfo[1] = field[1];
							MinInfo[2] = field[4];
						}
					}
				}
			}catch(Exception e){
//				System.out.println(e.getMessage());
				
				alError.add(new ErrorCheck(e.getMessage(), LineCnt));
				if(e.getMessage().equals("empty String"))
					System.out.println(LineCnt + " " + readtxt);
//				alError.add(new ErrorCheck(e.getMessage(), LineCnt));
				eCnt++;
			}
			// 한번 실행될때마다 반복횟수 증가
			LineCnt++;
		}
		
//		for(int i=0; i<alError.size(); i++){
//			System.out.printf("에러 라인 수 : %d - 에러 메세지 : %s \n ", alError.get(i).eCount, alError.get(i).eMessage );
//		}
		System.out.printf("에러 Data 총 갯수 : %d\n", eCnt);
		
		System.out.println("제일 가까운 거리 : " + distMin);
		System.out.printf("제일 가까운 주차장  관리번호 : %s  \n 주차장명 : %s  \n 주차장주소 : %s \n", MinInfo[0], MinInfo[1], MinInfo[2]);
		System.out.println("제일 먼 거리 : " + distMax);
		System.out.printf("제일 가까운 주차장  관리번호 : %s  \n 주차장명 : %s  \n 주차장주소 : %s \n", MaxInfo[0], MaxInfo[1], MaxInfo[2]);
		
		stmt.close();
		conn.close();
	}
}
