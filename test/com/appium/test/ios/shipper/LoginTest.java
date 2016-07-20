package com.appium.test.ios.shipper;


import com.cl.appium.common.Log;
import com.cl.appium.ios.shipper.user.ShipperLogin;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chenliu on 16/6/25.
 */
public class LoginTest {
    private static IOSDriver<IOSElement> driver;
    private static final Logger LOG = Log.getLog(LoginTest.class);

    // 启动app时 就相当于创建了一个session
//    @BeforeClass
    public static void beforeClass() throws Exception {
        driver = InitializeShipperIOSDriver.init();
    }

    @Test
    public void login() {
        ShipperLogin.loginByPassword(driver);
    }


    @Test
    public void logTest() {
        LOG.error("This is appium autotest error log");
        LOG.info("This is appium autotest info log");
    }

    @AfterClass
    public static void afterClass() {
        if (driver != null) {
//            driver.quit();
        }
    }

}
