package com.javagbunga.springbootexample.WebServices;

import com.google.gson.*;
import com.javagbunga.springbootexample.Common.CommonAPI;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;

/**
 * This class will be handling the transaction controller
 */
@RestController
public class TransactionController {
    @CrossOrigin
    @RequestMapping(path = "/getTransactionsDetailsByTags")
    public String getTransactionsDetailsByTags(@RequestParam(value="accountID", defaultValue="") String accountID ,@RequestParam(value="fromDate", defaultValue="") String fromDate , @RequestParam(value="toDate", defaultValue="") String toDate) {
        //Getting the request entity
        HttpEntity<String> requestEntity = CommonAPI.getHtttpEntity();
        //Modifying the URL
        String requestURL = CommonAPI.getTransactionDetails;
        requestURL = requestURL.replace("####", accountID);
        requestURL = requestURL.replace("FFFF", fromDate);
        requestURL = requestURL.replace("TTTT", toDate);
        //Getting the responsible
        ResponseEntity<String> result = CommonAPI.getHTTPGetResponse(requestURL,requestEntity);

        //This portion we need to change this into json and return the ID
        String response = result.getBody();
        HashMap<String, Float> tagCategories = new HashMap<>();
        //This is the part whereby
        JsonArray jsonArray = new JsonParser().parse(response).getAsJsonArray();
        Iterator<JsonElement> iterator = jsonArray.iterator();
        while(iterator.hasNext()) {
            JsonElement element = iterator.next();
            JsonObject object = element.getAsJsonObject();
            String tag = object.get("tag").getAsString();
            String amount = object.get("amount").getAsString();

            //If the tag catgories for such key of the FNB
            if(tagCategories.containsKey(tag)){
                float baseAmount = tagCategories.get(tag);
                baseAmount = baseAmount + Float.parseFloat(amount);
                tagCategories.put(tag,baseAmount);
            }else{
                //If this is a new categories
                tagCategories.put(tag,Float.parseFloat(amount));
            }
        }
        String jsonString = new Gson().toJson(tagCategories);
        //This is the part where i will return the ID of the customer
        return jsonString;
    }


    /**
     * This function will be responsible for returning the transaction details and grouping them by type
     * @return
     */
    @CrossOrigin
    @RequestMapping(path = "/getTransactionsDetailsByType")
    public String getTransactionsDetailsByType(@RequestParam(value="accountID", defaultValue="") String accountID ,@RequestParam(value="fromDate", defaultValue="") String fromDate , @RequestParam(value="toDate", defaultValue="") String toDate) {
        //Getting the request entity
        HttpEntity<String> requestEntity = CommonAPI.getHtttpEntity();
        //Modifying the URL
        String requestURL = CommonAPI.getTransactionDetails;
        requestURL = requestURL.replace("####", accountID);
        requestURL = requestURL.replace("FFFF", fromDate);
        requestURL = requestURL.replace("TTTT", toDate);
        //Getting the responsible
        ResponseEntity<String> result = CommonAPI.getHTTPGetResponse(requestURL,requestEntity);

        //This portion we need to change this into json and return the ID
        String response = result.getBody();
        HashMap<String, Float> tagCategories = new HashMap<>();
        //This is the part whereby
        JsonArray jsonArray = new JsonParser().parse(response).getAsJsonArray();
        Iterator<JsonElement> iterator = jsonArray.iterator();
        while(iterator.hasNext()) {
            JsonElement element = iterator.next();
            JsonObject object = element.getAsJsonObject();
            String type = object.get("type").getAsString();
            String amount = object.get("amount").getAsString();

            //If the tag catgories for such key of the FNB
            if(tagCategories.containsKey(type)){
                float baseAmount = tagCategories.get(type);
                baseAmount = baseAmount + Float.parseFloat(amount);
                tagCategories.put(type,baseAmount);
            }else{
                //If this is a new categories
                tagCategories.put(type,Float.parseFloat(amount));
            }
        }
        String jsonString = new Gson().toJson(tagCategories);
        return jsonString;
    }


    @CrossOrigin
    @RequestMapping(path = "/getListofTransaction")
    public String getListofTransaction(@RequestParam(value="accountID", defaultValue="") String accountID ,@RequestParam(value="fromDate", defaultValue="") String fromDate , @RequestParam(value="toDate", defaultValue="") String toDate) {
//Getting the request entity
        HttpEntity<String> requestEntity = CommonAPI.getHtttpEntity();
        //Modifying the URL
        String requestURL = CommonAPI.getTransactionDetails;
        requestURL = requestURL.replace("####", accountID);
        requestURL = requestURL.replace("FFFF", fromDate);
        requestURL = requestURL.replace("TTTT", toDate);
        //Getting the responsible
        ResponseEntity<String> result = CommonAPI.getHTTPGetResponse(requestURL,requestEntity);

        //This portion we need to change this into json and return the ID
        String response = result.getBody();
        return result.getBody();
    }

    @CrossOrigin
    @RequestMapping(path = "/getComputedAmount")
    public String getComputedAmount(@RequestParam(value="accountID", defaultValue="") String accountID ,@RequestParam(value="fromDate", defaultValue="") String fromDate , @RequestParam(value="toDate", defaultValue="") String toDate) {
        HttpEntity<String> requestEntity = CommonAPI.getHtttpEntity();
        //Modifying the URL
        String requestURL = CommonAPI.getTransactionDetails;
        requestURL = requestURL.replace("####", accountID);
        requestURL = requestURL.replace("FFFF", fromDate);
        requestURL = requestURL.replace("TTTT", toDate);
        //Getting the responsible
        ResponseEntity<String> result = CommonAPI.getHTTPGetResponse(requestURL,requestEntity);

        float totalAmount = 0;
        //This portion we need to change this into json and return the ID
        String response = result.getBody();
        JsonArray jsonArray = new JsonParser().parse(response).getAsJsonArray();
        Iterator<JsonElement> iterator = jsonArray.iterator();
        while(iterator.hasNext()) {
            JsonElement element = iterator.next();
            JsonObject object = element.getAsJsonObject();
            String amount = object.get("amount").getAsString();
            totalAmount = totalAmount + Float.parseFloat(amount);
        }
        return String.valueOf(totalAmount);
    }
}
