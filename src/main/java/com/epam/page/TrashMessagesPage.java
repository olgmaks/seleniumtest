package com.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.epam.model.Message;

public class TrashMessagesPage extends BasePage {

	@Override
	protected void initMessages() {
		messages = Message.toMessages(driver.findElements(By.className("UI")).get(2).findElements(By.className("zA")));
	}

	public void clickSendToInbox() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement moreActionsButton = (WebElement) js
				.executeScript("return document.getElementsByClassName('ns')[2];");

		moreActionsButton.click();

		WebElement moveToIndox = (WebElement) js
				.executeScript("return document.getElementsByClassName('aX2')[0].querySelectorAll('[act=\"8\"]')[0];");

		Action action = new Actions(driver).clickAndHold(moveToIndox).release().build();

		action.perform();
	}

}
