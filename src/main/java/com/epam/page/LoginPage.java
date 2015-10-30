package com.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.epam.engine.WebDriverUtils;

public class LoginPage {

	private static final String USER_EMAIL_FIELD_ID = "Email";
	
	//Email field
	private WebElement userEmailField;

	public LoginPage() {
		userEmailField = WebDriverUtils.getDriver().findElement(By.id(USER_EMAIL_FIELD_ID));
	}
	
	
	public PasswordPage setEmailAndSubmit (String email) {
		
		if (userEmailField != null) {
			userEmailField.sendKeys(email);
			userEmailField.submit();
		}
		
		return new PasswordPage();
	}
	

}
