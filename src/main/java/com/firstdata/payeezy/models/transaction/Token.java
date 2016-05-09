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
public class Token {
    @JsonProperty("token_type")
    private String tokenType;
    
    @JsonProperty("token_data")
    private Transarmor tokenData;

    
    public String getTokenType() {
        return tokenType;
    }

    
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    
    public Transarmor getTokenData() {
        return tokenData;
    }

    
    public void setTokenData(Transarmor tokenData) {
        this.tokenData = tokenData;
    }
    
    
}
