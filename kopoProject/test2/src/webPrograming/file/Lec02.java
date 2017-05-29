package webPrograming.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec02 {
	public static void main(String[] args) throws IOException {
		// \�� Ư�������̹Ƿ� \\ �� ���� ����Ѵ�
		File f = new File("c:\\test\\���������������ǥ�ص�����.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;
		
		//�� ���� ���� �о�� �ʵ���� �� �� �ִ�.
		if((readtxt=br.readLine())==null){
			System.out.printf("�� �����Դϴ�.\n");
			return;
		}
		String[] field_name = readtxt.split("\t");
		
		//���ձ�� �츮�� �����浵, �������� �˾ƺ���
		double lat=37.3860521;
		double lng=127.1214038;
		double distMax=0.0;
		String[] Max =new String[3];
		String[] Min =new String[3];
		double distMin=0.0;
		
		
		int LineCnt=0;
		while((readtxt=br.readLine())!=null){
			String[] field = readtxt.split("\t");
			System.out.printf("**[%d��° �׸�]***********\n", LineCnt);
			System.out.printf(" %s : %s\n", field_name[9], field[9]);//9�� : �����ּ�
			System.out.printf(" %s : %s\n", field_name[12], field[12]);//12�� : �����ּ�
			System.out.printf(" %s : %s\n", field_name[13], field[13]);//13�� : �浵�ּ�
			double dist=Math.sqrt( Math.pow(Double.parseDouble(field[12])-lat,2)
			 + Math.pow(Double.parseDouble(field[13])-lng,2));
			System.out.printf(" ���������� �Ÿ� : %f\n", dist); // 13�� : �浵�ּ�
			if(LineCnt == 0){
				distMax = dist;
				distMin = dist;
			}
			if(distMax < dist){
				distMax = dist;
				Max[0] = field[9] == null? "": field[9];
				Max[1] = field[12];
				Max[2] = field[13];
			}
			if(distMin > dist){
				distMin = dist;
				Min[0] = field[9];
				Min[1] = field[12];
				Min[2] = field[13];
			}
			LineCnt++;
		}
		System.out.println(distMax);
		System.out.printf("���� �� �Ÿ�  �ּ� %s\n",Max[0]);
		System.out.printf("���� �� �Ÿ�  ���� %s\n",Max[1]);
		System.out.printf("���� �� �Ÿ�  �浵 %s\n",Max[2]);
		System.out.println(distMin);
		System.out.printf("���� �����  �ּ� %s\n",Min[0]);
		System.out.printf("���� �����  ���� %s\n",Min[1]);
		System.out.printf("���� �����  �浵 %s\n",Min[2]);
		
		br.close();
	}
}
