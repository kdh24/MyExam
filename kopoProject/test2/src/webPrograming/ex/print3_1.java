package webPrograming.ex;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class print3_1 {
	public static void main(String[] args) {
		HanBlackPrint h_Black = null;

		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		
		Calendar k07_cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm");
		
		String [] itemName = {"초코파이", "바나나우유", "건포도", "오렌지주스", "초코에몽",
							"칠성사이다", "우유속모카", "맥스봉", "빼빼로", "볼펜",
							"서울우유1000L", "짜파게티", "신라면", "햇반", "좋은데이",
							"요플레", "어묵400g", "오뚜기케찹", "오뚜기진라면", "두부200g",
							"콘푸로스트", "맥심카누", "참이슬", "오비맥주", "칭따오",
							"안성탕면", "제주삼다수", "농심백산수", "호떡믹스", "파프리카"}; // 항목명 30개이상
		int [] price = {4000, 1000, 3300, 2500, 800,
						1700, 1500, 1000, 1200, 700,
						2900, 1400, 1500, 2000, 1700,
						3500, 1300, 2800, 1400, 1500,
						4000, 2200, 1600, 2500, 3000,
						1500, 1000, 1100, 3000, 2600};
		int [] num={2,4,1,3,5,
					3,6,2,1,2,
					3,4,2,1,1,
					2,3,4,1,1,
					3,5,6,2,3,
					2,1,1,3,4};
		boolean [] taxfree={true, true, false, true, true,
				true, true, false, true, true,
				true, true, true, true, false,
				true, true, true, true, true,
				false, true, false, true, true,
				true, true, false, true, false};
		
		String product1 = "풀무원샘물";
		String productCode1 = "8809169718205";
		String product2 = "드링킹요구르트";
		String productCode2 = "8801155822828";
		
		int beforeTax;
		int tax;
		int freeSum=0;
		int taxSum=0;
		int sum=0;

		System.out.printf("%-30.30s\n", "영수증 미지참시 교환/환불 불가(30일내)");
		System.out.printf("%-30.30s\n", "교환/환불 구매점에서 가능(결제카드지참)");
		System.out.printf("%-30.30s\n", "체크카드/신용카드 청구취소 반영은");
		System.out.printf("%-30.30s\n\n", "최대 3''5일 소요 (주말,공휴일제외)");

		System.out.printf("%-6.6s%-20.20s %-13.13s\n", "[구  매]", sdf.format(k07_cal.getTime()), "POS:0009-2418");
		System.out.printf("------------------------------------------------\n");
		System.out.printf("%10.10s %10.10s %8.8s %8.8s\n", "상  품  명", "단  가", "수  량", "금  액");
		System.out.printf("------------------------------------------------\n");

		
		int base = itemName[0].getBytes().length/2;
		int number=0;
		int hSum=0;
		
//		for(int i=0 ;i<itemName.length; i++){
//			System.out.println(itemName[i].getBytes().length)/2;
//		}
//		System.out.println(itemName.length);
		
		for(int i=0; i<itemName.length; i++){
//			if(itemName[i].getBytes().length > 0 ){
//				for(int j=0; j<itemName[j].length(); j++){
//					System.out.println(itemName[i].substring(j, j+1).getBytes().length);
//					if(itemName[i].substring(j, j+1).getBytes().length > 1){
//						hSum++;
//					}
//				}
				number = h_Black.HanCount(itemName[i])/2;
				
//			number = base - itemName[i].getBytes().length;
//			h_Black
//			System.out.printf("%-5.5s%-10.10s%6.6s%10.10s%12.12s\n", i+1 < 10 ? "0"+String.valueOf(i+1) : i+1, itemName[i], df.format(price[i]), df.format(num[i]), df.format(price[i]*num[i]));
			
//			if(itemName[i].getBytes().length/2 >=  base){
//				System.out.println("------");
			System.out.printf("%-5.5s%-" + String.valueOf(14-h_Black.HanCount(itemName[i])) +"."+String.valueOf(14-h_Black.HanCount(itemName[i]))+"s" +
					 "%6.6s%10.10s%12.12s\n", i+1 < 10 ? "0"+String.valueOf(i+1) : i+1, itemName[i], df.format(price[i]), df.format(num[i]), df.format(price[i]*num[i]));
//			}else{
//				System.out.printf("%-5.5s%-" + String.valueOf(25+number) +"."+String.valueOf(25+number)+"s" +
//						"%6.6s%10.10s%12.12s\n", i+1 < 10 ? "0"+String.valueOf(i+1) : i+1, itemName[i], df.format(price[i]), df.format(num[i]), df.format(price[i]*num[i]));
//			}
//				
//					i + 1 < 10 ? "0" + String.valueOf(i + 1) : i + 1, itemName[i], df.format(price[i]), df.format(num[i]), df.format(price[i]*num[i]));
//			System.out.printf("%s \t",String.valueOf(itemName[i].getBytes().length));
//			if(itemName[i].getBytes().length > 0 ){
//				System.out.printf("%-5.5s%-" + String.valueOf(14-itemName[i].length()) +"."+String.valueOf(14-itemName[i].length())+"s" +
//			 "%6.6s%10.10s%12.12s\n", i+1 < 10 ? "0"+String.valueOf(i+1) : i+1, itemName[i], df.format(price[i]), df.format(num[i]), df.format(price[i]*num[i]));
//			} else {
//				System.out.printf("%-5.5s%-20.20s" + "%6.6s%10.10s%12.12s\n",
//						i + 1 < 10 ? "0" + String.valueOf(i + 1) : i + 1, itemName[i], df.format(price[i]), df.format(num[i]), df.format(price[i]*num[i]));
//			}
			
			hSum=0;
			number=0;
			
			if(taxfree[i]){
				freeSum += price[i] * num[i];
			}else
				taxSum += price[i] * num[i];
			
		}
		beforeTax = (int)(taxSum/1.1);
//		if(beforeTax % 10 != 0) beforeTax = (beforeTax+5)/10 *10;
		tax = (int)(beforeTax/10.0);
		if(tax % 10 != 0){
			tax = (tax+5)/10 * 10;
			beforeTax = taxSum - tax;
		}

		System.out.printf("%20.20s %22.22s\n", "(*)면 세  물 품", df.format(freeSum));
		System.out.printf("%20.20s %22.22s\n", "과 세  물 품", df.format(taxSum));
		System.out.printf("%21.21s %22.22s\n", "부   가   세", df.format(tax));
		System.out.printf("%22.22s %22.22s\n", "합        계", df.format(tax+taxSum+freeSum));
		System.out.printf("%-18.18s%23.23s\n", "결 제 대 상 금 액", df.format(tax+taxSum+freeSum));
		System.out.printf("------------------------------------------------\n");
		System.out.printf("%-20.20s%25.25s\n", "0024 하 나", "5417**8890/07850246");
		System.out.printf("%-15.15s%25.25s\n", "카드결제", "일시불 / "+ df.format(tax+taxSum+freeSum));
		System.out.printf("------------------------------------------------\n");
	}
}


