package com.firstdata.payeezy.models.enrollment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnrollmentApp {
	
	String application;
	
	@JsonProperty("application_id")
	String applicationId;
	
	
	String device;
	
	@JsonProperty("device_id")
	String deviceId;
	
	@JsonProperty("ip_address")
	String ipAddress;
	
	@JsonProperty("true_ip_address")
	String trueIpAddress;
	
	String imei;
	
	@JsonProperty("organization_id")
	String organizationId;
	
	@JsonProperty("session_id")
	String sessionId;
	
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getTrueIpAddress() {
		return trueIpAddress;
	}
	public void setTrueIpAddress(String trueIpAddress) {
		this.trueIpAddress = trueIpAddress;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
	
	
}