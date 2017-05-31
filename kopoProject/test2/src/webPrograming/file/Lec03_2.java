package webPrograming.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lec03_2 {
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
			// �ʵ� 6��° ���� ���̰� 1 �̻��� ���� �����ϰ� �Ѵ�
			if (field[5].trim().length() > 1) {
				// ������ SK�� ������ ���ǵ��� �����ؼ� ó�����ش�
				if (field[5].trim().equals("SKT")
						|| field[5].trim().replace("\"", "").substring(0, 2).toLowerCase().equals("sk")
						|| field[5].trim().toLowerCase().contains("����Ư����û")
								&& field[5].trim().toLowerCase().contains("sk")
						|| field[5].trim().contains("�̷�â��")
								&& field[5].trim().toLowerCase().contains("skt")
						|| field[5].trim().toLowerCase().contains("��sk")) {
					// 6��° �ʵ��� ���� SKT�� �ƴҰ�� SKT�� �����ؼ� ���Ͽ� ���ش�.
					if (field[5].trim() != "SKT")
						field[5] = "SKT";
					bw1.write(readtxt);
					bw1.newLine();
				// ������ KT�� ������ ���ǵ��� �����ؼ� ó�����ش�
				} else if (field[5].trim().equals("KT")
						|| field[5].trim().replace("\"", "").substring(0, 2).toLowerCase().equals("kt")
						|| (field[5].trim().toLowerCase().contains("����Ư����û")
								&& field[5].trim().toLowerCase().contains("-kt"))
						|| field[5].trim().contains("����Ƽ")
						|| (field[5].trim().toLowerCase().contains("����û")
								&& field[5].trim().toLowerCase().contains("kt\""))
						|| field[5].trim().toLowerCase().contains("��kt")) {
					// 6��° �ʵ��� ���� KT�� �ƴҰ�� KT�� �����ؼ� ���Ͽ� ���ش�.					
					if (field[5].trim() != "KT")
						field[5] = "KT";
					bw2.write(readtxt);
					bw2.newLine();
				// ������ LG�� ������ ���ǵ��� �����ؼ� ó�����ش�					
				} else if (field[5].trim().equals("LGU+")
						|| field[5].trim().replace("\"", "").substring(0, 2).toLowerCase().equals("lg")
						|| field[5].trim().replace("\"", "").substring(0, 2).toLowerCase().equals("u+")
						|| field[5].trim().toLowerCase().contains("������")
						|| field[5].trim().toLowerCase().contains("����Ư����û")
								&& field[5].trim().toLowerCase().contains("lg")
						|| field[5].trim().toLowerCase().contains("����û")
								&& field[5].trim().toLowerCase().contains("lgu\"")) {
					// 6��° �ʵ��� ���� LGU+�� �ƴҰ�� LGU+�� �����ؼ� ���Ͽ� ���ش�.					
					if (field[5].trim() != "LGU+")
						field[5] = "LGU+";
					bw3.write(readtxt);
					bw3.newLine();
				// ���� ���ǿ� �ƹ��͵� �ش���� ���� �� �� �� ���� ��Ż�� ǥ���ؼ� ȭ�鿡 ������ش�
				} else {
					System.out.printf("�� �� ���� ��Ż�[%d��° �׸�][%s]***\n", LineCnt, field[5]);
				}
			}
			// �ݺ�Ƚ�� ����
			LineCnt++;
		}
		//�ڿ� ��ȯ
		br.close();bw1.close();bw2.close();bw3.close();
	}
}
