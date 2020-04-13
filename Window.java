import java.io.IOException;

public abstract class Window {
    DisplayBehavior displayBehavior;

    public Window(){

    }

    public void setDisplayBehavior(DisplayBehavior db) throws IOException {
        displayBehavior = db;
        performDisplay();
    }

    public DisplayBehavior getDisplayBehavior(){
        return this.displayBehavior;
    }

    public void performDisplay() throws IOException {
        displayBehavior.display();
    }


}
