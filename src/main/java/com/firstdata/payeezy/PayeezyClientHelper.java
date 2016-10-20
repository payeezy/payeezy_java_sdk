package com.firstdata.payeezy;

import com.firstdata.payeezy.api.APIResourceConstants;
import com.firstdata.payeezy.api.PayeezyRequestOptions;
import com.firstdata.payeezy.api.RequestMethod;
import com.firstdata.payeezy.client.PayeezyClient;
import com.firstdata.payeezy.client.PayeezyConfiguration;
import com.firstdata.payeezy.models.enrollment.BAARequest;
import com.firstdata.payeezy.models.enrollment.EnrollmentRequest;
import com.firstdata.payeezy.models.exception.ApplicationRuntimeException;
import com.firstdata.payeezy.models.transaction.PayeezyResponse;
import com.firstdata.payeezy.models.transaction.TransactionRequest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Helper class that provides convenient methods to execute primary, secondary, getToken and dynamic pricing API's
 * the URL should always point to the host.
 * when making the GetToken call do not pass the protocol as the helper sets up the protocol
 */
public class PayeezyClientHelper {

    private PayeezyClient payeezyClient;
    private Properties properties;
    private JSONHelper jsonHelper;

    /**
     * Loads the Configuration properties from ~HOME/.payeez.properties
     * throws ApplicationRuntimeException if Configuration file is not found
     * @throws ApplicationRuntimeException
     */
    public PayeezyClientHelper() {
        jsonHelper = new JSONHelper();
        try{
            properties = new Properties();
            properties.load(new FileInputStream(new PayeezyConfiguration().load()));
        }catch (FileNotFoundException e) {
            throw new ApplicationRuntimeException("Configuration file not found." +
                    " If you are not using the .payeezt.properties file," +
                    " please use the " + PayeezyClientHelper.class.getSimpleName() + "(Properties) constructor." +
                    " If you are using .payeezy.properties, you can generate one using java -jar payeezy-sdk-for-java-x.xx.jar", e);
        } catch (IOException e) {
            throw new ApplicationRuntimeException("Configuration file could not be loaded.  Check to see if the user running this has permission to access the file", e);
        }
        payeezyClient = new PayeezyClient(properties);
    }


    /**
     * Construct a PayeezyClientHelper specifying the configuration.
     * Properties that must be set are:
     * url
     * apikey
     * secret
     * token
     * proxyHost --> if behind a proxy
     * proxyPort --> proxy port, defaults to 80 if the proxyHost is provided, but no proxyPort set      *
     */
    public PayeezyClientHelper(Properties properties) {
        jsonHelper = new JSONHelper();
        if(properties ==null || properties.isEmpty()){
            throw new ApplicationRuntimeException("SDK Properties should be configured to use the Client. Please provide the required properties based on the type of transaction.");
        }
        this.properties = properties;
        payeezyClient = new PayeezyClient(properties);
    }

    /**
     * Use this for primary transactions like Authorize, Purchase
     * @param transactionRequest
     * @return
     * @throws Exception
     */
    public PayeezyResponse doPrimaryTransaction(TransactionRequest transactionRequest) throws Exception {
        String payload = jsonHelper.getJSONObject(transactionRequest);
        String URL = properties.getProperty("url");
        URL = URL+ APIResourceConstants.PRIMARY_TRANSACTIONS;
        PayeezyResponse payeezyResponse = payeezyClient.execute(URL, RequestMethod.POST, getRequestOptions(), payload );
        return payeezyResponse;
    }

    /**
     *Use this for Secondary transactions like void, refund, capture etc
     */

    public PayeezyResponse doSecondaryTransaction(String id, TransactionRequest transactionRequest) throws Exception {
        String URL = properties.getProperty("url");
        URL = URL+ APIResourceConstants.PRIMARY_TRANSACTIONS+ "/"+id;
        String payload = jsonHelper.getJSONObject(transactionRequest);
        PayeezyResponse payeezyResponse = payeezyClient.execute(URL, RequestMethod.POST, getRequestOptions(),payload );
        return payeezyResponse;
    }

