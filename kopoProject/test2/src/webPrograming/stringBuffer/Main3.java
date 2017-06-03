package webPrograming.stringBuffer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class Main3 {

	public static void main(String[] args) {
		// 날짜 계산을 위해 칼렌다 변수를 선언 및 생성한다
		Calendar cal = Calendar.getInstance();

		// 현재 날짜 및 시간을 어떤 포맷으로 사용할지 포맷을 정해준다	
		SimpleDateFormat df = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");
//		
		dataSet(); 		// 데이터 셋팅
		dataSort();		// 데이터 정렬
//		HeaderPrint(1, df.format(cal.getTime()));	// 헤더인쇄
//		for(int i=0; i<ArrayOneRec.size(); i++){ //내용인쇄
//			ItemPrint(i);
//		}
		
		int pageNum = 10;
		int maxLoop = ArrayOneRec.size() % (double)pageNum != 0 ?  (ArrayOneRec.size() / pageNum)+1:ArrayOneRec.size() / pageNum ;
		int pageCount = 1;
		int dataCount = 0;
		int dataStart = 0;
		
		for(int i = 0; i<maxLoop; i++){
			HeaderPrint(pageCount,df.format(cal.getTime()));
			if (i == maxLoop - 1) {
				if(Main3.iPerson % pageNum != 0){
					pageNum= Main3.iPerson % pageNum;
				}
			}
			for(int j=dataStart; j<dataStart+pageNum; j++){
				ItemPrint(j);
//				dataCouEut.printf(" %d\n", maxLoop);
				dataCount++;
			}
			dataStart = (i+1)* pageNum;
			TailPrint(pageNum, dataCount); // 꼬리인쇄
			pageCount++;
		}
		pageNum=0;
		
	}
	
	static ArrayList<OneRec> ArrayOneRec = new ArrayList<>();

	static int sumKor=0;
	static int sumEng=0;
	static int sumMat=0;
	static int sumSum=0;
	static int sumAve=0;
	static int sumKorTotal=0;
	static int sumEngTotal=0;
	static int sumMatTotal=0;
	static int sumSumTotal=0;
	static int sumAveTotal=0;
	static final int iPerson=52;
	
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
			ArrayOneRec.add(new OneRec(i+1,name,kor,eng,mat)); // 하나의 OneRec클래스를 생성 후 ArrayList에 집어넣었다.

//			System.out.println(i);
		}
	}
	
	// 헤더 인쇄
	public static void HeaderPrint(int page, String cal){
		// 날짜 계산을 위해 칼렌다 변수를 선언 및 생성한다
//		Calendar cal1 = Calendar.getInstance();
//
//		// 현재 날짜 및 시간을 어떤 포맷으로 사용할지 포맷을 정해준다
//		SimpleDateFormat df = new SimpleDateFormat("YYYY.MM.DD HH:mm:ss");
		
		System.out.printf("%20.20s\n", "성적집계표");
		System.out.printf("%-4.4s: %-2d %40.40s\n", "PAGE", page, "출력일자 :" + cal);
		System.out.printf("====================================================\n");
		System.out.printf("%4s %4s %5s %3s %3s %3s %4s\n", "번호","이름","국어","영어","수학","합계","평균");
		System.out.printf("====================================================\n");
	}
	
	// 내용 인쇄
	public static void ItemPrint(int i){
		OneRec rec;
		
		rec=ArrayOneRec.get(i);
		System.out.printf("%4d %8s %4d %4d %5d  %4d  %5d\n", rec.student_id(), rec.name(), rec.kor(), rec.eng(), rec.mat(), rec.sum(), (int)rec.ave());
		
		sumKor+=rec.kor();
		sumEng+=rec.eng();
		sumMat+=rec.mat();
		sumSum+=rec.sum();
		sumAve+=rec.ave();
		sumKorTotal+=rec.kor();
		sumEngTotal+=rec.eng();
		sumMatTotal+=rec.mat();
		sumSumTotal+=rec.sum();
		sumAveTotal+=rec.ave();
	}
	
	// 꼬리 인쇄
	public static void TailPrint(int pageNum, int dataCount){
		System.out.printf("====================================================\n");
		System.out.printf("%-31.31s\n", "현재페이지");
		System.out.printf("%-10.10s %7d %5d %5d %5d %5d\n", "합계", sumKor, sumEng, sumMat, sumSum, sumAve);
		System.out.printf("%-10.10s %7d %5d %5d %5d %5d\n", "평균", sumKor/pageNum, sumEng/pageNum, sumMat/pageNum, sumSum/pageNum, sumAve/pageNum);
//		System.out.printf("평균 %10d\n",sumEng, sumEng/(double)ArrayOneRec.size());
//		System.out.printf("수학합계 %d	수학평균: %6.2f\n",sumMat, sumMat/(double)ArrayOneRec.size());
		sumKor=0;
		sumEng=0;
		sumMat=0;
		sumSum=0;
		sumAve=0;
		System.out.printf("====================================================\n");
		System.out.printf("%-31.31s\n", "누적페이지");
		System.out.printf("%-10.10s %7d %5d %5d %5d %5d\n", "합계", sumKorTotal, sumEngTotal, sumMatTotal, sumSumTotal, sumAveTotal);
		System.out.printf("%-10.10s %7d %5d %5d %5d %5d\n", "평균", sumKorTotal/dataCount, sumEngTotal/dataCount, sumMatTotal/dataCount, sumSumTotal/dataCount, sumAveTotal/dataCount);
//		System.out.println(dataCount);
		System.out.println();
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
