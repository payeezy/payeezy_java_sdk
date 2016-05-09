package com.firstdata.payeezy.api;

/**
 * Use this call to pass apikey, token and secret required for making a transaction
 */
public class PayeezyRequestOptions {

    private String apiKey;
    private String token;
    private String secret;

    public PayeezyRequestOptions(String apiKey, String token, String securedSecret){
        this.apiKey = apiKey;
        this.token = token;
        this.secret = securedSecret;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getToken() {
        return token;
    }

    public String getSecret() {
        return secret;
    }
}
