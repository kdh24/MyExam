package webPrograming.stringBuffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class File {
	public static void main(String[] args) throws Exception {
		// ���Ͽ� �����ϱ� ���� FileWriter Ŭ���� ���� �� ����
		FileWriter k07_fw = new FileWriter("c:\\test\\a.txt", true); 
		// �����ϰ��� �ϴ� �����̸�(�ʿ��� ��ε� ���)�� �ߺ��� ����� ����
		
		// StringBuffer�� ����ϱ� ���ؼ� ������ ������ ���� �� �������ش�
		BufferedWriter k07_bw = new BufferedWriter(k07_fw);
		StringBuffer k07_sf = new StringBuffer();
		
		//����ڰ� �Է��ϴ� ���� ���Ͽ� �������� BufferedReader Ŭ���� ���
		BufferedReader k07_br = new BufferedReader(new InputStreamReader(System.in));
		// �Է¹��� ���ڿ��� �����ϱ� ���� str ����
		String k07_str = "";
		// ����ڰ� �Է��� ���ڿ��� str ������ �����ϰ�  �ش� ���� �ҹ��� s�� �ƴϸ� �ݺ������� �Է¹޾�
		// StringBuffer�� �߰����ش�
		while(!(k07_str=k07_br.readLine()).startsWith("s"))
			k07_sf.append(k07_str+"\n");	// ��Ʈ�����ۿ� ���پ� �о� ����Ѵ�.
		
		k07_br.close();		// �ڿ�����
		// ���ڿ��� �Է¹޾� StringBuffer�� �������־��� ������ ���Ͽ� �־��ش�
		k07_fw.write(k07_sf.toString());	// ��Ʈ�����۸� ��Ʈ�������� ��ȯ�Ͽ� ����Ѵ�.
		k07_fw.flush();
		k07_fw.close();		// �ڿ��� �����Ѵ�.
		// ���� �Ϸ� ǥ��
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
	}
}
