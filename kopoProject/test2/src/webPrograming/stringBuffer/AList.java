package webPrograming.stringBuffer;

import java.util.ArrayList;

public class AList {
	public static void main(String[] args) {
		// iAL 어레이 리스트 변수를 생성 및 선언
		ArrayList k07_iAL = new ArrayList();
		
		// iAL이란 ArrayList 에 아래의 값을 차례대로 저장해준다
		k07_iAL.add("abc");
		k07_iAL.add("abcd");
		k07_iAL.add("efga");
		k07_iAL.add("가나다0");
		k07_iAL.add("1234");
		k07_iAL.add("12rk34");
		//iAL.add(356); 어레이리스트를 스트링으로 쓰려고 하는데 
		// 중간에 숫자를 넣으면 안 된다
		
		System.out.printf("***********************************\n"); 
		// 어레이 리스트의 총 크기를 확인
		System.out.printf(" 시작 ArraySize %d \n", k07_iAL.size()); 
		// 어레이 리스트의 크기만큼 반복해서 차례대로 값을 가져와서 확인한다
		for(int i=0; i<k07_iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, k07_iAL.get(i));
		
		// 어레이 리스트 3번 값의 내용을 변경한다
		k07_iAL.set(3, "가라라라"); // 3번 어레이리스트 내용변경
		System.out.printf("***********************************\n");
		// 어레이 리스트의 총 크기를 확인
		System.out.printf(" 내용변경 ArraySize %d \n", k07_iAL.size());
		// 어레이 리스트의 크기만큼 반복해서 차례대로 값을 가져와서 확인한다
		for(int i=0; i<k07_iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, k07_iAL.get(i));
		
		k07_iAL.remove(4); // 4번 어레이리스트 삭제
		System.out.printf("***********************************\n");
		// 어레이 리스트의 총 크기를 확인
		System.out.printf(" 내용변경 ArraySize %d \n", k07_iAL.size());
		// 어레이 리스트의 크기만큼 반복해서 차례대로 값을 가져와서 확인한다
		for(int i=0; i<k07_iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, k07_iAL.get(i));
		
		// 어레이 리스트 정렬
		k07_iAL.sort(null);
		System.out.printf("***********************************\n");
		// 어레이 리스트의 총 크기를 확인
		System.out.printf(" 리스트Sort ArraySize %d \n", k07_iAL.size());
		// 어레이 리스트의 크기만큼 반복해서 차례대로 값을 가져와서 확인한다
		for(int i=0; i<k07_iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, k07_iAL.get(i));
		
		k07_iAL.clear(); // 어레이리스트 삭제
		System.out.printf("***********************************\n");
		// 어레이 리스트의 총 크기를 확인
		System.out.printf(" 전부 삭제 ArraySize %d \n", k07_iAL.size());
		// 어레이 리스트가 전부 삭제되었는지 확인
		for(int i=0; i<k07_iAL.size(); i++)
			System.out.printf(" ArrayList %d = %s\n", i, k07_iAL.get(i));
	
	
	
	}
}
