package webPrograming.ex;

public class HanBlackPrint {
	// 길이 조절을 위해 한글 앞에 공백으로 채워넣는 메소드
	// 한글값과 전체 길이를 매개변수로 넘겨받아 처리한다
	public static String HanBlackForeword(String Han, int num){
		// 한글 공백변수
		String k07_HanBlack="";
		// 한글매개변수의 값의 바이트 길이를 전체 길이에서 빼서 그것을 최대값으로 정하는 변수 
		int max= num -Han.getBytes().length;
		// 0부터 max 변수의 값까지 반복하는 반복문
		for(int i=0; i<max; i++){
			// max의 크기만큼 k07_HanBlack 변수에 공백을 더해준다
			k07_HanBlack += " ";
		}
		// 공백이 들어있는 k07_HanBlack 변수에 넘겨받은 한글값을 더해준다
		k07_HanBlack += Han;
		// 한글공백처리를 완료한 String 값을 돌려준다.
		return k07_HanBlack;
	}
	// 길이 조절을 위해 한글 뒤에 공백으로 채워넣는 메소드
	// 한글값과 전체 길이를 매개변수로 넘겨받아 처리한다
	public static String HanBlackBackword(String k07_Han, int k07_num){
		// 한글 공백변수
		String k07_HanBlack="";
		// 한글매개변수의 값의 바이트 길이를 전체 길이에서 빼서 그것을 최대값으로 정하는 변수		
		int max= k07_num -k07_Han.getBytes().length;
		
		
		if(k07_Han.getBytes().length > k07_num ){
			if(k07_Han.getBytes().length % 2 == 1)
				k07_HanBlack = new String(k07_Han.getBytes(), 0, 23) + " ";
			else 
				k07_HanBlack = new String(k07_Han.getBytes(), 0, 24);
		}else
		{
//			k07_HanBlack = new String(k07_Han.getBytes(), 0, 20);
			
			// 한글 공백처리변수에 미리 넘겨받은 한글값을 넣어준다
			k07_HanBlack += k07_Han;
			// max 변수의 값만큼 공백을 추가로 더해준다
			for (int i = 0; i < max; i++) {
				k07_HanBlack += " ";
			}
		}
		// 한글과 공백을 더한 k07_HanBlack 변수를 리턴값으로 돌려준다.
		return k07_HanBlack;
	}
	// String 변수에 한글로 된 값이 몇개나 있는지 비교해서 알려주는 클래스
	// k07_Han 변수에 있는 한글의 갯수를 구해서 넘겨준다. 
	public static int HanCount(String k07_Han) {
		// 한글의 갯수를 구해서 리턴값으로 넘겨줄 k07_count 변수를 생성 및 0으로 초기화
		int k07_count=0;
		// 매개변수로 받은 Han 변수의 길이만큼 반복해서 처리하는 반복문
		for(int i=0; i<k07_Han.length(); i++){
			// Han 변수의 값을 앞에서부터 한개씩 가져와서 byte 길이가 1이 넘으면 한글이므로 count 변수에 더해준다 
			if(k07_Han.substring(i, i+1).getBytes().length >1){
				k07_count += 1;
			}
		}
		// 리턴값으로 구해준 한글의 갯수를 넘겨준다
		return k07_count;
	}

	public static void main(String[] args) {
		// 길이에 맞게 앞에 공백을 추가해준 HanBlackForeword 함수 호출해서 결과 출력
		System.out.printf("HanBlackForeword[%s]\n", HanBlackForeword("한글abcd", 15));
		// 길이에 맞게 앞에 공백을 추가해준 HanBlackForeword 함수 호출해서 결과 출력
		System.out.printf("HanBlackForeword[%s]\n", HanBlackForeword("한글한글aa", 15));
		// 길이에 맞게 뒤에 공백을 추가해준 HanBlackBackword 함수 호출해서 결과 출력		
		System.out.printf("HanBlackBackword[%s]\n", HanBlackBackword("한글aa", 15));
		// 길이에 맞게 뒤에 공백을 추가해준 HanBlackBackword 함수 호출해서 결과 출력		
		System.out.printf("HanBlackBackword[%s]\n", HanBlackBackword("한글한글aa", 15));
		// 변수에 한글이 몇개나 있는지 확인해서 갯수를 알려주는 HanCount 함수 호출해서 결과 출력
		System.out.printf("한글은 [%d]개\n", HanCount("한글한글aa"));
	}
}
