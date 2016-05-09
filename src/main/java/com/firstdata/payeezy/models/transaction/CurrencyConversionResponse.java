/**
 * 
 */
package com.firstdata.payeezy.models.transaction;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author rveerama
 *
 */
@JsonAutoDetect(getterVisibility= Visibility.DEFAULT,setterVisibility= Visibility.DEFAULT,fieldVisibility= Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class CurrencyConversionResponse extends CommonResponse {
	
	@JsonProperty("rate_id")
	private String rateId;
	
	@JsonProperty("currency_code")
	private String currencyCode;
	
	private String amount;
	
	@JsonProperty("exchange_rate")
	private String exchangeRate;
	
	@JsonProperty("dcc_offered")
	private String dccOffered;
	
	@JsonIgnore
	private String binQualifies;
	
	@JsonProperty("rate_expiry_timestamp")
	private String expiryTimestamp;
	
	@JsonProperty("margin_percentage")
	private String marginPercentage;
	
	@JsonProperty("echange_rate_source")
	private String exchangeRateSource;
	
	@JsonProperty("source_timestamp")
	private String sourceTimestamp;
	
	@JsonProperty("foreign_currency")
	private String foreignCurrency;
	
	@JsonIgnore
	private String terminalCurrency;
	
	@JsonIgnore
	private String baseAmount;

	@JsonIgnore
	private String terminalCurrencyCode;

	@JsonIgnore
	private String terminalCurrencyMinorUnit;
	
	@JsonProperty("foreign_amount")
	private String foreignAmount;

	@JsonIgnore
	private String foreignCurrencyCode;

	@JsonIgnore
	private String foreignCurrencyMinorUnit;
	
	/**
	 * @return the rateId
	 */
	public String getRateId() {
		return rateId;
	}

	/**
	 * @param rateId the rateId to set
	 */
	public void setRateId(String rateId) {
		this.rateId = rateId;
	}

	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @param currencyCode the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the exchangeRate
	 */
	public String getExchangeRate() {
		return exchangeRate;
	}

	/**
	 * @param exchangeRate the exchangeRate to set
	 */
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	/**
	 * @return the dccOffered
	 */
	public String getDccOffered() {
		return dccOffered;
	}

	/**
	 * @param dccOffered the dccOffered to set
	 */
	public void setDccOffered(String dccOffered) {
		this.dccOffered = dccOffered;
	}

	/**
	 * @return the expiryTimestamp
	 */
	public String getExpiryTimestamp() {
		return expiryTimestamp;
	}

	/**
	 * @param expiryTimestamp the expiryTimestamp to set
	 */
	public void setExpiryTimestamp(String expiryTimestamp) {
		this.expiryTimestamp = expiryTimestamp;
	}

	/**
	 * @return the marginPercentage
	 */
	public String getMarginPercentage() {
		return marginPercentage;
	}

	/**
	 * @param marginPercentage the marginPercentage to set
	 */
	public void setMarginPercentage(String marginPercentage) {
		this.marginPercentage = marginPercentage;
	}

	/**
	 * @return the exchangeRateSource
	 */
	public String getExchangeRateSource() {
		return exchangeRateSource;
	}

	/**
	 * @param exchangeRateSource the exchangeRateSource to set
	 */
	public void setExchangeRateSource(String exchangeRateSource) {
		this.exchangeRateSource = exchangeRateSource;
	}

	/**
	 * @return the sourceTimestamp
	 */
	public String getSourceTimestamp() {
		return sourceTimestamp;
	}

	/**
	 * @param sourceTimestamp the sourceTimestamp to set
	 */
	public void setSourceTimestamp(String sourceTimestamp) {
		this.sourceTimestamp = sourceTimestamp;
	}

	public String getBinQualifies() {
		return binQualifies;
	}

	public void setBinQualifies(String binQualifies) {
		this.binQualifies = binQualifies;
	}

	public String getForeignCurrency() {
		return foreignCurrency;
	}

	public void setForeignCurrency(String foreignCurrency) {
		this.foreignCurrency = foreignCurrency;
	}

	public String getTerminalCurrency() {
		return terminalCurrency;
	}

	public void setTerminalCurrency(String terminalCurrency) {
		this.terminalCurrency = terminalCurrency;
	}

	public String getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(String baseAmount) {
		this.baseAmount = baseAmount;
	}

	public String getTerminalCurrencyCode() {
		return terminalCurrencyCode;
	}

	public void setTerminalCurrencyCode(String terminalCurrencyCode) {
		this.terminalCurrencyCode = terminalCurrencyCode;
	}

	public String getTerminalCurrencyMinorUnit() {
		return terminalCurrencyMinorUnit;
	}

	public void setTerminalCurrencyMinorUnit(String terminalCurrencyMinorUnit) {
		this.terminalCurrencyMinorUnit = terminalCurrencyMinorUnit;
	}

	public String getForeignAmount() {
		return foreignAmount;
	}

	public void setForeignAmount(String foreignAmount) {
		this.foreignAmount = foreignAmount;
	}

	public String getForeignCurrencyCode() {
		return foreignCurrencyCode;
	}

	public void setForeignCurrencyCode(String foreignCurrencyCode) {
		this.foreignCurrencyCode = foreignCurrencyCode;
	}

	public String getForeignCurrencyMinorUnit() {
		return foreignCurrencyMinorUnit;
	}

	public void setForeignCurrencyMinorUnit(String foreignCurrencyMinorUnit) {
		this.foreignCurrencyMinorUnit = foreignCurrencyMinorUnit;
	}
	
}
