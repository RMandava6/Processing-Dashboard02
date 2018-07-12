import java.util.*;
import processing.data.*;
import processing.core.*;
//import java.io.FileReader;  
import java.io.*;

public class DataLoader {
  public static final String BASE_FOLDER= "/Users/raminfarhanian/projects/Visualization/midterm/Processing-Dashboard02/Dashboard_Initial/Data";
  //public static final String BASE_FOLDER= "/Users/ramya/Documents/GitHub/Processing-Dashboard02/Dashboard_Initial/Data";
  private static final String JSON_FOLDER = BASE_FOLDER + "/json/";
  private static final String COUNTRY_NAME_PATH = JSON_FOLDER + "country-by-name.json";
  private static final String COUNTRY_ABBREVIATION_PATH = JSON_FOLDER + "country-by-abbreviation.json";
  private static final String COUNTRY_AVERAGE_MALE_HEIGHT_PATH = JSON_FOLDER + "country-by-avg-male-height.json";
  private static final String COUNTRY_BARCODE_PATH = JSON_FOLDER + "country-by-barcode-prefix.json";
  private static final String COUNTRY_CALLING_CODE_PATH = JSON_FOLDER + "country-by-calling-code.json";
  private static final String COUNTRY_CAPITAL_CITY_PATH = JSON_FOLDER + "country-by-capital-city.json";
  private static final String COUNTRY_LIFE_EXPECTANCY_PATH = JSON_FOLDER + "country-by-life-expectancy.json";
  private static final String COUNTRY_LONGITUDE_LATITUDE_PATH = JSON_FOLDER + "country-by-long-lat.json";
  private static final String COUNTRY_POPULATION_PATH = JSON_FOLDER + "country-by-population.json";
  private static final String COUNTRY_SURFACE_AREA_PATH = JSON_FOLDER + "country-by-surface-area.json";
  private static final String COUNTRY_BY_YEARLY_AVERAGE_TEMPERATURE = JSON_FOLDER + "country-by-yearly-average-temperature.json";
 
 public static Map<String, Country> init() {
 
   try {
   Map<String, Country> map = DataLoader.loadCountryMap();
    loadAbbreviation(map);
    loadAverageHeight(map);
    loadBarcode(map);
    loadCallingCode(map);
    loadCapitalCity(map);
    loadLifeExpectancy(map); 
    loadLongitudeAndLatitude(map);
    loadPopulation(map);
    loadSurfaceArea(map);
    loadTemperature(map);
    return map;
   } catch(Exception e) {
     throw new IllegalStateException(e);
   }
 
 }
 private static Map<String, Country> loadCountryMap() throws Exception {
   Map<String, Country> countryMap = new HashMap<>();
   JSONArray jsonArray = JSONArray.parse(readFile(COUNTRY_NAME_PATH));
   
   for(int i = 0; i < jsonArray.size(); i++){
    JSONObject jsonItem = jsonArray.getJSONObject(i);
    String name = (String) jsonItem.get("country");
    Country country = new Country();
    country.setName(name);
    countryMap.put(name, country);
  }
   return countryMap;
 }

private static void loadAbbreviation(Map<String, Country> countries) throws Exception {
   JSONArray jsonArray = JSONArray.parse(readFile(COUNTRY_ABBREVIATION_PATH));
   
   
   for(int i = 0; i < jsonArray.size(); i++){
    JSONObject jsonItem = jsonArray.getJSONObject(i);
    String name = (String) jsonItem.get("country");
    //System.out.println("NAME:" + name);
    Country country = countries.get(name);
    if(country!=null) {
    country.setAbbreviation((String) jsonItem.get("abbreviation"));
    //System.out.println(country);
    }
    else {
      System.out.println("country not available for abbreviation: " + name);
  }}
 }

private static void loadAverageHeight(Map<String, Country> countries) throws Exception {
   JSONArray jsonArray = JSONArray.parse(readFile(COUNTRY_AVERAGE_MALE_HEIGHT_PATH));
   
   for(int i = 0; i < jsonArray.size(); i++){
    JSONObject jsonItem = jsonArray.getJSONObject(i);
    String name = (String) jsonItem.get("country");
    Country country = countries.get(name);
    //System.out.println(country);
    if(country!=null) {
    country.setHeight((Double) jsonItem.get("height"));
    //System.out.println(country);
    }
    else {
      System.out.println("country not available for average height: " + name);
    }
  }
 }

private static void loadBarcode(Map<String, Country> countries) throws Exception {
   JSONArray jsonArray = JSONArray.parse(readFile(COUNTRY_BARCODE_PATH));
   
   for(int i = 0; i < jsonArray.size(); i++){
    JSONObject jsonItem = jsonArray.getJSONObject(i);
    String name = (String) jsonItem.get("country");
    Country country = countries.get(name);
    //System.out.println(country);
    if(country!=null) {
      country.setBarCode((String) jsonItem.get("barcode"));
    }
    else {
      System.out.println("country not available for bar code: " + name);
    }
  }
 }
 
