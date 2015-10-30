package com.epam.page;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.engine.WebDriverUtils;
import com.epam.model.Message;

public class InboxMessagesPage {

	private static final String MESSAGE_ITEM_CLASS_NAME = "zA";
	private static final String MARK_AS_IMPORTANT_BUTTON_ID = ":6i";
	private static final String TRASH_MESSAGES_BUTTON_ID = ":58";
	private static final String MORE_ACTIONS_BUTTON_ID = ":3a";

	private static final Logger LOG = Logger.getLogger(InboxMessagesPage.class);

	private WebDriver driver;
	private WebElement moreOptionsButton;

	private List<Message> messages;

	public InboxMessagesPage() {

		driver = WebDriverUtils.getDriver();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// moreActionsButton =
		// driver.findElement(By.id(MORE_ACTIONS_BUTTON_ID));

		moreOptionsButton = driver.findElement(By.id(":4x"));

		messages = Message.toMessages(driver.findElements(By.className(MESSAGE_ITEM_CLASS_NAME)));

	}

	// Trash
	public TrashMessagesPage openTrashMessagesPage() {

		moreOptionsButton.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByClassName('UKr6le')[8].click();");

		return new TrashMessagesPage();
	}

	// Important
	public ImportantMessagesPage openImportantMessagesPage() {

		((JavascriptExecutor) driver).executeScript(
				"document.getElementsByClassName('r9gPwb')[0].getElementsByClassName('n3')[1].getElementsByClassName('GLujEb')[0].click();");
		return new ImportantMessagesPage();
	}

	public List<Message> getMessages() {
		return messages;
	}

}
