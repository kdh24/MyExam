package test2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test1Class {
	
	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		int c = 0;
		Scanner myIn = new Scanner(System.in);
		try{
			b = myIn.nextInt();
			c = a/b;
			System.out.println(c);
		}catch(ArithmeticException e) {
			System.out.println("0으로 나누지 말라고!");
		}catch(InputMismatchException e){
			System.out.println("숫자만 입력하세요!");
		}
		System.out.println("정상!!");
		myIn.close();
	}
}