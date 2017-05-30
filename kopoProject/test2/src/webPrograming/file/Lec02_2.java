package webPrograming.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec02_2 {
	public static void main(String[] args) throws IOException {
		// \�� Ư�������̹Ƿ� \\ �� ���� ����Ѵ�
		File f = new File("c:\\test\\���������������ǥ�ص�����.txt");
		// ������ ���� ���� ���� Ŭ���� ���� �� ����
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		// ���� Ŭ������ �̿��ؼ� ���پ� ������ ������ String ����
		String readtxt;
		
		//�� ���� ���� �о�� �ʵ���� �� �� �ִ�.
		// ���Ͽ��� �о�� ���� ���� ��� �� �����̶�� �˷��ش�
		if((readtxt=br.readLine())==null){
			System.out.printf("�� �����Դϴ�.\n");
			return;
		}
		// �� ������ �ƴҶ� ó������ ������ ���� �׸��� ����κ��̹Ƿ� field_name �迭�� ������ ���� 
		String[] field_name = readtxt.split("\t");
		
		//���ձ�� �츮�� �����浵, �������� �˾ƺ���
		double lat=37.3860521;
		double lng=127.1214038;
		// �ִ� �Ÿ� �ּҰŸ� ����
		double distMax=0.0;
		double distMin=0.0;
		// �ִ�,�ּҰ� �׸��� �����ϱ� ���� String �迭
		String[] Max =new String[3];
		String[] Min =new String[3];
		
		// �ݺ� Ƚ���� �˱����� int ����
		int LineCnt=0;
		// ������ ������� ������ �����ͼ� �ݺ�ó��
		while((readtxt=br.readLine())!=null){
			// ��(\t)�� �����ڷ� ���ۿ��� ������ ������ ��(readtxt)�� field �迭�� ������ �������ش�
			String[] field = readtxt.split("\t");
			// ������ ������ �� �������� ���� ���ϴ� �׸� index ������ ȭ�鿡 ������ش�
			System.out.printf("**[%d��° �׸�]***********\n", LineCnt);
			System.out.printf(" %s : %s\n", field_name[9], field[9]);//9�� : �����ּ�
			System.out.printf(" %s : %s\n", field_name[12], field[12]);//12�� : �����ּ�
			System.out.printf(" %s : %s\n", field_name[13], field[13]);//13�� : �浵�ּ�
			// �Ÿ��� ���ϴ� �� 
			double dist=Math.sqrt( Math.pow(Double.parseDouble(field[12])-lat,2)
			 + Math.pow(Double.parseDouble(field[13])-lng,2));
			// �Ÿ� ���ϴ� ���� �̿��� ���� �������� �Ÿ��� ���ؼ� ȭ�鿡 ������ش�
			System.out.printf(" ���������� �Ÿ� : %f\n", dist); // 13�� : �浵�ּ�
			if(LineCnt == 0){ // ó���� ����� �Ÿ������� �ʱ�ȭ ���ش�
				distMax = dist;
				distMin = dist;
			}else{// ó���� �ƴҶ� �Ʒ��� ���� ���� �� ���� ó��
				// ���� ���� �Ÿ��� distMax ���� ũ�� �ִ밪�̹Ƿ� distMax ������ �������ش�
				if (distMax < dist) {
					distMax = dist;
					// �ִ밪�� �׸��� Max �迭�� �������ش�
					Max[0] = field[9] == null ? "" : field[9];
					Max[1] = field[12];
					Max[2] = field[13];
				}
				// ���� ���� �Ÿ��� distMax ���� ������ �ּҰ��̹Ƿ� distMin ������ �������ش�
				if (distMin > dist) {
					distMin = dist;
					// �ּҰ��� �׸��� Min �迭�� �������ش�
					Min[0] = field[9];
					Min[1] = field[12];
					Min[2] = field[13];
				}
			}
			// �ѹ� ����ɶ����� �ݺ�Ƚ�� ����
			LineCnt++;
		}

		System.out.printf("*******************************\n", LineCnt);

		System.out.printf("���� �� �Ÿ�  �ּ� %s\n",Max[0]);
		System.out.printf("���� �� �Ÿ�  ���� %s\n",Max[1]);
		System.out.printf("���� �� �Ÿ�  �浵 %s\n",Max[2]);
		System.out.printf("���� �� �Ÿ� �� : %s\n", distMax);
		System.out.printf("���� �����  �ּ� %s\n",Min[0]);
		System.out.printf("���� �����  ���� %s\n",Min[1]);
		System.out.printf("���� �����  �浵 %s\n",Min[2]);
		System.out.printf("���� ����� �Ÿ� �� : %s\n", distMin);
		// ���� Ŭ���� ����ó��
		br.close();
	}
}
