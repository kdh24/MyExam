package spectro;


import spectro.dto.Config;
import spectro.thread.ThreadDHT11;
import spectro.thread.ThreadGasAndFlame;
import spectro.thread.ThreadUltrasonic;

public class AppMain {

    //member table 정보 관련
    //room table 정보 관련
    //스레드 관련
    public static void main(String[] args) throws Exception {
        //////////////////////////////////////////////////////
        // main 메소드
        //////////////////////////////////////////////////////
        
        //====== 공유 객체 : 설정정보 셋팅 ===================
        Config configSensor = new Config("kosauser", "12345", "103", "http://192.168.0.30:8080/myweb/piserver");
        //Config configSensor = new Config("kosauser", "12345", "103","http://localhost:8080/myweb/piserver");
        
        //센서설정 - 온도 습도 
        configSensor.setBoolSwitchDHT11(true);

        //센서설정 - 화재감지
        configSensor.setBoolSwitchFlame(true);
        configSensor.setIntSensitivityLevelFlame(Config.intSENSITIVITY_LEVEL_MIDDLE);
        
        //센서설정 - 가스감지
        configSensor.setBoolSwitchGas(true);
        configSensor.setIntSensitivityLevelGas(Config.intSENSITIVITY_LEVEL_MIDDLE);        
        configSensor.setBoolReferenceValueAutoGas(false);
        configSensor.setIntReferenceValueGas(165);
        
        //센서설정 - 방문자 감지
        configSensor.setBoolSwitchUltrasonic(true);
        configSensor.setIntSensitivityLevelUltrasonic(Config.intSENSITIVITY_LEVEL_MIDDLE); //민감도 셋팅
        configSensor.setIntStyleDoorUltrasonic(Config.intDOOR_PULL); //문 열림 방향 셋팅
        //configSensor.setBoolReferenceValueAutoUltrasonic(false); //문과 센서의 거리 기준값(cm) 산정 자동화 수행 여부
        configSensor.setIntReferenceValueUltrasonic(160);       //문과 센서의 거리 기준값(cm) 지정 
        //====================================================
        
        
        //아이디로 비번으로 로그인해서 해당 사용자가 쓰고있는 방아이디 정보 불러오는 기능
        //그 정보중에 하나 선택해서 RID값 셋팅
        //
        System.out.println("■ IOT 더미 제어 프로그램(101) ■");
        System.out.println("== 1초뒤 센서 구동 및 Http 통신 시작");
        Thread.sleep(1000);

        //온도 습도
        ThreadDHT11 threadDHT11 = new ThreadDHT11(configSensor);
        threadDHT11.setPriority(Thread.MIN_PRIORITY);
        threadDHT11.start();
        
        //화재&가스
        ThreadGasAndFlame threadGasAndFlame = new ThreadGasAndFlame(configSensor);
        threadGasAndFlame.setPriority(Thread.MAX_PRIORITY);
        threadGasAndFlame.start();
 
        //거리감지
        ThreadUltrasonic threadUltrasonic = new ThreadUltrasonic(configSensor);
        threadUltrasonic.setPriority(Thread.NORM_PRIORITY);
        threadUltrasonic.start();

    }
}