 private static void loadCallingCode(Map<String, Country> countries) throws Exception {
   String callingCode = readFile(COUNTRY_CALLING_CODE_PATH);
   //System.out.println(callingCode);
   JSONArray jsonArray = JSONArray.parse(callingCode);
   //System.out.println(jsonArray);
   for(int i = 0; i < jsonArray.size(); i++){
    JSONObject jsonItem = jsonArray.getJSONObject(i);
    String name = (String) jsonItem.get("country");
       //System.out.println(name);
    Country country = countries.get(name);
    //System.out.println(country);
    if(country!=null) {
      country.setCalling_code((String) jsonItem.get("calling_code"));
    }
    else {
      System.out.println("country not available for calling_code: " + name);
    }
  }
 }
 
 private static void loadCapitalCity(Map<String, Country> countries) throws Exception {
   
   JSONArray jsonArray = JSONArray.parse(readFile(COUNTRY_CAPITAL_CITY_PATH));
   for(int i = 0; i < jsonArray.size(); i++){
    JSONObject jsonItem = jsonArray.getJSONObject(i);
    String name = (String) jsonItem.get("country");
       //System.out.println(name);
    Country country = countries.get(name);
    if(country!=null && !jsonItem.isNull("city")) {
        country.setCity((String)jsonItem.get("city"));
    }
    else {
      System.out.println("country not available for capital city: " + name);
    }
  }
 }
 
 private static void loadLifeExpectancy(Map<String, Country> countries) throws Exception {
   
   JSONArray jsonArray = JSONArray.parse(readFile(COUNTRY_LIFE_EXPECTANCY_PATH));
   for(int i = 0; i < jsonArray.size(); i++){
    JSONObject jsonItem = jsonArray.getJSONObject(i);
    String name = (String) jsonItem.get("country");
       //System.out.println(name);
    Country country = countries.get(name);
    if(country!=null && !jsonItem.isNull("expectancy")) {
        country.setExpectancy((Double)jsonItem.get("expectancy"));
    }
    else {
      System.out.println("country not available for Life expectancy: " + name);
    }
  }
 }
 

    private static void loadLongitudeAndLatitude(Map<String, Country> countries) throws Exception {

        JSONArray jsonArray = JSONArray.parse(readFile(COUNTRY_LONGITUDE_LATITUDE_PATH));
        for(int i = 0; i < jsonArray.size(); i++){
            JSONObject jsonItem = jsonArray.getJSONObject(i);
            String name = (String) jsonItem.get("name");
            //System.out.println(name);
            Country country = countries.get(name);
            if(country!=null && !jsonItem.isNull("latitude") && !jsonItem.isNull("longitude")) {
                country.setLongitude((Double)jsonItem.get("longitude"));
                country.setLatitude((Double)jsonItem.get("latitude"));
                float cx = CoordinationUtils.mercX(0, 1);
                float cy = CoordinationUtils.mercY(0, 1);
                float x = CoordinationUtils.mercX(country.getLongitude().floatValue(), 1) - cx;
                float y = CoordinationUtils.mercY(country.getLatitude().floatValue(), 1) - cy;
                country.setX(x);
                country.setY(y);
            }
            else {
                System.out.println("country not available for Longitude or Latitude: " + name);
            }
        }
    }

    private static void loadPopulation(Map<String, Country> countries) throws Exception {

        JSONArray jsonArray = JSONArray.parse(readFile(COUNTRY_POPULATION_PATH));
        for(int i = 0; i < jsonArray.size(); i++){
            JSONObject jsonItem = jsonArray.getJSONObject(i);
            String name = (String) jsonItem.get("country");
            //System.out.println(name);
            Country country = countries.get(name);
            if(country!=null && !jsonItem.isNull("population")) {
                country.setPopulation((Integer)jsonItem.get("population"));
            }
            else {
                System.out.println("country not available for Population: " + name);
            }
        }
    }
    
    private static void loadSurfaceArea(Map<String, Country> countries) throws Exception {

        JSONArray jsonArray = JSONArray.parse(readFile(COUNTRY_SURFACE_AREA_PATH));
        for(int i = 0; i < jsonArray.size(); i++){
            JSONObject jsonItem = jsonArray.getJSONObject(i);
            String name = (String) jsonItem.get("country");
            //System.out.println(name);
            Country country = countries.get(name);
            if(country!=null && !jsonItem.isNull("area")) {
                country.setArea(Float.valueOf(jsonItem.get("area").toString()));
            }
            else {
                System.out.println("country not available for Surface Area: " + name);
            }
        }
    }
    
   private static void loadTemperature(Map<String, Country> countries) throws Exception {
        JSONArray jsonArray = JSONArray.parse(readFile(COUNTRY_BY_YEARLY_AVERAGE_TEMPERATURE));
        for(int i = 0; i < jsonArray.size(); i++){
            JSONObject jsonItem = jsonArray.getJSONObject(i);
            String name = (String) jsonItem.get("country");
            //System.out.println(name);
            Country country = countries.get(name);
            if(country!=null && !jsonItem.isNull("temperature")) {
                country.setTemperature(Float.valueOf(jsonItem.get("temperature").toString()));
            }
            else {
                System.out.println("country not available for Temperature: " + name);
            }
        }
    }

 private static String readFile(String fileName) {
  StringBuilder stringBuilder= new StringBuilder();
  try {
    FileReader fr = new FileReader(fileName);
    int i;     
    while((i=fr.read())!=-1)    
    {
       stringBuilder.append((char)i);    
    }
    fr.close();   
   } catch(Exception e) {
      throw new RuntimeException(e);
   }
      return stringBuilder.toString(); 
  }
  
}
