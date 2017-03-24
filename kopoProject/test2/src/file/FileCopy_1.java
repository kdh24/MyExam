package file;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileCopy_1 {
	public static void main(String[] args){
//		int sum=0;
		try {
			InputStream in = new FileInputStream("C:\\zzz\\input.csv");
			DataInputStream din = new DataInputStream(in);
			
			while(din.available() > 0){
				String value = din.readLine();
				String[] split = value.split(",");
				System.out.println("원래 값" + value);
				System.out.println("split[0] 값" + split[0]);
				System.out.println("split[1] 값" + split[1]);
				System.out.println("split[2] 값" + split[2]);
	//			int data = Integer.parseInt(value);
	//			sum = sum + data;
			}
	//		System.out.println(sum);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//없으면 새로, 있으면 덮어 쓴다.
	/*//	OutputStream out = new FileOutputStream("copy1.exe");
		
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
		out.close();*/
	}
}
