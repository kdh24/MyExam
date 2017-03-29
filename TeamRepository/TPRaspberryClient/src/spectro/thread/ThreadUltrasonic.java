package spectro.thread;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import spectro.dto.Config;
import spectro.sensor.UltrasonicSensor;
import static spectro.sensor.UltrasonicSensor.getDistance;

public class ThreadUltrasonic extends Thread {

    public final static boolean boolDOOR_CLOSED = false;
    public final static boolean boolDOOR_OPENED = true;
    
    private Config configSensor;
    private boolean boolDoorState;
    
    private boolean boolFristSendSW; //최초 실행시 일단 한번 전송하겠근 하는 스위치

    public ThreadUltrasonic(Config configSensor) {
        this.setName("ThreadUTSN");
        this.configSensor = configSensor;
        this.boolDoorState = ThreadUltrasonic.boolDOOR_CLOSED;
        
        //최초에는 한번 데이터 날리기
        this.boolFristSendSW = true;
    }

    @Override
    public void run() {
        // 스레드가 실행할 작업 내용
        GpioController gpio = GpioFactory.getInstance();
        //트래거 : 나가는 신호
        GpioPinDigitalOutput trigPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.LOW); //RaspiPin.GPIO_00는 PuTTY에서 gpio readall로 조회해서 나오는 정보를 기반으로 핀꼽은곳 상수값 가져다 쓰는것 
        //에코 : 들어오는 신호
        GpioPinDigitalInput echoPin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_05); //RaspiPin.GPIO_01는 위와 동일
        
        if(configSensor.isBoolReferenceValueAutoUltrasonic() == true){
            int intDistanceSum = 0;
            double dblDistanceAvg = 0.0;
            System.out.print("UTSN\t■ 문과의 거리 자동 산정 중(10초)");
            for(int i=1; i<=10; i++){
                int distance = UltrasonicSensor.getDistance(trigPin, echoPin);
                intDistanceSum += distance;
                try {Thread.sleep(1000);} catch (Exception e) {}
            }
            System.out.println("");
            dblDistanceAvg = intDistanceSum / 10;
            System.out.println("UTSN\t■ 문과의 거리 자동 산정 완료-측정된 값 : " + (int)dblDistanceAvg);
            configSensor.setIntReferenceValueUltrasonic((int)dblDistanceAvg); //문과 센서의 거리 기준값 산정 cm
            configSensor.setBoolReferenceValueAutoUltrasonic(false);
            try {Thread.sleep(1000);} catch (Exception e) {}
        }
        
        try {
            while (true) {
                if (configSensor.isBoolSwitchUltrasonic() == true) {
                    //int num = (int) (Math.random() * 5) + 1;
                    //int distance = 10 + num;
                    int distance = UltrasonicSensor.getDistance(trigPin, echoPin);
                    Date dateEventTime = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                    
                    //평 상 시 : 최소 셋팅 된 최소 ~ 최대값 범위
                    //거리변화 : 민감도 상 : 거리 변화 10cm 에 반응
                    //거리변화 : 민감도 중 : 거리 변화 20cm 에 반응
                    //거리변화 : 민감도 하 : 거리 변화 30cm 에 반응
                    boolean boolSendSW = false;
                    
                    //■닫혀있던 상태에서 문이 열렸나 확인
                    if(boolDoorState == ThreadUltrasonic.boolDOOR_CLOSED){
                        if( configSensor.getIntSensitivityLevelUltrasonic() == Config.intSENSITIVITY_LEVEL_TOP ){
                            if(configSensor.getIntStyleDoorUltrasonic() == Config.intDOOR_PULL){
                                //당기는 문
                                if(distance <= configSensor.getIntReferenceValueUltrasonic() - 10){
                                    boolSendSW = true;
                                    boolDoorState = ThreadUltrasonic.boolDOOR_OPENED;
                                }
                            }else if(configSensor.getIntStyleDoorUltrasonic() == Config.intDOOR_PUSH){
                                //미는 문
                                if(distance >= configSensor.getIntReferenceValueUltrasonic() + 10){
                                    boolSendSW = true;
                                    boolDoorState = ThreadUltrasonic.boolDOOR_OPENED;
                                }
                            }  
                        }
                        if( configSensor.getIntSensitivityLevelUltrasonic() == Config.intSENSITIVITY_LEVEL_MIDDLE ){
                            if(configSensor.getIntStyleDoorUltrasonic() == Config.intDOOR_PULL){
                                //당기는 문
                                if(distance <= configSensor.getIntReferenceValueUltrasonic() - 20){
                                    boolSendSW = true;
                                    boolDoorState = ThreadUltrasonic.boolDOOR_OPENED;
                                }
                            }else if(configSensor.getIntStyleDoorUltrasonic() == Config.intDOOR_PUSH){
                                //미는 문
                                if(distance >= configSensor.getIntReferenceValueUltrasonic() + 20){
                                    boolSendSW = true;
                                    boolDoorState = ThreadUltrasonic.boolDOOR_OPENED;
                                }
                            }
                        }
                        if( configSensor.getIntSensitivityLevelUltrasonic() == Config.intSENSITIVITY_LEVEL_BOTTOM ){
                            if(configSensor.getIntStyleDoorUltrasonic() == Config.intDOOR_PULL){
                                //당기는 문
                                if(distance <= configSensor.getIntReferenceValueUltrasonic() - 30){
                                    boolSendSW = true;
                                    boolDoorState = ThreadUltrasonic.boolDOOR_OPENED;
                                }
                            }else if(configSensor.getIntStyleDoorUltrasonic() == Config.intDOOR_PUSH){
                                //미는 문
                                if(distance >= configSensor.getIntReferenceValueUltrasonic() + 30){
                                    boolSendSW = true;
                                    boolDoorState = ThreadUltrasonic.boolDOOR_OPENED;
                                }
                            }
                        }
                        
                    //■문이 열린 상태에서 문이 닫혔는지 확인
                    }else if(boolDoorState == ThreadUltrasonic.boolDOOR_OPENED){
                        if( configSensor.getIntSensitivityLevelUltrasonic() == Config.intSENSITIVITY_LEVEL_TOP ){
                            if(configSensor.getIntStyleDoorUltrasonic() == Config.intDOOR_PULL){
                                //당기는 문
                                if(distance >= configSensor.getIntReferenceValueUltrasonic() - 10){
                                    boolSendSW = true;
                                    boolDoorState = ThreadUltrasonic.boolDOOR_CLOSED;
                                }
                            }else if(configSensor.getIntStyleDoorUltrasonic() == Config.intDOOR_PUSH){
                                //미는 문
                                if(distance <= configSensor.getIntReferenceValueUltrasonic() + 10){
                                    boolSendSW = true;
                                    boolDoorState = ThreadUltrasonic.boolDOOR_CLOSED;
                                }
                            }  
                        }
                        if( configSensor.getIntSensitivityLevelUltrasonic() == Config.intSENSITIVITY_LEVEL_MIDDLE ){
                            if(configSensor.getIntStyleDoorUltrasonic() == Config.intDOOR_PULL){
                                //당기는 문
                                if(distance >= configSensor.getIntReferenceValueUltrasonic() - 20){
                                    boolSendSW = true;
                                    boolDoorState = ThreadUltrasonic.boolDOOR_CLOSED;
                                }
                            }else if(configSensor.getIntStyleDoorUltrasonic() == Config.intDOOR_PUSH){
                                //미는 문
                                if(distance <= configSensor.getIntReferenceValueUltrasonic() + 20){
                                    boolSendSW = true;
                                    boolDoorState = ThreadUltrasonic.boolDOOR_CLOSED;
                                }
                            }
                        }
                        if( configSensor.getIntSensitivityLevelUltrasonic() == Config.intSENSITIVITY_LEVEL_BOTTOM ){
                            if(configSensor.getIntStyleDoorUltrasonic() == Config.intDOOR_PULL){
                                //당기는 문
                                if(distance >= configSensor.getIntReferenceValueUltrasonic() - 30){
                                    boolSendSW = true;
                                    boolDoorState = ThreadUltrasonic.boolDOOR_CLOSED;
                                }
                            }else if(configSensor.getIntStyleDoorUltrasonic() == Config.intDOOR_PUSH){
                                //미는 문
                                if(distance <= configSensor.getIntReferenceValueUltrasonic() + 30){
                                    boolSendSW = true;
                                    boolDoorState = ThreadUltrasonic.boolDOOR_CLOSED;
                                }
                            }
                        }
                        
                    }
 
                    //전송 처리
                    if(boolSendSW == true || this.boolFristSendSW == true){
                        this.boolFristSendSW = false;
                        //log 출력
                        String strPrintState = (boolDoorState==true)?"OPENED":"CLOSED";
                        String strPrintContent = "UTSN\t"
                                + " - Event Time : " + sdf.format(dateEventTime)
                                + "\t" + "Room ID : " + configSensor.getStrRoomRid()
                                + "\t" + "distance : " + distance
                                + "\t" + "state : " + strPrintState;
                        System.out.println(strPrintContent);
                        
                        //////////////////////////////////////////////////////////////////////
                        // HTTP send
                        //////////////////////////////////////////////////////////////////////
                        //System.out.println("UTSN\t■ Evnet!");
                        URL url = null;
                        HttpURLConnection conn = null;
                        //POST 방식
                        try {
                            //Http Connect
                            url = new URL(configSensor.getStrTargetURL() + "/acceptutsn");
                            conn = (HttpURLConnection) url.openConnection();
                            conn.setDoInput(true); 		// 입력스트림 사용여부
                            conn.setDoOutput(true); 		// 출력스트림 사용여부
                            conn.setUseCaches(false); 		// 캐시사용 여부
                            conn.setReadTimeout(20000);		// 타임아웃 설정 ms단위
                            conn.setRequestMethod("POST");	// or GET

                            OutputStream os = conn.getOutputStream();
                            OutputStreamWriter writer = new OutputStreamWriter(os);
                            writer.write("vrid=" + configSensor.getStrRoomRid());
                            writer.write("&vstate=" + boolDoorState);
                            writer.close();
                            os.close();

                            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                                //System.out.println("UTSN\t■ Http send Success");
                            } else {
                                System.out.println("UTSN\t■ Http Problem : " + conn.getResponseCode() + "\t" + conn.getResponseMessage());
                            }

                            conn.disconnect();

                        } catch (Exception e) {
                            System.out.println("UTSN\t■ HTTP Error : " + e.getMessage());
                            conn.disconnect();
                        }
                    }
                    
                    //////////////////////////////////////////////////////////////////////
                    // Run Deleay
                    //////////////////////////////////////////////////////////////////////
                    Thread.sleep(1000);
                } else {
                    Thread.yield();
                }
            }
        } catch (Exception e) {
            System.out.println("□ Error [" + this.getName() + "]" + e.getMessage());
        }

    }

}
