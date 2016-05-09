package com.firstdata.payeezy.client;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class PayeezyHttpClientFactory {
    
    private static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 100;

    private static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 5;

    private static final int DEFAULT_READ_TIMEOUT_MILLISECONDS = (60 * 1000);
    
    private HttpClient httpClient;

    public PayeezyHttpClientFactory(Properties properties){
        buildHttpClient(properties);
    }

    public void buildHttpClient(Properties properties){
        try {
            SSLContext sslContext = new SSLContextBuilder().build();
            String[] protocols = {"TLSv1.2"};
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, protocols, null, null);
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
                    .<ConnectionSocketFactory>create()
                    .register("https", sslConnectionSocketFactory)
                    .register("http", new PlainConnectionSocketFactory())
                    .build();
            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(
                    socketFactoryRegistry);
            cm.setMaxTotal(Integer.valueOf(DEFAULT_MAX_TOTAL_CONNECTIONS));
            cm.setDefaultMaxPerRoute(Integer.valueOf(DEFAULT_MAX_CONNECTIONS_PER_ROUTE));
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(DEFAULT_READ_TIMEOUT_MILLISECONDS)
                    .setConnectTimeout(DEFAULT_READ_TIMEOUT_MILLISECONDS)
                    .setSocketTimeout(DEFAULT_READ_TIMEOUT_MILLISECONDS)
                    .setExpectContinueEnabled(true)
                    .setStaleConnectionCheckEnabled(true).build();

            HttpClientBuilder clientBuilder = HttpClientBuilder.create().setConnectionManager(cm);
            clientBuilder.setDefaultRequestConfig(requestConfig);
            // set proxy
            String proxyUrl = properties.getProperty("proxyHost");
            boolean proxyURLProvided = StringUtils.isNotEmpty(proxyUrl);
            if(!proxyURLProvided){
                System.out.println("No Proxy URL Set");
            }
            String proxyPort = properties.getProperty("proxyPort");
            if(proxyURLProvided && StringUtils.isEmpty(proxyPort)){
                System.out.println("Proxy Port not provided. Defaulting to port 80");
                proxyPort = "80";
            }

            if(proxyURLProvided){
                HttpHost proxy = new HttpHost(proxyUrl, Integer.parseInt(proxyPort));
                clientBuilder.setProxy(proxy);
            }

            httpClient = clientBuilder.build();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (KeyManagementException ex){
            ex.printStackTrace();
        }
    }
    
    public HttpClient getHttpClient() {
        return httpClient;
    }
}
