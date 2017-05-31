package webPrograming.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class L07 {
	public static void main(String[] args) throws IOException {
		// �ֽĵ����Ͱ� ����ִ� ������ �����ͼ� ó���ϱ� ���� File Ŭ���� �����
		File f= new File("C:\\test\\day_data\\THTSKS010H00.dat");
		// BufferedReader Ŭ������ �̿��� ���ϳ��� ó�����ش�
		BufferedReader br = new BufferedReader(new FileReader(f));

		String readtxt;
		// �ݺ�Ƚ�� ó�� ����
		int LineCnt=0;
		// ���� �ִ��� Ȯ���ϱ� ���� ����
		int n=-1;
		// StringBuffer Ŭ���� ���� �� ����
		StringBuffer s = new StringBuffer();
		// ���� ������ �����ش�
		while(true){
			// char �� �迭�� 1000���� ������ �� �ִ� ������ŭ ����
			char[] ch = new char[1000];
			// ch �迭�� ũ�⸸ŭ �����ͼ� n������ �������ش�
			n = br.read(ch);
			// ������ ���� ������ ����
			if(n==-1)break;
			// char ������ ������ ch�� ���� char�� ���� c�� �ϳ��� �����ͼ� �ݺ�ó�����ش�
			for(char c:ch){
				// ���� c�� �����̸� ���� s�� ������ ������ ȭ�鿡 ���
				if(c=='\n'){
					System.out.printf("[%s]***\n", s.toString());
					// ����ϰ� s���۸� �����ش�
					s.delete(0, s.length());
				}else{ // s ���ۿ� c�� ������ �������ش�
					s.append(c);
				}
			}
			//Ƚ�� ����
			LineCnt++;
		}// ������ �۾��� ȭ�鿡  ǥ��
		System.out.printf("[%s]***\n",s.toString());
		br.close();
	}

}
