package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OriginalDetails {

	@JsonProperty("local_date_time")
	private String localDateTime;
	
	@JsonProperty("response_code")
	private String respCode;
	
	@JsonProperty("stan")
	private String stan;
	
	@JsonProperty("transmission_date_time")
	private String trnmsnDateTime;
	
	public String getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(String localDateTime) {
		this.localDateTime = localDateTime;
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getStan() {
		return stan;
	}
	public void setStan(String stan) {
		this.stan = stan;
	}
	public String getTrnmsnDateTime() {
		return trnmsnDateTime;
	}
	public void setTrnmsnDateTime(String trnmsnDateTime) {
		this.trnmsnDateTime = trnmsnDateTime;
	}
	
	
}
