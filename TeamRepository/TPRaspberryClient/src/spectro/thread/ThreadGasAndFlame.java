package spectro.thread;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import spectro.dto.Config;
import spectro.sensor.FlameSensor;
import spectro.sensor.GasSensor;

public class ThreadGasAndFlame extends Thread {
    public final static boolean boolFLAME_ADNORMAL = true; //화재 문제발생
    public final static boolean boolFLAME_NORMAL = false; //화재 정상상태
    
    public final static boolean boolGAS_ADNORMAL = true; //가스 문제발생
    public final static boolean boolGAS_NORMAL = false; //가스 정상상태
    
    private Config configSensor;
    private FlameSensor sensorFlame;
    private GasSensor sensorGas;
    
    private boolean boolFlameState;
    private boolean boolGasState;
    

    public ThreadGasAndFlame(Config configSensor) {
        this.setName("ThreadGasAndFlame");
        this.configSensor = configSensor;
        this.sensorFlame = FlameSensor.getInstance();
        this.sensorGas = GasSensor.getInstance();
        
        this.boolFlameState = ThreadGasAndFlame.boolFLAME_NORMAL;
        this.boolGasState = ThreadGasAndFlame.boolGAS_NORMAL;
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.runGas();
                Thread.sleep(10000);
                
                this.runFlame();
                Thread.sleep(10000);
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
            //System.out.println(strPrintContent);
            
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
            //System.out.println(strPrintContent);
            
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

}
