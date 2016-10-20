package com.firstdata.payeezy.samples;

import com.firstdata.payeezy.JSONHelper;
import com.firstdata.payeezy.PayeezyClientHelper;
import com.firstdata.payeezy.models.transaction.*;

/** Example to illustrate an authorization using a credit card
 */
public class ConnectPayAuthorizeSample {

    public static void main(String [] args){
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAmount("100"); // always set the amouunt in cents
        transactionRequest.setTransactionType(TransactionType.AUTHORIZE.name().toLowerCase());
        transactionRequest.setPaymentMethod(PaymentMethod.CONNECT_PAY.getValue());
        transactionRequest.setCurrency("USD");
        // set the credit card info
        ConnectPay connectPay = new ConnectPay();
        connectPay.setNumber("1639635000001693");
        transactionRequest.setConnectPay(connectPay);
        // this picks the properties from the .payeezy.properties files
        // alternatively you can populate the properties and pass it to the constructor
        PayeezyClientHelper clientHelper = new PayeezyClientHelper();
        try{
            PayeezyResponse payeezyResponse = clientHelper.doPrimaryTransaction(transactionRequest);
            System.out.println("Status Code:"+payeezyResponse.getStatusCode());
            System.out.println("Response:"+payeezyResponse.getResponseBody());

            JSONHelper jsonHelper = new JSONHelper();
            TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
            // the responses for connect pay will not have any transaction_tag
            // ConnectPay Capture requires only transaction id
            TransactionRequest captureRequest = new TransactionRequest();
            captureRequest.setTransactionType(TransactionType.CAPTURE.name().toLowerCase());
            captureRequest.setPaymentMethod(PaymentMethod.CONNECT_PAY.getValue());
            captureRequest.setAmount("100"); // should always match the request amount
            captureRequest.setCurrency("USD");
            captureRequest.setConnectPay(connectPay);

            PayeezyResponse voidPayeezyResponse = clientHelper.doSecondaryTransaction(transactionResponse.getTransactionId(), captureRequest);
            System.out.println(voidPayeezyResponse.getResponseBody());
       }catch (Exception e){
            e.printStackTrace();
       }
       System.exit(0);
    }
}
