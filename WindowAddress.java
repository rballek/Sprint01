import java.io.IOException;

//Class for the window to be displayed if they do want a map generated
//Uses the display address behavior

public class WindowAddress extends Window {
    public String incident = " ";

    public WindowAddress(String incident) throws IOException {
        this.incident = incident;
        setDisplayBehavior(new DisplayAddress(incident));

    }

    public void display(){

    }
}
