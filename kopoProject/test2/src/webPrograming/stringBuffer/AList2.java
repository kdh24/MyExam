package webPrograming.stringBuffer;

import java.util.ArrayList;

public class AList2 {
	public static void main(String[] args) {
		// �ִ밪�� ���ϱ� ���� k07_iTestMAX ���� ���� �� �ʱ�ȭ
		int k07_iTestMAX=1000000;
		// ���� �����ϱ� ���� ��� ����Ʈ ����
		ArrayList k07_iAL = new ArrayList();
		
		// �ִ밪 k07_iTestMAX ��ŭ �ݺ��ؼ� �����ϰ� ������ ���� ��� ����Ʈ iAL �� �������ش�
		for(int i=0; i<k07_iTestMAX; i++)
			k07_iAL.add((int)(Math.random()*1000000));
		
		// ��� ����Ʈ iAL�� ũ�⸸ŭ �ݺ��ؼ� ȭ�鿡 �ش� ������ ������ش�
		for(int i=0; i<k07_iAL.size(); i++)
			System.out.printf(" ArrayList %d = %d\n", i, k07_iAL.get(i));
	
		System.out.printf("*********************************************\n");
		
		// ��� ����Ʈ�� ���� ����
		k07_iAL.sort(null);
		
		// �ٽ� ��� ����Ʈ iAL�� ũ�⸸ŭ �ݺ��ؼ� ȭ�鿡 �ش� ������ ������ش�
		for(int i=0; i<k07_iAL.size(); i++)
			System.out.printf(" ArrayList %d = %d\n", i, k07_iAL.get(i));
	
	
	}
}
