package webPrograming.ex;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class print {
	public static void main(String[] args) {
		// 숫자를 String 값으려 출력할때 1000(천) 단위마다 콤마(,)를 표시하도록 정해준다.
		DecimalFormat k07_df = new DecimalFormat("###,###,###,###,###");
		
		// 가격 변수
		int k07_iPrice = 21000;
		// 세금 제외한 물건값
		int k07_beforMoney = (int)((k07_iPrice+0.1)/1.1);
		// 물건 세금
		double k07_tax = k07_iPrice - k07_beforMoney;
		
		// 카드계산 변수 0이면 현금으로 계산하는 것으로 처리
		int k07_card = k07_iPrice;
		// 현금계산 변수
		int k07_cash = 0;
		// 카드 변수가 0으로 초기화가 되면 현금계산이므로 변경처리
		if(k07_card == 0)
			k07_cash = k07_iPrice;

		// 날짜 계산을 위해 칼렌다 변수를 선언 및 생성한다
		Calendar k07_calt = Calendar.getInstance();
		// 현재 날짜 및 시간을 어떤 포맷으로 사용할지 포맷을 정해준다
		SimpleDateFormat k07_sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		SimpleDateFormat k07_sdt2 = new SimpleDateFormat("YYYYMMdd");

		// 영수증 출력 부분 길이를 정해 정해진 텍스트를 그대로 출력해준다
		System.out.printf("%30.30s\n", "영   수   증");
		System.out.printf("-----------------------------------------------------\n");
		System.out.printf("%-100.100s\n", "종로상회(분당서현점)  129-17-77924");
		System.out.printf("%-100.100s\n", "이상철  031 781 1596");
		System.out.printf("%-100.100s\n", "성남시 분당구 서현동 269-3");
		System.out.printf("%-100.100s\n", "테이블명 : 12");
		System.out.printf("%-8.8s%-8.8s%9.9s\n", "주문번호 :", k07_sdt2.format(k07_calt.getTime()),"01 00041");
		System.out.printf("-----------------------------------------------------\n");
		// 한줄에 출력부분을 2개로 나누어 30.30s 부분은 항목을 19.19s 부분은 금액을 표기
		// df.format을 사용해서 금액을 String 방식으로 표기하고 1000(천) 단위마다 콤마(,) 표기
		System.out.printf("%-30.30s", "주문합계");
		System.out.printf("%19.19s\n",  k07_df.format(k07_iPrice));
		System.out.printf("%-30.30s", "할인금액");
		System.out.printf("%19.19s\n",  k07_df.format(0));
		System.out.printf("%-30.30s", "받을금액");
		System.out.printf("%19.19s\n",  k07_df.format(k07_iPrice));
		System.out.printf("-----------------------------------------------------\n");
		// 위에서 계산한 세전금액, 부가세, 현금 or 카드 계산을 변수로해서 각각 출력해준다
		// 마찬가지로 df.format을 사용해 천단위 콤마 표기
		System.out.printf("%-18.18s %6.6s", "현   금", k07_df.format(k07_cash));
		System.out.printf("%10.10s%14.14s\n", "과   세", k07_df.format(k07_beforMoney));
		System.out.printf("%-18.18s %6.6s", "카   드", k07_df.format(k07_card));
		System.out.printf("%10.10s%14.14s\n", "세   액", k07_df.format(k07_tax));
		System.out.printf("%-18.18s%6.6s", "포인트", k07_df.format(0));
		System.out.printf("%10.10s%14.14s\n", "면   세", k07_df.format(0));
		System.out.printf("%35.35s%14.14s\n", "영수금액", k07_df.format(k07_iPrice));
		System.out.printf("-----------------------------------------------------\n");
		// 위에서 현금과 카드변수를 따로 만들었기 때문에 카드 승인 부분은
		// 카드변수가 0이 아닐때(카드결제일때)만 출력하게 해준다
		if(k07_card != 0){
			System.out.printf("%28.28s\n", "[우리카드 신용 승인]");
			System.out.printf("%-14.14s%-20.20s\n", "승  인  일  시  : ", k07_sdt.format(k07_calt.getTime()));
			System.out.printf("%-100.100s\n", "카  드  번  호  : 55222059****2021");
			System.out.printf("%-100.100s\n", "승  인  번  호  : 79753574  할부개월 : 00");
			System.out.printf("%-14.14s%-20.20s\n", "승  인  금  액  :", k07_df.format(k07_iPrice));
			System.out.printf("%-100.100s\n", "가  맹  번  호  : 730461774  /  비씨카드사");
			System.out.printf("%-100.100s\n", "사 업 자   번호 : 129-17-77924");
			System.out.printf("-----------------------------------------------------\n");
			System.out.printf("%-18.18s%-10.10s%11.11s\n", k07_sdt.format(k07_calt.getTime()), "  CASHIER :", "직원");
			System.out.printf("-----------------------------------------------------\n");
			System.out.printf("%-100.100s\n", "감사 합니다.");
		
		}
	}

}
