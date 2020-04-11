import javax.swing.*;

public abstract class Window {
    DisplayBehavior displayBehavior;

    public Window(){

    }

    public void setDisplayBehavior(DisplayBehavior db){
        displayBehavior = db;
        performDisplay();
    }

    public void performDisplay(){
        displayBehavior.display();
    }


}
