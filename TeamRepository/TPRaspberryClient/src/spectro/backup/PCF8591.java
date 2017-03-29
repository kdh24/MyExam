package spectro.backup;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import java.io.IOException;

public class PCF8591 {    
    public static int PIN_AIN0 = 0x40;
    public static int PIN_AIN1 = 0x41;
    public static int PIN_AIN2 = 0x42;
    public static int PIN_AIN3 = 0x43; 
    
    public static int read(int i2cAddress, int pin) throws I2CFactory.UnsupportedBusNumberException, IOException {
        I2CBus i2CBus = I2CFactory.getInstance(I2CBus.BUS_1);
        I2CDevice i2CDevice = i2CBus.getDevice(i2cAddress);
        
        i2CDevice.write((byte)pin);
        i2CDevice.read((byte)pin); //dummy read
        int analogVal = i2CDevice.read((byte)pin);

        i2CBus.close();
        return analogVal;
    }
}
