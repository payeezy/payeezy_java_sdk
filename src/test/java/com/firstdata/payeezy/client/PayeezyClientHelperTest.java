package com.firstdata.payeezy.client;

import com.firstdata.payeezy.JSONHelper;
import com.firstdata.payeezy.PayeezyClientHelper;
import com.firstdata.payeezy.api.PayeezyRequestOptions;
import com.firstdata.payeezy.models.transaction.*;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by FA7G14Q on 3/31/2016.
 */
public class PayeezyClientHelperTest {

    PayeezyClientHelper payeezyClientHelper;
    PayeezyRequestOptions requestOptions;
    JSONHelper jsonHelper;

    private static final String APIKEY = "kJ0bejUU3FrAUSAKp6DHZYDkdFKYgcj9"; //"y6pWAJNyJyjGv66IsVuWnklkKUPFbb0a";
    private static final String SECURE_SECRET = "49b1d4dbe0446711d1435f2a32ce2eea55dfe8681fc2e1c9666b8e5b5218ffe8";//"86fbae7030253af3cd15faef2a1f4b67353e41fb6799f576b5093ae52901e6f7";
    private static final String TOKEN = "fdoa-a480ce8951daa73262734cf102641994c1e55e7cdf4c02b6";
    private static final String DCC_OKEN =    "fdoa-d790ce8951daa73262645cf102641994c1e55e7cdf4c03c8";
    private String GIFT_CARD_NUMBER = "7777045839985463";

    @Before
    public void setup(){
        payeezyClientHelper = new PayeezyClientHelper();
        jsonHelper = new JSONHelper();
    }

   /* @Test
    public void doCreditCardAuthorizationWithNoAPIKey(){
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAmount("100"); // ex: $1.00
        transactionRequest.setTransactionType(TransactionType.AUTHORIZE.name().toLowerCase());
        transactionRequest.setPaymentMethod(PaymentMethod.CREDIT_CARD.getValue());
        transactionRequest.setReferenceNo("abc1412096293369");
        transactionRequest.setPaymentMethod("credit_card");
        transactionRequest.setCurrency("USD");
        Card card = new Card();
        card.setName("Not Provided");
        card.setType("visa");
        card.setCvv("123");
        card.setExpiryDt("1020");
        card.setNumber("4012000033330026");
        transactionRequest.setCard(card);
        try {
            PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(transactionRequest);
            Assert.assertNotNull(payeezyResponse);
            Assert.assertNotNull(payeezyResponse.getStatusCode());
            Assert.assertEquals(401,payeezyResponse.getStatusCode());
            Assert.assertNotNull(payeezyResponse.getResponseBody());

        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Transaction failed");
        }
    }*/

    @Test
    public void doCreditCardAuthorization(){
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAmount("100"); // ex: $1.00
        transactionRequest.setTransactionType(TransactionType.AUTHORIZE.name().toLowerCase());
        transactionRequest.setPaymentMethod(PaymentMethod.CREDIT_CARD.getValue());
        transactionRequest.setReferenceNo("abc1412096293369");
        transactionRequest.setPaymentMethod("credit_card");
        transactionRequest.setCurrency("USD");
        Card card = new Card();
        card.setName("Not Provided");
        card.setType("visa");
        card.setCvv("123");
        card.setExpiryDt("1020");
        card.setNumber("4012000033330026");
        transactionRequest.setCard(card);
        try {
            PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(transactionRequest);
            assertPayeezyResponse(payeezyResponse);
            TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
            assertTransactionResponse(transactionResponse);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Transaction failed");
        }
    }


    @Test
    public void doCreditCardPurchase(){
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAmount("100"); // ex: $1.00
        transactionRequest.setTransactionType(TransactionType.PURCHASE.name().toLowerCase());
        transactionRequest.setPaymentMethod(PaymentMethod.CREDIT_CARD.getValue());
        transactionRequest.setReferenceNo("abc1412096293369");
        transactionRequest.setPaymentMethod("credit_card");
        transactionRequest.setCurrency("USD");
        Card card = new Card();
        card.setName("Not Provided");
        card.setType("visa");
        card.setCvv("123");
        card.setExpiryDt("1020");
        card.setNumber("4012000033330026");
        transactionRequest.setCard(card);
        try {
            PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(transactionRequest);
            assertPayeezyResponse(payeezyResponse);
            TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
            assertTransactionResponse(transactionResponse);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Transaction failed");
        }
    }

    @Test
    public void doAuthorizationAndCaptureTransaction(){
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAmount("100"); // ex: $1.00
        transactionRequest.setTransactionType(TransactionType.AUTHORIZE.name().toLowerCase());
        transactionRequest.setPaymentMethod(PaymentMethod.CREDIT_CARD.getValue());
        transactionRequest.setPaymentMethod("credit_card");
        transactionRequest.setCurrency("USD");
        Card card = new Card();
        card.setName("Not Provided");
        card.setType("visa");
        card.setCvv("123");
        card.setExpiryDt("1020");
        card.setNumber("4012000033330026");
        transactionRequest.setCard(card);
        try {
            PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(transactionRequest);
            Assert.assertNotNull(payeezyResponse);
            Assert.assertNotNull(payeezyResponse.getStatusCode());
            TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
            // set the required attributes for capture
            transactionRequest.setTransactionTag(transactionResponse.getTransactionTag());
            transactionRequest.setCard(null);
            transactionRequest.setTransactionType(TransactionType.CAPTURE.name().toLowerCase());
            PayeezyResponse secondaryTransactionResponse =payeezyClientHelper.doSecondaryTransaction(transactionResponse.getTransactionId(), transactionRequest);
            assertPayeezyResponse(secondaryTransactionResponse);
            transactionResponse = jsonHelper.fromJson(secondaryTransactionResponse.getResponseBody(), TransactionResponse.class);
            assertTransactionResponse(transactionResponse);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Transaction failed");
        }
    }

    @Test
    public void doPurchaseTaggedVoidTransaction(){
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAmount("100"); // ex: $1.00
        transactionRequest.setTransactionType(TransactionType.PURCHASE.name().toLowerCase());
        transactionRequest.setPaymentMethod(PaymentMethod.CREDIT_CARD.getValue());
        transactionRequest.setReferenceNo("abc1412096293369");
        transactionRequest.setPaymentMethod("credit_card");
        transactionRequest.setCurrency("USD");
        Card card = new Card();
        card.setName("Not Provided");
        card.setType("visa");
        card.setCvv("123");
        card.setExpiryDt("1020");
        card.setNumber("4012000033330026");
        transactionRequest.setCard(card);
        try {
            PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(transactionRequest);
            Assert.assertNotNull(payeezyResponse);
            Assert.assertNotNull(payeezyResponse.getStatusCode());
            TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
            // set the required attributes for TaggedVoid
            transactionRequest.setTransactionTag(transactionResponse.getTransactionTag());
            transactionRequest.setCard(null);
            transactionRequest.setTransactionType(TransactionType.VOID.name().toLowerCase());
            PayeezyResponse secondaryTransactionResponse =payeezyClientHelper.doSecondaryTransaction(transactionResponse.getTransactionId(), transactionRequest);
            assertPayeezyResponse(secondaryTransactionResponse);
            transactionResponse = jsonHelper.fromJson(secondaryTransactionResponse.getResponseBody(), TransactionResponse.class);
            assertTransactionResponse(transactionResponse);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Transaction failed");
        }
    }

