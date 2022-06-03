package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomApiException extends RuntimeException {

	private static final long serialVersionUID = -807520916259076805L;

	private Map<String, String> errorMap;

	public CustomApiException(String message) {
		super(message);
	}
}
