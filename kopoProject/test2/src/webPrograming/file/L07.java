package webPrograming.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class L07 {
	public static void main(String[] args) throws IOException {
		// 주식데이터가 들어있는 파일을 가져와서 처리하기 위한 File 클래서 선언부
		File f= new File("C:\\test\\day_data\\THTSKS010H00.dat");
		// BufferedReader 클래스를 이용해 파일내용 처리해준다
		BufferedReader br = new BufferedReader(new FileReader(f));

		String readtxt;
		// 반복횟수 처리 변수
		int LineCnt=0;
		// 값이 있는지 확인하기 위한 변수
		int n=-1;
		// StringBuffer 클래스 선언 및 생성
		StringBuffer s = new StringBuffer();
		// 무한 루프를 돌려준다
		while(true){
			// char 형 배열을 1000개를 저장할 수 있는 공간만큼 생성
			char[] ch = new char[1000];
			// ch 배열의 크기만큼 가져와서 n형으로 저장해준다
			n = br.read(ch);
			// 가져온 값이 없으면 중지
			if(n==-1)break;
			// char 형으로 가져온 ch의 값을 char형 변수 c로 하나씩 가져와서 반복처리해준다
			for(char c:ch){
				// 변수 c가 엔터이면 버퍼 s에 저장한 값들을 화면에 출력
				if(c=='\n'){
					System.out.printf("[%s]***\n", s.toString());
					// 출력하고 s버퍼를 지워준다
					s.delete(0, s.length());
				}else{ // s 버퍼에 c의 값들을 저장해준다
					s.append(c);
				}
			}
			//횟수 증가
			LineCnt++;
		}// 마지막 작업을 화면에  표시
		System.out.printf("[%s]***\n",s.toString());
		br.close();
	}

}
