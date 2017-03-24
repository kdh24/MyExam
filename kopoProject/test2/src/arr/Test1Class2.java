package arr;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Test1Class2 {

	public static void main(String[] args) {
		
		
		try {
			OutputStream out = new FileOutputStream("C:\\test\\output.csv");
			DataOutputStream dout = new DataOutputStream(out);
			Scanner myInput = new Scanner(System.in);
//			String name;
			int  loopCheck =1, number = 0;
			String dataStr;
			int count=0;
			int[][] score = new int[100][10];
			
			System.out.println("몇과목 인가요?");
			count =  myInput.nextInt();
			
			
			do{
				// 콘솔에서 데이터 입력
				System.out.println(number+1 + "번 학생의  ");
				
				for(int i=0; i<count; i++){
					System.out.println((i+1) + "과목 점수는 몇점입니까? ");
					score[number][count] = myInput.nextInt();
					// 총점
					score[number][count] = score[number][count] + score[number][i];
				}
				score[number][count+1] = score[number][count] / count;
				
				number++;
				
				
				/*System.out.println(number + "번 학생의 영어 점수를 입력하세요 : ");
				score[count][0] = myInput.nextInt();

				System.out.println(number + "번 학생의 수학 점수를 입력하세요 : ");
				score[count][1] = myInput.nextInt();
*/				
				count++;
				
				System.out.println("계속 하시겠습니까? : yes(1), no(0)");
				loopCheck = myInput.nextInt();
	
			}while(loopCheck != 0);
			
			for(int i=1; i<number; i++){
				for(int j=0; j<count + 2; j++){
					System.out.println(score[i][j] + "\t");
					//파일로 데이터 출력
					dataStr = score[i][j] + ",";
					dout.write(dataStr.getBytes());
				}
			}
			
			System.out.println(score[0].length);
			number=1;
			/*
			for(int i=0; i<score[0].length; i++){
				if(score[i][0] != 0)
				{
					System.out.println(number + "번 학생의 영어점수는 " + score[i][0] + ", 수학점수는 " + score[i][1]);
					dataStr = number + "," + score[i][0] + "," + score[i][1] + "\n";
					dout.write(dataStr.getBytes());

					number++;
				}
				
			for(int i=0; i<score.length; i++){
				if(score[i][0] != 0)
				{
					System.out.println(number + "번 학생의 영어점수는 " + score[i][0] + ", 수학점수는 " + score[i][1]);
					dataStr = number + "," + score[i][0] + "," + score[i][1] + "\n";
					dout.write(dataStr.getBytes());

					number++;
				}
				
			}*/
			
			out.close();
			
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
