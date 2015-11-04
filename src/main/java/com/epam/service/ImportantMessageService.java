package com.epam.service;

import java.util.List;

import com.epam.model.Message;
import com.epam.model.User;
import com.epam.page.ImportantMessagesPage;
import com.epam.page.InboxMessagesPage;

public class ImportantMessageService extends BaseService {

	// Pages
	private ImportantMessagesPage importantMessagesPage;
	private InboxMessagesPage inboxMessagesPage;

	// Messages
	private List<Message> messages;

	// Will continue previous services executions
	public ImportantMessageService(InboxMessagesService inboxMessagesService) {

		inboxMessagesPage = inboxMessagesService.getInboxMessagesPage();

		importantMessagesPage = inboxMessagesPage.openImportantMessagesPage();

		initMessages();
	}

	// Will login and open
	public ImportantMessageService(User user) {

		LoginService loginService = new LoginService(user);

		inboxMessagesPage = loginService.login().getInboxMessagesPage();

		importantMessagesPage = inboxMessagesPage.openImportantMessagesPage();

		initMessages();
	}

	@Override
	public void initMessages() {
		messages = importantMessagesPage.getMessages();
	}


	@Override
	public List<Message> indicateMessagesAsSelected(Integer... messagesIndexes) {
		return Services.indicateMessagesAsSelected(importantMessagesPage, messagesIndexes);
	}

	@Override
	public List<Message> indicateMessagesAsImportant(Integer... messagesIndexes) {
		return Services.indicateMessagesAsImportant(importantMessagesPage, messagesIndexes);
	}

	@Override
	public Boolean verifyMessagesPresence(List<Message> expectedMessages) {
		return Services.verifyMessagesPresence(importantMessagesPage, expectedMessages);
	}

	public void selectMessagesAndRemove(Integer... messagesIndexes) {
		indicateMessagesAsSelected(messagesIndexes);
		importantMessagesPage.deleteCheckedMessages();
	}

	public void selectMessagesAndRemove(List<Message> messagesToBeRemoved) {

		Integer[] array = new Integer[messagesToBeRemoved.size()];

		int index = 0;
		for (Message m : messagesToBeRemoved) {

			array[index] = messages.indexOf(m);

			index++;

		}

		selectMessagesAndRemove(array);
	}
	

	public List<Message> getMessages() {
		return messages;
	}

	public ImportantMessagesPage getImportantMessagesPage() {
		return importantMessagesPage;
	}
}
