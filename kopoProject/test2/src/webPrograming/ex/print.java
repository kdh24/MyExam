package webPrograming.ex;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class print {
	public static void main(String[] args) {
		DecimalFormat k07_df = new DecimalFormat("###,###,###,###,###");
		
		// 가격 변수
		int k07_iPrice = 21000;
		// 세금 제외한 물건값
		int k07_beforMoney = (int)(k07_iPrice/1.1);
		// 물건 세금
		double k07_tax = k07_iPrice - k07_beforMoney;
		
		int k07_card = k07_iPrice;
		int k07_cash = 0;
		if(k07_card == 0)
			k07_cash = k07_iPrice;
		else
			k07_cash = 0;
		
		Calendar k07_calt = Calendar.getInstance();
		SimpleDateFormat k07_sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

		System.out.printf("%30.30s\n", "영   수   증");
		System.out.printf("-----------------------------------------------------\n");
		System.out.printf("%-100.100s\n", "종로상회(분당서현점)  129-17-77924");
		System.out.printf("%-100.100s\n", "이상철  031 781 1596");
		System.out.printf("%-100.100s\n", "성남시 분당구 서현동 269-3");
		System.out.printf("%-100.100s\n", "테이블명 : 12");
		System.out.printf("%-100.100s\n", "주문번호 : 20160425 01 00041");
		System.out.printf("-----------------------------------------------------\n");
//		System.out.printf("%-86.86s%d\n", "주문합계", k07_iPrice);
		System.out.printf("%-30.30s", "주문합계");
		System.out.printf("%19.19s\n",  k07_df.format(k07_iPrice));
		System.out.printf("%-30.30s", "할인금액");
		System.out.printf("%19.19s\n",  k07_df.format(0));
		System.out.printf("%-30.30s", "받을금액");
		System.out.printf("%19.19s\n",  k07_df.format(k07_iPrice));
		System.out.printf("-----------------------------------------------------\n");
		System.out.printf("%-18.18s %6.6s", "현   금", k07_df.format(k07_cash));
		System.out.printf("%10.10s%14.14s\n", "과   세", k07_df.format(k07_beforMoney));
		System.out.printf("%-18.18s %6.6s", "카   드", k07_df.format(k07_card));
		System.out.printf("%10.10s%14.14s\n", "세   액", k07_df.format(k07_tax));
		System.out.printf("%-18.18s%6.6s", "포인트", k07_df.format(0));
		System.out.printf("%10.10s%14.14s\n", "면   세", k07_df.format(0));
		System.out.printf("%35.35s%14.14s\n", "영수금액", k07_df.format(k07_iPrice));
		System.out.printf("-----------------------------------------------------\n");
		if(k07_card != 0){
			System.out.printf("%28.28s\n", "[우리카드 신용 승인]");
			System.out.printf("%-14.14s%20.20s\n", "승  인  일  시  : ", k07_sdt.format(k07_calt.getTime()));
			System.out.printf("%-100.100s\n", "카  드  번  호  : 55222059****2021");
			System.out.printf("%-100.100s\n", "승  인  번  호  : 79753574  할부개월 : 00");
			System.out.printf("%-14.14s%-20.20s\n", "승  인  금  액  :", k07_df.format(k07_iPrice));
			System.out.printf("%-100.100s\n", "가  맹  번  호  : 730461774  /  비씨카드사");
			System.out.printf("%-100.100s\n", "사 업 자   번호 : 129-17-77924");
			System.out.printf("-----------------------------------------------------\n");
			System.out.printf("%-40.40s%11.11s\n", "2016-04-25  12:44  CASHIER :", "직원");
			System.out.printf("-----------------------------------------------------\n");
			System.out.printf("%-100.100s\n", "감사 합니다.");
		
		}
	}

}
