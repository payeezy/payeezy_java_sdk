package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


@JsonAutoDetect(getterVisibility= Visibility.NONE,setterVisibility= Visibility.NONE,fieldVisibility= Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Level2Properties {
    @JsonProperty("tax1_amount")
    private BigDecimal tax1Amount;
    
    @JsonProperty("tax1_number")
    private String tax1Number;
    
    @JsonProperty("tax2_amount")
    private BigDecimal tax2Amount;
    
    @JsonProperty("tax2_number")
    private String tax2Number;
    
    @JsonProperty("customer_ref")
    private String customerReferenceNo;

    
    public BigDecimal getTax1Amount() {
        return tax1Amount;
    }

    
    public void setTax1Amount(BigDecimal tax1Amount) {
        this.tax1Amount = tax1Amount;
    }

    
    public String getTax1Number() {
        return tax1Number;
    }

    
    public void setTax1Number(String tax1Number) {
        this.tax1Number = tax1Number;
    }

    
    public BigDecimal getTax2Amount() {
        return tax2Amount;
    }

    
    public void setTax2Amount(BigDecimal tax2Amount) {
        this.tax2Amount = tax2Amount;
    }

    
    public String getTax2Number() {
        return tax2Number;
    }

    
    public void setTax2Number(String tax2Number) {
        this.tax2Number = tax2Number;
    }

    
    public String getCustomerReferenceNo() {
        return customerReferenceNo;
    }

    
    public void setCustomerReferenceNo(String customerReferenceNo) {
        this.customerReferenceNo = customerReferenceNo;
    }

    
}
