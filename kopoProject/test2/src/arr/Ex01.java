package arr;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class Ex01 {

	public static void main(String[] args) {

		try {
			InputStream in = new FileInputStream("C:\\test\\goods.csv");
			DataInputStream din = new DataInputStream(in);
			int count=0;
			
			while (din.available() > 0) {
				String str;
				String[] str2 = new String[10];
				str = din.readLine();
				if(count == 0 && str != null){
					System.out.println("==================  상품 리스트  ==================");
					count++;
				}
				str2 = str.split(",");
				
				for (int i = 0; i < str2.length; i++) {
					if (str2[i] != null) {
						System.out.print(str2[i] + " ");
					}
				}
				System.out.println();
			}
			in.close();
			din.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
