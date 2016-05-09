package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by fa7g14q on 1/26/2016.
 */
@JsonAutoDetect(getterVisibility= JsonAutoDetect.Visibility.NONE,setterVisibility= JsonAutoDetect.Visibility.NONE,fieldVisibility= JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingDetails extends ShipToAddress {

    @JsonProperty("ship_date")
    private String date;

    @JsonProperty("ship_carrier_name")
    private String shippingCarrierName;

    @JsonProperty("ship_method")
    private String shipMethod;

    @JsonProperty("ship_comments")
    private String shippingComments;

    @JsonProperty("ship_from_zip")
    private String shipFromZip;

    @JsonProperty("text_message")
    private String textMessage;

    @JsonProperty("collection_store_id")
    private String collectionStoreId;

    @JsonProperty("comp_name")
    private String companyName;

    @JsonProperty("delivery_ind")
    private String deliveryIndicator;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShippingCarrierName() {
        return shippingCarrierName;
    }

    public void setShippingCarrierName(String shippingCarrierName) {
        this.shippingCarrierName = shippingCarrierName;
    }

    public String getShipMethod() {
        return shipMethod;
    }

    public void setShipMethod(String shipMethod) {
        this.shipMethod = shipMethod;
    }

    public String getShippingComments() {
        return shippingComments;
    }

    public void setShippingComments(String shippingComments) {
        this.shippingComments = shippingComments;
    }

    public String getShipFromZip() {
        return shipFromZip;
    }

    public void setShipFromZip(String shipFromZip) {
        this.shipFromZip = shipFromZip;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getCollectionStoreId() {
        return collectionStoreId;
    }

    public void setCollectionStoreId(String collectionStoreId) {
        this.collectionStoreId = collectionStoreId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDeliveryIndicator() {
        return deliveryIndicator;
    }

    public void setDeliveryIndicator(String deliveryIndicator) {
        this.deliveryIndicator = deliveryIndicator;
    }
}
