package com.javagbunga.springbootexample.WebServices;

import com.google.gson.*;
import com.javagbunga.springbootexample.Common.CommonAPI;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class DepositController {

    @CrossOrigin
    @RequestMapping("/getDepositBalance")
    public String getDepositBalance(@RequestParam(value="accountID", defaultValue="1") String accountID,
            @RequestParam(value="month", defaultValue="10") String month,
            @RequestParam(value="year", defaultValue="2018") String year)
    {

        //Getting the request entity
        HttpEntity<String> requestEntity = CommonAPI.getHtttpEntity();
        //Modifying the URL
        String requestURL = CommonAPI.getDepositAccount;
        requestURL = requestURL.replace("####", accountID);
        requestURL = requestURL.replace("MMMM", month);
        requestURL = requestURL.replace("YYYY", year);

        ResponseEntity<String> result = null;

        //Getting the responsible
        try {
            result = CommonAPI.getHTTPGetResponse(requestURL, requestEntity);
            //This portion we need to change this into json and return the ID
            return result.getBody();
        }catch(HttpClientErrorException e){
            return "400";
        }
    }
}
