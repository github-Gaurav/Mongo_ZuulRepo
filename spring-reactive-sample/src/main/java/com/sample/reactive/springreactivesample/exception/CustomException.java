package com.sample.reactive.springreactivesample.exception;

public class CustomException extends Exception {


	private final String exceptionMessage;
	private final String statusCode;

	public CustomException(String exceptionMessage, String statusCode) {
		super(exceptionMessage);
		this.exceptionMessage = exceptionMessage;
		this.statusCode = statusCode;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}
	@Override
	public String toString() {
		return "CustomException [exceptionMessage=" + exceptionMessage
				+ ", statusCode=" + statusCode + "]";
	}

}
