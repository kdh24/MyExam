//package arr;
//
//import java.io.DataInputStream;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.Scanner;
//
//public class ClassInput {
//	public static void main(String[] args){
//		InputStream in = new FileInputStream("C:\\zzz\\input.csv");
//		DataInputStream din = new DataInputStream(in);
//		Scanner myInput = new Scanner(System.in);
//		int count = 0;
//		
//		
//		while(din.available() > 0){
//			String str;
//			String[] str2 = new String[10];
//			str = din.readLine();
//			str2 = str.split(",");
//			for(int i=0; i<count; i++){
//				score[number][i] = Integer.parseInt(str2[i]);
//			}
//			number++;
//		}
//		
//		do{
//			//콘솔에서 데이터 입력
//			System.out.println(number + "번 학생의");
//			
//			for(int i=0; i<count;i++){
//				System.out.println((i+1) + "과목 점수는 몇점입니까? ");
//				score[number][i] = myInput.
//			}
//		}while();
//	}
//}
