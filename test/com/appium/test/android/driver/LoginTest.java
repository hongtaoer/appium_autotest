package com.appium.test.android.driver;


import com.cl.appium.android.driver.user.DriverLogin;
import com.cl.appium.common.log.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;

public class LoginTest {
	private static AndroidDriver<AndroidElement> driver;
	private static Logger LOG = Log.getLog(LoginTest.class);

	// 启动app时 就相当于创建了一个session

	@BeforeClass
	public static void beforeClass() throws Exception {

		driver = InitializeDriverAndroidDriver.init();

	}
	
	@Test
	public void login(){
		DriverLogin.loginByPassword(driver);
	}

	@AfterClass
	public static void afterClass() {
		if (driver != null) {
			driver.quit();
		}
	}
}
