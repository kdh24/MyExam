package webPrograming.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L08_3 {

	//파일 정제...
	public static void main(String[] args) throws IOException {
		// \은 특수문자이므로 \\ 두 개를 써야한다
		// 주식데이터가 들어있는 파일을 가져와서 처리하기 위한 File 클래서 선언부
		File f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
		BufferedReader br = new BufferedReader(new FileReader(f));
		// 데이터를 저장하기 위한 File 클래스 선언부
		File f1 = new File("c:\\test\\Sam_2015_2.csv");
		BufferedWriter bw1=new BufferedWriter(new FileWriter(f1));
		// 한줄씩 가져와 저장하기 위한 변수
		String readtxt;
		// 최대, 최소값 저장을 위한 변수
		int sMax=0;
		int sMin=0;
		String MaxDay="";
		String MinDay="";
		// 반복 횟수 처리를 위한 
		int cnt = 0; int wcnt=0;
		// 한줄의 내용을 readtxt 변수에 가져와 null값이 아니면 실행한다
		while((readtxt=br.readLine())!= null){
			// StringBuffer 선언 및 생성
			StringBuffer s = new StringBuffer();
			// 한줄의 내용을 %_% 구분자로 나눠서 field 배열에 가져온다
			String[] field = readtxt.split("%_%");
			
//			상품코드가 삼성전자(A005930)이고, 2015년도 데이터인지 확인하는  if문
			if(field.length>2&&field[2].replace("^", "").trim().substring(0,7).equals("A005930")
					&& field[1].replace("^", "").trim().substring(0,4).equals("2015")){
				// 비교를 처음 할때 (wcnt == 0) 실행하는 부분
				if(wcnt == 0){
					// 필드의 4번째 값에 ^표시와 공백을 제거해서 최대, 최소값을 변수에 대입해준다
					sMax = Integer.parseInt(field[3].replace("^", "").trim());
					sMin = Integer.parseInt(field[3].replace("^", "").trim());
				}else{ // 비교가 처음이 아닐때 실행
					// 최대값 변수보다 필드에서 가져온 값이 더 크면 다시 대입해준다
					if (sMax < Integer.parseInt(field[3].replace("^", "").trim())){
						sMax = Integer.parseInt(field[3].replace("^", "").trim());
						MaxDay = field[1].trim().replace("^", "");
					}
					// 최소값 변수보다 필드에서 가져온 값이 더 작으면 다시 대입해준다
					if (sMin > Integer.parseInt(field[3].replace("^", "").trim())){
						sMin = Integer.parseInt(field[3].replace("^", "").trim());
						MinDay = field[1].trim().replace("^", "");
					}
				}
				// 제일 처음 s 버퍼에 필드 첫번째 값을 ^와 공백을 제거해서 추가해준다
				s.append(field[0].replace("^", "").trim());
				// 필드의 길이만큼 반복하는 for 반복문
				for(int j=1; j<field.length; j++){
					// 처음 이후 s 버퍼에 필드 j번째 값을 ,를 붙이고  ^와 공백을 제거해서 추가해준다
					s.append(","+field[j].replace("^", "").trim());
				}
				// 파일에 써주고 줄 바꿈 처리해준다
				bw1.write(s.toString());bw1.newLine();
				// 비교대상일 때 반복횟수 증가 
				wcnt++;
				// 전체 반복횟수, 비교대상횟수, 내용 출력
				System.out.printf("write [%d][%d][%s]\n", cnt,wcnt,s.toString());
			}
			// 전체 반복횟수 증가
			cnt++;
		}
		// 삼성 주가의 최대, 최소값 출력
		System.out.println("삼성주가 15년 최대값 : " + sMax + " 날짜 : " + MaxDay);
		System.out.println("삼성주가 15년 최소값 : " + sMin + " 날짜 : " + MinDay);
		// 자원 반환
		br.close();bw1.close();
		// 종료하고 전체 반복 횟수, 비교대상에 포함되어 반복한 횟수를 출력해준다
		System.out.printf("Program End[%d][%d]records\n", cnt, wcnt);
	}

}
