package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.codec.binary.Base64;


@JsonAutoDetect(getterVisibility = Visibility.DEFAULT, setterVisibility = Visibility.NONE,
                fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ThreeDomainSecureToken extends Card {
    
    @JsonProperty("data")
    private String data;
    @JsonProperty("header")
    private ThreeDomainSecureHeader header;
    @JsonProperty("signature")
    private String signature;
    @JsonProperty("version")
    private String version;
    @JsonProperty("xid")
    private String xid;
    @JsonProperty("applicationData")
    private String applicationData;
    
    @JsonProperty("type")
    private String type;
    /*
     * @JsonProperty("transactionId") private String transactionId;
     * @JsonProperty("encryptedData") private String encryptedData;
     * @JsonProperty("publicKeyHash") private String publicKeyHash;
     * @JsonProperty("wrappedKey") private String wrappedKey;
     * @JsonProperty("symmetricKeyInfo") private String symmetricKeyInfo;
     * @JsonProperty("asymmetricKeyInfo") private String asymmetricKeyInfo;
     * @JsonProperty("pkcs7Signature") private String pkcs7Signature;
     * @JsonProperty("eciIndicator") private String eciIndicator;
     */
    @JsonProperty("merchantIdentifier")
    private String merchantIdentifier;
    /*
     * @JsonProperty("signatureAlgInfo") private String signatureAlgInfo;
     */
    
    @JsonProperty("cavv")
    private String cavv;
    @JsonProperty("timestamp")
    private String timestamp;
    
    
    public String getTimestamp() {
        return timestamp;
    }
    
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    
    public String getCavv() {
        return cavv;
    }
    
    
    public void setCavv(String cavv) {
        this.cavv = cavv;
    }
    
    
    public String getType() {
        return type;
    }
    
    
    public void setType(String type) {
        this.type = type;
    }
    
    
    public String MerchantIdentifier() {
        return merchantIdentifier;
    }
    
    
    public void setMerchantIdentifier(String merchantIdentifier) {
        this.merchantIdentifier = merchantIdentifier;
    }


    
    public String getData() {
        return data;
    }


    
    public void setData(String data) {
        this.data = data;
    }


    
    public ThreeDomainSecureHeader getHeader() {
        return header;
    }


    
    public void setHeader(ThreeDomainSecureHeader header) {
        this.header = header;
    }


    
    public String getSignature() {
        return signature;
    }


    
    public void setSignature(String signature) {
        this.signature = signature;
    }


    
    public String getVersion() {
        return version;
    }


    
    public void setVersion(String version) {
        this.version = version;
    }


    
    public String getXid() {
        return xid;
    }

    
    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getApplicationData() {
        return applicationData;
    }

    public void setApplicationData(String applicationData) {
        this.applicationData = applicationData;
    }

    public String getMerchantIdentifier() {
        return merchantIdentifier;
    }

    @JsonIgnore
    public String getApplicationDataDecoded() {
        String appData = getApplicationData();
        if (appData == null) return null;
        byte[] b = Base64.decodeBase64(appData.getBytes());
        return new String(b);
    }
    
}
