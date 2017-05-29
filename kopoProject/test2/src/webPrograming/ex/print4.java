package webPrograming.ex;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class print4 {
	public static void main(String[] args) {
		// 1000(õ) �������� �޸� ó���� �ϱ� ���� DecimalFormat ��ü ���� �� ���� ����
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		
		// ��¥���� �������� ���� Calendar ��ü ���� �� ����
		Calendar k07_cal = Calendar.getInstance();
		// ��¥�� �������ִ� �������� ����ϱ� ���� SimpleDateFormat Ŭ����
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm");
		
		// String �迭�� �� �׸��� ���������� �Է����ش�.
		String [] OneRec= {
				"01   ��������       4,000         2       8,000",
				"02   �ٳ�������     1,000         4       4,000",
				"03   ������         3,300         1       3,300",
				"04   �������ֽ�     2,500         3       7,500",
				"05   ���ڿ���         800         5       4,100",
				"06   ĥ�����̴�     1,700         3       5,100",
				"07   �����Ӹ�ī     1,500         6       9,000",
				"08   �ƽ���         1,000         2       2,000",
				"09   ������         1,200         1       1,200",
				"10   ����             700         2       1,400",
				"11   �������1000L  2,900         3       8,700",
				"12   ¥�İ�Ƽ       1,400         4       5,600",
				"13   �Ŷ��         1,500         2       3,000",
				"14   �޹�           2,000         1       2,000",
				"15   ��������       1,700         1       1,700",
				"16   ���÷�         3,500         2       7,000",
				"17   �400g       1,300         3       3,900",
				"18   ���ѱ�����     2,800         4      11,200",
				"19   ���ѱ������   1,400         1       1,400",
				"20   �κ�200g       1,500         1       1,500",
				"21   ��Ǫ�ν�Ʈ     4,000         3      12,200",
				"22   �ƽ�ī��       2,200         5      11,000",
				"23   ���̽�         1,600         6       9,600",
				"24   �������       2,500         2       5,000",
				"25   Ī����         3,000         3       9,000",
				"26   �ȼ�����       1,500         2       3,000",
				"27   ���ֻ�ټ�     1,000         1       1,000",
				"28   ��ɹ���     1,100         1       1,100",
				"29   ȣ���ͽ�       3,000         3       9,000",
				"30   ������ī       2,600         4      10,400"};

		// ��Ż ����Ʈ 47
		// OneRec �迭�� ������ �׸� ���� ��ǰ��ȣ, ��ǰ��, ��ǰ����, ����, �Ѿ���  ó���� ���� ����
		String k07_pId = null;	// ��ǰ ��ȣ
		String k07_pName = null;	// ��ǰ��
		int k07_pPrice = 0;	// ��ǰ����
		int k07_pNum = 0;	// ���ż���
		int k07_pTotal = 0;	// �Ѿ�

		// OneRec �迭�� ���̸�ŭ �ݺ��ؼ� ó�����ִ� for �ݺ���
		for(int i=0; i<OneRec.length; i++){
			// ��Ż ����Ʈ 47
			//OneRec �迭�� ������ �׸� ���� ��ǰ��ȣ, ��ǰ��, ��ǰ����, ����, �Ѿ��� ���� 
			// ������ ������ �������ش�(������ ��ġ�� �ش��ϴ� Byte ������ �����ͼ� �޸��� �����ְ� �յ� ���鵵 �������ش�)
			k07_pId = new String(OneRec[i].getBytes(),0,4);	// ��ǰ��
			k07_pName = new String(OneRec[i].getBytes(),5,15);	// ��ǰ��
			k07_pPrice = Integer.parseInt(new String(OneRec[i].getBytes(),20,10).trim().replaceAll(",", ""));	// ��ǰ����
			k07_pNum = Integer.parseInt(new String(OneRec[i].getBytes(),30,10).trim().replaceAll(",", ""));	// ���ż���
			k07_pTotal = Integer.parseInt(new String(OneRec[i].getBytes(),40,7).trim().replaceAll(",", ""));	// �Ѿ�
			
			// �迭���� ������ ���ݰ� ������ ���� ���� �Ѿװ� ���� ������ ����
			if(k07_pPrice * k07_pNum != k07_pTotal){
				System.out.printf("****************************************************\n");
				// �������� ���� �κ��� ȭ�鿡 ������ش�
				System.out.printf("����[%s]\n",OneRec[i].toString());
				// ������ ��갪�� �߸��Ǿ����Ƿ� ����� �� ��갪�� ���� �ش� ��ġ�� �ٲ㼭 �ٽ� �־��ش�.
				// replaceAll �Լ��� ����Ѵ�.
				OneRec[i]= OneRec[i].toString().replaceAll(new String(OneRec[i].getBytes(),40,7).trim(), df.format(k07_pPrice*k07_pNum));

				// ������ ��갪�� ����� �� ������ �����������Ƿ� �ٲ� ���� �ٽ� ����ؼ� Ȯ���Ѵ�
				System.out.printf("����[%s]\n",OneRec[i].toString());
				System.out.printf("****************************************************\n");
			}
		}
	}
}


