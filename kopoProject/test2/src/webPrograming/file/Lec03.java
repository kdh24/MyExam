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
		File f = new File("c:\\test\\전국무료와이파이표준데이터.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));

		File f1 = new File("c:\\test\\전국무료와이파이표준데이터_SKT.txt");
		File f2 = new File("c:\\test\\전국무료와이파이표준데이터_KT.txt");
		File f3 = new File("c:\\test\\전국무료와이파이표준데이터_LGU.txt");
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2));
		BufferedWriter bw3 = new BufferedWriter(new FileWriter(f3));

		String readtxt;
		// 한 줄을 먼저 읽어야 필드명을 알 수 있다.
		if ((readtxt = br.readLine()) == null) {
			System.out.printf("빈 파일입니다.\n");
			return;
		}

		// 첫 줄은 모든 파일에 다 쓴다.
		bw1.write(readtxt);
		bw1.newLine();
		bw2.write(readtxt);
		bw2.newLine();
		bw3.write(readtxt);
		bw3.newLine();

		int LineCnt = 0;
		while ((readtxt = br.readLine()) != null) {
			String[] field = readtxt.split("\t");

			if (field[5].trim().equals("SKT") || field[5].trim().toLowerCase().equals("sk텔레콤")
					|| field[5].trim().equals("SK") || field[5].trim().equals("SK, KT, LG U+")) {
				if (field[5].trim() != "SKT")
					field[5] = "SKT";
				bw1.write(readtxt);
				bw1.newLine();
			} else if (field[5].trim().equals("KT")) {
				bw2.write(readtxt);
				bw2.newLine();
			} else if (field[5].trim().equals("LGU+") || field[5].trim().equals("LGT")
					|| field[5].trim().equals("LU G+")) {
				if (field[5].trim() != "LGU+") {
					field[5] = "LGU+";
				}
				bw3.write(readtxt);
				bw3.newLine();
			} else if (field[5].trim().equals("LG U+")) {
				// 해당 필드 LU G+ -> LGU+로 고쳐서 파일에 쓰시오
				// 그리고 SK텔레콤, LGT등도 마찬가지...
			} else {
				System.out.printf("알 수 없는 통신사[%d번째 항목][%s]***\n", LineCnt, field[5]);
			}
			LineCnt++;
		}
		br.close();
		bw1.close();
		bw2.close();
		bw3.close();
	}
}
