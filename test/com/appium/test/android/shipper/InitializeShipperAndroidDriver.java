package com.appium.test.android.shipper;

import com.cl.appium.common.log.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class InitializeShipperAndroidDriver {
	private static Logger LOG= Log.getLog(InitializeShipperAndroidDriver.class);
	public static AndroidDriver<AndroidElement> init(){
		LOG.info("========登录测试初始化驱动器=====");
		 AndroidDriver<AndroidElement> driver = null;
		try {
			// 创建文件夹，设置apk的路径
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "apps");
			File appShipper = new File(appDir, "560Shipper_v200_test.apk");// 司机版

			DesiredCapabilities capabilities2 = new DesiredCapabilities();
			capabilities2.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.5.3");
			capabilities2.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");// 设置安卓的系统版本
			capabilities2.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities2.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
			capabilities2.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
			capabilities2.setCapability(MobileCapabilityType.APP, appShipper.getAbsolutePath());
			capabilities2.setCapability(MobileCapabilityType.FULL_RESET, true);//删除整个模拟器目录
			capabilities2.setCapability(MobileCapabilityType.NO_RESET, false);//不要在会话前重置会话状态

			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities2);// 若存在错误则抛出异常
			// 对上面的设置是否成功进行断言
			Capabilities caps = driver.getCapabilities();

			assertEquals(true, caps.getCapability(MobileCapabilityType.AUTOMATION_NAME).equals(AutomationName.APPIUM));
			assertEquals(true, caps.getCapability(MobileCapabilityType.PLATFORM_NAME).equals(MobilePlatform.ANDROID));
			assertNotEquals(null, caps.getCapability(MobileCapabilityType.DEVICE_NAME));
			assertEquals(true, caps.getCapability(MobileCapabilityType.APP).equals(appShipper.getAbsolutePath()));

		} catch (Exception e) {
			LOG.error("========登录测试初始化驱动器出现异常=====" + e.getMessage());
			e.printStackTrace();
		}
		LOG.info("========登录测试初始化驱动器成功=====");
		return driver;
	}
}
