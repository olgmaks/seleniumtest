package com.epam.page;

import com.epam.businesslogic.LoginService;
import com.epam.control.marker.Decorable;
import com.epam.engine.WebDriverUtils;
import com.epam.testdata.Data;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Oleh_Maksymuk on 11/5/2015.
 */
public class InboxMessagesPageTest {

    @Test
    public void test() {


        WebDriverUtils.load(Data.URL);

        LoginService loginService = new LoginService(Data.getDefaultUser());

        InboxMessagesPage inboxMessagesPage = loginService.login().getInboxMessagesPage();


        System.out.println(inboxMessagesPage.getMessages());

    }

}
