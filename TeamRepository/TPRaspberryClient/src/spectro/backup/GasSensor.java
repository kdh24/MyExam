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

public class GasSensor {
    private int i2CDeviceAddress = 0x48;
    private int analogPinNo = PCF8591.PIN_AIN1;
    private GpioController gpio;

    private static GasSensor instance = new GasSensor();
    private GasSensor() {
        gpio = GpioFactory.getInstance();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                 gpio.shutdown();
            }
        });
    }
    public static GasSensor getInstance() {
        return instance;
    }

    public double getValue() throws I2CFactory.UnsupportedBusNumberException, IOException {
        int analogVal = PCF8591.read(i2CDeviceAddress, analogPinNo);
        return analogVal;
    }
    
    public static void main(String[] args) throws Exception {
        GasSensor sensor = GasSensor.getInstance();
        for(int i=0; i<=100; i++) {
            double value = sensor.getValue();
            System.out.print(value + ": ");
            Thread.sleep(1000);
            //■■■■ 가스감지 : double value
        }
    }
}
