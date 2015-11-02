package com.epam.page;

import org.openqa.selenium.By;

import com.epam.transformer.MessageTransformer;

public class ImportantMessagesPage extends BasePage {

	@Override
	protected void initMessages() {
		messages = MessageTransformer
				.fetchAll(driver.findElements(By.className("UI")).get(1).findElements(By.className("zA")));
	}

}
