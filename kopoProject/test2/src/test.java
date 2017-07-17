import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		
		int[] a = new int[9];
		
		for(int i=0; i<9; i++){
			System.out.println(a[i]);
			System.out.println("Á¦¸ñ"+String.valueOf(i));
		}
		
		String str = "http://192.168.23.110:8080/L9/resort/adm_loginck.jsp";
		System.out.println(str.length());
		str = str.substring(0, 28);
		System.out.println(str);
		System.out.println(str.lastIndexOf("/"));
		System.out.println(str.substring(0,26) +"/sar.jsp");
		
		
		str = "http://192.168.23.93:8080/koposw13/Ohori_resort/adm_loginck.jsp";

		str = str.substring(0, 28);
		System.out.println(str);
		System.out.println(str.lastIndexOf("/"));
		System.out.println(str.substring(0,25) +"/sar.jsp");
		/*
		String date ="2017-05-08";
		String temp = date.replaceAll("-","");
		System.out.println(temp.length());
		String fixStr = temp.substring(0,4);
		System.out.println(fixStr);
		fixStr+="-";
		fixStr += temp.substring(4,6);
		System.out.println(fixStr);
		fixStr+="-";
		fixStr += temp.substring(6,8);
		System.out.println(fixStr);
		date = fixStr;
		System.out.println(date);
		*/
		ArrayList<String> add = new ArrayList<>();
		add.add("String");
		add.add("tring");
		add.add("ring");
		add.add("ing");
		add.add("ng");

		
		for(int i=0; i<add.size(); i++){
			
			System.out.println(add.get(i));
		}
		
	}

}
