package com.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.epam.engine.WebDriverUtils;

public class PasswordPage {
	
	private static final String USER_PASSWORD_FIELD_ID = "Passwd";
	
	//Password field
	private WebElement passwordField;
	
	public PasswordPage() {
		passwordField = WebDriverUtils.getDriver().findElement(By.id(USER_PASSWORD_FIELD_ID));
	}
	
	public InboxMessagesPage setPasswordAndSubmit (String password) {
		
		if (passwordField != null) {
			passwordField.sendKeys(password);
			passwordField.submit();	
		}
		
		return new InboxMessagesPage();
	}

}
