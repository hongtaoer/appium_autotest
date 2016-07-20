package com.appium.test.android.driver;


import com.cl.appium.android.driver.user.DriverLogin;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginTest {
	private static AndroidDriver<MobileElement> driver;

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
