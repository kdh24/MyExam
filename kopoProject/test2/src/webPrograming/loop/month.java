package webPrograming.loop;

public class month {
	public static void main(String[] args) {

		///////////////////////////////////////////////////
		// 프로그래밍은 그깟 몇 줄 아끼는 것보다 직관적인 것이 좋다
		// 그냥 문장이라고 생각하고 프로그래밍 한다.
		// 1월은 31이고, 2월은 28일.. 12월은 31이다.
		
		// 1부터 12까지 반복하는 for 반복문
		for(int i=1; i<13; i++){
			
			System.out.printf(" %d월 =>", i);
			for(int j=1; j<32; j++){
				System.out.printf("%d", j);
				
				if(i==1 && j==31) break;
				if(i==2 && j==31) break;
				if(i==3 && j==31) break;
				if(i==4 && j==31) break;
				if(i==5 && j==31) break;
				if(i==6 && j==31) break;
				if(i==7 && j==31) break;
				if(i==8 && j==31) break;
				if(i==9 && j==31) break;
				if(i==10 && j==31) break;
				if(i==11 && j==31) break;
				if(i==12 && j==31) break;
			}
			System.out.printf("\n");
		}
	}
}
