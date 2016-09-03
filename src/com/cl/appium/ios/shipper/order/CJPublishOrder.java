package com.cl.appium.ios.shipper.order;

        import com.cl.appium.common.log.Log;
        import io.appium.java_client.SwipeElementDirection;
        import io.appium.java_client.TouchAction;
        import io.appium.java_client.ios.IOSDriver;
        import io.appium.java_client.ios.IOSElement;
        import org.openqa.selenium.By;
        import org.slf4j.Logger;

        import java.util.concurrent.TimeUnit;

/**
 * Created by pengtao on 6/17/16.
 */
public class CJPublishOrder {

    private static final Logger LOG = Log.getLog(CJPublishOrder.class);
    public static void publish(IOSDriver<IOSElement> driver) {
        LOG.info("iOS货主版开始发布城际订单:");
        try {
            //点击我要发货按钮
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAScrollView[1]/UIAElement[1]/UIAElement[1]/UIAButton[2][@name = '(_navigationTransitionView)(_myScrollView)(_bgView)(_topView)(empty string)']")).click();
            //等待2秒
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            //点击选填发货信息(_navigationTransitionView)
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[1]/UIAElement[1]/UIAElement[1" +
                    "]/UIAElement[1]/UIAElement[1][@name = '(_navigationTransitionView)']")).click();
            //选择出发地所在地区(_navigationTransitionView)(_topBackView)
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAElement[1" +
                    "]/UIAElement[1][@name='(_navigationTransitionView)(_topBackView)']")).click();

