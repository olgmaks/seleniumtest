package com.epam.page;

import com.epam.control.element.Button;
import com.epam.control.elementimpl.ButtonImpl;
import com.epam.control.engine.WebDriverUtils;
import com.epam.control.pagetools.PageTools;
import com.epam.control.wraper.WebElementWrapper;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TrashMessagesPage extends HomePage {

    private static final String MORE_ACTION_BUTTON_XPATH = "//div[@gh='tm']/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]";
    private static final String MOVE_TO_INBOX_XPATH = "//div[@class='SK AX']//div[@act='8']";
    public static final String TRASH_MESSAGE_IDENTIFICATOR_XPATH = "//div[@gh='tl']//tbody/tr//img[@class='aqN']";


    @FindBy(xpath = MORE_ACTION_BUTTON_XPATH)
    private Button moreActionsButton;

    @FindBy(xpath = MOVE_TO_INBOX_XPATH)
    private Button moveToInbox;

    public void clickSendToInbox() {

        moreActionsButton.click();

        Actions actions = new Actions(WebDriverUtils.getDriver());

        Action action = actions.clickAndHold(((ButtonImpl) moveToInbox).getWebElement()).release().build();
        action.perform();
    }


    @Override
    protected void waitBeforeInit() {
        new PageTools.WaitForElementsByXpath(TRASH_MESSAGE_IDENTIFICATOR_XPATH);
    }
}
