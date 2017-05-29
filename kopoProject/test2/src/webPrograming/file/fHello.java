package webPrograming.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fHello {
	public static void main(String[] args) {
		try {
			File f = new File("c:\\test\\Mytest.txt");
			FileWriter fw = new FileWriter(f);

			fw.write("¾È³ç ÆÄÀÏ\n");
			fw.write("hello Çï·Î\n");

			fw.close();
			
			FileReader fr = new FileReader(f);
			
			int n = -1;
			char [] ch;
			
			while(true){
				ch = new char[100];
				n = fr.read(ch);
				
				if(n==-1)break;
				
				for(int i=0;i<n; i++){
					System.out.printf("%c",ch[i]);
				}
			}
			fr.close();
			
			System.out.printf("\n FILE READ END ");
		} catch (IOException e) {
			System.out.printf("³ª ¿¡·¯[%s]\n", e);
		}

	}
}
