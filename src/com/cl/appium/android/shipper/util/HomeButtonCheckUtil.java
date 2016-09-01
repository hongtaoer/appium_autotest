package com.cl.appium.android.shipper.util;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomeButtonCheckUtil {

	//判断首页是否存在首页按钮
	public static boolean isShipperHomeButtonExist(AndroidDriver<AndroidElement> driver){
		
		try {
			if (driver.findElementById("com.topjet.shipper:id/rb_home").isDisplayed()) return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}
