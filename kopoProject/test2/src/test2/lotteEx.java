package test2;

import java.util.Scanner;

public class lotteEx {/*
	public static void main(String[] args) {
		final int FREE_DAY_OLD = 52000, FREE_DAY_YOUTH = 45000, FREE_DAY_CHILD = 41000, FREE_DAY_BABY = 13000;
		final int FREE_AFTER4_OLD = 41000, FREE_AFTER4_YOUTH = 36000, FREE_AFTER4_CHILD = 32000,
				FREE_AFTER4_BABY = 13000;
		final int ENT_DAY_OLD = 36000, ENT_DAY_YOUTH = 32000, ENT_DAY_CHILD = 29000, ENT_DAY_BABY = 0;
		final int ENT_AFTER4_OLD = 30000, ENT_AFTER4_YOUTH = 27000, ENT_AFTER4_CHILD = 24000, ENT_AFTER4_BABY = 0;
		final int ENT_AFTER7_OLD = 18000, ENT_AFTER7_YOUTH = 16000, ENT_AFTER7_CHILD = 14000, ENT_AFTER7_BABY = 0;
		int ticketType = 0, ticketCategory = 0, age = 0, count = 0, discountType = 0;
		int ageCheck = 0;
		int ticketPrice = 0;
		Scanner sc = new Scanner(System.in);

		// 권종 입력
while(true){
	
MENU1:
		System.out.print("권종을 선택하세요\n");
		System.out.print("1. 자유이용권\n");
		System.out.print("2. 입장권\n");
		System.out.print("----\n");
		ticketType = sc.nextInt();
		if (ticketType == 1) {
			// 티켓 구분
			System.out.print("티켓 구분을 선택하세요\n");
			System.out.print("1. 1일권\n");
			System.out.print("2. After4\n");
			ticketCategory = sc.nextInt();
			if (!(ticketCategory == 1 || ticketCategory == 2)) {
				System.out.print("잘못 입력하셨습니다.\n");
				break MENU1;
			}
		} else if (ticketType == 2) {
			// 티켓 구분
			System.out.print("티켓 구분을 선택하세요\n");
			System.out.print("1. 1일권\n");
			System.out.print("2. After4\n");
			System.out.print("2. After7\n");
			ticketCategory = sc.nextInt();

			if (!(ticketCategory == 1 || ticketCategory == 2 || ticketCategory == 3)) {
				System.out.print("잘못 입력하셨습니다.\n");
				break MENU1;
			}
		} else {
			System.out.print("잘못 입력하셨습니다.\n");
			break MENU1;
		}

		System.out.print("----\n");

		System.out.print("나이를 입력하세요\n");
		System.out.print("----\n");
		age = sc.nextInt();

		System.out.print("몇개를 주문 하시겠습니까?\n");
		System.out.print("----\n");
		count = sc.nextInt();

		System.out.print("우대사항을 선택하세요\n");
		System.out.print("1. 없음\n");
		System.out.print("2. 장애인\n");
		System.out.print("3. 국가유공자\n");
		System.out.print("----\n");
		discountType = sc.nextInt();

		// 기본 가격 계산
		// 자유이용권 or 입장권
		if (ticketType == 1) { // 자유이용권
			if (ticketCategory == 1) { // 1일권
				if (age >= 0 && age <= 3) {
					ticketPrice = FREE_DAY_BABY;
				} else if (age >= 3 && age <= 12) {
					ticketPrice = FREE_DAY_CHILD;
				} else if (age >= 13 && age <= 18) {
					ticketPrice = FREE_DAY_YOUTH;
				} else if (age >= 19) {
					ticketPrice = FREE_DAY_OLD;
				} else if (age >= 65 && discountType == 1) {
					ticketPrice = ENT_AFTER4_CHILD;
				}
			} else { // After 4
				if (age >= 0 && age <= 3) {
					ticketPrice = FREE_AFTER4_BABY;
				} else if (age >= 3 && age <= 12) {
					ticketPrice = FREE_AFTER4_CHILD;
				} else if (age >= 13 && age <= 18) {
					ticketPrice = FREE_AFTER4_YOUTH;
				} else if (age >= 19) {
					ticketPrice = FREE_AFTER4_OLD;
				}
			}
		} else if (ticketType == 2) { // 입장권
			if (ticketCategory == 1) { // 1일권
				if (age >= 0 && age <= 3) {
					ticketPrice = ENT_DAY_BABY;
				} else if (age >= 3 && age <= 12) {
					ticketPrice = ENT_DAY_CHILD;
				} else if (age >= 13 && age <= 18) {
					ticketPrice = ENT_DAY_YOUTH;
				} else if (age >= 19) {
					ticketPrice = ENT_DAY_OLD;
				}
			} else if (ticketCategory == 2) { // After 4
				if (age >= 0 && age <= 3) {
					ticketPrice = ENT_AFTER4_BABY;
				} else if (age >= 3 && age <= 12) {
					ticketPrice = ENT_AFTER4_CHILD;
				} else if (age >= 13 && age <= 18) {
					ticketPrice = ENT_AFTER4_YOUTH;
				} else if (age >= 19) {
					ticketPrice = ENT_AFTER4_OLD;
				}
			} else { // After 7
				if (age >= 0 && age <= 3) {
					ticketPrice = ENT_AFTER7_BABY;
				} else if (age >= 3 && age <= 12) {
					ticketPrice = ENT_AFTER7_CHILD;
				} else if (age >= 13 && age <= 18) {
					ticketPrice = ENT_AFTER7_YOUTH;
				} else if (age >= 19) {
					ticketPrice = ENT_AFTER7_OLD;
				}
			}
		}

		// 갯수
		ticketPrice *= count;

		// 우대사항
		if (discountType == 2) {
			ticketPrice *= 0.7;
		} else if (discountType == 3) {
			ticketPrice *= 0.5;
		}

		System.out.printf("가격은 %d 원입니다.\n", ticketPrice);
		System.out.println("감사합니다");
}
	}*/
}
