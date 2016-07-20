package com.cl.appium.ios.shipper.util;

/**
 * Created by chenliu on 16/7/2.
 */
public class CommonUtil {
    //查找控件获取xpath和name的方法
    public static String getXpathWithname(String Xpath, String name) {
        String xpathWithName = Xpath + "[@name=" + "'" + name + "']";
        return xpathWithName;
    }

}
