package webPrograming.stringBuffer;

public class report1 {
	public static void main(String[] args) {
		// 클래스 배열의 갯수를 정하기 위한 iPerson 변수
		int k07_iPerson=10;
		// OneRec2 클래스의 클래스 배열을 iPerson 값만큼 생성
		OneRec2[] k07_inData = new OneRec2[k07_iPerson];
		
		// 클래스 배열 0~9번까지의 값을 초기화 시켜준다
		k07_inData[0] = new OneRec2("홍길01", 100, 100, 100);
		k07_inData[1] = new OneRec2("홍길02", 90, 90, 80);
		k07_inData[2] = new OneRec2("홍길03", 90, 80, 80);
		k07_inData[3] = new OneRec2("홍길04", 70, 70, 80);
		k07_inData[4] = new OneRec2("홍길05", 90, 80, 80);
		k07_inData[5] = new OneRec2("홍길06", 70, 90, 80);
		k07_inData[6] = new OneRec2("홍길07", 90, 50, 80);
		k07_inData[7] = new OneRec2("홍길08", 70, 60, 80);
		k07_inData[8] = new OneRec2("홍길09", 90, 70, 80);
		k07_inData[9] = new OneRec2("홍길10", 70, 80, 80);
		
		// 값을 출력하기 전에 해당 항목들이 어떤 값인지 길이에 맞춰 표시해준다
		System.out.printf("==========================================\n");
		System.out.printf("%5.5s %3.3s %3.3s %3.3s %5.5s %5.5s\n", "이름", "국어", "영어", "수학", "총점", "평균");
		System.out.printf("==========================================\n");

		// OneRec2 클래스의 배열 inData의 크키만큼 반복
		for(int i=0; i<k07_inData.length; i++){
			// 클래스 배열의 각 항목들의 값을 가져와 출력해준다.
			System.out.printf("%5.5s %5.5s %5.5s %5.5s %6.6s %6.6s\n",
					k07_inData[i].name(), k07_inData[i].kor(), k07_inData[i].eng(), k07_inData[i].mat(), k07_inData[i].sum(), (int)k07_inData[i].ave());
		}
	}
}
