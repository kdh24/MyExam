package webPrograming.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L08_1 {

	//���� ����...
	public static void main(String[] args) throws IOException {
		// \�� Ư�������̹Ƿ� \\ �� ���� ����Ѵ�
		// �ֽĵ����Ͱ� ����ִ� ������ �����ͼ� ó���ϱ� ���� File Ŭ���� �����
		File f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
		BufferedReader br = new BufferedReader(new FileReader(f));
		// �����͸� �����ϱ� ���� File Ŭ���� �����
		File f1 = new File("c:\\test\\A005930.csv");
		BufferedWriter bw1=new BufferedWriter(new FileWriter(f1));
		// ���پ� ������ �����ϱ� ���� ����
		String readtxt;
		// �ݺ�Ƚ���� �����ϱ� ���� int�� ����
		int cnt = 0; int wcnt=0;
		// ������ ������ readtxt ������ ������ null���� �ƴϸ� �����Ѵ�
		while((readtxt=br.readLine())!= null){
			// StringBuffer ���� �� ����
			StringBuffer s = new StringBuffer();
			// ������ ������ %_% �����ڷ� ������ field �迭�� �����´�
			String[] field = readtxt.split("%_%");
			// field�� ���̰� 2���� ũ��, 3��° ������ ^�� ������ ���ְ� �Ｚ�ڵ�(A005930)���� Ȯ���ϴ� if��
			if(field.length>2&&field[2].replace("^", "").trim().substring(0,7).equals("A005930")){
				// ���� ó�� s ���ۿ� �ʵ� ù��° ���� ^�� ������ �����ؼ� �߰����ش�
				s.append(field[0].replace("^", "").trim());
				// �ʵ��� ���̸�ŭ �ݺ��ϴ� for �ݺ���
				for(int j=1; j<field.length; j++){
					// ó�� ���� s ���ۿ� �ʵ� j��° ���� ,�� ���̰�  ^�� ������ �����ؼ� �߰����ش�
					s.append(","+field[j].replace("^", "").trim());
				}
				// ���Ͽ� ���ְ� �� �ٲ� ó�����ش�
				bw1.write(s.toString());bw1.newLine();
				// �񱳴���� �� �ݺ�Ƚ�� ���� 
				wcnt++;
				// ��ü �ݺ�Ƚ��, �񱳴��Ƚ��, ���� ���
				System.out.printf("write [%d][%d][%s]\n", cnt,wcnt,s.toString());
			}
			// ��ü �ݺ�Ƚ�� ����
			cnt++;
		}
		// �ڿ� ��ȯ
		br.close();
		bw1.close();

		// �����ϰ� ��ü �ݺ�Ƚ�� , �񱳴�� �ݺ�Ƚ�� ���
		System.out.printf("Program End[%d][%d]records\n", cnt, wcnt);
	}

}
