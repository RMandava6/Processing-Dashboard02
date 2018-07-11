
public abstract class Panel {
  
  protected Dashboard parent;
  
  public Panel(Dashboard parent) {
    this.parent =parent;
  }
  
  
/**
This method is used by both left and right panel so it might belong to their base class.
It has become protected so that both subclasses can have access to that.
*/
protected void radio(int theC) {
  switch(theC) {
    case(0):parent.c=parent.color(0,200);break;
    case(1):parent.c=parent.color(255,0,0,200);break;
    case(2):parent.c=parent.color(0, 200, 140,200);break;
    case(3):parent.c=parent.color(0, 128, 255,200);break;
    case(4):parent.c=parent.color(50,128);break;
  }
} 
  
  public abstract void notifyChangeInTheOtherPanel();
}
