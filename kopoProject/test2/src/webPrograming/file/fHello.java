package webPrograming.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fHello {
	public static void main(String[] args) {
		try { // 예외 처리를 위한 try - catch 문
			// 파일 사용을 위한 File 클래스 파일경로와 파일명을 설정해준다.
			File f = new File("c:\\test\\Mytest.txt");
			// File을 쓰기위한 FileWriter
			FileWriter fw = new FileWriter(f);

			// "안녕 파일" 문자열을 파일안에 넣어준다.
			fw.write("안녕 파일\n");
			// "hello 헬로" 문자열을 파일안에 넣어준다.			
			fw.write("hello 헬로\n");

			// 파일쓰기 종료 후 FileWriter 클래스를 종료해준다
			fw.close();
			
			// 파일을 읽기위한 FileReader 클래스 선언 및 생성
			FileReader fr = new FileReader(f);
			
			// 읽어온 파일 수를 체크하는 변수
			int n = -1;
			// char형 변수 선언
			char [] ch;
			
			// 무한 반복
			while(true){
				// char형 배열 ch를 크기 100으로 생성 
				ch = new char[100];
				// 파일에서 읽어온 갯수를 변수 n에 넣어준다
				n = fr.read(ch);
				
				// 읽어온 값이 없으면 빠져나간다
				if(n==-1)break;
				
				// 읽어온 값만큼 반복
				for(int i=0;i<n; i++){
					// 읽어온 값으 내용을 화면에 출력
					System.out.printf("%c",ch[i]);
				}
			}
			// FileReader 클래스 반환
			fr.close();
			
			// 종료 표시
			System.out.printf("\n FILE READ END ");
		} catch (IOException e) {
			// 에러가 발생했을때 에러내용 출력
			System.out.printf("나 에러[%s]\n", e);
		}

	}
}
