package com.epam.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.engine.WebDriverUtils;
import com.epam.model.User;
import com.epam.page.InboxMessagesPage;
import com.epam.page.LoginPage;
import com.epam.page.PasswordPage;
import com.epam.testdata.Data;


public class LoginTest {
	
	private static final Logger LOG = Logger.getLogger(LoginTest.class);
	
	
	@BeforeClass
	public static void beforeClass () {
		//Start browser driver
		WebDriverUtils.load(Data.URL);
	}

	@Test
	public void testLogin() throws IOException {
		
		//Loading default user for test from property file
		User user = Data.getDefaultUser();
		
		//Loading page
		LoginPage loginPage = new LoginPage();
		
		//Typing email, submiting and starting password page
		PasswordPage passwordPage = loginPage.setEmailAndSubmit(user.getEmail());
		
		//Typing password and starting inbon messages page
		InboxMessagesPage inboxMessagesPage = passwordPage.setPasswordAndSubmit(user.getPassword());
		
		
	}
	
	@AfterClass
	public static void afterClass () {
		//Stop browser driver
		WebDriverUtils.stop();
	}

}
