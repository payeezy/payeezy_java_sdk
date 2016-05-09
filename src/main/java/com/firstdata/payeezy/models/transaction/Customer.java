package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by FA7G14Q on 6/30/2015.
 */
@JsonAutoDetect(getterVisibility= JsonAutoDetect.Visibility.DEFAULT,setterVisibility= JsonAutoDetect.Visibility.DEFAULT,fieldVisibility= JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Customer{

    @JsonProperty("type")
    private String customerType;

    @JsonProperty("id")
    private String customerId;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("middle_name")
    private String milddleName;

    @JsonProperty("suffix")
    private String suffix;

    @JsonProperty("email")
    private String email;

    @JsonProperty("email_change")
    private String emailChange;

    @JsonProperty("home_phone_change")
    private String homePhoneChange;

    @JsonProperty("billing_address_change")
    private String billingAddressChange;

    @JsonProperty("pwd_change")
    private String passwordChange;

    @JsonProperty("contact")
    private List<Contact> contacts;

    @JsonProperty("promo_code")
    private String promoCode;

    @JsonProperty("promo_amt")
    private String promoAmount;

    @JsonProperty("ref_code")
    private String refCode;

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailChange() {
        return emailChange;
    }

    public void setEmailChange(String emailChange) {
        this.emailChange = emailChange;
    }

    public String getHomePhoneChange() {
        return homePhoneChange;
    }

    public void setHomePhoneChange(String homePhoneChange) {
        this.homePhoneChange = homePhoneChange;
    }

    public String getBillingAddressChange() {
        return billingAddressChange;
    }

    public void setBillingAddressChange(String billingAddressChange) {
        this.billingAddressChange = billingAddressChange;
    }

    public String getPasswordChange() {
        return passwordChange;
    }

    public void setPasswordChange(String passwordChange) {
        this.passwordChange = passwordChange;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getPromoAmount() {
        return promoAmount;
    }

    public void setPromoAmount(String promoAmount) {
        this.promoAmount = promoAmount;
    }

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMilddleName() {
        return milddleName;
    }

    public void setMilddleName(String milddleName) {
        this.milddleName = milddleName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
