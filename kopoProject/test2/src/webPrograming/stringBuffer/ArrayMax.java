package webPrograming.stringBuffer;

public class ArrayMax {
	public static void main(String[] args) {
		int [] iArray={1,7,5,3,2,1,3,4,9,12,1,212,33,11,21,11,2121,121,11,5,6,33};
		
		for(int i=0; i<iArray.length; i++)
			System.out.printf("iArray[%d]=%d\n", i, iArray[i]);
			
			// 
			// MAX ã��
			//
			
			int iMax=iArray[0];	// ó�����۹迭���ͽ���
			int iMaxPt=0;
			for(int i=0; i<iArray.length; i++){	// �迭������ŭ �����ݺ�
				if(iMax<iArray[i]){		// ���� �����ƽ��������� �迭���� ũ�ٸ�
					iMax=iArray[i];		// ���� �ƽ����� ���� �迭������ �ٲٰ�
					iMaxPt=i;			// ���� �ƽ������� �迭��ġ���� �ٲٰ�
				}
			}
			System.out.printf("MAX : iArray[%d]=%d\n", iMaxPt, iMax);
	}
}
