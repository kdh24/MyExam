package webPrograming.stringBuffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main01 {

	public static void main(String[] args) {
		dataSet(); 		// 데이터 셋팅
//		dataSort();		// 데이터 정렬
		HeaderPrint();	// 헤더인쇄
		for(int i=0; i<ArrayOneRec.size(); i++){ //내용인쇄
			ItemPrint(i);
		}
		TailPrint(); // 꼬리인쇄
	}
	// OneRec 클래스 형식의 어레이 리스트 생성
	static ArrayList<OneRec> ArrayOneRec = new ArrayList<>();

	// 누적값 처리를 위한 sum 변수들
	static int k07_sumKor=0;
	static int k07_sumEng=0;
	static int k07_sumMat=0;
	static int k07_sumSum=0;
	static int k07_sumAve=0;
	static final int k07_iPerson=20;
	
	//데이터 만들기
	public static void dataSet(){
		// 데이터를 만들어서 저장하기 위한 변수 
		String k07_name = null;
		int k07_kor = 0;
		int k07_eng = 0;
		int k07_mat = 0;
		for(int i=0; i<k07_iPerson; i++){
			k07_name = String.format("홍길%02d", i); // 이름 만들기
			k07_kor = (int)(Math.random()*100);	//국어점수 만들기
			k07_eng = (int)(Math.random()*100);	//영어점수 만들기
			k07_mat = (int)(Math.random()*100);	//수학점수 만들기
			// 하나의 OneRec클래스를 생성 후 ArrayList에 집어넣었다.
			ArrayOneRec.add(new OneRec(i,k07_name,k07_kor,k07_eng,k07_mat)); 
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
		// OneRec 클래스 변수를 선언
		OneRec k07_rec;
		
		// 어레이 리스트 i에 저장되어 있는 값을 가져와서 rec 클래스에 넣어준다 
		k07_rec=ArrayOneRec.get(i);
		// 어레이 리스트에서 받아와서 rec 변수에 넣은 값들을 항목별로 가져와 출력해준다
		System.out.printf("%4d %4s %3d %3d %3d  %3d  %6.2f\n", 
				k07_rec.student_id(), k07_rec.name(), k07_rec.kor(), k07_rec.eng(), k07_rec.mat(), k07_rec.sum(), k07_rec.ave());
		
		// 누적값 변수에 값을 누적시켜 준다.
		k07_sumKor+=k07_rec.kor();
		k07_sumEng+=k07_rec.eng();
		k07_sumMat+=k07_rec.mat();
		k07_sumSum+=k07_rec.sum();
		k07_sumAve+=k07_rec.ave();
	}
	
	// 꼬리 인쇄
	public static void TailPrint(){
		// 각 항목의 합계 및 평균 값 출력
		System.out.printf("************************************\n");
		System.out.printf("국어합계 %d	국어평균: %6.2f\n",k07_sumKor, k07_sumKor/(double)ArrayOneRec.size());
		System.out.printf("영어합계 %d	영어평균: %6.2f\n",k07_sumEng, k07_sumEng/(double)ArrayOneRec.size());
		System.out.printf("수학합계 %d	수학평균: %6.2f\n",k07_sumMat, k07_sumMat/(double)ArrayOneRec.size());
		System.out.printf("************************************\n");
		System.out.printf("반평균합계 %d		반평균: %6.2f\n",k07_sumAve,k07_sumAve/(double)ArrayOneRec.size());
	}
	
	// ArrayList 정렬
	public static void dataSort(){
		Comparator<OneRec> k07_bikyeokijun = new Comparator<OneRec>(){
			public int compare(OneRec a1, OneRec a2){
				// 만일 문자형 비교면 아래와 같이 써줌
				// return (String.valueOf(a1.kor).compareTo(String.valueOf(a2.kor)));
				// a2의 값이 크면 양수로 a2가 선택되고 a1의 값이 크면 음수를 리턴해 준다.
				return (a2.sum()-a1.sum());
			}
		};
		Collections.sort(ArrayOneRec, k07_bikyeokijun);	// 설정한 내용대로 정렬(sort!)
//			Collections.reverse(ArrayOneRec); //역정렬(뒤집기)
		
	}
}
