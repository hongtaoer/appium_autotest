package com.appium.test.common;

import com.cl.appium.common.log.Log;
import org.junit.Test;
import org.slf4j.Logger;

/**
 * Created by chenliu on 7/21/16.
 */
public class LogTest {

    private static final Logger LOG = Log.getLog(LogTest.class);

    @Test
    public void logTest() {
        LOG.error("床前明月光,疑是地上霜,举头望明月,低头,吃口香糖");
        LOG.info ("床前明月光,疑是地上霜,举头望明月,低头,吃口香糖");
        LOG.debug("床前明月光,疑是地上霜,举头望明月,低头,吃口香糖");
    }
}
