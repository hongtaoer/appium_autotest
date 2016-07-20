package com.cl.appium.ios.shipper.util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by chenliu on 16/6/25.
 * 判断页面是否存在登录的button按钮
 */
public class LoginUICheck {
   // public static boolean checkLogin(IOSDriver<MobileElement> driver) {
//        try {
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//            if (driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]").isDisplayed()) {
////                try {
////                driver.findElementByName("登录").isDisplayed();
////            } catch (Exception e) {
////                System.out.println("不能找到登录按钮.");
////                return true;
////            }
////            try {
////
////                driver.findElementByName("密码登录").isDisplayed();
////            } catch (Exception e) {
////                System.out.println("不能找到密码登录tab.");
////                return true;
////            }
//            return true;
//        }
//
//        } catch (Exception e1) {
//            return false;
//        }
//
//        return false;
//    }
    //判断是否在首页页面(使用广告页判断)
//    public static boolean checkHomeButton(IOSDriver<MobileElement> driver){
//        try {
//            if(driver.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAElement[2]").isDisplayed())
//                return true;
//        }
//        catch (Exception e)
//        {
//            return false;
//        }
//
//        return false;
//    }
}
