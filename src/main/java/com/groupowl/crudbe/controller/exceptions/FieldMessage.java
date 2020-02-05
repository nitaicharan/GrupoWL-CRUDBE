package com.groupowl.crudbe.controller.exceptions;

public class FieldMessage {
	private String fielName;
	private String message;
	
	public void FielMessage() {	
	}

	public FieldMessage(String fielName, String message) {
		super();
		this.fielName = fielName;
		this.message = message;
	}

	public String getFielName() {
		return fielName;
	}

	public void setFielName(String fielName) {
		this.fielName = fielName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
