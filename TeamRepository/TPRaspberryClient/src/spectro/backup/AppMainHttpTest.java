package spectro.backup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

//import spectro.dto.SensorDHT11;

public class AppMainHttpTest {
/*	public static void main(String[] args) throws Exception {
        for (int i = 0; i < 50; i++) {
            Thread.sleep(1000);
            double[] values = {10.7, 17.5};
            //System.out.println("Temperature = " +  values[0] + " Humidity = " + values[1]);
            SensorDHT11 dht11 = new SensorDHT11();
            dht11.setTrid(201);
            dht11.setTdate(new Date());
            dht11.setTtemperature(25.5);
            dht11.setThumidity(13.5);
            try {
            	URL url = new URL("http://localhost:8080/myweb/piserver/acceptdht11?"
            					+ "trid=" + dht11.getTrid()
            					+ "&tdate=" + dht11.getTdate()
            					+ "&ttemperature=" + dht11.getTtemperature() 
            					+ "&thumidity=" + dht11.getThumidity()
            					);
                //URL url = new URL("http://localhost:8080/myweb/piserver/acceptdht11?trid=" + 201 + "&ttemperature=" + values[0] + "&thumidity=" + values[1]);
            	//URL url = new URL("http://localhost:8080/myweb/piserver/acceptdht11?dht11=" + dht11);
            	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();
                if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    System.out.println("send success");
                }
                conn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}*/
	
	
/*post방식*/
/*	
	public static void main(String[] args) throws Exception {
        for (int i = 0; i < 50; i++) {
            Thread.sleep(1000);
            
            
            //테스트 객체
	        SensorDHT11 dht11 = new SensorDHT11();
	        dht11.setTrid(201);
	        dht11.setTdate(new Date());
	        dht11.setTtemperature(25.5);
	        dht11.setThumidity(13.5);
			
	        String str = null; //If there are any Korean letters in HTML, then encode them
			try { 
				str = URLEncoder.encode("한글","UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			
			URL url = null;
			try {
				url = new URL("http://localhost:8080/myweb/piserver/acceptdht11");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true); 			// 입력스트림 사용여부
			conn.setDoOutput(true); 		// 출력스트림 사용여부
			conn.setUseCaches(false); 		// 캐시사용 여부
			conn.setReadTimeout(20000);		// 타임아웃 설정 ms단위
			conn.setRequestMethod("POST");	// or GET
			
			OutputStream os = conn.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(os);
			//writer.write("title = " + str);
			//writer.write("&subTitle = " + str + " 2");
			writer.write("trid=" + 201);
			writer.write("&tdate=" + dht11.getTdate());
			writer.write("&ttemperature=" + dht11.getTtemperature());
			writer.write("&thumidity=" + dht11.getThumidity());
			writer.close(); 
			os.close();

			StringBuffer sb = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while(true){
				String line = br.readLine();
				if (line == null)
					break;
				sb.append(line + "\n"); //set new lines to look better !
			}
			br.close();
			conn.disconnect();
        }
	}

*/
}
