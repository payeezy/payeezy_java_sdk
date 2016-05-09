package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(getterVisibility = Visibility.DEFAULT, setterVisibility = Visibility.DEFAULT, fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class TokenResponse extends CommonResponse {

	public TokenResponse() {
		super();
	}

	@JsonProperty("type")
	private String type;

	@JsonProperty("transaction_id")
	private String transactionId;

	@JsonProperty("transaction_tag")
	private String transactionTag;

	@JsonProperty("avs")
	private String avs;

	@JsonProperty("token")
	private Transarmor token;

	@JsonProperty("card")
	private Card card;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Transarmor getToken() {
		return token;
	}

	public void setToken(Transarmor token) {
		this.token = token;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public String getAvs() {
		return avs;
	}

	public void setAvs(String avs) {
		this.avs = avs;
	}

}
