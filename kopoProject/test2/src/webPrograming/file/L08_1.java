package webPrograming.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L08_1 {

	//파일 정제...
	public static void main(String[] args) throws IOException {
		// \은 특수문자이므로 \\ 두 개를 써야한다
		// 주식데이터가 들어있는 파일을 가져와서 처리하기 위한 File 클래서 선언부
		File f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
		BufferedReader br = new BufferedReader(new FileReader(f));
		// 데이터를 저장하기 위한 File 클래스 선언부
		File f1 = new File("c:\\test\\A005930.csv");
		BufferedWriter bw1=new BufferedWriter(new FileWriter(f1));
		// 한줄씩 가져와 저장하기 위한 변수
		String readtxt;
		// 반복횟수를 저장하기 위한 int형 변수
		int cnt = 0; int wcnt=0;
		// 한줄의 내용을 readtxt 변수에 가져와 null값이 아니면 실행한다
		while((readtxt=br.readLine())!= null){
			// StringBuffer 선언 및 생성
			StringBuffer s = new StringBuffer();
			// 한줄의 내용을 %_% 구분자로 나눠서 field 배열에 가져온다
			String[] field = readtxt.split("%_%");
			// field의 길이가 2보다 크고, 3번째 값에서 ^와 공백을 없애고 삼성코드(A005930)인지 확인하는 if문
			if(field.length>2&&field[2].replace("^", "").trim().substring(0,7).equals("A005930")){
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
		// 자원 반환
		br.close();
		bw1.close();

		// 종료하고 전체 반복횟수 , 비교대상 반복횟수 출력
		System.out.printf("Program End[%d][%d]records\n", cnt, wcnt);
	}

}
