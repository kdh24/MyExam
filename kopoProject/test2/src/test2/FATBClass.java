package test2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FATBClass {
	public static void main(String args[]) {
		int a = 0;
		Scanner myInput = new Scanner(System.in);
		System.out.println("1. 자유이용권, 2. 입장권");
		try{
			a = myInput.nextInt();
			if( a < 1 || a > 2) {
				throw new InputMismatchException();
			}
		}catch(InputMismatchException e){
			System.out.println("입력 오류 입니다.");
		}catch(Exception e){
			
		}
	}
}
