package webPrograming.stringBuffer;

public class report1 {
	public static void main(String[] args) {
		int iPerson=10;
		OneRec2[] inData = new OneRec2[iPerson];
		
		inData[0] = new OneRec2("ȫ��01", 100, 100, 100);
		inData[1] = new OneRec2("ȫ��02", 90, 90, 80);
		inData[2] = new OneRec2("ȫ��03", 90, 80, 80);
		inData[3] = new OneRec2("ȫ��04", 70, 70, 80);
		inData[4] = new OneRec2("ȫ��05", 90, 80, 80);
		inData[5] = new OneRec2("ȫ��06", 70, 90, 80);
		inData[6] = new OneRec2("ȫ��07", 90, 50, 80);
		inData[7] = new OneRec2("ȫ��08", 70, 60, 80);
		inData[8] = new OneRec2("ȫ��09", 90, 70, 80);
		inData[9] = new OneRec2("ȫ��10", 70, 80, 80);
		
		System.out.printf("==========================================\n");
		System.out.printf("%5.5s %3.3s %3.3s %3.3s %5.5s %5.5s\n", "�̸�", "����", "����", "����", "����", "���");
		System.out.printf("==========================================\n");

		int TotalSum = 0;
		
		for(int i=0; i<inData.length; i++){
			System.out.printf("%5.5s %5.5s %5.5s %5.5s %6.6s %6.6s\n", inData[i].name(), inData[i].kor(), inData[i].eng(), inData[i].mat(), inData[i].sum(), (int)inData[i].ave());
		}
	}
}
