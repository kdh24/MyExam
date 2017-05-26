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
		
		String [] itemName = {"��������", "�ٳ�������", "������", "�������ֽ�", "���ڿ���",
							"ĥ�����̴�", "�����Ӹ�ī", "�ƽ���", "������", "����",
							"�������1000L", "¥�İ�Ƽ", "�Ŷ��", "�޹�", "��������",
							"���÷�", "�400g", "���ѱ�����", "���ѱ������", "�κ�200g",
							"��Ǫ�ν�Ʈ", "�ƽ�ī��", "���̽�", "�������", "Ī����",
							"�ȼ�����", "���ֻ�ټ�", "��ɹ���", "ȣ���ͽ�", "������ī"}; // �׸�� 30���̻�
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
		
		String product1 = "Ǯ��������";
		String productCode1 = "8809169718205";
		String product2 = "�帵ŷ�䱸��Ʈ";
		String productCode2 = "8801155822828";
		
		int beforeTax =0;
		int beforeTaxSum = 0;
		int tax = 0;
		int freeSum=0;
		int taxSum=0;
		int sum=0;

		System.out.printf("%-30.30s\n", "������ �������� ��ȯ/ȯ�� �Ұ�(30�ϳ�)");
		System.out.printf("%-30.30s\n", "��ȯ/ȯ�� ���������� ����(����ī������)");
		System.out.printf("%-30.30s\n", "üũī��/�ſ�ī�� û����� �ݿ���");
		System.out.printf("%-30.30s\n\n", "�ִ� 3''5�� �ҿ� (�ָ�,����������)");

		System.out.printf("%-6.6s%-20.20s %-13.13s\n", "[��  ��]", sdf.format(k07_cal.getTime()), "POS:0009-2418");
		System.out.printf("------------------------------------------------\n");
		System.out.printf("%10.10s %10.10s %8.8s %8.8s\n", "��  ǰ  ��", "��  ��", "��  ��", "��  ��");
		System.out.printf("------------------------------------------------\n");

		for(int i=0; i<itemName.length; i++){
			System.out.printf("%-5.5s%-" + String.valueOf(14-h_Black.HanCount(itemName[i])) +"."+String.valueOf(14-h_Black.HanCount(itemName[i]))+"s" +
					 "%6.6s%10.10s%12.12s\n", i+1 < 10 ? "0"+String.valueOf(i+1) : i+1 + ((taxfree[i] == false) ? "*" : ""), itemName[i], df.format(price[i]), df.format(num[i]), df.format(price[i]*num[i]));

			if (taxfree[i] == false) {
				beforeTax = ((int)(price[i] / 1.1 % 10)) != 0 ? (int)(price[i] / 1.1+5) /10 * 10 : (int)(price[i] / 1.1);
				tax = (int) ((price[i]-beforeTax)*num[i]);
				taxSum += tax;
				beforeTaxSum+= beforeTax*num[i];
			}else
				freeSum += price[i]*num[i];
			
			sum+= price[i]*num[i];
			
		}
		System.out.printf("%20.20s %22.22s\n", "(*)�� ��  �� ǰ", df.format(freeSum));
		System.out.printf("%20.20s %22.22s\n", "�� ��  �� ǰ", df.format(beforeTaxSum));
		System.out.printf("%21.21s %22.22s\n", "��   ��   ��", df.format(taxSum));
		System.out.printf("%22.22s %22.22s\n", "��        ��", df.format(beforeTaxSum+taxSum+freeSum));
		System.out.printf("%-18.18s%23.23s\n", "�� �� �� �� �� ��", df.format(sum));
		System.out.printf("------------------------------------------------\n");
		System.out.printf("%-20.20s%25.25s\n", "0024 �� ��", "5417**8890/07850246");
		System.out.printf("%-15.15s%25.25s\n", "ī�����", "�Ͻú� / "+ df.format(sum));
		System.out.printf("------------------------------------------------\n");
	}
}


