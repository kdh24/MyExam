package webPrograming.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferReader {
	public static void FileWrite() throws IOException { // ���� ó���� ���� throws �ڹٿ��� ����ó�� �κ��� �Ѱ��ش�
		// ���� ����� ���� File Ŭ���� ���ϰ�ο� ���ϸ��� �������ش�.
		File f = new File("c:\\test\\BMytest.txt");
		// BufferedWriter ȿ������ ���ڿ� ������ ���� BufferedWriter ��� ���� �� ����
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		// ���۸� �̿��� ���ڿ� ����
		bw.write("�ȳ� ����");
		// ���ۿ� �ٹٲ� ó��
		bw.newLine();
		// ���۸� �̿��� ���ڿ� ����		
		bw.write("hello ���");
		// ���ۿ� �ٹٲ� ó��		
		bw.newLine();
		
		// ���� Ŭ������ �������ش�
		bw.close();
		
	}
	public static void FileRead() throws IOException { // ���� �б� ���� �޼ҵ�  ����ó���� ���� throws
		// ���� ����� ���� File Ŭ���� ���ϰ�ο� ���ϸ��� �������ش�.		
		File f =new File("c:\\test\\BMytest.txt");
		// BufferedReader ȿ�������� ���ڿ��� �о���� ���� BufferedReader ��� ���� �� ����
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		// ���ڿ� readtxt ���� ����
		String readtxt;
		
		// BufferedReader�� ���پ� �����ͼ� readtxt ������ �־��ְ� null ������ ���ؼ� �ƴϸ� �ݺ�
		while((readtxt=br.readLine())!=null){
			// ������ ���ڿ��� ������ ȭ�鿡 ������ش�
			System.out.printf("%s\n", readtxt);
		}
		// ���� Ŭ������ �������ش�
		br.close();
	}
	
	public static void main(String[] args) throws IOException {
		FileWrite();	// ������ ���� ���� �޼ҵ� ȣ��
		FileRead();		// ������ �б� ���� �޼ҵ� ȣ��
	}
}
