package arr;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ArrayTestClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			OutputStream out = new FileOutputStream("C:\\test\\output.csv");
	 		DataOutputStream dout = new DataOutputStream(out);
	 		// 파일 불러오기 선언
	 		InputStream in = new FileInputStream("C:\\test\\input.csv");
	 		DataInputStream din = new DataInputStream(in);
	 		
			int[][] score = new int[100][20];
			int number = 1;
			int question = 0;
			int count = 0;
			Scanner myInput = new Scanner(System.in);

//			System.out.println("몇과목 인가요? ");
//			count= myInput.nextInt();
			count = 3;
			
			// 파일에서 불러오기
			while(din.available() > 0) {
				String str;
				String[] str2 = new String[10];
				str = din.readLine();
				str2 = str.split(",");
				for(int i=0;i<count;i++) {
					score[number][i] = Integer.parseInt(str2[i]);
					System.out.print(score[number][i] + " ");
				}
				number++;
			}
			do {
	 			// 콘솔에서 데이터 입력
				System.out.println(number + "번 학생의");
				
				for(int i=0;i<count;i++){
					System.out.println( (i+1) + "과목 점수는 몇접입니까? ");
		     		score[number][i] = myInput.nextInt();
		     		// 총점
					score[number][count] = score[number][count] + score[number][i];
				}
				// 평균
				score[number][count+1] = score[number][count] / count;
						
	     		number++;
	     		
	     		// 재입력 물어보기
	     		System.out.println("계속 입력하시겠습니까? (1:Yes, 2:No) ");
	     		question = myInput.nextInt();
	     	} while(question != 2);
			
			String dataStr;
			// 출력
			for(int i=1;i<number;i++){
				for(int j=0;j<count + 2;j++){
					System.out.print(score[i][j] + "\t");
					// 파일로 데이터 출력
	         		dataStr = score[i][j] + ","; 
	         		out.write(dataStr.getBytes());
				}
				System.out.println();
				dataStr = "\n"; 
         		out.write(dataStr.getBytes());
			}
		}catch(Exception e) {
			
		}
		
	}
}
