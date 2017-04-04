package mysqlJDBC;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PublicWifiDataClass {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.1:33060/testDB?useSSL=false", "root", "ehdgus24");
		Statement stmt = conn.createStatement();
		
		String sql = null;
		
	/*	sql = "CREATE TABLE wifiDB(";
		sql += "inst_place varchar(50)," ;
		sql += "inst_place_detail varchar(50)," ;
		sql += "inst_city varchar(50)," ;
		sql += "inst_country varchar(50)," ;
		sql += "inst_place_flag varchar(50)," ;
		sql += "service_provider varchar(50)," ;
		sql += "wifi_ssid varchar(50)," ;
		sql += "inst_date varchar(50)," ;
		sql += "place_addr_road varchar(200)," ;
		sql += "place_addr_land varchar(200)," ;
		sql += "manage_office varchar(50)," ;
		sql += "manage_office_phone varchar(50)," ;
		sql += "latitude double," ;
		sql += "longitude double," ;
		sql += "write_date varchar(50))" ;
		sql += " DEFAULT CHARSET = utf8;" ;
		
		stmt.execute(sql);
	*/	
		stmt.execute("DELETE from wifiDB;");
		
		InputStream in = new FileInputStream("c:\\zzz\\wifiData.txt");
//		DataInputStream din = new DataInputStream(in);
		BufferedInputStream bis = new BufferedInputStream(in);
		BufferedReader br = new BufferedReader(new InputStreamReader(bis, "MS949"));
		
		String readTxt;
		
		if((readTxt = br.readLine()) == null){
			System.out.println("빈 파일입니다");
			return;
		}
		int LineCnt = 0;
		
		while((readTxt = br.readLine()) != null) {
			String[] filed = readTxt.split("\t");
			
			sql = String.format("INSERT INTO wifiDB(inst_place, inst_place_detail, inst_city, "
			 + "inst_country, inst_place_flag, service_provider, wifi_ssid, inst_date, "
			 +"place_addr_road, place_addr_land, manage_office, manage_office_phone, "
			 + "latitude, longitude, write_date) VALUES("
			 + "'%s', '%s', '%s', '%s', '%s',"
			 + "'%s', '%s', '%s', '%s', '%s',"
			 + "'%s', '%s', %s, %s, '%s');",
			 filed[0], filed[1], filed[2], filed[3], filed[4],
			 filed[5], filed[6], filed[7], filed[8], filed[9],
			 filed[10], filed[11], filed[12], filed[13], filed[14]);

			stmt.execute(sql);
			System.out.printf("%d번째 항목 Insert OK [%s]\n",LineCnt, sql);
			LineCnt++;
			//
//			System.out.print(str2[0]+"\t");
//			System.out.print(str2[1]+"\t");
//			System.out.print(str2[2]+"\t");
//			System.out.print(str2[3]+"\t");
//			System.out.print(str2[4]+"\t");
//			System.out.println(str2[5]);
		}
		br.close();
		stmt.close();
		conn.close();
	}
}
