package webPrograming.ex;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class print2 {
	public static void main(String[] args) {
		DecimalFormat k07_df = new DecimalFormat("###,###,###,###,###");
		
		Calendar k07_cal = Calendar.getInstance();
		SimpleDateFormat k07_sdf = new SimpleDateFormat("YYYY/MM/dd");
		
		String k07_product1 = "풀무원샘물";
		String k07_productCode1 = "8809169718205";
		String k07_product2 = "드링킹요구르트";
		String k07_productCode2 = "8801155822828";
		
		int k07_p_price1=600;
		int k07_p_price2=1600;
		int k07_p_num1=1;
		int k07_p_num2=1;
		int k07_sum = k07_p_price1*k07_p_num1+k07_p_price2*k07_p_num2;
		
		int k07_beforeTax = (int)(k07_sum/1.1);
//		if(beforeTax % 10 != 0) beforeTax = (beforeTax+5)/10 *10;
		int k07_tax = (int)(k07_beforeTax/10.0);
		if(k07_tax % 10 != 0){
			k07_tax = (k07_tax+5)/10 * 10;
			k07_beforeTax = k07_sum - k07_tax;
		}
		
		System.out.printf("%-100.100s\n", "충주(양평)휴게소");
		System.out.printf("%-100.100s\n", "충북충주시가금면용전리380-4");
		System.out.printf("%-100.100s\n", "최병권 677-85-00239  TEL:043-857-9229");
		System.out.printf("\n\n%-25.25s %-15.15s\n", "[정상등록]20160504 190049", "POS번호: 0002");
		System.out.printf("-------------------------------------------------\n");
		System.out.printf("%-25.25s %-4.4s%-4.4s %4.4s\n", "품목코드", "단가","수량","금액");
		System.out.printf("-------------------------------------------------\n");
		System.out.printf("%-100.100s\n", k07_product1+k07_product1);
		System.out.printf("%-30.30s%4.4s%5.5s%10.10s\n", k07_productCode1, k07_df.format(k07_p_price1), k07_df.format(k07_p_num1), k07_df.format(k07_p_price1*k07_p_num1));
		System.out.printf("%-100.100s\n", k07_product2+k07_product2);
		System.out.printf("%-28.28s%6.6s%5.5s%10.10s\n", k07_productCode2, k07_df.format(k07_p_price2), k07_df.format(k07_p_num2), k07_df.format(k07_p_price2*k07_p_num2));
		
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
		System.out.printf("%-10.10s-%-10.10s\n", k07_sdf.format(k07_cal.getTime()), "0002-0922");
		System.out.printf("%-6.6s[%-20.20s]\n", "연동모듈 : ", "00138705   20160504190049");

	}

}
