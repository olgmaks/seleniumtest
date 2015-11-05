package com.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.epam.transformer.MessageTransformer;

public class TrashMessagesPage extends HomePage {

	private static final String MORE_ACTION_BUTTON_XPATH = "//div[@gh='tm']/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]";
	private static final String MOVE_TO_INBOX_XPATH = "//div[@class='SK AX']//div[@act='8']";
	private static final String TRASH_MESSAGES_XPATH = "//div[@class='ae4 UI']/div[1]/div[1]/table/tbody/tr";

//	@Override
//	protected void initMessages() {
//		messageElements = MessageTransformer.fetchAll(driver.findElements(By.xpath(TRASH_MESSAGES_XPATH)));
//	}

	public void clickSendToInbox() {

		WebElement moreActionsButton = driver.findElement(By.xpath(MORE_ACTION_BUTTON_XPATH));
		moreActionsButton.click();

		WebElement moveToIndox = driver.findElement(By.xpath(MOVE_TO_INBOX_XPATH));
		Action action = new Actions(driver).clickAndHold(moveToIndox).release().build();
		action.perform();
	}

}