            //等待2秒
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            //选择地址上海(empty string)(_collectionView)
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]/UIAElement[1]/UIACollectionView[1" +
                    "]/UIACollectionCell[2][@name='(empty string)(_collectionView)']")).click();
            //等待1秒
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            //选择浦东新区(empty string)(_collectionView)
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]/UIAElement[1]/UIACollectionView[1" +
                    "]/UIACollectionCell[6][@name='(empty string)(_collectionView)']")).click();
            //等待1秒
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            //点击选择详细地址(_navigationTransitionView)(_topBackView)
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAElement[1" +
                    "]/UIAElement[2][@name='(_navigationTransitionView)(_topBackView)']")).click();

            //等待5秒
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            //选择地图聚焦点,并移动获取详细地址

            driver.findElement(By.id("NearbyTruck_centerLocation")).swipe(SwipeElementDirection.UP, 1);

            //等待3秒
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

            // 点击确定按钮选择选择详细信息
            driver.findElement(By.id("(_searchBackView)(_closeSureBtn)")).click();

            //输入发货联系人
            driver.findElement(By.id("(_navigationTransitionView)(_topBackView)(_contactNameTextField)")).setValue("陈柳");

            // 点击确定按钮
            driver.findElement(By.id("(_navigationTransitionView)(_sureButton)")).click();

            //等待2秒
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            //点击[选填收货信息]
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAElement[2]")).click();

            //等待2秒
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            //点击所在地区弹出城市选择列表
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[1]/UIAElement[1]/UIAElement[1" +
                    "]/UIAElement[1]/UIAElement[1][@name='(_navigationTransitionView)(_topBackView)']")).click();

            //等待1秒
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            //选择北京
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]/UIAElement[1]/UIACollectionView[1" +
                    "]/UIACollectionCell[1][@name='(empty string)(_collectionView)']")).click();

            //选择海淀
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]/UIAElement[1]/UIACollectionView[1" +
                    "]/UIACollectionCell[4][@name='(empty string)(_collectionView)']")).click();

            //等待1秒
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            //点击详细地址进入详细地址选择地图界面(_navigationTransitionView)(_topBackView)
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAElement[2]")).click();

            //等待5秒,等待地图加载完毕
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            //选择地图聚焦点,并移动获取详细地址
            driver.findElement(By.id("NearbyTruck_centerLocation")).swipe(SwipeElementDirection.DOWN, 1);

            //等待5秒,等待地图加载完毕
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            //点击确定按钮选择完详细目的地填写
            driver.findElement(By.id("(_searchBackView)(_closeSureBtn)")).click();

            //等待1秒
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            //输入收货联系人
            driver.findElement(By.id("(_navigationTransitionView)(_topBackView)(_contactNameTextField)")).setValue("张三");

            //输入收货人联系电话
            driver.findElement(By.id("(_navigationTransitionView)(_topBackView)(_contactMobileTextField)")).setValue("18602108194");

            //点击确定按钮完成收货信息填写(_navigationTransitionView)(_sureButton)
            driver.findElement(By.id("(_navigati onTransitionView)(_sureButton)")).click();

            //等待1秒
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            //点击下一步
            driver.findElement(By.id("(_navigationTransitionView)(38ce27d84639f3a6e07c00b3b4995c0e)")).click();

            //等待2秒
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            //点击选择发货时间
            driver.findElement(By.id("(_navigationTransitionView)(_tableView)(_wrapperView)(_sendGoodsTimeCell)")).click();

            //滑动选择日期
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[2]/UIAPicker[1]/UIAPickerWheel[1]")).swipe(SwipeElementDirection.UP, 2);

            //滑动选择时间
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[2]/UIAPicker[1]/UIAPickerWheel[3]"))
                    .swipe(SwipeElementDirection.UP, 3);

            //点击钩确定时间
            driver.findElement(By.id("(_contentView)(empty string58bcc90b7b2665422a12ce5974395d9f)")).click();

            //点击货物信息
            driver.findElement(By.id("(_navigationTransitionView)(_tableView)(_wrapperView)(_GoodsInfoCell)")).click();

            //等待2秒
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            //填写货物重量
            driver.findElement(By.id("(_navigationTransitionView)(_tableView)(_wrapperView)(_goodsWeightViewCell)(_weightTextField)")).setValue("999");

            //点击进入货物类型选择界面
            driver.findElement(By.id("(_navigationTransitionView)(_tableView)(_wrapperView)(_goodsTypeViewCell)")).click();

            //选择[其它]货物类型
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[2]/UIAButton[26]")).click();

            //等待1秒
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            //点击进入包装方式界面
            driver.findElement(By.id("(_navigationTransitionView)(_tableView)(_wrapperView)(_packTypeViewCell)")).click();

            //等待1秒
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            //选择包装方式[其它]
            driver.findElement(By.id("(_contentView)(5a0afc9dbd6c2e98769d4620d4fb5b13)")).click();

            //等待1秒
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            //点击选择卸货方式
            driver.findElement(By.id("(_navigationTransitionView)(_tableView)(_wrapperView)(_dischargeModeViewCell)")).click();

            //等待1秒
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            //选择一装一卸
            driver.findElement(By.id("(_contentView)(7debea4ee53b014d689f3af235bb49c5)")).click();

            //等待5秒,这里需要等待一段时间才能点击确定按钮,否则报错elementId xx could not be tapped
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            //点击键盘上的[完成按钮]隐藏键盘
          //  driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAElement[1]/UIAToolbar[1]/UIAButton[3" +
                    //"][@name='(_hostView)']")).click();

            //等待5秒,这里需要等待一段时间才能点击确定按钮,否则报错elementId xx could not be tapped
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            //点击确定按钮完成货物信息录入
            driver.findElement(By.id("(_navigationTransitionView)(38cf16f2204ffab8a6e0187070558721)")).click();


            //等待1秒
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            //点击车辆需求进入车型选择界面
            driver.findElement(By.id("(_navigationTransitionView)(_tableView)(_wrapperView)(_truckDemandCell)")).click();

            //等待1秒
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            //选择高低平板车
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIATableView[1]/UIATableCell[7]/UIAStaticText[1]")).click();

            //等待1秒
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            //选择13米长
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIATableView[2]/UIATableCell[2]/UIAStaticText[1]")).click();

            //等待1秒
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            //输入信息费
            driver.findElement(By.id("(_navigationTransitionView)(_tableView)(_wrapperView)(_informationFeeViewCell)(_informationFeeTextField)")).setValue("998");

            //选择付款方式
            driver.findElement(By.id("(_navigationTransitionView)(_tableView)(_wrapperView)(_informationFeeViewCell)(_prePartPayButton)")).click();

            //填写备注
            driver.findElement(By.id("(_navigationTransitionView)(_tableView)(_wrapperView)(_otherDemandViewCell)(_otherDemandTextView)")).setValue("自动化测试发布城际订单");

            //等待5秒,这里需要等待一段时间才能点击确定按钮,否则报错elementId xx could not be tapped
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            //隐藏键盘
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAElement[1]/UIAToolbar[1]/UIAButton[3][@name='(_hostView)']"))
                    .click();

            //等待5秒,这里需要等待一段时间才能点击确定按钮,否则报错elementId xx could not be tapped
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            //点击提交按钮
            driver.findElement(By.id("(_navigationTransitionView)(939d5345ad4345dbaabe14798f6ac0f1)")).click();

            //等待5秒 进入托管运费授权界面
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            //点击[托管运费]按钮
            driver.findElement(By.id("(_navigationTransitionView)(20f4b74eae082e9788677f424ad4dba8)")).click();

            //等待5秒 进入托管运费授权界面
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            //进入等待竞价界面 判断起点图标存在
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAImage[2" +
                    "][@name='GrabOrder_start']")).isDisplayed();

            //判断订单详情按钮存在
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[1]/UIAElement[1]/UIAElement[1]/UIAElement" +
                    "[3][@name='(_navigationTransitionView)']")).isDisplayed();
            LOG.info("IOS货主版完成发布城际订单:");
        } catch (Exception e) {
            LOG.error("============发布城际货源流程失败,请校验!================", e.getMessage());
            e.printStackTrace();
        }

    }
}
