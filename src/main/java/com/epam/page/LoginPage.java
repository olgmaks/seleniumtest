package com.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.epam.engine.WebDriverUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private static final String USER_EMAIL_FIELD_ID = "Email";
	
	//Email field

	@FindBy(id = USER_EMAIL_FIELD_ID)
	private WebElement userEmailField;

	public LoginPage() {
		PageFactory.initElements(WebDriverUtils.getDriver(), this);
	}
	
	
	public PasswordPage setEmailAndSubmit (String email) {
		
		if (userEmailField != null) {
			userEmailField.sendKeys(email);
			userEmailField.submit();
		}
		
		return new PasswordPage();
	}
	

}
