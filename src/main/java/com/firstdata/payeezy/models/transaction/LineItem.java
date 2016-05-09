package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonAutoDetect(getterVisibility= Visibility.NONE,setterVisibility= Visibility.NONE,fieldVisibility= Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItem {
    @JsonProperty("commodity_code")
    private String commodityCode;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("discount_amount")
    private BigDecimal discountAmount;
    
    @JsonProperty("discount_indicator")
    private String discountIndicator;
    
    @JsonProperty("gross_net_indicator")
    private String grossNetIndicator;
    
    @JsonProperty("line_item_total")
    private BigDecimal lineItemTotal;
    
    @JsonProperty("product_code")
    private String productCode;
    
    @JsonProperty("quantity")
    private String quantity;
    
    @JsonProperty("tax_amount")
    private BigDecimal taxAmount;
    
    @JsonProperty("tax_rate")
    private BigDecimal taxRate;

    @JsonProperty("unit_tax")
    private BigDecimal unitTax;
    
    @JsonProperty("tax_type")
    private String taxType;
    
    @JsonProperty("unit_cost")
    private BigDecimal unitCost;
    
    @JsonProperty("unit_of_measure")
    private String unitOfMeasure;

    @JsonProperty("gift_message")
    private String giftMessage;

    @JsonProperty("brand_name")
    private String brandName;

    @JsonProperty("category")
    private String category;

    @JsonProperty("misc")
    private String misc;

    @JsonProperty("taxable")
    private String taxable;

    @JsonProperty("email")
    private String email;

    public String getCommodityCode() {
        return commodityCode;
    }

    
    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    
    public String getDescription() {
        return description;
    }

    
    public void setDescription(String description) {
        this.description = description;
    }

    
    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    
    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    
    public String getDiscountIndicator() {
        return discountIndicator;
    }

    
    public void setDiscountIndicator(String discountIndicator) {
        this.discountIndicator = discountIndicator;
    }

    
    public String getGrossNetIndicator() {
        return grossNetIndicator;
    }

    
    public void setGrossNetIndicator(String grossNetIndicator) {
        this.grossNetIndicator = grossNetIndicator;
    }

    
    public BigDecimal getLineItemTotal() {
        return lineItemTotal;
    }

    
    public void setLineItemTotal(BigDecimal lineItemTotal) {
        this.lineItemTotal = lineItemTotal;
    }

    
    public String getProductCode() {
        return productCode;
    }

    
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    
    public String getQuantity() {
        return quantity;
    }

    
    public void setQuantity(String quantity) {
        this.quantity = quantity;
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

    
    public String getTaxType() {
        return taxType;
    }

    
    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    
    public BigDecimal getUnitCost() {
        return unitCost;
    }

    
    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    
    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getGiftMessage() {
        return giftMessage;
    }

    public void setGiftMessage(String giftMessage) {
        this.giftMessage = giftMessage;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMisc() {
        return misc;
    }

    public BigDecimal getUnitTax() {
        return unitTax;
    }

    public void setUnitTax(BigDecimal unitTax) {
        this.unitTax = unitTax;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    public String getTaxable() {
        return taxable;
    }

    public void setTaxable(String taxable) {
        this.taxable = taxable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
