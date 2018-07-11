import controlP5.*;
import g4p_controls.*;

private LeftPanel leftPanel;
//private RightPanel rightPanel;

color c = color(0, 160, 100);

PImage mapimg;
int clat = 0;
int clon = 0;

int ww = 1024;
int hh = 512;

int zoom = 1;
String[] earthquakes;

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
  leftPanel = new LeftPanel(this);
  //rightPanel = new RightPanel(this);
  background(220);
  size(1224, 712);
  noStroke();
  smooth();
  buildGui();
  
  String url = "https://api.mapbox.com/styles/v1/mapbox/dark-v9/static/" +
    clon + "," + clat + "," + zoom + "/" +
    ww + "x" + hh +
    "?access_token=pk.eyJ1Ijoicm1hbmRhdmEiLCJhIjoiY2pqZ2x3dmZrNWE4cTNrcDE5cmg5d29qZiJ9.Nm_sF_3GjloxJxY2JuQN_w";
  mapimg = loadImage(url, "jpg");
  //println(url);
  earthquakes = loadStrings("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.csv");
  
  pushMatrix();
  translate(200,0);
  //translate(width / 2, height / 2);
  //imageMode(CENTER);
  image(mapimg,0,0);
  popMatrix();
  
  float cx = mercX(clon);
  float cy = mercY(clat);
  
  for (int i = 1; i < earthquakes.length; i++) {
    String[] data = earthquakes[i].split(",");
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
}

void buildGui() {
  G4P.setGlobalColorScheme(GCScheme.ORANGE_SCHEME);
  G4P.setCursor(ARROW);
  leftPanel.buildGui();
}
  
void draw() {
  surface.setTitle(mouseX + ", " + mouseY);
  leftPanel.draw();
  //rightPanel.draw();
  
}


public float getLeftPanelHelloRadioButtonValue(String radioButtonName) {
  return leftPanel.getCp5().getController(radioButtonName).getValue();
}
