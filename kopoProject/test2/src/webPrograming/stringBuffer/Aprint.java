package webPrograming.stringBuffer;

import java.util.ArrayList;

public class Aprint {

//	public static void main(String[] args) {
//		OneRec OneRec;

		static ArrayList<OneRec> ArrayOneRec = new ArrayList<OneRec>();
		
		static int sumkor=0;
		static int sumeng=0;
		static int summat=0;
		static int sumsum=0;
		static int sumave=0;
		static final int iPerson = 20;
		
		//������ �����
		public static void dataSet(){
			for(int i=0; i<iPerson; i++){
				String name=String.format("ȫ��%02d", i);	//�̸������
				int kor = (int)(Math.random()*100);	//�������� �����
				int eng = (int)(Math.random()*100);	//�������� �����
				int mat = (int)(Math.random()*100);	//�������� �����
				ArrayOneRec.add(new OneRec(i,name,kor,eng,mat)); // �ϳ��� OneRecŬ������ ���� �� ArrayList�� ����־���.
			}
		}
//	}

}