    @Test
    public void doCreditcardPurchaseTaggedRefundTransaction(){
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAmount("100"); // ex: $1.00
        transactionRequest.setTransactionType(TransactionType.PURCHASE.name().toLowerCase());
        transactionRequest.setPaymentMethod(PaymentMethod.CREDIT_CARD.getValue());
        transactionRequest.setReferenceNo(String.valueOf(System.currentTimeMillis()));
        transactionRequest.setCurrency("USD");
        Card card = new Card();
        card.setName("Not Provided");
        card.setType("visa");
        card.setCvv("123");
        card.setExpiryDt("1020");
        card.setNumber("4012000033330026");
        transactionRequest.setCard(card);
        try {
            PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(transactionRequest);
            Assert.assertNotNull(payeezyResponse);
            Assert.assertNotNull(payeezyResponse.getStatusCode());
            TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
            assertTransactionResponse(transactionResponse);
            // set the required attributes for TaggedVoid
            transactionRequest.setTransactionTag(transactionResponse.getTransactionTag());
            transactionRequest.setCard(null);
            transactionRequest.setTransactionType(TransactionType.REFUND.name().toLowerCase());
            PayeezyResponse secondaryTransactionResponse = payeezyClientHelper.doSecondaryTransaction(transactionResponse.getTransactionId(), transactionRequest);
            assertPayeezyResponse(secondaryTransactionResponse);
            assertTransactionResponse(jsonHelper.fromJson(secondaryTransactionResponse.getResponseBody(), TransactionResponse.class));

        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Transaction failed");
        }
    }

