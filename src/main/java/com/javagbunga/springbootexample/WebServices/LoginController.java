package com.javagbunga.springbootexample.WebServices;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.javagbunga.springbootexample.Common.CommonAPI;
import com.javagbunga.springbootexample.Common.CommonResponseAPI;
import com.javagbunga.springbootexample.WebModel.Customer;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;

public class LoginController {
    private static final String TOKEN = "63c06a21-263c-4e0a-a502-7230ac6f6b8f";
    private static final String PWD = "123";

    @RequestMapping("/login")
    public String login(@RequestParam(value = "userName") String userName,
                        @RequestParam(value = "password") String password) {

        //Getting the request entity
        HttpEntity<String> requestEntity = CommonAPI.getHtttpEntity();
        //Modifying the URL
        String requestURL = CommonAPI.getCustomerDetails + userName;
        //Getting the responsible
        ResponseEntity<String> result = CommonAPI.getHTTPGetResponse(requestURL,requestEntity);

        JsonObject jsonObject = new JsonParser().parse(result.getBody()).getAsJsonObject();
        Iterator<JsonElement> iterator = jsonArray.iterator();
        while(iterator.hasNext()) {
            JsonElement element = iterator.next();
            JsonObject object = element.getAsJsonObject();
            if(object.get("id").getAsString().equals()){
                return object.get("name").getAsString();
            }
        }
        return "";

        if(customer != null && password.equals(PWD)){]
            return "ok";
        }else{
            return "error";
        }
        return "OK";
    }
}

