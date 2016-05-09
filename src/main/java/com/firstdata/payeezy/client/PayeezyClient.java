package com.firstdata.payeezy.client;

import com.firstdata.payeezy.api.APIResourceConstants;
import com.firstdata.payeezy.api.PayeezyRequestOptions;
import com.firstdata.payeezy.api.RequestMethod;
import com.firstdata.payeezy.models.transaction.PayeezyResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Client class that provides convenience methods to execute GET and POST requests
 */
public class PayeezyClient extends PayeezyAbstractClient {

    private PayeezyHttpClientFactory payeezyHttpClient;

    public PayeezyClient(Properties properties){
        payeezyHttpClient = new PayeezyHttpClientFactory(properties);
    }

    /**
     * Reads the required credentials and the host information from VCAP_SERVICES variables
     * making it cloudfoundry aware
     * @param method
     * @param payload
     * @return
     * @throws Exception
     */
    public PayeezyResponse execute(RequestMethod method, Object payload) throws Exception{
        String envString = System.getenv("VCAP_SERVICES");
        String apikey = null;
        String token = null;
        String secret = null;
        String url = null;
        JSONParser jsonParser = new JSONParser();
        try{
            JSONObject vcapServiceObject = (JSONObject) jsonParser.parse(envString);
            JSONArray payeezyJsonArray = (JSONArray) vcapServiceObject.get("payeezy-service");
            JSONObject payeezyObject = (JSONObject)payeezyJsonArray.get(0);
            if(payeezyObject != null){
                JSONObject credentialsObject = (JSONObject) payeezyObject.get("credentials");
                apikey = (String) credentialsObject.get("apikey");
                token = (String) credentialsObject.get("token");
                secret = (String) credentialsObject.get("secret");
                url = (String) credentialsObject.get("uri");
                if(url != null && !url.contains("https")){
                    url = "https://"+url;
                }
            }
        }catch (ParseException ex){
            ex.printStackTrace();
        }
        PayeezyRequestOptions requestOptions = new PayeezyRequestOptions(apikey, token, secret);
        return  execute(url, method, requestOptions, payload);
    }

    /**
     * Method that executes a GET and POST for the provided payload
     * @param URL
     * @param method
     * @param requestOptions
     * @param payload
     * @return
     * @throws Exception
     */
    public PayeezyResponse execute(String URL, RequestMethod method, PayeezyRequestOptions requestOptions, Object payload) throws Exception{
        switch (method){
            case GET:
                return executeGetRequest(URL,(Map<String,String>) payload);
            case POST:
                return executePostRequest(URL,(String) payload,requestOptions);
            default:
                throw new Exception("Unsupported Request Method");
        }
    }

    /**
     * Execute a POST Request
     * @param uri
     * @param payload
     * @param requestOptions
     * @return
     * @throws Exception
     */
    protected PayeezyResponse executePostRequest(String uri, String payload, PayeezyRequestOptions requestOptions) throws Exception{
        HttpClient httpClient = payeezyHttpClient.getHttpClient();
        HttpPost httpPost =  createPostConnection(uri,payload,requestOptions);
        StringEntity entity = new StringEntity(payload);
        httpPost.setEntity(entity);
        // Create a custom response handler
        ResponseHandler<PayeezyResponse> responseHandler = new ResponseHandler<PayeezyResponse>() {

           public PayeezyResponse handleResponse(final HttpResponse response) throws IOException {
                    int status = response.getStatusLine().getStatusCode();
                    HttpEntity entity = response.getEntity();
                    String jsonResponse = entity != null ? EntityUtils.toString(entity) : null;
               return new PayeezyResponse(status, jsonResponse);
            }

        };
        return httpClient.execute(httpPost, responseHandler);
    }

    /**
     * Execute a Get Request
     * @param uri
     * @param queryParams
     * @return
     * @throws Exception
     */
    protected PayeezyResponse executeGetRequest(String uri, Map<String,String> queryParams) throws Exception{
        URI buildURI =  buildGetURI(uri, queryParams);
        HttpGet httpGet = new HttpGet(buildURI);
        HttpClient httpClient = payeezyHttpClient.getHttpClient();
        ResponseHandler<PayeezyResponse> responseHandler = new ResponseHandler<PayeezyResponse>() {

                public PayeezyResponse handleResponse(final HttpResponse response) throws IOException {
                    int status = response.getStatusLine().getStatusCode();
                    HttpEntity entity = response.getEntity();
                    String jsonResponse = entity != null ? EntityUtils.toString(entity) : null;
                    String tokenResponse = jsonResponse.substring(jsonResponse.indexOf(":{") + 1, jsonResponse.indexOf("})"));
                    return new PayeezyResponse(status, tokenResponse);
           }

            };
        return httpClient.execute(httpGet, responseHandler);
    }

    /**
     * Build GET URI
     * @param uri
     * @param queryParams
     * @return
     * @throws URISyntaxException
     */
    private URI buildGetURI(String uri, Map<String, String> queryParams) throws URISyntaxException {
        if(uri.contains("https://")){
           uri = uri.replace("https://", "");
        }
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setHost(uri);
        uriBuilder.setScheme("https");
        Set<String> keySet = queryParams.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            uriBuilder.setParameter(key, queryParams.get(key));
        }
        return uriBuilder.build();
    }

    /**
     * Create Post Connection
     * @param uri
     * @param payload
     * @param requestOptions
     * @return
     * @throws Exception
     */
    private HttpPost createPostConnection(String uri, String payload, PayeezyRequestOptions requestOptions) throws  Exception{
        HttpPost post = new HttpPost(uri);
        setHttpHeaders(post,payload, requestOptions );
        return post;
    }

    /**
     * Set the HTTP Headers required for the request
     * @param httpPost
     * @param payload
     * @param requestOptions
     * @throws Exception
     */

    private void setHttpHeaders(HttpPost httpPost, String payload, PayeezyRequestOptions requestOptions) throws  Exception{
        Map<String, String> keyMap = getSecurityKeys( payload, requestOptions);
        Iterator<String> iter=keyMap.keySet().iterator();
        while(iter.hasNext()) {
            String key=iter.next();
            if(APIResourceConstants.SecurityConstants.PAYLOAD.equals(key))
                continue;
            httpPost.setHeader(key, keyMap.get(key));
        }
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Linux; U; Android 4.0.3; ko-kr; LG-L160L Build/IML74K) AppleWebkit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
    }

}
