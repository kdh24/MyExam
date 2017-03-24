package oop;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class MoneyChangeClass {
	public double exchange(double won, String targetName) {
		double result = 0;
		
		InputStream in;
		try {
			in = new FileInputStream("C:\\test\\exchange.csv");

			DataInputStream din = new DataInputStream(in);
			double[] currency = new double[100];
			String[] name = new String[100];
			int number = 0;
			
			while (din.available() > 0) {
				String temp = din.readLine();
				String[] temp_curr = new String[3];
				temp_curr = temp.split(",");

				name[number] = temp_curr[0];
				currency[number] = Double.parseDouble(temp_curr[1]);
				number++;
			}
			for(int i=0; i<number; i++){
				if(name[i].equals(targetName) == true){
					result = won / currency[i];
					break;
				}
			}

			in.close();
			din.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
