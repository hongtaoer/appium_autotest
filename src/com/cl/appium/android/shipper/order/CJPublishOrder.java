package com.cl.appium.android.shipper.order;

import com.cl.appium.android.shipper.user.ShipperLogin;
import com.cl.appium.android.shipper.util.CityListSelectUtil;
import com.cl.appium.common.log.Log;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * 貨主版發佈貨源功能(城际订单)
 * 
 * @author bjbpc026
 *
 */
public class CJPublishOrder {
	private static final Logger LOG = Log.getLog(CJPublishOrder.class);

	public static void publish(AndroidDriver<MobileElement> driver) {

		LOG.info("安卓系统货主版开始发布城际订单:");
		try {
//			// 首先用【首页】按钮判断用户是否已登录，若未登录先登录才能发布货源
//			if (HomeButtonCheckUtil.isShipperHomeButtonExist(driver)) {
//				MobileElement homeButton = driver.findElementById("com.topjet.shipper:id/rb_home");
//				homeButton.click();
//			} else {
			ShipperLogin.loginByPassword(driver);
//			}

			// 找到发布货源的按钮并点击
			driver.findElementById("com.topjet.shipper:id/ll_auto_search_goods").click();

			// 判断是否跳转到发布货源页面
			Assert.assertTrue("forward failed", driver.findElementById("com.topjet.shipper:id/tv_from").isDisplayed());
			// 出发地
			MobileElement startAddress = driver.findElementsByClassName("android.widget.TextView").get(1);
			startAddress.click();
			//调用发货地
			CityListSelectUtil.startCJCityListSelect(driver);

//			//点击定位
			//driver.findElementsByClassName("android.widget.ImageView").get(8).click();
     		driver.findElementById("com.topjet.shipper:id/btn_sure").click();//确定按钮
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//
			//收货地
			driver.findElement(By.id("com.topjet.shipper:id/tv_to")).click();
		    //调用收货地城市选择和地图
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//
			CityListSelectUtil.endCJCityListSelect(driver);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//
			//输入姓名和手机号
			driver.findElement(By.id("com.topjet.shipper:id/et_deliver_name")).sendKeys("xiaochen");
			driver.findElement(By.id("com.topjet.shipper:id/et_deliver_phone")).sendKeys("18888888888");
	
			
			//常用联系人
//			driver.findElement(By.id("com.topjet.shipper:id/tv_title_bar_right")).click();
//			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//			//选择联系人
//			driver.findElement(By.id("com.topjet.shipper:id/rl_listitem")).click();
			
     		driver.findElement(By.id("com.topjet.shipper:id/btn_sure")).click();
			//点击下一步
			driver.findElement(By.id("com.topjet.shipper:id/btn_next")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//断言 （判断是否跳转到订单录入页面）
     		Assert.assertTrue("page forward failed", driver.findElementById("com.topjet.shipper:id/tv_title_bar_title")
				.isDisplayed());
         
			//进入订单录入页面 选择发货时间
			driver.findElement(By.id("com.topjet.shipper:id/tv_deliver_date")).click();
	       //driver.findElement(By.id("com.topjet.shipper:id/wheel_hour")).swipe(SwipeElementDirection.DOWN, 20);
			driver.findElement(By.id("com.topjet.shipper:id/time_wheel_ok")).click();
			driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
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
			driver.findElement(By.id("com.topjet.shipper:id/tv_TruckSelectOutCity")).click();
			Assert.assertTrue("page forward failed", driver.findElementById("com.topjet.shipper:id/tv_title_bar_title").isDisplayed());
		    //选择车型
			driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget" +
					".FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget" +
					".LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[1]").click();
			driver.findElementByXPath(" //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget" +
					".FrameLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget" +
					".LinearLayout[1]/android.widget.ListView[2]/android.widget.LinearLayout[2]/android.widget" +
					".LinearLayout[1]/android.widget.TextView[1]").click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//页面跳转到订单录入页面等待三秒钟
			//输入信息费
			driver.findElement(By.id("com.topjet.shipper:id/et_jiage")).sendKeys("200");
			//选择不同的运费方式
			driver.findElementsByClassName("android.widget.CheckBox").get(0).click();//选择提付全款
			//driver.findElement(By.id("com.topjet.shipper:id/cb1")).click();//提付部分运费
			//driver.findElement(By.id("com.topjet.shipper:id/cb3")).click();//货到付款
			//driver.findElement(By.id("com.topjet.shipper:id/cb2")).click();//回单付运费
			//找到提交按钮并点击
			driver.findElement(By.id("com.topjet.shipper:id/btn")).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);//页面跳转到是否托管运费页面等待三秒钟
			//断言页面是否跳转到是否托管运费页面
			Assert.assertTrue("page forward failed", driver.findElementById("com.topjet.shipper:id/tv_title_bar_title").isDisplayed());
			//找到托管运费并点击
			driver.findElement(By.id("com.topjet.shipper:id/btn_deposit")).click();
			//driver.findElement(By.id("com.topjet.shipper:id/btn_not_deposit")).click();不托管运费
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//判断页面是否跳转至等待竞价页面
			Assert.assertTrue("page forward failed", driver.findElementById("com.topjet.shipper:id/tv_title_bar_title").isDisplayed());

			LOG.info("安卓系统货主版完成发布城际订单:");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error("安卓系统货主版发布城际订单失败:\n" + e.getMessage());
			e.printStackTrace();
		}

	}

}
