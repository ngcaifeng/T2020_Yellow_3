package com.javagbunga.springbootexample.Common;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Iterator;

/**
 * This class will be handling all the common utils functionality
 */
public class CommonUtils {

    //This function will be responsible for converting the json String into a json object

    /**
     * This function will be responsible for converting jsonString to Json
     * @param response
     * @return
     */
    public static JsonObject convertStringToJson(String response) {
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(response).getAsJsonObject();
        return jsonObject;
    }

    /**
     * This function will be responsible for fetching an item from the json
     * @param jsonObject
     * @param key
     * @return
     */
    public static String fetchItemFromJson(JsonObject jsonObject, String key){
        return jsonObject.get(key).getAsString();
    }

    public static JsonArray convertStringToJsonArray(String response) {
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(response).getAsJsonArray();
        return jsonArray;
    }

}
