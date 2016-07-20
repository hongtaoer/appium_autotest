package com.appium.test.ios.shipper;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by chenliu on 16/6/25.
 *初始化iOS设置
 */
public class InitializeShipperIOSDriver {

    public static IOSDriver<IOSElement> init() throws MalformedURLException {
        IOSDriver<IOSElement> driver = null;
        File appDir = new File("/Users/chenliu/Desktop/iOSfile/Shipper.ipa");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "9.3");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "IPhone 6");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, appDir.getAbsolutePath());
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET,true);//删除整个模拟器目录
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,false);
//        desiredCapabilities.setCapability("unicodekeyboard", true);
//        desiredCapabilities.setCapability("resetkeyboard", true);
        desiredCapabilities.setCapability("appiumVersion","1.5.3");
        driver = new IOSDriver<IOSElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
//        if(driver.isAppInstalled("com.NewTestShiper")){
//            driver.removeApp("com.NewTestShiper");
//            driver.installApp(appDir.getAbsolutePath());
//        }
        return  driver;
    }
}
