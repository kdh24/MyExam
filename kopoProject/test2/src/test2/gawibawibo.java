package test2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class gawibawibo {
	public static void main(String args[]){
		boolean loop = true;
		Scanner myScan = new Scanner(System.in);
		Random rand = new Random();
		int randNum = Math.abs(rand.nextInt() % 3);
		int myNum = 0;

		while (loop) {
			System.out.println("어떤 것을 내시겠습니까?" + "( 0 : 가위, 1 : 바위, 2 : 보)");
			try {
				myNum = myScan.nextInt();
				if(myNum < 0 || myNum > 2){
					throw new InputMismatchException();
				}
				
				switch(myNum){
				case 0:
					if(randNum == 1){
						System.out.println("졌습니다");
					}else if(randNum == 2){
						System.out.println("이겼습니다");
					}else{
						System.out.println("비김");
					}
					break;
				case 1:
					if(randNum == 2){
						System.out.println("졌습니다");
					}else if(randNum == 0){
						System.out.println("이겼습니다");
					}else{
						System.out.println("비김");
					}
					break;
				case 2:
					if(randNum == 0){
						System.out.println("졌습니다");
					}else if(randNum == 1){
						System.out.println("이겼습니다");
					}else{
						System.out.println("비김");
					}
					break;
					default:
						break;
				}
				loop = false;
				
				
			} catch (InputMismatchException e) {
				myScan.nextLine();
				loop = true;
				System.out.println("다시 !!");
			}
		}
		
		
	}
}
