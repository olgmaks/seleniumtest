package com.epam.service;

import org.apache.log4j.Logger;

import com.epam.model.User;
import com.epam.page.InboxMessagesPage;
import com.epam.page.LoginPage;
import com.epam.page.PasswordPage;

public class LoginService {
	
	private static final Logger LOG = Logger.getLogger(LoginService.class);
	
	public InboxMessagesPage login (User user) {


		// Loading page
		LoginPage loginPage = new LoginPage();
		LOG.info("Login Page page has been opened");

		// Typing email, submitting and starting password page
		PasswordPage passwordPage = loginPage.setEmailAndSubmit(user.getEmail());
		LOG.info("Password Page has been opened");

		
		// Typing password and starting inbox messages page 
		InboxMessagesPage result = passwordPage.setPasswordAndSubmit(user.getPassword());
		
		
		return result;
		
		
	}

}
