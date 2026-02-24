package platform;

import main.GamePanel;
import main.ResourceLoader;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlatformManager {
    Platform[] platform;
    GamePanel gp;

    int mapPlatformNum[] [];
    public PlatformManager(GamePanel gp) {

        this.gp = gp;

        platform = new Platform[10];
        mapPlatformNum = new int[gp.maxScreenCol] [gp.maxScreenRow];

        getPlatformImage();
        loadMap();
    }

    public void getPlatformImage() {

        try {
            platform[0] = new Platform();
            platform[0].image = ImageIO.read(ResourceLoader.openResource(
                    getClass(),
                    "/block/block_improv.png",
                    "/sprites/block/block_improv.png"
            ));

//            platform[1] = new Platform();
//            platform[1].image = ImageIO.read(getClass().getResourceAsStream("/hearts/Health Bar.png"));

            platform[1] = new Platform();
            platform[1].image = ImageIO.read(ResourceLoader.openResource(
                    getClass(),
                    "/block/waer.png",
                    "/sprites/block/waer.png"
            ));



            //platform[0] = new platform.Platform();
            //platform[0].image = ImageIO.read(getClass().getResourceAsStream("/block/block_improv.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {
        try {
            InputStream is = ResourceLoader.openResource(getClass(), "/maps/map1.txt", "/res/maps/map1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxScreenCol && row < gp.maxScreenRow) {

                String line = br.readLine();
                
                while(col < gp.maxScreenCol) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapPlatformNum[col] [row] = num;
                    col++;

                }
                if(col == gp.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();


        }catch(Exception e) {

        }
    }
    public void draw(Graphics2D g2) {

            g2.drawImage(platform[0].image, 0, 0, gp.tileSize, gp.tileSize, null);

            int col = 0;
            int row = 0;
            int x = 0;
            int y = 0;

            while(col < gp.maxScreenCol && row < gp.maxScreenRow) {

                int platformNum = mapPlatformNum[col] [row];

                g2.drawImage(platform[platformNum].image, x, y, gp.tileSize, gp.tileSize, null);
                col++;
                x += gp.tileSize;

                if(col == gp.maxScreenCol) {
                    col = 0;
                    x = 0;
                    row++;
                    y += gp.tileSize;
                }
            }
        }
    }

