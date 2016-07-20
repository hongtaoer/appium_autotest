package com.appium.test.android.shipper;

import com.cl.appium.android.shipper.user.ShipperLogin;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 测试货主版登陆
 * 
 * @author bjbpc026
 *
 */
public class LoginTest {

	private static AndroidDriver<MobileElement> driver;

	// 启动app时 就相当于创建了一个session

	@BeforeClass
	public static void beforeClass() throws Exception {
		driver = InitializeShipperAndroidDriver.init(); 
	}
	
	@Test
	public void login(){
		ShipperLogin.loginByPassword(driver);
	}
	
	
	@AfterClass
	public static void afterClass() {
		if (driver != null) {
			driver.quit();
		}
	}
}
