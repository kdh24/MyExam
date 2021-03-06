package webPrograming.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec02 {
	public static void main(String[] args) throws IOException {
		// \은 특수문자이므로 \\ 두 개를 써야한다
		File f = new File("c:\\test\\전국무료와이파이표준데이터.txt");
		// 파일을 읽이 위한 버퍼 클래스 생성 및 선언
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		// 버퍼 클래스를 이용해서 한줄씩 가져와 저장할 String 변수
		String readtxt;
		
		//한 줄을 먼저 읽어야 필드명을 알 수 있다.
		// 파일에서 읽어온 값이 없을 경우 빈 파일이라고 알려준다
		if((readtxt=br.readLine())==null){
			System.out.printf("빈 파일입니다.\n");
			return;
		}
		// 빈 파일이 아닐때 처음으로 가져온 값은 항목의 제목부분이므로 field_name 배열에 순차로 저장 
		String[] field_name = readtxt.split("\t");
		
		//융합기술 우리집 위도경도, 지도에서 알아보기
		double lat=37.3860521;
		double lng=127.1214038;
		
		// 반복 횟수를 알기위한 int 변수
		int LineCnt=0;
		// 파일이 비어있지 않으면 가져와서 반복처리
		while((readtxt=br.readLine())!=null){
			// 탭(\t)을 구분자로 버퍼에서 가져온 한줄의 값(readtxt)를 field 배열에 나눠서 저장해준다
			String[] field = readtxt.split("\t");
			// 나눠서 가져온 값 기준으로 보기 원하는 항목만 index 값으로 화면에 출력해준다
			System.out.printf("**[%d번째 항목]***********\n", LineCnt);
			System.out.printf(" %s : %s\n", field_name[9], field[9]);//9번 : 지번주소
			System.out.printf(" %s : %s\n", field_name[12], field[12]);//12번 : 위도주소
			System.out.printf(" %s : %s\n", field_name[13], field[13]);//13번 : 경도주소
			// 거리를 구하는 식 
			double dist=Math.sqrt( Math.pow(Double.parseDouble(field[12])-lat,2)
			 + Math.pow(Double.parseDouble(field[13])-lng,2));
			// 거리 구하는 식을 이용해 현재 지점과의 거리를 구해서 화면에 출력해준다
			System.out.printf(" 현재지점과 거리 : %f\n", dist); // 13번 : 경도주소
			// 한번 실행될때마다 반복횟수 증가
			LineCnt++;
		}
		// 버퍼 클래스 종료처리
		br.close();
	}
}
