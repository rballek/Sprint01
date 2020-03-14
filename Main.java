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

    private static void GUITemplate() {
    /*
    * Initial Version for The Template's GUI for the Template
    *
    * Display Available templates to the user
    * */

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

        /*
        * Initial Gui for the Map. it Displays Moravian College properties to the user
        *
        * */

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
        /*
        * General function to display a map online
        *
        * TODO
        *Generalize the function to display  any of Moravian College properties with the GUI
        *
        * */
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI("https://www.google.com/maps/search/?api=1&query=moravian+college"));
        }
    }

    private  static ArrayList<String> read_addresses() throws IOException {

        /*Function to read the file with current or of interest Moravian College Properties*/

        File file = new File("CollegeProperties");
        ArrayList<String> buildings = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        //add each property to the Array
        while ((st = br.readLine()) != null) {
            buildings.add(st);
        }

        return buildings;

    }

    public static void saveMap(String NorthOrSouth){
        BufferedImage image;
        String CITY = "Behlehem";
        String STATE = "PA";
        String KEY ="NO_KEY";
        try{
            String address = "https://maps.googleapis.com/maps/api/staticmap?center="+NorthOrSouth+","+CITY+","+STATE+"&zoom=16&size=400x400&key="+KEY;
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
            else {
                System.out.println("Wrong input\nValid answer: North, South");
            }
        }

        if(userAnswer.equals("North")){
            userAnswer = "1200_Main_st";
        }
        else{
            userAnswer = "344_Main_Street";

        }
        return userAnswer;

    }


    public static void main(String[] args) throws IOException, URISyntaxException {
        Scanner myScanner = new Scanner(System.in);

        //String Location = get_user_input(myScanner);
        //saveMap(Location);
        //GUIMap();
        //GUITemplate();mapOnline();



    }
}
