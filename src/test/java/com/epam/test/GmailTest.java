package com.epam.test;

import com.epam.businesslogic.LoginService;
import com.epam.businesslogic.MessagesService;
import com.epam.engine.WebDriverUtils;
import com.epam.model.User;
import com.epam.testdata.Data;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailTest {

    private static final Logger LOG = Logger.getLogger(GmailTest.class);

    @BeforeClass
    public static void beforeClass() {
        // Start browser driver
        WebDriverUtils.load(Data.URL);
        LOG.info("Browser started with URL = " + Data.URL);
    }

    @Test
    public void testGmail() {

        User user = Data.getDefaultUser();
        LoginService loginService = new LoginService(user);
        loginService.login();

        MessagesService messagesService = new MessagesService();

        LOG.info("Test has been passed");
    }

    @AfterMethod
    public void afterTest() {


        LOG.info("System has been returned to pre-contition state");

    }

    @AfterClass
    public static void afterClass() {
        // Stop browser driver
        WebDriverUtils.stop();
        LOG.info("Browser has been stopped");
    }

}
