package Elements;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ImageLoader {
    private HashMap<String, BufferedImage> images = new HashMap<>();
    private GraphicsConfiguration configuration;
    private static ImageLoader instance;

    private ImageLoader(){
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        configuration = environment.getDefaultScreenDevice().getDefaultConfiguration();
        String[] list = {"a", "b", "c", "j", "e", "t", "g", "h", "s", "bien", "mal","spritesheet"};
        for(String name : list){
            images.put(name, load("src/Images/"+name+".png"));
        }
    }

    public static ImageLoader getInstance() {
        if(instance == null)
            instance = new ImageLoader();
        return instance;
    }


    private BufferedImage load(String path){
        try{
            return ImageIO.read(new File(path));
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public BufferedImage getImage(String name) {
        return (BufferedImage) images.getOrDefault(name, null);
    }
}
