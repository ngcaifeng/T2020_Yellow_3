package com.javagbunga.springbootexample.WebServices;

import com.javagbunga.springbootexample.Common.CommonAPI;
import com.javagbunga.springbootexample.Common.CommonUtils;
import com.google.gson.JsonObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class wlll be responsible for getting all the accounts related request
 */
@RestController
public class AccountsController {

    @CrossOrigin
    @RequestMapping("/getUserAccount")
    public JsonObject getUserAccount(@RequestParam(value="customerID", defaultValue="") String customerID) {
        //Getting the request entity
        HttpEntity<String> requestEntity = CommonAPI.getHtttpEntity();
        //Modifying the URL
        String requestURL = CommonAPI.getListofDepositAccount + customerID;
        //Getting the responsible
        ResponseEntity<String> result = CommonAPI.getHTTPGetResponse(requestURL,requestEntity);
        return CommonUtils.convertStringToJson(result.getBody());
    }
}
