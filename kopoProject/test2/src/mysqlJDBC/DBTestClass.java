package mysqlJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class DBTestClass {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/testDB", "root", "ehdgus24");

			Statement stmt = conn.createStatement();


			ResultSet rset = stmt.executeQuery("select * from examtable where mat>90 and eng>70;");
			while(rset.next()){
				System.out.println(rset.getString(1) + "\t" + rset.getInt(2) + "\t" + 
			rset.getString(3) +"\t"+ rset.getString(4) +"\t" + rset.getString(5) +"\t");
			}
			
			
			
			
			
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
			
	/*		stmt.execute("INSERT INTO examtable(name, studentid, kor, eng, mat) values ('�슚誘�', 209901, 95, 100, 95);");
			stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat)"
					+ " values ('蹂대엺', 209902, 95, 95, 95);");
			stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat)"
					+ " values ('���젙', 209903, 100, 100, 100);");
			stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat)"
					+ " values ('吏��뿰', 209904, 95, 95, 90);");
			stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat)"
					+ " values ('�냼�뿰', 209905, 80, 100, 70);");
			stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat)"
					+ " values ('�걧由�', 209906, 100, 100, 70);");
			stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat)"
					+ " values ('�솕�쁺', 209907, 70, 70, 70);");
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
				// 寃곌낵臾� 泥섎━
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
