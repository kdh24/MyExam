package webPrograming.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lec03_2 {
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
			// 필드 6번째 값의 길이가 1 이상일 때만 동작하게 한다
			if (field[5].trim().length() > 1) {
				// 각각의 SK로 구분할 조건들을 지정해서 처리해준다
				if (field[5].trim().equals("SKT")
						|| field[5].trim().replace("\"", "").substring(0, 2).toLowerCase().equals("sk")
						|| field[5].trim().toLowerCase().contains("서울특별시청")
								&& field[5].trim().toLowerCase().contains("sk")
						|| field[5].trim().contains("미래창조")
								&& field[5].trim().toLowerCase().contains("skt")
						|| field[5].trim().toLowerCase().contains("㈜sk")) {
					// 6번째 필드의 값이 SKT가 아닐경우 SKT로 변경해서 파일에 써준다.
					if (field[5].trim() != "SKT")
						field[5] = "SKT";
					bw1.write(readtxt);
					bw1.newLine();
				// 각각의 KT로 구분할 조건들을 지정해서 처리해준다
				} else if (field[5].trim().equals("KT")
						|| field[5].trim().replace("\"", "").substring(0, 2).toLowerCase().equals("kt")
						|| (field[5].trim().toLowerCase().contains("서울특별시청")
								&& field[5].trim().toLowerCase().contains("-kt"))
						|| field[5].trim().contains("케이티")
						|| (field[5].trim().toLowerCase().contains("고성군청")
								&& field[5].trim().toLowerCase().contains("kt\""))
						|| field[5].trim().toLowerCase().contains("㈜kt")) {
					// 6번째 필드의 값이 KT가 아닐경우 KT로 변경해서 파일에 써준다.					
					if (field[5].trim() != "KT")
						field[5] = "KT";
					bw2.write(readtxt);
					bw2.newLine();
				// 각각의 LG로 구분할 조건들을 지정해서 처리해준다					
				} else if (field[5].trim().equals("LGU+")
						|| field[5].trim().replace("\"", "").substring(0, 2).toLowerCase().equals("lg")
						|| field[5].trim().replace("\"", "").substring(0, 2).toLowerCase().equals("u+")
						|| field[5].trim().toLowerCase().contains("엘지유")
						|| field[5].trim().toLowerCase().contains("서울특별시청")
								&& field[5].trim().toLowerCase().contains("lg")
						|| field[5].trim().toLowerCase().contains("고성군청")
								&& field[5].trim().toLowerCase().contains("lgu\"")) {
					// 6번째 필드의 값이 LGU+가 아닐경우 LGU+로 변경해서 파일에 써준다.					
					if (field[5].trim() != "LGU+")
						field[5] = "LGU+";
					bw3.write(readtxt);
					bw3.newLine();
				// 위의 조건에 아무것도 해당되지 않을 때 알 수 없는 통신사로 표시해서 화면에 출력해준다
				} else {
					System.out.printf("알 수 없는 통신사[%d번째 항목][%s]***\n", LineCnt, field[5]);
				}
			}
			// 반복횟수 증가
			LineCnt++;
		}
		//자원 반환
		br.close();bw1.close();bw2.close();bw3.close();
	}
}
