package com.cl.appium.ios.shipper.util;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

/**
 * Created by chenliu on 16/6/25.
 */
public class SystemTipsCheck {
    //首次安装判断是否弹出系统提示框(打开货主版是否开启定位服务)不开启
    public static boolean checkPositon(IOSDriver<IOSElement> driver){
        try {
            if(driver.findElementByXPath("//UIAApplication[1]/UIAWindow[7]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]").isDisplayed())
                return true;
        }
        catch (Exception e)
        {
            return false;
        }

        return false;
    }
    //首次安装判断是否弹出系统提示框(打开货主版是否开启推送通知)不允许
    public static boolean checkNotification(IOSDriver<IOSElement> driver){
        try {
           // driver.findElementByXPath("//UIAApplication[1]/UIAWindow[7]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]\")//好
            if (driver.findElementByXPath("//UIAApplication[1]/UIAWindow[7]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]").isDisplayed())
                return true;
        }
        catch (Exception e)
        {
            return false;
        }
        return false;
    }
}
