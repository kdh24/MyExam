package test2;

import java.awt.image.DataBufferUShort;
import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		boolean check = false; // true 윤년, false 윤년 아님
		String dayOfWeek = "";
		int leapYearCount = 0;
		int dayOfWeekCount = 0;
		int year = 0, month = 0, day = 0;
		int days = 0;
		System.out.println("Year : ");
		year = myScan.nextInt();
		System.out.println("Month : ");
		month = myScan.nextInt();
		System.out.println("Day : ");
		day = myScan.nextInt();
		
		days = (year - 1900) * 365; // 몇년 지났는가?
		//days += ?? // 몇월 지났는가?
		switch(month){
		case 12:
			days += 31;
		case 11:
			days += 30;
		case 10:
			days += 31;
		case 9:
			days += 30;
		case 8:
			days += 31;
		case 7:
			days += 30;
		case 6:
			days += 31;
		case 5:
			days += 30;
		case 4:
			days += 31;
		case 3:
			days += 30;
		case 2:
			days += 28;
		case 1:
			days += 0;
			break;
		}
		
		for(int i=1900; i<year; i++){
			if(year % 4 == 0 && year % 100 == 0 || year % 400 == 0){
				leapYearCount++;
			}
		}
		
		days += day -1 + leapYearCount; // 몇일 지났는가?
		
		dayOfWeekCount = days % 7;
		switch(dayOfWeekCount){
		case 0:
			dayOfWeek = "일";
			break;
		case 1:
			dayOfWeek = "월";
			break;
		case 2:
			dayOfWeek = "화";
			break;
		case 3:
			dayOfWeek = "수";
			break;
		case 4:
			dayOfWeek = "목";
			break;
		case 5:
			dayOfWeek = "금";
			break;
		case 6:
			dayOfWeek = "토";
			break;
		}
		
		
		System.out.println("1900년 1월 1일부터" + days + "일 지났네요");
		System.out.println(year + "-" + month + "-" + day);
		System.out.println(dayOfWeekCount);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		// 앞에 공백 갯수 (요일만큼)
		if (dayOfWeekCount != 0) {
			for (int j = 0; j <= dayOfWeekCount; j++) {
				System.out.print("\t");
			}
		}
		int checkDays = dayOfWeekCount;
		for(int i=1; i<=31; i++){
			System.out.print(i + "\t");
			if(checkDays == 5) {
				System.out.println();
			}
			checkDays = checkDays + 1;
			if(checkDays > 6){
				checkDays = 0;
			}
		}
		
		/*boolean loop=true;
		Scanner sc = new Scanner(System.in);
		
		int year = 0;
		
		while(loop){
			year = sc.nextInt();
			
			if(year % 4 == 0 && year % 100 == 0 || year % 400 == 0){
				System.out.printf("%d 년은 윤년입니다.\n", year);
			}else{
				System.out.printf("%d 년은 윤년이 아닙니다.\n", year);
			}
			
		}*/
	}

}
