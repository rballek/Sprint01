import java.io.IOException;

//class to set the behavior to DisplayFirst
//this is the starting page of the program
//Uses the behavior DisplayFirst and it is the only class
// to ever use it so the behavior is set right in the constructor

public class WindowFirst extends Window {

    public WindowFirst() throws IOException {
        setDisplayBehavior(new DisplayFirst());
    }

    public void display(){

    }
}
