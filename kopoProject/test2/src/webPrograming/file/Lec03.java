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
		File f = new File("c:\\test\\���������������ǥ�ص�����.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));

		File f1 = new File("c:\\test\\���������������ǥ�ص�����_SKT.txt");
		File f2 = new File("c:\\test\\���������������ǥ�ص�����_KT.txt");
		File f3 = new File("c:\\test\\���������������ǥ�ص�����_LGU.txt");
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2));
		BufferedWriter bw3 = new BufferedWriter(new FileWriter(f3));

		String readtxt;
		// �� ���� ���� �о�� �ʵ���� �� �� �ִ�.
		if ((readtxt = br.readLine()) == null) {
			System.out.printf("�� �����Դϴ�.\n");
			return;
		}

		// ù ���� ��� ���Ͽ� �� ����.
		bw1.write(readtxt);
		bw1.newLine();
		bw2.write(readtxt);
		bw2.newLine();
		bw3.write(readtxt);
		bw3.newLine();

		int LineCnt = 0;
		while ((readtxt = br.readLine()) != null) {
			String[] field = readtxt.split("\t");

			if (field[5].trim().equals("SKT") || field[5].trim().toLowerCase().equals("sk�ڷ���")
					|| field[5].trim().equals("SK") || field[5].trim().equals("SK, KT, LG U+")) {
				if (field[5].trim() != "SKT")
					field[5] = "SKT";
				bw1.write(readtxt);
				bw1.newLine();
			} else if (field[5].trim().equals("KT")) {
				bw2.write(readtxt);
				bw2.newLine();
			} else if (field[5].trim().equals("LGU+") || field[5].trim().equals("LGT")
					|| field[5].trim().equals("LU G+")) {
				if (field[5].trim() != "LGU+") {
					field[5] = "LGU+";
				}
				bw3.write(readtxt);
				bw3.newLine();
			} else if (field[5].trim().equals("LG U+")) {
				// �ش� �ʵ� LU G+ -> LGU+�� ���ļ� ���Ͽ� ���ÿ�
				// �׸��� SK�ڷ���, LGT� ��������...
			} else {
				System.out.printf("�� �� ���� ��Ż�[%d��° �׸�][%s]***\n", LineCnt, field[5]);
			}
			LineCnt++;
		}
		br.close();
		bw1.close();
		bw2.close();
		bw3.close();
	}
}
