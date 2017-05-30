package webPrograming.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec01 {
	public static void main(String[] args) throws IOException {// ���� ó���� ���� throws �ڹٿ��� ����ó�� �κ��� �Ѱ��ش�
		// \�� Ư�������̹Ƿ� \\ �� ���� ����Ѵ�
		File f = new File("c:\\test\\���������������ǥ�ص�����.csv");
		// ���۸� �̿��� ������ �о���� ���� BufferedReader Ŭ���� ���� �� ����
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		// ���ڿ� readtxt ����
		String readtxt;
		
		//������ ���� �о�� �ʵ���� �� �� �ִ�.
		// BufferedReader�� ���پ� �����ͼ� readtxt ������ �־��ְ� null ������ ���ؼ� null�̸� �� �����̶�� ������ش�
		if((readtxt=br.readLine())==null){
			System.out.printf("�� �����Դϴ�\n");
			return;
		}
		// ���۸� �̿��� ������ ��(ù��° ���� ��)�� ������ �޸�(,)�� ����� String �迭 field_name�� �־��ش�
		String[] field_name = readtxt.split(",");

		// ���μ��� ����ϱ� ���� int ���� ����
		int LineCnt=0;
		// BufferedReader�� ���پ� �����ͼ� readtxt ������ �־��ְ� null ������ ���ؼ� �ƴϸ� �ݺ�
		while((readtxt=br.readLine())!=null){
			// ���۸� �̿��� ������ ���� ������ �޸�(,)�� ����� String �迭 field�� �־��ش�
			String[] field = readtxt.split(",");
			// LineCnt ������ �̿��� ���° ���� ó�������� ȭ�鿡 ���
			System.out.printf("**[%d��° �׸�]******************\n", LineCnt);
			// ù��° ���� ���� ������ �ִ� field_name �迭�� ũ�⸦ �̿��ؼ� �� ũ�⸸ŭ �ݺ�ó��
			for(int j=0; j<field_name.length; j++){
				// ù��(field_name �׸�)�� �̾ ������ �� �׸���� ������ ������ ȭ�鿡 ������ش� 
				System.out.printf(" %s : %s\n", field_name[j], field[j]);
			}
			System.out.printf("*******************************\n");
			// �ݺ��ؼ� ó���� Ƚ���� 100�� ������ �����ش�
			if(LineCnt==100)break;
			// ���μ��� ����ϱ� ���� LineCnt ���� ����
			LineCnt++;
		}
		// ���� Ŭ���� �ڿ� ��ȯ
		br.close();
	}
}
