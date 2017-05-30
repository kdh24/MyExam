package webPrograming.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class L07 {

	public static void main(String[] args) throws IOException {
		File f= new File("C:\\test\\day_data\\THTSKS010H00.dat");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;
		int LineCnt=0;
		int n=-1;
		StringBuffer s = new StringBuffer();
		while(true){
			char[] ch = new char[1000];
			
			n = br.read(ch);
			
			if(n==-1)break;
			
			for(char c:ch){
				if(c=='\n'){
					System.out.printf("[%s]***\n", s.toString());
					s.delete(0, s.length());
				}else{
					s.append(c);
				}
					
			}
			
			LineCnt++;
		}
		System.out.printf("[%s]***\n",s.toString());
		br.close();
	}

}
