import controlP5.*;
import java.util.*;

ControlP5 cp5;

Accordion accordion;

color c = color(0, 160, 100);
List l = CountryService.getInstance().loadCountryNames("name", true);
PImage mapimg;
PImage pin;
String dd;
int shuff=0;
int dropd =0;
int radio=5;
int clat = 0;
int clon = 0;
float gx;
float gy;

int ww = 1024;
int hh = 512;

int zoom = 1;
String[] earthquakes;
String[] geo;

float mercX(float lon) {
  lon = radians(lon);
  float a = (256 / PI) * pow(2, zoom);
  float b = lon + PI;
  return a * b;
}

float mercY(float lat) {
  lat = radians(lat);
  float a = (256 / PI) * pow(2, zoom);
  float b = tan(PI / 4 + lat / 2);
  float c = PI - log(b);
  return a * c;
}

void setup() {
  background(220);
  //size(600, 600);
  size(1224, 712);
  noStroke();
  smooth();
  gui();
  
  
  //Accessing maps through mapboxAPI and loading it
  String url = "https://api.mapbox.com/styles/v1/mapbox/dark-v9/static/" +
    clon + "," + clat + "," + zoom + "/" +
    ww + "x" + hh +
    "?access_token=pk.eyJ1Ijoicm1hbmRhdmEiLCJhIjoiY2pqZ2x3dmZrNWE4cTNrcDE5cmg5d29qZiJ9.Nm_sF_3GjloxJxY2JuQN_w";
  mapimg = loadImage(url, "jpg");
  
  //Loading earthquakes csv from the below URL
  earthquakes = loadStrings("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.csv");
  
  pin = loadImage(DataLoader.BASE_FOLDER+ "/PinDrop.jpg");
  
  //Load latitude and longitude data
  //geo = loadStrings( DataLoader.BASE_FOLDER + "/CountryLatLong.csv");
}//end of setup

void gui() {
  
  cp5 = new ControlP5(this);
  
  // group number 1, contains scrollable list
  Group g1 = cp5.addGroup("Country List")
                .setBackgroundColor(color(0, 64))
                .setBackgroundHeight(228)
                ;
     
  cp5.addScrollableList("dropdown")
     .setPosition(10, 20)
     .setSize(150, 200)
     .setBarHeight(20)
     .setItemHeight(20)
     .addItems(l)
     .setType(ScrollableList.DROPDOWN)
     ;
     
  // group number 2, contains a radiobutton
  Group g2 = cp5.addGroup("International Stats")
                .setBackgroundColor(color(0, 64))
                .setBackgroundHeight(228)
                ;
  
  cp5.addRadioButton("radio")
     .setPosition(10,20)
     .setItemWidth(20)
     .setItemHeight(20)
     .addItem("LifeExpectancy", 0)
     .addItem("Population", 1)
     .addItem("Surface Area", 2)
     .addItem("Avg Male Height", 3)
     .addItem("grey", 4)
     .setColorLabel(color(255))
     .activate(4)
     .moveTo(g2)
     ;

  // group number 3, contains a bang and a slider
  Group g3 = cp5.addGroup("Earthquake Data")
                .setBackgroundColor(color(0, 64))
                .setBackgroundHeight(228)
                ;
  
  cp5.addBang("shuffle")
     .setPosition(10,20)
     .setSize(40,50)
     .moveTo(g3)
     ;
     
  cp5.addSlider("hello")
     .setPosition(60,20)
     .setSize(100,20)
     .setRange(100,500)
     .setValue(100)
     .moveTo(g3)
     ;
     
  cp5.addSlider("world")
     .setPosition(60,50)
     .setSize(100,20)
     .setRange(100,500)
     .setValue(200)
     .moveTo(g3)
     ;

  // create a new accordion
  // add g1, g2, and g3 to the accordion.
  accordion = cp5.addAccordion("acc")
                 .setPosition(0,0)
                 .setWidth(200)
                 .addItem(g1)
                 .addItem(g2)
                 .addItem(g3)
                 ;
                 
  cp5.mapKeyFor(new ControlKey() {public void keyEvent() {accordion.open(0,1,2);}}, 'o');
  cp5.mapKeyFor(new ControlKey() {public void keyEvent() {accordion.close(0,1,2);}}, 'c');
  cp5.mapKeyFor(new ControlKey() {public void keyEvent() {accordion.setWidth(300);}}, '1');
  cp5.mapKeyFor(new ControlKey() {public void keyEvent() {accordion.setPosition(0,0);accordion.setItemHeight(190);}}, '2'); 
  cp5.mapKeyFor(new ControlKey() {public void keyEvent() {accordion.setCollapseMode(ControlP5.ALL);}}, '3');
  cp5.mapKeyFor(new ControlKey() {public void keyEvent() {accordion.setCollapseMode(ControlP5.SINGLE);}}, '4');
  cp5.mapKeyFor(new ControlKey() {public void keyEvent() {cp5.remove("myGroup1");}}, '0');
  
  accordion.open(0,1,2);
  
  // use Accordion.MULTI to allow multiple group 
  // to be open at a time.
  accordion.setCollapseMode(Accordion.MULTI);
  
  // when in SINGLE mode, only 1 accordion  
  // group can be open at a time.  
  // accordion.setCollapseMode(Accordion.SINGLE);
}
  

