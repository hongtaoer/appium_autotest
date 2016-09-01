package com.appium.test.ios.shipper;

import com.cl.appium.ios.shipper.order.CJPublishOrder;

import com.cl.appium.ios.shipper.user.ShipperLogin;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by chenliu on 16/6/26.
 */
public class PublishOrderTest {
    private static IOSDriver<IOSElement> driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        if (driver == null)
            driver = InitializeShipperIOSDriver.init();
    }

    @Test
    public void execute() {
        //城际订单发货
         ShipperLogin.loginByPassword(driver);
        CJPublishOrder.publish(driver);
    }
}
