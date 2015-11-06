package com.epam.page;

import com.epam.control.element.TextField;
import com.epam.control.pagetools.PageTools;
import org.openqa.selenium.support.FindBy;

public class PasswordPage {

    private static final String USER_PASSWORD_FIELD_ID = "Passwd";

    //Password field

    @FindBy(id = USER_PASSWORD_FIELD_ID)
    private TextField passwordTextField;


    public PasswordPage() {
        PageTools.initPageElements(this);
    }

    public InboxMessagesPage setPasswordAndSubmit(String password) {

        if (passwordTextField != null) {
            passwordTextField.setText(password);
            passwordTextField.submit();
        }

        return new InboxMessagesPage();
    }

}
