package webPrograming.ex;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class print3_2 {
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

	public static void main(String[] args) {
		// 숫자를 String 값으려 출력할때 1000(천) 단위마다 콤마(,)를 표시하도록 정해준다.
		DecimalFormat k07_df = new DecimalFormat("###,###,###,###,###");
		// 날짜 계산을 위해 칼렌다 변수를 선언 및 생성한다
		Calendar k07_cal = Calendar.getInstance();
		// 현재 날짜 및 시간을 어떤 포맷으로 사용할지 포맷을 정해준다		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm");

		int num = 0;
		// 구매할 품목명을 String 배열에 순차적으로 30개를 저장시켜 놓았다
		String [] k07_itemName = {"초코파이", "돌김", "빅파이2000", "감귤주스", "아침햇살",
				"칠성사이다", "우유속모카", "고구마", "빼빼로", "맥콜",
				"닭꼬치", "짜파게티", "신라면", "햇반", "좋은데이",
				"요플레", "어묵400g", "오뚜기케찹", "오뚜기진라면", "두부200g",
				"오징어땅콩", "맥심카누", "감자", "오비맥주", "칭따오",
				"오뚜기카레", "감자 400g", "농심백산수", "호떡믹스", "파프리카"}; // 항목명 30개이상
// 구매할 품목의 가격에 해당하는 금액을 int형 배열에 30개 저장
int [] k07_price = {1400, 1241, 3300, 2500, 820,
			17500, 10500, 1000, 1200, 7100,
			1000, 1400, 1500, 2400, 1700,
			1500, 1300, 2800, 1600, 31500,
			230, 2200, 1900, 8500, 1000,
			800, 1400, 400, 7000, 5600};
// 구매할 상품을 몇개나 살지 int형 배열에 저장시켰다
int [] k07_num={8,4,1,3,5,
		3,6,4,1,7,
		3,5,2,1,1,
		2,3,2,1,1,
		3,5,6,2,3,
		2,1,2,3,4};
// 구매할 품목의 상품이 면세상품인지 과세상품인지 true와 false로 구분해서 
// boolean형 배열에 순차적으로 저장했다
boolean [] k07_taxfree={false, true, false, false, true,
	false, true, false, true, false,
	false, false, false, false, false,
	true, false, false, false, false,
	false, false, true, false, true,
	true, true, false, false, false};
		
		
		// 상품의 세전 가격을 저장할 변수
		int k07_beforeTax =0;
		// 상품별 세전가격의 누적값을 저장할 변수
		int k07_beforeTaxSum = 0;
		// 과세 상품의 세금값을 저장할 변수
		int k07_tax = 0;
		// 면세 상품의 누적가격을 저장할 변수
		int k07_freeSum=0;
		// 과세상품의 세금값을 누적시킬 변수
		int k07_taxSum=0;
		// 물건의 총 금액을 저장할 변수
		int k07_sum=0;

		// 출력을 원하는 크기만큼 해당 텍스트를 출력해준다
		System.out.printf("%-30.30s\n", "영수증 미지참시 교환/환불 불가(30일내)");
		System.out.printf("%-30.30s\n", "교환/환불 구매점에서 가능(결제카드지참)");
		System.out.printf("%-30.30s\n", "체크카드/신용카드 청구취소 반영은");
		System.out.printf("%-30.30s\n\n", "최대 3''5일 소요 (주말,공휴일제외)");

		// 현재 날짜 및 시간을 지정해준 포맷으로 출력
		System.out.printf("%-6.6s%-20.20s %-13.13s\n", "[구  매]", sdf.format(k07_cal.getTime()), "POS:0009-2418");
		System.out.printf("---------------------------------------------------------\n");
		System.out.printf("%10.10s %20.20s %8.8s %8.8s\n", "상  품  명", "단  가", "수  량", "금  액");
		System.out.printf("---------------------------------------------------------\n");

		// 배열에 순차적으로 저장되어 있는 내용을 순차적으로 가져와서 출력해주는 부분
		// 배열의 크기가 0부터 29까지 30개가 있으므로 30번 반복해서 실행이 된다
		for(int i=0; i<k07_itemName.length; i++){
//			if(k07_itemName[i].getBytes().length>20){
//				k07_itemName[i]=new String(k07_itemName[i].getBytes(), 0, 20);
//			}
//			for(int j=0; j<20-(k07_itemName[i].getBytes().length);j++){
//				k07_itemName[i]=k07_itemName[i]+" ";
//			}
			String iName = HanBlackBackword(k07_itemName[i], 24);
			
			// 상품명에 한글이 몇개 들어있는지 확인해서 14.14s 에서 그만큼 숫자를 빼줘서 출력해준다
			System.out.printf("%-5.5s%s" +
			// 삼항연산자를 사용해서 상품번호가 10보다 작으면 숫자 앞에 0을 붙여주고 면세물품이면 뒤에 *를 더해준다
					 "%6.6s%10.10s%12.12s\n", (i+1 < 10 ? "0"+String.valueOf(i+1) : i+1) + ((k07_taxfree[i] == true) ? "*" : ""),
					 				iName, k07_df.format(k07_price[i]), k07_df.format(k07_num[i]), k07_df.format(k07_price[i]*k07_num[i]));

			// 상품이 과세물품이라면 세전금액과 세금 부분을 계산해준다.
			if (k07_taxfree[i] == true) {
				// 면세 상품에 대한 값들을 누적시켜준다
				k07_freeSum += k07_price[i]*k07_num[i];
			}else	// 면세상품에 대한 처리
				k07_beforeTaxSum += k07_price[i]*k07_num[i];
			
			// 면세와 과세를 모두 포함한 전체 상품에 대한 누적값을 sum 변수에 저장
			k07_sum+= k07_price[i]*k07_num[i];
			
		}
		k07_beforeTax = (int)((k07_beforeTaxSum+1)/1.1);
		// 각각의 변수 값을 정해진 길이대로 화면에 출력해준다
		System.out.printf("%30.30s %22.22s\n", "(*)면 세  물 품", k07_df.format(k07_freeSum));
		System.out.printf("%30.30s %22.22s\n", "과 세  물 품", k07_df.format((int)(k07_beforeTax)));
		System.out.printf("%31.31s %22.22s\n", "부   가   세", k07_df.format(k07_beforeTaxSum-k07_beforeTax));
		System.out.printf("%32.32s %22.22s\n", "합        계", k07_df.format(k07_sum));
		System.out.printf("%-28.28s%23.23s\n", "결 제 대 상 금 액", k07_df.format(k07_sum));
		System.out.printf("---------------------------------------------------------\n");
		System.out.printf("%-30.30s%25.25s\n", "0024 하 나", "5417**8890/07850246");
		System.out.printf("%-25.25s%25.25s\n", "카드결제", "일시불 / "+ k07_df.format(k07_sum));
		System.out.printf("---------------------------------------------------------\n");
	}
}


