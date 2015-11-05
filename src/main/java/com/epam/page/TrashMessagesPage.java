package com.epam.page;

import com.epam.control.element.Button;
import com.epam.control.wraper.WebElementWrapper;
import com.epam.engine.WebDriverUtils;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;

public class TrashMessagesPage extends HomePage {

    private static final String MORE_ACTION_BUTTON_XPATH = "//div[@gh='tm']/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]";
    private static final String MOVE_TO_INBOX_XPATH = "//div[@class='SK AX']//div[@act='8']";
    private static final String TRASH_MESSAGES_XPATH = "//div[@class='ae4 UI']/div[1]/div[1]/table/tbody/tr";

    @FindBy(xpath = MORE_ACTION_BUTTON_XPATH)
    private Button moreActionsButton;

    @FindBy(xpath = MOVE_TO_INBOX_XPATH)
    private Button moveToInbox;

    public void clickSendToInbox() {


//        WebElement moreActionsButton = driver.findElement(By.xpath(MORE_ACTION_BUTTON_XPATH));
        moreActionsButton.click();

//        WebElement moveToInbox = driver.findElement(By.xpath(MOVE_TO_INBOX_XPATH));
        Action action = new Actions(WebDriverUtils.getDriver()).clickAndHold(((WebElementWrapper) moveToInbox).getElement()).release().build();
        action.perform();
    }

}
