import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;


//behavior for the JFrame to display if they choose to generate a map for the incident

public class DisplayAddress implements DisplayBehavior {

    //variable incident to be able to generate and set a
    // new windows behavior after the address is selected

    private static String incident;

    DisplayAddress(String incident){
        this.incident = incident;
    }

    /*
    Creates/display the behavior of window(how it looks/fields of user input)
    Contains all the user input which we will use to create the email to be sent out
     */

    public void display() throws IOException {
        JFrame frame = new JFrame("Campus Security");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(430, 100);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);
        ArrayList<String> Buildings2 = read_addresses();
        String[] Buildings = Buildings2.toArray(new String[0]);

        final JComboBox<String> cb = new JComboBox<String>(Buildings);

        cb.setMaximumSize(cb.getPreferredSize());
        cb.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cb);

        JLabel lbl2 = new JLabel("select the radius( in miles)");
        lbl2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lbl2);


        String[] templates = {"select", "1", "2", "5", "10"};
        final JComboBox<String> cb1 = new JComboBox<String>(templates);
        cb1.setMaximumSize(cb1.getPreferredSize());
        cb1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(cb1);

        JButton btn = new JButton("OK");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btn);

        frame.setVisible(true);

        btn.addActionListener(new ActionListener(){

            private String incident;

            /*
        adding action listener for button "ok"
        to generate and save the map based off the address selected
        Then it creates a new WindowTemplate depending on the incident
         */

            @Override
            public void actionPerformed(ActionEvent e) {
                String mapAddress = (String)cb.getSelectedItem();
                String radius = (String)cb.getSelectedItem();

                if(!mapAddress.equals("select") && !radius.equals("select")) {
                    //saveMap(mapAddress, radius);
                }
                try {
                    frame.dispose();
                    Window incident = new WindowTemplates(DisplayAddress.incident);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
    }


    //method that reads in all the schools properties
    //used for the dropdown for addresses to generate a map from
    private  static ArrayList<String> read_addresses() throws IOException {

        /*Function to read the file with current or of interest Moravian College Properties*/

        File file = new File("D:\\Java\\IdeaProjects\\Sprint01WorkingOn\\src\\CollegeProperties");
        ArrayList<String> buildings = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        //add each property to the Array
        while ((st = br.readLine()) != null) {
            buildings.add(st);
        }
        return buildings;
    }

    //saves the image if they choose to have a map generated
    private static void saveMap(String mapAddress, String radius){
        BufferedImage image;
        String CITY = "Behlehem";
        String STATE = "PA";
        String KEY ="noKey";
        String newStr = mapAddress.replaceAll(" ", "+");
        System.out.println(newStr);


        try{
            String address = "https://maps.googleapis.com/maps/api/staticmap?center="+newStr+","+CITY+","+STATE+"&zoom=16&size=400x400&key="+KEY;
            URL url =new URL(address);
            //            // read the url

            image = ImageIO.read(url);
            System.out.println(image);

            // for png
            ImageIO.write(image, "png",new File("/Users/giraldoj@moravian.edu/IdeaProjects/Sprint02/map.png"));

            // for jpg
            ImageIO.write(image, "jpg",new File("/Users/giraldoj@moravian.edu/IdeaProjects/Sprint02/map.jpg"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void mapOnline(String address) throws URISyntaxException, IOException {
        /*
         * General function to display a map online
         *
         * TODO
         *Generalize the function to display  any of Moravian College properties with the GUI
         *
         * */
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI("https://www.google.com/maps/search/?api=1&query="+address));
        }
    }
}
