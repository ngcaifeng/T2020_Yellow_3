package com.javagbunga.springbootexample.WebServices;

import com.google.gson.JsonObject;
import com.javagbunga.springbootexample.Common.CommonAPI;
import com.javagbunga.springbootexample.Common.CommonUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class will be handling the transaction controller
 */
@RestController
public class TransactionController {

//    @CrossOrigin
//    @RequestMapping(path = "/getTransactionsDetails/{id}/{name}", method = RequestMethod.GET)
//    public JsonObject getTransactionsDetails(@RequestParam(value="accountID", defaultValue=""), String accountID) {
//        //Getting the request entity
//        HttpEntity<String> requestEntity = CommonAPI.getHtttpEntity();
//        //Modifying the URL
//        String requestURL = CommonAPI.getTransactionDetails;
//        requestURL = requestURL.replace("####", "customerID");
//
//        //Getting the responsible
//        ResponseEntity<String> result = CommonAPI.getHTTPGetResponse(requestURL,requestEntity);
//        return CommonUtils.convertStringToJson(result.getBody());
//    }
}
