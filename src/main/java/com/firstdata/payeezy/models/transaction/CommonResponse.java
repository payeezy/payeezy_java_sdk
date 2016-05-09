package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.firstdata.payeezy.models.exception.Error;

@JsonAutoDetect(getterVisibility = Visibility.DEFAULT, setterVisibility = Visibility.DEFAULT, fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class CommonResponse {

	@JsonProperty("correlation_id")
	private String corrID;
	
	@JsonProperty("status")
	private String status;

	@JsonProperty("Error")
	private Error error;

	public String getCorrID() {
		return corrID;
	}

	public void setCorrID(String corrID) {
		this.corrID = corrID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
