package com.epam.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.model.Message;
import com.epam.model.User;
import com.epam.page.InboxMessagesPage;
import com.epam.page.MessageItemFragment;

public class InboxMessagesService {

	private LoginService loginService;

	private InboxMessagesPage inboxMessagesPage;

	public InboxMessagesService(User user) {
		LoginService loginService = new LoginService(user);
		this.loginService = loginService;
	}

	public InboxMessagesService(LoginService loginService) {
		this.loginService = loginService;
	}

	public InboxMessagesService indicateMessagesAsImportant(Integer... messagesNumbers) {

		List<Message> result = new ArrayList<>();

		inboxMessagesPage = loginService.login().getInboxMessagesPage();

		List<MessageItemFragment> messages = inboxMessagesPage.getMessages();

		for (Integer index : messagesNumbers) {
			
			if (!messages.get(index).getMessage().getImportant()) {
				inboxMessagesPage.indicateMessageAsImportant(index);
			}
			
			result.add(messages.get(index).getMessage());
		}

		return this;
	}

}
