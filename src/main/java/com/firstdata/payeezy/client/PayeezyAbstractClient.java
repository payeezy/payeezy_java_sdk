package com.firstdata.payeezy.client;

import com.firstdata.payeezy.api.APIResourceConstants;
import com.firstdata.payeezy.api.PayeezyRequestOptions;
import com.firstdata.payeezy.models.transaction.PayeezyResponse;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * Base client class that provides helper methods to calculate
 * authorization headers and request options
 */
public abstract class PayeezyAbstractClient {

    protected Map<String,String> getSecurityKeys(String payLoad, PayeezyRequestOptions requestOptions) throws Exception{
        Map<String,String> returnMap=new HashMap<String, String>();
        if(requestOptions == null){
            throw new Exception("Payeezy Request Options not set");
        }
        try {
            long nonce = Math.abs(SecureRandom.getInstance("SHA1PRNG").nextLong());
            returnMap.put(APIResourceConstants.SecurityConstants.NONCE, Long.toString(nonce));
            returnMap.put(APIResourceConstants.SecurityConstants.APIKEY, requestOptions.getApiKey());
            returnMap.put(APIResourceConstants.SecurityConstants.TIMESTAMP, Long.toString(System.currentTimeMillis()));
            returnMap.put(APIResourceConstants.SecurityConstants.TOKEN, requestOptions.getToken());
            returnMap.put(APIResourceConstants.SecurityConstants.APISECRET, requestOptions.getSecret());
            returnMap.put(APIResourceConstants.SecurityConstants.PAYLOAD, payLoad);
           // returnMap.put(APIResourceConstants.SecurityConstants.AUTHORIZE, getMacValue(returnMap));
            return returnMap;
        } catch (NoSuchAlgorithmException e) {
            MessageLogger.logMessage(e.getMessage());
            throw new RuntimeException(e.getMessage(),e);
        }
    }

    /**
     * Builds the authorization string that will sent as part of the Request Header
     * @param data
     * @return
     * @throws Exception
     */
    private String getMacValue(Map<String,String> data) throws Exception{
        Mac mac=Mac.getInstance("HmacSHA256");
        String apiSecret= data.get(APIResourceConstants.SecurityConstants.APISECRET);
        SecretKeySpec secret_key = new SecretKeySpec(apiSecret.getBytes(), "HmacSHA256");
        mac.init(secret_key);
        String apikey = data.get(APIResourceConstants.SecurityConstants.APIKEY);
        String nonce = data.get(APIResourceConstants.SecurityConstants.NONCE);
        String timeStamp = data.get(APIResourceConstants.SecurityConstants.TIMESTAMP);
        String token = data.get(APIResourceConstants.SecurityConstants.TOKEN);
        String payload = data.get(APIResourceConstants.SecurityConstants.PAYLOAD);

        StringBuilder buff=new StringBuilder();
        buff.append(apikey)
                .append(nonce)
                .append(timeStamp);
        if(token!=null){
            buff.append(token);
        }
        if(payload != null){
            buff.append(payload);
        }
        String bufferData = buff.toString();
        //MessageLogger.logMessage(String.format(bufferData));
        byte[] macHash=mac.doFinal(bufferData.getBytes("UTF-8"));
        //MessageLogger.logMessage(Integer.toString(macHash.length));
        //MessageLogger.logMessage(String.format("MacHAsh:{}" , macHash));
        String authorizeString = Base64.encodeBase64(toHex(macHash)).toString();
        //   MessageLogger.logMessage(String.format("Authorize:{}" , authorizeString));
        return authorizeString;
    }

    /**
     * Converts the bytes to Hex bytes
     * @param arr
     * @return
     */
    private byte[] toHex(byte[] arr) {
        String hex= byteArrayToHex(arr);
        return hex.getBytes();
    }

    private String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02x", b & 0xff));
        return sb.toString();
    }

    protected abstract PayeezyResponse executePostRequest(String uri, String payload, PayeezyRequestOptions requestOptions) throws Exception;

    protected abstract PayeezyResponse executeGetRequest(String uri, Map<String, String> queryParams) throws Exception;

}
