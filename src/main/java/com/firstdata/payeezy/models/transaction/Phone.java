package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(getterVisibility= Visibility.NONE,setterVisibility= Visibility.NONE,fieldVisibility= Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Phone {
    
    @JsonProperty("type")
    private String type;
    @JsonProperty("number")
    private String number;
    
    
    public String getType() {
        return type;
    }
    
    
    public void setType(String type) {
        this.type = type;
    }
    
    
    public String getNumber() {
        return number;
    }
    
    
    public void setNumber(String number) {
        this.number = number;
    }
    
}
