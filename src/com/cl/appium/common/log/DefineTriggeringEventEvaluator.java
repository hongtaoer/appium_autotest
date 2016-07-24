package com.cl.appium.common.log;

import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.TriggeringEventEvaluator;

/**
 * Created by pengtao on 7/21/16.
 */
public class DefineTriggeringEventEvaluator implements TriggeringEventEvaluator {

    @Override
    public boolean isTriggeringEvent(LoggingEvent loggingEvent) {
        return loggingEvent.getLevel().isGreaterOrEqual(Level.DEBUG);
    }
}
