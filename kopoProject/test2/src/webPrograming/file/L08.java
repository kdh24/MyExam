package webPrograming.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L08 {

	//���� ����...
	public static void main(String[] args) throws IOException {
		// \�� Ư�������̹Ƿ� \\ �� ���� ����Ѵ�
		File f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		File f1 = new File("c:\\test\\StockDailyPrice.csv");
		BufferedWriter bw1=new BufferedWriter(new FileWriter(f1));
		
		String readtxt;
		
		int cnt = 0; int wcnt=0;
		while((readtxt=br.readLine())!= null){
			StringBuffer s = new StringBuffer();
			String[] field = readtxt.split("%_%");
			
			if(field.length>2&&field[2].replace("^", "").trim().substring(0, 1).equals("A")){
				s.append(field[0].replace("^", "").trim());
				for(int j=1; j<field.length; j++){
					s.append(","+field[j].replace("^", "").trim());
				}
				bw1.write(s.toString());bw1.newLine();
				wcnt++;
				System.out.printf("write [%d][%d][%s]\n", cnt,wcnt,s.toString());
			}
			cnt++;
		}
		
		br.close();
		bw1.close();

		System.out.printf("Program End[%d][%d]records\n", cnt, wcnt);
	}

}
