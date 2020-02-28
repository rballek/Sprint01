import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static void GUI() {

        JFrame frame = new JFrame("Campus Security");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(430, 100);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        frame.add(panel);

        JLabel lbl = new JLabel("Select one of the templates and click OK");
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(lbl);

        String[] templates = {"Template 1", "Template 2", "Template 3", "Template 4",
                "Template 5", "Template 6"};

        final JComboBox<String> cb = new JComboBox<String>(templates);

        cb.setMaximumSize(cb.getPreferredSize());
        cb.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cb);

        JButton btn = new JButton("OK");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btn);

        frame.setVisible(true);

    }

    private static void GUIMap() throws IOException {

        JFrame frame = new JFrame("Campus Security");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(430, 100);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        frame.add(panel);

        JLabel lbl = new JLabel("Select one of the templates and click OK");
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(lbl);

        ArrayList<String> Buildings2 = read_addresses();
        String[] Buildings = Buildings2.toArray(new String[0]);

        final JComboBox<String> cb = new JComboBox<String>(Buildings);

        cb.setMaximumSize(cb.getPreferredSize());
        cb.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cb);

        JButton btn = new JButton("OK");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btn);

        frame.setVisible(true);

    }

    private static void mapOnline() throws URISyntaxException, IOException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI("https://www.google.com/maps/search/?api=1&query=moravian+college"));
        }
    }

    private  static ArrayList<String> read_addresses() throws IOException {
        // We need to provide file path as the parameter:
        // double backquote is to avoid compiler interpret words
        // like \test as \t (ie. as a escape sequence)
        File file = new File("/Users/giraldoj@moravian.edu/Downloads/Properties - Sheet1.csv");
        ArrayList<String> buildings = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            buildings.add(st);

        }

        return buildings;

    }

    public static void saveMap(String NorthOrSouth){
        BufferedImage image;
        String CITY = "Behlehem";
        String STATE = "PA";
        String KEY ="AIzaSyB5aUTNspLfNZSMyNQqdzEgrH1G4lJ9ICU";
        try{
            String address = "https://maps.googleapis.com/maps/api/staticmap?center="+NorthOrSouth+","+CITY+","+STATE+"&zoom=14&size=400x400&key="+KEY;
            URL url =new URL(address);
            //            // read the url

            image = ImageIO.read(url);
            System.out.println(image);

            // for png
            ImageIO.write(image, "png",new File("/Users/giraldoj@moravian.edu/IdeaProjects/Sprint01/map.png"));

            // for jpg
            ImageIO.write(image, "jpg",new File("/Users/giraldoj@moravian.edu/IdeaProjects/Sprint01/map.jpg"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static String get_user_input(Scanner myScanner){
        boolean NorthOrSouth = false;
        String userAnswer = "";

        System.out.println("Would you like to display North or South Campus?\nAnswer:   ");
        while(!NorthOrSouth) {
            userAnswer = myScanner.nextLine();  // Read user input
            if(userAnswer.equals("North") || userAnswer.equals("South")){
                NorthOrSouth = true;
            }
        }

        if(userAnswer.equals("North")){
            userAnswer = "1200 Main st";
        }
        else{
            userAnswer = "344 Main Street";

        }
        return userAnswer;

    }


    public static void main(String[] args) throws IOException, URISyntaxException {
        Scanner myScanner = new Scanner(System.in);

        //String Location = get_user_input(myScanner);
        //saveMap(Location);
        GUIMap();
        //GUI();
        //mapOnline();
        //


    }
}
