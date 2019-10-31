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
public class MarketingController {

    @CrossOrigin
    @RequestMapping("/marketing")
    public String getMarketing(@RequestParam(value="id", defaultValue="1") String marketingId)
    {
        ResponseEntity<String> result;

        //Getting the request entity
        HttpEntity<String> requestEntity = CommonAPI.getHtttpEntity();
        //Modifying the URL
        String requestURL = CommonAPI.getMarketingMessages + marketingId;

        try {
            result = CommonAPI.getHTTPGetResponse(requestURL, requestEntity);
        }catch(HttpClientErrorException e){
            return "400";
        }

        System.out.println(result);

        return CommonUtils.convertStringToJsonArray(result.getBody()).toString();

    }
}
