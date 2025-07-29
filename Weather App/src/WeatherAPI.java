import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WeatherAPI {
    public static void main(String[] args) {
        try {
            Scanner scnr = new Scanner(System.in);
            String city;
            do{
                System.out.println("==============");
                System.out.print("Enter name of city (type no to exit): ");
                city = scnr.next();

                JSONObject cityLoc = (JSONObject) getLocationData(city);
                double latitude = (double) cityLoc.get("latitude");
                double longitude = (double) cityLoc.get("longitude");

                getWeatherData(latitude, longitude);
            }while(!city.equalsIgnoreCase("no"));

        }catch(Exception e){

            e.printStackTrace();
        }
    }

    private static JSONObject getLocationData(String city){
        city = city.replaceAll(" ", "+");
        String urlCity = "https://geocoding-api.open-meteo.com/v1/search?name=" +
                city + "&count=1&language=en&format=json";
        try {
            HttpURLConnection apiCon = fetchAPIResponse(urlCity);

            if (apiCon.getResponseCode() != 200) {
                System.out.println("Could not retrieve data.");
                return null;
            }
        String JSONResponse = readAPIResponse(apiCon);
        JSONParser parser = new JSONParser();
        JSONObject jsonRslt = (JSONObject) parser.parse(JSONResponse);
        JSONArray locData = (JSONArray) jsonRslt.get("results");

        return (JSONObject) locData.get(0);


        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private static void getWeatherData(double latitude, double longitude){
        try{

            String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude +
                    "&current=temperature_2m,rain,relative_humidity_2m&timezone=auto&forecast_days=1";
            HttpURLConnection apiConnection = fetchAPIResponse(url);


            if(apiConnection.getResponseCode() != 200){
                System.out.println("Error: Could not connect to API");
                return;
            }


            String jsonResponse = readAPIResponse(apiConnection);

            // 3. Parse the string into a JSON Object
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);
            JSONObject currentWeatherJson = (JSONObject) jsonObject.get("current");
//            System.out.println(currentWeatherJson.toJSONString());

            // 4. Store the data into their corresponding data type
            String time = (String) currentWeatherJson.get("time");
            System.out.println("Current Time: " + time);

            double temperature = (double) currentWeatherJson.get("temperature_2m");
            System.out.println("Current Temperature (C): " + temperature);

            long relativeHumidity = (long) currentWeatherJson.get("relative_humidity_2m");
            System.out.println("Relative Humidity: " + relativeHumidity);


        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private static HttpURLConnection fetchAPIResponse(String urlCity){
        try {
            URL url = new URL(urlCity);
            HttpURLConnection open = (HttpURLConnection) url.openConnection();
            open.setRequestMethod("GET");

            return open;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String readAPIResponse(HttpURLConnection apiCon){
        try{
            StringBuilder rslt = new StringBuilder();
            Scanner scnr = new Scanner(apiCon.getInputStream());
            while(scnr.hasNext()){
                rslt.append(scnr.nextLine());
                return rslt.toString();
            }
            scnr.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
