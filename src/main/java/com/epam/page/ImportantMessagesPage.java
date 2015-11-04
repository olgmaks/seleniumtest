package com.epam.page;

import org.openqa.selenium.By;

import com.epam.transformer.MessageTransformer;

public class ImportantMessagesPage extends BasePage {
	
	private static final String IMPORTANT_MESSAGES_XPATH = "//div[@class='ae4 UI']/div[1]/div[1]/table/tbody/tr";

	@Override
	protected void initMessages() {
		messages = MessageTransformer
				.fetchAll(driver.findElements(By.xpath(IMPORTANT_MESSAGES_XPATH)));
	}

}
