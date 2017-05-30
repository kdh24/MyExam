package webPrograming.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L08_3 {

	//파일 정제...
	public static void main(String[] args) throws IOException {
		// \은 특수문자이므로 \\ 두 개를 써야한다
		File f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		File f1 = new File("c:\\test\\Sam_2015_2.csv");
		BufferedWriter bw1=new BufferedWriter(new FileWriter(f1));
		
		String readtxt;
		int sMax=0;
		int sMin=0;
		
		int cnt = 0; int wcnt=0;
		while((readtxt=br.readLine())!= null){
			StringBuffer s = new StringBuffer();
			String[] field = readtxt.split("%_%");
			
//			System.out.println(field[3].replace("^", "").trim());
			if(field.length>2&&field[2].replace("^", "").trim().substring(0,7).equals("A005930")
					&& field[1].replace("^", "").trim().substring(0,4).equals("2015")){
				if(wcnt == 0){
					sMax = Integer.parseInt(field[3].replace("^", "").trim());
					sMin = Integer.parseInt(field[3].replace("^", "").trim());
					System.out.printf("********************************************************");
					System.out.printf("최대 : %s 최소 : %s", sMax, sMin);
				}else{
					if (sMax < Integer.parseInt(field[3].replace("^", "").trim()))
						sMax = Integer.parseInt(field[3].replace("^", "").trim());
					if (sMin > Integer.parseInt(field[3].replace("^", "").trim()))
						sMin = Integer.parseInt(field[3].replace("^", "").trim());
				}
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
		System.out.println("삼성주가 15년 최대값 : " + sMax);
		System.out.println("삼성주가 15년 최소값 : " + sMin);
		
		br.close();
		bw1.close();

		System.out.printf("Program End[%d][%d]records\n", cnt, wcnt);
	}

}
