package spectro.backup;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class UltrasonicSensor {
    public static void main(String[] args) throws Exception {
        GpioController gpio = GpioFactory.getInstance();
        //트래거 : 나가는 신호
        GpioPinDigitalOutput trigPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.LOW); //RaspiPin.GPIO_00는 PuTTY에서 gpio readall로 조회해서 나오는 정보를 기반으로 핀꼽은곳 상수값 가져다 쓰는것 
        //에코 : 들어오는 신호
        GpioPinDigitalInput echoPin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_05); //RaspiPin.GPIO_01는 위와 동일

        while (true) {
            int distance = getDistance(trigPin, echoPin);
            System.out.println("거리(cm): " + distance);
            Thread.sleep(1000);
            //■■■■ 거리 : int distance
        }
    }

    public static int getDistance(GpioPinDigitalOutput trigPin, GpioPinDigitalInput echoPin) {
        //시간 변수 선언
        double start = 0;
        double end = 0;
        //펄스를 10 마이크로초 동안 발생
        
        //1. 트래거가 활성화하고 0.01초의 동안 신호를 날림 ======
        trigPin.high(); //트래거 on
        try {
            Thread.sleep(0, 10000); //0.01
        } catch (InterruptedException e) {}
        trigPin.low(); //트래거 off -> 이상태가 되면 자동적으로 echoPin.isLow()( = 에코 on/받을준비 ) 상태가 되어있고(?)
        //================================================
        
        //2. 신호가 되돌아 올때까지 대기 타기 =================
        //> high 수신 시작일 때 시간 측정
        while (!echoPin.isHigh()) {
            /* 1. echoPin.isHigh() : false( = echoPin.isLow(): ture )상태로 신호되돌아 올때까지 대기타기타다
             * 2. 신호가 들어오면 echoPin.isHigh()=true( = echoPin.isLow(): false )가 되서 종료됨  */ 
        }
        start = System.nanoTime(); //되돌아오는 신호를 감지한 순간의 시간 기록 : start
        //================================================
        
        //3. 되돌아온 신호를 다 받을 때까지 대기타기 ===========
        //> low 수신 시작일 때 시간 측정
        while (!echoPin.isLow()) {
            /* 1. 신호가 들어오는 동안 echoPin.isHigh()=true( = echoPin.isLow(): false )의 상태로 받다가
             * 2. 신호를 다 받으면 echoPin.isHigh() : false( = echoPin.isLow(): ture )상태가 되서 종료됨  */ 
        }
        end = System.nanoTime(); //되돌아온 신호가 끝나는 순간의 시간 기록 : end
        //================================================
        
        //4. 시간으로 거리 계산 =============================
        //편도 시간(단위: sec)
        double seconds = (end - start) / 1000000000 / 2; //시간 거리 측정, 센서 특성상 최대 5m이내 인식가능
        //거리 계산(단위: cm)
        double distance = seconds * 34000;
        return (int) distance;
        //================================================
    }
}
