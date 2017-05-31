package webPrograming.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lec03 {
	public static void main(String[] args) throws IOException {
		// \은 특수문자이므로 \\ 두 개를 써야 한다.
		// 가져와서 처리할 파일을 파일클래스 객체를 이용해 가져온다
		File f = new File("C:\\test\\전국무료와이파이표준데이터.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		// 데이터 처리 후 저장할 파일을 파일클래스 객체를 이용해서 만들어준다
		File f1 = new File("C:\\test\\전국무료와이파이표준데이터_SKT.txt");
		File f2 = new File("C:\\test\\전국무료와이파이표준데이터_KT.txt");
		File f3 = new File("C:\\test\\전국무료와이파이표준데이터_LGU.txt");
		// BufferedWriter를 이용해서 각각의 파일에 쓰기위한 처리  
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2));
		BufferedWriter bw3 = new BufferedWriter(new FileWriter(f3));
		// 한 줄씩 받아와 처리하기 위한 String 변수
		String readtxt;
		// 한 줄을 먼저 읽어야 필드명을 알 수 있다.
		if ((readtxt = br.readLine()) == null) {
			System.out.printf("빈 파일입니다.\n");
			return;
		}
		// 첫 줄은 모든 파일에 다 쓴다.
		bw1.write(readtxt);bw1.newLine();
		bw2.write(readtxt);bw2.newLine();
		bw3.write(readtxt);bw3.newLine();
		// 몇 번째 작업을 처리하는지 확인하기 위한 int형 변수
		int LineCnt = 0;
		// 한줄씩 가져와서 readtxt 변수에 넣고 null이 아니면 처리 한다.
		while ((readtxt = br.readLine()) != null) {
			// 탭을 구분자로 field 배열에 나누어서 값을 가져온다
			String[] field = readtxt.split("\t");

			// field 6번째에 해당하는 값이 SKT 문자열이면 sk 파일에 저장시켜준다
			if (field[5].trim().equals("SKT") || field[5].toLowerCase().trim().equals("sk텔레콤")){
				field[5] = "SKT";
				bw1.write(readtxt);bw1.newLine();
			// field 6번째에 해당하는 값이 SKT 문자열이 아니고 KT 문자열이면 파일에 저장시켜준다
			} else if (field[5].trim().equals("KT")) {
				bw2.write(readtxt);bw2.newLine();
				// field 6번째에 해당하는 값이 SKT, KT 문자열이 아니고 LGU+ 문자열이면 파일에 저장시켜준다				
			} else if (field[5].trim().equals("LGU+")) {
				bw3.write(readtxt);bw3.newLine();
				// field 6번째에 해당하는 값이 SKT, KT,LGU+ 문자열이 아니고 LG U+ 문자열이면 파일에 저장시켜준다								
			} else if (field[5].trim().equals("LG U+") || field[5].trim().equals("LGT")) {
				// 해당 필드 LU G+ -> LGU+로 고쳐서 파일에 쓰시오
				// 그리고 SK텔레콤, LGT등도 마찬가지...
				field[5] = "LGU+";
				bw3.write(readtxt);bw3.newLine();
			} else { // 위에 해당하는 조건이 하나도 없을 때 알 수 없는 통신사로 표기해서 몇번째 작업인지와 필드값을 화면에 보여준다
				System.out.printf("알 수 없는 통신사[%d번째 항목][%s]***\n", LineCnt, field[5]);
			}
			// 반복횟수 증가
			LineCnt++;
		}
		// 자원 반환
		br.close();
		bw1.close();
		bw2.close();
		bw3.close();
	}
}
