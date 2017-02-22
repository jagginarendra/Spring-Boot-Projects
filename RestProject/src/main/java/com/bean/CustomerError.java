package com.bean;

public class CustomerError {

	private String errorMessage;
	
	private String errorCode;
	
	private String documentation;

	public CustomerError() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerError(String errorMessage , String errorCode , String documentation) {
		
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.documentation = documentation;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
	
}
