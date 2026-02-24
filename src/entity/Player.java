package entity;

import main.GamePanel;
import main.KeyHandlerArrows;
import main.KeyHandlerWASD;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class Player {
    BufferedImage rightlooking, leftlooking;
    String direction = "right";
    int playerX;
    int playerY;
    int playerSpeed;

    double velocityY = 0;
    double gravity = 0.2;
    double jumpStrength = -10;
    boolean onGround = true;

    public int maxLife;
    public int life;

    GamePanel gamepanel;
    Controls controls;
    private KeyHandlerArrows keyHArrows;
    private KeyHandlerWASD KeyHWASD;

    public Player(GamePanel gamepanel, Controls controls, int playerNumber) {
        this.gamepanel = gamepanel;
        this.controls = controls;
        setDefaultValues();
        getPlayerImage(playerNumber);
    }
    public void setDefaultValues(){
        playerX =  100;
        playerY = 100;
        playerSpeed = 4;
        maxLife = 2;
        life = 1;
    }
    public void getPlayerImage(int playerNumber){
        try {

            rightlooking = ImageIO.read(getClass().getResourceAsStream("/player/p" + playerNumber + "Right.png"));
            leftlooking = ImageIO.read(getClass().getResourceAsStream("/player/p" + playerNumber + "Left.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if (controls.up()){    playerY -= playerSpeed;}
        if (controls.down()){  playerY += playerSpeed;}
        if (controls.left()) {playerX -= playerSpeed;
            direction = "left";}
        if (controls.right()) {
            playerX += playerSpeed;
            direction = "right";}

        if (controls.up() && onGround) {
            velocityY = jumpStrength;
            onGround = false;
        }

        if (playerY >= gamepanel.screenHeight - gamepanel.tileSize) {
            playerY = gamepanel.screenHeight - gamepanel.tileSize;
            velocityY = 0;
            onGround = true;
        }

        if (!onGround) {
            velocityY += gravity;
            playerY += velocityY;
        }

        // LINKS begrenzen
        if (playerX < 0) {
            playerX = 0;
        }

        // RECHTS begrenzen
        if (playerX > gamepanel.screenWidth - gamepanel.tileSize) {
            playerX = gamepanel.screenWidth - gamepanel.tileSize;
        }

        // OBEN begrenzen
        if (playerY < 0) {
            playerY = 0;
        }

        // UNTEN begrenzen
        if (playerY > gamepanel.screenHeight - gamepanel.tileSize) {
            playerY = gamepanel.screenHeight - gamepanel.tileSize;
        }
    }
    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        if (direction.equals("right")) {
            image = rightlooking;
        } else if (direction.equals("left")) {
            image = leftlooking;
        }

        g2.drawImage(image, playerX, playerY,50,50, null);
    }
}
