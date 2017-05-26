package webPrograming.stringBuffer;

import java.util.ArrayList;

import oracle.net.aso.e;

public class AList {
	public static void main(String[] args) {
		ArrayList iAL = new ArrayList();
		
		iAL.add("abc");
		iAL.add("abcd");
		iAL.add("efga");
		iAL.add("가나다0");
		iAL.add("1234");
		iAL.add("12rk34");
		//iAL.add(356); 어레이리스트를 스트링으로 쓰려고 하는데 
		// 중간에 숫자를 넣으면 안 된다
		
		System.out.printf("***********************************\n"); 
		System.out.printf(" 시작 ArraySize %d \n", iAL.size()); 
		for(int i=0; i<iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, iAL.get(i));
		
		iAL.set(3, "가라라라"); // 3번 어레이리스트 내용변경
		System.out.printf("***********************************\n");
		System.out.printf(" 내용변경 ArraySize %d \n", iAL.size());
		for(int i=0; i<iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, iAL.get(i));
		
		iAL.remove(4); // 4번 어레이리스트 삭제
		System.out.printf("***********************************\n");
		System.out.printf(" 내용변경 ArraySize %d \n", iAL.size());
		for(int i=0; i<iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, iAL.get(i));
		
		iAL.sort(null);
		System.out.printf("***********************************\n");
		System.out.printf(" 리스트Sort ArraySize %d \n", iAL.size());
		for(int i=0; i<iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, iAL.get(i));
		
		iAL.clear(); // 어레이리스트 삭제
		System.out.printf("***********************************\n");
		System.out.printf(" 전부 삭제 ArraySize %d \n", iAL.size());
		for(int i=0; i<iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, iAL.get(i));
	
	
	
	}
}
