package test_0323;

import java.util.Scanner;

public class exam {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.println("숫자 세 개를 입력하세요 : ");
			int num1 = scanner.nextInt();
			int num2 = scanner.nextInt();
			int num3 = scanner.nextInt();
			if(num1 == 0 && num2 == 0 && num3 == 0 )
				break;
			
			int max = num1;
			
			if(max < num2)max = num2;
			if(max < num3)max = num3;
			
			System.out.println("최대값은 " + max);
		}
		System.out.println("종료");
	}

}
