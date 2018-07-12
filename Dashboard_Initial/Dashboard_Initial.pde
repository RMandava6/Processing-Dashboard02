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
int radio;
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
  geo = loadStrings( DataLoader.BASE_FOLDER + "/CountryLatLong.csv");
}

void gui() {
  
  cp5 = new ControlP5(this);
  
 // List l = Arrays.asList("US", "AD", "AE", "AF", "AG", "AL", "AU", "CA");
  
  // group number 1, contains scrollable list
  Group g1 = cp5.addGroup("myGroup1")
                .setBackgroundColor(color(0, 64))
                .setBackgroundHeight(228)
                ;
     
  cp5.addScrollableList("dropdown")
     .setPosition(10, 20)
     .setSize(100, 100)
     .setBarHeight(20)
     .setItemHeight(20)
     .addItems(l)
     .setType(ScrollableList.DROPDOWN)
     ;
     
  // group number 2, contains a radiobutton
  Group g2 = cp5.addGroup("myGroup2")
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
  Group g3 = cp5.addGroup("myGroup3")
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
  //if(dd=="US")
  //{
  //  println("it matched to US");
  //}
  
 //String array[] = cp5.get(ScrollableList.class, "dropdown").getItem(n);
  /* here an item is stored as a Map  with the following key-value pairs:
   * name, the given name of the item
   * text, the given text of the item by default the same as name
   * value, the given value of the item, can be changed by using .getItem(n).put("value", "abc"); a value here is of type Object therefore can be anything
   * color, the given color of the item, how to change, see below
   * view, a customizable view, is of type CDrawable 
   */
  
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
  
  //cp5.addCanvas(Canvas);
  //println(cp5.get(ScrollableList.class, "dropdown").getItem(dd));
  //noLoop();
  
  if(shuff==1){
    show(earthquakes);
  }//end of if shuff==1
  
  else if(dropd==1){
    show(geo);
  }//end of else if
  
  switch(radio) {
    //case(0):c=color(0,200);break;
    case(0):show(geo);
            break;
    case(1):c=color(255,0,0,200);break;
    case(2):c=color(0, 200, 140,200);break;
    case(3):c=color(0, 128, 255,200);break;
    case(4):c=color(50,128);break;
  }//end of switch case
  
   if(key =='c' || key =='C'){
     dropd=0;
     shuff=0;
    //filter(INVERT);
    //setup();
   }//end of if
   
}//end of draw

void show(String[] strar){
  float cx = mercX(clon);
  float cy = mercY(clat);
  //float mag;
  String[] strarray  = strar;
  String country;
  
  //c = color(random(255),random(255),random(255),random(128,255));
  for (int i = 1; i < strarray.length; i++) {
    String[] data = strarray[i].split(",");
    //console.log(data);
    float lat = float(data[1]);
    float lon = float(data[2]);
    float x = mercX(lon) - cx;
    float y = mercY(lat) - cy;
    // This addition fixes the case where the longitude is non-zero and
    // points can go off the screen.
    if(x < - width/2) {
      x += width;
    } else if(x > width / 2) {
      x -= width;
    }
    
    
    
    if(shuff==1)
    {
      float mag = float(data[4]);
      mag = pow(10, mag);
      mag = sqrt(mag);
      float magmax = sqrt(pow(10, 10));
      float d = map(mag, 0, magmax, 0, 180);
      stroke(255, 0, 255);
      fill(255, 0, 255, 200);
      //ellipse(x+510, y+260, d, d);
      ellipse(x+710, y+255, d, d);
    }//end of if shuff==1
    
    else if(dropd==1)
    {
      country = data[0].toString();
      if(country.equals(dd))
      {
        image(pin, x+706, y+255, 10,10); //<>//
        //println("dd is",dd);
      }
    }//end of else if dropd==1
    
    else if(radio<5)
    {
      ellipse( x+710, y+255, 3,3);
    }//end of else if radio<5
   }//end of for loop
   
}//end of show()


