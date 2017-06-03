package webPrograming.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L08_3 {

	//���� ����...
	public static void main(String[] args) throws IOException {
		// \�� Ư�������̹Ƿ� \\ �� ���� ����Ѵ�
		// �ֽĵ����Ͱ� ����ִ� ������ �����ͼ� ó���ϱ� ���� File Ŭ���� �����
		File f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
		BufferedReader br = new BufferedReader(new FileReader(f));
		// �����͸� �����ϱ� ���� File Ŭ���� �����
		File f1 = new File("c:\\test\\Sam_2015_2.csv");
		BufferedWriter bw1=new BufferedWriter(new FileWriter(f1));
		// ���پ� ������ �����ϱ� ���� ����
		String readtxt;
		// �ִ�, �ּҰ� ������ ���� ����
		int sMax=0;
		int sMin=0;
		String MaxDay="";
		String MinDay="";
		// �ݺ� Ƚ�� ó���� ���� 
		int cnt = 0; int wcnt=0;
		// ������ ������ readtxt ������ ������ null���� �ƴϸ� �����Ѵ�
		while((readtxt=br.readLine())!= null){
			// StringBuffer ���� �� ����
			StringBuffer s = new StringBuffer();
			// ������ ������ %_% �����ڷ� ������ field �迭�� �����´�
			String[] field = readtxt.split("%_%");
			
//			��ǰ�ڵ尡 �Ｚ����(A005930)�̰�, 2015�⵵ ���������� Ȯ���ϴ�  if��
			if(field.length>2&&field[2].replace("^", "").trim().substring(0,7).equals("A005930")
					&& field[1].replace("^", "").trim().substring(0,4).equals("2015")){
				// �񱳸� ó�� �Ҷ� (wcnt == 0) �����ϴ� �κ�
				if(wcnt == 0){
					// �ʵ��� 4��° ���� ^ǥ�ÿ� ������ �����ؼ� �ִ�, �ּҰ��� ������ �������ش�
					sMax = Integer.parseInt(field[3].replace("^", "").trim());
					sMin = Integer.parseInt(field[3].replace("^", "").trim());
				}else{ // �񱳰� ó���� �ƴҶ� ����
					// �ִ밪 �������� �ʵ忡�� ������ ���� �� ũ�� �ٽ� �������ش�
					if (sMax < Integer.parseInt(field[3].replace("^", "").trim())){
						sMax = Integer.parseInt(field[3].replace("^", "").trim());
						MaxDay = field[1].trim().replace("^", "");
					}
					// �ּҰ� �������� �ʵ忡�� ������ ���� �� ������ �ٽ� �������ش�
					if (sMin > Integer.parseInt(field[3].replace("^", "").trim())){
						sMin = Integer.parseInt(field[3].replace("^", "").trim());
						MinDay = field[1].trim().replace("^", "");
					}
				}
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
		// �Ｚ �ְ��� �ִ�, �ּҰ� ���
		System.out.println("�Ｚ�ְ� 15�� �ִ밪 : " + sMax + " ��¥ : " + MaxDay);
		System.out.println("�Ｚ�ְ� 15�� �ּҰ� : " + sMin + " ��¥ : " + MinDay);
		// �ڿ� ��ȯ
		br.close();bw1.close();
		// �����ϰ� ��ü �ݺ� Ƚ��, �񱳴�� ���ԵǾ� �ݺ��� Ƚ���� ������ش�
		System.out.printf("Program End[%d][%d]records\n", cnt, wcnt);
	}

}
