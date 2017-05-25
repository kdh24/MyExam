package webPrograming.ex;

public class HanBlackPrint {
	

	public static String HanBlackForeword(String Han, int num){
		
		String HanBlack="";
		int max= num -Han.getBytes().length;
		
//		for(int i=0; i<Han.length(); i++){
//			Han.substring(i, i+1).getBytes();
//		}
		
		for(int i=0; i<max; i++){
			HanBlack += " ";
		}
		HanBlack += Han;
		
		return HanBlack;
	}
	public static String HanBlackBackword(String Han, int num){
		
		String HanBlack="";
		int max= num -Han.getBytes().length;
		
		HanBlack += Han;
		System.out.println(max);

		for(int i=0; i<max; i++){
			HanBlack += " ";
		}
		return HanBlack;
	}

	public static int HanCount(String Han) {

		int count=0;
		
		for(int i=0; i<Han.length(); i++){
			if(Han.substring(i, i+1).getBytes().length >1){
				count += 1;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		System.out.printf("HanBlackForeword[%s]\n", HanBlackForeword("�ѱ�abcd", 15));
		System.out.printf("HanBlackForeword[%s]\n", HanBlackForeword("�ѱ��ѱ�aa", 15));
		System.out.printf("HanBlackForeword[%s]\n", HanBlackBackword("�ѱ�aa", 15));
		System.out.printf("HanBlackForeword[%s]\n", HanBlackBackword("�ѱ��ѱ�aa", 15));
		System.out.printf("�ѱ��� [%d]��\n", HanCount("�ѱ��ѱ�aa"));
	}
}
