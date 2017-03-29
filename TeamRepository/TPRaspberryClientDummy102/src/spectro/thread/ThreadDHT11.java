package spectro.thread;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import spectro.dto.Config;

public class ThreadDHT11 extends Thread {

    private Config configSensor;

    public ThreadDHT11(Config configSensor) {
        this.setName("ThreadDHT11");
        this.configSensor = configSensor;
    }

    @Override
    public void run() {
        // 스레드가 실행할 작업 내용
        try {
            while (true) {
                if (configSensor.isBoolSwitchDHT11() == true) {
                    int num1 = (int) (Math.random() * 2) + 1;
                    int num2 = (int) (Math.random() * 5) + 1;
                    double[] values = {17.0 + num1, 26.0 + num2};

                    Date dateEventTime = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

                    String strPrintContent = "DHT11\t"
                            + " - Event Time : " + sdf.format(dateEventTime)
                            + "\t" + "Room ID : " + configSensor.getStrRoomRid()
                            + "\t" + "Temperature : " + values[0]
                            + "\t" + "Humidity :" + values[1];
                    //System.out.println(strPrintContent);
                    
                    //////////////////////////////////////////////////////////////////////
                    // HTTP send
                    //////////////////////////////////////////////////////////////////////
                    URL url = null;
                    HttpURLConnection conn = null;
                    //POST 방식
                    try {
                        //Http Connect
                        url = new URL(configSensor.getStrTargetURL() + "/acceptdht11");
                        conn = (HttpURLConnection) url.openConnection();
                        conn.setDoInput(true); 		// 입력스트림 사용여부
                        conn.setDoOutput(true); 		// 출력스트림 사용여부
                        conn.setUseCaches(false); 		// 캐시사용 여부
                        conn.setReadTimeout(20000);		// 타임아웃 설정 ms단위
                        conn.setRequestMethod("POST");	// or GET

                        OutputStream os = conn.getOutputStream();
                        OutputStreamWriter writer = new OutputStreamWriter(os);
                        writer.write("trid=" + configSensor.getStrRoomRid());
                        writer.write("&ttemperature=" + values[0]);
                        writer.write("&thumidity=" + values[1]);
                        writer.close();
                        os.close();
                        
                        //System.out.println("DHT11\t■ Evnet!");
                        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                            //System.out.println("DHT11\t■ Http send Success");
                        } else {
                            System.out.println("DHT11\t■ Http Problem : " + conn.getResponseCode() + "\t" + conn.getResponseMessage());
                        }

                        conn.disconnect();

                    } catch (Exception e) {
                        System.out.println("DHT11\t■ HTTP Error : " + e.getMessage());
                        conn.disconnect();
                    }


                    //////////////////////////////////////////////////////////////////////
                    // Run Deleay
                    //////////////////////////////////////////////////////////////////////
                    Thread.sleep(20000);
                } else {
                    Thread.yield();
                }
            }
        } catch (Exception e) {
            System.out.println("□ Error [" + this.getName() + "]" + e.getMessage());
        }

    }

}
