package webPrograming.stringBuffer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class Main02 {

	public static void main(String[] args) {
		// 날짜 계산을 위해 칼렌다 변수를 선언 및 생성한다
		Calendar cal = Calendar.getInstance();

		// 현재 날짜 및 시간을 어떤 포맷으로 사용할지 포맷을 정해준다	
		SimpleDateFormat df = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");

		dataSet(); 		// 데이터 셋팅
		dataSort();		// 데이터 정렬
		
		// 한 페이지에 표시할 라인수
		int pageNum = 10;
		// 페이지 라인수에 따라 몇 페이지까지 표시할건지 지정하는 변수
		int maxLoop = ArrayOneRec.size() % (double)pageNum != 0 ?  
				(ArrayOneRec.size() / pageNum)+1:ArrayOneRec.size() / pageNum ;
		// 현재 몇 번째 페이지를 출력하는지 알려주는 변수
		int pageCount = 1;
		// 현재 몇번째 데이터를 출력하는지 알려주는 변수
		int dataCount = 0;
		// 페이지에 따른 몇번째 데이터부터 출력해야 되는지 지정하는 변수
		int dataStart = 0;
		
		// 페이지출력을 위해 순차적으로 반복되는 반복문  
		for(int i = 0; i<maxLoop; i++){
			
			//헤더부분을 출력을 위한 함수 호출 매개변수로 페이지값과 현재 시간값을 넘겨준다
			HeaderPrint(pageCount,df.format(cal.getTime()));
			// 마지막 페이지일때 전체 인원수를 라인수로 나누었을때 0으로 딱 떨어지지 않으면
			// 출력할 라인수를 그 나머지 값으로 줌으로써 인원에 맞게 출력되게 처리해준다.
			if (i == maxLoop - 1) {
				if(Main02.iPerson % pageNum != 0){
					pageNum= Main02.iPerson % pageNum;
				}
				
			}
			// 페이지수에 따른 데이터의 시작부터 끝까지 반복해서 내용을 출력해주는 반복문
			for(int j=dataStart; j<dataStart+pageNum; j++){
				
				// 내용을 순서대로 출력
				ItemPrint(j);
//				dataCouEut.printf(" %d\n", maxLoop);
				// 몇번째 데이터를 처리중인지 확인하기 위한 dataCount 변수
				dataCount++;
			}
			// 처음 페이지 출력을 하고 나면 i+1 변수에 라인수를 곱해서 다음 데이터 시작점을 저장해준다
			dataStart = (i+1)* pageNum;
			// 전체 데이터 마지막 꼬리 부분을 출력하기 위한 함수 호출
			// 페이지 라인수와 몇번째 데이터를 처리중인지를 매개변수로 보내어 처리해준다
			TailPrint(pageNum, dataCount); // 꼬리인쇄
			// 현재 몇번째 페이지를 출력하는지 확인하기 위한 pageCount 변수
			pageCount++;
		}
		
		
	}
	
	// OneRec 클래스를 ArrayList로 사용하기 위해 ArrayOneRec 이름으로 선언 및 생성해준다
	static ArrayList<OneRec> ArrayOneRec = new ArrayList<>();

	// 페이지별 누적값(국어, 영어, 수학, 총점, 평균)을 처리하기 위한 변수들
	static int sumKor=0;
	static int sumEng=0;
	static int sumMat=0;
	static int sumSum=0;
	static int sumAve=0;
	// 전체 누적값(국어, 영어, 수학, 총점, 평균)을 처리하기 위한 변수들	
	static int sumKorTotal=0;
	static int sumEngTotal=0;
	static int sumMatTotal=0;
	static int sumSumTotal=0;
	static int sumAveTotal=0;
	// 전체 학생수를 정해주는 상수
	static final int iPerson=200;
	
	//데이터 만들기
	public static void dataSet(){
		String name = null;
		int kor = 0;
		int eng = 0;
		int mat = 0;
		// iPerson 상수의 값만큼 학생수를 초기화하기 위한 반복문
		for(int i=0; i<iPerson; i++){
			// 각각의 값을 생성해서 변수에 저장해준다
			name = String.format("홍길%02d", i); // 이름 만들기
			// Math.random 랜덤함수를 이용해서 각각의 변수에 저장해준다
			kor = (int)(Math.random()*100);	//국어점수 만들기
			eng = (int)(Math.random()*100);	//영어점수 만들기
			mat = (int)(Math.random()*100);	//수학점수 만들기
			// 위에서 구한 각각의 값들을 초기값으로 ArrayOneRec에 추가해준다.
			ArrayOneRec.add(new OneRec(i+1,name,kor,eng,mat)); // 하나의 OneRec클래스를 생성 후 ArrayList에 집어넣었다.
		}
	}
	
	// 헤더 인쇄
	// 매개변수로 현재 페이지값과 날짜표현 값을 넘겨받아 헤드 부분 출력을 처리한다
	public static void HeaderPrint(int page, String cal){
		// 각각의 값들을 정해준 길이대로 출력해준다
		System.out.printf("%20.20s\n", "성적집계표");
		// 현재 페이지 값과 출력일자 및 시간 출력
		System.out.printf("%-4.4s: %-2d %40.40s\n", "PAGE", page, "출력일자 :" + cal);
		System.out.printf("====================================================\n");
		// 내용 출력때 헷갈리지 않게 각 항목의 제목 출력
		System.out.printf("%4s %4s %5s %3s %3s %3s %4s\n", "번호","이름","국어","영어","수학","합계","평균");
		System.out.printf("====================================================\n");
	}
	
	// 내용 인쇄
	public static void ItemPrint(int i){
		// OneRec 클래스의 메소드를 이용하기 위해 rec란 객체명으로 선언해준다.
		OneRec rec;
		
		// rec 변수에 ArrayList에서 불러온 OneRec 객체를 저장시켜준다.
		rec=ArrayOneRec.get(i);
			
		// ArrayList에서 불러온 OneRec 객체의 값을 각 항목별로 가져와서 출력해준다.
		System.out.printf("  %03d %6s %5d %5d %5d  %4d  %4d\n", 
				rec.student_id(), rec.name(), rec.kor(), rec.eng(), rec.mat(), rec.sum(), (int)rec.ave());
		
		// 페이지별 누적값(국어, 영어, 수학, 총점, 평균)을 처리하기 위한 변수들
		sumKor+=rec.kor();
		sumEng+=rec.eng();
		sumMat+=rec.mat();
		sumSum+=rec.sum();
		sumAve+=rec.ave();
		// 전체 누적값(국어, 영어, 수학, 총점, 평균)을 처리하기 위한 변수들
		sumKorTotal+=rec.kor();
		sumEngTotal+=rec.eng();
		sumMatTotal+=rec.mat();
		sumSumTotal+=rec.sum();
		sumAveTotal+=rec.ave();
	}
	
	// 꼬리 인쇄
	// 페이지별 라인수와 현재 데이터 처리 갯수를 넘겨받아 처리해준다.
	public static void TailPrint(int pageNum, int dataCount){
		System.out.printf("====================================================\n");
		System.out.printf("%-31.31s\n", "현재페이지");
		// 페이지별 누적값을 가져와서 출력해준다
		System.out.printf("%-10.10s %7d %5d %5d %5d %5d\n", "합계",
				sumKor, sumEng, sumMat, sumSum, sumAve);
		// 페이지별 누적값에 페이지별 라인수를 가져와서 나누기(/) 함으로써 평균값을 구해서 출력해준다.
		System.out.printf("%-10.10s %7d %5d %5d %5d %5d\n", "평균",
				sumKor/pageNum, sumEng/pageNum, sumMat/pageNum, sumSum/pageNum, sumAve/pageNum);
//		System.out.printf("평균 %10d\n",sumEng, sumEng/(double)ArrayOneRec.size());
//		System.out.printf("수학합계 %d	수학평균: %6.2f\n",sumMat, sumMat/(double)ArrayOneRec.size());
		// 다음 페이지별 누적값을 구하기 위해 변수를 초기화 시켜준다.
		sumKor=0;
		sumEng=0;
		sumMat=0;
		sumSum=0;
		sumAve=0;
		
		System.out.printf("====================================================\n");
		System.out.printf("%-31.31s\n", "누적페이지");
		// 전체 누적값 변수의 내용을 화면에 출력해준다.
		System.out.printf("%-10.10s %7d %5d %5d %5d %5d\n", "합계",
				sumKorTotal, sumEngTotal, sumMatTotal, sumSumTotal, sumAveTotal);
		// 전체 누적값을 현재 데이터처리 갯수로 나누어 평균을 구해서 화면에 출력해준다.
		System.out.printf("%-10.10s %7d %5d %5d %5d %5d\n", "평균",
				sumKorTotal/dataCount, sumEngTotal/dataCount, sumMatTotal/dataCount, sumSumTotal/dataCount, sumAveTotal/dataCount);
//		System.out.println(dataCount);
		System.out.println();
	}
	
	// ArrayList 정렬
	public static void dataSort(){
		// OneRec 클래스를 정렬하기 위해 Comparator
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


