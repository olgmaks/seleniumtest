package com.epam.businesslogic;

import com.epam.control.pagetools.PageTools;
import com.epam.model.Message;
import com.epam.page.ImportantMessagesPage;
import com.epam.page.InboxMessagesPage;
import com.epam.page.TrashMessagesPage;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * Created by OLEG on 04.11.2015.
 */
public class MessagesService {


    private static final Logger LOG = Logger.getLogger(MessagesService.class);

    // Services
    private LoginService loginService;


    // Pages
    private InboxMessagesPage inboxMessagesPage;
    private ImportantMessagesPage importantMessagesPage;
    private TrashMessagesPage trashMessagesPage;


    public MessagesService (LoginService loginService) {
        this.loginService = loginService;
    }



    public void openInboxMessage () {
        LOG.info("Opening inbox messages ...");
        inboxMessagesPage = loginService.login().getInboxMessagesPage();
    }


    public List<Message> indicateMessagesAsImportant (Integer ... indexes) {
        LOG.info("Indicating messages " + Arrays.asList(indexes) + " as important messages...");
        return  inboxMessagesPage.indicateMessagesAsImportant(indexes);
    }


    public void openImportantMessagePage () {
        LOG.info("Opening important messages ...");
        importantMessagesPage = inboxMessagesPage.openImportantMessagesPage();
    }


    public boolean verifyMessagesPresenceAmongImportantMessages(List<Message> messages) {
        LOG.info("Verifying messages presence among important ..., Messages = " + messages);
        return importantMessagesPage.verifyMessagesPresence(messages);
    }


    public List<Message> selectAndDeleteImportantMessages(List<Message> messages) {
        LOG.info("Selecting important messages ..., Messages = " + messages);
        List<Message> result = importantMessagesPage.indicateMessagesAsSelected(messages);
        LOG.info("Deleting checked messages ...");
        importantMessagesPage.deleteCheckedMessages();
        return  result;
    }


    public void openTrashMessagePage () {
        LOG.info("Opening trash messages ...");
        trashMessagesPage = importantMessagesPage.openTrashMessagesPage();
    }


    public boolean verifyMessagesPresenceAmongTrashMessages (List<Message> messages) {
        LOG.info("Verifying messages presence among trash ..., Messages = " + messages);
        return trashMessagesPage.verifyMessagesPresence(messages);
    }


    public void makeAllTrashUnimportant () {
        LOG.info("Making trash messages unimportant ...");
        for (int i = 0; i < trashMessagesPage.getMessages().size(); i++) {
            trashMessagesPage.indicateMessageAsImportant(i);
        }
    }

    public void moveAllTrashToInbox() {
        LOG.info("Selecting trash messages and sending to inbox ..., Messages = " + trashMessagesPage.getMessages());
        trashMessagesPage.indicateMessagesAsSelected(trashMessagesPage.getMessages());
        trashMessagesPage.clickSendToInbox();
    }

    public void closeBrowser () {
        PageTools.closeBrowser();
    }


}
