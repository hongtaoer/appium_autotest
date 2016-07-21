package com.cl.appium.common.log;

import org.apache.log4j.HTMLLayout;

/**
 * Created by chenliu on 7/21/16.
 */
public class DefineLayOut extends HTMLLayout {
    public String getContentType() {
        // 修改编码方式
        return "text/html;charset=UTF-8";
    }
}
