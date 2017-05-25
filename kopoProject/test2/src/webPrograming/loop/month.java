package webPrograming.loop;

public class month {
	public static void main(String[] args) {

		///////////////////////////////////////////////////
		// 프로그래밍은 그깟 몇 줄 아끼는 것보다 직관적인 것이 좋다
		// 그냥 문장이라고 생각하고 프로그래밍 한다.
		// 1월은 31이고, 2월은 28일.. 12월은 31이다.
		
		// 1부터 12까지 반복하는 for 반복문
		for(int k07_i=1; k07_i<13; k07_i++){
			// 1월~ 12월까지 순차적으로 출력해준다
			System.out.printf(" %d월 =>", k07_i);
			// 1부터 31 까지 반복하는 for 반복문
			for(int k07_j=1; k07_j<32; k07_j++){
				System.out.printf("%d", k07_j);
				
				// 1월부터 순차적으로 해당하는 월의 일수를 지정해서 그 날짜가 넘어가면 종료되게 처리
				if(k07_i==1 && k07_j==31) break;
				if(k07_i==2 && k07_j==28) break;
				if(k07_i==3 && k07_j==31) break;
				if(k07_i==4 && k07_j==30) break;
				if(k07_i==5 && k07_j==31) break;
				if(k07_i==6 && k07_j==30) break;
				if(k07_i==7 && k07_j==31) break;
				if(k07_i==8 && k07_j==31) break;
				if(k07_i==9 && k07_j==30) break;
				if(k07_i==10 && k07_j==31) break;
				if(k07_i==11 && k07_j==30) break;
				if(k07_i==12 && k07_j==31) break;
			}
			// 엔터 처리
			System.out.printf("\n");
		}

		System.out.println();
		
		for (int i = 1; i < 13; i++) {
			System.out.printf(" %d월 =>", i);
			for (int j = 1; j < 32; j++) {
				System.out.printf("%d,", j);

				if (i == 4 || i == 6 || i == 9 || i == 7 || i == 11) {
					if (j == 30)
						break;
				}
				if (i == 2) {
					if (j == 28)
						break;
				}
			}
			System.out.printf("\n");
		}

		System.out.println();
		
		///////////////////////////////////////////
		// 앞에처럼 쓰는 것을 권장, 뭐 좀 프로그램이 익숙해지면 이것도 무난함
		//
		
		for(int i=1; i<13; i++){
			System.out.printf(" %d월 =>", i);
			for(int j=1; j<32; j++){
				System.out.printf("%d,",j);
				
				if((i==4||i==6||i==9||i==7||i==11)&&(j==30)) break;
				if(i==2 && j==28) break;
			}
			System.out.printf("\n");
		}

		System.out.println();
		
		//////////////////////////////////////////////////////////////
		// 이 예제는 정말 억지로 만든거 이렇게 이상하게 프로그램하지는 않는다.
		//
		
		for(int i=1; i<13; i++){
			System.out.printf(" %d월 =>", i);
			LOOP:for(int j=1; j<32; j++){
				
				System.out.printf("%d,",j);
				
				switch(i){
				case 4:case 6:case 9:case 7:case 11:
					if(j==30) break LOOP;
					//거의 이런 표현은 안 함
					//LOOP라는 표시자가 없으면 엉뚱한 결과.
					break;
				case 2:
					if(j==28) break LOOP;
					break;
				}
			}
			System.out.printf("\n");
		}
		
		///////////////////////////////////////////////////////////////
		// 비정형 비교(룰이 애매한)는 배열을 이용하는 것도 한 방법이다.
		//
		
		int [] iLMD = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		// 단 배열은 0부터 시작한다는 것에 유의 LastMonthDate
		// iLMD[0] ~ iLMD[11] 이다
		
		for(int i=1; i<13; i++){
			System.out.printf(" %d월 =>", i);
			for(int j=1; j<32; j++){
				System.out.printf("%d", j);
				
				if(iLMD[i-1]==j) break;
				
				System.out.printf(","); // 마지막에 콤마 안 찍기
			}
			System.out.printf("\n");
			
		}
	}
}
