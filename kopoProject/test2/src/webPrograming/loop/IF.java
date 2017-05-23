package webPrograming.loop;

public class IF {
	public static void main(String[] args) {
		// int형 변수 score 를 선언하고 70의 값으로 초기화
		int score = 70;
		
		// score 변수의 값이 60 이상인지 if문에서 확인
		if(score > 60){
			System.out.println("합격입니다.");
		}
		// 변수 score 를 60의 값으로 초기화
		score = 60;
		// score 가 60 보다 작을때
		if(score > 60){
			System.out.println("합격입니다.");
		}
		
		// 변수 score의 값이 60보다 높을경우 합격
		if(score > 60){
			System.out.println("합격입니다.");
			// 60보다 작거나 같을 경우 불합격 출력
		} else {
			System.out.println("불합격입니다.");
		}
		
		// int 형 변수 num을 선언하고 10으로 초기화
		int num = 10;
		// num 변수의 값이 0보다 큰지 if문으로 확인
		if(num > 0){
			System.out.println("양수입니다.");
			// num 변수의 값이 0보다 작은 값인지 확인
		} else if(num <0){
			System.out.println("음수입니다.");
		}
		// num 변수의 값이 0보다 크지도 작지도 않으면 0이므로  영이라고 출력
		else {
			System.out.println("영입니다.");
		}
		
		// score 값을 88로 초기화
		score = 88;
		// score 변수의 값이 90보다 크거나 같으면 A등급
		if(score >= 90){
			System.out.println("A등급");
			// score 변수의 값이 80보다 크거나 같고 90보다 작으면 B등급			
		}else if(score >= 80 && score < 90){
			System.out.println("B등급");
			// score 변수의 값이 70보다 크거나 같고 80보다 작으면 C등급			
		}else if(score >= 70 && score < 80){
			System.out.println("C등급");
			// score 변수의 값이 70보다 작은 값이면 F등급 처리를 한다
		}else { // score < 70
			System.out.println("F등급");
		}
		
	}
}
