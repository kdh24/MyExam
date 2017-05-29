package webPrograming.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec01 {
	public static void main(String[] args) throws IOException {
		// \은 특수문자이므로 \\ 두 개를 써야한다
		File f = new File("c:\\test\\전국무료와이파이표준데이터.csv");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;
		
		//한줄을 먼저 읽어야 필드명을 알 수 있다.
		if((readtxt=br.readLine())==null){
			System.out.printf("빈 파일입니다\n");
			return;
		}
		String[] field_name = readtxt.split(",");
		
		int LineCnt=0;
		while((readtxt=br.readLine())!=null){
			
			String[] field = readtxt.split(",");
			System.out.printf("**[%d번째 항목]******************\n", LineCnt);
			for(int j=0; j<field_name.length; j++){
				System.out.printf(" %s : %s\n", field_name[j], field[j]);
			}
			System.out.printf("*******************************\n");
			if(LineCnt==100)break;
			LineCnt++;
		}
		br.close();
	}
}
