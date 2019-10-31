package com.javagbunga.springbootexample.WebServices;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.javagbunga.springbootexample.Common.CommonAPI;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class LoginController {

    private static final String PWD = "123";

    @CrossOrigin
    @RequestMapping("/login")
    public String login(@RequestParam(value="userName", defaultValue="limzeyang") String userName) {


        //Getting the request entity
        HttpEntity<String> requestEntity = CommonAPI.getHtttpEntity();
        //Modifying the URL
        String requestURL = CommonAPI.getCustomerDetails + userName;
        //Getting the responsible

        ResponseEntity<String> result;
        try {
            result = CommonAPI.getHTTPGetResponse(requestURL, requestEntity);
            return result.getBody();
        }catch(HttpClientErrorException e){
            return "400";
        }
    }
}
