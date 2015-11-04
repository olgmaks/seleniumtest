package com.epam.service;

import java.util.List;

import com.epam.model.Message;

public abstract class BaseService {
	
	// Messages
	protected List<Message> messages;

	public abstract List<Message> indicateMessagesAsSelected(Integer... messagesIndexes);

	public abstract List<Message> indicateMessagesAsImportant(Integer... messagesIndexes);
	
	public abstract Boolean verifyMessagesPresence (List<Message> expectedMessages);
	
	protected abstract void initMessages();

}
