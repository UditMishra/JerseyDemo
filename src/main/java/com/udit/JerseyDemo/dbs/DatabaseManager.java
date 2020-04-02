package com.udit.JerseyDemo.dbs;

import java.util.HashMap;
import java.util.Map;

import com.udit.JerseyDemo.models.Message;

public class DatabaseManager {

	private static Map<Integer, Message> messageMap;

	static {
		messageMap = new HashMap<>();
		messageMap.put(1, new Message(1, "First message", "Udit"));
		messageMap.put(2, new Message(2, "Hello world", "Amit"));
		messageMap.put(3, new Message(3, "Stay home", "Sumit"));
	}

	public static Map<Integer, Message> getMessageMap() {
		return messageMap;
	}
}
