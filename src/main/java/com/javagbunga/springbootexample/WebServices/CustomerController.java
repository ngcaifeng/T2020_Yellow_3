package com.javagbunga.springbootexample.WebServices;

import com.javagbunga.springbootexample.Common.CommonAPI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller will be responsible for getting all the customer  response
 */
@RestController
public class CustomerController {
    @CrossOrigin
    @RequestMapping("/getCustomerDetails")
    public String getCustomerDetails(@RequestParam(value="userName", defaultValue="marytan") String userName) {
        //Getting the request entity
        HttpEntity<String> requestEntity = CommonAPI.getHtttpEntity();
        //Modifying the URL
        String requestURL = CommonAPI.getCustomerDetails + userName;
        //Getting the responsible
        ResponseEntity<String> result = CommonAPI.getHTTPGetResponse(requestURL,requestEntity);
        return result.getBody();
    }

}
