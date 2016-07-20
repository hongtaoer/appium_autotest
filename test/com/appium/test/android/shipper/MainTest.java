package com.appium.test.android.shipper;

import com.appium.test.android.driver.InitializeDriverAndroidDriver;
import com.cl.appium.android.shipper.order.CJPublishOrder;
import com.cl.appium.android.shipper.user.ShipperLogin;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {

	private static AndroidDriver<MobileElement> driver;

	// 启动app时 就相当于创建了一个session

	@BeforeClass
	public static void beforeClass() throws Exception {
		if(driver==null)
		driver = InitializeDriverAndroidDriver.init(); 
	}
	
	@Test
	public void execute(){
		ShipperLogin.loginByPassword(driver);
		CJPublishOrder.publish(driver);
	}
	
	
	@AfterClass
	public static void afterClass() {
		if (driver != null) {
			driver.quit();
		}
	}
}
