import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImageDownloader
{
    public static void main(String[] args )
    {
        BufferedImage image;
        try{

            URL url =new URL("https://maps.googleapis.com/maps/api/staticmap?center=Berkeley,CA&zoom=14&size=400x400&key=AIzaSyAgnqzaV0d_5sO7BQYWsGkY5RzPd5jwbKU");
                    // read the url

            image = ImageIO.read(url);
            System.out.println(image);

            // for png
            ImageIO.write(image, "png",new File("/Users/giraldoj@moravian.edu/IdeaProjects/Sprint01/map.png"));

            // for jpg
            ImageIO.write(image, "jpg",new File("/Users/giraldoj@moravian.edu/IdeaProjects/Sprint01/map.jpg"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }}