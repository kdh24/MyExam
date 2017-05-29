package webPrograming.ex;

public class HanBlackPrint {
	// ���� ������ ���� �ѱ� �տ� �������� ä���ִ� �޼ҵ�
	// �ѱ۰��� ��ü ���̸� �Ű������� �Ѱܹ޾� ó���Ѵ�
	public static String HanBlackForeword(String Han, int num){
		// �ѱ� ���麯��
		String k07_HanBlack="";
		// �ѱ۸Ű������� ���� ����Ʈ ���̸� ��ü ���̿��� ���� �װ��� �ִ밪���� ���ϴ� ���� 
		int max= num -Han.getBytes().length;
		// 0���� max ������ ������ �ݺ��ϴ� �ݺ���
		for(int i=0; i<max; i++){
			// max�� ũ�⸸ŭ k07_HanBlack ������ ������ �����ش�
			k07_HanBlack += " ";
		}
		// ������ ����ִ� k07_HanBlack ������ �Ѱܹ��� �ѱ۰��� �����ش�
		k07_HanBlack += Han;
		// �ѱ۰���ó���� �Ϸ��� String ���� �����ش�.
		return k07_HanBlack;
	}
	// ���� ������ ���� �ѱ� �ڿ� �������� ä���ִ� �޼ҵ�
	// �ѱ۰��� ��ü ���̸� �Ű������� �Ѱܹ޾� ó���Ѵ�
	public static String HanBlackBackword(String k07_Han, int k07_num){
		// �ѱ� ���麯��
		String k07_HanBlack="";
		// �ѱ۸Ű������� ���� ����Ʈ ���̸� ��ü ���̿��� ���� �װ��� �ִ밪���� ���ϴ� ����		
		int max= k07_num -k07_Han.getBytes().length;
		
		
		if(k07_Han.getBytes().length > k07_num ){
			if(k07_Han.getBytes().length % 2 == 1)
				k07_HanBlack = new String(k07_Han.getBytes(), 0, 23) + " ";
			else 
				k07_HanBlack = new String(k07_Han.getBytes(), 0, 24);
		}else
		{
//			k07_HanBlack = new String(k07_Han.getBytes(), 0, 20);
			
			// �ѱ� ����ó�������� �̸� �Ѱܹ��� �ѱ۰��� �־��ش�
			k07_HanBlack += k07_Han;
			// max ������ ����ŭ ������ �߰��� �����ش�
			for (int i = 0; i < max; i++) {
				k07_HanBlack += " ";
			}
		}
		// �ѱ۰� ������ ���� k07_HanBlack ������ ���ϰ����� �����ش�.
		return k07_HanBlack;
	}
	// String ������ �ѱ۷� �� ���� ��� �ִ��� ���ؼ� �˷��ִ� Ŭ����
	// k07_Han ������ �ִ� �ѱ��� ������ ���ؼ� �Ѱ��ش�. 
	public static int HanCount(String k07_Han) {
		// �ѱ��� ������ ���ؼ� ���ϰ����� �Ѱ��� k07_count ������ ���� �� 0���� �ʱ�ȭ
		int k07_count=0;
		// �Ű������� ���� Han ������ ���̸�ŭ �ݺ��ؼ� ó���ϴ� �ݺ���
		for(int i=0; i<k07_Han.length(); i++){
			// Han ������ ���� �տ������� �Ѱ��� �����ͼ� byte ���̰� 1�� ������ �ѱ��̹Ƿ� count ������ �����ش� 
			if(k07_Han.substring(i, i+1).getBytes().length >1){
				k07_count += 1;
			}
		}
		// ���ϰ����� ������ �ѱ��� ������ �Ѱ��ش�
		return k07_count;
	}

	public static void main(String[] args) {
		// ���̿� �°� �տ� ������ �߰����� HanBlackForeword �Լ� ȣ���ؼ� ��� ���
		System.out.printf("HanBlackForeword[%s]\n", HanBlackForeword("�ѱ�abcd", 15));
		// ���̿� �°� �տ� ������ �߰����� HanBlackForeword �Լ� ȣ���ؼ� ��� ���
		System.out.printf("HanBlackForeword[%s]\n", HanBlackForeword("�ѱ��ѱ�aa", 15));
		// ���̿� �°� �ڿ� ������ �߰����� HanBlackBackword �Լ� ȣ���ؼ� ��� ���		
		System.out.printf("HanBlackBackword[%s]\n", HanBlackBackword("�ѱ�aa", 15));
		// ���̿� �°� �ڿ� ������ �߰����� HanBlackBackword �Լ� ȣ���ؼ� ��� ���		
		System.out.printf("HanBlackBackword[%s]\n", HanBlackBackword("�ѱ��ѱ�aa", 15));
		// ������ �ѱ��� ��� �ִ��� Ȯ���ؼ� ������ �˷��ִ� HanCount �Լ� ȣ���ؼ� ��� ���
		System.out.printf("�ѱ��� [%d]��\n", HanCount("�ѱ��ѱ�aa"));
	}
}
