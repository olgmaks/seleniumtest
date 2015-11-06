package com.epam.control.elementimpl;

import com.epam.control.element.Label;
import org.openqa.selenium.WebElement;

/**
 * Created by Oleh_Maksymuk on 11/6/2015.
 */
public class LabelImpl extends AbstractComponent implements Label {


    public LabelImpl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        webElement.click();
    }

    @Override
    public String getText() {
        return webElement.getText();
    }
}
