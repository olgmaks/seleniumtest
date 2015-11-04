package com.epam.service;

import java.util.List;

import com.epam.model.Message;
import com.epam.model.User;
import com.epam.page.InboxMessagesPage;

public class InboxMessagesService extends BaseService {

	// Services
	private LoginService loginService;

	// Pages
	private InboxMessagesPage inboxMessagesPage;

	public InboxMessagesService(User user) {
		loginService = new LoginService(user);
		initInbox();

	}

	public InboxMessagesService(LoginService loginService) {
		this.loginService = loginService;
		initInbox();
	}

	private void initInbox() {
		inboxMessagesPage = loginService.login().getInboxMessagesPage();
	}

	@Override
	protected void initMessages() {
		messages = inboxMessagesPage.getMessages();
	}

	@Override
	public List<Message> indicateMessagesAsImportant(Integer... messagesIndexes) {
		return Services.indicateMessagesAsImportant(inboxMessagesPage, messagesIndexes);
	}

	@Override
	public List<Message> indicateMessagesAsSelected(Integer... messagesIndexes) {
		return Services.indicateMessagesAsSelected(inboxMessagesPage, messagesIndexes);
	}

	@Override
	public Boolean verifyMessagesPresence(List<Message> expectedMessages) {
		return Services.verifyMessagesPresence(inboxMessagesPage, expectedMessages);
	}

	public InboxMessagesPage getInboxMessagesPage() {
		return inboxMessagesPage;
	}

	public List<Message> getMessages() {
		return messages;
	}

}
