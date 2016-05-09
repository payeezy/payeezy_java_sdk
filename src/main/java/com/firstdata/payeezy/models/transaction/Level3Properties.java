package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonAutoDetect(getterVisibility= Visibility.NONE,setterVisibility= Visibility.NONE,fieldVisibility= Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Level3Properties {
    @JsonProperty("tax_amount")
    private BigDecimal taxAmount;
    
    @JsonProperty("tax_rate")
    private BigDecimal taxRate;
    
    @JsonProperty("alt_tax_amount")
    private BigDecimal altTaxAmount;
    
    @JsonProperty("alt_tax_id")
    private String altTaxId;
    
    @JsonProperty("discount_amount")
    private BigDecimal discountAmount;
    
    @JsonProperty("duty_amount")
    private BigDecimal dutyAmount;
    
    @JsonProperty("ship_date")
    private Date date;

    @JsonProperty("ship_carrier_name")
    private String shippingCarrierName;

    @JsonProperty("ship_method")
    private String shipMethod;


    @JsonProperty("ship_comments")
    private String shippingComments;

    @JsonProperty("freight_amount")
    private BigDecimal freightAmount;

    @JsonProperty("ship_from_zip")
    private String shipFromZip;
    
    @JsonProperty("ship_to_address")
    private ShipToAddress shipToAddress;

    @JsonProperty("line_items")
    private List<LineItem> lineItems = new ArrayList<LineItem>();


    @JsonProperty("text_message")
    private String textMessage;

    @JsonProperty("collection_store_id")
    private String collectionStoreId;

    @JsonProperty("comp_name")
    private String companyName;

    @JsonProperty("delivery_ind")
    private String deliveryIndicator;

    public String getDeliveryIndicator() {
        return deliveryIndicator;
    }

    public void setDeliveryIndicator(String deliveryIndicator) {
        this.deliveryIndicator = deliveryIndicator;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCollectionStoreId() {
        return collectionStoreId;
    }

    public void setCollectionStoreId(String collectionStoreId) {
        this.collectionStoreId = collectionStoreId;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    
    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    
    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    
    public BigDecimal getAltTaxAmount() {
        return altTaxAmount;
    }

    
    public void setAltTaxAmount(BigDecimal altTaxAmount) {
        this.altTaxAmount = altTaxAmount;
    }

    
    public String getAltTaxId() {
        return altTaxId;
    }

    
    public void setAltTaxId(String altTaxId) {
        this.altTaxId = altTaxId;
    }

    
    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    
    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    
    public BigDecimal getDutyAmount() {
        return dutyAmount;
    }

    
    public void setDutyAmount(BigDecimal dutyAmount) {
        this.dutyAmount = dutyAmount;
    }

    
    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    
    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    
    public String getShipFromZip() {
        return shipFromZip;
    }

    
    public void setShipFromZip(String shipFromZip) {
        this.shipFromZip = shipFromZip;
    }

    
    public ShipToAddress getShipToAddress() {
        return shipToAddress;
    }

    
    public void setShipToAddress(ShipToAddress shipToAddress) {
        this.shipToAddress = shipToAddress;
    }

    
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }
}
