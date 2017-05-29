package webPrograming.ex;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class print2 {
	public static void main(String[] args) {
		// 숫자를 String 값으려 출력할때 1000(천) 단위마다 콤마(,)를 표시하도록 정해준다.
		DecimalFormat k07_df = new DecimalFormat("###,###,###,###,###");
		// 날짜 계산을 위해 칼렌다 변수를 선언 및 생성한다
		Calendar k07_cal = Calendar.getInstance();
		// 현재 날짜 및 시간을 어떤 포맷으로 사용할지 포맷을 정해준다		
		SimpleDateFormat k07_sdf = new SimpleDateFormat("YYYY/MM/dd");
		SimpleDateFormat k07_sdf2 = new SimpleDateFormat("YYYYMMdd");
		
		// 상품명과 상품코드에 대한 변수
		String k07_product1 = "풀무원샘물";
		String k07_productCode1 = "123648912354";
		String k07_product2 = "드링킹요구르트";
		String k07_productCode2 = "145612777";
		
		// 상품가격과 상품 구매 수량에 관한 변수 선언 및 초기화
		int k07_p_price1=600;
		int k07_p_price2=1600;
		int k07_p_num1=1;
		int k07_p_num2=1;
		// 상품 가격과 수량을 곱해서 총 가격을 구하는 변수 sum
		int k07_sum = k07_p_price1*k07_p_num1+k07_p_price2*k07_p_num2;
		
		// 총액을 기준으로 세전금액을 구해 저장하는 변수 총액에서 1.1으로 나눠준다 10프로(0.1)가 세금 
		int k07_beforeTax = (int)((k07_sum+0.1)/1.1);
		// 세금이 10프로를 차지하므로 세전금액에서 10.0으로 나누어 세금을 구한다
		int k07_tax = k07_sum-k07_beforeTax;
		
		// % 다음에 -표시를 해주면 왼쪽 정렬이 되고 정해진 길이대로 문자열을 출력해준다
		System.out.printf("%-100.100s\n", "충주(양평)휴게소");
		System.out.printf("%-100.100s\n", "충북충주시가금면용전리380-4");
		System.out.printf("%-100.100s\n", "최병권 677-85-00239  TEL:043-857-9229");
		System.out.printf("\n\n%-8.8s%-8.8s %-8.8s %-15.15s\n", "[정상등록]",k07_sdf2.format(k07_cal.getTime()), "190049", "POS번호: 0002");
		System.out.printf("-------------------------------------------------\n");
		System.out.printf("%-25.25s %-4.4s%-4.4s %4.4s\n", "품목코드", "단가","수량","금액");
		System.out.printf("-------------------------------------------------\n");
		// 구매 상품명과 가격 수량에 대한 변수를 정해진 형식대로 출력해준다 
		System.out.printf("%-100.100s\n", k07_product1+k07_product1);
		System.out.printf("%-28.28s%6.6s%5.5s%10.10s\n", k07_productCode1, k07_df.format(k07_p_price1),
				k07_df.format(k07_p_num1), k07_df.format(k07_p_price1*k07_p_num1));
		System.out.printf("%-100.100s\n", k07_product2+k07_product2);
		System.out.printf("%-28.28s%6.6s%5.5s%10.10s\n", k07_productCode2, k07_df.format(k07_p_price2),
				k07_df.format(k07_p_num2), k07_df.format(k07_p_price2*k07_p_num2));
		// 세전금액, 세금, 총액 등 각각의 금액을 변수를 이용해서 화면에 출력해준다
		System.out.printf("%-10.10s%33.33s\n", "과세  물품  합계", k07_df.format(k07_beforeTax));
		System.out.printf("%-13.13s%33.33s\n", "부     가     세", k07_df.format(k07_tax));
		System.out.printf("%-14.14s%33.33s\n", "합            계", k07_df.format(k07_sum));
		System.out.printf("%-18.18s %25.25s\n", "026-비씨카드사 ", "00/00A");
		System.out.printf("%-14.14s%31.31s\n", "카  드  번  호  :", "5522-20**-****-BADD");
		System.out.printf("%-13.13s%32.32s\n", "카  드  매  출  :", k07_df.format(k07_sum));
		System.out.printf("%-15.15s%27.27s\n", "거  래  구  분  :", "일시불");
		System.out.printf("%-24.24s  %19.19s\n", "승  인  번  호  : 04-KICC", "75549250");
		System.out.printf("%-24.24s\n", "가 맹 점 번 호  : ");
		System.out.printf("%-15.15s%30.30s\n", "받  은  금  액  : ", k07_df.format(k07_sum));
		System.out.printf("%-15.15s%31.31s\n", "거    스    름  : ", k07_df.format(0));
		System.out.printf("-------------------------------------------------\n");
		System.out.printf("%-10.10s %-10.10s\n", "주문번호 : ", "0920");
		System.out.printf("-------------------------------------------------\n");
		System.out.printf("%-5.5s %-5.5s %-5.5s\n", "판매원 : ", "000002", "편의점2");
		// 현재 날자와 시간을 형식에 맞게 출력해준다
		System.out.printf("%-10.10s-%-10.10s\n", k07_sdf.format(k07_cal.getTime()), "0002-0922");
		System.out.printf("%-6.6s[%-20.20s]\n", "연동모듈 : ", "00138705   20160504190049");

	}

}
