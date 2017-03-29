package spectro.dto;

public class Config {
    //////////////////////////////////////////////////////
    // 설정 정보
    //////////////////////////////////////////////////////
    public final static int intSENSITIVITY_LEVEL_TOP = 3;    //센서 민감도 상
    public final static int intSENSITIVITY_LEVEL_MIDDLE = 2; //센서 민감도 중
    public final static int intSENSITIVITY_LEVEL_BOTTOM = 1; //센서 민감도 하
    
    public final static int intDOOR_PULL = -1; //당기는 문
    public final static int intDOOR_PUSH = 1; //미는문

    String strMemberMid = "";
    String strMemberMpassword = "";
    String strRoomRid = "";
    String strTargetURL = "";
    
    boolean boolSwitchDHT11 = false;
    
    //화재감지 센서 관련
    boolean boolSwitchFlame = false;
    int intSensitivityLevelFlame = Config.intSENSITIVITY_LEVEL_MIDDLE; //민감도 기본값 보통
    
    //가스감지 센서 관련
    boolean boolSwitchGas = false;
    int intSensitivityLevelGas = Config.intSENSITIVITY_LEVEL_MIDDLE; //민감도 기본값 보통
    boolean boolReferenceValueAutoGas = false;  //공기 수치 자동감지 기능 ON/OFF    
    int intReferenceValueGas = 0; //보통 공기 상태 값 지정

    //거리감지 센서 관련
    boolean boolSwitchUltrasonic = false;
    int intSensitivityLevelUltrasonic = Config.intSENSITIVITY_LEVEL_MIDDLE; //민감도 기본값 보통
    int intStyleDoorUltrasonic = 0; //문의 방향(미는 문 / 당기는 문 셋팅)
    boolean boolReferenceValueAutoUltrasonic = false;  //거리 기준 자동감지 기능 ON/OFF
    int intReferenceValueUltrasonic = 0;               //거리 기준 수동지정 cm

    

    public Config() {
    }


    public Config(String strMemberMid, String strMemberMpassword, String strRoomRid, String strTargetURL) {
        super();
        this.strMemberMid = strMemberMid;
        this.strMemberMpassword = strMemberMpassword;
        this.strRoomRid = strRoomRid;
        this.strTargetURL = strTargetURL;
    }


    //====================== 회원 ID======================
    public String getStrMemberMid() {
        return strMemberMid;
    }
    public void setStrMemberMid(String strMemberMid) {
        //System.out.println(Thread.currentThread().getName() + " 가 ConfigSensor 수정");
        this.strMemberMid = strMemberMid;
    }

    //====================== 회원 PW======================
    public String getStrMemberMpassword() {
        return strMemberMpassword;
    }
    public void setStrMemberMpassword(String strMemberMpassword) {
        System.out.println(Thread.currentThread().getName() + " 가 ConfigSensor 수정");
        this.strMemberMpassword = strMemberMpassword;
    }

    //====================== Room ID ======================
    public String getStrRoomRid() {
        return strRoomRid;
    }
    public void setStrRoomRid(String strRoomRid) {
        //System.out.println(Thread.currentThread().getName() + " 가 ConfigSensor 수정");
        this.strRoomRid = strRoomRid;
    }

    //====================== TargetURL ======================
    public String getStrTargetURL() {
        return strTargetURL;
    }
    public void setStrTargetURL(String strTargetURL) {
        //System.out.println(Thread.currentThread().getName() + " 가 ConfigSensor 수정");
        this.strTargetURL = strTargetURL;
    }

    //====================== boolSwitchDHT11 ======================
    public boolean isBoolSwitchDHT11() {
        return boolSwitchDHT11;
    }
    public synchronized void setBoolSwitchDHT11(boolean boolSwitchDHT11) {
        //System.out.println(Thread.currentThread().getName() + " 가 ConfigSensor 수정");
        this.boolSwitchDHT11 = boolSwitchDHT11;
    }

