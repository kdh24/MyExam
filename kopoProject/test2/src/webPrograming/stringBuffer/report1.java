package webPrograming.stringBuffer;

public class report1 {
	public static void main(String[] args) {
		// Ŭ���� �迭�� ������ ���ϱ� ���� iPerson ����
		int k07_iPerson=10;
		// OneRec2 Ŭ������ Ŭ���� �迭�� iPerson ����ŭ ����
		OneRec2[] k07_inData = new OneRec2[k07_iPerson];
		
		// Ŭ���� �迭 0~9�������� ���� �ʱ�ȭ �����ش�
		k07_inData[0] = new OneRec2("ȫ��01", 100, 100, 100);
		k07_inData[1] = new OneRec2("ȫ��02", 90, 90, 80);
		k07_inData[2] = new OneRec2("ȫ��03", 90, 80, 80);
		k07_inData[3] = new OneRec2("ȫ��04", 70, 70, 80);
		k07_inData[4] = new OneRec2("ȫ��05", 90, 80, 80);
		k07_inData[5] = new OneRec2("ȫ��06", 70, 90, 80);
		k07_inData[6] = new OneRec2("ȫ��07", 90, 50, 80);
		k07_inData[7] = new OneRec2("ȫ��08", 70, 60, 80);
		k07_inData[8] = new OneRec2("ȫ��09", 90, 70, 80);
		k07_inData[9] = new OneRec2("ȫ��10", 70, 80, 80);
		
		// ���� ����ϱ� ���� �ش� �׸���� � ������ ���̿� ���� ǥ�����ش�
		System.out.printf("==========================================\n");
		System.out.printf("%5.5s %3.3s %3.3s %3.3s %5.5s %5.5s\n", "�̸�", "����", "����", "����", "����", "���");
		System.out.printf("==========================================\n");

		// OneRec2 Ŭ������ �迭 inData�� ũŰ��ŭ �ݺ�
		for(int i=0; i<k07_inData.length; i++){
			// Ŭ���� �迭�� �� �׸���� ���� ������ ������ش�.
			System.out.printf("%5.5s %5.5s %5.5s %5.5s %6.6s %6.6s\n",
					k07_inData[i].name(), k07_inData[i].kor(), k07_inData[i].eng(), k07_inData[i].mat(), k07_inData[i].sum(), (int)k07_inData[i].ave());
		}
	}
}
