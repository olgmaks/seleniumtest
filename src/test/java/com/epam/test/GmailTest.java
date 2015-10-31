package com.epam.test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.engine.WebDriverUtils;
import com.epam.model.Message;
import com.epam.model.User;
import com.epam.page.ImportantMessagesPage;
import com.epam.page.InboxMessagesPage;
import com.epam.page.LoginPage;
import com.epam.page.PasswordPage;
import com.epam.page.TrashMessagesPage;
import com.epam.testdata.Data;

public class GmailTest {

	private static final Logger LOG = Logger.getLogger(GmailTest.class);

	@BeforeClass
	public static void beforeClass() {
		// Start browser driver
		WebDriverUtils.load(Data.URL);
		LOG.info("Browser started with URL = " + Data.URL);
	}

	@Test
	public void testScenario() {

		LOG.info("Test execution has been started");

		// Loading default user for test from property file
		User user = Data.getDefaultUser();

		// Loading page
		LoginPage loginPage = new LoginPage();
		LOG.info("Login Page page has been opened");

		// Typing email, submiting and starting password page
		PasswordPage passwordPage = loginPage.setEmailAndSubmit(user.getEmail());
		LOG.info("Password Page has been opened");

		// Typing password and starting inbon messages page
		InboxMessagesPage inboxMessagesPage = passwordPage.setPasswordAndSubmit(user.getPassword());
		LOG.info("Inbox Messages Page has been opened");

		// Preparing Messages to be indicated as important
		List<Message> inboxMessages = inboxMessagesPage.getMessages();

		Message firstMessage = inboxMessages.get(0);
		Message secondMessage = inboxMessages.get(1);
		Message thirdMessage = inboxMessages.get(2);

		// Indicating messages as important
		firstMessage.getImportantCheckBox().click();
		secondMessage.getImportantCheckBox().click();
		thirdMessage.getImportantCheckBox().click();

		// Important messages page
		ImportantMessagesPage importantMessagesPage = inboxMessagesPage.openImportantMessagesPage();
		LOG.info("Important Messages page has been opened");

		// Important messages
		List<Message> importantMessages = importantMessagesPage.getMessages();

		// Messages
		Message firstImportantMessage = importantMessages.get(0);
		Message secondImportantMessage = importantMessages.get(1);
		Message thirdImportantMessage = importantMessages.get(2);

		// Verifying indicated messages presence among important messages
		assertEquals(importantMessages.contains(firstMessage), true);
		assertEquals(importantMessages.contains(secondMessage), true);
		assertEquals(importantMessages.contains(thirdMessage), true);
		LOG.info("Messages have been found in important box");

		// Indicating messages as important
		firstImportantMessage.getIndicatedCheckBox().click();
		secondImportantMessage.getIndicatedCheckBox().click();
		thirdImportantMessage.getIndicatedCheckBox().click();

		// Deleting indicated messages
		importantMessagesPage.deleteCheckedMessages();

		// Opening trash messages page
		TrashMessagesPage trashMessagesPage = importantMessagesPage.openTrashMessagesPage();
		LOG.info("Trash Messages Page page has been opened");

		// Trash messages
		List<Message> trashMessages = trashMessagesPage.getMessages();

		Message firstTrashMessage = trashMessages.get(0);
		Message secondTrashMessage = trashMessages.get(1);
		Message thirdTrashMessage = trashMessages.get(2);

		// Verifying trash messages
		assertEquals(trashMessages.contains(firstImportantMessage), true);
		assertEquals(trashMessages.contains(secondImportantMessage), true);
		assertEquals(trashMessages.contains(thirdImportantMessage), true);
		LOG.info("Messages have been found in trashed messages");

		// Returning system to previous state
		firstTrashMessage.getImportantCheckBox().click();
		secondTrashMessage.getImportantCheckBox().click();
		thirdTrashMessage.getImportantCheckBox().click();

		firstTrashMessage.getIndicatedCheckBox().click();
		secondTrashMessage.getIndicatedCheckBox().click();
		thirdTrashMessage.getIndicatedCheckBox().click();

		WebDriverUtils.getDriver().findElement(By.id(":as")).click();

		Action action = new Actions(WebDriverUtils.getDriver())
				.clickAndHold(WebDriverUtils.getDriver().findElement(By.id(":cc"))).release().build();
		action.perform();
		LOG.info("System has been returned to pre-contition state");
		LOG.info("Test has been passed");
	}

	@AfterClass
	public static void afterClass() {
		// Stop browser driver
		WebDriverUtils.stop();
		LOG.info("Browser has been stopped");
	}

}
