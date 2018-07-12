import java.util.*;
import processing.data.*;
import processing.core.*;
//import java.io.FileReader;  
import java.io.*;

public class DataLoader {
  
 
  public static final String BASE_FOLDER= "/Users/raminfarhanian/projects/Visualization/midterm/Processing-Dashboard02/Dashboard_Initial/Data";
  //private static final String BASE_FOLDER= "/Users/ramya/Documents/GitHub/Processing-Dashboard02/Dashboard/Data";
  private static final String JSON_FOLDER = BASE_FOLDER + "/json/";
  private static final String COUNTRY_NAME_PATH = JSON_FOLDER + "country-by-name.json";
  private static final String COUNTRY_ABBREVIATION_PATH = JSON_FOLDER + "country-by-abbreviation.json";
  private static final String COUNTRY_AVERAGE_MALE_HEIGHT_PATH = JSON_FOLDER + "country-by-avg-male-height.json";
  private static final String COUNTRY_BARCODE_PATH = JSON_FOLDER + "country-by-barcode-prefix.json";
  private static final String COUNTRY_CALLING_CODE_PATH = JSON_FOLDER + "country-by-calling-code.json";
  private static final String COUNTRY_CAPITAL_CITY_PATH = JSON_FOLDER + "country-by-capital-city.json";
  private static final String COUNTRY_LIFE_EXPECTANCY_PATH = JSON_FOLDER + "country-by-life-expectancy.json";
 
 public static Map<String, Country> init() {
 
   try {
   Map<String, Country> map = DataLoader.loadCountryMap();
    loadAbbreviation(map);
    loadAverageHeight(map);
    loadBarcode(map);
    loadCallingCode(map);
    loadCapitalCity(map);
    loadLifeExpectancy(map); 
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