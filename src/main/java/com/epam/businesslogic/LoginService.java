package com.epam.businesslogic;

import com.epam.control.engine.WebDriverUtils;
import com.epam.model.User;
import com.epam.page.InboxMessagesPage;
import com.epam.page.LoginPage;
import com.epam.page.PasswordPage;
import com.epam.testdata.Data;
import org.apache.log4j.Logger;

public class LoginService {

    private static final Logger LOG = Logger.getLogger(LoginService.class);

    // Models
    private User user;

    // Pages
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private InboxMessagesPage inboxMessagesPage;

    public LoginService(User user) {
        this.user = user;
        // Loading page
        LOG.info("Initialisation login page...");
        loginPage = new LoginPage();
    }

    public LoginService login() {

        // Typing email, submitting and starting password page
        LOG.info("Typing email = " + user.getEmail() + " and submitting ...");
        PasswordPage passwordPage = loginPage.setEmailAndSubmit(user.getEmail());

        // Typing password and starting inbox messages page
        LOG.info("Typing password = " + user.getPassword() + " and submitting ...");
        inboxMessagesPage = passwordPage.setPasswordAndSubmit(user.getPassword());

        return this;

    }

    public User getUser() {
        return user;
    }

    public InboxMessagesPage getInboxMessagesPage() {
        return inboxMessagesPage;
    }
}