    @Test
    public void doGetTokenTransaction(){
        //PayeezyClientHelper clientHelper = new PayeezyClientHelper("api-cert.payeezy.com/");
        PayeezyClientHelper clientHelper = new PayeezyClientHelper();
        try {
            PayeezyResponse payeezyResponse = clientHelper.doGetTokenCall(buildGetTokenRequestMap());
            Assert.assertNotNull(payeezyResponse);
            Assert.assertNotNull(payeezyResponse.getStatusCode());
            TokenResponse tokenResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TokenResponse.class);
            Assert.assertNotNull(tokenResponse);
            Assert.assertNotNull(tokenResponse.getToken());
            Assert.assertNotNull(tokenResponse.getToken().getValue());
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Transaction failed");
        }
    }

    private Map<String, String> buildGetTokenRequestMap(){
        Map<String, String> requestMap = new HashMap<String, String>();
        requestMap.put("ta_token","NOIW");
        requestMap.put("auth","false");
        requestMap.put("type","FDToken");
        requestMap.put("credit_card.type","visa");
        requestMap.put("credit_card.cardholder_name","John Smith");
        requestMap.put("credit_card.card_number","4788250000028291");
        requestMap.put("credit_card.exp_date","1030");
        requestMap.put("credit_card.cvv","123");
        requestMap.put("billing_address.city","St.Louis");
        requestMap.put("billing_address.country","US");
        requestMap.put("billing_address.email","abc@abc.com");
        requestMap.put("billing_address.phone.type","home");
        requestMap.put("billing_address.phone.number","212-515-1212");
        requestMap.put("billing_address.street","12115 LACKLAND");
        requestMap.put("billing_address.state_province","MO");
        requestMap.put("billing_address.phone.number","212-515-1212");
        requestMap.put("billing_address.zip_postal_code","63146");
        requestMap.put("callback","Payeezy.callback");
        return requestMap;
    }

    @Test
    public void doTokenAuthorizeTransaction(){
        PayeezyClientHelper clientHelper = new PayeezyClientHelper();
        try {
            // get token
            PayeezyResponse payeezyResponse = clientHelper.doGetTokenCall(buildGetTokenRequestMap());
            Assert.assertNotNull(payeezyResponse);
            Assert.assertNotNull(payeezyResponse.getStatusCode());
            TokenResponse tokenResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TokenResponse.class);
            Assert.assertNotNull(tokenResponse);
            Assert.assertNotNull(tokenResponse.getToken());
            Assert.assertNotNull(tokenResponse.getToken().getValue());

            // Token Transaction Authorize Request
            TransactionRequest transactionRequest = new TransactionRequest();
            transactionRequest.setAmount("100"); // ex: $1.00
            transactionRequest.setTransactionType(TransactionType.AUTHORIZE.name().toLowerCase());
            transactionRequest.setPaymentMethod(PaymentMethod.TOKEN.getValue());
            transactionRequest.setReferenceNo(String.valueOf(System.currentTimeMillis()));
            transactionRequest.setCurrency("USD");
            Token token = new Token();
            transactionRequest.setToken(token);
            token.setTokenType(TokenType.FDToken.name());
            Transarmor transarmor = new Transarmor();
            token.setTokenData(transarmor);
            transarmor.setType("visa");
            transarmor.setName("Not Provided");
            transarmor.setCvv("123");
            transarmor.setExpiryDt("1020");
            transarmor.setValue(tokenResponse.getToken().getValue());
            PayeezyResponse payeezyTokenResponse = payeezyClientHelper.doPrimaryTransaction( transactionRequest);
            assertPayeezyResponse(payeezyTokenResponse);
            TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyTokenResponse.getResponseBody(), TransactionResponse.class);
            assertTransactionResponse(transactionResponse);


        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Transaction failed");
        }
    }

    @Test
    public void doTokenAuthorizeAndVoidTransaction(){
        PayeezyClientHelper clientHelper = new PayeezyClientHelper();
        try {
            // get token
            PayeezyResponse payeezyResponse = clientHelper.doGetTokenCall(buildGetTokenRequestMap());
            Assert.assertNotNull(payeezyResponse);
            Assert.assertNotNull(payeezyResponse.getStatusCode());
            TokenResponse tokenResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TokenResponse.class);
            Assert.assertNotNull(tokenResponse);
            Assert.assertNotNull(tokenResponse.getToken());
            Assert.assertNotNull(tokenResponse.getToken().getValue());

            // Token Transaction Authorize Request
            TransactionRequest transactionRequest = new TransactionRequest();
            transactionRequest.setAmount("100"); // ex: $1.00
            transactionRequest.setTransactionType(TransactionType.AUTHORIZE.name().toLowerCase());
            transactionRequest.setPaymentMethod(PaymentMethod.TOKEN.getValue());
            transactionRequest.setReferenceNo(String.valueOf(System.currentTimeMillis()));
            transactionRequest.setCurrency("USD");
            Token token = new Token();
            transactionRequest.setToken(token);
            token.setTokenType(TokenType.FDToken.name());
            Transarmor transarmor = new Transarmor();
            token.setTokenData(transarmor);
            transarmor.setType("visa");
            transarmor.setName("Not Provided");
            transarmor.setCvv("123");
            transarmor.setExpiryDt("1020");
            transarmor.setValue(tokenResponse.getToken().getValue());
            PayeezyResponse payeezyTokenResponse = payeezyClientHelper.doPrimaryTransaction(transactionRequest);
            assertPayeezyResponse(payeezyTokenResponse);
            TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyTokenResponse.getResponseBody(), TransactionResponse.class);
            assertTransactionResponse(transactionResponse);

            //do a void call, use the previous transaction request
            transactionRequest.setTransactionType(TransactionType.VOID.name().toLowerCase());
            transactionRequest.setTransactionTag(transactionResponse.getTransactionTag());
            PayeezyResponse voidPayeezyResponse = payeezyClientHelper.doSecondaryTransaction(transactionResponse.getTransactionId(),transactionRequest);
            assertPayeezyResponse(voidPayeezyResponse);
            transactionResponse = jsonHelper.fromJson(voidPayeezyResponse.getResponseBody(), TransactionResponse.class);
            assertTransactionResponse(transactionResponse);

        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Transaction failed");
        }
    }

    @Test
    public void doTokenAuthorizeAndRefundTransaction(){
       PayeezyClientHelper clientHelper =  new PayeezyClientHelper();
        //PayeezyClientHelper clientHelper = new PayeezyClientHelper("api-cert.payeezy.com");
        try {
            // get token
            PayeezyResponse payeezyResponse = clientHelper.doGetTokenCall(buildGetTokenRequestMap());
            Assert.assertNotNull(payeezyResponse);
            Assert.assertNotNull(payeezyResponse.getStatusCode());
            TokenResponse tokenResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TokenResponse.class);
            Assert.assertNotNull(tokenResponse);
            Assert.assertNotNull(tokenResponse.getToken());
            Assert.assertNotNull(tokenResponse.getToken().getValue());

            // Token Transaction Authorize Request
            TransactionRequest transactionRequest = new TransactionRequest();
            transactionRequest.setAmount("100"); // ex: $1.00
            transactionRequest.setTransactionType(TransactionType.AUTHORIZE.name().toLowerCase());
            transactionRequest.setPaymentMethod(PaymentMethod.TOKEN.getValue());
            transactionRequest.setReferenceNo(String.valueOf(System.currentTimeMillis()));
            transactionRequest.setCurrency("USD");
            Token token = new Token();
            transactionRequest.setToken(token);
            token.setTokenType(TokenType.FDToken.name());
            Transarmor transarmor = new Transarmor();
            token.setTokenData(transarmor);
            transarmor.setType("visa");
            transarmor.setName("Not Provided");
            transarmor.setCvv("123");
            transarmor.setExpiryDt("1020");
            transarmor.setValue(tokenResponse.getToken().getValue());
            PayeezyResponse payeezyTokenResponse = payeezyClientHelper.doPrimaryTransaction(transactionRequest);
            assertPayeezyResponse(payeezyTokenResponse);
            TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyTokenResponse.getResponseBody(), TransactionResponse.class);
            assertTransactionResponse(transactionResponse);

            //do a refund call, use the previous transaction request as content is same except a few
            transactionRequest.setTransactionType(TransactionType.REFUND.name().toLowerCase());
            transactionRequest.setTransactionTag(transactionResponse.getTransactionTag());
            PayeezyResponse voidPayeezyResponse = payeezyClientHelper.doSecondaryTransaction(transactionResponse.getTransactionId(),transactionRequest);
            assertPayeezyResponse(voidPayeezyResponse);
            transactionResponse = jsonHelper.fromJson(voidPayeezyResponse.getResponseBody(), TransactionResponse.class);
            assertTransactionResponse(transactionResponse);

        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Transaction failed");
        }
    }

    @Test
    public void doGiftCardBalanceInquiry() throws Exception {
        TransactionRequest request = populateCommonGiftCardRequestInfo(GIFT_CARD_NUMBER);
        request.setTransactionType(TransactionType.BALANCE_INQUIRY.name().toLowerCase());
        PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(request);
        // assert response is not null
        assertPayeezyResponse(payeezyResponse);
        TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
        Assert.assertNotNull(transactionResponse);
    }

    @Test
    public void doGiftCardPurchase() {
        TransactionRequest request = populateCommonGiftCardRequestInfo(GIFT_CARD_NUMBER);
        request.setTransactionType(TransactionType.PURCHASE.name().toLowerCase());
        request.setAmount("500");
        try{
            PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(request);
            // assert response is not null
            assertPayeezyResponse(payeezyResponse);
            TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
            Assert.assertNotNull(transactionResponse);
        } catch(Exception ex){
            ex.printStackTrace();
            Assert.fail("Transaction failed");
        }

    }


    @Test
    public void doGiftCardPurchaseAndVoid() throws Exception {
        TransactionRequest request = populateCommonGiftCardRequestInfo(GIFT_CARD_NUMBER);
        request.setTransactionType(TransactionType.PURCHASE.name().toLowerCase());
        request.setAmount("500");
        PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(request);
        // assert response is not null
        assertPayeezyResponse(payeezyResponse);
        TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
        Assert.assertNotNull(transactionResponse);
        //
        TransactionRequest transactionRequest =  new TransactionRequest();
        transactionRequest.setTransactionTag(transactionResponse.getTransactionTag());
        transactionRequest.setTransactionType(TransactionType.VOID.name().toLowerCase());
        transactionRequest.setCurrency("USD");
        transactionRequest.setAmount(request.getAmount());
        PayeezyResponse voidPayeezyResponse = payeezyClientHelper.doSecondaryTransaction(transactionResponse.getTransactionId(),transactionRequest);
        assertPayeezyResponse(voidPayeezyResponse);

        TransactionResponse voidTransactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
        assertTransactionResponse(voidTransactionResponse);
    }


    @Test
    public void doGiftCardPurchaseAndRefund() throws Exception {
        TransactionRequest request = populateCommonGiftCardRequestInfo(GIFT_CARD_NUMBER);
        request.setTransactionType(TransactionType.PURCHASE.name().toLowerCase());
        request.setAmount("500");
        PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(request);
        // assert response is not null
        assertPayeezyResponse(payeezyResponse);
        TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
        Assert.assertNotNull(transactionResponse);
        //
        TransactionRequest transactionRequest =  new TransactionRequest();
        transactionRequest.setTransactionTag(transactionResponse.getTransactionTag());
        transactionRequest.setTransactionType(TransactionType.REFUND.name().toLowerCase());
        transactionRequest.setCurrency("USD");
        transactionRequest.setAmount(request.getAmount());
        PayeezyResponse voidPayeezyResponse = payeezyClientHelper.doSecondaryTransaction(transactionResponse.getTransactionId(), transactionRequest);
        assertPayeezyResponse(voidPayeezyResponse);

        TransactionResponse voidTransactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
        assertTransactionResponse(voidTransactionResponse);
    }

    /**
     * Partial Redemption can be applied to a transaction, if the balance on the card is less than the amount of the transaction
     * A split_tender_id is returned in the transaction response, this should be used in teh subsequent transactions to tie the transactions together
     * the amount returned in the response is the amount authorized for the transaction, the user has to calculate the difference and redo the transaction
     * for the difference
     * @throws Exception
     */
    @Test
    public void doPartialPaymentRequest() throws Exception {

        TransactionRequest request = populateCommonGiftCardRequestInfo(GIFT_CARD_NUMBER);
        request.setTransactionType(TransactionType.PURCHASE.name().toLowerCase());
        request.setPartialRedemption("true");
        request.setAmount("500"); //$5.00
        PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(request);
        // assert response is not null
        assertPayeezyResponse(payeezyResponse);
        TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
        Assert.assertNotNull(transactionResponse);
        //
        request.setSplitTenderId(transactionResponse.getSplitTenderId());
        //
        String amountDiff = calculateDifference(request.getAmount(), transactionResponse.getAmount());
        if(Double.valueOf(amountDiff) > 0){
            request.setAmount(calculateDifference(request.getAmount(), transactionResponse.getAmount()));

            PayeezyResponse partialPayeezyResponse = payeezyClientHelper.doPrimaryTransaction(request);
            assertPayeezyResponse(partialPayeezyResponse);

            TransactionResponse partialTransactionResponse = jsonHelper.fromJson(partialPayeezyResponse.getResponseBody(), TransactionResponse.class);
            assertTransactionResponse(partialTransactionResponse);
        }

    }

    @Test
    public void doGiftCardReload() throws Exception {
        //Double prevCardBal = getCardBalance(GIFT_CARD_NUMBER);
        // Reload 50 dollars in the card
        TransactionRequest reloadReq = populateCommonGiftCardRequestInfo(GIFT_CARD_NUMBER);
        reloadReq.setTransactionType(TransactionType.RELOAD.name().toLowerCase());
        reloadReq.setAmount("5000");
        PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(reloadReq);
        assertPayeezyResponse(payeezyResponse);
        TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
        assertTransactionResponse(transactionResponse);
    }

    @Test
    public void doGiftCardDeActivation() throws Exception {
        //Double prevCardBal = getCardBalance(GIFT_CARD_NUMBER);
        // Reload 50 dollars in the card
        TransactionRequest reloadReq = populateCommonGiftCardRequestInfo(GIFT_CARD_NUMBER);
        reloadReq.setTransactionType(TransactionType.DEACTIVATION.name().toLowerCase());
        reloadReq.setAmount("5000");
        PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(reloadReq);
        assertPayeezyResponse(payeezyResponse);
        TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
        assertTransactionResponse(transactionResponse);
    }


    @Test
    public void doGiftCardActivation() throws Exception {
        //Double prevCardBal = getCardBalance(GIFT_CARD_NUMBER);
        // Reload 50 dollars in the card
        TransactionRequest reloadReq = populateCommonGiftCardRequestInfo(GIFT_CARD_NUMBER);
        reloadReq.setTransactionType(TransactionType.ACTIVATION.name().toLowerCase());
        reloadReq.setAmount("5000");
        reloadReq.getValuelink().setCardCost("5");
        PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(reloadReq);
        assertPayeezyResponse(payeezyResponse);
        TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
        assertTransactionResponse(transactionResponse);
    }

    @Test
    public void doGiftCardCashout() throws Exception {
        //Double prevCardBal = getCardBalance(GIFT_CARD_NUMBER);
        // Reload 50 dollars in the card
        TransactionRequest reloadReq = populateCommonGiftCardRequestInfo(GIFT_CARD_NUMBER);
        reloadReq.setTransactionType(TransactionType.CASHOUT.name().toLowerCase());
        reloadReq.setAmount("5000");
        reloadReq.getValuelink().setCardCost("5");
        PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(reloadReq);
        assertPayeezyResponse(payeezyResponse);
        TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
        assertTransactionResponse(transactionResponse);
    }

    @Test
    public void doPaypalAuthorizeTransaction() throws  Exception{
        TransactionRequest paypalTransactionRequest = new TransactionRequest();
        paypalTransactionRequest.setAmount("12"); // 12 cents
        paypalTransactionRequest.setTransactionType(TransactionType.AUTHORIZE.name().toLowerCase());
        paypalTransactionRequest.setPaymentMethod(PaymentMethod.PAYPAL.name().toLowerCase());
        paypalTransactionRequest.setCurrency("USD");
        PaypalTransactionDetail paypalTransactionDetail = new PaypalTransactionDetail();
        paypalTransactionDetail.setAuthorization("O-1XW865551D308884E");
        paypalTransactionDetail.setSuccess(true);
        paypalTransactionDetail.setMessage("Success");
        paypalTransactionDetail.setCorrelationID("c9e47ba37b784");
        paypalTransactionDetail.setPayerId("SA4SLFX48Y6DL");
        paypalTransactionDetail.setCurrencyId("USD");
        paypalTransactionDetail.setCardHolderName("John Smith");
        paypalTransactionRequest.setPaypal(paypalTransactionDetail);
        PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(paypalTransactionRequest);
        assertPayeezyResponse(payeezyResponse);
        TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
        assertTransactionResponse(transactionResponse);
    }

    @Test
    public void doPaypalOrderTransaction() throws  Exception{
        TransactionRequest paypalTransactionRequest = new TransactionRequest();
        paypalTransactionRequest.setAmount("12"); // 12 cents
        paypalTransactionRequest.setTransactionType(TransactionType.ORDER.name().toLowerCase());
        paypalTransactionRequest.setPaymentMethod(PaymentMethod.PAYPAL.name().toLowerCase());
        paypalTransactionRequest.setCurrency("USD");
        PaypalTransactionDetail paypalTransactionDetail = new PaypalTransactionDetail();
        paypalTransactionDetail.setAuthorization("O-1XW865551D308884E");
        paypalTransactionDetail.setSuccess(true);
        paypalTransactionDetail.setMessage("Success");
        paypalTransactionDetail.setCorrelationID("c9e47ba37b784");
        paypalTransactionDetail.setPayerId("SA4SLFX48Y6DL");
        paypalTransactionDetail.setCurrencyId("USD");
        paypalTransactionDetail.setCardHolderName("John Smith");
        paypalTransactionRequest.setPaypal(paypalTransactionDetail);
        PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(paypalTransactionRequest);
        assertPayeezyResponse(payeezyResponse);
        TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
        assertTransactionResponse(transactionResponse);

    }

    @Test
    public void doPaypalPurchaseTransaction() throws  Exception{
        TransactionRequest paypalTransactionRequest = new TransactionRequest();
        paypalTransactionRequest.setAmount("12"); // 12 cents
        paypalTransactionRequest.setTransactionType(TransactionType.PURCHASE.name().toLowerCase());
        paypalTransactionRequest.setPaymentMethod(PaymentMethod.PAYPAL.name().toLowerCase());
        paypalTransactionRequest.setCurrency("USD");
        PaypalTransactionDetail paypalTransactionDetail = new PaypalTransactionDetail();
        paypalTransactionDetail.setAuthorization("O-1XW865551D308884E");
        paypalTransactionDetail.setSuccess(true);
        paypalTransactionDetail.setMessage("Success");
        paypalTransactionDetail.setCorrelationID("c9e47ba37b784");
        paypalTransactionDetail.setPayerId("SA4SLFX48Y6DL");
        paypalTransactionDetail.setCurrencyId("USD");
        paypalTransactionDetail.setCardHolderName("John Smith");
        paypalTransactionRequest.setPaypal(paypalTransactionDetail);
        PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(paypalTransactionRequest);
        assertPayeezyResponse(payeezyResponse);
        TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
        assertTransactionResponse(transactionResponse);

    }

    @Test
    public void doPaypalAuthorizeAndVoidTransaction() throws  Exception{
        TransactionRequest paypalTransactionRequest = new TransactionRequest();
        paypalTransactionRequest.setAmount("12"); // 12 cents
        paypalTransactionRequest.setTransactionType(TransactionType.AUTHORIZE.name().toLowerCase());
        paypalTransactionRequest.setPaymentMethod(PaymentMethod.PAYPAL.name().toLowerCase());
        paypalTransactionRequest.setCurrency("USD");
        PaypalTransactionDetail paypalTransactionDetail = new PaypalTransactionDetail();
        paypalTransactionDetail.setAuthorization("O-1XW865551D308884E");
        paypalTransactionDetail.setSuccess(true);
        paypalTransactionDetail.setMessage("Success");
        paypalTransactionDetail.setCorrelationID("c9e47ba37b784");
        paypalTransactionDetail.setPayerId("SA4SLFX48Y6DL");
        paypalTransactionDetail.setCurrencyId("USD");
        paypalTransactionDetail.setCardHolderName("John Smith");
        paypalTransactionRequest.setPaypal(paypalTransactionDetail);
        PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(paypalTransactionRequest);
        assertPayeezyResponse(payeezyResponse);
        TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
        assertTransactionResponse(transactionResponse);
        paypalTransactionRequest.setTransactionTag(transactionResponse.getTransactionTag());
        paypalTransactionRequest.setPaypal(null);
        paypalTransactionRequest.setTransactionType(TransactionType.VOID.name().toLowerCase());
        PayeezyResponse secondaryTransactionResponse =payeezyClientHelper.doSecondaryTransaction(transactionResponse.getTransactionId(), paypalTransactionRequest);
        assertPayeezyResponse(secondaryTransactionResponse);
        transactionResponse = jsonHelper.fromJson(secondaryTransactionResponse.getResponseBody(), TransactionResponse.class);
        assertTransactionResponse(transactionResponse);
    }


    @Test
    public void doTeleCheckPurchaseRequest() throws Exception{
		TransactionRequest req = new TransactionRequest();
        req.setAmount("9200");
        req.setTransactionType("purchase");
        req.setReferenceNo("abc1412096293369");
        req.setPaymentMethod("tele_check");
        req.setCurrency("USD");
        TeleCheck teleCheck = new TeleCheck();
        req.setTeleCheck(teleCheck);
        teleCheck.setAccountholderName("Tom Eck");
        teleCheck.setCheckNumber("4788");
        teleCheck.setCheckType("C");
        teleCheck.setBankRoutingNumber("0987654321");
        teleCheck.setBankAccountNumber("12345");
        teleCheck.setCustomerIdType("1");
        teleCheck.setCustomerIdNumber("423424bh");
        teleCheck.setClientEmail("rajan.veeramani@firstdata.com");
        teleCheck.setGiftCardAmount("100");
        teleCheck.setVip("n");
        teleCheck.setClerkId("RVK_001");
        teleCheck.setDeviceId("jkh78");
        teleCheck.setMicr("hj");
        teleCheck.setReleaseType("X");
        teleCheck.setRegistrationNumber("123345");
        teleCheck.setRegistrationDate("01012014");
        teleCheck.setDateOfBirth("01012010");
        PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(req);
        assertPayeezyResponse(payeezyResponse);
        TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
        assertTransactionResponse(transactionResponse);

    }

    @Test
    public void doApplePayTransaction(){
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setReferenceNo("order1");
        transactionRequest.setPaymentMethod(PaymentMethod.THREEDS.getValue());
        transactionRequest.setTransactionType(TransactionType.PURCHASE.name().toLowerCase());
        ThreeDomainSecureToken threeDs = new ThreeDomainSecureToken();
        threeDs.setType("A"); // A denotes apple pay
        threeDs.setData("NdCmVw5nMjQq746HYc/VbiZcQZ/zFzeEcM1wVMPruEG4/C/EFhobSkwB5JZJU+t6JuDVXUBiRYuOOC8FTYd+qIm6ckktid9aiGh0f2NDP0INSr59QXmr389RonyUfRYKnBmwsh5UqtI7Iz0AmMtl1PWMdxcCewtjuffs79ahTnFgXsRN+ynuhyDfbdRanlTnYKGoTeVh9eJfheJ1wquO+jiGj+npJ/Oh9bAdlw7iEHrYO2aUkgaMyXZ3foXRAJeimQVQS1y8lU1PPq62zpPrFzidbnnU5fK25pvGFjOdmLsBELZPk5thQEkSaA9p1LSKzWSesHhi0BxZaFPXSA6ANXvYIU2AT0lG+0O0w1URA5Sinyj3YDZVqjuir6rzNN9bB2U2nTQnKMbuGLMS20K8fUKZN/YLJh+AtE6J69+VVSU95mE1nOb8hyabz6E5RmnC5Ze2k6F/hQ75ig==");
        ThreeDomainSecureHeader header = new ThreeDomainSecureHeader();
        threeDs.setHeader(header);
        header.setApplicationDataHash("94ee059335e587e501cc4bf90613e0814f00a7b08bc7c648fd865a2af6a22cc2");
        header.setEphemeralPublicKey("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEiaU1SbkYTJy/j5L1t51vtGDh4KlNl5MFPWzo/C8r0WcrktWriz5pdRaDVUDvU++KlDu2iuQsd2xSNKJlFscbDQ==");
        header.setPublicKeyHash("YmSWN7lj4+A6fVJVPicP8TgS7gI7ougD8rEWB5LXtMM=");
        header.setTransactionId("31323334353637");
        threeDs.setSignature("\"MIAGCSqGSIb3DQEHAqCAMIACAQExDzANBglghkgBZQMEAgEFADCABgkqhkiG9w0BBwEAAKCAMIIB0zCCAXkCAQEwCQYHKoZIzj0EATB2MQswCQYDVQQGEwJVUzELMAkGA1UECAwCTkoxFDASBgNVBAcMC0plcnNleSBDaXR5MRMwEQYDVQQKDApGaXJzdCBEYXRhMRIwEAYDVQQLDAlGaXJzdCBBUEkxGzAZBgNVBAMMEmQxZHZ0bDEwMDAuMWRjLmNvbTAeFw0xNTA3MjMxNjQxMDNaFw0xOTA3MjIxNjQxMDNaMHYxCzAJBgNVBAYTAlVTMQswCQYDVQQIDAJOSjEUMBIGA1UEBwwLSmVyc2V5IENpdHkxEzARBgNVBAoMCkZpcnN0IERhdGExEjAQBgNVBAsMCUZpcnN0IEFQSTEbMBkGA1UEAwwSZDFkdnRsMTAwMC4xZGMuY29tMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAErnHhPM18HFbOomJMUiLiPL7nrJuWvfPy0Gg3xsX3m8q0oWhTs1QcQDTT+TR3yh4sDRPqXnsTUwcvbrCOzdUEeTAJBgcqhkjOPQQBA0kAMEYCIQDrC1z2JTx1jZPvllpnkxPEzBGk9BhTCkEB58j/Cv+sXQIhAKGongoz++3tJroo1GxnwvzK/Qmc4P1K2lHoh9biZeNhAAAxggFUMIIBUAIBATB7MHYxCzAJBgNVBAYTAlVTMQswCQYDVQQIDAJOSjEUMBIGA1UEBwwLSmVyc2V5IENpdHkxEzARBgNVBAoMCkZpcnN0IERhdGExEjAQBgNVBAsMCUZpcnN0IEFQSTEbMBkGA1UEAwwSZDFkdnRsMTAwMC4xZGMuY29tAgEBMA0GCWCGSAFlAwQCAQUAoGkwGAYJKoZIhvcNAQkDMQsGCSqGSIb3DQEHATAcBgkqhkiG9w0BCQUxDxcNMTUwODEyMTczMTAwWjAvBgkqhkiG9w0BCQQxIgQgJyjKLiGQo3I1ZbfHSmF2XCZ8dNlcZyohziuXO48EKwgwCgYIKoZIzj0EAwIESDBGAiEAznKDYEz9MsC+r1g6e4LR1DTaQOl+X2rVNkWnKDpc1EQCIQCmK48ChHoz4HWnUnW5XqaGWOUXKHQvUgeqFr/jgBUzegAAAAAAAA==\"");
        threeDs.setVersion("EC_v1");
        threeDs.setApplicationData("VEVTVA==");
        threeDs.setMerchantIdentifier("order-1");
        transactionRequest.setThreeDomainSecureToken(threeDs);
        Address address = new Address();
        address.setAddressLine1("dsdsds");
        address.setState("NY");
        address.setCity("New York");
        address.setCountry("US");
        address.setZip("11741");
        transactionRequest.setBilling(address);

        try {
            PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(transactionRequest);
            assertPayeezyResponse(payeezyResponse);
            TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
            assertTransactionResponse(transactionResponse);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Transaction failed");
        }
    }

    /**
     * Example of a fraud flex authorize request
     * Merchant account should be enabled for Fraud Flex
     * This does a credit card authorization and a fraud call, Please refer to the documentation on the fraud calls
     */

    @Test
    public void doCreditCardFraudAuthorization(){
        TransactionRequest transactionRequest = getCreditCardTransactionRequestForFraud(TransactionType.AUTHORIZE_SCORE.name().toLowerCase());
        try {
            PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(transactionRequest);
            assertFraudTransaction(payeezyResponse, transactionRequest);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Transaction failed");
        }
    }


    @Test
    public void doCreditCardFraudScoreOnly(){
        TransactionRequest transactionRequest = getCreditCardTransactionRequestForFraud(TransactionType.SCORE_ONLY.name().toLowerCase());
        try {
            PayeezyResponse payeezyResponse = payeezyClientHelper.doPrimaryTransaction(transactionRequest);
            assertFraudTransaction(payeezyResponse, transactionRequest);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Transaction failed");
        }
    }

    @Test
    public void doDynamicCurrencyCoversion(){
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setBin("559552");
        transactionRequest.setType("card_rate");
        transactionRequest.setAmount("100");
        requestOptions = new PayeezyRequestOptions(APIKEY, DCC_OKEN, SECURE_SECRET);
        try {
            PayeezyResponse payeezyResponse = payeezyClientHelper.doExchangeRate(transactionRequest);
            Assert.assertNotNull(payeezyResponse);
            Assert.assertEquals(payeezyResponse.getStatusCode(), HttpStatus.SC_OK);
            Assert.assertNotNull(payeezyResponse.getResponseBody());
        }catch (Exception ex){
            ex.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void doDynamicPricingLookup(){
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setBin("559552");
        transactionRequest.setType("merchant_rate");
        transactionRequest.setAmount("100");
        requestOptions = new PayeezyRequestOptions(APIKEY, DCC_OKEN, SECURE_SECRET);
        try {
            PayeezyResponse payeezyResponse = payeezyClientHelper.doExchangeRate(transactionRequest);
            Assert.assertNotNull(payeezyResponse);
            Assert.assertEquals(payeezyResponse.getStatusCode(), HttpStatus.SC_OK);
            Assert.assertNotNull(payeezyResponse.getResponseBody());
        }catch (Exception ex){
            ex.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void doDynamicPricingPurchase(){
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setBin("559552");
        transactionRequest.setType("card_rate");
        transactionRequest.setAmount("100");
        requestOptions = new PayeezyRequestOptions(APIKEY, DCC_OKEN, SECURE_SECRET);
        try {
            PayeezyResponse payeezyResponse = payeezyClientHelper.doExchangeRate(transactionRequest);
            Assert.assertNotNull(payeezyResponse);
            Assert.assertEquals(payeezyResponse.getStatusCode(), HttpStatus.SC_OK);
            Assert.assertNotNull(payeezyResponse.getResponseBody());
            CurrencyConversionResponse currencyConversionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), CurrencyConversionResponse.class);
            TransactionRequest purchaseRequest = new TransactionRequest();
            purchaseRequest.setAmount("100");
            purchaseRequest.setPaymentMethod(PaymentMethod.CREDIT_CARD.name().toLowerCase());
            purchaseRequest.setTransactionType(TransactionType.PURCHASE.name().toLowerCase());
            purchaseRequest.setCurrency("GBP");

            Card card = new Card();
            card.setName("Not Provided");
            card.setType("mastercard");
            card.setCvv("123");
            card.setExpiryDt("1220");
            card.setNumber("4389800000000006");
            purchaseRequest.setCard(card);
            RateReference rateReference = new RateReference();
            rateReference.setRateId(currencyConversionResponse.getRateId());
            purchaseRequest.setRateReference(rateReference);
            payeezyResponse = payeezyClientHelper.doPrimaryTransaction(purchaseRequest);
           assertPayeezyResponse(payeezyResponse);
            TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
            assertTransactionResponse(transactionResponse);
        }catch (Exception ex){
            ex.printStackTrace();
            Assert.fail();
        }
    }


    private void assertFraudTransaction(PayeezyResponse payeezyResponse, TransactionRequest transactionRequest){
        assertPayeezyResponse(payeezyResponse);
        TransactionResponse transactionResponse = jsonHelper.fromJson(payeezyResponse.getResponseBody(), TransactionResponse.class);
        assertTransactionResponse(transactionResponse, "Not Processed");
        Assert.assertNotNull(transactionResponse.getFraudScoreResponse());
        Assert.assertNotNull(transactionResponse.getFraudScoreResponse().getRecommendationCode());
        Assert.assertNotNull(transactionResponse.getFraudScoreResponse().getFraudScore());
        Assert.assertNotNull(transactionResponse.getFraudScoreResponse().getTransactionId(), transactionRequest.getReferenceNo());
    }

    private TransactionRequest getCreditCardTransactionRequestForFraud(String transactionType) {
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setReferenceNo(String.valueOf(System.currentTimeMillis())); // this is invoice number of the transaction, mandatory for fraud trnasactions
        transactionRequest.setAmount("100"); // ex: $1.00
        transactionRequest.setTransactionType(transactionType);
        transactionRequest.setPaymentMethod(PaymentMethod.CREDIT_CARD.getValue());
        transactionRequest.setReferenceNo(String.valueOf(System.currentTimeMillis())); //required for authorize_score and score_only calls
        transactionRequest.setPaymentMethod("credit_card");
        transactionRequest.setCurrency("USD");
        transactionRequest.setSalesChannel("WEB");
        transactionRequest.setSalesRep("TX1200");
        Card card = new Card();
        card.setName("Not Provided");
        card.setType("visa");
        card.setCvv("123");
        card.setExpiryDt("1020");
        card.setNumber("4012000033330026");
        transactionRequest.setCard(card);

        // Add Customer Info
        Customer customer = getCustomer();
        transactionRequest.setCustomer(customer);
        // Add Member Info
        Member member = getMember();
        transactionRequest.setMemberDetails(member);
        //Add Loyalty
        Loyalty loyalty = getLoyalty();
        transactionRequest.setLoyaltyDetails(loyalty);

        // add request origin i.e IP Address, Host Name, Device Id
        transactionRequest.setRequestOrigin(getTransactionRequestOrigin());

        // add level3 properties
        transactionRequest.setLevel3Properties(populateLevel3Properties());
        transactionRequest.setAdditionalShipping(getAdditionalShippingInfo());
        transactionRequest.setOrderDetails(getOrderDetails());
        return transactionRequest;
    }

    private TransactionRequestOrigin getTransactionRequestOrigin() {
        TransactionRequestOrigin transactionRequestOrigin = new TransactionRequestOrigin();
        transactionRequestOrigin.setDeviceId("XYZ1234asdfas");
        transactionRequestOrigin.setHost("google");
        transactionRequestOrigin.setIpAddress("192.198.23.25");
        return transactionRequestOrigin;
    }

    private Customer getCustomer() {
        Customer customer = new Customer();
        customer.setCustomerType(CustomerType.GUEST.getValue());
        customer.setBillingAddressChange("Y");
        customer.setCustomerId("MX123456");
        customer.setEmail("Accept@gmail.com");
        customer.setEmailChange("N");
        customer.setFirstName("First");
        customer.setLastName("Last");
        customer.setHomePhoneChange("N");
        customer.setMilddleName("Middle");
        customer.setPromoCode("PRAPR2015");
        customer.setStartDate("12/16/2015");
        customer.setPasswordChange("N");
        customer.setPromoAmount("10");
        customer.setSuffix("Jr");
        Contact contact = new Contact();
        Phone phone = new Phone();
        phone.setType("Mobile");
        phone.setNumber("212-858-8800");
        contact.setPhone(phone);
        List<Contact> contactList = new ArrayList<Contact>();
        customer.setContacts(contactList);
        return customer;
    }

    private Member getMember() {
        Member member = new Member();
        member.setBirthDate("12/20/1983");
        member.setStartDate("12/16/2015");
        member.setId("M12345");
        member.setLevel("PREMIUM");
        member.setStatus("ACTIVE");

        member.setAddress(getAddress());
        Contact contact = new Contact();
        Phone phone = new Phone();
        phone.setType("Mobile");
        phone.setNumber("212-858-8800");
        contact.setPhone(phone);
       return  member;
    }

    private Loyalty getLoyalty() {
        Loyalty loyalty = new Loyalty();
        loyalty.setStartDate("12/16/2015");
        loyalty.setId("M12345");
        loyalty.setLevel("PREMIUM");
        loyalty.setStatus("ACTIVE");
        return  loyalty;
    }
    private Address getAddress(){
        Address address = new Address();
        address.setAddressLine1("dsdsds");
        address.setState("NY");
        address.setCity("New York");
        address.setCountry("US");
        address.setZip("11741");
        Phone phone = new Phone();
        phone.setNumber("212-858-8000");
        phone.setType("Home");
        address.setPhoneNumber(phone);
        return  address;
    }

    private  void assertPayeezyResponse(PayeezyResponse payeezyResponse){
        Assert.assertNotNull(payeezyResponse);
        Assert.assertEquals(payeezyResponse.getStatusCode(), HttpStatus.SC_CREATED);
        Assert.assertNotNull(payeezyResponse.getResponseBody());
    }

    private  void assertTransactionResponse(TransactionResponse transactionResponse, String transactionStatus){
        Assert.assertNotNull(transactionResponse);
        Assert.assertEquals(transactionResponse.getValidationStatus(), "success");
        Assert.assertEquals(transactionResponse.getTransactionStatus(), transactionStatus);
        Assert.assertNotNull(transactionResponse.getAmount());
        Assert.assertNotNull(transactionResponse.getCorrID());
    }

    private  void assertTransactionResponse(TransactionResponse transactionResponse){
        assertTransactionResponse(transactionResponse, transactionResponse.getTransactionStatus());
        Assert.assertNotNull(transactionResponse.getTransactionTag());
        Assert.assertNotNull(transactionResponse.getTransactionId());
    }

    private Level3Properties populateLevel3Properties(){
        Level3Properties level3Properties = new Level3Properties();
        level3Properties.setCollectionStoreId("9986");
        level3Properties.setCompanyName("Fedex Shipments");
        level3Properties.setDate(new Date());
        level3Properties.setDeliveryIndicator("D");
        level3Properties.setDiscountAmount(new BigDecimal(10.25));
        level3Properties.setDutyAmount(new BigDecimal(0.0));
        level3Properties.setFreightAmount(new BigDecimal(5.95));
        level3Properties.setShipFromZip("10020");
        level3Properties.setShipMethod("AIR");
        level3Properties.setShippingCarrierName("Fexex");
        level3Properties.setShippingComments("Handle with care");
        level3Properties.setTaxAmount(new BigDecimal(2.36));
        level3Properties.setTaxRate(new BigDecimal(2.75));
        level3Properties.setTextMessage("Fraud Fraud");

        LineItem lineItem = new LineItem();
        lineItem.setCommodityCode("A");
        lineItem.setDescription("line item 1");
        lineItem.setDiscountAmount(new BigDecimal(0.1));
        lineItem.setDiscountIndicator("5");
        lineItem.setGrossNetIndicator("B");
        lineItem.setLineItemTotal(new BigDecimal(10.0));
        lineItem.setProductCode("BB");
        lineItem.setQuantity("5");
        lineItem.setTaxAmount(new BigDecimal(5.0));
        lineItem.setTaxRate(new BigDecimal(1.0));
        lineItem.setTaxType("T");
        lineItem.setUnitCost(new BigDecimal(2.0));
        lineItem.setUnitOfMeasure("M");
        List<LineItem> lineItems = new ArrayList<LineItem>();
        lineItems.add(lineItem);
        level3Properties.setLineItems(lineItems);
        ShipToAddress ship = new ShipToAddress();
        AddressType addressType = new AddressType();
        addressType.setIndicator("APT");
        addressType.setType("Apartment");
        ship.setAddressType(addressType);
        ship.setMobilePhone(null);
        ship.setFirstName("Fraud");
        ship.setLastName("Fraud");
        ship.setMiddleName("X");
        ship.setName("Fruadster is my name");
        ship.setPhoneType("Home");
        ship.setCity("New York");
        ship.setCountry("New York");
        ship.setCustomerNumber("1234546");
        ship.setEmail("abc@main.com");
        ship.setName("ABC");
        ship.setPhone("212-968-1100");
        ship.setState("NY");
        ship.setStreet("123 Main Street");
        ship.setZip("11375");
        level3Properties.setShipToAddress(ship);
        return level3Properties;
    }

    private AdditionalShippingInfo getAdditionalShippingInfo() {
        AdditionalShippingInfo additionalShippingInfo = new AdditionalShippingInfo();
        List<ShippingDetails> shippingDetailsArrayList = new ArrayList<ShippingDetails>();
        for (int i =0; i<2;i++) {
            ShippingDetails shippingDetails = new ShippingDetails();
            shippingDetails.setCollectionStoreId("2562");
            shippingDetails.setCompanyName("FedEx");
            shippingDetails.setDate("12/10/2015");
            shippingDetails.setDeliveryIndicator("N");
            shippingDetails.setShipFromZip("18752");
            shippingDetails.setShipMethod("G");
            shippingDetails.setShippingCarrierName("FexEx");
            shippingDetails.setShippingComments("Leave at the door");
            shippingDetails.setTextMessage("Fraud Transaction");
            shippingDetails.setAddressType(getAddressType());
            shippingDetails.setCity("New York");
            shippingDetails.setCountry("US");
            shippingDetails.setCustomerNumber("1235646");
            shippingDetails.setEmail("customer@email.com");
            shippingDetails.setFirstName("First Name");
            shippingDetails.setLastName("Last Name");
            shippingDetails.setMiddleName("JR");
            shippingDetails.setPhone("1234785960");
            shippingDetails.setPhoneType("home");
            shippingDetailsArrayList.add(shippingDetails);
        }

        additionalShippingInfo.setShippingDetailsList(shippingDetailsArrayList);
        return additionalShippingInfo;
    }

    private OrderDetails getOrderDetails() {
        OrderDetails details = new OrderDetails();
        List<String> detailsList = new ArrayList<String>();
        for (int i = 0; i<10;i++){
            detailsList.add("details"+i);
        }
        details.setDetails(detailsList);
        return details;
    }

    public AddressType getAddressType() {
        AddressType addressType = new AddressType();
        addressType.setIndicator("APT");
        addressType.setType("Apartment");
        return addressType;
    }

    String calculateDifference(String actualAmount, String authroizedAmount){
        BigDecimal amount1 = new BigDecimal(actualAmount);
        BigDecimal amount2 = new BigDecimal(authroizedAmount);
        return amount1.subtract(amount2).toString();
    }

    private TransactionRequest populateCommonGiftCardRequestInfo(String cardNumber){
        TransactionRequest request = new TransactionRequest();
        request.setPaymentMethod("valuelink");
        request.setCurrency("USD");
        ValueLink vk = new ValueLink();
        vk.setCardHoldersName( "Joe Smith");
        vk.setCardNumber( cardNumber);
        request.setValuelink(vk);
        return request;
    }
}
