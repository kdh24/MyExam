package webPrograming.stringBuffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class File {
	public static void main(String[] args) throws Exception {
		// 파일에 저장하기 위한 FileWriter 클래스 생성 및 선언
		FileWriter k07_fw = new FileWriter("c:\\test\\a.txt", true); 
		// 저장하고자 하는 파일이름(필요한 경로도 써라)과 중복시 덮어쓰기 유무
		
		// StringBuffer를 사용하기 위해서 각각의 변수를 생성 및 선언해준다
		BufferedWriter k07_bw = new BufferedWriter(k07_fw);
		StringBuffer k07_sf = new StringBuffer();
		
		//사용자가 입력하는 값을 파일에 쓰기위해 BufferedReader 클래스 사용
		BufferedReader k07_br = new BufferedReader(new InputStreamReader(System.in));
		// 입력받은 문자열을 저장하기 위한 str 변수
		String k07_str = "";
		// 사용자가 입력한 문자열을 str 변수에 저장하고  해당 값이 소문자 s가 아니면 반복적으로 입력받아
		// StringBuffer에 추가해준다
		while(!(k07_str=k07_br.readLine()).startsWith("s"))
			k07_sf.append(k07_str+"\n");	// 스트링버퍼에 한줄씩 읽어 기록한다.
		
		k07_br.close();		// 자원해제
		// 문자열을 입력받아 StringBuffer에 저장해주었던 값들을 파일에 넣어준다
		k07_fw.write(k07_sf.toString());	// 스트링버퍼를 스트링형으로 변환하여 기록한다.
		k07_fw.flush();
		k07_fw.close();		// 자원을 해제한다.
		// 저장 완료 표시
		System.out.println("저장이 완료되었습니다.");
	}
}
