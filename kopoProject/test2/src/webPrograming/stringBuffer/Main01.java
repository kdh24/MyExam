package webPrograming.stringBuffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main01 {

	public static void main(String[] args) {
		dataSet(); 		// 데이터 셋팅
		dataSort();		// 데이터 정렬
		HeaderPrint();	// 헤더인쇄
		for(int i=0; i<ArrayOneRec.size(); i++){ //내용인쇄
			ItemPrint(i);
		}
		TailPrint(); // 꼬리인쇄
	}
	
	static ArrayList<OneRec> ArrayOneRec = new ArrayList<>();

	static int sumKor=0;
	static int sumEng=0;
	static int sumMat=0;
	static int sumSum=0;
	static int sumAve=0;
	static final int iPerson=20;
	
	//데이터 만들기
	public static void dataSet(){
		String name = null;
		int kor = 0;
		int eng = 0;
		int mat = 0;
		for(int i=0; i<iPerson; i++){
			name = String.format("홍길%02d", i); // 이름 만들기
			kor = (int)(Math.random()*100);	//국어점수 만들기
			eng = (int)(Math.random()*100);	//영어점수 만들기
			mat = (int)(Math.random()*100);	//수학점수 만들기
			ArrayOneRec.add(new OneRec(i,name,kor,eng,mat)); // 하나의 OneRec클래스를 생성 후 ArrayList에 집어넣었다.
		}
	}
	
	// 헤더 인쇄
	public static void HeaderPrint(){
		System.out.printf("************************************\n");
		System.out.printf("%2s %4s %2s %2s %2s %2s  %2s\n", "번호","이름","국어","영어","수학","합계","평균");
		System.out.printf("************************************\n");
	}
	
	// 내용 인쇄
	public static void ItemPrint(int i){
		OneRec rec;
		
		rec=ArrayOneRec.get(i);
		System.out.printf("%4d %4s %3d %3d %3d  %3d  %6.2f\n", rec.student_id(), rec.name(), rec.kor(), rec.eng(), rec.mat(), rec.sum(), rec.ave());
		
		sumKor+=rec.kor();
		sumEng+=rec.eng();
		sumMat+=rec.mat();
		sumSum+=rec.sum();
		sumAve+=rec.ave();
	}
	
	// 꼬리 인쇄
	public static void TailPrint(){
		System.out.printf("************************************\n");
		System.out.printf("국어합계 %d	국어평균: %6.2f\n",sumKor, sumKor/(double)ArrayOneRec.size());
		System.out.printf("영어합계 %d	영어평균: %6.2f\n",sumEng, sumEng/(double)ArrayOneRec.size());
		System.out.printf("수학합계 %d	수학평균: %6.2f\n",sumMat, sumMat/(double)ArrayOneRec.size());
		System.out.printf("************************************\n");
		System.out.printf("반평균합계 %d		반평균: %6.2f\n",sumAve,sumAve/(double)ArrayOneRec.size());
	}
	
	// ArrayList 정렬
	public static void dataSort(){
		Comparator<OneRec> bikyeokijun = new Comparator<OneRec>(){
			public int compare(OneRec a1, OneRec a2){
				// 만일 문자형 비교면 아래와 같이 써줌
				// return (String.valueOf(a1.kor).compareTo(String.valueOf(a2.kor)));
				// a2의 값이 크면 양수로 a2가 선택되고 a1의 값이 크면 음수를 리턴해 준다.
				return (a2.sum()-a1.sum());
			}
		};
		Collections.sort(ArrayOneRec, bikyeokijun);	// 설정한 내용대로 정렬(sort!)
//			Collections.reverse(ArrayOneRec); //역정렬(뒤집기)
		
	}
}
