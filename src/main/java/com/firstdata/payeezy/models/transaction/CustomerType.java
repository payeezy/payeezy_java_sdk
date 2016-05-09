package com.firstdata.payeezy.models.transaction;

/**
 * Created by FA7G14Q on 6/30/2015.
 */
public enum CustomerType {
        MEMBER("M"), GUEST("G");

        String value;
        CustomerType(String value){
                this.value = value;
        }

        public String getValue() {
                return value;
        }
}
