package webPrograming.ex;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class print3_1 {
	public static int k07_HanCount(String k07_Han) {

	int k07_count=0;
	
	for(int i=0; i<k07_Han.length(); i++){
		if(k07_Han.substring(i, i+1).getBytes().length >1){
			k07_count += 1;
		}
	}
	
	return k07_count;
}
	public static void main(String[] args) {
		DecimalFormat k07_df = new DecimalFormat("###,###,###,###,###");
		
		Calendar k07_cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm");
		
		String [] k07_itemName = {"초코파이", "바나나우유", "건포도", "오렌지주스", "초코에몽",
							"칠성사이다", "우유속모카", "맥스봉", "빼빼로", "볼펜",
							"서울우유1000L", "짜파게티", "신라면", "햇반", "좋은데이",
							"요플레", "어묵400g", "오뚜기케찹", "오뚜기진라면", "두부200g",
							"콘푸로스트", "맥심카누", "참이슬", "오비맥주", "칭따오",
							"안성탕면", "제주삼다수", "농심백산수", "호떡믹스", "파프리카"}; // 항목명 30개이상
		int [] k07_price = {4000, 1000, 3300, 2500, 800,
						1700, 1500, 1000, 1200, 700,
						2900, 1400, 1500, 2000, 1700,
						3500, 1300, 2800, 1400, 1500,
						4000, 2200, 1600, 2500, 3000,
						1500, 1000, 1100, 3000, 2600};
		int [] k07_num={2,4,1,3,5,
					3,6,2,1,2,
					3,4,2,1,1,
					2,3,4,1,1,
					3,5,6,2,3,
					2,1,1,3,4};
		boolean [] k07_taxfree={true, true, false, true, true,
				true, true, false, true, true,
				true, true, true, true, false,
				true, true, true, true, true,
				false, true, false, true, true,
				true, true, false, true, false};
		
		int k07_beforeTax =0;
		int k07_beforeTaxSum = 0;
		int k07_tax = 0;
		int k07_freeSum=0;
		int k07_taxSum=0;
		int k07_sum=0;

		System.out.printf("%-30.30s\n", "영수증 미지참시 교환/환불 불가(30일내)");
		System.out.printf("%-30.30s\n", "교환/환불 구매점에서 가능(결제카드지참)");
		System.out.printf("%-30.30s\n", "체크카드/신용카드 청구취소 반영은");
		System.out.printf("%-30.30s\n\n", "최대 3''5일 소요 (주말,공휴일제외)");

		System.out.printf("%-6.6s%-20.20s %-13.13s\n", "[구  매]", sdf.format(k07_cal.getTime()), "POS:0009-2418");
		System.out.printf("------------------------------------------------\n");
		System.out.printf("%10.10s %10.10s %8.8s %8.8s\n", "상  품  명", "단  가", "수  량", "금  액");
		System.out.printf("------------------------------------------------\n");

		for(int i=0; i<k07_itemName.length; i++){
			System.out.printf("%-5.5s%-" + String.valueOf(14-k07_HanCount(k07_itemName[i])) +"."+String.valueOf(14-k07_HanCount(k07_itemName[i]))+"s" +
					 "%6.6s%10.10s%12.12s\n", i+1 < 10 ? "0"+String.valueOf(i+1) : i+1 + ((k07_taxfree[i] == false) ? "*" : ""), k07_itemName[i], k07_df.format(k07_price[i]), k07_df.format(k07_num[i]), k07_df.format(k07_price[i]*k07_num[i]));

			if (k07_taxfree[i] == false) {
				k07_beforeTax = ((int)(k07_price[i] / 1.1 % 10)) != 0 ? (int)(k07_price[i] / 1.1+5) /10 * 10 : (int)(k07_price[i] / 1.1);
				k07_tax = (int) ((k07_price[i]-k07_beforeTax)*k07_num[i]);
				k07_taxSum += k07_tax;
				k07_beforeTaxSum+= k07_beforeTax*k07_num[i];
			}else
				k07_freeSum += k07_price[i]*k07_num[i];
			
			k07_sum+= k07_price[i]*k07_num[i];
			
		}
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


