package com.cl.appium.android.shipper.user;

import com.cl.appium.android.shipper.util.HomeButtonCheckUtil;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PersonalCenter {
	public static void personal(AndroidDriver<MobileElement> driver){
		try {
			// 首先用【首页】按钮判断用户是否已登录，若未登录先登录才能发布货源
			if (HomeButtonCheckUtil.isShipperHomeButtonExist(driver)) {
				MobileElement homeButton = driver.findElementById("com.topjet.shipper:id/rb_home");
				homeButton.click();
			} else {
				ShipperLogin.loginByPassword(driver);
			}	
			
			//找到个人中心的按钮
			//driver.findElementById("")
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
