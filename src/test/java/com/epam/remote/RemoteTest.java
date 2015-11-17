package com.epam.remote;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.uiautomation.ios.IOSCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Oleh_Maksymuk on 11/16/2015.
 */
public class RemoteTest {



    @BeforeClass
    public static void setup (){


    }

    @Test
    public void test () throws MalformedURLException  {


        DesiredCapabilities safari = IOSCapabilities.iphone("Safari");

        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.25.9.253:4444/wd/hub/"), safari);

        driver.get("https://www.google.com");
    }
}
