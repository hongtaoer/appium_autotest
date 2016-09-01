package com.appium.test.ios.shipper;


import com.cl.appium.common.log.Log;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by chenliu on 16/6/25.
 *初始化iOS设置
 */
public class InitializeShipperIOSDriver {
    private static Logger LOG= Log.getLog(InitializeShipperIOSDriver.class);
    public static IOSDriver<IOSElement> init()  {
        LOG.info("========登录测试初始化驱动器=====");
        IOSDriver<IOSElement> driver = null;
        try {
            File appDir = new File("/Users/chenliu/Desktop/iOSfile/560Shipper_v200_test.ipa");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "9.3");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "IPhone 6");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, appDir.getAbsolutePath());
            desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, true);//删除整个模拟器目录
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, false);//不要在会话前重置会话状态
            desiredCapabilities.setCapability("autoAcceptAlerts",true);//设置个人信息的访问为ture(自动接收系统通知)

//        desiredCapabilities.setCapability("unicodekeyboard", true);
//        desiredCapabilities.setCapability("resetkeyboard", true);

            desiredCapabilities.setCapability("appiumVersion", "1.5.3");
            driver = new IOSDriver<IOSElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

//        if(driver.isAppInstalled("com.NewTestShiper")){
//            driver.removeApp("com.NewTestShiper");
//            driver.installApp(appDir.getAbsolutePath());
//        }
        }
        catch (Exception e)
        {
            LOG.error("========登录测试初始化驱动器出现异常=====" + e.getMessage());
            e.printStackTrace();
        }
        LOG.info("========登录测试初始化驱动器成功=====");
        return  driver;
    }
}
