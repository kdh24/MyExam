package webPrograming.stringBuffer;

public class ArrayMax {
	public static void main(String[] args) {
		// int형 값이 순차적으로 저장되어 있는  k07_iArray 배열
		int [] k07_iArray={1,7,5,3,2,1,3,4,9,12,1,212,33,11,21,11,2121,121,11,5,6,33};
		
		// iArray 배열의 길이만큼 반복하는 for 반복문
		for(int i=0; i<k07_iArray.length; i++)
			// iArray 배열의 인덱스와 값을 순차적으로 출력해준다
			System.out.printf("iArray[%d]=%d\n", i, k07_iArray[i]);
			
			// 
			// MAX 찾기
			//
			
			int iMax=k07_iArray[0];	// 처음시작배열부터시작
			int iMaxPt=0;	// Max 값의 인덱스 저장을 위한 변수
			for(int i=0; i<k07_iArray.length; i++){	// 배열갯수만큼 루프반복
				if(iMax<k07_iArray[i]){		// 만일 기존맥스변수보다 배열값이 크다면
					iMax=k07_iArray[i];		// 기존 맥스변수 값은 배열값으로 바꾸고
					iMaxPt=i;			// 기존 맥스변수의 배열위치값도 바꾸고
				}
			}
			// iArray 배열의 최대값과 인덱스값을 출력해서 확인
			System.out.printf("MAX : iArray[%d]=%d\n", iMaxPt, iMax);
	}
}
