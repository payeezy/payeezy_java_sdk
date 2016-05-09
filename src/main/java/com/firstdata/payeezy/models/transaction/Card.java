package com.firstdata.payeezy.models.transaction;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(getterVisibility= Visibility.NONE,setterVisibility= Visibility.NONE,fieldVisibility= Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class Card implements Cloneable {

	@JsonProperty("type")
	private String type;

	@JsonProperty("cardholder_name")
	private String name;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("card_number")
	private String number;

	@JsonProperty("exp_date")
	private String expiryDt;

	@JsonProperty("cvv")
	private String cvv;
	
	
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String nmber) {
		this.number = nmber;
	}
	
	public String getExpiryDt() {
		return expiryDt;
	}
	
	public void setExpiryDt(String expiryDt) {
		this.expiryDt = expiryDt;
	}
	
	public String getCvv() {
		return cvv;
	}
	
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public Card clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Card)super.clone();
	}

}
