package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy1 {
	public static void main(String[] args) throws Exception{
		InputStream in = new FileInputStream("C:\\zzz\\apache-tomcat-8.0.41.exe");
		//없으면 새로, 있으면 덮어 쓴다.
		OutputStream out = new FileOutputStream("copy1.exe");
		
		long start = System.currentTimeMillis();
		
		//얼만지 몰라
		while(true){
			//읽어낸 한 바이트의 데이터는 int 값으로 나온다. <-- 1바이트의 쓰여있는 값
			//255값
			int data = in.read();
			
			if(data == -1){
				break;
			}
			
			out.write(data);
		}//end while
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
		
		in.close();
		out.close();
	}
}
