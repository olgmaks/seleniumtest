package com.epam.page;

import com.epam.control.element.TextField;
import com.epam.control.engine.WebDriverUtils;
import com.epam.control.pagetools.PageTools;
import com.epam.testdata.Data;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private static final String USER_EMAIL_FIELD_ID = "Email";

    //Email field

    @FindBy(id = USER_EMAIL_FIELD_ID)
    private TextField userEmailTextField;

    public LoginPage() {

        // Start browser driver
        WebDriverUtils.load(Data.URL);

        PageTools.initPageElements(this);
    }

    public PasswordPage setEmailAndSubmit(String email) {

        if (userEmailTextField != null) {
            userEmailTextField.setText(email);
            userEmailTextField.submit();
        }

        return new PasswordPage();
    }


}
