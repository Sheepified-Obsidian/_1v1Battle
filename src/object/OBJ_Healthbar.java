package object;

import main.GamePanel;
import main.ResourceLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import entity.Player;


public class OBJ_Healthbar extends SuperObject {

    GamePanel gp;
    BufferedImage image[] = new BufferedImage[8];
    Player owner;


    public OBJ_Healthbar(GamePanel gp, Player owner){
        this.gp = gp;
        this.owner = owner;
        name = "Healthbar";
        BufferedImage sheet;


        try{
       sheet = ImageIO.read(ResourceLoader.openResource(
               getClass(),
               "/hearts/Health Bar.png",
               "/sprites/hearts/Health Bar.png"
       ));
            for (int i = 0; i < 8; i++) {
                image[i] = sheet.getSubimage(i * frameSize, 0, frameSize, frameSize);
            }
        }
        catch (Exception e) {
            e.printStackTrace();

        }

    }

@Override
    public void draw(Graphics2D g2, GamePanel gp){
//        g2.drawImage(image1, worldX, worldY, gp.tileSize, gp.tileSize, null);

    int startIndex;
    if (owner.life == 2) {
        startIndex = 0;
    } else {
        startIndex = 4;
    }

        for (int i = 0; i < 4; i++) {

                int x = worldX + i * gp.tileSize;
                int y = worldY;
                g2.drawImage(image[startIndex + i], x, y, gp.tileSize, gp.tileSize, null);






        }

    }

}
