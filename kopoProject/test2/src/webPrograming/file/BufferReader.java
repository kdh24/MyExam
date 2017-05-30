package webPrograming.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferReader {
	public static void FileWrite() throws IOException { // 예외 처리를 위한 throws 자바에게 예외처리 부분을 넘겨준다
		// 파일 사용을 위한 File 클래스 파일경로와 파일명을 설정해준다.
		File f = new File("c:\\test\\BMytest.txt");
		// BufferedWriter 효율적인 문자열 저장을 위한 BufferedWriter 사용 선언 및 생성
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		// 버퍼를 이용해 문자열 저장
		bw.write("안녕 파일");
		// 버퍼에 줄바꿈 처리
		bw.newLine();
		// 버퍼를 이용해 문자열 저장		
		bw.write("hello 헬로");
		// 버퍼에 줄바꿈 처리		
		bw.newLine();
		
		// 버퍼 클래스를 종료해준다
		bw.close();
		
	}
	public static void FileRead() throws IOException { // 파일 읽기 위한 메소드  예외처리를 위한 throws
		// 파일 사용을 위한 File 클래스 파일경로와 파일명을 설정해준다.		
		File f =new File("c:\\test\\BMytest.txt");
		// BufferedReader 효율적으로 문자열을 읽어오기 위한 BufferedReader 사용 선언 및 생성
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		// 문자열 readtxt 변수 선언
		String readtxt;
		
		// BufferedReader를 한줄씩 가져와서 readtxt 변수에 넣어주고 null 값인지 비교해서 아니면 반복
		while((readtxt=br.readLine())!=null){
			// 가져온 문자열의 내용을 화면에 출력해준다
			System.out.printf("%s\n", readtxt);
		}
		// 버퍼 클래스를 종료해준다
		br.close();
	}
	
	public static void main(String[] args) throws IOException {
		FileWrite();	// 파일을 쓰기 위한 메소드 호출
		FileRead();		// 파일을 읽기 위한 메소드 호출
	}
}
