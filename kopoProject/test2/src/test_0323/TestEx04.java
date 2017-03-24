package test_0323;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class TestEx04 {

	public static void main(String[] args) {
		try{
			OutputStream out = new FileOutputStream("C:\\JavaEx\\output.csv");
			DataOutputStream dout = new DataOutputStream(out);
			
			FileOutput test = new FileOutput();
			
			Scanner sc = new Scanner(System.in);
			
			String[] code = new String[10];
			String dataStr= "";
			int check = 1;
			double[] result = new double[10];
			int count = 0;
			int resultCount=0;
			

			System.out.println("[입력]");
			System.out.print("환율 계산을 위한 원화 금액을 입력하세요 :");
			int InputMoney = sc.nextInt(); //Integer.parseInt(sc.nextLine());
			
			do {
				System.out.print("변환할 국가 코드를 입력하세요 :");
				code[count] = sc.next();

				if(count == 0){
					dataStr += "입력," + String.valueOf(InputMoney) + "\n";
					dataStr += "국가,환산\n";
				}
				result[count] = test.exchange(InputMoney, code[count]);
				if(result[count] > 0){
					resultCount++;
				}else{
					System.out.println("없는 코드 입니다. (" + code[count] + ")");
				}

				count++;

				System.out.print("추가 하시겠습니까? (1:Yes, 2:No) :");
				check = sc.nextInt();

			} while (check != 2 && count < 10);
			
			for(int i=0; i<resultCount; i++){
				dataStr += code[i] + "," + String.valueOf(result[i]) + "\n";
				dout.write(dataStr.getBytes("euc-kr"));
				dataStr = "";
			}
			
			System.out.println("파일에 저장되었습니다");
			
			sc.close();
			out.close();
			dout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
