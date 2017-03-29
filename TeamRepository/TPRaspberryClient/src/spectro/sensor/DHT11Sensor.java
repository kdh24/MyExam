package spectro.sensor;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalMultipurpose;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import spectro.backup.*;
import java.util.List;
import java.util.ArrayList;

import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.GpioUtil;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class DHT11Sensor {
	private static final int MAXTIMINGS = 85;
	private int[] dht11_dat = { 0, 0, 0, 0, 0 };

	private static final int PIN_NO = 29;
	private KalmanFilter kalmanFilterH;
	private KalmanFilter kalmanFilterC;

        //GpioController gpio = GpioFactory.getInstance();
        //GpioPinDigitalMultipurpose pin = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_29, PinMode.DIGITAL_INPUT);
        
        private static DHT11Sensor instance = new DHT11Sensor();
        
	private DHT11Sensor() {
		// setup wiringPi
                /*
		if (Gpio.wiringPiSetup() == -1) {
			System.out.println(" ==>> GPIO SETUP FAILED");
			return;
		}
		GpioUtil.export(PIN_NO, GpioUtil.DIRECTION_OUT);
                */
	}
        
        public static DHT11Sensor getInstance() {
            return instance;
        }

	public double[] getTemperature() {
		int laststate = Gpio.HIGH;
		int j = 0;
		dht11_dat[0] = dht11_dat[1] = dht11_dat[2] = dht11_dat[3] = dht11_dat[4] = 0;

		Gpio.pinMode(PIN_NO, Gpio.OUTPUT);
		Gpio.digitalWrite(PIN_NO, Gpio.LOW);
		Gpio.delay(18);

		Gpio.digitalWrite(PIN_NO, Gpio.HIGH);
		Gpio.pinMode(PIN_NO, Gpio.INPUT);

		for (int i = 0; i < MAXTIMINGS; i++) {
			int counter = 0;
			while (Gpio.digitalRead(PIN_NO) == laststate) {
				counter++;
				Gpio.delayMicroseconds(1);
				if (counter == 255) {
					break;
				}
			}

			laststate = Gpio.digitalRead(PIN_NO);

			if (counter == 255) {
				break;
			}

			/* ignore first 3 transitions */
			if ((i >= 4) && (i % 2 == 0)) {
				/* shove each bit into the storage bytes */
				dht11_dat[j / 8] <<= 1;
				if (counter > 16) {
					dht11_dat[j / 8] |= 1;
				}
				j++;
			}
		}
		// check we read 40 bits (8bit x 5 ) + verify checksum in the last
		// byte
		if ((j >= 40) && checkParity()) {
			float h = (float) ((dht11_dat[0] << 8) + dht11_dat[1]) / 10;
			if (h > 100) {
				h = dht11_dat[0]; // for DHT11
			}
			float c = (float) (((dht11_dat[2] & 0x7F) << 8) + dht11_dat[3]) / 10;
			if (c > 125) {
				c = dht11_dat[2]; // for DHT11
			}
			if ((dht11_dat[2] & 0x80) != 0) {
				c = -c;
			}
			float f = c * 1.8f + 32;

			// System.out.println("Humidity = " + h + " Temperature = " + c);
			double[] values = { c, h };
			return values;

			/*
			 * if(kalmanFilterH == null) { kalmanFilterH = new KalmanFilter(h);
			 * } if(kalmanFilterC == null) { kalmanFilterC = new
			 * KalmanFilter(c); } System.out.println("Humidity = " +
			 * Math.round(kalmanFilterH.update(h)) + " Temperature = " +
			 * Math.round(kalmanFilterC.update(c)));
			 * System.out.println("-----------");
			 */
		} else {
			return getTemperature();
		}
	}

	private boolean checkParity() {
		return (dht11_dat[4] == ((dht11_dat[0] + dht11_dat[1] + dht11_dat[2] + dht11_dat[3]) & 0xFF));
	}

	class KalmanFilter {
		private double Q = 0.00001;
		private double R = 0.001;
		private double X = 0;
		private double P = 1;
		private double K;

		// 첫번째값을 입력받아 초기화 한다. 예전값들을 계산해서 현재값에 적용해야 하므로 반드시 하나이상의 값이 필요하므로~
		public KalmanFilter(double initValue) {
			X = initValue;
		}

		// 예전값들을 공식으로 계산한다
		public void measurementUpdate() {
			K = (P + Q) / (P + Q + R);
			P = R * (P + Q) / (R + P + Q);
		}

		// 현재값을 받아 계산된 공식을 적용하고 반환한다
		public double update(double measurement) {
			measurementUpdate();
			X = X + (measurement - X) * K;
			return X;
		}
	}

}