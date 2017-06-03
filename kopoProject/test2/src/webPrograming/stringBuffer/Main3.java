package webPrograming.stringBuffer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class Main3 {

	public static void main(String[] args) {
		// ��¥ ����� ���� Į���� ������ ���� �� �����Ѵ�
		Calendar cal = Calendar.getInstance();

		// ���� ��¥ �� �ð��� � �������� ������� ������ �����ش�	
		SimpleDateFormat df = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");
//		
		dataSet(); 		// ������ ����
		dataSort();		// ������ ����
//		HeaderPrint(1, df.format(cal.getTime()));	// ����μ�
//		for(int i=0; i<ArrayOneRec.size(); i++){ //�����μ�
//			ItemPrint(i);
//		}
		
		int pageNum = 10;
		int maxLoop = ArrayOneRec.size() % (double)pageNum != 0 ?  (ArrayOneRec.size() / pageNum)+1:ArrayOneRec.size() / pageNum ;
		int pageCount = 1;
		int dataCount = 0;
		int dataStart = 0;
		
		for(int i = 0; i<maxLoop; i++){
			HeaderPrint(pageCount,df.format(cal.getTime()));
			if (i == maxLoop - 1) {
				if(Main3.iPerson % pageNum != 0){
					pageNum= Main3.iPerson % pageNum;
				}
			}
			for(int j=dataStart; j<dataStart+pageNum; j++){
				ItemPrint(j);
//				dataCouEut.printf(" %d\n", maxLoop);
				dataCount++;
			}
			dataStart = (i+1)* pageNum;
			TailPrint(pageNum, dataCount); // �����μ�
			pageCount++;
		}
		pageNum=0;
		
	}
	
	static ArrayList<OneRec> ArrayOneRec = new ArrayList<>();

	static int sumKor=0;
	static int sumEng=0;
	static int sumMat=0;
	static int sumSum=0;
	static int sumAve=0;
	static int sumKorTotal=0;
	static int sumEngTotal=0;
	static int sumMatTotal=0;
	static int sumSumTotal=0;
	static int sumAveTotal=0;
	static final int iPerson=52;
	
	//������ �����
	public static void dataSet(){
		String name = null;
		int kor = 0;
		int eng = 0;
		int mat = 0;
		for(int i=0; i<iPerson; i++){
			name = String.format("ȫ��%02d", i); // �̸� �����
			kor = (int)(Math.random()*100);	//�������� �����
			eng = (int)(Math.random()*100);	//�������� �����
			mat = (int)(Math.random()*100);	//�������� �����
			ArrayOneRec.add(new OneRec(i+1,name,kor,eng,mat)); // �ϳ��� OneRecŬ������ ���� �� ArrayList�� ����־���.

//			System.out.println(i);
		}
	}
	
	// ��� �μ�
	public static void HeaderPrint(int page, String cal){
		// ��¥ ����� ���� Į���� ������ ���� �� �����Ѵ�
//		Calendar cal1 = Calendar.getInstance();
//
//		// ���� ��¥ �� �ð��� � �������� ������� ������ �����ش�
//		SimpleDateFormat df = new SimpleDateFormat("YYYY.MM.DD HH:mm:ss");
		
		System.out.printf("%20.20s\n", "��������ǥ");
		System.out.printf("%-4.4s: %-2d %40.40s\n", "PAGE", page, "������� :" + cal);
		System.out.printf("====================================================\n");
		System.out.printf("%4s %4s %5s %3s %3s %3s %4s\n", "��ȣ","�̸�","����","����","����","�հ�","���");
		System.out.printf("====================================================\n");
	}
	
	// ���� �μ�
	public static void ItemPrint(int i){
		OneRec rec;
		
		rec=ArrayOneRec.get(i);
		System.out.printf("%4d %8s %4d %4d %5d  %4d  %5d\n", rec.student_id(), rec.name(), rec.kor(), rec.eng(), rec.mat(), rec.sum(), (int)rec.ave());
		
		sumKor+=rec.kor();
		sumEng+=rec.eng();
		sumMat+=rec.mat();
		sumSum+=rec.sum();
		sumAve+=rec.ave();
		sumKorTotal+=rec.kor();
		sumEngTotal+=rec.eng();
		sumMatTotal+=rec.mat();
		sumSumTotal+=rec.sum();
		sumAveTotal+=rec.ave();
	}
	
	// ���� �μ�
	public static void TailPrint(int pageNum, int dataCount){
		System.out.printf("====================================================\n");
		System.out.printf("%-31.31s\n", "����������");
		System.out.printf("%-10.10s %7d %5d %5d %5d %5d\n", "�հ�", sumKor, sumEng, sumMat, sumSum, sumAve);
		System.out.printf("%-10.10s %7d %5d %5d %5d %5d\n", "���", sumKor/pageNum, sumEng/pageNum, sumMat/pageNum, sumSum/pageNum, sumAve/pageNum);
//		System.out.printf("��� %10d\n",sumEng, sumEng/(double)ArrayOneRec.size());
//		System.out.printf("�����հ� %d	�������: %6.2f\n",sumMat, sumMat/(double)ArrayOneRec.size());
		sumKor=0;
		sumEng=0;
		sumMat=0;
		sumSum=0;
		sumAve=0;
		System.out.printf("====================================================\n");
		System.out.printf("%-31.31s\n", "����������");
		System.out.printf("%-10.10s %7d %5d %5d %5d %5d\n", "�հ�", sumKorTotal, sumEngTotal, sumMatTotal, sumSumTotal, sumAveTotal);
		System.out.printf("%-10.10s %7d %5d %5d %5d %5d\n", "���", sumKorTotal/dataCount, sumEngTotal/dataCount, sumMatTotal/dataCount, sumSumTotal/dataCount, sumAveTotal/dataCount);
//		System.out.println(dataCount);
		System.out.println();
	}
	
	// ArrayList ����
	public static void dataSort(){
		Comparator<OneRec> bikyeokijun = new Comparator<OneRec>(){
			public int compare(OneRec a1, OneRec a2){
				// ���� ������ �񱳸� �Ʒ��� ���� ����
				// return (String.valueOf(a1.kor).compareTo(String.valueOf(a2.kor)));
				// a2�� ���� ũ�� ����� a2�� ���õǰ� a1�� ���� ũ�� ������ ������ �ش�.
				return (a2.sum()-a1.sum());
			}
		};
		Collections.sort(ArrayOneRec, bikyeokijun);	// ������ ������ ����(sort!)
//			Collections.reverse(ArrayOneRec); //������(������)
		
	}
}
