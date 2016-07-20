package com.cl.appium.android.driver.user;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class DriverLogin {

	public static void loginByPassword(AndroidDriver<MobileElement> driver) {
		try {
			// 找到司機版并点击
			driver.startActivity("com.topjet.crediblenumber", "com.topjet.common.ui.activity.LauncherActivity");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			System.out.println("================" +driver.currentActivity() );
     		assertEquals(driver.currentActivity(), ".ui.activity.V3_LoginActivity");// 断言

			// 点击密码登陆
			driver.findElementById("com.topjet.crediblenumber:id/rb_loginpwd").click();
			// 若找不到密码登陆的按钮则抛出断言函数
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Assert.assertTrue("no found loginpwd",
					driver.findElementById("com.topjet.crediblenumber:id/rb_loginpwd").isDisplayed());
			// 找到手机号和密码
			driver.findElementById("com.topjet.crediblenumber:id/et_login_username").sendKeys("18986254173");
			driver.findElementById("com.topjet.crediblenumber:id/et_login_pwd").sendKeys("112233");
			driver.findElement(By.id("com.topjet.crediblenumber:id/btn_login")).click();
			// 设置等待时间为5秒
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			// 若不存在智能找货 则抛出断言函数
			Assert.assertTrue("login failed",
					driver.findElementById("com.topjet.crediblenumber:id/ll_auto_search_goods").isDisplayed());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public static void loginByCode() {
	//
	// }
}
