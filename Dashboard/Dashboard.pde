

import controlP5.*;
import g4p_controls.*;
import java.util.*;

private LeftPanel leftPanel;
private RightPanel rightPanel;

color c = color(0, 160, 100);


void setup() {
  
    CountryService countryService = new CountryService();
    List<Country> result = countryService.load("name", false);
    //all countries in the result are loaded in reverse order based on "name". The result will start with zimbawe and should end with a country like albany.
    //for (Country country : result) {
       //System.out.println("country = " + country);
    //}
  
  leftPanel = new LeftPanel(this);
  rightPanel = new RightPanel(this);
  background(220);
  size(600, 600);
  noStroke();
  smooth();
  buildGui();
  
}

void buildGui() {
  G4P.setGlobalColorScheme(GCScheme.ORANGE_SCHEME);
  G4P.setCursor(ARROW);
  leftPanel.buildGui();
}
  
void draw() {
  leftPanel.draw();
  rightPanel.draw();
}


public float getLeftPanelHelloRadioButtonValue(String radioButtonName) {
  return leftPanel.getCp5().getController(radioButtonName).getValue();
}
