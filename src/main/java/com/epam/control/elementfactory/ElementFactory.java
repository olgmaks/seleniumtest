package com.epam.control.elementfactory;

import com.epam.control.element.Button;
import com.epam.control.element.CheckBox;
import com.epam.control.element.Label;
import com.epam.control.element.TextField;
import com.epam.control.elementimpl.*;
import com.epam.control.marker.Decorable;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

/**
 * Created by Oleh_Maksymuk on 11/6/2015.
 */
public class ElementFactory {

    public static final int BUTTON = 0;
    public static final int TEXT_FIELD = 1;
    public static final int CHECK_BOX = 2;
    public static final int LABEL = 3;

    private ElementFactory() {
    }

    public static AbstractComponent getElement(int elementType, WebElement webElement) {

        if (elementType == BUTTON)
            return new ButtonImpl(webElement);

        else if (elementType == TEXT_FIELD)
            return new TextFieldImpl(webElement);

        else if (elementType == CHECK_BOX)
            return new CheckBoxImpl(webElement);

        else if (elementType == LABEL)
            return new LabelImpl(webElement);

        throw new NoSuchElementException("AbstractComponent. Factory exception. No such element type");
    }


    public static AbstractComponent getElement(Class clazz, WebElement webElement) {

        if (Button.class.isAssignableFrom(clazz))
            return getElement(BUTTON, webElement);

        else if (Label.class.isAssignableFrom(clazz))
            return getElement(LABEL, webElement);

        else if (CheckBox.class.isAssignableFrom(clazz))
            return getElement(CHECK_BOX, webElement);

        else if (TextField.class.isAssignableFrom(clazz))
            return getElement(TEXT_FIELD, webElement);

        throw new NoSuchElementException("AbstractComponent. Factory exception. No such element type");
    }


}
