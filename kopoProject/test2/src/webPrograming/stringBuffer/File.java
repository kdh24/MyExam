package webPrograming.stringBuffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class File {
	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("c:\\test\\a.txt", true); 
		// 저장하고자 하는 파일이름(필요한 경로도 써라)과 중복시 덮어쓰기 유무
		
		BufferedWriter bw = new BufferedWriter(fw);
		StringBuffer sf = new StringBuffer();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while(!(str=br.readLine()).startsWith("s"))
			sf.append(str+"\n");	// 스트링버퍼에 한줄씩 읽어 기록한다.
		
		br.close();		// 자원해제
		fw.write(sf.toString());	// 스트링버퍼를 스트링형으로 변환하여 기록한다.
		fw.flush();
		fw.close();		// 자원을 해제한다.
		System.out.println("저장이 완료되었습니다.");
		
		
		
	}
}
