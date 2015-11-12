package com.epam.page;

import com.epam.control.pagetools.PageTools;

public class InboxMessagesPage extends HomePage {

    public InboxMessagesPage() {

    }

    @Override
    protected void waitBeforeInit() {
        new PageTools.WaitForElementsByXpath(MESSAGES_BOX_XPATH);
    }
}
