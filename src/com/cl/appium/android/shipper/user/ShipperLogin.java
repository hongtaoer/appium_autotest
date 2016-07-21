package com.cl.appium.android.shipper.user;

import com.cl.appium.common.log.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

public class ShipperLogin {

    private static final Logger LOG = Log.getLog(ShipperLogin.class);

    public static void loginByPassword(AndroidDriver<MobileElement> driver) {

        LOG.info("安卓系统货主版开始登陆");
        try {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            // 找到货主版并点击
//			driver.startActivity("com.topjet.shipper", "com.topjet.shipper.ui.activity.V3_LoginActivity");
//			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            //	System.out.println("============" + driver.currentActivity());
//			assertEquals(driver.currentActivity(), ".ui.activity.V3_LoginActivity");// 断言

            // 使用list找到文本框
            driver.findElementById("com.topjet.shipper:id/et_login_username").sendKeys("18602108194");
            driver.findElementById("com.topjet.shipper:id/et_login_pwd").sendKeys("112233");
            driver.findElementById("com.topjet.shipper:id/btn_login").click();

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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

    // public static void loginByCode() {
    //
    // }
}
