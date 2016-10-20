package com.firstdata.payeezy.models.enrollment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BAARequest {

	@JsonProperty("application")
	private EnrollmentApp enrollmentApplication;
	
	@JsonProperty("subscriber_id")
	private String subscriberId;
	
	@JsonProperty("enrollment_id")
	private String enrollmentId;
	
	@JsonProperty("authentication_answer")
	private int authenticationAnswer;
	
	

	public EnrollmentApp getEnrollmentApplication() {
		return enrollmentApplication;
	}
	public void setEnrollmentApplication(EnrollmentApp enrollmentApplication) {
		this.enrollmentApplication = enrollmentApplication;
	}
	public String getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
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
