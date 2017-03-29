package spectro.backup;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.i2c.I2CFactory;
import java.io.IOException;

public class FlameSensor {
    private int i2CDeviceAddress = 0x48; //아날로그신호를 디지털화하는 장비(PCF8591)번호
    private int analogPinNo = PCF8591.PIN_AIN0; //PCF8591의 핀번호 0,1,2,3 
    //private Pin digitalPinNo = RaspiPin.GPIO_00; //디지털신호(Do신호 특정값이되면 1, 아니면 0) 보내는건데 제외(의미없음)
    //private GpioController gpio;
    //private GpioPinDigitalInput pin;

    private static FlameSensor instance = new FlameSensor();
    private FlameSensor() {
        /*
        gpio = GpioFactory.getInstance();
        //pin = gpio.provisionDigitalInputPin(digitalPinNo);
        gpio.addListener(listener, pin);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                 gpio.shutdown();
            }
        });
        */
    }
    public static FlameSensor getInstance() {
        return instance;
    }
    
    /*
    GpioPinListenerDigital listener = new GpioPinListenerDigital() {
        @Override
        public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
            if(event.getState()==PinState.LOW) {
                System.out.println("불났음");
            } else {
                System.out.println("안전함");
            }
        }
    };
    */

    public double getValue() throws I2CFactory.UnsupportedBusNumberException, IOException {
        int analogVal = PCF8591.read(i2CDeviceAddress, analogPinNo);
        return analogVal;
    }
    
    /*
    public PinState getState() {
        return pin.getState();
    }
    */
    
    public static void main(String[] args) throws Exception {
        FlameSensor sensor = FlameSensor.getInstance();
        for(int i=0; i<=100; i++) {
            double value = sensor.getValue();
            System.out.print(value + ": ");
            Thread.sleep(1000);
            //■■■■ 화재감지 : double value
            
        }
    }
}
