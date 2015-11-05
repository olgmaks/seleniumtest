package com.epam.businesslogic;

import com.epam.model.Message;
import com.epam.page.ImportantMessagesPage;
import com.epam.page.InboxMessagesPage;
import com.epam.page.TrashMessagesPage;
import org.apache.log4j.Logger;

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
        inboxMessagesPage = loginService.login().getInboxMessagesPage();
    }


    public List<Message> indicateMessagesAsImportant (Integer ... indexes) {
        return  inboxMessagesPage.indicateMessagesAsImportant(indexes);
    }


    public void openImportantMessagePage () {
        importantMessagesPage = inboxMessagesPage.openImportantMessagesPage();
    }


    public boolean verifyMessagesPresenceAmongImportantMessages(List<Message> messages) {
        return importantMessagesPage.verifyMessagesPresence(messages);
    }


    public List<Message> selectAndDeleteImportantMessages(List<Message> messages) {
        List<Message> result = importantMessagesPage.indicateMessagesAsSelected(messages);
        importantMessagesPage.deleteCheckedMessages();
        return  result;
    }


    public void openTrashMessagePage () {
        trashMessagesPage = importantMessagesPage.openTrashMessagesPage();
    }


    public boolean verifyMessagesPresenceAmongTrashMessages (List<Message> messages) {
        return trashMessagesPage.verifyMessagesPresence(messages);
    }


    public void makeAllTrashUnimportant () {

        for (int i = 0; i < trashMessagesPage.getMessages().size(); i++) {
            trashMessagesPage.indicateMessageAsImportant(i);
        }
    }

    public void moveAllTrashToInbox() {
        trashMessagesPage.indicateMessagesAsSelected(trashMessagesPage.getMessages());
        trashMessagesPage.clickSendToInbox();
    }



}
