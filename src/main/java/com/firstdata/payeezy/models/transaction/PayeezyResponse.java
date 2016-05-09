package com.firstdata.payeezy.models.transaction;

/**
 * Created by FA7G14Q on 3/30/2016.
 */
public class PayeezyResponse {
    private int statusCode;
    private String responseBody;

    public  PayeezyResponse(int statusCode, String responseBody){
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }
}
