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
@JsonAutoDetect(getterVisibility= Visibility.NONE,setterVisibility= Visibility.NONE,fieldVisibility= Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class DebitCard {
	
	@JsonProperty("iban")
	private String iban;
	
	@JsonProperty("mandate_ref")
	private String mandateReference;
	
	@JsonProperty("bic")
	private String bic;

	/**
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * @param iban the iban to set
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * @return the mandateReference
	 */
	public String getMandateReference() {
		return mandateReference;
	}

	/**
	 * @param mandateReference the mandateReference to set
	 */
	public void setMandateReference(String mandateReference) {
		this.mandateReference = mandateReference;
	}

	/**
	 * @return the bic
	 */
	public String getBic() {
		return bic;
	}

	/**
	 * @param bic the bic to set
	 */
	public void setBic(String bic) {
		this.bic = bic;
	}

}
