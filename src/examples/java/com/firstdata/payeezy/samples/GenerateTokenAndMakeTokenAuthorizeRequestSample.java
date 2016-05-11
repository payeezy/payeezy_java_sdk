package firstdata.payeezy.samples;

import com.firstdata.payeezy.JSONHelper;
import com.firstdata.payeezy.PayeezyClientHelper;
import com.firstdata.payeezy.models.transaction.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Example to illustrate a Payeezy.JS get token call
 */
public class GenerateTokenAndMakeTokenAuthorizeRequestSample {

    public static void main(String [] args){
        Map<String, String> requestMap = new HashMap<String, String>();
        requestMap.put("callback","Payeezy.callback");
        requestMap.put("ta_token","NOIW");
        requestMap.put("auth","false");
        requestMap.put("type","FDToken");
        requestMap.put("credit_card.type","visa");
        requestMap.put("credit_card.cardholder_name","John Smith");
        requestMap.put("credit_card.card_number","4788250000028291");
        requestMap.put("credit_card.exp_date","1030");
        requestMap.put("credit_card.cvv","123");
        // billing address is optional
        requestMap.put("billing_address.city","St.Louis");
        requestMap.put("billing_address.country","US");
        requestMap.put("billing_address.email","abc@abc.com");
        requestMap.put("billing_address.phone.type","home");
        requestMap.put("billing_address.phone.number","212-515-1212");
        requestMap.put("billing_address.street","12115 LACKLAND");
        requestMap.put("billing_address.state_province","MO");
        requestMap.put("billing_address.phone.number","212-515-1212");
        requestMap.put("billing_address.zip_postal_code","63146");

        // this picks the properties from the .payeezy.properties files
        // alternatively you can populate the properties and pass it to the constructor
        PayeezyClientHelper clientHelper = new PayeezyClientHelper();
        try{
            PayeezyResponse payeezyResponse = clientHelper.doGetTokenCall(requestMap);
            String jsonResponse = payeezyResponse.getResponseBody();
            String responseBody;
            if(jsonResponse != null && jsonResponse.trim().startsWith("Payeezy.callback")){
                responseBody = jsonResponse.substring(jsonResponse.indexOf(":{") + 1, jsonResponse.indexOf("})"));
            }else{
                responseBody = jsonResponse;
            }
            TokenResponse tokenResponse = new JSONHelper().fromJson(responseBody, TokenResponse.class);
            TransactionRequest transactionRequest = new TransactionRequest();
            transactionRequest.setAmount("100");
            transactionRequest.setCurrency("USD");
            transactionRequest.setTransactionType(TransactionType.PURCHASE.name().toLowerCase());
            transactionRequest.setPaymentMethod(PaymentMethod.TOKEN.getValue());
            Token token = new Token();
            token.setTokenType(TokenType.FDToken.toString());
            Transarmor transarmor = new Transarmor();
            transarmor.setValue(tokenResponse.getToken().getValue());
            transarmor.setType("VISA");
            transarmor.setName("John Smith");
            transarmor.setExpiryDt("1030");
            transarmor.setCvv("123");
            token.setTokenData(transarmor);
            transactionRequest.setToken(token);
            PayeezyResponse tokenTransactionRes = clientHelper.doPrimaryTransaction(transactionRequest);
            System.out.println(tokenTransactionRes.getStatusCode());
            System.out.println(tokenTransactionRes.getResponseBody());
       }catch (Exception e){
            e.printStackTrace();
       }
       System.exit(0);
    }


}


