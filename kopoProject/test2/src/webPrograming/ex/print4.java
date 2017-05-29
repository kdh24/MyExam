package webPrograming.ex;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class print4 {
	public static void main(String[] args) {
		// 1000(천) 단위마다 콤마 처리를 하기 위한 DecimalFormat 객체 생성 및 포맷 지정
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		
		// 날짜값을 가져오기 위한 Calendar 객체 생성 및 선언
		Calendar k07_cal = Calendar.getInstance();
		// 날짜를 지정해주는 포맷으로 출력하기 위한 SimpleDateFormat 클래스
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm");
		
		// String 배열에 각 항목을 순차적으로 입력해준다.
		String [] OneRec= {
				"01   초코파이       4,000         2       8,000",
				"02   바나나우유     1,000         4       4,000",
				"03   건포도         3,300         1       3,300",
				"04   오렌지주스     2,500         3       7,500",
				"05   초코에몽         800         5       4,100",
				"06   칠성사이다     1,700         3       5,100",
				"07   우유속모카     1,500         6       9,000",
				"08   맥스봉         1,000         2       2,000",
				"09   빼빼로         1,200         1       1,200",
				"10   볼펜             700         2       1,400",
				"11   서울우유1000L  2,900         3       8,700",
				"12   짜파게티       1,400         4       5,600",
				"13   신라면         1,500         2       3,000",
				"14   햇반           2,000         1       2,000",
				"15   좋은데이       1,700         1       1,700",
				"16   요플레         3,500         2       7,000",
				"17   어묵400g       1,300         3       3,900",
				"18   오뚜기케찹     2,800         4      11,200",
				"19   오뚜기진라면   1,400         1       1,400",
				"20   두부200g       1,500         1       1,500",
				"21   콘푸로스트     4,000         3      12,200",
				"22   맥심카누       2,200         5      11,000",
				"23   참이슬         1,600         6       9,600",
				"24   오비맥주       2,500         2       5,000",
				"25   칭따오         3,000         3       9,000",
				"26   안성탕면       1,500         2       3,000",
				"27   제주삼다수     1,000         1       1,000",
				"28   농심백산수     1,100         1       1,100",
				"29   호떡믹스       3,000         3       9,000",
				"30   파프리카       2,600         4      10,400"};

		// 토탈 바이트 47
		// OneRec 배열의 각각의 항목에 대한 상품번호, 상품명, 상품가격, 수량, 총액을  처리랄 변수 선언
		String k07_pId = null;	// 상품 번호
		String k07_pName = null;	// 상품명
		int k07_pPrice = 0;	// 상품가격
		int k07_pNum = 0;	// 구매수량
		int k07_pTotal = 0;	// 총액

		// OneRec 배열의 길이만큼 반복해서 처리해주는 for 반복문
		for(int i=0; i<OneRec.length; i++){
			// 토탈 바이트 47
			//OneRec 배열의 각각의 항목에 대한 상품번호, 상품명, 상품가격, 수량, 총액의 값을 
			// 각각의 변수에 대입해준다(각각의 위치에 해당하는 Byte 값으로 가져와서 콤마는 없애주고 앞뒤 공백도 제거해준다)
			k07_pId = new String(OneRec[i].getBytes(),0,4);	// 상품명
			k07_pName = new String(OneRec[i].getBytes(),5,15);	// 상품명
			k07_pPrice = Integer.parseInt(new String(OneRec[i].getBytes(),20,10).trim().replaceAll(",", ""));	// 상품가격
			k07_pNum = Integer.parseInt(new String(OneRec[i].getBytes(),30,10).trim().replaceAll(",", ""));	// 구매수량
			k07_pTotal = Integer.parseInt(new String(OneRec[i].getBytes(),40,7).trim().replaceAll(",", ""));	// 총액
			
			// 배열에서 가져온 가격과 수량을 곱한 값이 총액과 맞지 않으면 실행
			if(k07_pPrice * k07_pNum != k07_pTotal){
				System.out.printf("****************************************************\n");
				// 오류값에 대한 부분을 화면에 출력해준다
				System.out.printf("오류[%s]\n",OneRec[i].toString());
				// 마지막 계산값이 잘못되었으므로 제대로 된 계산값을 구해 해당 위치만 바꿔서 다시 넣어준다.
				// replaceAll 함수를 사용한다.
				OneRec[i]= OneRec[i].toString().replaceAll(new String(OneRec[i].getBytes(),40,7).trim(), df.format(k07_pPrice*k07_pNum));

				// 마지막 계산값을 제대로 된 값으로 변경해줬으므로 바뀐 값을 다시 출력해서 확인한다
				System.out.printf("수정[%s]\n",OneRec[i].toString());
				System.out.printf("****************************************************\n");
			}
		}
	}
}


