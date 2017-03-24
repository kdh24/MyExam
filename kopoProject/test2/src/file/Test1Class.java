package file;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Test1Class {

	public static void main(String[] args) {
		
		int[] score = new int[100];
		String[] name = new String[100];
		
		try {
			OutputStream out = new FileOutputStream("C:\\test\\output.csv");
			DataOutputStream dout = new DataOutputStream(out);
			Scanner myInput = new Scanner(System.in);
//			String name;
			int scoreKor, scoreEng, loopCheck =1;
			String dataStr;
			
			do{
				// 콘솔에서 데이터 입력
				System.out.println("이름을 입력하세요(영어로) : ");
				name[0] = myInput.next();
				System.out.println("국어 점수를 입력하세요 : ");
				scoreKor = myInput.nextInt();
				System.out.println("영어 점수를 입력하세요 : ");
				scoreEng = myInput.nextInt();
				
				// 파일로 데이터 출력
				dataStr = name + "," + scoreKor + "," + scoreEng + "\n";
				dout.write(dataStr.getBytes());
				
				System.out.println("계속 하시겠습니까? : yes(1), no(0)");
				loopCheck = myInput.nextInt();
	
			}while(loopCheck != 0);
			out.close();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
