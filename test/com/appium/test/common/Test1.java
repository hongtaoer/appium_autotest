package com.appium.test.common;

import com.cl.appium.common.log.Log;
import org.junit.Test;
import org.slf4j.Logger;

/**
 * Created by chenliu on 16/7/24.
 */
public class Test1 {
    public static Logger log = Log.getLog(Test1.class);

    @Test
    public void logs() {
        log.info("wwwwwwwwwwwwwwwwwwwwwwww");
        log.error("qqqqqqqqqqqqqqqqqqqqq");
        log.debug("eeeeeeeeeeeeeeeeeee");
        log.warn("33333333333333333333333");
        if (log.isDebugEnabled()){
            int i =0;
            int j=1;
            int k = i+j;
        }
        log.trace("324234234332432432432432");

    }
}
