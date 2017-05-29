package webPrograming.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec02 {
	public static void main(String[] args) throws IOException {
		// \은 특수문자이므로 \\ 두 개를 써야한다
		File f = new File("c:\\test\\전국무료와이파이표준데이터.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;
		
		//한 줄을 먼저 읽어야 필드명을 알 수 있다.
		if((readtxt=br.readLine())==null){
			System.out.printf("빈 파일입니다.\n");
			return;
		}
		String[] field_name = readtxt.split("\t");
		
		//융합기술 우리집 위도경도, 지도에서 알아보기
		double lat=37.3860521;
		double lng=127.1214038;
		double distMax=0.0;
		String[] Max =new String[3];
		String[] Min =new String[3];
		double distMin=0.0;
		
		
		int LineCnt=0;
		while((readtxt=br.readLine())!=null){
			String[] field = readtxt.split("\t");
			System.out.printf("**[%d번째 항목]***********\n", LineCnt);
			System.out.printf(" %s : %s\n", field_name[9], field[9]);//9번 : 지번주소
			System.out.printf(" %s : %s\n", field_name[12], field[12]);//12번 : 위도주소
			System.out.printf(" %s : %s\n", field_name[13], field[13]);//13번 : 경도주소
			double dist=Math.sqrt( Math.pow(Double.parseDouble(field[12])-lat,2)
			 + Math.pow(Double.parseDouble(field[13])-lng,2));
			System.out.printf(" 현재지점과 거리 : %f\n", dist); // 13번 : 경도주소
			if(LineCnt == 0){
				distMax = dist;
				distMin = dist;
			}
			if(distMax < dist){
				distMax = dist;
				Max[0] = field[9] == null? "": field[9];
				Max[1] = field[12];
				Max[2] = field[13];
			}
			if(distMin > dist){
				distMin = dist;
				Min[0] = field[9];
				Min[1] = field[12];
				Min[2] = field[13];
			}
			LineCnt++;
		}
		System.out.println(distMax);
		System.out.printf("제일 먼 거리  주소 %s\n",Max[0]);
		System.out.printf("제일 먼 거리  위도 %s\n",Max[1]);
		System.out.printf("제일 먼 거리  경도 %s\n",Max[2]);
		System.out.println(distMin);
		System.out.printf("제일 가까운  주소 %s\n",Min[0]);
		System.out.printf("제일 가까운  위도 %s\n",Min[1]);
		System.out.printf("제일 가까운  경도 %s\n",Min[2]);
		
		br.close();
	}
}
