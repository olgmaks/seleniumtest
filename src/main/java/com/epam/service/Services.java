package com.epam.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.model.Message;
import com.epam.page.BasePage;

public class Services {

	public static List<Message> indicateMessagesAsImportant(BasePage page, Integer... messagesIndexes) {

		List<Message> indicatedMessages = new ArrayList<>();

		List<Message> messages = page.getMessages();

		for (Integer index : messagesIndexes) {

			Message currentMessage = messages.get(index);

			if (!currentMessage.getImportant()) {
				page.indicateMessageAsImportant(index);
			}

			indicatedMessages.add(currentMessage);

		}

		return indicatedMessages;
	}

	public static List<Message> indicateMessagesAsSelected(BasePage page, Integer... messagesIndexes) {

		List<Message> selectedMessages = new ArrayList<>();

		List<Message> messages = page.getMessages();

		for (Integer index : messagesIndexes) {

			Message currentMessage = messages.get(index);

			if (!currentMessage.getIndicated()) {
				page.indicateMessageAsSelected(index);
			}

			selectedMessages.add(currentMessage);

		}

		return selectedMessages;
	}

	public static Boolean verifyMessagesPresence(BasePage page, List<Message> expectedMessages) {

		if (expectedMessages == null || expectedMessages.isEmpty()) {
			return false;
		}

		List<Message> messages = page.getMessages();

		Boolean result = messages.containsAll(expectedMessages);

		return result;
	}

}
