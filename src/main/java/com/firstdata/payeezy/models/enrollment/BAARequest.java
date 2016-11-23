package com.firstdata.payeezy.models.enrollment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BAARequest {

	@JsonProperty("application")
	private EnrollmentApp enrollmentApplication;
	
	@JsonProperty("subscriber_id")
	private String subscriberId;
	
	@JsonProperty("token")
	private String token;
	
	@JsonProperty("authentication_answer")
	private int authenticationAnswer;
	
	

	public EnrollmentApp getEnrollmentApplication() {
		return enrollmentApplication;
	}
	public void setEnrollmentApplication(EnrollmentApp enrollmentApplication) {
		this.enrollmentApplication = enrollmentApplication;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getAuthenticationAnswer() {
		return authenticationAnswer;
	}
	public void setAuthenticationAnswer(int authenticationAnswer) {
		this.authenticationAnswer = authenticationAnswer;
	}
	public String getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}
	
	
	
}
