package webPrograming.stringBuffer;

import java.util.ArrayList;

public class AList {
	public static void main(String[] args) {
		// iAL ��� ����Ʈ ������ ���� �� ����
		ArrayList k07_iAL = new ArrayList();
		
		// iAL�̶� ArrayList �� �Ʒ��� ���� ���ʴ�� �������ش�
		k07_iAL.add("abc");
		k07_iAL.add("abcd");
		k07_iAL.add("efga");
		k07_iAL.add("������0");
		k07_iAL.add("1234");
		k07_iAL.add("12rk34");
		//iAL.add(356); ��̸���Ʈ�� ��Ʈ������ ������ �ϴµ� 
		// �߰��� ���ڸ� ������ �� �ȴ�
		
		System.out.printf("***********************************\n"); 
		// ��� ����Ʈ�� �� ũ�⸦ Ȯ��
		System.out.printf(" ���� ArraySize %d \n", k07_iAL.size()); 
		// ��� ����Ʈ�� ũ�⸸ŭ �ݺ��ؼ� ���ʴ�� ���� �����ͼ� Ȯ���Ѵ�
		for(int i=0; i<k07_iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, k07_iAL.get(i));
		
		// ��� ����Ʈ 3�� ���� ������ �����Ѵ�
		k07_iAL.set(3, "������"); // 3�� ��̸���Ʈ ���뺯��
		System.out.printf("***********************************\n");
		// ��� ����Ʈ�� �� ũ�⸦ Ȯ��
		System.out.printf(" ���뺯�� ArraySize %d \n", k07_iAL.size());
		// ��� ����Ʈ�� ũ�⸸ŭ �ݺ��ؼ� ���ʴ�� ���� �����ͼ� Ȯ���Ѵ�
		for(int i=0; i<k07_iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, k07_iAL.get(i));
		
		k07_iAL.remove(4); // 4�� ��̸���Ʈ ����
		System.out.printf("***********************************\n");
		// ��� ����Ʈ�� �� ũ�⸦ Ȯ��
		System.out.printf(" ���뺯�� ArraySize %d \n", k07_iAL.size());
		// ��� ����Ʈ�� ũ�⸸ŭ �ݺ��ؼ� ���ʴ�� ���� �����ͼ� Ȯ���Ѵ�
		for(int i=0; i<k07_iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, k07_iAL.get(i));
		
		// ��� ����Ʈ ����
		k07_iAL.sort(null);
		System.out.printf("***********************************\n");
		// ��� ����Ʈ�� �� ũ�⸦ Ȯ��
		System.out.printf(" ����ƮSort ArraySize %d \n", k07_iAL.size());
		// ��� ����Ʈ�� ũ�⸸ŭ �ݺ��ؼ� ���ʴ�� ���� �����ͼ� Ȯ���Ѵ�
		for(int i=0; i<k07_iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, k07_iAL.get(i));
		
		k07_iAL.clear(); // ��̸���Ʈ ����
		System.out.printf("***********************************\n");
		// ��� ����Ʈ�� �� ũ�⸦ Ȯ��
		System.out.printf(" ���� ���� ArraySize %d \n", k07_iAL.size());
		// ��� ����Ʈ�� ���� �����Ǿ����� Ȯ��
		for(int i=0; i<k07_iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, k07_iAL.get(i));
	
	
	
	}
}
