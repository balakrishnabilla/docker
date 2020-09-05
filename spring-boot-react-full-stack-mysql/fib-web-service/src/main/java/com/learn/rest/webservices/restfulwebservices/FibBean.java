package com.learn.rest.webservices.restfulwebservices;

public class FibBean {

	private String message;

	public FibBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("FibBean [message=%s]", message);
	}

}
