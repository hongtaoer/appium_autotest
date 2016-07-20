package com.cl.appium.android.driver.util;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CityListSelectAndDriverTruckUtil {
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
	public static void cityListSelect(AndroidDriver<MobileElement> driver, String first, String second, String third) {

		if (first.contains("北京") || first.contains("上海") || first.contains("天津") || first.contains("重庆")) {
			driver.findElementByName(first).click();
			driver.findElementByName(third).click();
		} else {
			driver.findElementByName(first).click();
			driver.findElementByName(second).click();
			driver.findElementByName(third).click();
		}
	}
	
	//选择出发地
	public static void startDepart(AndroidDriver<MobileElement> driver)
	{
		cityListSelect(driver,"上海",null,"宝山");
	}
	//选择目的地
	public static void endDestination(AndroidDriver<MobileElement> driver)
	{
		cityListSelect(driver,"天津",null,"武清");
	}
	//手动选择车型车长
	public static void driverTruckLength(AndroidDriver<MobileElement> driver)
	{
	    
	}
	

}
