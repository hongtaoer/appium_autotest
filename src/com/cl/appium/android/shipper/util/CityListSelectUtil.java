package com.cl.appium.android.shipper.util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class CityListSelectUtil {
	// 城市选择出发地（城际）
	public static void startCJCityListSelect(AndroidDriver<MobileElement> driver) {
		cityListSelect(driver, "北京", null, "海淀");
	}

	// 城市选择目的地
	public static void endCJCityListSelect(AndroidDriver<MobileElement> driver) {
		cityListSelect(driver, "天津", null, "和平");
	}

	// 城市选择出发地（城内）
	public static void startCNCityListSelect(AndroidDriver<MobileElement> driver) {
		cityListSelect(driver, "上海", null, "闵行");
	}

	// 城市选择目的地
	public static void endCNCityListSelect(AndroidDriver<MobileElement> driver) {
		cityListSelect(driver, "上海", null, "宝山");
	}

	/**
	 * 根据传入的城市名称选择城市
	 * 
	 * @param driver
	 * @param first
	 *            一级地址名称
	 * @param second
	 *            二级地址名称 直辖市为null
	 * @param third
	 *            三级地址名称
	 */
	public static void cityListSelect(AndroidDriver<MobileElement> driver, String first, String second, String third){

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//
		// 点击所在地区(发货)
		driver.findElement(By.id("com.topjet.shipper:id/tv_deliver_palce")).click();

		if (first.contains("北京") || first.contains("上海") || first.contains("天津") || first.contains("重庆")) {
             //用参数代替可变的字符串
			driver.findElementByXPath(String.format( "//*[@text=\"%s\"]", first )).click();
			driver.findElementByXPath(String.format("//*[@text=\"%s\"]", third)).click();

		} else {

			driver.findElementByXPath(String.format("//*[@text=\"%s\"]", first)).click();
			driver.findElementByXPath(String.format("//*[@text=\"%s\"]", second)).click();
			driver.findElementByXPath(String.format( "//*[@text=\"%s\"]", third )).click();

		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);// 等待20秒钟
		// 获取详细地址
		driver.findElement(By.id("com.topjet.shipper:id/tv_deliver_palce_detail")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementsByClassName("android.widget.ImageView").get(4).swipe(SwipeElementDirection.LEFT, 1);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("com.topjet.shipper:id/tv_ok_cancel")).click();
	}

}
