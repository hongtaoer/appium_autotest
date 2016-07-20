package com.cl.appium.android.driver.order;

import com.cl.appium.android.driver.user.DriverLogin;
import com.cl.appium.android.driver.util.CityListSelectAndDriverTruckUtil;
import com.cl.appium.android.driver.util.HomeButtonCheckUtil;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class FindGoods {
	/**
	 * 智能找货
	 * 
	 * @param driver
	 */
	public static void capacityFindgoods(AndroidDriver<MobileElement> driver) {
		// 首先用【首页】按钮判断用户是否已登录，若未登录先登录才能在首页点击智能找货
		if (HomeButtonCheckUtil.isDriverHomeButtonExist(driver)) {
			driver.findElement(By.id("com.topjet.crediblenumber:id/rb_home")).click();
		} else {
			DriverLogin.loginByPassword(driver);
		}

		// 找到智能找货按钮并点击
		driver.findElement(By.id("com.topjet.crediblenumber:id/ll_auto_search_goods")).click();
        //断言判断是否跳转至智能找货页面(如果后面条件为false ，则抛出错误信息)
	    Assert.assertFalse("forward failed", driver.findElementById("com.topjet.crediblenumber:id/tv_title_bar_title").isDisplayed());
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//跳转至智能找货页面等待三秒钟
	    //选择出发地为上海宝山的货源
	    driver.findElement(By.id("com.topjet.crediblenumber:id/ll_depart")).click();
	    CityListSelectAndDriverTruckUtil.startDepart(driver);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//跳转至智能找货页面等待五秒钟
	   if(driver.findElementsByName("android.widget.LinearLayout").contains("上海市  宝山区"))
	   {
		   driver.findElement(By.id("com.topjet.crediblenumber:id/tv_is_inner")).findElement(By.name("竞价")).click();
	   }
	   else 
	   {
//		   driver.findElementsByName("android.widget.LinearLayout").get(7).click();//默认找到页面第一笔订单
//		   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//
		   return;
	   }
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//跳转至订单详情页面
	    //选择保价金额
	    driver.findElement(By.id("com.topjet.crediblenumber:id/et_my_bidding")).sendKeys("10000");
	    	
	    
	}
}
