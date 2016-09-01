package com.appium.test.android.shipper;

import com.cl.appium.android.shipper.order.CJPublishOrder;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.BeforeClass;
import org.junit.Test;

public class PublishOrderTest {

	private static AndroidDriver<AndroidElement> driver;

	@BeforeClass
	public static void beforeClass() throws Exception {
		if (driver == null)
			driver = InitializeShipperAndroidDriver.init();
	}

	@Test
	public void execute() {
        //城际订单发货
        CJPublishOrder.publish(driver);
		//城内订单发货
		//CNPublishOrder.publish(driver);
        
	}
}
