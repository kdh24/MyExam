package spectro.sensor;

import spectro.backup.*;
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
	private int i2CDeviceAddress = 0x48; // 아날로그신호를 디지털화하는 장비(PCF8591)번호
	private int analogPinNo = PCF8591.PIN_AIN0; // PCF8591의 핀번호 0,1,2,3

	private static FlameSensor instance = new FlameSensor();

	private FlameSensor() {
	}

	public static FlameSensor getInstance() {
		return instance;
	}

	public double getValue() throws I2CFactory.UnsupportedBusNumberException, IOException {
		int analogVal = PCF8591.read(i2CDeviceAddress, analogPinNo);
		return analogVal;
	}

}
