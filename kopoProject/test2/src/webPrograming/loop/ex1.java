package webPrograming.loop;

public class ex1 {
	public static void main(String[] args) {
		/////////////////////////////////////////////////
		// 범위를 주어서 찾기
		//
		// 정수형 변수 iVal 선언
		int k07_iVal;
		// 0부터 299까지 for 반복문 실행
		for(int i=0; i<300; i++){
			// 변수 iVal에 5의 배수로 차례대로 증감시켜서 대입
			k07_iVal = 5 * i;
			// iVal의 값이 0보다 크거나 같고 10보다 작으면 일의 자리 출력
			if(k07_iVal >=0 && k07_iVal<10) System.out.printf("일 %d\n", k07_iVal);
			// iVal의 값이 10보다 크거나 같고 100보다 작으면 십의 자리 출력
			else if(k07_iVal >= 10 && k07_iVal<100) System.out.printf("십 %d\n", k07_iVal);
			// iVal의 값이 100보다 크거나 같고 1000보다 작으면 백의 자리 출력
			else if(k07_iVal >= 100 && k07_iVal<1000) System.out.printf("백 %d\n", k07_iVal);
			// 그 외는 천의 단위이므로 천위단위로 출력
			else System.out.printf("천 %d\n", k07_iVal);
		}
		
		///////////////////////
		// 범위를 주는 것, 숫자 자르기
		// 문자열 배열 units 에 문자열 영부터 구까지 순차적으로 초기화
		String[] k07_units={"영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
		// 0부터 100까지 순차적으로 실행되는 for 반복문
		for(int i=0; i<101; i++){
			// 변수 i가 0보다 크거나 같고 10보다 작은지 비교
			if(i>= 0 && i<10){
				// if문이 충족되면 일의 자리 출력
				System.out.printf("일의 자리 : %s\n", k07_units[i]);
			}
			// if문의 값에 해당되지 않으면서 10보다 크거나 같고 100보다 작은지 비교
			else if(i >= 10 && i < 100){
				// 십의 자리 저장하는 i10 변수와 일의 자리 저장하는 i0 변수 선언
				int k07_i10, k07_i0;
				// i의 값을 10으로 나누면 십의 자리 숫자가 나오고 그것을 i10 변수에 저장
				k07_i10 = i/10; // 십의 자리
				// i의 값을 10으로 나눈 나머지가 일의 자리 숫자기 되고 그것을 i0 변수에 저장
				k07_i0 = i %10; // 일의 자리
				// i0 변수의 값이 0인지 확인
				if(k07_i0 == 0){
					// i0의 값이 0 일때 십의자리 "영" 을 출력
					System.out.printf("십의자리 : %s십\n", k07_units[k07_i10]);
					// i0의 값이 0이 아니면 십의 자리에 해당하는 문자열 출력
				}else{
					System.out.printf("십의자리 : %s십%s\n", k07_units[k07_i10], k07_units[k07_i0]);
				}
			}
			// 일,십의 단위가 넘어가면 숫자 그대로 출력
			else System.out.printf("==> %d\n", i);
			
		}
		
		// int형 변수 iNumVal에 1001034567 값 초기화
		int k07_iNumVal = 1001034567;
		// 문자열 변수 sNumVal에 iNumVal의 값을 문자열로 변환시켜서 저장
		String k07_sNumVal = String.valueOf(k07_iNumVal);
		// String 변수 sNumVoice 선언 후 생성
		String k07_sNumVoice="";
		// 숫자를 문자로 변환한 sNumVal의 값을 문자열로 그대로 출력하고 총 길이도 출력
		System.out.printf("==> %s [%d자리]\n", k07_sNumVal, k07_sNumVal.length());
		// 변수 i, j 선언
		int k07_i, k07_j;
		// String 배열 units1에 "영" 부터 "구"까지 순차적으로 대입 
		String[] k07_units1={"영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
		// String 배열 unitX에 "" 부터 "십"까지 순차적으로 초기화
		String[] k07_unitX={"", "십", "백", "천", "만", "십", "백", "천", "억", "십"};
		// 변수 i를 0으로 초기화
		k07_i=0;
		// 변수 j에 sNumVal 배열의 마지막 index 번호를 대입
		k07_j=k07_sNumVal.length()-1;
		// 계속 반복되는 while 반복문
		while(true){
			// i의 숫자가 sNumVal 배열의 크기를 벗어나면 반복문을 빠져나간다
			if(k07_i>=k07_sNumVal.length()) break;
			
			// sNumVal 변수에서 i 번째에 해당하는 값을 가져와 출력해주고, 대괄호[] 안에 문자열로도 표시해준다
			System.out.printf("%s[%s]",
					k07_sNumVal.substring(k07_i, k07_i+1),
					k07_units1[Integer.parseInt(k07_sNumVal.substring(k07_i,k07_i+1))]);
			// 자리수가 0의 값을 가지고 있는지 확인
			if(k07_sNumVal.substring(k07_i,k07_i+1).equals("0")) {
				//
				// 해당자리가 0일땐 단위값을 안 붙이는데 억, 만 자리는 붙인다.
				// 이백 사만 이십.. 이백 만 원 ..
				// 억, 만 자리가 아니면 아무짓도 안 함
				// 
				// 자리수가 0이고 억이나 만의 값을 가지고 있는지 확인
				if(k07_unitX[k07_j].equals("만")||k07_unitX[k07_j].equals("억")){
					// 단위가 억이나 만의 값을 가지고 있을땐 단위를 붙여준다
					k07_sNumVoice = k07_sNumVoice + "" + k07_unitX[k07_j];
					// 해당자리가 0이면 단위만 붙여줌
				}else{
					// 아무짓도 안함
				}
			}else {
				// 문자열 변수 sNumVoice문자열로 표시하는 숫자, 단위 까지 모두 추가해서 저장
				k07_sNumVoice=k07_sNumVoice
						+ k07_units[Integer.parseInt(k07_sNumVal.substring(k07_i,k07_i+1))]
						+ k07_unitX[k07_j];
			}
			// 변수 i는 1개씩 증가, j는 한개씩 감소
			k07_i++; k07_j--;
		}
		// 최종값을 출력해준다. sNumVal은 문자열 형식으로 저장된 숫자로 표시되는 전체 금액, 
		// []의 값은 숫자를 문자열 표기한 단위를 포함한 전체 금액 
		System.out.printf("\n %s[%s]\n", k07_sNumVal, k07_sNumVoice);
		
	}
}
