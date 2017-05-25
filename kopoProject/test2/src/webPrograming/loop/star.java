package webPrograming.loop;

public class star {
	public static void main(String[] args) {
		///////////////////////////////////////
		//
		// 단순 비교
		// for문을 안 스고 while문을 씀
		//
		
		// 반복을 위한 변수 선언
		int k07_iA, k07_iB;
		
		// k07_iA의 값을 0으로 초기화
		k07_iA=0;
		// 계속 반복하게 해주는 while 반복문
		while(true){
			// 변수 k07_iB의 값을 0으로 초기화
			k07_iB=0;
			// 계속 반복하게 해주는 while 반복문			
			while(true){
				// * 출력
				System.out.printf("*");
				
				// 변수 k07_iA의 값과 k07_iB의 값이 같으면 2번째 반복문을 빠져나간다
				if(k07_iA==k07_iB) break;

				// 변수 k07_iB의 값을 하나씩 증가
				k07_iB++;
			}
			// 엔터 처리
			System.out.printf("\n");

			// 변수 k07_iA의 값을 하나씩 증가
			k07_iA++;
			// 변수 k07_iA의 값이 30이 되면 빠져나간다
			if(k07_iA == 30) break;
		}
	}
}
