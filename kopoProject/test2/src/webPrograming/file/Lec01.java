package webPrograming.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec01 {
	public static void main(String[] args) throws IOException {
		// \�� Ư�������̹Ƿ� \\ �� ���� ����Ѵ�
		File f = new File("c:\\test\\���������������ǥ�ص�����.csv");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;
		
		//������ ���� �о�� �ʵ���� �� �� �ִ�.
		if((readtxt=br.readLine())==null){
			System.out.printf("�� �����Դϴ�\n");
			return;
		}
		String[] field_name = readtxt.split(",");
		
		int LineCnt=0;
		while((readtxt=br.readLine())!=null){
			
			String[] field = readtxt.split(",");
			System.out.printf("**[%d��° �׸�]******************\n", LineCnt);
			for(int j=0; j<field_name.length; j++){
				System.out.printf(" %s : %s\n", field_name[j], field[j]);
			}
			System.out.printf("*******************************\n");
			if(LineCnt==100)break;
			LineCnt++;
		}
		br.close();
	}
}
