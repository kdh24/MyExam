package webPrograming.loop;

import java.text.DecimalFormat;

public class ex2 {
	public static void main(String[] args) {

		///////////////////////
		// 띄어쓰기 연습
		//
		// 그냥 이론적 연습
		// 0부터 9까지 반복하는 for 반복문
		for(int i=0; i<10; i++){
			// 0부터 i 보다 작은 숫자만큼 반복하는 for 반복문
			// i가 증가하는 만큼 공백의 숫자도 증가한 뒤 출력해준다 
			for(int j=0; j<i; j++) System.out.printf(" ");
			// i의 값을 출력
			System.out.printf("%d\n", i);
		}
		
		
		//
		// 미친척하고 sin 그래프를 그려보자
		// 360도 : 2pi = 1도:x
		//
		
		// 실수형(double) 변수 fSin 선언
		double fSin;
		
		// 0부터 359 총 360개의 횟수를 반복하는 for 반복문
		for(int i=0; i<360; i++){	//360도까지 값이 어찌 나오나
			
			fSin = Math.sin(i *3.141592/180);
			System.out.printf("%d sin ==>%f\n", i,fSin);
		}
		
		for(int i=0; i<360; i++){	//360도까지 그리자.
			fSin = Math.sin(i * 3.141592/180);
			
			int iSpace = (int)((1.0-fSin) *50);
			for(int j=0; j<iSpace; j++) System.out.printf(" ");
			System.out.printf("*[%f][%d]\n",fSin,iSpace);
		}
		
		
		int n, m;
		
		m=20; n=1;
		
		while(true){
			for(int i=0; i<m; i++) System.out.printf(" ");
			for(int i=0; i<n; i++) System.out.printf("*");
			System.out.printf("\n");
			
			m=m-1;
			n=n+2;
			
			if(m<0) break;
		}
		
		
		////////////////////////////////////////////////
		// 칸 맞추기 실습
		//
		
		// String 변수 item을 선언하고 "사과" 문자열로 초기화
		String item = "사과";
		// int형 변수 unit_price를 선언하고 5000으로 초기화
		int unit_price = 5000;
		// int형 변수 num을 선언하고 500으로 초기화
		int num=500;
		// int형 변수 total을 선언하고 0으로 초기화
		int total=0;
		
		// DecimalFormat 클래스 선언 및 생성 -(3자리마다 콤마(,)를 찍어주게끔 해준다)
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		
		// 헤더 찍기
		System.out.printf("=========================================================\n");
		// 스트링 출력을 전체크기(정렬역할).출력해줄크기 형식으로 지정해서 각각 출력해준다 
		System.out.printf("%20.20s%10.10s%9.9s%15.15s\n","품목","단가","수량","합계");
		System.out.printf("=========================================================\n");
		
		// 값 찍기
		// 스트링 출력을 전체크기(정렬역할).출력해줄크기 형식으로 지정해서 각각 출력해준다		
		// DecimalFormat 변수명을 사용해서 정해준 포맷으로 출력해주므로 3자리수마다 콤마(,)가 포함된 숫자 형식으로 출력된다.
		System.out.printf("%20.20s%10.10s%6.6s%10.10s\n",
				item,df.format(unit_price), df.format(num), df.format(unit_price*num));
	}
}
