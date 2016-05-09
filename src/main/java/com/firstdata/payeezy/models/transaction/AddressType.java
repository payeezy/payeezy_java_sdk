package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by FA7G14Q on 7/18/2015.
 */
public class AddressType {
    @JsonProperty("type")
    private String type;
    @JsonProperty("ind")
    private String indicator;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }
}
