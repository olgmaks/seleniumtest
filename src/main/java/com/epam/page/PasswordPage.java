package com.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.epam.engine.WebDriverUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
	
	private static final String USER_PASSWORD_FIELD_ID = "Passwd";
	
	//Password field

	@FindBy(id = USER_PASSWORD_FIELD_ID)
	private WebElement passwordField;
	
	public PasswordPage() {
		PageFactory.initElements(WebDriverUtils.getDriver(), this);
	}
	
	public InboxMessagesPage setPasswordAndSubmit (String password) {
		
		if (passwordField != null) {
			passwordField.sendKeys(password);
			passwordField.submit();	
		}
		
		return new InboxMessagesPage();
	}

}
