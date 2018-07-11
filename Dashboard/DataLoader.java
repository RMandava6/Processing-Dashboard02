import java.util.*;
import processing.data.*;
import processing.core.*;
//import java.io.FileReader;  
import java.io.*;

public class DataLoader {
  
  private static final String BASE_FOLDER= "/Users/ramin/IdeaProjects/Processing-Dashboard02/Dashboard/Data/json";
  private static final String COUNTRY_NAME_PATH = BASE_FOLDER + "/" +"country-by-name.json";
  private static final String COUNTRY_ABBREVIATION_PATH = BASE_FOLDER + "/" +"country-by-abbreviation.json";
  private static final String COUNTRY_AVERAGE_MALE_HEIGHT_PATH = BASE_FOLDER + "/" +"country-by-avg-male-height.json";
 
 public static Map<String, Country> loadCountryMap() throws Exception {
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

public static void loadAbbreviation(Map<String, Country> countries) throws Exception {
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
      System.out.println("could not find country: " + name);
  }}
 }

public static void loadAverageHeight(Map<String, Country> countries) throws Exception {
   JSONArray jsonArray = JSONArray.parse(readFile(COUNTRY_AVERAGE_MALE_HEIGHT_PATH));
   
   
   for(int i = 0; i < jsonArray.size(); i++){
    JSONObject jsonItem = jsonArray.getJSONObject(i);
    String name = (String) jsonItem.get("country");
    Country country = countries.get(name);
    System.out.println(country);
    if(country!=null) {
    country.setHeight((Double) jsonItem.get("height"));
    //System.out.println(country);
    }
    else {
      System.out.println("could not find country to set average height: " + name);
  }}
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
