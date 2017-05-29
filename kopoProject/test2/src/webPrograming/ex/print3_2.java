package webPrograming.ex;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class print3_2 {
	public static String HanBlackBackword(String k07_Han, int k07_num){
		// �ѱ� ���麯��
		String k07_HanBlack="";
		// �ѱ۸Ű������� ���� ����Ʈ ���̸� ��ü ���̿��� ���� �װ��� �ִ밪���� ���ϴ� ����		
		int max= k07_num -k07_Han.getBytes().length;
		
		if(k07_Han.getBytes().length > k07_num ){
			if(k07_Han.getBytes().length % 2 == 1)
				k07_HanBlack = new String(k07_Han.getBytes(), 0, 23) + " ";
			else 
				k07_HanBlack = new String(k07_Han.getBytes(), 0, 24);
		}else
		{
//			k07_HanBlack = new String(k07_Han.getBytes(), 0, 20);
			
			// �ѱ� ����ó�������� �̸� �Ѱܹ��� �ѱ۰��� �־��ش�
			k07_HanBlack += k07_Han;
			// max ������ ����ŭ ������ �߰��� �����ش�
			for (int i = 0; i < max; i++) {
				k07_HanBlack += " ";
			}
		}
		// �ѱ۰� ������ ���� k07_HanBlack ������ ���ϰ����� �����ش�.
		return k07_HanBlack;
	}

	public static void main(String[] args) {
		// ���ڸ� String ������ ����Ҷ� 1000(õ) �������� �޸�(,)�� ǥ���ϵ��� �����ش�.
		DecimalFormat k07_df = new DecimalFormat("###,###,###,###,###");
		// ��¥ ����� ���� Į���� ������ ���� �� �����Ѵ�
		Calendar k07_cal = Calendar.getInstance();
		// ���� ��¥ �� �ð��� � �������� ������� ������ �����ش�		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm");

		int num = 0;
		// ������ ǰ����� String �迭�� ���������� 30���� ������� ���Ҵ�
		String [] k07_itemName = {"��������", "����", "������2000", "�����ֽ�", "��ħ�޻�",
				"ĥ�����̴�", "�����Ӹ�ī", "����", "������", "����",
				"�߲�ġ", "¥�İ�Ƽ", "�Ŷ��", "�޹�", "��������",
				"���÷�", "�400g", "���ѱ�����", "���ѱ������", "�κ�200g",
				"��¡���", "�ƽ�ī��", "����", "�������", "Ī����",
				"���ѱ�ī��", "���� 400g", "��ɹ���", "ȣ���ͽ�", "������ī"}; // �׸�� 30���̻�
// ������ ǰ���� ���ݿ� �ش��ϴ� �ݾ��� int�� �迭�� 30�� ����
int [] k07_price = {1400, 1241, 3300, 2500, 820,
			17500, 10500, 1000, 1200, 7100,
			1000, 1400, 1500, 2400, 1700,
			1500, 1300, 2800, 1600, 31500,
			230, 2200, 1900, 8500, 1000,
			800, 1400, 400, 7000, 5600};
// ������ ��ǰ�� ��� ���� int�� �迭�� ������״�
int [] k07_num={8,4,1,3,5,
		3,6,4,1,7,
		3,5,2,1,1,
		2,3,2,1,1,
		3,5,6,2,3,
		2,1,2,3,4};
// ������ ǰ���� ��ǰ�� �鼼��ǰ���� ������ǰ���� true�� false�� �����ؼ� 
// boolean�� �迭�� ���������� �����ߴ�
boolean [] k07_taxfree={false, true, false, false, true,
	false, true, false, true, false,
	false, false, false, false, false,
	true, false, false, false, false,
	false, false, true, false, true,
	true, true, false, false, false};
		
		
		// ��ǰ�� ���� ������ ������ ����
		int k07_beforeTax =0;
		// ��ǰ�� ���������� �������� ������ ����
		int k07_beforeTaxSum = 0;
		// ���� ��ǰ�� ���ݰ��� ������ ����
		int k07_tax = 0;
		// �鼼 ��ǰ�� ���������� ������ ����
		int k07_freeSum=0;
		// ������ǰ�� ���ݰ��� ������ų ����
		int k07_taxSum=0;
		// ������ �� �ݾ��� ������ ����
		int k07_sum=0;

		// ����� ���ϴ� ũ�⸸ŭ �ش� �ؽ�Ʈ�� ������ش�
		System.out.printf("%-30.30s\n", "������ �������� ��ȯ/ȯ�� �Ұ�(30�ϳ�)");
		System.out.printf("%-30.30s\n", "��ȯ/ȯ�� ���������� ����(����ī������)");
		System.out.printf("%-30.30s\n", "üũī��/�ſ�ī�� û����� �ݿ���");
		System.out.printf("%-30.30s\n\n", "�ִ� 3''5�� �ҿ� (�ָ�,����������)");

		// ���� ��¥ �� �ð��� �������� �������� ���
		System.out.printf("%-6.6s%-20.20s %-13.13s\n", "[��  ��]", sdf.format(k07_cal.getTime()), "POS:0009-2418");
		System.out.printf("---------------------------------------------------------\n");
		System.out.printf("%10.10s %20.20s %8.8s %8.8s\n", "��  ǰ  ��", "��  ��", "��  ��", "��  ��");
		System.out.printf("---------------------------------------------------------\n");

		// �迭�� ���������� ����Ǿ� �ִ� ������ ���������� �����ͼ� ������ִ� �κ�
		// �迭�� ũ�Ⱑ 0���� 29���� 30���� �����Ƿ� 30�� �ݺ��ؼ� ������ �ȴ�
		for(int i=0; i<k07_itemName.length; i++){
//			if(k07_itemName[i].getBytes().length>20){
//				k07_itemName[i]=new String(k07_itemName[i].getBytes(), 0, 20);
//			}
//			for(int j=0; j<20-(k07_itemName[i].getBytes().length);j++){
//				k07_itemName[i]=k07_itemName[i]+" ";
//			}
			String iName = HanBlackBackword(k07_itemName[i], 24);
			
			// ��ǰ�� �ѱ��� � ����ִ��� Ȯ���ؼ� 14.14s ���� �׸�ŭ ���ڸ� ���༭ ������ش�
			System.out.printf("%-5.5s%s" +
			// ���׿����ڸ� ����ؼ� ��ǰ��ȣ�� 10���� ������ ���� �տ� 0�� �ٿ��ְ� �鼼��ǰ�̸� �ڿ� *�� �����ش�
					 "%6.6s%10.10s%12.12s\n", (i+1 < 10 ? "0"+String.valueOf(i+1) : i+1) + ((k07_taxfree[i] == true) ? "*" : ""),
					 				iName, k07_df.format(k07_price[i]), k07_df.format(k07_num[i]), k07_df.format(k07_price[i]*k07_num[i]));

			// ��ǰ�� ������ǰ�̶�� �����ݾװ� ���� �κ��� ������ش�.
			if (k07_taxfree[i] == true) {
				// �鼼 ��ǰ�� ���� ������ ���������ش�
				k07_freeSum += k07_price[i]*k07_num[i];
			}else	// �鼼��ǰ�� ���� ó��
				k07_beforeTaxSum += k07_price[i]*k07_num[i];
			
			// �鼼�� ������ ��� ������ ��ü ��ǰ�� ���� �������� sum ������ ����
			k07_sum+= k07_price[i]*k07_num[i];
			
		}
		k07_beforeTax = (int)((k07_beforeTaxSum+1)/1.1);
		// ������ ���� ���� ������ ���̴�� ȭ�鿡 ������ش�
		System.out.printf("%30.30s %22.22s\n", "(*)�� ��  �� ǰ", k07_df.format(k07_freeSum));
		System.out.printf("%30.30s %22.22s\n", "�� ��  �� ǰ", k07_df.format((int)(k07_beforeTax)));
		System.out.printf("%31.31s %22.22s\n", "��   ��   ��", k07_df.format(k07_beforeTaxSum-k07_beforeTax));
		System.out.printf("%32.32s %22.22s\n", "��        ��", k07_df.format(k07_sum));
		System.out.printf("%-28.28s%23.23s\n", "�� �� �� �� �� ��", k07_df.format(k07_sum));
		System.out.printf("---------------------------------------------------------\n");
		System.out.printf("%-30.30s%25.25s\n", "0024 �� ��", "5417**8890/07850246");
		System.out.printf("%-25.25s%25.25s\n", "ī�����", "�Ͻú� / "+ k07_df.format(k07_sum));
		System.out.printf("---------------------------------------------------------\n");
	}
}


