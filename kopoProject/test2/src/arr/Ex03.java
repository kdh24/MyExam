package arr;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {

		try {
			InputStream in = new FileInputStream("C:\\test\\goods.csv");
			DataInputStream din = new DataInputStream(in);
			String[] goods_name = new String[100];
			int[] goods_price = new int[100];
			int[] goods_count = new int[100];
			int count = 0;
			int loopCheck = 0;
			int InputCheck = 0;

			int[] buyProductNum = new int[100];
			int[] buyProductCount = new int[100];
			// int buyProductNum=0;
			// int buyProductCount=0;
			int buyCount = 0;
			int[] result = new int[100];
			int totalResult = 0;

			while (din.available() > 0) {
				String str;
				String[] str2 = new String[10];
				str = din.readLine();
				str2 = str.split(",");
				if (str != null) {
					// if(count == 0)
					// System.out.println("================== 상품 리스트
					// ==================");
					goods_name[count] = str2[0];
					goods_price[count] = Integer.parseInt(str2[1]);
					goods_count[count] = Integer.parseInt(str2[2]);
					count++;
				}

				// for (int i = 0; i < str2.length; i++) {
				// if (str2[i] != null) {
				// System.out.print(str2[i] + " ");
				// }
				// }
				// System.out.println();

			}

			do {
				buyCount= 0;
				totalResult=0;
				System.out.println("[입력]");
				Scanner sc = new Scanner(System.in);
				do {
					System.out.print("상품번호 : ");
					buyProductNum[buyCount] = sc.nextInt();
					int selectNum = buyProductNum[buyCount] -1;
					
					if (goods_name[selectNum] != null) {
						System.out.printf("%d 번 상품 => %s, %d원\n", buyProductNum[buyCount], goods_name[selectNum], goods_price[selectNum] );
						System.out.print("수량 : ");
						buyProductCount[buyCount] = sc.nextInt();
//						if(goods_count[selectNum] - buyProductCount[buyCount] < 0){
//							System.out.println("수량이 부족합니다. 처음으로 돌아갑니다");
//							continue;
//						}else{
							result[buyCount] += goods_price[selectNum] * buyProductCount[buyCount];
//							goods_count[selectNum] = goods_count[selectNum] - buyProductCount[buyCount];
							totalResult += result[buyCount];
							buyCount++;
//						}
					} else {
						System.out.println("상품이 없습니다. 처음으로 돌아갑니다");
						continue;
					}
					System.out.println("계속 입력하시겠습니까?  (1:Yes 2:No)");
					InputCheck = sc.nextInt();

					// System.out.println("물품가격은 : " + result);
				} while (InputCheck != 2);

				System.out.println("[출력]");
				System.out.println("========= 폴리 마켓 =========");
				System.out.println("상품명\t가격\t수량\t소계");
				for (int i = 0; i < buyCount; i++) {
					System.out.print(goods_name[buyProductNum[i]-1] + "\t");
					System.out.print(goods_price[buyProductNum[i]-1] + "\t");
					System.out.print(buyProductCount[i] + "\t");
					System.out.println(result[i]);
				}
				System.out.println();
				System.out.println("총계 : " + totalResult);
				System.out.println();

				System.out.println("계속 하시겠습니까?  (1:Yes 2:영업종료)");
				loopCheck = sc.nextInt();
				
			} while (loopCheck != 2);

			in.close();
			din.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
