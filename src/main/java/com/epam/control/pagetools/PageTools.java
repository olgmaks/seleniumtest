package com.epam.control.pagetools;

import com.epam.control.wraper.DriverElementDecorator;
import com.epam.control.engine.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Oleh_Maksymuk on 11/5/2015.
 */
public class PageTools {

    private static final long INTERVAL_BETWEEN_TIMEOUT_IN_MILLISECONDS = 1000;
    private static final long TIMEOUT_IN_SECONDS = 30;


    public static void initPageElements(Object page) {

        PageFactory.initElements(
                new DriverElementDecorator(
                        new DefaultElementLocatorFactory(
                                WebDriverUtils.getDriver())), page);
    }

    public static void executeJS (String script) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverUtils.getDriver();
        js.executeScript(script);
    }

    private static void waitForAll(By by) {
        new WebDriverWait(WebDriverUtils.getDriver(),
                TIMEOUT_IN_SECONDS,
                INTERVAL_BETWEEN_TIMEOUT_IN_MILLISECONDS).until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    private static void waitForOne (By by) {
        new WebDriverWait(WebDriverUtils.getDriver(),
                TIMEOUT_IN_SECONDS,
                INTERVAL_BETWEEN_TIMEOUT_IN_MILLISECONDS).until(
                ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementByXpath (String xpath) {
        waitForAll(By.xpath(xpath));
    }

    public static void waitForElementsByXpath (String xpath) {
        waitForAll(By.xpath(xpath));
    }

    public static void closeBrowser () {
        WebDriverUtils.stop();
    }

}
