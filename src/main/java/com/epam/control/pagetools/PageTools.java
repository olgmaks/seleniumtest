package com.epam.control.pagetools;

import com.epam.control.marker.Decorable;
import com.epam.control.wraper.DriverElementDecorator;
import com.epam.control.engine.WebDriverUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

/**
 * Created by Oleh_Maksymuk on 11/5/2015.
 */
public class PageTools {

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

//    public static Actions performActions (Decorable element) {
//        Actions actions = new Actions(WebDriverUtils.getDriver());
//        return actions;
//    }

}
