package spectro.thread;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.Gpio;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import spectro.dto.Config;
import spectro.sensor.DHT11Sensor;
import spectro.sensor.FlameSensor;
import spectro.sensor.GasSensor;
import spectro.sensor.UltrasonicSensor;

public class ThreadMul extends Thread {

    private Config configSensor;
    
    //온도 습도 관련
    private DHT11Sensor dht;
    
    //거리감지 관련
    public final static boolean boolDOOR_CLOSED = false;
    public final static boolean boolDOOR_OPENED = true;
    private boolean boolDoorState;
    
    //화재 가스 관련
    public final static boolean boolFLAME_ADNORMAL = true; //화재 문제발생
    public final static boolean boolFLAME_NORMAL = false; //화재 정상상태
    public final static boolean boolGAS_ADNORMAL = true; //가스 문제발생
    public final static boolean boolGAS_NORMAL = false; //가스 정상상태
    private FlameSensor sensorFlame;
    private GasSensor sensorGas;
    private boolean boolFlameState;
    private boolean boolGasState;
    
    //거리감지 관련
    GpioController gpio;
    //트래거 : 나가는 신호
    GpioPinDigitalOutput trigPin;
    //에코 : 들어오는 신호
    GpioPinDigitalInput echoPin;

    public ThreadMul(Config configSensor) {
        this.setName("ThreadAll");
        this.configSensor = configSensor;
        
        //온도 습도 관련
        this.dht = DHT11Sensor.getInstance();
        
         //거리감지 관련
        this.boolDoorState = ThreadUltrasonic.boolDOOR_CLOSED;
        
        //화재 가스 관련
        this.sensorFlame = FlameSensor.getInstance();
        this.sensorGas = GasSensor.getInstance();
        this.boolFlameState = ThreadGasAndFlame.boolFLAME_NORMAL;
        this.boolGasState = ThreadGasAndFlame.boolGAS_NORMAL;
        
        //거리감지 관련
        gpio = GpioFactory.getInstance();
        trigPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.LOW); //RaspiPin.GPIO_00는 PuTTY에서 gpio readall로 조회해서 나오는 정보를 기반으로 핀꼽은곳 상수값 가져다 쓰는것 
        echoPin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_05); //RaspiPin.GPIO_01는 위와 동일
    }
 
    
    @Override
    public void run() {
        // 스레드가 실행할 작업 내용
        try {
            while (true) {
                this.runDHT11();
                Thread.sleep(1000);
                
                
                this.runGas();
                Thread.sleep(1000);
                
                this.runFlame();
                Thread.sleep(1000);
                
                this.runUltrasonic();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("□ Error [" + this.getName() + "]" + e.getMessage());
        }

    }
    
    
    
    public void runDHT11() {
        // 스레드가 실행할 작업 내용
        try {
            if (configSensor.isBoolSwitchDHT11() == true) {
                //int num = (int) (Math.random() * 5) + 1;
                //double[] values = {20.5 + num, 10.3 + num};
                double[] values = dht.getTemperature();
                Date dateEventTime = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

                String strPrintContent = "DHT11\t"
                        + " - Event Time : " + sdf.format(dateEventTime)
                        + "\t" + "Room ID : " + configSensor.getStrRoomRid()
                        + "\t" + "Temperature : " + values[0]
                        + "\t" + "Humidity :" + values[1];
                System.out.println(strPrintContent);

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

                //GET 방식
                /*
                try {
                    //URL encode
                    String strUTF8EventTime = URLEncoder.encode(dateEventTime.toString(), "UTF-8");
                    //Http Connect
                    url = new URL(configSensor.getStrTargetURL() + "/acceptdht11?"
                            + "trid=" + configSensor.getStrRoomRid()
                            + "&tdate=" + strUTF8EventTime
                            + "&ttemperature=" + values[0]
                            + "&thumidity=" + values[1]
                    );
                    conn = (HttpURLConnection) url.openConnection();
                    conn.connect();
                    if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        System.out.println(this.getName() + "\t" + "■ Http send Success");
                    } else {
                        System.out.println(this.getName() + "\t" + "■ Http Problem : " + conn.getResponseCode() + "\t" + conn.getResponseMessage());
                    }

                    conn.disconnect();

                } catch (Exception e) {
                    System.out.println(this.getName() + "\t" + "■ HTTP Error : " + e.getMessage());
                }
                */

                //////////////////////////////////////////////////////////////////////
                // Run Deleay
                //////////////////////////////////////////////////////////////////////
                Thread.sleep(1000);
            } else {
                Thread.yield();
            }

        } catch (Exception e) {
            System.out.println("□ Error [" + this.getName() + "]" + e.getMessage());
        }

    }
    
    
    public void runFlame() throws Exception {
        ///////////////////////////////////////////////////////////
        // 화재 감지 센서 관련
        ///////////////////////////////////////////////////////////
        if (configSensor.isBoolSwitchFlame() == true) {
            //int num = (int) (Math.random() * 5) + 1;
            //double value = 170.2 + num;
            double value = sensorFlame.getValue();
            Date dateEventTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

            //평 상 시 : 240~255이상
            //화재감지 : 민감 상 : 200이하
            //화재감지 : 민감 중 : 175이하 ★
            //화재감지 : 민감 하 : 150이하
            
            this.boolFlameState = ThreadGasAndFlame.boolFLAME_NORMAL;
            if ((configSensor.getIntSensitivityLevelFlame() == Config.intSENSITIVITY_LEVEL_TOP) && value <= 200) {
                this.boolFlameState = ThreadGasAndFlame.boolFLAME_ADNORMAL;
            }
            if ((configSensor.getIntSensitivityLevelFlame() == Config.intSENSITIVITY_LEVEL_MIDDLE) && value <= 175) {
                this.boolFlameState = ThreadGasAndFlame.boolFLAME_ADNORMAL;
            }
            if ((configSensor.getIntSensitivityLevelFlame() == Config.intSENSITIVITY_LEVEL_BOTTOM) && value <= 150) {
                this.boolFlameState = ThreadGasAndFlame.boolFLAME_ADNORMAL;
            }

            String strPrintState = (this.boolFlameState==true)?"문제 발생":"정상";
            String strPrintContent = "Flame\t"
                    + " - Event Time : " + sdf.format(dateEventTime)
                    + "\t" + "Room ID : " + configSensor.getStrRoomRid()
                    + "\t" + "Flame : " + value
                    + "\t" + "state : " + strPrintState;
            System.out.println(strPrintContent);
            
            //////////////////////////////////////////////////////////////////////
            // HTTP send
            //////////////////////////////////////////////////////////////////////
            //System.out.println("Flame\t" + "■ Evnet!");
            URL url = null;
            HttpURLConnection conn = null;
            //POST 방식
            try {
                //Http Connect
                url = new URL(configSensor.getStrTargetURL() + "/acceptflame");
                conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true); 		// 입력스트림 사용여부
                conn.setDoOutput(true); 		// 출력스트림 사용여부
                conn.setUseCaches(false); 		// 캐시사용 여부
                conn.setReadTimeout(20000);		// 타임아웃 설정 ms단위
                conn.setRequestMethod("POST");	// or GET

                OutputStream os = conn.getOutputStream();
                OutputStreamWriter writer = new OutputStreamWriter(os);
                writer.write("frid=" + this.configSensor.getStrRoomRid());
                writer.write("&fflame=" + value);
                writer.write("&fstate=" + this.boolFlameState);
                writer.close();
                os.close();

                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    //System.out.println("Flame\t" + "■ Http send Success");
                } else {
                    System.out.println("Flame\t" + "■ Http Problem : " + conn.getResponseCode() + "\t" + conn.getResponseMessage());
                }

                conn.disconnect();

            } catch (Exception e) {
                System.out.println("Flame\t" + "■ HTTP Error : " + e.getMessage());
                conn.disconnect();
            }

        }

    }

    public void runGas() throws Exception  {
        ///////////////////////////////////////////////////////////
        // 가스 감지 센서 관련
        ///////////////////////////////////////////////////////////
        if (configSensor.isBoolReferenceValueAutoGas() == true) {
            int intAirSum = 0;
            double dblAirAvg = 0.0;
            System.out.print("Gas\t■ 공기값 자동 산정 중(10초)");
            for (int i = 1; i <= 10; i++) {
                double air = sensorGas.getValue();
                intAirSum += air;
                Thread.sleep(1000);
            }
            System.out.println("");
            dblAirAvg = intAirSum / 10;
            System.out.println("Gas\t■ 공기값 자동 산정 완료-측정된 값 : " + (int) dblAirAvg);
            configSensor.setIntReferenceValueGas((int) dblAirAvg); //공기 평균값 지정
            configSensor.setBoolReferenceValueAutoGas(false);
        }

        if (configSensor.isBoolSwitchGas() == true) {
            //int num = (int) (Math.random() * 5) + 1;
            //double value = 224.5 + num;
            
            double value = sensorGas.getValue();
            Date dateEventTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

            //평 상 시 : 120~140 이하 170 255
            //가스감지 : 민감도 상 : +30 ( 보통 170이상 )
            //가스감지 : 민감도 중 : +60 ( 보통 200이상 ) ★
            //가스감지 : 민감도 하 : +90 ( 보통 230이상 )
            
            this.boolGasState = ThreadGasAndFlame.boolGAS_NORMAL;
            if ((configSensor.getIntSensitivityLevelGas() == Config.intSENSITIVITY_LEVEL_TOP) && value >= configSensor.getIntReferenceValueGas() + 30) {
                this.boolGasState = ThreadGasAndFlame.boolGAS_ADNORMAL;
            }
            if ((configSensor.getIntSensitivityLevelGas() == Config.intSENSITIVITY_LEVEL_MIDDLE) && value >= configSensor.getIntReferenceValueGas() + 60) {
                this.boolGasState = ThreadGasAndFlame.boolGAS_ADNORMAL;
            }
            if ((configSensor.getIntSensitivityLevelGas() == Config.intSENSITIVITY_LEVEL_BOTTOM) && value >= configSensor.getIntReferenceValueGas() + 90) {
                this.boolGasState = ThreadGasAndFlame.boolGAS_ADNORMAL;
            }

            String strPrintState = (this.boolGasState==true)?"문제 발생":"정상";
            String strPrintContent = "Gas\t"
                    + " - Event Time : " + sdf.format(dateEventTime)
                    + "\t" + "Room ID : " + configSensor.getStrRoomRid()
                    + "\t" + "Gas : " + value
                    + "\t" + "state : " + strPrintState;
            System.out.println(strPrintContent);
            
            //////////////////////////////////////////////////////////////////////
            // HTTP send
            //////////////////////////////////////////////////////////////////////
            //System.out.println("Gas\t■ Evnet!");
            URL url = null;
            HttpURLConnection conn = null;
            //POST 방식
            try {
                //Http Connect
                url = new URL(configSensor.getStrTargetURL() + "/acceptgas");
                conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true); 		// 입력스트림 사용여부
                conn.setDoOutput(true); 		// 출력스트림 사용여부
                conn.setUseCaches(false); 		// 캐시사용 여부
                conn.setReadTimeout(20000);		// 타임아웃 설정 ms단위
                conn.setRequestMethod("POST");	// or GET

                OutputStream os = conn.getOutputStream();
                OutputStreamWriter writer = new OutputStreamWriter(os);
                writer.write("grid=" + configSensor.getStrRoomRid());
                writer.write("&ggas=" + value);
                writer.write("&gstate=" + this.boolGasState);
                writer.close();
                os.close();

                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    //System.out.println("Gas\t■ Http send Success");
                } else {
                    System.out.println("Gas\t■ Http Problem : " + conn.getResponseCode() + "\t" + conn.getResponseMessage());
                }

                conn.disconnect();

            } catch (Exception e) {
                System.out.println("Gas\t■ HTTP Error : " + e.getMessage());
                conn.disconnect();
            }

        }

    }
    

    public void runUltrasonic(){
        int distance = UltrasonicSensor.getDistance(trigPin, echoPin);

        System.out.println("distance : " + distance);

        //////////////////////////////////////////////////////////////////////
        // Run Deleay
        //////////////////////////////////////////////////////////////////////
            


    }
}
