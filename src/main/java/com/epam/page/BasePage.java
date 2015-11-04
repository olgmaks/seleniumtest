package com.epam.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.epam.engine.WebDriverUtils;
import com.epam.transformer.MessageTransformer;

public class BasePage {

	private static final String DELETE_CHECKED_MESSAGES_BUTTON_XPATH = "//div[@gh='tm']//div[@act='10']";
	private static final String MORE_MENU_OPTIONS_BUTTON_XPATH = "//span[@class='ait']";
	private static final String IMPORTANT_MESSAGES_BUTTON_XPATH = "//div[@class='r9gPwb bQ']/div[3]/div[1]/div[1]/div[1]/div[1]";

	protected WebDriver driver;
	protected WebElement moreOptionsButton;
	protected WebElement deleteCheckedButton;
	protected WebElement trashMessagesButton;

	protected List<MessageItemFragment> messages;

	protected BasePage() {

		driver = WebDriverUtils.getDriver();

		By locator = By.xpath(MORE_MENU_OPTIONS_BUTTON_XPATH);
		
		WebDriverUtils.createWebDriverWait(5).until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		moreOptionsButton = driver.findElement(locator);


		initMessages();

	}

	protected void initMessages() {
		messages = MessageTransformer.fetchAll(driver.findElements(By.className("zA")));

	}
	
	public void indicateMessageAsImportant (Integer index) {
		messages.get(index).getImportantCheckBox().click();
	}
	
	public void indicateMessageAsSelected (Integer index) {
		messages.get(index).getIndicatedCheckBox().click();
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

		moreOptionsButton.click();

		WebElement importantMessagesButton = driver.findElement(By.xpath(IMPORTANT_MESSAGES_BUTTON_XPATH));

		importantMessagesButton.click();

		return new ImportantMessagesPage();
	}

	public void deleteCheckedMessages() {

		deleteCheckedButton = driver.findElement(By.xpath(DELETE_CHECKED_MESSAGES_BUTTON_XPATH));

		deleteCheckedButton.click();
	}

	public List<MessageItemFragment> getMessages() {
		return messages;
	}
}
