package com.epam.control.wraper;

import com.epam.control.element.Button;
import com.epam.control.element.CheckBox;
import com.epam.control.element.TextField;
import com.epam.control.element.Label;
import com.epam.control.marker.Decorable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Oleh_Maksymuk on 11/5/2015.
 */
public class WebElementWrapper implements CheckBox, TextField, Label, Button {

    private WebElement element;

    public WebElementWrapper(WebElement element) {
        this.element = element;
    }


    @Override
    public void check() {
        element.click();
    }

    @Override
    public boolean isChecked() {
        return element.isSelected();
    }

    @Override
    public void setText(String text) {
        element.sendKeys(text);
    }

    @Override
    public void submit() {
        element.submit();
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public String getText() {
        return element.getText();
    }

    public WebElement getElement() {
        return element;
    }

    public CheckBox getChildCheckBox(By by) {
        return (CheckBox) findChild(by);
    }

    public Label getChildLabel(By by) {
        return (Label) findChild(by);
    }

    public TextField getChildField(By by) {
        return (TextField) findChild(by);
    }

    public Button getChildButton(By by) {
        return (Button) findChild(by);
    }

    private Decorable findChild(By by) {
        return new WebElementWrapper(element.findElement(by));
    }
}
