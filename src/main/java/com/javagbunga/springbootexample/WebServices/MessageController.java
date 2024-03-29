package com.javagbunga.springbootexample.WebServices;

import com.javagbunga.springbootexample.Common.CommonAPI;
import com.javagbunga.springbootexample.Common.CommonUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class MessageController {

    @CrossOrigin
    @RequestMapping("/messages")
    public String getMessages(@RequestParam(value="customerId", defaultValue="1") String customerId)
    {
        ResponseEntity<String> result;

            //Getting the request entity
            HttpEntity<String> requestEntity = CommonAPI.getHtttpEntity();
            //Modifying the URL
            String requestURL = CommonAPI.getPersonalMessages + customerId;

            try {
                result = CommonAPI.getHTTPGetResponse(requestURL, requestEntity);
            }catch(HttpClientErrorException e){
                return "400";
            }


        return CommonUtils.convertStringToJsonArray(result.getBody()).toString();

    }
}
