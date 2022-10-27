package com.tibame.ball.common;

import java.io.Serializable;

public class Result implements Serializable{

	private static final long serialVersionUID = 1L;
	private boolean successful;
	private String message;
	
	
	public Result() {
	}
	
	public Result(boolean successful, String message) {
		this.successful = successful;
		this.message = message;
	}
	public boolean isSuccessful() {
		return successful;
	}
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
