package com.javagbunga.springbootexample.WebServices;

import com.google.gson.JsonObject;
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
    @RequestMapping("/deposit_balance")
    public String getDepositBalance(@RequestParam(value="accountId", defaultValue="1") String accountId,
            @RequestParam(value="accountId", defaultValue="1") String month,
            @RequestParam(value="accountId", defaultValue="1") String year)
    {
        ResponseEntity<String> result;

        //Getting the request entity
        HttpEntity<String> requestEntity = CommonAPI.getHtttpEntity();
        //Modifying the URL
        String requestURL = CommonAPI.getCreditBalance + accountId + "/balance?month="+month+"&year="+year;

        try {
            result = CommonAPI.getHTTPGetResponse(requestURL, requestEntity);
        }catch(HttpClientErrorException e){
            return "400";
        }

        System.out.println(result);

        return result.getBody();
    }
}
