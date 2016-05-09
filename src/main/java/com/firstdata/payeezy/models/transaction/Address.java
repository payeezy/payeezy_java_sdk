package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(getterVisibility= Visibility.NONE,setterVisibility= Visibility.NONE,fieldVisibility= Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Address {
    
    public Address() {
    }
    @JsonProperty("name")
    private String name;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("middle_name")
    private String middleName;

    @JsonProperty("suffix")
    private String suffix;

    @JsonProperty("street")
    private String addressLine1;

    @JsonProperty("street2")
    private String addressLine2;
    
    @JsonProperty("state_province")
    private String state;
    
    @JsonProperty("city")
    private String city;
    
    @JsonProperty("country")
    private String country;
    
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("phone")
    private Phone phoneNumber;
    
    @JsonProperty("zip_postal_code")
    private String zip;

    @JsonProperty("address_type")
    private String addressType;
    
    
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    
    
    public String getState() {
        return state;
    }
    
    
    
    public void setState(String state) {
        this.state = state;
    }
    
    
    public String getCity() {
        return city;
    }
    
    
    
    public void setCity(String city) {
        this.city = city;
    }
    
    
    public String getCountry() {
        return country;
    }
    
    
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    
    public String getEmail() {
        return email;
    }
    
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
	 * @return the phoneNumber
	 */
	public Phone getPhoneNumber() {
		return phoneNumber;
	}

    /**

	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(Phone phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
}
