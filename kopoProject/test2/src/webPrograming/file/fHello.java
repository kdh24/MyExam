package webPrograming.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fHello {
	public static void main(String[] args) {
		try { // ���� ó���� ���� try - catch ��
			// ���� ����� ���� File Ŭ���� ���ϰ�ο� ���ϸ��� �������ش�.
			File f = new File("c:\\test\\Mytest.txt");
			// File�� �������� FileWriter
			FileWriter fw = new FileWriter(f);

			// "�ȳ� ����" ���ڿ��� ���Ͼȿ� �־��ش�.
			fw.write("�ȳ� ����\n");
			// "hello ���" ���ڿ��� ���Ͼȿ� �־��ش�.			
			fw.write("hello ���\n");

			// ���Ͼ��� ���� �� FileWriter Ŭ������ �������ش�
			fw.close();
			
			// ������ �б����� FileReader Ŭ���� ���� �� ����
			FileReader fr = new FileReader(f);
			
			// �о�� ���� ���� üũ�ϴ� ����
			int n = -1;
			// char�� ���� ����
			char [] ch;
			
			// ���� �ݺ�
			while(true){
				// char�� �迭 ch�� ũ�� 100���� ���� 
				ch = new char[100];
				// ���Ͽ��� �о�� ������ ���� n�� �־��ش�
				n = fr.read(ch);
				
				// �о�� ���� ������ ����������
				if(n==-1)break;
				
				// �о�� ����ŭ �ݺ�
				for(int i=0;i<n; i++){
					// �о�� ���� ������ ȭ�鿡 ���
					System.out.printf("%c",ch[i]);
				}
			}
			// FileReader Ŭ���� ��ȯ
			fr.close();
			
			// ���� ǥ��
			System.out.printf("\n FILE READ END ");
		} catch (IOException e) {
			// ������ �߻������� �������� ���
			System.out.printf("�� ����[%s]\n", e);
		}

	}
}
