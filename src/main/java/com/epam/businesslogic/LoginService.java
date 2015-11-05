package com.epam.businesslogic;

import org.apache.log4j.Logger;

import com.epam.model.User;
import com.epam.page.InboxMessagesPage;
import com.epam.page.LoginPage;
import com.epam.page.PasswordPage;

public class LoginService {

	private static final Logger LOG = Logger.getLogger(LoginService.class);

	private User user;

	private InboxMessagesPage inboxMessagesPage;

	public LoginService(User user) {
		this.user = user;
	}

	public LoginService login() {

		// Loading page
		LoginPage loginPage = new LoginPage();
		LOG.info("Login Page page has been opened");

		// Typing email, submitting and starting password page
		PasswordPage passwordPage = loginPage.setEmailAndSubmit(user.getEmail());
		LOG.info("Password Page has been opened");

		// Typing password and starting inbox messages page
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
