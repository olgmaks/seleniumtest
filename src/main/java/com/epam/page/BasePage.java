package com.epam.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.engine.WebDriverUtils;
import com.epam.model.Message;
import com.epam.transformer.MessageTransformer;

public class BasePage {

	// private static final Logger LOG = Logger.getLogger(BasePage.class);

	protected WebDriver driver;
	protected WebElement moreOptionsButton;
	protected WebElement deleteCheckedButton;

	protected List<Message> messages;

	protected BasePage() {

		driver = WebDriverUtils.getDriver();

		WebDriverUtils.webDriverWait(5);

		moreOptionsButton = driver.findElement(By.className("n6"));

		initMessages();

	}

	protected void initMessages() {
		messages = MessageTransformer.fetchAll(driver.findElements(By.className("zA")));

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

	public void deleteCheckedMessages() {
		deleteCheckedButton = driver.findElements(By.className("ar9")).get(1);
		deleteCheckedButton.click();
	}

	public List<Message> getMessages() {
		return messages;
	}
}
