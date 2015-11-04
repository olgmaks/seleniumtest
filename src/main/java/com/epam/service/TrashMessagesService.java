package com.epam.service;

import java.util.List;

import com.epam.model.Message;
import com.epam.model.User;
import com.epam.page.TrashMessagesPage;

public class TrashMessagesService extends BaseService {

	private TrashMessagesPage trashMessagesPage;

	public TrashMessagesService(User user) {
		LoginService loginService = new LoginService(user);
		trashMessagesPage = loginService.login().getInboxMessagesPage().openTrashMessagesPage();
		initMessages();
	}

	public TrashMessagesService(ImportantMessageService importantMessageService) {
		trashMessagesPage = importantMessageService.getImportantMessagesPage().openTrashMessagesPage();
		initMessages();
	}

	@Override
	protected void initMessages() {
		messages = trashMessagesPage.getMessages();
	}

	@Override
	public List<Message> indicateMessagesAsSelected(Integer... messagesIndexes) {
		return Services.indicateMessagesAsSelected(trashMessagesPage, messagesIndexes);
	}

	@Override
	public List<Message> indicateMessagesAsImportant(Integer... messagesIndexes) {
		return Services.indicateMessagesAsImportant(trashMessagesPage, messagesIndexes);
	}

	@Override
	public Boolean verifyMessagesPresence(List<Message> expectedMessages) {
		return Services.verifyMessagesPresence(trashMessagesPage, expectedMessages);
	}

	public List<Message> moveMessagesToInbox() {

		Integer[] array = new Integer[messages.size()];

		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}

		indicateMessagesAsSelected(array);
		
		trashMessagesPage.clickSendToInbox();

		return messages;
	}
	
	public List<Message> getMessages() {
		return messages;
	}

}
