package com.firstdata.payeezy.models.exception;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Messages {
    @JsonProperty("code")
    private String code;
    @JsonProperty("description")
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
