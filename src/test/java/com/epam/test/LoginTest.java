package com.epam.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
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

public class LoginTest {

	private static final Logger LOG = Logger.getLogger(LoginTest.class);

	@BeforeClass
	public static void beforeClass() {
		// Start browser driver
		WebDriverUtils.load(Data.URL);
	}

	@Test
	public void testLogin() throws IOException {

		// Loading default user for test from property file
		User user = Data.getDefaultUser();

		// Loading page
		LoginPage loginPage = new LoginPage();

		// Typing email, submiting and starting password page
		PasswordPage passwordPage = loginPage.setEmailAndSubmit(user.getEmail());

		// Typing password and starting inbon messages page
		InboxMessagesPage inboxMessagesPage = passwordPage.setPasswordAndSubmit(user.getPassword());

		// Preparing Messages to be indicated as important
		List<Message> inboxMessages = inboxMessagesPage.getMessages();

		Message firstMessage = inboxMessages.get(0);
		Message secondMessage = inboxMessages.get(1);
		Message thirdMessage = inboxMessages.get(2);

		LOG.info("firstMessage=" + firstMessage);
		LOG.info("secondMessage=" + secondMessage);
		LOG.info("thirdMessage=" + thirdMessage);

		// Indicating messages as important
		firstMessage.getImportantCheckBox().click();
		secondMessage.getImportantCheckBox().click();
		thirdMessage.getImportantCheckBox().click();

		// Important messages page
		ImportantMessagesPage importantMessagesPage = inboxMessagesPage.openImportantMessagesPage();

		// Important messages
		List<Message> importantMessages = importantMessagesPage.getMessages();

		// Verifying 3 messages in important box
		assertEquals(importantMessages.size(), 3);

		// Messages
		Message firstImportantMessage = importantMessages.get(0);
		Message secondImportantMessage = importantMessages.get(1);
		Message thirdImportantMessage = importantMessages.get(2);

		LOG.info("firstImportantMessage=" + firstImportantMessage);
		LOG.info("secondImportantMessage=" + secondImportantMessage);
		LOG.info("thirdImportantMessage=" + thirdImportantMessage);

		// Verifying indicated messages presence among important messages
		assertEquals(firstMessage, firstImportantMessage);
		assertEquals(secondMessage, secondImportantMessage);
		assertEquals(thirdMessage, thirdImportantMessage);

		// Indicating messages as important
		firstImportantMessage.getIndicatedCheckBox().click();
		secondImportantMessage.getIndicatedCheckBox().click();
		thirdImportantMessage.getIndicatedCheckBox().click();

		// Deleting indicated messages
		importantMessagesPage.deleteCheckedMessages();

		// Opening trash messages page
		TrashMessagesPage trashMessagesPage = importantMessagesPage.openTrashMessagesPage();

		// Trash messages
		List<Message> trashMessages = trashMessagesPage.getMessages();

		Message firstTrashMessage = trashMessages.get(0);
		Message secondTrashMessage = trashMessages.get(1);
		Message thirdTrashMessage = trashMessages.get(2);

		LOG.info("firstTrashMessage=" + firstTrashMessage);
		LOG.info("secondTrashMessage=" + secondTrashMessage);
		LOG.info("thirdTrashMessage=" + thirdTrashMessage);

		// Verifying trash messages
		assertEquals(firstImportantMessage, firstTrashMessage);
		assertEquals(secondImportantMessage, secondTrashMessage);
		assertEquals(thirdImportantMessage, thirdTrashMessage);
		
		
		
		//Returning system to previous state
		firstTrashMessage.getIndicatedCheckBox().click();
		WebDriverUtils.getDriver().findElement(By.id(":as")).click();
		Actions actions = new Actions(
				WebDriverUtils.getDriver());
		Action action = actions.clickAndHold(
				WebDriverUtils.getDriver().findElement(By.id(":cc"))).release().build();
		action.perform();
	}

	@AfterClass
	public static void afterClass() {
		// Stop browser driver
		// WebDriverUtils.stop();
	}

}
