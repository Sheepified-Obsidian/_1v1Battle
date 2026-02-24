package object;

import main.Game;
import main.GamePanel;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
public class SuperObject {
    public BufferedImage image1, image2, image3, image4, image5, image6, image7, image8;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public static final int frameSize = 16;



    public void draw(Graphics2D g2, GamePanel gp){
         g2.drawImage(image1, worldX, worldY, frameSize, frameSize, null);
    }


}
