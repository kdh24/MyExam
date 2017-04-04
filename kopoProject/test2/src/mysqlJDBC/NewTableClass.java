package mysqlJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class NewTableClass {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://192.168.56.1:33060/testDB?SSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();
		Scanner sc = new Scanner(System.in);
		
		String name = null;
		int eng = 0, mat = 0; 
		String sql=null;
		int count=0;
		
	/*	String create = null;
		
		create = "CREATE TABLE mysqlEx (";
		create += "studentid int not null primary key,";
		create += "name varchar(20),";
		create += "eng int,";
		create += "mat int,";
		create += "total int,";
		create += "average int)";
		create += "DEFAULT CHARSET = utf8;";
		System.out.println(create);
		stmt.execute(create);
		*/
		
		stmt.execute("delete from newTable;");
		
		while(true){
			
			System.out.print("이름 입력 : ");
			name = sc.nextLine();
			if(name.toLowerCase().equals("end")){
				break;
			}
			System.out.print("영어점수 입력 : ");
			eng = sc.nextInt();
			System.out.print("수학점수 입력 : ");
			mat = sc.nextInt();
			sc.nextLine();
			
			count++;
			
			sql = "INSERT INTO mysqlEx(studentid, name, eng, mat, total, average) VALUES(";
			sql += (2000+count) + "," +"'" + name + "'," + eng  + "," + mat  + "," + (eng+mat) + "," + (eng+mat)/2 + ");";
			
			stmt.execute(sql);
			
			//출력부분
			System.out.println("학번\t이름\t영어\t수학\t총점\t평균");
			
			ResultSet rset = stmt.executeQuery("select * from mysqlEx;");
			
			while(rset.next()){
				//결과물 처리
				System.out.print(rset.getString(1)+"\t");
				System.out.print(rset.getString(2)+"\t");
				System.out.print(rset.getString(3)+"\t");
				System.out.print(rset.getString(4)+"\t");
				System.out.print(rset.getString(5)+"\t");
				System.out.println(rset.getString(6));
			}
			
		}
		stmt.close();
		conn.close();
	}
}
