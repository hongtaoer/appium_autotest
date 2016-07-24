package com.cl.appium.common.util;

import com.cl.appium.common.log.Log;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

/**
 * Created by chenl on 7/14/16.
 */
public class CommonUtil {

    private static Logger log = Log.getLog(CommonUtil.class);

    public static void WaitForElementPresentByXpath(String locator, int timeout, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        } catch (Exception e) {
            log.error("Error found:" + e.getMessage());
            throw new ElementNotFoundException(locator, "", "");
        }
    }

    public static void WaitForElementPresentById(String locator, int timeout, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
        } catch (Exception e) {
            log.error("Error found:" + e.getMessage());
            throw new ElementNotFoundException(locator, "", "");
        }
    }
}
