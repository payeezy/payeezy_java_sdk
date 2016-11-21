package com.firstdata.payeezy.models.enrollment;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.firstdata.payeezy.models.exception.Messages;

import java.util.List;

@JsonAutoDetect(getterVisibility=Visibility.NONE,setterVisibility=Visibility.NONE,fieldVisibility=Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class ACHPayTokenResponse {

	// <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	// <UcommEnrollmentResponse xmlns="http://cmi.connectpay.1dc.com/achReload">
	// <UcommBaseResponse><EnrollmentId>2000000003005978</EnrollmentId>
	// <StatusCode>0</StatusCode><StatusDescription>ACTIVE</StatusDescription>
	// <ResponseVerbiage></ResponseVerbiage><TeleCheckTraceID>1400320000000007236852</TeleCheckTraceID>
	// <TeleCheckDetails><TCKResponseCode>07</TCKResponseCode>
	// <ApproveCode>1107</ApproveCode><DisplayText>APPROVED </DisplayText><SequenceID>96</SequenceID><ECAOfferedCode>Y</ECAOfferedCode></TeleCheckDetails>
	// <UcommApplication><SubscriberId>36003347</SubscriberId></UcommApplication><UcommEnrollmentDataError/></UcommBaseResponse></UcommEnrollmentResponse>
	
	
	@JsonProperty("enrollment_id")
	private String enrollmentId;
	
	@JsonProperty("status_code")
	private String statusCode;
	
	@JsonProperty("status_description")
	private String statusDescription;
	
	@JsonProperty("response_verbiage")
	private String responseVerbiage;
	
	@JsonProperty("tele_check_trace_id")
	private String teleCheckTraceID;
	
	@JsonProperty("tck_response_code")
	private String tckResponseCode;
	
	@JsonProperty("approve_code")
	private String approveCode;
	
	@JsonProperty("display_text")
	private String displayText;
	
	@JsonProperty("sequence_id")
	private String sequenceID;
	
	@JsonProperty("eca_offered_code")
	private String ecaOfferedCode;
	
	private String subscriberId;
	private List<Messages> errorMessages;
	
	
	public String getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	public String getResponseVerbiage() {
		return responseVerbiage;
	}
	public void setResponseVerbiage(String responseVerbiage) {
		this.responseVerbiage = responseVerbiage;
	}
	public String getTeleCheckTraceID() {
		return teleCheckTraceID;
	}
	public void setTeleCheckTraceID(String teleCheckTraceID) {
		this.teleCheckTraceID = teleCheckTraceID;
	}
	public String getTckResponseCode() {
		return tckResponseCode;
	}
	public void setTckResponseCode(String tckResponseCode) {
		this.tckResponseCode = tckResponseCode;
	}
	public String getApproveCode() {
		return approveCode;
	}
	public void setApproveCode(String approveCode) {
		this.approveCode = approveCode;
	}
	public String getDisplayText() {
		return displayText;
	}
	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}
	public String getSequenceID() {
		return sequenceID;
	}
	public void setSequenceID(String sequenceID) {
		this.sequenceID = sequenceID;
	}
	public String getEcaOfferedCode() {
		return ecaOfferedCode;
	}
	public void setEcaOfferedCode(String ecaOfferedCode) {
		this.ecaOfferedCode = ecaOfferedCode;
	}
	public String getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}
	public List<Messages> getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(List<Messages> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public boolean hasErrors() {
		return this.errorMessages != null && this.errorMessages.size() > 0;
	}
	
	
}