    /**
     * Get Token Call to tokenize a credit card
     * @param queryMap
     * @return
     * @throws Exception
     */
    public PayeezyResponse doGetTokenCall(Map<String, String> queryMap) throws Exception {
        String URL = properties.getProperty("url")+ APIResourceConstants.SECURE_TOKEN_URL;
        if(URL.contains("http://")){
            URL.replace("https://", "");
        }
        if(!queryMap.containsKey(APIResourceConstants.SecurityConstants.APIKEY)){
            String apikey = properties.getProperty(APIResourceConstants.SecurityConstants.APIKEY);
            queryMap.put(APIResourceConstants.SecurityConstants.APIKEY, apikey);
        }

        if(!queryMap.containsKey(APIResourceConstants.SecurityConstants.JS_SECURITY_KEY)){
            String jsSecurityKey = properties.getProperty(APIResourceConstants.SecurityConstants.JS_SECURITY_KEY);
            queryMap.put(APIResourceConstants.SecurityConstants.JS_SECURITY_KEY, jsSecurityKey);
        }
        PayeezyResponse payeezyResponse = payeezyClient.execute(URL, RequestMethod.GET, null, queryMap);
        return payeezyResponse;
    }

    /**
     * Dynamic Pricing look up
     * @param transactionRequest
     * @return
     * @throws Exception
     */
    public PayeezyResponse doExchangeRate(TransactionRequest transactionRequest) throws Exception {
        String URL = properties.getProperty("url")+ APIResourceConstants.EXCHANGE_RATE;
        String payload = jsonHelper.getJSONObject(transactionRequest);
        PayeezyResponse payeezyResponse = payeezyClient.execute(URL, RequestMethod.POST, getRequestOptions(),payload );
        return payeezyResponse;
    }


    /**
     * API Call to search for events
     * @param URL
     * @param queryMap
     * @param requestOptions
     * @return
     * @throws Exception
     */
    public PayeezyResponse getEvents(String URL, Map<String, String> queryMap, PayeezyRequestOptions requestOptions) throws Exception {
        URL = URL+ APIResourceConstants.SECURE_TOKEN_URL;
        PayeezyResponse payeezyResponse = payeezyClient.execute(URL, RequestMethod.GET,requestOptions,queryMap);
        return payeezyResponse;
    }


    private  PayeezyRequestOptions getRequestOptions(){
        String apikey = properties.getProperty(APIResourceConstants.SecurityConstants.APIKEY);
        String secret = properties.getProperty(APIResourceConstants.SecurityConstants.APISECRET);
        String token = properties.getProperty(APIResourceConstants.SecurityConstants.TOKEN);
        return new PayeezyRequestOptions(apikey, token, secret);
    }

    /**
     * Enrollment call for Connect Pay
     * @param EnrollmentRequest
     * @return
     * @throws Exception
     */
    public PayeezyResponse enrollInConnectPay(EnrollmentRequest enrollmentRequest) throws Exception {
        String payload = jsonHelper.getJSONObject(enrollmentRequest);
        String URL = properties.getProperty("url");
        URL = URL+ APIResourceConstants.CONNECT_PAY_URL;
        PayeezyResponse payeezyResponse = payeezyClient.execute(URL, RequestMethod.POST, getRequestOptions(), payload );
        return payeezyResponse;
    }

    /**
     * Enrollment call for Connect Pay
     * @param BAARequest
     * @return
     * @throws Exception
     */
    public PayeezyResponse validateMicroDeposit(BAARequest microDeposit) throws Exception {
        String payload = jsonHelper.getJSONObject(microDeposit);
        String URL = properties.getProperty("url");
        URL = URL+ APIResourceConstants.CONNECT_PAY_MICRO_DEPOSIT;
        PayeezyResponse payeezyResponse = payeezyClient.execute(URL, RequestMethod.POST, getRequestOptions(), payload );
        return payeezyResponse;
    }

    /**
     * Update Connect Pay Enrollment info
     * @param BAARequest
     * @return
     * @throws Exception
     */
    public PayeezyResponse updateConnectPayEnrollment(EnrollmentRequest enrollmentRequest) throws Exception {
        String payload = jsonHelper.getJSONObject(enrollmentRequest);
        String URL = properties.getProperty("url");
        URL = URL+ APIResourceConstants.CONNECT_PAY_URL;
        PayeezyResponse payeezyResponse = payeezyClient.execute(URL, RequestMethod.PUT, getRequestOptions(), payload );
        return payeezyResponse;
    }

    /**
     * Close Enrollment call for Connect Pay
     * @param EnrollmentRequest
     * @return
     * @throws Exception
     */
    public PayeezyResponse closeConnectPayEnrollment(EnrollmentRequest enrollmentRequest) throws Exception {
        String payload = jsonHelper.getJSONObject(enrollmentRequest);
        String URL = properties.getProperty("url");
        URL = URL+ APIResourceConstants.CONNECT_PAY_CLOSE;
        PayeezyResponse payeezyResponse = payeezyClient.execute(URL, RequestMethod.POST, getRequestOptions(), payload );
        return payeezyResponse;
    }

}
