package com.appium.test.common;

import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Logger;
import org.apache.log4j.net.SMTPAppender;

/**
 * Created by chenliu on 7/21/16.
 */
public class TestLog4jSendMail {

    static Logger logger = Logger.getLogger(TestLog4jSendMail.class);
    SMTPAppender appender = new SMTPAppender();

    public TestLog4jSendMail() {
        try {
            appender.setSMTPUsername("pms@566560.com");
            appender.setSMTPPassword("Admin566");
            appender.setTo("chenl@566560.com");
            appender.setFrom("pms@566560.com");
            // SMTP服务器 smtp.exmail.qq.com
            appender.setSMTPHost("smtp.exmail.qq.com");
            appender.setLocationInfo(true);
            appender.setSubject("Test Mail From Log4J");
            appender.setLayout(new HTMLLayout());
            appender.activateOptions();
            logger.addAppender(appender);
            logger.error("自动化测试-测试邮件发送自动化测试结果");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Printing ERROR Statements", e);
        }
    }

    public static void main(String args[]) {
        new TestLog4jSendMail();
    }
}
