package arr;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class Ex02 {

	public static void main(String[] args) {

		try {
			InputStream in = new FileInputStream("C:\\test\\goods.csv");
			DataInputStream din = new DataInputStream(in);
			String[] goods_name = new String[100];
			int[] goods_price = new int[100];
			int[] goods_count = new int[100];
			int count=0;
			
			while (din.available() > 0) {
				String str;
				String[] str2 = new String[10];
				str = din.readLine();
				str2 = str.split(",");
				if(str != null){
					if(count == 0)
						System.out.println("==================  상품 리스트  ==================");
					goods_name[count] = str2[0];
					goods_price[count] = Integer.parseInt(str2[1]);
					goods_count[count] = Integer.parseInt(str2[2]);
					count++;
				}
				
				for (int i = 0; i < str2.length; i++) {
					if (str2[i] != null) {
						System.out.print(str2[i] + " ");
					}
				}
				System.out.println();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
