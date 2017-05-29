package webPrograming.stringBuffer;

import java.util.ArrayList;

public class AList2 {
	public static void main(String[] args) {
		// 최대값을 정하기 위해 k07_iTestMAX 변수 생성 및 초기화
		int k07_iTestMAX=1000000;
		// 값을 저장하기 위해 어레이 리스트 선언
		ArrayList k07_iAL = new ArrayList();
		
		// 최대값 k07_iTestMAX 만큼 반복해서 랜덤하게 생성된 값을 어레이 리스트 iAL 에 저장해준다
		for(int i=0; i<k07_iTestMAX; i++)
			k07_iAL.add((int)(Math.random()*1000000));
		
		// 어레이 리스트 iAL의 크기만큼 반복해서 화면에 해당 값들을 출력해준다
		for(int i=0; i<k07_iAL.size(); i++)
			System.out.printf(" ArrayList %d = %d\n", i, k07_iAL.get(i));
	
		System.out.printf("*********************************************\n");
		
		// 어레이 리스트의 값을 정렬
		k07_iAL.sort(null);
		
		// 다시 어레이 리스트 iAL의 크기만큼 반복해서 화면에 해당 값들을 출력해준다
		for(int i=0; i<k07_iAL.size(); i++)
			System.out.printf(" ArrayList %d = %d\n", i, k07_iAL.get(i));
	
	
	}
}
