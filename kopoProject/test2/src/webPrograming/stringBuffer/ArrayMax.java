package webPrograming.stringBuffer;

public class ArrayMax {
	public static void main(String[] args) {
		// int�� ���� ���������� ����Ǿ� �ִ�  k07_iArray �迭
		int [] k07_iArray={1,7,5,3,2,1,3,4,9,12,1,212,33,11,21,11,2121,121,11,5,6,33};
		
		// iArray �迭�� ���̸�ŭ �ݺ��ϴ� for �ݺ���
		for(int i=0; i<k07_iArray.length; i++)
			// iArray �迭�� �ε����� ���� ���������� ������ش�
			System.out.printf("iArray[%d]=%d\n", i, k07_iArray[i]);
			
			// 
			// MAX ã��
			//
			
			int iMax=k07_iArray[0];	// ó�����۹迭���ͽ���
			int iMaxPt=0;	// Max ���� �ε��� ������ ���� ����
			for(int i=0; i<k07_iArray.length; i++){	// �迭������ŭ �����ݺ�
				if(iMax<k07_iArray[i]){		// ���� �����ƽ��������� �迭���� ũ�ٸ�
					iMax=k07_iArray[i];		// ���� �ƽ����� ���� �迭������ �ٲٰ�
					iMaxPt=i;			// ���� �ƽ������� �迭��ġ���� �ٲٰ�
				}
			}
			// iArray �迭�� �ִ밪�� �ε������� ����ؼ� Ȯ��
			System.out.printf("MAX : iArray[%d]=%d\n", iMaxPt, iMax);
	}
}
