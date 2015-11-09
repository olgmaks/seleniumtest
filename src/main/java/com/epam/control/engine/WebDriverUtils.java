package com.epam.control.engine;

import java.util.concurrent.TimeUnit;

import com.epam.page.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

    // logger

    private static final Logger LOG = Logger.getLogger(WebDriverUtils.class);

    /**
     * Creating static web driver
     */

    private static WebDriver driver;
    private static final long IMPLICITLY_WAIT_TIMEOUT = 30;
    private static final Object SYNC_ROOT = new Object();

    private WebDriverUtils() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            synchronized (SYNC_ROOT) {
                if (driver == null) {
                    driver = new FirefoxDriver();
                    driver.manage()
                            .timeouts()
                            .implicitlyWait(getImplicitlyWaitTimeout(),
                                    TimeUnit.SECONDS);
                }
            }
        }
        return driver;
    }

    public static long getImplicitlyWaitTimeout() {
        return IMPLICITLY_WAIT_TIMEOUT;
    }

    public static void stop() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
        LOG.info("Browser has been stopped.");
    }

    public static WebDriverWait createWebDriverWait(long seconds) {
        return new WebDriverWait(driver, seconds);
    }

    public static void load(String path) {
        getDriver().get(path);
        LOG.info("Browser has been started with URL = " + path);
    }

    public static void refresh() {
        getDriver().navigate().refresh();
    }

    public static void alertAccept() {
        getDriver().switchTo().alert().accept();
    }

    public static void alertDismiss() {
        getDriver().switchTo().alert().dismiss();
    }
}
