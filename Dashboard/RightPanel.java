
import controlP5.*;
import g4p_controls.*;

public class RightPanel extends Panel {
 
  private GImageToggleButton btnToggle2; 
  //private GImageToggleButton btnToggle0, btnToggle1, btnToggle3; 
  
  public RightPanel(Dashboard parent) {
    super(parent);
    btnToggle2 = new GImageToggleButton(parent, 350, 250, "s2.png", "s3.png", 4, 4);
    btnToggle2.tag = "User 16 state button with over image ";
  }
  
  // Event handler for image toggle buttons
public void handleToggleButtonEvents(GImageToggleButton button, GEvent event) { 
  //println(button + "   State: " + button.getState());
  int state = button.getState();
  float rand = parent.random(0,4);
  radio((int)(rand));
  switch(state) {
    //case(0):c=color(0,200);break;
    case(1):parent.background(255);break;
    case(2):parent.background(0, 200, 140,200);break;
    case(3):parent.background(0, 128, 255,200);break;
    case(4):parent.background(50,128);break;
    case(5):parent.background(0,200);break;
    case(6):parent.background(255,0,0,200);break;
    case(7):parent.background(0, 200, 140,200);break;
    case(8):parent.background(0, 128, 255,200);break;
    case(9):parent.background(50,128);break;
    case(10):parent.background(0,200);break;
    case(11):parent.background(255,0,0,200);break;
    case(12):parent.background(0, 200, 140,200);break;
    case(13):parent.background(0, 128, 255,200);break;
    case(14):parent.background(50,128);break;
    case(15):parent.background(50,128);break;
    case(16):parent.background(50,128);break;
  }
}

void draw() {
   parent.fill(parent.color(0, 160, 100)); 
  
  float s1 = parent.getLeftPanelHelloRadioButtonValue("hello");
  
  parent.ellipse(350,400,s1,s1);
  
  float s2 = parent.getLeftPanelHelloRadioButtonValue("world");
  parent.ellipse(400,100,s2,s2);
}
  
  public void notifyChangeInTheOtherPanel() {
    
  }
}
