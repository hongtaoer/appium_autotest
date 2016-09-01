package com.cl.appium.android.shipper.order;

import com.cl.appium.android.shipper.user.ShipperLogin;
import com.cl.appium.android.shipper.util.CityListSelectUtil;
import com.cl.appium.common.log.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

public class CNPublishOrder {

    private static final Logger LOG = Log.getLog(CNPublishOrder.class);

    /**
     * 货主版发布货源（城内订单）
     *
     * @param driver
     */

    public static void publish(AndroidDriver<AndroidElement> driver) {
        LOG.info("安卓系统货主版开始发布城内订单:");
        try {
            // 判断app是否已登录
//			if (HomeButtonCheckUtil.isShipperHomeButtonExist(driver)) {
//				MobileElement homeButton = driver.findElementById("com.topjet.shipper:id/rb_home");
//				homeButton.click();
//			} else {
            ShipperLogin.loginByPassword(driver);
            //}
            // 找到发布货源的按钮并点击
            driver.findElementById("com.topjet.shipper:id/ll_auto_search_goods").click();
            // 判断是否跳转到发布货源页面
            Assert.assertTrue("forward failed", driver.findElementById("com.topjet.shipper:id/tv_from").isDisplayed());
            // 出发地
            MobileElement startAddress = driver.findElementsByClassName("android.widget.TextView").get(1);
            startAddress.click();
            //调用城内发货地
            CityListSelectUtil.startCNCityListSelect(driver);
            driver.findElementById("com.topjet.shipper:id/btn_sure").click();//确定按钮

            //收货地
            driver.findElement(By.id("com.topjet.shipper:id/tv_to")).click();
            //调用城内收货地
            CityListSelectUtil.endCNCityListSelect(driver);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//跳转至收货地页面等待三秒钟
            //输入姓名和手机号
            driver.findElement(By.id("com.topjet.shipper:id/et_deliver_name")).sendKeys("xiaochen");
            driver.findElement(By.id("com.topjet.shipper:id/et_deliver_phone")).sendKeys("18888888888");

            driver.findElement(By.id("com.topjet.shipper:id/btn_sure")).click();
            //点击下一步
            driver.findElement(By.id("com.topjet.shipper:id/btn_next")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            //断言 （判断是否跳转到订单录入页面）
            Assert.assertTrue("page forward failed", driver.findElementById("com.topjet.shipper:id/tv_title_bar_title").isDisplayed());
            //进入订单录入页面 选择发货时间
            driver.findElement(By.id("com.topjet.shipper:id/tv_deliver_date")).click();
            driver.findElement(By.id("com.topjet.shipper:id/time_wheel_ok")).click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            //点击货物信息选项
            driver.findElement(By.id("com.topjet.shipper:id/tv_goodsinfo")).click();
            //选择货物类型
            //driver.findElement(By.id("com.topjet.shipper:id/tv_goods_type")).click();

            //断言是否跳转到货物信息页面
            Assert.assertTrue("page forward failed", driver.findElementById("com.topjet.shipper:id/tv_title_bar_title").isDisplayed());
            //输入重量和体积
            driver.findElements(By.className("android.widget.EditText")).get(0).sendKeys("12.12");
            driver.findElement(By.id("com.topjet.shipper:id/et_volume")).sendKeys("20.11");
            //点击确定按钮并点击
            driver.findElement(By.id("com.topjet.shipper:id/btn_submit")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//跳转页面等待5秒钟
            //找到并点击车辆需求
            driver.findElement(By.id("com.topjet.shipper:id/tv_TruckSelectCityInside")).click();
            Assert.assertTrue("page forward failed", driver.findElementById("com.topjet.shipper:id/tv_title_bar_title").isDisplayed());

            //选择车型(面包车)
            driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]").click();
            driver.findElement(By.id("com.topjet.shipper:id/btn_sunmit")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//页面跳转到订单录入页面等待三秒钟
            //运费报价
            driver.findElement(By.id("com.topjet.shipper:id/et_jiage")).clear();
            driver.findElement(By.id("com.topjet.shipper:id/et_jiage")).sendKeys("500");
            //填写特殊需求
            //driver.findElement(By.id("com.topjet.shipper:id/et_textRemark")).sendKeys("发货信息属实");
            //点击提交按钮
            driver.findElement(By.id("com.topjet.shipper:id/btn")).click();
            LOG.info("安卓系统货主版完成发布城内订单:");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            LOG.error("安卓系统货主版发布城内订单失败:\n" + e.getMessage());
            e.printStackTrace();
        }
    }

}
