package com.epam.page;

import com.epam.control.pagetools.PageTools;

public class ImportantMessagesPage extends HomePage {


    public static final String IMPORTANT_MESSAGES_IDENTIFICATOR_XPATH = "//div[@gh='tl']//tbody/tr//div[@class='av']";

    public ImportantMessagesPage () {
    }

    @Override
    protected void waitBeforeInit() {
        PageTools.waitForElementsByXpath(IMPORTANT_MESSAGES_IDENTIFICATOR_XPATH);
    }
}
