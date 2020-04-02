package com.udit.JerseyDemo.services;

import java.util.ArrayList;
import java.util.List;

import com.udit.JerseyDemo.dbs.DatabaseManager;
import com.udit.JerseyDemo.models.Message;

public class MessageService {

	public MessageService() {
	}

	public List<Message> getMessages() {
		return new ArrayList<>(DatabaseManager.getMessageMap().values());
	}

	public Message getMessage(int messageId) {
		return DatabaseManager.getMessageMap().get(messageId);
	}

	public Message createMessage(Message message) {
		message.setId(DatabaseManager.getMessageMap().size() + 1);
		DatabaseManager.getMessageMap().put(message.getId(), message);
		return getMessage(message.getId());
	}

	public Message updateMessage(int messageId, Message message) {
		message.setId(messageId);
		DatabaseManager.getMessageMap().put(message.getId(), message);
		return getMessage(message.getId());
	}

	public void removeMessage(int messageId) {
		DatabaseManager.getMessageMap().remove(messageId);
	}
}
