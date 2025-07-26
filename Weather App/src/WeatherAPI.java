import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.io.IOException;



public class WeatherAPI {
    public static void main(String[] args) {
       try{
           Scanner scnr = new Scanner(System.in);
           String city;
           do {
               System.out.println("=====================");
               System.out.println("Enter city name (type no to quit): ");
               city = scnr.next();
           }while(!city.equalsIgnoreCase("no"));

           JSONOBject cityLocData = (JSONObject) getLocData(city);
           double latitude = (double) cityLocData.get("latitude");
           double longitude = (double) cityLocData.get("longitude");

           displayWeatherOutput(latitude, longitude);

       } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getLocData(String city){
        city = city.replaceAll(" ", "+");
        String url = "https://geocoding-api.open-meteo.com/v1/search?name=" + city + "=1&language=en&format=json";

        try{
            HttpURLConnection apiCon = fetchAPIResponse(url);

            if(apiCon.getResponseCode() != 200){
                System.out.println("Could not retrieve data.");
                return null;
            }

            String jsonResponse = readAPIResponse(apiCon);

            JSONParser parser = new JSONParser();
            JSONObject resltJson = (JSONObject) parser.parse(jsonResponse);

            JSONArray locData = (JSONArray) resltJson.get("results");

            return (JSONObject) locData.get(0);


        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static HttpURLConnection fetchAPIResponse(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection open = (HttpURLConnection) url.openConnection();
            open.setRequestMethod("GET");

            return open;
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }

    private static String readAPIResponse(HttpURLConnection apiCon){
        StringBuilder rslt = new StringBuilder();
        try {
            Scanner scnr = new Scanner(apiCon.getInputStream());
            while (scnr.hasNext()){
                rslt.append(scnr.nextLine());
            }
            scnr.close();
            return rslt.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}