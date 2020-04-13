import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Map {
    final String address;

    public Map(String address){
        this.address = address;

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
}
