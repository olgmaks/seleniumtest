package com.epam.test;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.engine.WebDriverUtils;
import com.epam.model.Message;
import com.epam.model.User;
import com.epam.service.ImportantMessageService;
import com.epam.service.InboxMessagesService;
import com.epam.service.TrashMessagesService;
import com.epam.testdata.Data;

public class GmailTest {

	private static final Logger LOG = Logger.getLogger(GmailTest.class);

	private static boolean gmailTestPassed = false;

	@BeforeClass
	public static void beforeClass() {
		// Start browser driver
		WebDriverUtils.load(Data.URL);
		LOG.info("Browser started with URL = " + Data.URL);
	}

	@Test
	public void gmailTest() {

		User user = Data.getDefaultUser();

		InboxMessagesService inboxMessagesService = new InboxMessagesService(user);

		List<Message> messages = inboxMessagesService.indicateMessagesAsImportant(0, 1, 2);

		ImportantMessageService importantMessageService = new ImportantMessageService(inboxMessagesService);

		assertTrue(importantMessageService.verifyMessagesPresence(messages));

		importantMessageService.selectMessagesAndRemove(messages);

		TrashMessagesService trashMessagesService = new TrashMessagesService(importantMessageService);

		assertTrue(trashMessagesService.verifyMessagesPresence(messages));

		trashMessagesService.moveMessagesToInbox();

		gmailTestPassed = true;

		LOG.info("Test has been passed");
	}

	@AfterMethod
	public void afterTest() {

		if (!gmailTestPassed) {
			
			TrashMessagesService trashMessagesService = new TrashMessagesService(Data.getDefaultUser());

			trashMessagesService.moveMessagesToInbox();
		}

		LOG.info("System has been returned to pre-contition state");

	}

	@AfterClass
	public static void afterClass() {
		// Stop browser driver
		WebDriverUtils.stop();
		LOG.info("Browser has been stopped");
	}

}
