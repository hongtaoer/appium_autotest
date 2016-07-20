package com.appium.test.ios.shipper;



import com.cl.appium.ios.shipper.order.CJPublishOrder;
import com.cl.appium.ios.shipper.user.ShipperLogin;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by chenliu on 16/6/25.
 */
public class LoginTest {
    private static IOSDriver<IOSElement> driver;

    // 启动app时 就相当于创建了一个session
    @BeforeClass
    public static void beforeClass() throws Exception {
        driver =InitializeShipperIOSDriver.init();
    }

    @Test
    public void login(){
        ShipperLogin.loginByPassword(driver);
    }


    @AfterClass
    public static void afterClass() {
        if (driver != null) {
//            driver.quit();
        }
    }
}
