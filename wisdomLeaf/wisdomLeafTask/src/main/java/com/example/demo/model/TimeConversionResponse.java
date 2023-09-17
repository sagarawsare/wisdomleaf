package com.example.demo.model;

public class TimeConversionResponse {
	private String message;

    public TimeConversionResponse(String message) {
        this.message = message;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
