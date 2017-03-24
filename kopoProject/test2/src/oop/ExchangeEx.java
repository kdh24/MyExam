package oop;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ExchangeEx {

	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("C:\\test\\exchange.csv");
			DataInputStream din = new DataInputStream(in);
			double result = 0.0;
			String ex[] = new String[2];
			int count = 0;

			while (din.available() > 0) {
				String str = din.readLine();
				String[] str2 = new String[10];

				str2 = str.split(",");

				ex[count] = str2[0];
				count++;
			}

			MoneyChangeClass testClass = new MoneyChangeClass();
			// testClass.exchange(10000, "USD");
			// System.out.println(testClass.exchange(10000, "USD"));
			result = testClass.exchange(1000, ex[0]);
			System.out.println(result);
			result = testClass.exchange(1000, ex[1]);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
