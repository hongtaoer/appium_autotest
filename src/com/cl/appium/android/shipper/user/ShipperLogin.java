package com.cl.appium.android.shipper.user;

import com.cl.appium.common.log.Log;
import com.cl.appium.common.util.CommonUtil;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

public class ShipperLogin {

    private static final Logger LOG = Log.getLog(ShipperLogin.class);

    public static void loginByPassword(AndroidDriver<AndroidElement> driver) {

        LOG.info("安卓系统货主版开始登陆");
        try {

            // 找到货主版并点击
//			driver.startActivity("com.topjet.shipper", "com.topjet.shipper.ui.activity.V3_LoginActivity");
//			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            //	System.out.println("============" + driver.currentActivity());
//			assertEquals(driver.currentActivity(), ".ui.activity.V3_LoginActivity");
            //启动APP后判断是否弹出读取位置信息的系统(允许按钮)
//            if(driver.findElementById("com.huawei.systemmanager:id/btn_allow").isDisplayed())
//            {
//                driver.findElementById("com.huawei.systemmanager:id/btn_allow").click();
//            }
            //启动前找到该页面等待三秒
            CommonUtil.WaitForElementPresentById("com.topjet.shipper:id/rl_guide1", 3, driver);
            //启动APP并滑动导航栏

//            TouchAction action = new TouchAction(driver);
//            action.press(0, 0).moveTo(60, 720).release().perform();
            swipeToLeft(driver,1000);
            CommonUtil.WaitForElementPresentById("com.topjet.shipper:id/rl_guide2", 3, driver);
            swipeToLeft(driver,1000);
            CommonUtil.WaitForElementPresentById("com.topjet.shipper:id/rl_guide3", 3, driver);
            swipeToLeft(driver,1000);
            CommonUtil.WaitForElementPresentById("com.topjet.shipper:id/btn_guide", 3, driver);
            driver.findElementById("com.topjet.shipper:id/btn_guide").click();
            //用户名手机号出来前5秒等待
            CommonUtil.WaitForElementPresentById("com.topjet.shipper:id/et_login_username", 3, driver);

            driver.findElementById("com.topjet.shipper:id/et_login_username").setValue("18602108194");
            driver.findElementById("com.topjet.shipper:id/et_login_pwd").setValue("112233");
            driver.findElementById("com.topjet.shipper:id/btn_login").click();


            LOG.info("安卓系统货主版完成登陆");
            // Assert.assertTrue("登陆失败"
            // ,driver.findElementByAndroidUIAutomator("new
            // UiSelector().resourceId(\"com.topjet.shipper:id/ll_publish_goods_source\")").isDisplayed());

//			Assert.assertTrue("login failed",
//					driver.findElementById("com.topjet.shipper:id/ll_auto_search_goods").isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("安卓系统货主版登录失败:\n" + e.getMessage());
        }
    }

        //向左移动
    public static void swipeToLeft(AndroidDriver driver, int during){
        try {
            int width = driver.manage().window().getSize().width;
            int height = driver.manage().window().getSize().height;
            driver.swipe(width * 3 / 4, height / 2, width / 16, height / 2, during);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
