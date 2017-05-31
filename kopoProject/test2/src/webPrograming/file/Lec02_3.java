package webPrograming.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec02_3 {
	public static void main(String[] args) throws IOException {
		// \은 특수문자이므로 \\ 두 개를 써야한다
		File f = new File("C:\\test\\전국주차장표준데이터.txt");
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
		// 최대 거리 최소거리 변수
		double distMax=0.0;
		double distMin=0.0;
		// 최대,최소값 항목을 저장하기 위한 String 배열
		String[] Max =new String[3];
		String[] Min =new String[3];
		
		// 반복 횟수를 알기위한 int 변수
		int LineCnt=0;
		int wcnt=0;
		// 파일이 비어있지 않으면 가져와서 반복처리
		while((readtxt=br.readLine())!=null){
			// 탭(\t)을 구분자로 버퍼에서 가져온 한줄의 값(readtxt)를 field 배열에 나눠서 저장해준다
			String[] field = readtxt.split("\t");
			// 나눠서 가져온 값 기준으로 보기 원하는 항목만 index 값으로 화면에 출력해준다
			if(field.length > 32){
			System.out.printf("**[%d번째 항목]***********\n", LineCnt);
			System.out.printf(" %s : %s\n", field_name[4], field[4]);//9번 : 지번주소
			System.out.printf(" %s : %s\n", field_name[5], field[5]);//9번 : 지번주소
			System.out.printf(" %s : %s\n", field_name[31], field[31]);//12번 : 위도주소
			System.out.printf(" %s : %s\n", field_name[32], field[32]);//13번 : 경도주소
			}
			// 거리를 구하는 식 
			if (field.length > 31 ) {
				double dist = Math.sqrt(Math.pow(Double.parseDouble(field[31]) - lat, 2)
						+ Math.pow(Double.parseDouble(field[32]) - lng, 2));
				// 거리 구하는 식을 이용해 현재 지점과의 거리를 구해서 화면에 출력해준다
				System.out.printf(" 현재지점과 거리 : %f\n", dist); // 13번 : 경도주소
				
				if (wcnt == 0) { // 처음에 실행된 거리값으로 초기화
					distMax = dist;
					distMin = dist;
					wcnt++;
				} else {// 처음이 아닐때 아래와 같이 값을 비교 연산 처리
						// 새로 구한 거리가 distMax 보다 크면 최대값이므로 distMax 변수에 대입해준다
					if (distMax < dist) {
						distMax = dist;
						// 최대값의 항목들로 Max 배열에 대입해준다
						Max[0] = field[4].trim();
						Max[1] = field[31];
						Max[2] = field[32];
					}
					// 새로 구한 거리가 distMax 보다 작으면 최소값이므로 distMin 변수에 대입해준다
					if (distMin > dist && dist > 0.0001) {
						distMin = dist;
						// 최소값의 항목들로 Min 배열에 대입해준다
						Min[0] = field[4].trim();
						Min[1] = field[31];
						Min[2] = field[32];
					}
					wcnt++;
				}

//				System.out.println(distMin);
			}
			// 한번 실행될때마다 반복횟수 증가
			LineCnt++;
		}

		System.out.printf("*******************************\n", LineCnt);
		// 지정된 위치에서 가장 먼 곳과 가까운 곳에 대한 값들을 화면에 뿌려준다
		System.out.printf("비교횟수 : %s\n", wcnt);
		System.out.printf("제일 먼 주차장 : %s\n",Max[0]);
		System.out.printf("제일 먼 거리 위도  : %s\n",Max[1]);
		System.out.printf("제일 먼 거리 경도  : %s\n",Max[2]);
		System.out.printf("제일 먼 거리 값   : %s\n", distMax);
		System.out.printf("제일 가까운 주차장 : %s\n",Min[0]);
		System.out.printf("제일 가까운 위도  : %s\n",Min[1]);
		System.out.printf("제일 가까운 경도  : %s\n",Min[2]);
		System.out.printf("제일 가까운 거리  : %s\n", distMin);
		// 버퍼 클래스 종료처리
		br.close();
	}
}
