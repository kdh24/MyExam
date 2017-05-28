package webPrograming.stringBuffer;

import java.util.ArrayList;

public class Aprint {

//	public static void main(String[] args) {
//		OneRec OneRec;

		static ArrayList<OneRec> ArrayOneRec = new ArrayList<OneRec>();
		
		static int sumkor=0;
		static int sumeng=0;
		static int summat=0;
		static int sumsum=0;
		static int sumave=0;
		static final int iPerson = 20;
		
		//데이터 만들기
		public static void dataSet(){
			for(int i=0; i<iPerson; i++){
				String name=String.format("홍길%02d", i);	//이름만들기
				int kor = (int)(Math.random()*100);	//국어점수 만들기
				int eng = (int)(Math.random()*100);	//영어점수 만들기
				int mat = (int)(Math.random()*100);	//수학점수 만들기
				ArrayOneRec.add(new OneRec(i,name,kor,eng,mat)); // 하나의 OneRec클래스를 생성 후 ArrayList에 집어넣었다.
			}
		}
//	}

}
