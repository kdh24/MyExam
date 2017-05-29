package webPrograming.stringBuffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main01 {

	public static void main(String[] args) {
		dataSet(); 		// ������ ����
//		dataSort();		// ������ ����
		HeaderPrint();	// ����μ�
		for(int i=0; i<ArrayOneRec.size(); i++){ //�����μ�
			ItemPrint(i);
		}
		TailPrint(); // �����μ�
	}
	// OneRec Ŭ���� ������ ��� ����Ʈ ����
	static ArrayList<OneRec> ArrayOneRec = new ArrayList<>();

	// ������ ó���� ���� sum ������
	static int k07_sumKor=0;
	static int k07_sumEng=0;
	static int k07_sumMat=0;
	static int k07_sumSum=0;
	static int k07_sumAve=0;
	static final int k07_iPerson=20;
	
	//������ �����
	public static void dataSet(){
		// �����͸� ���� �����ϱ� ���� ���� 
		String k07_name = null;
		int k07_kor = 0;
		int k07_eng = 0;
		int k07_mat = 0;
		for(int i=0; i<k07_iPerson; i++){
			k07_name = String.format("ȫ��%02d", i); // �̸� �����
			k07_kor = (int)(Math.random()*100);	//�������� �����
			k07_eng = (int)(Math.random()*100);	//�������� �����
			k07_mat = (int)(Math.random()*100);	//�������� �����
			// �ϳ��� OneRecŬ������ ���� �� ArrayList�� ����־���.
			ArrayOneRec.add(new OneRec(i,k07_name,k07_kor,k07_eng,k07_mat)); 
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
		// OneRec Ŭ���� ������ ����
		OneRec k07_rec;
		
		// ��� ����Ʈ i�� ����Ǿ� �ִ� ���� �����ͼ� rec Ŭ������ �־��ش� 
		k07_rec=ArrayOneRec.get(i);
		// ��� ����Ʈ���� �޾ƿͼ� rec ������ ���� ������ �׸񺰷� ������ ������ش�
		System.out.printf("%4d %4s %3d %3d %3d  %3d  %6.2f\n", 
				k07_rec.student_id(), k07_rec.name(), k07_rec.kor(), k07_rec.eng(), k07_rec.mat(), k07_rec.sum(), k07_rec.ave());
		
		// ������ ������ ���� �������� �ش�.
		k07_sumKor+=k07_rec.kor();
		k07_sumEng+=k07_rec.eng();
		k07_sumMat+=k07_rec.mat();
		k07_sumSum+=k07_rec.sum();
		k07_sumAve+=k07_rec.ave();
	}
	
	// ���� �μ�
	public static void TailPrint(){
		// �� �׸��� �հ� �� ��� �� ���
		System.out.printf("************************************\n");
		System.out.printf("�����հ� %d	�������: %6.2f\n",k07_sumKor, k07_sumKor/(double)ArrayOneRec.size());
		System.out.printf("�����հ� %d	�������: %6.2f\n",k07_sumEng, k07_sumEng/(double)ArrayOneRec.size());
		System.out.printf("�����հ� %d	�������: %6.2f\n",k07_sumMat, k07_sumMat/(double)ArrayOneRec.size());
		System.out.printf("************************************\n");
		System.out.printf("������հ� %d		�����: %6.2f\n",k07_sumAve,k07_sumAve/(double)ArrayOneRec.size());
	}
	
	// ArrayList ����
	public static void dataSort(){
		Comparator<OneRec> k07_bikyeokijun = new Comparator<OneRec>(){
			public int compare(OneRec a1, OneRec a2){
				// ���� ������ �񱳸� �Ʒ��� ���� ����
				// return (String.valueOf(a1.kor).compareTo(String.valueOf(a2.kor)));
				// a2�� ���� ũ�� ����� a2�� ���õǰ� a1�� ���� ũ�� ������ ������ �ش�.
				return (a2.sum()-a1.sum());
			}
		};
		Collections.sort(ArrayOneRec, k07_bikyeokijun);	// ������ ������ ����(sort!)
//			Collections.reverse(ArrayOneRec); //������(������)
		
	}
}
