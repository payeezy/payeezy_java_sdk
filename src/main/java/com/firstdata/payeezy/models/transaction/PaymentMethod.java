package com.firstdata.payeezy.models.transaction;

/**
 * Created by FA7G14Q on 3/31/2016.
 */
public enum PaymentMethod {
    CREDIT_CARD("credit_card"),TOKEN("token"),VALUELINK("valuelink"),THREEDS("3ds"),TELE_CHECK("tele_check"),PAYPAL("paypal");

    private String value;

    PaymentMethod(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
}
