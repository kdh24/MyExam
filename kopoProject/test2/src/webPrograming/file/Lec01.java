package webPrograming.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec01 {
	public static void main(String[] args) throws IOException {// 예외 처리를 위한 throws 자바에게 예외처리 부분을 넘겨준다
		// \은 특수문자이므로 \\ 두 개를 써야한다
		File f = new File("c:\\test\\전국무료와이파이표준데이터.csv");
		// 버퍼를 이용해 파일을 읽어오기 위한 BufferedReader 클래스 생성 및 선언
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		// 문자열 readtxt 선언
		String readtxt;
		
		//한줄을 먼저 읽어야 필드명을 알 수 있다.
		// BufferedReader를 한줄씩 가져와서 readtxt 변수에 넣어주고 null 값인지 비교해서 null이면 빈 파일이라고 출력해준다
		if((readtxt=br.readLine())==null){
			System.out.printf("빈 파일입니다\n");
			return;
		}
		// 버퍼를 이용해 가져온 값(첫번째 줄의 값)을 구분자 콤마(,)로 나누어서 String 배열 field_name에 넣어준다
		String[] field_name = readtxt.split(",");

		// 라인수를 계산하기 위한 int 변수 선언
		int LineCnt=0;
		// BufferedReader를 한줄씩 가져와서 readtxt 변수에 넣어주고 null 값인지 비교해서 아니면 반복
		while((readtxt=br.readLine())!=null){
			// 버퍼를 이용해 가져온 값을 구분자 콤마(,)로 나누어서 String 배열 field에 넣어준다
			String[] field = readtxt.split(",");
			// LineCnt 변수를 이용해 몇번째 값을 처리중인지 화면에 출력
			System.out.printf("**[%d번째 항목]******************\n", LineCnt);
			// 첫번째 줄의 값을 가지고 있는 field_name 배열의 크기를 이용해서 그 크기만큼 반복처리
			for(int j=0; j<field_name.length; j++){
				// 첫줄(field_name 항목값)과 이어서 가져온 각 항목들의 내용을 가져와 화면에 출력해준다 
				System.out.printf(" %s : %s\n", field_name[j], field[j]);
			}
			System.out.printf("*******************************\n");
			// 반복해서 처리한 횟수가 100이 넘으면 멈춰준다
			if(LineCnt==100)break;
			// 라인수를 계산하기 위한 LineCnt 변수 증가
			LineCnt++;
		}
		// 버퍼 클래스 자원 반환
		br.close();
	}
}
