package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * This holds the additional shipping information that needs to be sent to FFD
 */
@JsonAutoDetect(getterVisibility= JsonAutoDetect.Visibility.NONE,setterVisibility= JsonAutoDetect.Visibility.NONE,fieldVisibility= JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalShippingInfo {

    @JsonProperty("shipping_address")
    List<ShippingDetails> shippingDetailsList;

    public List<ShippingDetails> getShippingDetailsList() {
        return shippingDetailsList;
    }

    public void setShippingDetailsList(List<ShippingDetails> shippingDetailsList) {
        this.shippingDetailsList = shippingDetailsList;
    }
}
