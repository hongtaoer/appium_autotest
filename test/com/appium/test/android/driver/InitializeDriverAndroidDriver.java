package com.appium.test.android.driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class InitializeDriverAndroidDriver {

	public static AndroidDriver<MobileElement> init(){
		 AndroidDriver<MobileElement> driver = null;
		try {
			// 创建文件夹，设置apk的路径
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "apps");
			File appShipper = new File(appDir, "Driver_test.apk");// 司机版

			DesiredCapabilities capabilities2 = new DesiredCapabilities();
			capabilities2.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.4.16");
			capabilities2.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.3");// 设置安卓的系统版本
			capabilities2.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities2.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
			capabilities2.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);

			capabilities2.setCapability(MobileCapabilityType.APP, appShipper.getAbsolutePath());


			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4725/wd/hub"), capabilities2);// 若存在错误则抛出异常
			// 对上面的设置是否成功进行断言
			Capabilities caps = driver.getCapabilities();

			assertEquals(true, caps.getCapability(MobileCapabilityType.AUTOMATION_NAME).equals(AutomationName.APPIUM));
			assertEquals(true, caps.getCapability(MobileCapabilityType.PLATFORM_NAME).equals(MobilePlatform.ANDROID));
			assertNotEquals(null, caps.getCapability(MobileCapabilityType.DEVICE_NAME));
			assertEquals(true, caps.getCapability(MobileCapabilityType.APP).equals(appShipper.getAbsolutePath()));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return driver;
	}
}
