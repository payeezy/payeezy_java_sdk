package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by FA7G14Q on 9/1/2015.
 */
@JsonAutoDetect(getterVisibility= JsonAutoDetect.Visibility.DEFAULT,setterVisibility= JsonAutoDetect.Visibility.DEFAULT,fieldVisibility= JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GiftRegistry {
    @JsonProperty("gift_registry_flag")
    private String giftRegistryFlag;

    @JsonProperty("gift_reg_address")
    private Address address;


    public String getGiftRegistryFlag() {
        return giftRegistryFlag;
    }

    public void setGiftRegistryFlag(String giftRegistryFlag) {
        this.giftRegistryFlag = giftRegistryFlag;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
