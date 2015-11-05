package com.epam.page;

import com.epam.control.element.Field;

import com.epam.control.pagetools.PageTools;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private static final String USER_EMAIL_FIELD_ID = "Email";

    //Email field

    @FindBy(id = USER_EMAIL_FIELD_ID)
    private Field userEmailField;

    public LoginPage() {
        PageTools.initPageElements(this);
    }

    public PasswordPage setEmailAndSubmit(String email) {

        if (userEmailField != null) {
            userEmailField.setText(email);
            userEmailField.submit();
        }

        return new PasswordPage();
    }


}
