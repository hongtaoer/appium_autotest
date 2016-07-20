package com.cl.appium.android.shipper.user;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

public class ShipperLogin {

	public static void loginByPassword(AndroidDriver<MobileElement> driver) {
		try {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			// 找到货主版并点击
//			driver.startActivity("com.topjet.shipper", "com.topjet.shipper.ui.activity.V3_LoginActivity");
//			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//	System.out.println("============" + driver.currentActivity());
//			assertEquals(driver.currentActivity(), ".ui.activity.V3_LoginActivity");// 断言

			// 使用list找到文本框
			driver.findElementById("com.topjet.shipper:id/et_login_username").sendKeys("18602108194");
			driver.findElementById("com.topjet.shipper:id/et_login_pwd").sendKeys("112233");
			driver.findElementById("com.topjet.shipper:id/btn_login").click();

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			// Assert.assertTrue("登陆失败"
			// ,driver.findElementByAndroidUIAutomator("new
			// UiSelector().resourceId(\"com.topjet.shipper:id/ll_publish_goods_source\")").isDisplayed());

//			Assert.assertTrue("login failed",
//					driver.findElementById("com.topjet.shipper:id/ll_auto_search_goods").isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public static void loginByCode() {
	//
	// }
}
