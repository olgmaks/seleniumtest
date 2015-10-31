package com.epam.page;

import org.openqa.selenium.By;

import com.epam.model.Message;

public class ImportantMessagesPage extends BasePage {

	@Override
	protected void initMessages() {
		messages = Message.toMessages(driver.findElements(By.className("UI")).get(1).findElements(By.className("zA")));
	}

}
