package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.*;

public class API {

    private final String API_KEY = "78d6b1e06b920f8d247dd691cc01b21b";
    private final String LOCATION = "London";
    private final String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&apikey=" + API_KEY + "&units=metric";

    public  Map<String, Object> jsonToMap(String str){
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>() {}.getType()
        );
        return map;
    }

    public void getAPI(){
        try{
            StringBuilder result = new StringBuilder();
            URL url =  new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line = rd.readLine()) != null){
                result.append(line);
            }
            rd.close();
            System.out.println(result);

            Map<String, Object> respMap = jsonToMap(result.toString());
            Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
            Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());

            System.out.println("Current Temperature: " + mainMap.get("temp"));
            System.out.println("Current Humidity: " + mainMap.get("humidity"));
            System.out.println("Wind Speeds: "+ windMap.get("speed"));
            System.out.println("Wind Angle: " + windMap.get("deg"));
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}