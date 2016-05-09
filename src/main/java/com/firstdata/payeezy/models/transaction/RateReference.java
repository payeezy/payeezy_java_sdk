/**
 * 
 */
package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author rveerama
 *
 */
@JsonAutoDetect(getterVisibility= Visibility.DEFAULT,setterVisibility= Visibility.DEFAULT,fieldVisibility= Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class RateReference {
	
	@JsonProperty("rate_id")
	private String rateId;
	
	@JsonProperty("dcc_applied")
	private String dccApplied;

	@JsonProperty("type")
	private String type;
	
	/**
	 * @return the rateId
	 */
	public String getRateId() {
		return rateId;
	}

	/**
	 * @param rateId the rateId to set
	 */
	public void setRateId(String rateId) {
		this.rateId = rateId;
	}

	/**
	 * @return the dccApplied
	 */
	public String getDccApplied() {
		return dccApplied;
	}

	/**
	 * @param dccApplied the dccApplied to set
	 */
	public void setDccApplied(String dccApplied) {
		this.dccApplied = dccApplied;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
