package test.copy;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

////////////////////////////////////
// 반올림은 유효숫자를 높여 오차를 줄이는 방법이나, 세금계산 문제 같으면 손해를 안 봐야 되는 문제
// 즉 세율을 나눠서 원단위가 딱 떨어지면 그대로 세금을 먹이나, 아니면 +1원을 더해야 한다.
public class Taxcalc {
	//	파라메터로 세전 물건값과 세금 퍼센트를 넘겨받는다
	public static int taxcal(int k07_val, int k07_rate){
		// 물건에 대한 세금값을 구해서 넣어줄 변수
		int k07_ret;
		
		// 세전 물건값과 세율을 곱한 값이 정수형 연산과 딱 맞아 떨어지는지 검사
		if(((double)k07_val*(double)k07_rate/100.0) == k07_val*k07_rate/100)
			// 물건에 대한 세금값 변수에 세전 물건값과 세율을 곱해서 넣어준다 
			k07_ret=k07_val*k07_rate/100;
		else
			// 변수에 세전물건값과 세율을 곱하고 딱 떨어지지 않으면 1월을 더해서 넣어준다
			k07_ret=k07_val*k07_rate/100+1;
		
		// 물건에 대한 세금값 변수를 리턴값으로 돌려준다
		return k07_ret;
	}
	
