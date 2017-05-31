package webPrograming.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec02_3 {
	public static void main(String[] args) throws IOException {
		// \�� Ư�������̹Ƿ� \\ �� ���� ����Ѵ�
		File k07_f = new File("C:\\test\\����������ǥ�ص�����.txt");
		// ������ ���� ���� ���� Ŭ���� ���� �� ����
		BufferedReader k07_br = new BufferedReader(new FileReader(k07_f));
		
		// ���� Ŭ������ �̿��ؼ� ���پ� ������ ������ String ����
		String k07_readtxt;
		
		//�� ���� ���� �о�� �ʵ���� �� �� �ִ�.
		// ���Ͽ��� �о�� ���� ���� ��� �� �����̶�� �˷��ش�
		if((k07_readtxt=k07_br.readLine())==null){
			System.out.printf("�� �����Դϴ�.\n");
			return;
		}
		// �� ������ �ƴҶ� ó������ ������ ���� �׸��� ����κ��̹Ƿ� field_name �迭�� ������ ���� 
		String[] k07_field_name = k07_readtxt.split("\t");
		
		//���ձ�� �츮�� �����浵, �������� �˾ƺ���
		double k07_lat=37.3860521;
		double k07_lng=127.1214038;
		// �ִ� �Ÿ� �ּҰŸ� ����
		double k07_distMax=0.0;
		double k07_distMin=0.0;
		// �ִ�,�ּҰ� �׸��� �����ϱ� ���� String �迭
		String[] k07_Max =new String[3];
		String[] k07_Min =new String[3];
		
		// �ݺ� Ƚ���� �˱����� int ����
		int k07_LineCnt=0;
		int k07_wcnt=0;
		
		// ������ ������� ������ �����ͼ� �ݺ�ó��
		while((k07_readtxt=k07_br.readLine())!=null){
			// ��(\t)�� �����ڷ� ���ۿ��� ������ ������ ��(readtxt)�� field �迭�� ������ �������ش�
			String[] k07_field = k07_readtxt.split("\t");
			// ������ ������ �� �������� ���� ���ϴ� �׸� index ������ ȭ�鿡 ������ش�
			if(k07_field.length > 32){
				System.out.printf("**[%d��° �׸�]***********\n", k07_LineCnt);
				System.out.printf(" %s : %s\n", k07_field_name[4], k07_field[4]);//9�� : �����ּ�
				System.out.printf(" %s : %s\n", k07_field_name[5], k07_field[5]);//9�� : �����ּ�
				System.out.printf(" %s : %s\n", k07_field_name[31], k07_field[31]);//12�� : �����ּ�
				System.out.printf(" %s : %s\n", k07_field_name[32], k07_field[32]);//13�� : �浵�ּ�
			}
			// �Ÿ��� ���ϴ� �� 
			if (k07_field.length > 31 ) {
				double k07_dist = Math.sqrt(Math.pow(Double.parseDouble(k07_field[31]) - k07_lat, 2)
						+ Math.pow(Double.parseDouble(k07_field[32]) - k07_lng, 2));
				// �Ÿ� ���ϴ� ���� �̿��� ���� �������� �Ÿ��� ���ؼ� ȭ�鿡 ������ش�
				System.out.printf(" ���������� �Ÿ� : %f\n", k07_dist); // 13�� : �浵�ּ�
				
				if (k07_wcnt == 0) { // ó���� ����� �Ÿ������� �ʱ�ȭ
					k07_distMax = k07_dist;
					k07_distMin = k07_dist;
					k07_wcnt++;
				} else {// ó���� �ƴҶ� �Ʒ��� ���� ���� �� ���� ó��
						// ���� ���� �Ÿ��� distMax ���� ũ�� �ִ밪�̹Ƿ� distMax ������ �������ش�
					if (k07_distMax < k07_dist) {
						k07_distMax = k07_dist;
						// �ִ밪�� �׸��� Max �迭�� �������ش�
						k07_Max[0] = k07_field[4].trim();
						k07_Max[1] = k07_field[31];
						k07_Max[2] = k07_field[32];
					}
					// ���� ���� �Ÿ��� distMax ���� ������ �ּҰ��̹Ƿ� distMin ������ �������ش�
					if (k07_distMin > k07_dist && k07_dist > 0.0001) {
						k07_distMin = k07_dist;
						// �ּҰ��� �׸��� Min �迭�� �������ش�
						k07_Min[0] = k07_field[4].trim();
						k07_Min[1] = k07_field[31];
						k07_Min[2] = k07_field[32];
					}
					k07_wcnt++;
				}

//				System.out.println(distMin);
			}
			// �ѹ� ����ɶ����� �ݺ�Ƚ�� ����
			k07_LineCnt++;
		}

		System.out.printf("*******************************\n", k07_LineCnt);
		// ������ ��ġ���� ���� �� ���� ����� ���� ���� ������ ȭ�鿡 �ѷ��ش�
		System.out.printf("��Ƚ�� : %s\n", k07_wcnt);
		System.out.printf("���� �� ������ : %s\n",k07_Max[0]);
		System.out.printf("���� �� �Ÿ� ����  : %s\n",k07_Max[1]);
		System.out.printf("���� �� �Ÿ� �浵  : %s\n",k07_Max[2]);
		System.out.printf("���� �� �Ÿ� ��   : %s\n", k07_distMax);
		System.out.printf("���� ����� ������ : %s\n",k07_Min[0]);
		System.out.printf("���� ����� ����  : %s\n",k07_Min[1]);
		System.out.printf("���� ����� �浵  : %s\n",k07_Min[2]);
		System.out.printf("���� ����� �Ÿ�  : %s\n", k07_distMin);
		// ���� Ŭ���� ����ó��
		k07_br.close();
	}
}
