package webPrograming.stringBuffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class File {
	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("c:\\test\\a.txt", true); 
		// �����ϰ��� �ϴ� �����̸�(�ʿ��� ��ε� ���)�� �ߺ��� ����� ����
		
		BufferedWriter bw = new BufferedWriter(fw);
		StringBuffer sf = new StringBuffer();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while(!(str=br.readLine()).startsWith("s"))
			sf.append(str+"\n");	// ��Ʈ�����ۿ� ���پ� �о� ����Ѵ�.
		
		br.close();		// �ڿ�����
		fw.write(sf.toString());	// ��Ʈ�����۸� ��Ʈ�������� ��ȯ�Ͽ� ����Ѵ�.
		fw.flush();
		fw.close();		// �ڿ��� �����Ѵ�.
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		
		
		
	}
}
