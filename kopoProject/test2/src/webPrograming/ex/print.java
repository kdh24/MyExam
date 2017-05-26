package webPrograming.ex;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class print {
	public static void main(String[] args) {
		DecimalFormat k07_df = new DecimalFormat("###,###,###,###,###");
		
		// ���� ����
		int k07_iPrice = 21000;
		// ���� ������ ���ǰ�
		int k07_beforMoney = (int)(k07_iPrice/1.1);
		// ���� ����
		double k07_tax = k07_iPrice - k07_beforMoney;
		
		int k07_card = k07_iPrice;
		int k07_cash = 0;
		if(k07_card == 0)
			k07_cash = k07_iPrice;
		else
			k07_cash = 0;
		
		Calendar k07_calt = Calendar.getInstance();
		SimpleDateFormat k07_sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

		System.out.printf("%30.30s\n", "��   ��   ��");
		System.out.printf("-----------------------------------------------------\n");
		System.out.printf("%-100.100s\n", "���λ�ȸ(�д缭����)  129-17-77924");
		System.out.printf("%-100.100s\n", "�̻�ö  031 781 1596");
		System.out.printf("%-100.100s\n", "������ �д籸 ������ 269-3");
		System.out.printf("%-100.100s\n", "���̺�� : 12");
		System.out.printf("%-100.100s\n", "�ֹ���ȣ : 20160425 01 00041");
		System.out.printf("-----------------------------------------------------\n");
//		System.out.printf("%-86.86s%d\n", "�ֹ��հ�", k07_iPrice);
		System.out.printf("%-30.30s", "�ֹ��հ�");
		System.out.printf("%19.19s\n",  k07_df.format(k07_iPrice));
		System.out.printf("%-30.30s", "���αݾ�");
		System.out.printf("%19.19s\n",  k07_df.format(0));
		System.out.printf("%-30.30s", "�����ݾ�");
		System.out.printf("%19.19s\n",  k07_df.format(k07_iPrice));
		System.out.printf("-----------------------------------------------------\n");
		System.out.printf("%-18.18s %6.6s", "��   ��", k07_df.format(k07_cash));
		System.out.printf("%10.10s%14.14s\n", "��   ��", k07_df.format(k07_beforMoney));
		System.out.printf("%-18.18s %6.6s", "ī   ��", k07_df.format(k07_card));
		System.out.printf("%10.10s%14.14s\n", "��   ��", k07_df.format(k07_tax));
		System.out.printf("%-18.18s%6.6s", "����Ʈ", k07_df.format(0));
		System.out.printf("%10.10s%14.14s\n", "��   ��", k07_df.format(0));
		System.out.printf("%35.35s%14.14s\n", "�����ݾ�", k07_df.format(k07_iPrice));
		System.out.printf("-----------------------------------------------------\n");
		if(k07_card != 0){
			System.out.printf("%28.28s\n", "[�츮ī�� �ſ� ����]");
			System.out.printf("%-14.14s%20.20s\n", "��  ��  ��  ��  : ", k07_sdt.format(k07_calt.getTime()));
			System.out.printf("%-100.100s\n", "ī  ��  ��  ȣ  : 55222059****2021");
			System.out.printf("%-100.100s\n", "��  ��  ��  ȣ  : 79753574  �Һΰ��� : 00");
			System.out.printf("%-14.14s%-20.20s\n", "��  ��  ��  ��  :", k07_df.format(k07_iPrice));
			System.out.printf("%-100.100s\n", "��  ��  ��  ȣ  : 730461774  /  ��ī���");
			System.out.printf("%-100.100s\n", "�� �� ��   ��ȣ : 129-17-77924");
			System.out.printf("-----------------------------------------------------\n");
			System.out.printf("%-40.40s%11.11s\n", "2016-04-25  12:44  CASHIER :", "����");
			System.out.printf("-----------------------------------------------------\n");
			System.out.printf("%-100.100s\n", "���� �մϴ�.");
		
		}
	}

}
