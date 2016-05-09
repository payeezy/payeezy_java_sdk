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
public class TeleCheck {
		@JsonProperty("accountholder_name")
	private String accountholderName;

	@JsonProperty("check_number")
	private String checkNumber;

	@JsonProperty("check_type")
	private String checkType;

	@JsonProperty("account_number")
	private String bankAccountNumber;

	@JsonProperty("routing_number")
	private String bankRoutingNumber;
	
	@JsonProperty("customer_id_type")
	private String customerIdType;
	
	@JsonProperty("customer_id_number")
	private String customerIdNumber;
	
	@JsonProperty("client_email")
	private String clientEmail;
	
	@JsonProperty("release_type")
	private String releaseType;
	
	@JsonProperty("gift_card_amount")
	private String giftCardAmount;
	
	@JsonProperty("date_of_birth")
	private String dateOfBirth;
	
	@JsonProperty("vip")
	private String vip;
	
	@JsonProperty("registration_number")
	private String registrationNumber;
	
	@JsonProperty("registration_date")
	private String registrationDate;
	
	@JsonProperty("clerk_id")
	private String clerkId;
	
	@JsonProperty("device_id")
	private String deviceId;
	
	@JsonProperty("micr")
	private String micr;
	

	/**
	 * @return the accountholderName
	 */
	public String getAccountholderName() {
		return accountholderName;
	}

	/**
	 * @param accountholderName the accountholderName to set
	 */
	public void setAccountholderName(String accountholderName) {
		this.accountholderName = accountholderName;
	}

	/**
	 * @return the checkNumber
	 */
	public String getCheckNumber() {
		return checkNumber;
	}

	/**
	 * @param checkNumber the checkNumber to set
	 */
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	/**
	 * @return the checkType
	 */
	public String getCheckType() {
		return checkType;
	}

	/**
	 * @param checkType the checkType to set
	 */
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	/**
	 * @return the bankAccountNumber
	 */
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	/**
	 * @param bankAccountNumber the bankAccountNumber to set
	 */
	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	/**
	 * @return the bankRoutingNumber
	 */
	public String getBankRoutingNumber() {
		return bankRoutingNumber;
	}

	/**
	 * @param bankRoutingNumber the bankRoutingNumber to set
	 */
	public void setBankRoutingNumber(String bankRoutingNumber) {
		this.bankRoutingNumber = bankRoutingNumber;
	}

	/**
	 * @return the customerIdType
	 */
	public String getCustomerIdType() {
		return customerIdType;
	}

	/**
	 * @param customerIdType the customerIdType to set
	 */
	public void setCustomerIdType(String customerIdType) {
		this.customerIdType = customerIdType;
	}

	/**
	 * @return the customerIdNumber
	 */
	public String getCustomerIdNumber() {
		return customerIdNumber;
	}

	/**
	 * @param customerIdNumber the customerIdNumber to set
	 */
	public void setCustomerIdNumber(String customerIdNumber) {
		this.customerIdNumber = customerIdNumber;
	}

	/**
	 * @return the clientEmail
	 */
	public String getClientEmail() {
		return clientEmail;
	}

	/**
	 * @param clientEmail the clientEmail to set
	 */
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	/**
	 * @return the releaseType
	 */
	public String getReleaseType() {
		return releaseType;
	}

	/**
	 * @param releaseType the releaseType to set
	 */
	public void setReleaseType(String releaseType) {
		this.releaseType = releaseType;
	}

	/**
	 * @return the giftCardAmount
	 */
	public String getGiftCardAmount() {
		return giftCardAmount;
	}

	/**
	 * @param giftCardAmount the giftCardAmount to set
	 */
	public void setGiftCardAmount(String giftCardAmount) {
		this.giftCardAmount = giftCardAmount;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the vip
	 */
	public String getVip() {
		return vip;
	}

	/**
	 * @param vip the vip to set
	 */
	public void setVip(String vip) {
		this.vip = vip;
	}

	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the registrationDate
	 */
	public String getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * @return the clerkId
	 */
	public String getClerkId() {
		return clerkId;
	}

	/**
	 * @param clerkId the clerkId to set
	 */
	public void setClerkId(String clerkId) {
		this.clerkId = clerkId;
	}

	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the micr
	 */
	public String getMicr() {
		return micr;
	}

	/**
	 * @param micr the micr to set
	 */
	public void setMicr(String micr) {
		this.micr = micr;
	}
	
}
