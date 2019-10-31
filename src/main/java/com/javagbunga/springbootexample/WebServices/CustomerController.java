package com.javagbunga.springbootexample.WebServices;

import com.javagbunga.springbootexample.Common.CommonAPI;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.HttpEntity;
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
    @RequestMapping("/getCustomerID")
    public String getCustomerID(@RequestParam(value="userName", defaultValue="") String userName) {
        //Getting the request entity
        HttpEntity<String> requestEntity = CommonAPI.getHtttpEntity();
        //Modifying the URL
        String requestURL = CommonAPI.getCustomerID + userName;
        //Getting the responsible
        ResponseEntity<String> result = CommonAPI.getHTTPGetResponse(requestURL,requestEntity);

        //This portion we need to change this into json and return the ID
        String response = result.getBody();
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(response).getAsJsonObject();
        //This is the part where i will return the ID of the customer
        return jsonObject.toString();
    }

    @CrossOrigin
    @RequestMapping("/getCustomerDetails")
    public String getCustomerDetails(@RequestParam(value="customerID", defaultValue="") String customerID) {
        //Getting the request entity
        HttpEntity<String> requestEntity = CommonAPI.getHtttpEntity();
        //Modifying the URL
        String requestURL = CommonAPI.getCustomerDetails;
        requestURL = requestURL.replace("####",customerID);
        //Getting the responsible
        ResponseEntity<String> result = CommonAPI.getHTTPGetResponse(requestURL,requestEntity);
        return result.getBody();
    }





}