/*
a list of all methods available for the Accordion Controller
use ControlP5.printPublicMethodsFor(Accordion.class);
to print the following list into the console.

You can find further details about class Accordion in the javadoc.

Format:
ClassName : returnType methodName(parameter type)


controlP5.Accordion : Accordion addItem(ControlGroup) 
controlP5.Accordion : Accordion close() 
controlP5.Accordion : Accordion open() 
controlP5.Accordion : Accordion remove(ControllerInterface) 
controlP5.Accordion : Accordion removeItem(ControlGroup) 
controlP5.Accordion : Accordion setCollapseMode(int) 
controlP5.Accordion : Accordion setItemHeight(int) 
controlP5.Accordion : Accordion setMinItemHeight(int) 
controlP5.Accordion : Accordion setWidth(int) 
controlP5.Accordion : Accordion updateItems() 
controlP5.Accordion : int getItemHeight() 
controlP5.Accordion : int getMinItemHeight() 
controlP5.ControlGroup : Accordion activateEvent(boolean) 
controlP5.ControlGroup : Accordion addListener(ControlListener) 
controlP5.ControlGroup : Accordion removeListener(ControlListener) 
controlP5.ControlGroup : Accordion setBackgroundColor(int) 
controlP5.ControlGroup : Accordion setBackgroundHeight(int) 
controlP5.ControlGroup : Accordion setBarHeight(int) 
controlP5.ControlGroup : Accordion setSize(int, int) 
controlP5.ControlGroup : Accordion updateInternalEvents(PApplet) 
controlP5.ControlGroup : String getInfo() 
controlP5.ControlGroup : String toString() 
controlP5.ControlGroup : int getBackgroundHeight() 
controlP5.ControlGroup : int getBarHeight() 
controlP5.ControlGroup : int listenerSize() 
controlP5.ControllerGroup : Accordion add(ControllerInterface) 
controlP5.ControllerGroup : Accordion addListener(ControlListener) 
controlP5.ControllerGroup : Accordion bringToFront() 
controlP5.ControllerGroup : Accordion bringToFront(ControllerInterface) 
controlP5.ControllerGroup : Accordion close() 
controlP5.ControllerGroup : Accordion disableCollapse() 
controlP5.ControllerGroup : Accordion enableCollapse() 
controlP5.ControllerGroup : Accordion hide() 
controlP5.ControllerGroup : Accordion hideArrow() 
controlP5.ControllerGroup : Accordion hideBar() 
controlP5.ControllerGroup : Accordion moveTo(ControlWindow) 
controlP5.ControllerGroup : Accordion moveTo(PApplet) 
controlP5.ControllerGroup : Accordion open() 
controlP5.ControllerGroup : Accordion registerProperty(String) 
controlP5.ControllerGroup : Accordion registerProperty(String, String) 
controlP5.ControllerGroup : Accordion remove(CDrawable) 
controlP5.ControllerGroup : Accordion remove(ControllerInterface) 
controlP5.ControllerGroup : Accordion removeCanvas(Canvas) 
controlP5.ControllerGroup : Accordion removeListener(ControlListener) 
controlP5.ControllerGroup : Accordion removeProperty(String) 
controlP5.ControllerGroup : Accordion removeProperty(String, String) 
controlP5.ControllerGroup : Accordion setAddress(String) 
controlP5.ControllerGroup : Accordion setArrayValue(float[]) 
controlP5.ControllerGroup : Accordion setArrayValue(int, float) 
controlP5.ControllerGroup : Accordion setCaptionLabel(String) 
controlP5.ControllerGroup : Accordion setColor(CColor) 
controlP5.ControllerGroup : Accordion setColorActive(int) 
controlP5.ControllerGroup : Accordion setColorBackground(int) 
controlP5.ControllerGroup : Accordion setColorForeground(int) 
controlP5.ControllerGroup : Accordion setColorLabel(int) 
controlP5.ControllerGroup : Accordion setColorValue(int) 
controlP5.ControllerGroup : Accordion setHeight(int) 
controlP5.ControllerGroup : Accordion setId(int) 
controlP5.ControllerGroup : Accordion setLabel(String) 
controlP5.ControllerGroup : Accordion setMouseOver(boolean) 
controlP5.ControllerGroup : Accordion setMoveable(boolean) 
controlP5.ControllerGroup : Accordion setOpen(boolean) 
controlP5.ControllerGroup : Accordion setPosition(float, float) 
controlP5.ControllerGroup : Accordion setPosition(float[]) 
controlP5.ControllerGroup : Accordion setSize(int, int) 
controlP5.ControllerGroup : Accordion setStringValue(String) 
controlP5.ControllerGroup : Accordion setTitle(String) 
controlP5.ControllerGroup : Accordion setUpdate(boolean) 
controlP5.ControllerGroup : Accordion setValue(float) 
controlP5.ControllerGroup : Accordion setVisible(boolean) 
controlP5.ControllerGroup : Accordion setWidth(int) 
controlP5.ControllerGroup : Accordion show() 
controlP5.ControllerGroup : Accordion showArrow() 
controlP5.ControllerGroup : Accordion showBar() 
controlP5.ControllerGroup : Accordion update() 
controlP5.ControllerGroup : Accordion updateAbsolutePosition() 
controlP5.ControllerGroup : CColor getColor() 
controlP5.ControllerGroup : Canvas addCanvas(Canvas) 
controlP5.ControllerGroup : ControlWindow getWindow() 
controlP5.ControllerGroup : Controller getController(String) 
controlP5.ControllerGroup : ControllerProperty getProperty(String) 
controlP5.ControllerGroup : ControllerProperty getProperty(String, String) 
controlP5.ControllerGroup : Label getCaptionLabel() 
controlP5.ControllerGroup : Label getValueLabel() 
controlP5.ControllerGroup : String getAddress() 
controlP5.ControllerGroup : String getInfo() 
controlP5.ControllerGroup : String getName() 
controlP5.ControllerGroup : String getStringValue() 
controlP5.ControllerGroup : String toString() 
controlP5.ControllerGroup : Tab getTab() 
controlP5.ControllerGroup : boolean isBarVisible() 
controlP5.ControllerGroup : boolean isCollapse() 
controlP5.ControllerGroup : boolean isMouseOver() 
controlP5.ControllerGroup : boolean isMoveable() 
controlP5.ControllerGroup : boolean isOpen() 
controlP5.ControllerGroup : boolean isUpdate() 
controlP5.ControllerGroup : boolean isVisible() 
controlP5.ControllerGroup : boolean setMousePressed(boolean) 
controlP5.ControllerGroup : float getArrayValue(int) 
controlP5.ControllerGroup : float getValue() 
controlP5.ControllerGroup : float[] getArrayValue() 
controlP5.ControllerGroup : float[] getPosition() 
controlP5.ControllerGroup : int getHeight() 
controlP5.ControllerGroup : int getId() 
controlP5.ControllerGroup : int getWidth() 
controlP5.ControllerGroup : int listenerSize() 
controlP5.ControllerGroup : void controlEvent(ControlEvent) 
controlP5.ControllerGroup : void remove() 
java.lang.Object : String toString() 
java.lang.Object : boolean equals(Object) 

created: 2015/03/24 12:25:32

*/
