package com.javagbunga.springbootexample.WebServices;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.javagbunga.springbootexample.WebModel.Greeting;
import net.minidev.json.JSONArray;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
    @CrossOrigin
    @RequestMapping("/getAllEmployees")
    public String getAllEmployees(){
        //This will be the API Call URL

        final String uri = "http://dummy.restapiexample.com/api/v1/employees";
        System.out.println(uri);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }
    @RequestMapping("/getAllEmployee")
    public String getAllEmployee(@RequestParam(value="Id", defaultValue="3") String Id){
        //This will be the API Call URL
        final String uri = "https://jsonplaceholder.typicode.com/comments";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        JsonArray jsonArray = new JsonParser().parse(result).getAsJsonArray();
        Iterator<JsonElement> iterator = jsonArray.iterator();
        while(iterator.hasNext()) {
            JsonElement element = iterator.next();
            JsonObject object = element.getAsJsonObject();
            if(object.get("id").getAsString().equals(Id)){
                return object.get("name").getAsString();
            }
        }
        return "";
    }
}