void radio(int theC) {
  shuff=0;
  dropd=0;
  radio=theC;
  switch(theC) {
    //case(0):c=color(0,200);break;
    case(0):c=color(0,200);break;
    case(1):c=color(255,0,0,200);break;
    case(2):c=color(0, 200, 140,200);break;
    case(3):c=color(0, 128, 255,200);break;
    case(4):c=color(50,128);break;
  }
} 


void shuffle() {
  shuff =1;
  dropd=0;
  radio=5;
}

void dropdown(int n) {
  shuff=0;
  radio=5;
  dd= l.get(n).toString();
  dropd=1;
  /* request the selected item based on index n */
  println(n, cp5.get(ScrollableList.class, "dropdown").getItem(n));
  println(dd);
  
  CColor c = new CColor();
  c.setBackground(color(255,0,0));
  cp5.get(ScrollableList.class, "dropdown").getItem(n).put("color", c);
  
}

void draw() {
  //background(220);
  surface.setTitle(mouseX + ", " + mouseY);
  pushMatrix();
  translate(200,0);
  image(mapimg,0,0);
  popMatrix();
  
  fill(c);
  
  float s1 = cp5.getController("hello").getValue();
  //ellipse(350,400,s1,s1);
  
  float s2 = cp5.getController("world").getValue();
  //ellipse(400,100,s2,s2);
  
  
  if(shuff==1){
    show(earthquakes);
  }//end of if shuff==1
  
  else if(dropd==1 || radio<5){
    show();
  }//end of else if
   
}//end of draw

void show(){
  List<Country> countries = CountryService.getInstance().load("name", true);
  String country;
  
  for (Country aCountry: countries) {
    System.out.println(aCountry.getName());
    
    Float x = aCountry.getX();
    Float y = aCountry.getY();    
    // This addition fixes the case where the longitude is non-zero and
    // points can go off the screen.
    if(x!=null && y !=null) {
      if(x < - width/2) {
        x += width;
      } else if(x > width / 2) {
        x -= width;
      }
    
    if(dropd==1)
    {
      country = aCountry.getName();
      if(country.equals(dd))
      {
        image(pin, x+706, y+255, 10,10); //<>//
      }
    }//end of else if dropd==1
    else if(radio<5)
    {
      switch(radio){
        case(0):c=color(0, 160, 100, 200);
                Float expectancy = (aCountry.getExpectancy()!=null?aCountry.getExpectancy().floatValue():0)/6;
                fill(c, 200);
                ellipse( x+710, y+255, expectancy, expectancy);
                break;
        case(1):c=color(255,0,0,200);
                Float population = (aCountry.getPopulation()!=null?aCountry.getPopulation().floatValue():0)/6000000;
                fill(c, 200);
                ellipse( x+710, y+255, population, population);
                break;
        case(2):c=color(0, 200, 140,200);
                Float area = (aCountry.getArea()!=null?aCountry.getArea().floatValue():0)/60000;
                fill(c, 200);
                ellipse( x+710, y+255, area, area);
                break;
        case(3):c=color(0, 128, 255,200);
                Float height1 = (aCountry.getHeight()!=null?aCountry.getHeight().floatValue():0)/2;
                fill(c, 200);
                ellipse( x+710, y+255, height1, height1);
                break;
        case(4):c=color(50,128);break;
      }//end of switch case
    }//end of else if radio<5
   }//end of if x or y null 
  }//end of for loop //<>// //<>//
}//end of show()

void show(String[] strar){
  float cx = mercX(clon);
  float cy = mercY(clat);
  String[] strarray  = strar;
  
  for (int i = 1; i < strarray.length; i++) {
    String[] data = strarray[i].split(",");
    //console.log(data);
    float lat = float(data[1]);
    float lon = float(data[2]);
    float mag = float(data[4]);
    float x = mercX(lon) - cx;
    float y = mercY(lat) - cy;
    
    // This addition fixes the case where the longitude is non-zero and
    // points can go off the screen.
    if(x < - width/2) {
      x += width;
    } else if(x > width / 2) {
      x -= width;
    }
    
      mag = pow(10, mag);
      mag = sqrt(mag);
      float magmax = sqrt(pow(10, 10));
      float d = map(mag, 0, magmax, 0, 180);
      stroke(255, 0, 255);
      fill(255, 0, 255, 200);
      //ellipse(x+510, y+260, d, d);
      ellipse(x+710, y+255, d, d);
  }//end of for loop    
}//end of show
