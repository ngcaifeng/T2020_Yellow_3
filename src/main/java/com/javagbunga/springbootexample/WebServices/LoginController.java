package com.javagbunga.springbootexample.WebServices;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.javagbunga.springbootexample.WebModel.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;

public class LoginController {
    private static final String TOKEN = "63c06a21-263c-4e0a-a502-7230ac6f6b8f";
    private static final String PWD = "123";

    @RequestMapping("/login")
    public String login(@RequestParam(value = "userName") String username,
                        @RequestParam(value = "password") String password) {
        //This will be the API Call URL
        final String uri = "http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com/customers/";
        RestTemplate restTemplate = new RestTemplate();

        //fetch user and convert to object
        //Customer customer = restTemplate.getForObject(uri+username, String.class);

//        String result = restTemplate.getForObject(uri, String.class);
//
//        JsonArray jsonArray = new JsonParser().parse(result).getAsJsonArray();
//        Iterator<JsonElement> iterator = jsonArray.iterator();
//        while(iterator.hasNext()) {
//            JsonElement element = iterator.next();
//            JsonObject object = element.getAsJsonObject();
//            if(object.get("id").getAsString().equals()){
//                return object.get("name").getAsString();
//            }
//        }
//        return "";
//
//        if(customer != null && password.equals(PWD)){]
//            return "ok";
//        }else{
//            return "error";
//        }
        return "";
    }
}

