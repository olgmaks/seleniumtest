package com.epam.page;

import com.epam.engine.DriverElementDecorator;
import com.epam.engine.WebDriverUtils;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

/**
 * Created by Oleh_Maksymuk on 11/5/2015.
 */
public class Page {

    public Page () {
        PageFactory.initElements(
                new DriverElementDecorator(
                        new DefaultElementLocatorFactory(
                                WebDriverUtils.getDriver())), this);
    }

}
