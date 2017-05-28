package webPrograming.ex;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class print3_1 {
	// 한글 숫자를 계산하는 한글 카운터 클래스
	// 매개변수로 String 값을 넘겨받아 처리해준뒤 한글 갯수가 몇개인지 int형 값으로 리턴해준다
	public static int k07_HanCount(String k07_Han) {
		// 매개변수 Han 변수에 한글이 몇개나 있는지 확인해서 int 형 갯수를 저장하기 위한 변수
		int k07_count = 0;

		// String 변수 Han의 길이만큼 반복해서 연산하는 for 반복문
		for (int i = 0; i < k07_Han.length(); i++) {
			// 정해준 위치의 값을 가져오는 substring 변수를 이용해서
			// i값부터 i+1의 값을 계속 가져와 처음부터 끝까지 한글자씩 가져오고
			// 그 바이트의 값이 1을 넘으면 한글(2바이트)이므로 if문을 실행시킨다
			if (k07_Han.substring(i, i + 1).getBytes().length > 1) {
				// 한글일때 실행하므로 갯수를 증가시켜준다
				k07_count += 1;
			}
		}
		// 한글 갯수를 리턴값으로 넘겨준다
		return k07_count;
	}

	public static void main(String[] args) {
		// 숫자를 String 값으려 출력할때 1000(천) 단위마다 콤마(,)를 표시하도록 정해준다.
		DecimalFormat k07_df = new DecimalFormat("###,###,###,###,###");
		// 날짜 계산을 위해 칼렌다 변수를 선언 및 생성한다
		Calendar k07_cal = Calendar.getInstance();
		// 현재 날짜 및 시간을 어떤 포맷으로 사용할지 포맷을 정해준다		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm");
		
		// 구매할 품목명을 String 배열에 순차적으로 30개를 저장시켜 놓았다
		String [] k07_itemName = {"초코파이", "바나나우유", "건포도", "오렌지주스", "초코에몽",
							"칠성사이다", "우유속모카", "맥스봉", "빼빼로", "볼펜",
							"서울우유1000L", "짜파게티", "신라면", "햇반", "좋은데이",
							"요플레", "어묵400g", "오뚜기케찹", "오뚜기진라면", "두부200g",
							"콘푸로스트", "맥심카누", "참이슬", "오비맥주", "칭따오",
							"안성탕면", "제주삼다수", "농심백산수", "호떡믹스", "파프리카"}; // 항목명 30개이상
		// 구매할 품목의 가격에 해당하는 금액을 int형 배열에 30개 저장
		int [] k07_price = {4000, 1000, 3300, 2500, 800,
						1700, 1500, 1000, 1200, 700,
						2900, 1400, 1500, 2000, 1700,
						3500, 1300, 2800, 1400, 1500,
						4000, 2200, 1600, 2500, 3000,
						1500, 1000, 1100, 3000, 2600};
		// 구매할 상품을 몇개나 살지 int형 배열에 저장시켰다
		int [] k07_num={2,4,1,3,5,
					3,6,2,1,2,
					3,4,2,1,1,
					2,3,4,1,1,
					3,5,6,2,3,
					2,1,1,3,4};
		// 구매할 품목의 상품이 면세상품인지 과세상품인지 true와 false로 구분해서 
		// boolean형 배열에 순차적으로 저장했다
		boolean [] k07_taxfree={true, true, false, true, true,
				true, true, false, true, true,
				true, true, true, true, false,
				true, true, true, true, true,
				false, true, false, true, true,
				true, true, false, true, false};
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
		System.out.printf("------------------------------------------------\n");
		System.out.printf("%10.10s %10.10s %8.8s %8.8s\n", "상  품  명", "단  가", "수  량", "금  액");
		System.out.printf("------------------------------------------------\n");

		// 배열에 순차적으로 저장되어 있는 내용을 순차적으로 가져와서 출력해주는 부분
		// 배열의 크기가 0부터 29까지 30개가 있으므로 30번 반복해서 실행이 된다
		for(int i=0; i<k07_itemName.length; i++){
			// 상품명에 한글이 몇개 들어있는지 확인해서 14.14s 에서 그만큼 숫자를 빼줘서 출력해준다
			System.out.printf("%-5.5s%-" + String.valueOf(14-k07_HanCount(k07_itemName[i])) +"."+String.valueOf(14-k07_HanCount(k07_itemName[i]))+"s" +
			// 삼항연산자를 사용해서 상품번호가 10보다 작으면 숫자 앞에 0을 붙여주고 면세물품이면 뒤에 *를 더해준다
					 "%6.6s%10.10s%12.12s\n", i+1 < 10 ? "0"+String.valueOf(i+1) : i+1 + ((k07_taxfree[i] == false) ? "*" : ""), k07_itemName[i], k07_df.format(k07_price[i]), k07_df.format(k07_num[i]), k07_df.format(k07_price[i]*k07_num[i]));

			// 상품이 과세물품이라면 세전금액과 세금 부분을 계산해준다.
			if (k07_taxfree[i] == false) {
				// 세전 금액을 구하기 위해 소비자 가격에서 1.1을 나눠준다 
				// 나머지가 0으로 딱 떨어지지 않으면 5를 더해서 10으로 나누고 곱해주어 반올림 처리를 해준다
				k07_beforeTax = ((int)(k07_price[i] / 1.1 % 10)) != 0 ? (int)(k07_price[i] / 1.1+5) /10 * 10 : (int)(k07_price[i] / 1.1);
				// 구매 상품과 수량에 따른 세금을 계산해준다
				k07_tax = (int) ((k07_price[i]-k07_beforeTax)*k07_num[i]);
				// 구한 세금을 세금 총합 변수 taxSum에 누적시켜준다
				k07_taxSum += k07_tax;
				// 세전금액의 총합을 beforeTaxSum 변수에 누적시켜준다
				k07_beforeTaxSum+= k07_beforeTax*k07_num[i];
			}else	// 면세상품에 대한 처리
				k07_freeSum += k07_price[i]*k07_num[i];
			
			// 면세와 과세를 모두 포함한 전체 상품에 대한 누적값을 sum 변수에 저장
			k07_sum+= k07_price[i]*k07_num[i];
			
		}
		// 각각의 변수 값을 정해진 길이대로 화면에 출력해준다
		System.out.printf("%20.20s %22.22s\n", "(*)면 세  물 품", k07_df.format(k07_freeSum));
		System.out.printf("%20.20s %22.22s\n", "과 세  물 품", k07_df.format(k07_beforeTaxSum));
		System.out.printf("%21.21s %22.22s\n", "부   가   세", k07_df.format(k07_taxSum));
		System.out.printf("%22.22s %22.22s\n", "합        계", k07_df.format(k07_beforeTaxSum+k07_taxSum+k07_freeSum));
		System.out.printf("%-18.18s%23.23s\n", "결 제 대 상 금 액", k07_df.format(k07_sum));
		System.out.printf("------------------------------------------------\n");
		System.out.printf("%-20.20s%25.25s\n", "0024 하 나", "5417**8890/07850246");
		System.out.printf("%-15.15s%25.25s\n", "카드결제", "일시불 / "+ k07_df.format(k07_sum));
		System.out.printf("------------------------------------------------\n");
	}
}


