package webPrograming.ex;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class print3_1 {
	// �ѱ� ���ڸ� ����ϴ� �ѱ� ī���� Ŭ����
	// �Ű������� String ���� �Ѱܹ޾� ó�����ص� �ѱ� ������ ����� int�� ������ �������ش�
	public static int k07_HanCount(String k07_Han) {
		// �Ű����� Han ������ �ѱ��� ��� �ִ��� Ȯ���ؼ� int �� ������ �����ϱ� ���� ����
		int k07_count = 0;

		// String ���� Han�� ���̸�ŭ �ݺ��ؼ� �����ϴ� for �ݺ���
		for (int i = 0; i < k07_Han.length(); i++) {
			// ������ ��ġ�� ���� �������� substring ������ �̿��ؼ�
			// i������ i+1�� ���� ��� ������ ó������ ������ �ѱ��ھ� ��������
			// �� ����Ʈ�� ���� 1�� ������ �ѱ�(2����Ʈ)�̹Ƿ� if���� �����Ų��
			if (k07_Han.substring(i, i + 1).getBytes().length > 1) {
				// �ѱ��϶� �����ϹǷ� ������ ���������ش�
				k07_count += 1;
			}
		}
		// �ѱ� ������ ���ϰ����� �Ѱ��ش�
		return k07_count;
	}

	public static void main(String[] args) {
		// ���ڸ� String ������ ����Ҷ� 1000(õ) �������� �޸�(,)�� ǥ���ϵ��� �����ش�.
		DecimalFormat k07_df = new DecimalFormat("###,###,###,###,###");
		// ��¥ ����� ���� Į���� ������ ���� �� �����Ѵ�
		Calendar k07_cal = Calendar.getInstance();
		// ���� ��¥ �� �ð��� � �������� ������� ������ �����ش�		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm");
		
		// ������ ǰ����� String �迭�� ���������� 30���� ������� ���Ҵ�
		String [] k07_itemName = {"��������", "�ٳ�������", "������", "�������ֽ�", "���ڿ���",
							"ĥ�����̴�", "�����Ӹ�ī", "�ƽ���", "������", "����",
							"�������1000L", "¥�İ�Ƽ", "�Ŷ��", "�޹�", "��������",
							"���÷�", "�400g", "���ѱ�����", "���ѱ������", "�κ�200g",
							"��Ǫ�ν�Ʈ", "�ƽ�ī��", "���̽�", "�������", "Ī����",
							"�ȼ�����", "���ֻ�ټ�", "��ɹ���", "ȣ���ͽ�", "������ī"}; // �׸�� 30���̻�
		// ������ ǰ���� ���ݿ� �ش��ϴ� �ݾ��� int�� �迭�� 30�� ����
		int [] k07_price = {4000, 1000, 3300, 2500, 800,
						1700, 1500, 1000, 1200, 700,
						2900, 1400, 1500, 2000, 1700,
						3500, 1300, 2800, 1400, 1500,
						4000, 2200, 1600, 2500, 3000,
						1500, 1000, 1100, 3000, 2600};
		// ������ ��ǰ�� ��� ���� int�� �迭�� ������״�
		int [] k07_num={2,4,1,3,5,
					3,6,2,1,2,
					3,4,2,1,1,
					2,3,4,1,1,
					3,5,6,2,3,
					2,1,1,3,4};
		// ������ ǰ���� ��ǰ�� �鼼��ǰ���� ������ǰ���� true�� false�� �����ؼ� 
		// boolean�� �迭�� ���������� �����ߴ�
		boolean [] k07_taxfree={true, true, false, true, true,
				true, true, false, true, true,
				true, true, true, true, false,
				true, true, true, true, true,
				false, true, false, true, true,
				true, true, false, true, false};
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
		System.out.printf("------------------------------------------------\n");
		System.out.printf("%10.10s %10.10s %8.8s %8.8s\n", "��  ǰ  ��", "��  ��", "��  ��", "��  ��");
		System.out.printf("------------------------------------------------\n");

		// �迭�� ���������� ����Ǿ� �ִ� ������ ���������� �����ͼ� ������ִ� �κ�
		// �迭�� ũ�Ⱑ 0���� 29���� 30���� �����Ƿ� 30�� �ݺ��ؼ� ������ �ȴ�
		for(int i=0; i<k07_itemName.length; i++){
			// ��ǰ�� �ѱ��� � ����ִ��� Ȯ���ؼ� 14.14s ���� �׸�ŭ ���ڸ� ���༭ ������ش�
			System.out.printf("%-5.5s%-" + String.valueOf(14-k07_HanCount(k07_itemName[i])) +"."+String.valueOf(14-k07_HanCount(k07_itemName[i]))+"s" +
			// ���׿����ڸ� ����ؼ� ��ǰ��ȣ�� 10���� ������ ���� �տ� 0�� �ٿ��ְ� �鼼��ǰ�̸� �ڿ� *�� �����ش�
					 "%6.6s%10.10s%12.12s\n", i+1 < 10 ? "0"+String.valueOf(i+1) : i+1 + ((k07_taxfree[i] == false) ? "*" : ""), k07_itemName[i], k07_df.format(k07_price[i]), k07_df.format(k07_num[i]), k07_df.format(k07_price[i]*k07_num[i]));

			// ��ǰ�� ������ǰ�̶�� �����ݾװ� ���� �κ��� ������ش�.
			if (k07_taxfree[i] == false) {
				// ���� �ݾ��� ���ϱ� ���� �Һ��� ���ݿ��� 1.1�� �����ش� 
				// �������� 0���� �� �������� ������ 5�� ���ؼ� 10���� ������ �����־� �ݿø� ó���� ���ش�
				k07_beforeTax = ((int)(k07_price[i] / 1.1 % 10)) != 0 ? (int)(k07_price[i] / 1.1+5) /10 * 10 : (int)(k07_price[i] / 1.1);
				// ���� ��ǰ�� ������ ���� ������ ������ش�
				k07_tax = (int) ((k07_price[i]-k07_beforeTax)*k07_num[i]);
				// ���� ������ ���� ���� ���� taxSum�� ���������ش�
				k07_taxSum += k07_tax;
				// �����ݾ��� ������ beforeTaxSum ������ ���������ش�
				k07_beforeTaxSum+= k07_beforeTax*k07_num[i];
			}else	// �鼼��ǰ�� ���� ó��
				k07_freeSum += k07_price[i]*k07_num[i];
			
			// �鼼�� ������ ��� ������ ��ü ��ǰ�� ���� �������� sum ������ ����
			k07_sum+= k07_price[i]*k07_num[i];
			
		}
		// ������ ���� ���� ������ ���̴�� ȭ�鿡 ������ش�
		System.out.printf("%20.20s %22.22s\n", "(*)�� ��  �� ǰ", k07_df.format(k07_freeSum));
		System.out.printf("%20.20s %22.22s\n", "�� ��  �� ǰ", k07_df.format(k07_beforeTaxSum));
		System.out.printf("%21.21s %22.22s\n", "��   ��   ��", k07_df.format(k07_taxSum));
		System.out.printf("%22.22s %22.22s\n", "��        ��", k07_df.format(k07_beforeTaxSum+k07_taxSum+k07_freeSum));
		System.out.printf("%-18.18s%23.23s\n", "�� �� �� �� �� ��", k07_df.format(k07_sum));
		System.out.printf("------------------------------------------------\n");
		System.out.printf("%-20.20s%25.25s\n", "0024 �� ��", "5417**8890/07850246");
		System.out.printf("%-15.15s%25.25s\n", "ī�����", "�Ͻú� / "+ k07_df.format(k07_sum));
		System.out.printf("------------------------------------------------\n");
	}
}


