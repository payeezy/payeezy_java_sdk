package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(getterVisibility= Visibility.NONE,setterVisibility= Visibility.NONE,fieldVisibility= Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaypalTransactionDetail {
    @JsonProperty("correlation_id")
    private String correlationID;
    
    private String timestamp;
    private String authorization;
    
    @JsonProperty("payer_id")
    private String payerId;
    
    @JsonProperty("gross_amount_currency_id")
    private String currencyId;
    
    private boolean success;
    private String message;
    @JsonProperty("cardholder_name")
    private String cardHolderName;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCorrelationID() {
        return correlationID;
    }
    
    public void setCorrelationID(String correlationID) {
        this.correlationID = correlationID;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getAuthorization() {
        return authorization;
    }
    
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }
    
    public String getPayerId() {
        return payerId;
    }
    
    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }
    
    public String getCurrencyId() {
        return currencyId;
    }
    
    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getCardHolderName() {
        return cardHolderName;
    }
    
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
