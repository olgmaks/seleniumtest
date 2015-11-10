package com.epam.page;

import com.epam.control.element.Button;
import com.epam.control.marker.Decorable;
import com.epam.control.pagetools.PageTools;
import com.epam.model.Message;
import com.epam.transformer.MessageTransformer;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    protected static final String DELETE_CHECKED_MESSAGES_BUTTON_XPATH = "//div[@gh='tm']//div[@act='10']";
    protected static final String MORE_MENU_OPTIONS_BUTTON_XPATH = "//span[@class='ait']";
    protected static final String IMPORTANT_MESSAGES_BUTTON_XPATH = "//div[@role='navigation']/div/div[3]//div[@class='LrBjie']/div/div[1]";
    protected static final String MESSAGES_BOX_XPATH = "//div[@gh='tl']//tbody/tr";


    @FindBy(xpath = MORE_MENU_OPTIONS_BUTTON_XPATH)
    protected Button moreOptionsButton;

    @FindBy(xpath = DELETE_CHECKED_MESSAGES_BUTTON_XPATH)
    protected Button deleteCheckedButton;

    @FindBy(xpath = IMPORTANT_MESSAGES_BUTTON_XPATH)
    protected Button importantMessagesButton;


    @FindBy(xpath = MESSAGES_BOX_XPATH)
    protected List<Decorable> messageTableRows;


    protected List<MessageElement> messagesElements;

    protected void waitBeforeInit() {
    }

    public HomePage() {

        waitBeforeInit();
//        new WebDriverWait(WebDriverUtils.getDriver(), 10, 1000).
//                until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//                        By.xpath("//div[@gh='tl']//tbody/tr")));

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        PageTools.initPageElements(this);
        messagesElements = MessageTransformer.transformTableRowsToPageObjectMessages(messageTableRows);
    }


    public void indicateMessageAsImportant(Integer index) {
        messagesElements.get(index).getImportantCheckBox().check();
    }


    public void indicateMessageAsSelected(Integer index) {
        messagesElements.get(index).getIndicatedCheckBox().check();
    }


    // Trash
    public TrashMessagesPage openTrashMessagesPage() {

        moreOptionsButton.click();

        PageTools.executeJS("document.getElementsByClassName('UKr6le')[8].click();");

        return new TrashMessagesPage();
    }


    // Important
    public ImportantMessagesPage openImportantMessagesPage() {


        moreOptionsButton.click();

        importantMessagesButton.click();

        return new ImportantMessagesPage();

    }


    public void deleteCheckedMessages() {

        deleteCheckedButton.click();

    }

    public List<Message> getMessages() {
        return MessageTransformer.transformPageObjectToModelMessages(messagesElements);
    }


    public List<Message> indicateMessagesAsImportant(Integer... messagesIndexes) {

        List<Message> indicatedMessages = new ArrayList<>();

        List<Message> messages = getMessages();

        for (Integer index : messagesIndexes) {

            Message currentMessage = messages.get(index);


            indicateMessageAsImportant(index);


            indicatedMessages.add(currentMessage);

        }

        return indicatedMessages;
    }


    public List<Message> indicateMessagesAsSelected(Integer... messagesIndexes) {

        List<Message> selectedMessages = new ArrayList<>();

        List<Message> messages = getMessages();

        for (Integer index : messagesIndexes) {

            Message currentMessage = messages.get(index);


            indicateMessageAsSelected(index);


            selectedMessages.add(currentMessage);

        }

        return selectedMessages;
    }


    public List<Message> indicateMessagesAsSelected(List<Message> messagesToBeSelected) {

        List<Message> messages = getMessages();

        ArrayList<Integer> indexes = new ArrayList<>();

        for (Message m : messagesToBeSelected) {
            indexes.add(messages.indexOf(m));
        }

        return indicateMessagesAsSelected(indexes.toArray(new Integer[indexes.size()]));

    }


    public Boolean verifyMessagesPresence(List<Message> expectedMessages) {

        if (expectedMessages == null || expectedMessages.isEmpty()) {
            return false;
        }

        List<Message> messages = getMessages();

        Boolean result = messages.containsAll(expectedMessages);

        if (!result) {
            System.out.println("Expected : " + expectedMessages);
            System.out.println("Found : " + messages);
        }

        return result;
    }

}
