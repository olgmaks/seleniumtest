package com.epam.control.elementimpl;

import com.epam.control.element.Button;
import org.openqa.selenium.WebElement;

/**
 * Created by Oleh_Maksymuk on 11/6/2015.
 */
public class ButtonImpl extends AbstractComponent implements Button {


    public ButtonImpl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        webElement.click();
    }
}
