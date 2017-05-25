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
		double k07_fSin;
		
		// 0부터 359 총 360개의 횟수를 반복하는 for 반복문
		for(int i=0; i<360; i++){	//360도까지 값이 어찌 나오나
			// 사인 값을 구해주는 Math 함수 사용 i값을 기준으로 값을 구해준다
			k07_fSin = Math.sin(i *3.141592/180);
			// i일때 사인값을 출력
			System.out.printf("%d sin ==>%f\n", i,k07_fSin);
		}
		// 0부터 359까지 반복해주는 for 반복문
		for(int i=0; i<360; i++){	//360도까지 그리자.
			// 사인 값을 구해주는 Math 함수 사용 i값을 기준으로 값을 구해준다
			k07_fSin = Math.sin(i * 3.141592/180);
			// 사인 값을 기준으로 최대 50개까지 공백처리를 해주기 위한 iSpace 변수
			int k07_iSpace = (int)((1.0-k07_fSin) *50);
			// 0부터 iSpace 변수보다 1개 작은 값까지 반복해주는 for 반복문
			for(int j=0; j<k07_iSpace; j++) System.out.printf(" ");
			// i 값을 기준으로 구한 사인값과 1에서 사인값을 빼서 곱하기 50을 해서 구한 iSpace 값 출력
			System.out.printf("*[%f][%d]\n",k07_fSin,k07_iSpace);
		}
		
		
		// int 형 변수 n, m 선언
		int k07_n, k07_m;
		// 변수 m 에 20, n에 1로 초기화를 해준다.
		k07_m=20; k07_n=1;
		
		// 무조건 반복해주는 while 반복문
		while(true){
			// 0 부터 m -1 의 값만큼 반복해주는 for문
			for(int i=0; i<k07_m; i++) System.out.printf(" ");
			// 0 부터 n -1 의 값만큼 반복해주는 for문
			for(int i=0; i<k07_n; i++) System.out.printf("*");
			// 엔터처리
			System.out.printf("\n");
			
			// 변수 m은 값을 하나씩 빼주고
			// 변수 n은 값을 2씩 증가시켜준다
			k07_m=k07_m-1;
			k07_n=k07_n+2;
			
			// if문을 사용하여 변수 m이 0보다 작은 값이 되면 break 문으로 반복문을 빠져나간다.
			if(k07_m<0) break;
		}
		
		
		////////////////////////////////////////////////
		// 칸 맞추기 실습
		//
		
		// String 변수 item을 선언하고 "사과" 문자열로 초기화
		String k07_item = "사과";
		// int형 변수 unit_price를 선언하고 5000으로 초기화
		int k07_unit_price = 5000;
		// int형 변수 num을 선언하고 500으로 초기화
		int k07_num=500;
		// int형 변수 total을 선언하고 0으로 초기화
		int k07_total=0;
		
		// DecimalFormat 클래스 선언 및 생성 -(3자리마다 콤마(,)를 찍어주게끔 해준다)
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		
		// 헤더 찍기
		System.out.printf("=========================================================\n");
		// 스트링 출력을 전체크기(정렬역할).출력해줄크기 형식으로 지정해서 각각 출력해준다 
		System.out.printf("%20.20s%8.8s%8.8s%8.8s\n","품목","단가","수량","합계");
		System.out.printf("=========================================================\n");
		
		// 값 찍기
		// 스트링 출력을 전체크기(정렬역할).출력해줄크기 형식으로 지정해서 각각 출력해준다		
		// DecimalFormat 변수명을 사용해서 정해준 포맷으로 출력해주므로 3자리수마다 콤마(,)가 포함된 숫자 형식으로 출력된다.
		System.out.printf("%20.20s%10.10s%10.10s%10.10s\n",
				k07_item,df.format(k07_unit_price), df.format(k07_num), df.format(k07_unit_price*k07_num));
	}
}
