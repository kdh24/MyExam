package mysqlJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class DBTestClass2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/testDB", "root", "ehdgus24");

			Statement stmt = conn.createStatement();

			Scanner sc = new Scanner(System.in);
			String newTable = "1"; 
			int columNum = 0;
			int tableCheck = 0;
			String columName = "";
			String columType = "";
			String makeTable = "";
			String insertData = "";
			String[] columArr = new String[columNum];
			int count=0;
			
			checkpoint_1:
			do{
				System.out.println("새로 만들 테이블 명을 입력하세요 (종료 : 1)");
				newTable = sc.nextLine();
				if(newTable.equals("1"))
					break;

				ResultSet rset = stmt.executeQuery("show tables;");

				while (rset.next()) {
					if (rset.getString(1).equals(newTable)) {
						System.out.println("이미 있는 테이블 입니다. 이것을 선택하려면 2를 입력하세요");
						tableCheck = sc.nextInt();
						if(tableCheck == 2){
							newTable = rset.getString(1);
							break;
						}
						continue checkpoint_1;
					}
				}
				if(tableCheck == 2){

					rset = stmt.executeQuery("show tables;");

					while (rset.next()) {
						count++;
					}
					columNum = count;
					columArr = new String[columNum];
					columNum--;
					break;
				}
				
				System.out.println("만들 테이블 컬럼 갯수를 입력하세요 ");
				columNum = sc.nextInt();
				columArr = new String[columNum];
				columNum--;
				
				for(int i=0; i<=columNum; i++){
					System.out.println("컬럼명을 입력하세요");
					columArr[i] = sc.next();
					
					System.out.println("컬럼 자료형을 입력하세요 (ex : varchar(20) not null primary key)");
					columType = sc.next();
					
					if(i==0){
						makeTable = "CREATE table " + newTable + "(" ;
					}

					makeTable += columArr[i] + " " + columType ;
					makeTable += (i == columNum) ? ")" : ",";
					makeTable += (i == columNum) ? "DEFAULT CHARSET = utf8;" : "";

				}
				stmt.execute(makeTable);
				
				System.out.println("테이블을 계속 만드시겠습니까? (종료 : 1)");
				newTable = sc.nextLine();
				
//				stmt.execute("create table from )

			}while(newTable != "1");
			
			insertData = "INSERT INTO " + newTable + "(";
			for(int i=0; i<=columNum; i++){
				insertData += columArr[i];
				System.out.println(columArr[i]);
				insertData += i == columNum ? ")" : ",";
			}
			insertData += "VALUES (";
			System.out.println(newTable + " 테이블에 컬럼순서로 값을 입력해주세요 ex('홍길동' , 2001, 80.. )" );
			insertData += sc.nextLine();
			
			stmt.execute(insertData);

	/*		ResultSet rset = stmt.executeQuery("select * from examtable where mat>90 and eng>70;");
			while(rset.next()){
				System.out.println(rset.getString(1) + "\t" + rset.getInt(2) + "\t" + 
			rset.getString(3) +"\t"+ rset.getString(4) +"\t" + rset.getString(5) +"\t");
			}
	*/		
			
			
			
			
	/*		
			int kor = 0;
			int eng = 0;
			int mat = 0;
			
			for(int i=2000; i<=3000; i++){
				kor = (int)(Math.random() * 100);
				eng = (int)(Math.random() * 100);
				mat = (int)(Math.random() * 100);
				stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat) " +
							"VALUES('Apple" + i + "'," + i + "," + kor +"," + eng + "," + mat +");");
				
			}
	*/		
			
			
			
//			stmt.execute("UPDATE examtable SET average = (eng+kor+mat) / 3;");
			
//			stmt.execute("UPDATE examtable SET total = eng+kor+mat;");
			
//			stmt.execute("ALTER TABLE examtable ADD average int");
			
//			stmt.execute("ALTER TABLE examtable ADD total int");
			
	/*		stmt.execute("INSERT INTO examtable(name, studentid, kor, eng, mat) values ('효민', 209901, 95, 100, 95);");
			stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat)"
					+ " values ('보람', 209902, 95, 95, 95);");
			stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat)"
					+ " values ('은정', 209903, 100, 100, 100);");
			stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat)"
					+ " values ('지연', 209904, 95, 95, 90);");
			stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat)"
					+ " values ('소연', 209905, 80, 100, 70);");
			stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat)"
					+ " values ('큐리', 209906, 100, 100, 70);");
			stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat)"
					+ " values ('화영', 209907, 70, 70, 70);");
	*/		
			
//			stmt.execute("delete from examtable;");
			
			
	/*		stmt.execute( "create table staffinfo(" +
						"name varchar(20)," +
						"studentid int not null primary key," +
						"kor int," +
						"eng int," +
						"mat int)" +
						"DEFAULT CHARSET=utf8;" );
	*/		
	/*		ResultSet rset = stmt.executeQuery("show tables;");
			while (rset.next()) {
				// 결과물 처리
				System.out.println(rset.getString(1));
			}
			rset.close();
	*/		stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
