package webPrograming.stringBuffer;

public class ArrayMax {
	public static void main(String[] args) {
		int [] iArray={1,7,5,3,2,1,3,4,9,12,1,212,33,11,21,11,2121,121,11,5,6,33};
		
		for(int i=0; i<iArray.length; i++)
			System.out.printf("iArray[%d]=%d\n", i, iArray[i]);
			
			// 
			// MAX 찾기
			//
			
			int iMax=iArray[0];	// 처음시작배열부터시작
			int iMaxPt=0;
			for(int i=0; i<iArray.length; i++){	// 배열갯수만큼 루프반복
				if(iMax<iArray[i]){		// 만일 기존맥스변수보다 배열값이 크다면
					iMax=iArray[i];		// 기존 맥스변수 값은 배열값으로 바꾸고
					iMaxPt=i;			// 기존 맥스변수의 배열위치값도 바꾸고
				}
			}
			System.out.printf("MAX : iArray[%d]=%d\n", iMaxPt, iMax);
	}
}
