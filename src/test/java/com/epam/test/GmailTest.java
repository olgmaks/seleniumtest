package com.epam.test;

import com.epam.businesslogic.LoginService;
import com.epam.businesslogic.MessagesService;
import com.epam.control.engine.WebDriverUtils;
import com.epam.control.pagetools.PageTools;
import com.epam.model.Message;
import com.epam.model.User;
import com.epam.testdata.Data;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.List;

public class GmailTest {

    private static final Logger LOG = Logger.getLogger(GmailTest.class);

    @BeforeClass
    public static void beforeClass() {
        LOG.info("GmailTest test SUITE started");
    }

    @Test
    public void testGmail() {

        LOG.info("Test execution has been started ...");

        User user = Data.getUserDataExсel();

        // Login business logic object
        LoginService loginService = new LoginService(user);

        // Message business logic object
        MessagesService messagesService = new MessagesService(loginService);

        // Opening important messages page
        messagesService.openInboxMessage();

        // Indicating messages as important
        List<Message> importantMessages = messagesService.indicateMessagesAsImportant(0, 1, 2);

        // Opening important messages page
        messagesService.openImportantMessagePage();

        // Verifying messages presence among important messages
        assertTrue(messagesService.verifyMessagesPresenceAmongImportantMessages(importantMessages));

        // Indicating important messages using their checkboxes
        List<Message> trashMessages = messagesService.selectAndDeleteImportantMessages(importantMessages);

        // Opening trash messages page
        messagesService.openTrashMessagePage();

        // Verifying messages presence among trash messages
        assertTrue(messagesService.verifyMessagesPresenceAmongTrashMessages(trashMessages));

        // Making trash unimportant
        messagesService.makeAllTrashUnimportant();

        // Moving Messages back to inbox
        messagesService.moveAllTrashToInbox();

        LOG.info("Test has been passed");
    }

    @AfterMethod
    public void afterTest() {

    }

    @AfterClass
    public static void afterClass() {
        // Stop browser driver
        LOG.info("GmailTest test SUITE executed");
        PageTools.closeBrowser();
    }

}
