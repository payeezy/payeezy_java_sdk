package com.firstdata.payeezy.models.transaction;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Date;

@JsonAutoDetect(getterVisibility= Visibility.NONE,setterVisibility= Visibility.NONE,fieldVisibility= Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class TransactionResponse extends CommonResponse {

	@JsonProperty("transaction_status")
	private String transactionStatus;
	@JsonProperty("validation_status")
	private String validationStatus;
	@JsonProperty("transaction_type")
	private String transactionType;
	@JsonProperty("transaction_id")
	private String transactionId;
	@JsonProperty("transaction_tag")
	private String transactionTag;
	@JsonProperty("method")
	private String method;
	@JsonProperty("amount")
	private String amount;
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("avs")
	private String avs;
	@JsonProperty("cvv2")
	private String cvv2;
//	private String token
	@JsonProperty("token")
	private Token token;
	@JsonProperty("card")
	private Card card;
	@JsonProperty("bank_resp_code")
	private String bankResponseCode;
	@JsonProperty("bank_resp_code_2")
    private String bankResponseCode2;
    
    @JsonProperty("bank_message")
    private String bankMessage;
    @JsonProperty("gateway_resp_code")
    private String exactResponseCode;
    @JsonProperty("gateway_message")
    private String exactMessage;
    @JsonProperty("correlation_id")
    private String corrID;
    
    @JsonProperty("split_tender_id")
    private String splitTenderId;
    
	@JsonProperty("valuelink")
	private ValueLink valueLink;
	
	@JsonProperty("tele_check")
	private TeleCheck teleCheck;
	
	@JsonProperty("recurring_id")
	private String recurringId;

	@JsonProperty("post_date")
	private String postDate;

	@JsonProperty("value_link_auth_code")
	private String valuelinkAuthCode;

	@JsonProperty("local_currency_code")
	private String localCurrencyCode;

	@JsonProperty("promo_details")
	private String promoDetails;

	@JsonIgnore
	private Date authorizationDate;

	@JsonProperty("transaction_status")
	public String getTransactionStatus() {
		return transactionStatus;
	}

	@JsonProperty("transaction_status")
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	
	@JsonProperty("validation_status")
	public String getValidationStatus() {
		return validationStatus;
	}

	@JsonProperty("validation_status")
	public void setValidationStatus(String validationStatus) {
		this.validationStatus = validationStatus;
	}
	
	@JsonProperty("transaction_type")
	public String getTransactionType() {
		return transactionType;
	}


	@JsonProperty("transaction_type")
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	@JsonProperty("transaction_id")
	public String getTransactionId() {
		return transactionId;
	}

	@JsonProperty("transaction_id")
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


	@JsonProperty("transaction_tag")
	public String getTransactionTag() {
		return transactionTag;
	}


	@JsonProperty("transaction_tag")
	public void setTransactionTag(String transactionTag) {
		this.transactionTag = transactionTag;
	}
	
	@JsonProperty("method")
	public String getMethod() {
		return method;
	}

	@JsonProperty("method")
	public void setMethod(String method) {
		this.method = method;
	}


	@JsonProperty("amount")
	public String getAmount() {
		return amount;
	}


	@JsonProperty("amount")
	public void setAmount(String amount) {
		this.amount = amount;
	}


	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}


	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@JsonProperty("avs")
	public String getAvs() {
		return avs;
	}


	@JsonProperty("avs")
	public void setAvs(String avs) {
		this.avs = avs;
	}


	@JsonProperty("cvv2")
	public String getCvv2() {
		return cvv2;
	}


	@JsonProperty("cvv2")
	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	@JsonProperty("card")
	public Card getCard() {
		return card;
	}

	@JsonProperty("card")
	public void setCard(Card reqCard) {
		this.card = reqCard;
	}

	@JsonProperty("fraud_results")
	private FraudScoreResponse fraudScoreResponse;
    
    public String getBankResponseCode() {
        return bankResponseCode;
    }

    
    public void setBankResponseCode(String bankResponseCode) {
        this.bankResponseCode = bankResponseCode;
    }

    
    public String getBankResponseCode2() {
        return bankResponseCode2;
    }

    
    public void setBankResponseCode2(String bankResponseCode2) {
        this.bankResponseCode2 = bankResponseCode2;
    }

    
    public String getBankMessage() {
        return bankMessage;
    }

    
    public void setBankMessage(String bankMessage) {
        this.bankMessage = bankMessage;
    }

    
    public String getExactResponseCode() {
        return exactResponseCode;
    }

    
    public void setExactResponseCode(String exactResponseCode) {
        this.exactResponseCode = exactResponseCode;
    }

    
    public String getExactMessage() {
        return exactMessage;
    }

    
    public void setExactMessage(String exactMessage) {
        this.exactMessage = exactMessage;
    }

    
    public String getCorrID() {
        return corrID;
    }

    
    public void setCorrID(String corrID) {
        this.corrID = corrID;
    }

	public String getSplitTenderId() {
		return splitTenderId;
	}

	public void setSplitTenderId(String splitTenderId) {
		this.splitTenderId = splitTenderId;
	}

	public ValueLink getValueLink() {
		return valueLink;
	}

	public void setValueLink(ValueLink valueLink) {
		this.valueLink = valueLink;
	}
	
	public TeleCheck getTeleCheck() {
		return teleCheck;
	}

	public void setTeleCheck(TeleCheck teleCheck) {
		this.teleCheck = teleCheck;
	}

	/**
	 * @return the recurringId
	 */
	public String getRecurringId() {
		return recurringId;
	}

	/**
	 * @param recurringId the recurringId to set
	 */
	public void setRecurringId(String recurringId) {
		this.recurringId = recurringId;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getValuelinkAuthCode() {
		return valuelinkAuthCode;
	}

	public void setValuelinkAuthCode(String valuelinkAuthCode) {
		this.valuelinkAuthCode = valuelinkAuthCode;
	}

	public String getLocalCurrencyCode() {
		return localCurrencyCode;
	}

	public void setLocalCurrencyCode(String localCurrencyCode) {
		this.localCurrencyCode = localCurrencyCode;
	}

	public String getPromoDetails() {
		return promoDetails;
	}

	public void setPromoDetails(String promoDetails) {
		this.promoDetails = promoDetails;
	}

	public FraudScoreResponse getFraudScoreResponse() {
		return fraudScoreResponse;
	}

	public void setFraudScoreResponse(FraudScoreResponse fraudScoreResponse) {
		this.fraudScoreResponse = fraudScoreResponse;
	}
}
