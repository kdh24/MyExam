package mysqlJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBTestClass3 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/testDB", "root", "ehdgus24");

			Statement stmt = conn.createStatement();

			Scanner sc = new Scanner(System.in);
			String inputText="";
			String sql = "";
			int eng = 0;
			int mat = 0;
			String resultData="";
			
			stmt.execute("DELETE from newTable;");
			
			while(true){
				System.out.print("이름 입력(종료는 end) : ");
				inputText = sc.next();
				if (inputText.equals("end"))
					break;

				System.out.print("영어 점수 : ");
				eng = sc.nextInt();
				
				System.out.print("수학 점수 : ");
				mat = sc.nextInt();

				sql = "INSERT INTO newTable(name, eng, mat, total, average) VALUES( ";
				sql += "'" + inputText + "'," + eng + "," + mat + ",";
				sql += eng + mat + "," + (eng + mat) / 2 + ");";
				stmt.execute(sql);
				
				System.out.println();
				System.out.println("[출력 결과]");
				System.out.println("이름\t영어\t수학\t총점\t평균");
				ResultSet rset = stmt.executeQuery("select * from newTable");

				while(rset.next()){
					resultData = rset.getString(1) + "\t";
									resultData += rset.getString(2) + "\t";
									resultData += rset.getString(3) + "\t";
									resultData += rset.getString(4) + "\t";
									resultData += rset.getString(5);

									System.out.println(resultData);
				}
				System.out.println();
				
			}

			
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
			
			
	/*		stmt.execute( "create table newTable(" +
						"name varchar(20)," +
						"studentid int not null primary key," +
						"kor int," +
						"eng int," +
						"mat int," +
						"total int," +
						"average int)" +
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
