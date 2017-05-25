package webPrograming.loop;

public class equal {
	public static void main(String[] args) {
		// int형 변수 il 선언
		int k07_il;
		// double형 변수 iD 선언
		double k07_iD;
		// il의 값을 10/3(정수형)으로 초기화
		k07_il = 10/3;
		// il의 값을 10/3(실수형)으로 초기화		
		k07_iD = 10/3.0;
		
		// int와 double은 정수형 연산과 실수형 연산이다.
		if (k07_il==k07_iD) System.out.println("equal\n");
		// int형 10/3과 실수형 /10/3.0은 같지 않다
		else System.out.printf("Not equal[%f][%f]\n", (double)k07_il, k07_iD);
		// 단지 유효숫자까지 표시된 것 뿐이지 다르다.
		if(k07_iD==3.333333) System.out.printf("equal\n");
		// 실수형 10/3.0 연산과 3.333333도 같지 않다
		else System.out.printf("Not equal[3.333333][%f]\n", k07_iD);
		// 실수형 변수 iD를 정수형으로 형변환
		k07_iD=(int)k07_iD;
		// il 과 형변환한 iD 변수는 같다
		if(k07_il==k07_iD) System.out.printf("equal\n");
		else System.out.printf("Not equal[%f][%f]\n", (double)k07_il, k07_iD);
		// 정수형과 실수형으로 각각 출력
		System.out.printf("int로 인쇄[%d][%f]\n", k07_il, k07_iD);
		// 실수형으로 출력
		System.out.printf("double로 인쇄[%f][%f]\n", (double)k07_il, k07_iD);
		// 문자형 변수 a를 선언하고 'c'로 초기화
		
		char k07_a='c';
		// 문자형 변수 a의 값이 'b', 'c', 'd' 의 값이면 각각 출력
		if(k07_a=='b')System.out.printf("a는 b이다\n");
		if(k07_a=='c')System.out.printf("a는 c이다\n");
		if(k07_a=='d')System.out.printf("a는 d이다\n");
		// 문자열 변수 aa를 선언하고 "abcd"의 값으로 초기화
		String k07_aa = "abcd";
		// 문자열 변수 aa의 값이 abcd와 같으면 출력
		if(k07_aa.equals("abcd")) System.out.println("aa는 abcd이다\n");
		else System.out.printf("aa는 abcd가 아니다\n");
		// 논리형 변수 bb를 선언하고 true 값으로 초기화
		boolean k07_bb = true;
		// !가 하나면 반대인 false가 되고 !가 더 붙으면 다시 true
		if(!!k07_bb) System.out.printf("bb가 아니고 아니면 참이다\n");
		else System.out.printf("bb가 아니고 아니면 거짓이다\n");
	}
}
