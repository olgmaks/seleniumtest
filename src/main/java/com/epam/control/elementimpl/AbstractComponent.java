package com.epam.control.elementimpl;

import com.epam.control.marker.Decorable;
import org.openqa.selenium.WebElement;

/**
 * Created by Oleh_Maksymuk on 11/6/2015.
 */
public abstract class AbstractComponent implements Decorable{


    protected WebElement webElement;

    public AbstractComponent (WebElement webElement) {
        this.webElement = webElement;
    }

    public WebElement getWebElement() {
        return webElement;
    }


}
