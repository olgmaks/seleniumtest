package com.epam.page;

import com.epam.control.element.Field;

import org.openqa.selenium.support.FindBy;

public class PasswordPage extends  Page{

    private static final String USER_PASSWORD_FIELD_ID = "Passwd";

    //Password field

    @FindBy(id = USER_PASSWORD_FIELD_ID)
    private Field passwordField;



    public InboxMessagesPage setPasswordAndSubmit(String password) {

        if (passwordField != null) {
            passwordField.setText(password);
            passwordField.submit();
        }

        return new InboxMessagesPage();
    }

}
