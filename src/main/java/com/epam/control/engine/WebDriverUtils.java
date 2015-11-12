package com.epam.control.engine;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtils {


    // Driver pool

    private static Map<Long, WebDriver> pool;

    private static volatile int activeBrowsersCount = 0;


    // logger

    private static final Logger LOG = Logger.getLogger(WebDriverUtils.class);


    /**
     * Creating static web driver
     */

    private static final long IMPLICITLY_WAIT_TIMEOUT = 30;

    private static final Object SYNC_CREATE_DRIVER = new Object();
    private static final Object SYNC_GET_DRIVER = new Object();

    static {
        // Pool init
        pool = new HashMap<>();
    }

    private WebDriverUtils() {

    }


    public static WebDriver getDriver() {

        WebDriver driver = null;

        synchronized (SYNC_GET_DRIVER) {

            driver = pool.get(Thread.currentThread().getId());

            if (driver != null) {
                return driver;
            }

        }


        synchronized (SYNC_CREATE_DRIVER) {

            if (activeBrowsersCount >= 5) {

                try {
                    SYNC_CREATE_DRIVER.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            driver = new FirefoxDriver();

            driver.manage()
                    .timeouts()
                    .implicitlyWait(getImplicitlyWaitTimeout(),
                            TimeUnit.SECONDS);

            pool.put(Thread.currentThread().getId(), driver);

            activeBrowsersCount++;

            return driver;

        }

    }

    public static long getImplicitlyWaitTimeout() {
        return IMPLICITLY_WAIT_TIMEOUT;
    }

    public static void stop() {

        synchronized (SYNC_CREATE_DRIVER) {

            WebDriver driver = null;

            driver = getDriver();

            pool.remove(Thread.currentThread().getId());

            if (driver != null) {
                driver.quit();
            }

            activeBrowsersCount--;

            driver = null;

            SYNC_CREATE_DRIVER.notify();
        }

        LOG.info("Browser has been stopped.");
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
