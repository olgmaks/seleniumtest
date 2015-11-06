package com.epam.control.elementimpl;

import com.epam.control.element.TextField;
import org.openqa.selenium.WebElement;

/**
 * Created by Oleh_Maksymuk on 11/6/2015.
 */
public class TextFieldImpl extends AbstractComponent implements TextField {


    public TextFieldImpl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void setText(String text) {
        webElement.sendKeys(text);
    }

    @Override
    public void submit() {
        webElement.submit();
    }

}
