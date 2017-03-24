package test_0323;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileOutput {

	public double exchange(int won, String targetName) {

		double result=0.0;
		try {
			InputStream in = new FileInputStream("C:\\JavaEx\\input.csv");
			DataInputStream din = new DataInputStream(in);

			String[] country = new String[10];
			double[] currency = new double[10];
			int number = 0;

			while (din.available() > 0) {
				String str = din.readLine();
				String[] str2 = str.split(",");

				country[number] = str2[0];
				currency[number] = Double.parseDouble(str2[1]);
				number++;
			}
			
			for(int i=0; i<number; i++){
				if(country[i].equals(targetName) == true){
					result = won * currency[i];
					System.out.println(won + " " + currency[i]);
					break;
				}
			}
			
			in.close();
			din.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
}
