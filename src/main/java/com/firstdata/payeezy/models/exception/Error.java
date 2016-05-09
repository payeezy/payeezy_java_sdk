package com.firstdata.payeezy.models.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Error {

	@JsonProperty("messages")
	private List<Messages> messages;
	
	public List<Messages> getMessages() {
		return messages;
	}

	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}
}

