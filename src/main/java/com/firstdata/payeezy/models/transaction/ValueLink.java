package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ValueLink {

	@JsonProperty("cardholder_name")
	private String cardHoldersName;
	@JsonProperty("cc_number")
	private String cardNumber;
	@JsonProperty("amount")
	private String dollarAmount;
	@JsonProperty("credit_card_type")
	private final String cardType = "Gift"; // submitting a ValueLink transaction, this property's value is required to be "Gift."
	@JsonProperty("card_cost")
	private String cardCost; // Used for ValueLink activation transactions. This can only be used for ValueLink transactions and is only available in the v9 or higher endpoint.
	@JsonProperty("reference_3")
	private String reference3; // to pass on the Foreign Access Code for ValueLink transactions
	@JsonProperty("ean")
	private String ean; // ValueLink card verification value similar to CVV2 numbers on the back of credit cards.
	@JsonProperty("virtual_card")
	private String virtualCard;
	@JsonProperty("previous_balance")
	private String prevoiusBal;
	@JsonProperty("current_balance")
	private String currentBal;

	public String getCardHoldersName() {
		return cardHoldersName;
	}

	public void setCardHoldersName(String cardHoldersName) {
		this.cardHoldersName = cardHoldersName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getDollarAmount() {
		return dollarAmount;
	}

	public void setDollarAmount(String dollarAmount) {
		this.dollarAmount = dollarAmount;
	}

	public String getCardCost() {
		return cardCost;
	}

	public void setCardCost(String cardCost) {
		this.cardCost = cardCost;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getVirtualCard() {
		return virtualCard;
	}

	public void setVirtualCard(String virtualCard) {
		this.virtualCard = virtualCard;
	}

	public String getCardType() {
		return cardType;
	}

	public String getPrevoiusBal() {
		return prevoiusBal;
	}

	public void setPrevoiusBal(String prevoiusBal) {
		this.prevoiusBal = prevoiusBal;
	}

	public String getCurrentBal() {
		return currentBal;
	}

	public void setCurrentBal(String currentBal) {
		this.currentBal = currentBal;
	}

}
