package webPrograming.stringBuffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main01 {

	public static void main(String[] args) {
		dataSet(); 		// ������ ����
		dataSort();		// ������ ����
		HeaderPrint();	// ����μ�
		for(int i=0; i<ArrayOneRec.size(); i++){ //�����μ�
			ItemPrint(i);
		}
		TailPrint(); // �����μ�
	}
	
	static ArrayList<OneRec> ArrayOneRec = new ArrayList<>();

	static int sumKor=0;
	static int sumEng=0;
	static int sumMat=0;
	static int sumSum=0;
	static int sumAve=0;
	static final int iPerson=20;
	
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
			ArrayOneRec.add(new OneRec(i,name,kor,eng,mat)); // �ϳ��� OneRecŬ������ ���� �� ArrayList�� ����־���.
		}
	}
	
	// ��� �μ�
	public static void HeaderPrint(){
		System.out.printf("************************************\n");
		System.out.printf("%2s %4s %2s %2s %2s %2s  %2s\n", "��ȣ","�̸�","����","����","����","�հ�","���");
		System.out.printf("************************************\n");
	}
	
	// ���� �μ�
	public static void ItemPrint(int i){
		OneRec rec;
		
		rec=ArrayOneRec.get(i);
		System.out.printf("%4d %4s %3d %3d %3d  %3d  %6.2f\n", rec.student_id(), rec.name(), rec.kor(), rec.eng(), rec.mat(), rec.sum(), rec.ave());
		
		sumKor+=rec.kor();
		sumEng+=rec.eng();
		sumMat+=rec.mat();
		sumSum+=rec.sum();
		sumAve+=rec.ave();
	}
	
	// ���� �μ�
	public static void TailPrint(){
		System.out.printf("************************************\n");
		System.out.printf("�����հ� %d	�������: %6.2f\n",sumKor, sumKor/(double)ArrayOneRec.size());
		System.out.printf("�����հ� %d	�������: %6.2f\n",sumEng, sumEng/(double)ArrayOneRec.size());
		System.out.printf("�����հ� %d	�������: %6.2f\n",sumMat, sumMat/(double)ArrayOneRec.size());
		System.out.printf("************************************\n");
		System.out.printf("������հ� %d		�����: %6.2f\n",sumAve,sumAve/(double)ArrayOneRec.size());
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