    //====================== boolSwitchFlame ======================
    public boolean isBoolSwitchFlame() {
        return boolSwitchFlame;
    }
    public synchronized void setBoolSwitchFlame(boolean boolSwitchFlame) {
        //System.out.println(Thread.currentThread().getName() + " 가 ConfigSensor 수정");
        this.boolSwitchFlame = boolSwitchFlame;
    }

    //intSensitivityLevelFlame
    public int getIntSensitivityLevelFlame() {
        return intSensitivityLevelFlame;
    }
    public void setIntSensitivityLevelFlame(int intSensitivityLevelFlame) {
        //System.out.println(Thread.currentThread().getName() + " 가 ConfigSensor 수정");
        this.intSensitivityLevelFlame = intSensitivityLevelFlame;
    }
    
    //====================== boolSwitchGas ======================
    public boolean isBoolSwitchGas() {
        return boolSwitchGas;
    }
    public synchronized void setBoolSwitchGas(boolean boolSwitchGas) {
        //System.out.println(Thread.currentThread().getName() + " 가 ConfigSensor 수정");
        this.boolSwitchGas = boolSwitchGas;
    }
    
    //intSensitivityLevelGas
    public int getIntSensitivityLevelGas() {
        return intSensitivityLevelGas;
    }

    public void setIntSensitivityLevelGas(int intSensitivityLevelGas) {
        this.intSensitivityLevelGas = intSensitivityLevelGas;
    }

    //boolReferenceValueAutoGas
    public boolean isBoolReferenceValueAutoGas() {
        return boolReferenceValueAutoGas;
    }
    public void setBoolReferenceValueAutoGas(boolean boolReferenceValueAutoGas) {
        this.boolReferenceValueAutoGas = boolReferenceValueAutoGas;
    }

    //intReferenceValueGas
    public int getIntReferenceValueGas() {
        return intReferenceValueGas;
    }
    public void setIntReferenceValueGas(int intReferenceValueGas) {
        this.intReferenceValueGas = intReferenceValueGas;
    }
    

    //====================== boolSwitchUltrasonic ======================
    public boolean isBoolSwitchUltrasonic() {
        return boolSwitchUltrasonic;
    }
    public synchronized void setBoolSwitchUltrasonic(boolean boolSwitchUltrasonic) {
        //System.out.println(Thread.currentThread().getName() + " 가 ConfigSensor 수정");
        this.boolSwitchUltrasonic = boolSwitchUltrasonic;
    }

    //intSensitivityLevelUltrasonic
    public int getIntSensitivityLevelUltrasonic() {
        return intSensitivityLevelUltrasonic;
    }
    public void setIntSensitivityLevelUltrasonic(int intSensitivityLevelUltrasonic) {
        //System.out.println(Thread.currentThread().getName() + " 가 ConfigSensor 수정");
        this.intSensitivityLevelUltrasonic = intSensitivityLevelUltrasonic;
    }
    
    //intStyleDoorUltrasonic
    public int getIntStyleDoorUltrasonic() {
        return intStyleDoorUltrasonic;
    }
    public void setIntStyleDoorUltrasonic(int intStyleDoorUltrasonic) {
        //System.out.println(Thread.currentThread().getName() + " 가 ConfigSensor 수정");
        this.intStyleDoorUltrasonic = intStyleDoorUltrasonic;
    }
    
    //BoolReferenceValueUltrasonicAuto
    public boolean isBoolReferenceValueAutoUltrasonic() {
        return boolReferenceValueAutoUltrasonic;
    }
    public void setBoolReferenceValueAutoUltrasonic(boolean boolReferenceValueUltrasonicAuto) {
        this.boolReferenceValueAutoUltrasonic = boolReferenceValueUltrasonicAuto;
    }

    //intReferenceValueUltrasonic
    public int getIntReferenceValueUltrasonic() {
        return intReferenceValueUltrasonic;
    }
    public void setIntReferenceValueUltrasonic(int intReferenceValueUltrasonic) {
        //System.out.println(Thread.currentThread().getName() + " 가 ConfigSensor 수정");
        this.intReferenceValueUltrasonic = intReferenceValueUltrasonic;
    }




}
