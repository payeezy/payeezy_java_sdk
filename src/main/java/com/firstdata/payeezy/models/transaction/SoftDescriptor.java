package com.firstdata.payeezy.models.transaction;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(getterVisibility= Visibility.NONE,setterVisibility= Visibility.NONE,fieldVisibility= Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)

public class SoftDescriptor {

	public SoftDescriptor() {
		// TODO Auto-generated constructor stub
	}
	
	@JsonProperty("dba_name")
	private String dba_name;
	
	@JsonProperty("street")
	private String street;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("region")
	private String region;
	
	@JsonProperty("postal_code")
	private String postalCode;
	
	@JsonProperty("country_code")
	private String countryCode;
	
	@JsonProperty("merchant_contact_info")
	private String merchantContactInfo;
	
    @JsonProperty("mid")
    private String mid;

	@JsonProperty("div_number")
	private String divisionNumber;
    
    @JsonProperty("mcc")
    private String mcc;

	@JsonProperty("amex_merch_no")
	private String amexMerchantNo;
    

	public String getDba_name() {
		return dba_name;
	}

	public void setDba_name(String dba_name) {
		this.dba_name = dba_name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getMerchantContactInfo() {
		return merchantContactInfo;
	}

	public void setMerchantContactInfo(String merchantContactInfo) {
		this.merchantContactInfo = merchantContactInfo;
	}

    
    public String getMid() {
        return mid;
    }

    
    public void setMid(String mid) {
        this.mid = mid;
    }

    
    public String getMcc() {
        return mcc;
    }

    
    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

	public String getDivisionNumber() {
		return divisionNumber;
	}

	public void setDivisionNumber(String divisionNumber) {
		this.divisionNumber = divisionNumber;
	}

	public String getAmexMerchantNo() {
		return amexMerchantNo;
	}

	public void setAmexMerchantNo(String amexMerchantNo) {
		this.amexMerchantNo = amexMerchantNo;
	}
}
