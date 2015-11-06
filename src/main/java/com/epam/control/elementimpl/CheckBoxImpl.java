package com.epam.control.elementimpl;

import com.epam.control.element.CheckBox;
import org.openqa.selenium.WebElement;

/**
 * Created by Oleh_Maksymuk on 11/6/2015.
 */
public class CheckBoxImpl extends AbstractComponent implements CheckBox{


    public CheckBoxImpl(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void check() {
        webElement.click();
    }

    @Override
    public boolean isChecked() {
        return webElement.isSelected();
    }
}
