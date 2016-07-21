package com.cl.appium.common.log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by cl on 7/20/16.
 */
public class Log {

    static {

        BasicConfigurator.configure();
        String configLocation = System.getProperty("user.dir") + "/resource/log4j.properties";
//        System.out.println("========================================"+configLocation);
        PropertyConfigurator.configure(configLocation);
    }

    /**
     * 根据类名获取日志对象
     *
     * @param clazz
     * @return
     */
    public static Logger getLog(Class clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
