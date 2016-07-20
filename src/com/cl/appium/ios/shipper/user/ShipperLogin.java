package com.cl.appium.ios.shipper.user;


import com.cl.appium.ios.shipper.util.SystemTipsCheck;

import io.appium.java_client.ios.IOSDriver;

import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;


import java.util.concurrent.TimeUnit;

/**
 * Created by chenliu on 16/6/25.
 * 货主版登陆
 */
public class ShipperLogin {
    public static void loginByPassword(IOSDriver<IOSElement> driver) {

        try {
            //启动页面判断是否有系统推送通知
            if (SystemTipsCheck.checkPositon(driver)) {
                driver.findElementByXPath("//UIAApplication[1]/UIAWindow[7]/UIAAlert[1]/UIACollectionView[1" +
                        "]/UIACollectionCell[2]").click();
                if (SystemTipsCheck.checkNotification(driver)) {
                    driver.findElementByXPath
                            ("//UIAApplication[1]/UIAWindow[7]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1" +
                                    "]").click();
                }
            }
            //判断是否在登录页面   判断登录页面
//            if (LoginUICheck.checkLogin(driver)) {

            //输入用户手机号
            driver.findElement(By.id("(_navigationTransitionView)(_scrollView)(_userPhoneLeftTf)")).setValue("18602108194");
            //输入密码
            driver.findElement(By.id("(_navigationTransitionView)(_scrollView)(_passwordTf)")).setValue("112233");
            //点击登录
            driver.findElement(By.id("(_navigationTransitionView)(_scrollView)(_loginLeftButt)")).click();

            //等待5秒
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//            }
//            else {
//                System.out.printf("用户已处于登录状态");
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            //判断登录到首页是否
            IOSElement adCloseButton = driver.findElement(By.id("(empty stringdeba35ea8b49f232911f94d62f16b822)"));
            if (adCloseButton.isDisplayed()) {
                adCloseButton.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("登录失败!" + e.getMessage());
        }
    }
    }












