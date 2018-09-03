package Elements;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite extends Element {
    private BufferedImage image;
    private boolean hidden = false;
    private BufferedImage sheet;



    public BufferedImage crop(int x, int y, int w, int h)
    {
        return sheet.getSubimage(x,y,w,h);
    }

    public void setImage(String imgName)
    {
        sheet = ImageLoader.getInstance().getImage("spritesheet");
        switch(imgName) {
            case "a":
                image = crop(0,0,200,200);
                w = image.getWidth();
                h = image.getHeight();
                boundingBox = new Rectangle(x, y, w, h);
                break;
            case "b":
                image = crop(200,0,200,200);
                w = image.getWidth();
                h = image.getHeight();
                boundingBox = new Rectangle(x, y, w, h);
                break;
            case "c":
                image = crop(400,0,200,200);
                w = image.getWidth();
                h = image.getHeight();
                boundingBox = new Rectangle(x, y, w, h);
                break;
            case "e":
                image = crop(600,0,200,200);
                w = image.getWidth();
                h = image.getHeight();
                boundingBox = new Rectangle(x, y, w, h);
                break;
            case "g":
                image = crop(0,200,200,200);
                w = image.getWidth();
                h = image.getHeight();
                boundingBox = new Rectangle(x, y, w, h);
                break;
            case "h":
                image = crop(200,200,200,200);
                w = image.getWidth();
                h = image.getHeight();
                boundingBox = new Rectangle(x, y, w, h);
                break;
            case "j":
                image = crop(400,200,200,200);
                w = image.getWidth();
                h = image.getHeight();
                boundingBox = new Rectangle(x, y, w, h);
                break;
            case "s":
                image = crop(600,200,200,200);
                w = image.getWidth();
                h = image.getHeight();
                boundingBox = new Rectangle(x, y, w, h);
                break;
            case "t":
                image = crop(0,400,200,200);
                w = image.getWidth();
                h = image.getHeight();
                boundingBox = new Rectangle(x, y, w, h);
                break;
            case "bien":
                image = crop(200,400,200,200);
                w = image.getWidth();
                h = image.getHeight();
                boundingBox = new Rectangle(x, y, w, h);
                break;
            case "mal":
                image = crop(400,400,200,200);
                w = image.getWidth();
                h = image.getHeight();
                boundingBox = new Rectangle(x, y, w, h);
                break;
            //image = ImageLoader.getInstance().getImage(imgName);
            //w = image.getWidth();
            //h = image.getHeight();
            //boundingBox = new Rectangle(x, y, w, h);
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        if(!hidden)
            g.drawImage(image, x, y, null);
    }

    public void hide(){
        hidden = true;
    }

    public void show(){
        hidden = false;
    }
}
