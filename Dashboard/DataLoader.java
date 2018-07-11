import java.util.*;
import processing.data.*;
import processing.core.*;
//import java.io.FileReader;  
import java.io.*;

public class DataLoader {
  
  private static final String BASE_FOLDER= "/Users/ramin/IdeaProjects/Processing-Dashboard02/Dashboard/Data/json";
  private static final String COUNTRY_NAME_PATH = BASE_FOLDER + "/" +"country-by-name.json";
 
 public static Map<String, Country> loadCountryMap() throws Exception {
   Map<String, Country> countryMap = new HashMap<>();
   JSONArray jsonArray = JSONArray.parse(readFile(COUNTRY_NAME_PATH));
   System.out.println("countries:" + jsonArray);
   
   for(int i = 0; i < jsonArray.size(); i++){
    JSONObject jsonItem = jsonArray.getJSONObject(i);
    String name = (String) jsonItem.get("country");
    Country country = new Country();
    country.setName(name);
    countryMap.put(name, country);
    System.out.println(country);
  }
   return countryMap;
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
