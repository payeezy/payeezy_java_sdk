package com.firstdata.payeezy.models.transaction;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE,
fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)

public class ThreeDomainSecureHeader {
    @JsonProperty("applicationDataHash")
    private String applicationDataHash;
    @JsonProperty("ephemeralPublicKey")
    private String ephemeralPublicKey;
    @JsonProperty("publicKeyHash")
    private String publicKeyHash;
    @JsonProperty("transactionId")
    private String transactionId;
    
    public String getApplicationDataHash() {
        return applicationDataHash;
    }
    
    public void setApplicationDataHash(String applicationDataHash) {
        this.applicationDataHash = applicationDataHash;
    }
    
    public String getEphemeralPublicKey() {
        return ephemeralPublicKey;
    }
    
    public void setEphemeralPublicKey(String ephemeralPublicKey) {
        this.ephemeralPublicKey = ephemeralPublicKey;
    }
    
    public String getPublicKeyHash() {
        return publicKeyHash;
    }
    
    public void setPublicKeyHash(String publicKeyHash) {
        this.publicKeyHash = publicKeyHash;
    }
    
    public String getTransactionId() {
        return transactionId;
    }
    
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    
    
    
}
