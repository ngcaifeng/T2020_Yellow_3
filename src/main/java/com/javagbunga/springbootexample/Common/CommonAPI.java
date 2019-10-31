package com.javagbunga.springbootexample.Common;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * This class will be containing all the static api
 */
public class CommonAPI {

    //This place is for variable.
    public final static String identify = "Group17";
    public final static String token = "63c06a21-263c-4e0a-a502-7230ac6f6b8f";

    //Customer API
    public final static String getCustomerID = "http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/customers/";
    public final static String getCustomerDetails = "http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/customers/####/details";

    //Account API
    public final static String getListofDepositAccount = "http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/accounts/deposit/";

    /**
     * This function will be responsible for getting http entity
     * @return
     */
    public static HttpEntity<String> getHtttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("identity", identify);
        headers.set("token", token);
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        return requestEntity;
    }

    /**
     * This function will be responsible for getting http get response
     * @param requestURL
     * @return
     */
    public static ResponseEntity<String> getHTTPGetResponse(String requestURL , HttpEntity<String> requestEntity){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(requestURL, HttpMethod.GET, requestEntity, String.class);
        return result;
    }
}
