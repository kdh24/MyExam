package webPrograming.loop;

public class switchCase {
	public static void main(String[] args) {
		// String 변수 jumin를 선언하고 123456-1234567  값으로 초기화 해준다
		String jumin = "123456-1234567";

		// jumin 변수의  - 다음 문자를 가져오려면 7번째 문자를 가져와야 한다.
		switch (jumin.charAt(7)) { // String표현은 안 된다.
		// 가져온 값이 문자 1일때  실행
		// break문이 생략되면 원하는 작업후에도 멈추지 않고 아래 작업이 한번 더 실행된다 
			case '1':
				System.out.printf("20세기전 태어난 남자 사람\n");
			// 가져온 값이 문자 2일때 실행
			case '2':
				System.out.printf("20세기전 태어난 여자 사람\n");
				break;
			// 가져온 값이 문자 3일때 실행
			case '3':
				System.out.printf("20세기후 태어난 남자 사람\n");
				break;
			// 가져온 값이 문자 4일때 실행
			case '4':
				System.out.printf("20세기후 태어난 여자 사람\n");
				break;
			// 가져온 값이 위에 1~4 중에 없을때 이것이 기본적으로 실행된다.
			default:
				System.out.printf("사람\n");
				break;
		}
	}
}