	public static void main(String[] args){
		int k07_val = 271;	// 세전 물건값
		int k07_rate = 5;	// 세금 5퍼센트
		
		/////////////////////////
		// 우리나라는 세금을 포함한 소비자가격을 기입하는데, 일본가면 세전가격을 소비자가라고 붙여놔서 헷갈린다.
		// 100엔이라고 편의점에서 사면 112엔을 받아서 잔돈만 생긴다.
		// 세전 물건값과 세금 퍼센트를 넘겨주어 물건에 대한 세금값을 구하는 변수
		int k07_tax= taxcal(k07_val,k07_rate);

		System.out.printf("**********************************ㅁ************************************\n");
		System.out.printf("*          단순 세금 계산                                *\n");
		System.out.printf("실제 세금 계산: %f\n", k07_val*k07_rate/100.0); // 하나라도 double형식 연산을 하면 실수로 표시,
		
		// 세전가격, 세금, 세포함가격을 전부 구해서 각각의 값을 출력해서 보여준다
		System.out.printf("세전가격: %d 세금:%d 세포함가격: %d\n", k07_val,k07_tax,k07_val+k07_tax);

		System.out.printf("**********************************************************************\n");
		
	
		
		///////////////////////////////////////////////////////////////////////////
		// 한국식은 소비자가가 100원..이런식으로 가격이 똑 떨어지게 처리
		// 세금은 무조건 올려서 소비자에게 받아야 한다.
		// 즉 세전가격을 버림처리하면 무조건 세금은 올림처리가 된다.
		// 세전가격을 정수형 연산하면 되겠네..
		//
		// net = custom / (1 + rate)
		// tax = custom - net
		// 솔직히 사인,코사인,미분,적분은 안 나오지만, 작업현장에서 이 정도 산수는 졸라게 나온다.
		//
		
		// 소비자 가격 변수에  값 할당
		int k07_custom = 280;
		// 세율 변수에  값 할당
		int k07_taxrate = 3;	//	3%는 0.03 -> taxrate/100.0
		
		// 세금,  세전가격  변수
		int k07_taxval, k07_netval;
		
		// 소비자 가격 기준으로 세전 가격을 구한다.
		k07_netval = (int) (k07_custom / (1 + k07_taxrate/100.0));
		// 세금 변수에 소비자 가격 - 세전 가격을 해서 세금 계산을 한 뒤 세금 값을 구해 대입한다.
		k07_taxval = k07_custom - k07_netval;

		System.out.printf("**********************************************************************\n");
		System.out.printf("*                소비자가 중심 세금 계산                                                 *\n");
		
		// 소비자 가격, 세전가격, 세금을 구해 출력해준다.
		System.out.printf("소비자가격: %d 		세전가격: %d  세금: %d  \n",  k07_custom, k07_netval, k07_taxval);		
		System.out.printf("**********************************************************************\n");
		
		// 전체 금액 변수에 값 할당
		int k07_MyWon = 1000000;		// 나는 은행에서 100만원주고 달라로 바꿔달라고 했다. 와 신난다 해외여행간다..
		// 달라 환율 변수에 값 할당
		double k07_MoneyEx = 1238.21;	// 달라 환율
		// 환전 수수료 변수에 값 할당
		double k07_commission = 0.003;	// 환전 수수료, 뭐 0.3퍼센트라고 생각하지..
		
		////////////////////////////////////////////
		// 은행가서 달라 바꾸는데 달라 지폐만 주지, 동전 센트 달라고 하면 바보된다.
		// 강동환 군은 100만원 들고 가서 네이버 환율보고 아 807달러 받겠구나 하고 갔다.
		// 은행 신입사원 유상현군은 수수료 생각 안 하고..
		
		// 전체 금액 변수에 달라 환율을 정수형으로 나누기 해주면 버림처리가 된 달라금액이 나온다 
		int k07_usd = (int) (k07_MyWon/k07_MoneyEx);	// 최종 결과를 정수형으로 만들면 버림처리가 된다. 전체금액을 환율로 나눴다.
		// 달라 금액과 달라 환율을 곱해서 전체금액에서 빼면 버림처리가 된 잔돈 금액이 나온다.
		int k07_remain = (int) (k07_MyWon-k07_usd*k07_MoneyEx);	// 고객에게 돌려줄 잔돈도 당연히 소숫점이하의 금액은 삥땅해야 한다.. 실수로 계산 후 버림처리
												// 전체금액에서 달러금액(달러*환율)을 뺏다. 만일 2324.22원 이런식으로 나오면 0.22원은 삥땅처라.. 줄 수도 없다.

		System.out.printf("**********************************************************************\n");
		System.out.printf("*                수수료없이 계산                             *\n");
		// 연산으로 구한 한화, 미화, 잔돈을 출력해준다
		System.out.printf("총 한화환전금액: %d원=> 미화: %d달러, 잔돈 : %d원\n", k07_MyWon, k07_usd, k07_remain);	// 쉽다.

		System.out.printf("**********************************************************************\n");
	
		//////////////////////////////////////////////////////////////
		// 유상현군은 짤렸다.. 수수료 안 받아서
		// 그 옆에 홍보경군이 수수료를 계산했다. 뭐 그거 얼마나 한다고..
		//
		
		// 달라 환율 * 환전 수수료 = 1달라당 수수료 
		double k07_ComPerOne = k07_MoneyEx * k07_commission;	// 1달러당 수수료
		//달러당 수수료를 더해서 계산할까? 아니면 전체금액을 산정한 후 수수료율을 때릴까?..
		// 현재는 실수연산을 사용하기 때문에 차이는 없다. 정수형은 차이가 난다.
		
		// 달라 금액과 1달라당 수수료를 곱해서 총 수수료를 구한다.
		double k07_totalcom = k07_usd * k07_ComPerOne;
		System.out.printf("**********************************************************************\n");
		System.out.printf("*            수수료 계산                                        *\n");
		// 총 수수료, 미화, 달러당 수수료 출력
		System.out.printf("총 수수료: %f원=> 미화: %d달러, 달러당 수수료: %f원\n", k07_totalcom, k07_usd, k07_ComPerOne);

		System.out.printf("**********************************************************************\n");
		
		/////////////////////////////////////////////////////////////////////////////////////
		// 당연히 수수료는 받아야 할 돈이니 올림처리하자
		
		// 총 수수료 변수 선언
		int k07_i_totalcom;
		
		// 뭔 짓거리를 했는지 따져보자.. 그리고 익혀서 암기.
		
		// 현재 총수수료 금액이 총 수수료 금액을 정수형으로 바뀐 뒤 실수형 금액으로 바꾼 값이 같은지 비교 
		if(k07_totalcom != (double)((int)k07_totalcom))
			// 총 수수료 변수 1원 증가처리
			k07_i_totalcom=(int)k07_totalcom+1;
		else
			// 총 수수료 변수 최종 계산값 산출
			k07_i_totalcom=(int)k07_totalcom;
		System.out.printf("**********************************************************************\n");
		System.out.printf("*                수수료 적용 환전                                       *\n");
		// 총 수수료, 미화, 달러당 수수료 출력
		System.out.printf("총 수수료: %d원=> 미화: %d달러, 달러당 수수료: %f원\n", k07_i_totalcom, k07_usd, k07_ComPerOne);	// 깔끔하다.
		
		//총 금액 - (미화 * 달러당 수수료) - 최종 총수수료 = 잔돈
		k07_remain = (int) (k07_MyWon-k07_usd*k07_MoneyEx - k07_i_totalcom);
		// 계산한 한화, 미화, 수수료, 잔돈을 출력해준다
		System.out.printf("총 한화환전금액: %d원=> 미화: %d달러, 수수료징구:%d원 잔돈 : %d원\n", k07_MyWon, k07_usd, k07_i_totalcom, k07_remain); // 쉽다..
		
		System.out.printf("**********************************************************************\n");

		///////////////////////////////////////////////////////////////
		// 홍보경군도 고객에게 저 잔돈도 없고요, 2233원을 더 주셔야 807달러를 드립니다. 했더니 고객이 아 난 100만원 딸랑 가지고 왔는데 뭐야.. 홍보경군도 짤렸다.
		//
		// 정확한 답은 실수형 계산으로 먼저 (1달러+1달러 환전수수료) 이 금액을 전체금액으로 나누어 환전해 주는 것이다. 홍진욱 군이 얻어 먹었다..
		// 왜 더블로 계산하고, 인트로 계산하는지 잘 생각해라.. 이런거 익히는게 변수선언, 형변환, 연산이다.
		//
		// int MyWon = 1000000;		// 나는 은행에서 100만원주고 달라로 바꿔달라고 했다.
		// double MoneyEx=1238.21; // 달라환율
		// double commission=0.003; // 환전 수수료, 뭐 0.3퍼센트라고 생각하지..
		// double ComPerOne = MoneyEx * commission;	// 1달러당 수수료
		
		//  총 금액  / (달러 환율 + 1달라당 수수료)  = 달러값
		k07_usd = (int) (k07_MyWon/(k07_MoneyEx + k07_ComPerOne)); // 환전달러
		// 달러값  * 1달러당 수수료  = 총 수수료
		k07_totalcom = k07_usd * k07_ComPerOne; // 총수수료
		//////////////////////
		// 수수료 올림처리
		// 총 수수료가 버림 처리를 해도 같은지 비교
		if(k07_totalcom != (double)((int)k07_totalcom))
			// 총 수수료가 버림 처리를 해서 같지 않으면( 딱 떨어지는 값이 아니면) 1원 올림처리
			k07_i_totalcom = (int)k07_totalcom+1;
		else
			// 총수수료가 딱 떨어지는 값이면 그대로 최종 총수수료 변수에 대입
			k07_i_totalcom=(int)k07_totalcom;
		//////////////////////
		System.out.printf("**********************************************************************\n");
		System.out.printf("*              (정확한)수수료 적용환전                                       *\n");
		
		// 총 수수료, 미화, 달러당 수수료 출력
		System.out.printf("총 수수료: %d원=> 미화: %d달러, 달러당 수수료: %f원\n", k07_i_totalcom, k07_usd, k07_ComPerOne);	// 깔끔하다.
		
		// 잔돈 = 총 금액 - (달러값 * 달러당 환율값) - 최종 총 수수료
		k07_remain = (int) (k07_MyWon-k07_usd*k07_MoneyEx - k07_i_totalcom);
		// 총 한화, 미화, 수수료 청구값, 잔돈 출력
		System.out.printf("총 한화환전금액: %d원 => 미화: %d달러, 수수료청구:%d원  잔돈: %d원\n", k07_MyWon, k07_usd, k07_i_totalcom, k07_remain);	// 쉽다..

		System.out.printf("**********************************************************************\n");
		
		
		//////////////////////////////////////////////////////////////////
		// # 돈은 영어기준으로 세자리마다 콤마를 찍는다 이거 해보자
		//
		// DecimalFormat 이라는 클래스를 가져다 끈다.  임포트하는 방법을 배우자.
		
		// DecimalFormat 클래스 선언 및 생성
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		
		System.out.printf("**********************************************************************\n");
		System.out.printf("*               콤마찍기, 날짜 적용                     *\n");
		
		System.out.printf("총 수수료: %s원 => 미화: %s달러, 달러당 수수료: %f원\n",
				// 최종 총 수수료를 1000원 단위마다 콤마(,) 처리
				df.format(k07_i_totalcom),
				// 달러값을 1000원 단위마다 콤마(,) 처리
				df.format(k07_usd),
				// 달러당 수수료 값을 1000원 단위마다 콤마(,) 처리
				k07_ComPerOne); // 깔끔하다.
		
		// 잔돈  = 총 한화 - (달러값 * 달러 환율) - 총 수수료   (버림처리)
		k07_remain = (int) (k07_MyWon - k07_usd * k07_MoneyEx - k07_i_totalcom);
		System.out.printf("총 한화환전금액: %s원 => 미화: %s달러, 수수료청구:%s원 잔돈: %s원\n",
				// 총 금액, 달러값, 총수수료, 잔돈 을 모두 1000원 단위마다 콤마(,) 처리 해서 출력
				df.format(k07_MyWon), df.format(k07_usd), df.format(k07_i_totalcom), df.format(k07_remain)); // 쉽다..
		

		////////////////////////////////////////////////////////
		// 처음에는 베껴쓰고 점점 암기 (시스템의 현재시간 가지고 오기, 3줄을 가져다 쓰기..)
		
		// Calendar k07_calt를 선언하고 객체 생성
		Calendar k07_calt = Calendar.getInstance();
		// SimpleDateFormat 변수를 sdt로 선언하고 생성
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		// 최종 실행시간을 SimpleDateFormat에 정해준대로 출력
		System.out.printf("최종실행시간: %s\n", sdt.format(k07_calt.getTime()));
		
		System.out.printf("**********************************************************************\n");
		
	}
}
