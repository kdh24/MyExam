package webPrograming.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lec03 {
	public static void main(String[] args) throws IOException {
		// \�� Ư�������̹Ƿ� \\ �� ���� ��� �Ѵ�.
		// �����ͼ� ó���� ������ ����Ŭ���� ��ü�� �̿��� �����´�
		File f = new File("C:\\test\\���������������ǥ�ص�����.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		// ������ ó�� �� ������ ������ ����Ŭ���� ��ü�� �̿��ؼ� ������ش�
		File f1 = new File("C:\\test\\���������������ǥ�ص�����_SKT.txt");
		File f2 = new File("C:\\test\\���������������ǥ�ص�����_KT.txt");
		File f3 = new File("C:\\test\\���������������ǥ�ص�����_LGU.txt");
		// BufferedWriter�� �̿��ؼ� ������ ���Ͽ� �������� ó��  
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2));
		BufferedWriter bw3 = new BufferedWriter(new FileWriter(f3));
		// �� �پ� �޾ƿ� ó���ϱ� ���� String ����
		String readtxt;
		// �� ���� ���� �о�� �ʵ���� �� �� �ִ�.
		if ((readtxt = br.readLine()) == null) {
			System.out.printf("�� �����Դϴ�.\n");
			return;
		}
		// ù ���� ��� ���Ͽ� �� ����.
		bw1.write(readtxt);bw1.newLine();
		bw2.write(readtxt);bw2.newLine();
		bw3.write(readtxt);bw3.newLine();
		// �� ��° �۾��� ó���ϴ��� Ȯ���ϱ� ���� int�� ����
		int LineCnt = 0;
		// ���پ� �����ͼ� readtxt ������ �ְ� null�� �ƴϸ� ó�� �Ѵ�.
		while ((readtxt = br.readLine()) != null) {
			// ���� �����ڷ� field �迭�� ����� ���� �����´�
			String[] field = readtxt.split("\t");

			// field 6��°�� �ش��ϴ� ���� SKT ���ڿ��̸� sk ���Ͽ� ��������ش�
			if (field[5].trim().equals("SKT") || field[5].toLowerCase().trim().equals("sk�ڷ���")){
				field[5] = "SKT";
				bw1.write(readtxt);bw1.newLine();
			// field 6��°�� �ش��ϴ� ���� SKT ���ڿ��� �ƴϰ� KT ���ڿ��̸� ���Ͽ� ��������ش�
			} else if (field[5].trim().equals("KT")) {
				bw2.write(readtxt);bw2.newLine();
				// field 6��°�� �ش��ϴ� ���� SKT, KT ���ڿ��� �ƴϰ� LGU+ ���ڿ��̸� ���Ͽ� ��������ش�				
			} else if (field[5].trim().equals("LGU+")) {
				bw3.write(readtxt);bw3.newLine();
				// field 6��°�� �ش��ϴ� ���� SKT, KT,LGU+ ���ڿ��� �ƴϰ� LG U+ ���ڿ��̸� ���Ͽ� ��������ش�								
			} else if (field[5].trim().equals("LG U+") || field[5].trim().equals("LGT")) {
				// �ش� �ʵ� LU G+ -> LGU+�� ���ļ� ���Ͽ� ���ÿ�
				// �׸��� SK�ڷ���, LGT� ��������...
				field[5] = "LGU+";
				bw3.write(readtxt);bw3.newLine();
			} else { // ���� �ش��ϴ� ������ �ϳ��� ���� �� �� �� ���� ��Ż�� ǥ���ؼ� ���° �۾������� �ʵ尪�� ȭ�鿡 �����ش�
				System.out.printf("�� �� ���� ��Ż�[%d��° �׸�][%s]***\n", LineCnt, field[5]);
			}
			// �ݺ�Ƚ�� ����
			LineCnt++;
		}
		// �ڿ� ��ȯ
		br.close();
		bw1.close();
		bw2.close();
		bw3.close();
	}
}
