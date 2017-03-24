package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy2 {
	public static void main(String[] args) throws Exception{
		InputStream in = new FileInputStream("C:\\zzz\\apache-tomcat-8.0.41.exe");
		//없으면 새로, 있으면 덮어 쓴다.
		OutputStream out = new FileOutputStream("copy2.exe");
		
		//바가지 --> buffer
		byte[] buffer = new byte[1024*8];
		
		long start = System.currentTimeMillis();
		
		while(true){
			//데이터는 바가지 몇 개나 새로운 데이터를 읽었는지.
			//a b c d e -- f g h i j -- k l m j
			int count = in.read(buffer);
			//바가지에 새로운 데이터가 없다. 다 읽었다.
			if(count == -1){
				break;
			}//end if
			
			out.write(buffer, 0, count);
			
		}// end while
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
		
		in.close();
		out.close();
		
	}
}
