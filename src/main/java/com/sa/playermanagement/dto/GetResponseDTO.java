package com.sa.playermanagement.dto;

public class GetResponseDTO {
	
	public static String FAILED = "Request Processing Failed";
	public static String SUCCEEDED = "Request Processed Successfully";
	
	private String requestStatus;
	private String message;
	
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
