package file;

import java.util.Date;

public class StringApi {
	public static void main(String[] args){
		String s = String.format("%, d", 1000000000);
		System.out.println(s);
		String fo = String.format("I have %.2f bugs to fix.", 44444.444);
		System.out.println(fo);
		String fo1 = String.format("I have %,.2f bugs to fix ", 2231323.23132);
		System.out.println(fo1);
		String fo2 = String.format("%,6.1f", 1323131123.133123213);
		System.out.println(fo2);
		// %tc 날짜와 시간 전부 표시
		String fo3 = String.format("%tc", new Date() );
		System.out.println(fo3);
		// %tr 시간만 표시할때
		String fo4 = String.format("%tr", new Date() );
		System.out.println(fo4);
		// %A %B %C 요일,월,일 표시
		String fo5 = String.format("%tA %tB %tC", new Date(), new Date(), new Date() );
		System.out.println(fo5);
		// 인자 하나로 
		String fo6 = String.format("%tA %<tB %<tC", new Date() );
		System.out.println(fo6);



		/*
		////////////////////////////////////
		String Str = new String("Welcome to Tutorialspoint.com");

	    System.out.print("Return Value :" );
	    System.out.println(Str.startsWith("Welcome") );

	    System.out.print("Return Value :" );
	    System.out.println(Str.startsWith("Tutorials") );
		
		////////////////////////////////////
		String Str = new String("This is really not immutable!!");
	    boolean retVal;

	    retVal = Str.endsWith( "immutable!!" );
	    System.out.println("Returned Value = " + retVal );

	    retVal = Str.endsWith( "immu" );
	    System.out.println("Returned Value = " + retVal );
		
		
		////////////////////////////////////
		String Str1 = new String("This is really not immutable!!");
	    String Str2 = Str1;
	    String Str3 = new String("This is really not immutable!!");
	    String Str4 = new String("This IS REALLY NOT IMMUTABLE!!");
	    boolean retVal;

	    retVal = Str1.equals( Str2 );
	    System.out.println("Returned Value = " + retVal );

	    retVal = Str1.equals( Str3 );
	    System.out.println("Returned Value = " + retVal );

	    retVal = Str1.equalsIgnoreCase( Str4 );
	    System.out.println("Returned Value = " + retVal );
		

		////////////////////////////////////
		String s = "Strings are immutable";
	    char result = s.charAt(8);
	    System.out.println(result);


		////////////////////////////////////
		String Str = new String("   Welcome to Tutorialspoint.com   ");

	    System.out.print("Return Value :" );
	    System.out.println(Str.trim() );
		
		////////////////////////////////////
		String Str = new String("Welcome-to-Tutorialspoint.com");
	    System.out.println("Return Value :" );      
	      
	    for (String retval: Str.split("-")) {
	       System.out.println(retval);
	    }
		////////////////////////////////////
		String Str = new String("Welcome to Tutorialspoint.com");

	    System.out.print("Return Value :" );
	    System.out.println(Str.toUpperCase() );

		////////////////////////////////////
		String Str = new String("Welcome to Tutorialspoint.com");

		System.out.print("Return Value :");
	    System.out.println(Str.toLowerCase());
		

		////////////////////////////////////
		String Str = new String("Welcome to Tutorialspoint.com");
		
		System.out.print("Return Value :" );
		System.out.println(Str.matches("(.*)Tutorials(.*)"));
		
		System.out.print("Return Value :" );
		System.out.println(Str.matches("Tutorials"));
		
		System.out.print("Return Value :" );
		System.out.println(Str.matches("Welcome(.*)"));
		
		

		////////////////////////////////////

		String data="헬로";
		
		String result =data.concat("^^");
		
		System.out.println(result);
		
		String text = "안녕";
		
		if(text.equals("안녕")){
			System.out.println("네 안녕하세요");
		}
		////////////////////////////////////
		String str1 = String.valueOf(100);
		String str2 = String.valueOf(87.5);
		String str3 = String.valueOf(true);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		

		////////////////////////////////////
		
		

		String data = "주민번호 123456-7890123";
		
		String firstData = data.substring(5, 11);
		String lastData = data.substring(12);
		
		System.out.println(firstData);
		System.out.println(lastData);
		

		////////////////////////////////////
		
		String str = "Java 프로그래밍";
		String newStr = str.replace("Java", "자바");
		
		System.out.println(str);
		System.out.println(newStr);
		
		////////////////////////////////////
		
		String data1 = "문자열의 길이는?";
		String data2 = "hello";
		
		int length1 = data1.length();
		int length2 = data2.length();
		
		System.out.println(length1);
		System.out.println(length2);
		
		///////////////////////////////
		
		String data = "문자열 위치 찾기";
		
		int num1 = data.indexOf("위치");
		int num2 = data.indexOf("찾기");
		
		System.out.println(num1);
		System.out.println(num2);*/
	}
}
