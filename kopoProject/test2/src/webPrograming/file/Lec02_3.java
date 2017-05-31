package webPrograming.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec02_3 {
	public static void main(String[] args) throws IOException {
		// \은 특수문자이므로 \\ 두 개를 써야한다
		File k07_f = new File("C:\\test\\전국주차장표준데이터.txt");
		// 파일을 읽이 위한 버퍼 클래스 생성 및 선언
		BufferedReader k07_br = new BufferedReader(new FileReader(k07_f));
		
		// 버퍼 클래스를 이용해서 한줄씩 가져와 저장할 String 변수
		String k07_readtxt;
		
		//한 줄을 먼저 읽어야 필드명을 알 수 있다.
		// 파일에서 읽어온 값이 없을 경우 빈 파일이라고 알려준다
		if((k07_readtxt=k07_br.readLine())==null){
			System.out.printf("빈 파일입니다.\n");
			return;
		}
		// 빈 파일이 아닐때 처음으로 가져온 값은 항목의 제목부분이므로 field_name 배열에 순차로 저장 
		String[] k07_field_name = k07_readtxt.split("\t");
		
		//융합기술 우리집 위도경도, 지도에서 알아보기
		double k07_lat=37.3860521;
		double k07_lng=127.1214038;
		// 최대 거리 최소거리 변수
		double k07_distMax=0.0;
		double k07_distMin=0.0;
		// 최대,최소값 항목을 저장하기 위한 String 배열
		String[] k07_Max =new String[3];
		String[] k07_Min =new String[3];
		
		// 반복 횟수를 알기위한 int 변수
		int k07_LineCnt=0;
		int k07_wcnt=0;
		
		// 파일이 비어있지 않으면 가져와서 반복처리
		while((k07_readtxt=k07_br.readLine())!=null){
			// 탭(\t)을 구분자로 버퍼에서 가져온 한줄의 값(readtxt)를 field 배열에 나눠서 저장해준다
			String[] k07_field = k07_readtxt.split("\t");
			// 나눠서 가져온 값 기준으로 보기 원하는 항목만 index 값으로 화면에 출력해준다
			if(k07_field.length > 32){
				System.out.printf("**[%d번째 항목]***********\n", k07_LineCnt);
				System.out.printf(" %s : %s\n", k07_field_name[4], k07_field[4]);//9번 : 지번주소
				System.out.printf(" %s : %s\n", k07_field_name[5], k07_field[5]);//9번 : 지번주소
				System.out.printf(" %s : %s\n", k07_field_name[31], k07_field[31]);//12번 : 위도주소
				System.out.printf(" %s : %s\n", k07_field_name[32], k07_field[32]);//13번 : 경도주소
			}
			// 거리를 구하는 식 
			if (k07_field.length > 31 ) {
				double k07_dist = Math.sqrt(Math.pow(Double.parseDouble(k07_field[31]) - k07_lat, 2)
						+ Math.pow(Double.parseDouble(k07_field[32]) - k07_lng, 2));
				// 거리 구하는 식을 이용해 현재 지점과의 거리를 구해서 화면에 출력해준다
				System.out.printf(" 현재지점과 거리 : %f\n", k07_dist); // 13번 : 경도주소
				
				if (k07_wcnt == 0) { // 처음에 실행된 거리값으로 초기화
					k07_distMax = k07_dist;
					k07_distMin = k07_dist;
					k07_wcnt++;
				} else {// 처음이 아닐때 아래와 같이 값을 비교 연산 처리
						// 새로 구한 거리가 distMax 보다 크면 최대값이므로 distMax 변수에 대입해준다
					if (k07_distMax < k07_dist) {
						k07_distMax = k07_dist;
						// 최대값의 항목들로 Max 배열에 대입해준다
						k07_Max[0] = k07_field[4].trim();
						k07_Max[1] = k07_field[31];
						k07_Max[2] = k07_field[32];
					}
					// 새로 구한 거리가 distMax 보다 작으면 최소값이므로 distMin 변수에 대입해준다
					if (k07_distMin > k07_dist && k07_dist > 0.0001) {
						k07_distMin = k07_dist;
						// 최소값의 항목들로 Min 배열에 대입해준다
						k07_Min[0] = k07_field[4].trim();
						k07_Min[1] = k07_field[31];
						k07_Min[2] = k07_field[32];
					}
					k07_wcnt++;
				}

//				System.out.println(distMin);
			}
			// 한번 실행될때마다 반복횟수 증가
			k07_LineCnt++;
		}

		System.out.printf("*******************************\n", k07_LineCnt);
		// 지정된 위치에서 가장 먼 곳과 가까운 곳에 대한 값들을 화면에 뿌려준다
		System.out.printf("비교횟수 : %s\n", k07_wcnt);
		System.out.printf("제일 먼 주차장 : %s\n",k07_Max[0]);
		System.out.printf("제일 먼 거리 위도  : %s\n",k07_Max[1]);
		System.out.printf("제일 먼 거리 경도  : %s\n",k07_Max[2]);
		System.out.printf("제일 먼 거리 값   : %s\n", k07_distMax);
		System.out.printf("제일 가까운 주차장 : %s\n",k07_Min[0]);
		System.out.printf("제일 가까운 위도  : %s\n",k07_Min[1]);
		System.out.printf("제일 가까운 경도  : %s\n",k07_Min[2]);
		System.out.printf("제일 가까운 거리  : %s\n", k07_distMin);
		// 버퍼 클래스 종료처리
		k07_br.close();
	}
}
