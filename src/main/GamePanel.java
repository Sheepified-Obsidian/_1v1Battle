package main;
import platform.PlatformManager;
import object.SuperObject;
import entity.Player;

import object.OBJ_Healthbar;


import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    PlatformManager platformM = new PlatformManager(this);
    KeyHandlerWASD keyHWASD = new KeyHandlerWASD();
    KeyHandlerArrows keyHArrows = new KeyHandlerArrows();
    public AssetSetter aSetter = new AssetSetter(this);
    Player p1 = new Player(this, keyHWASD, 1);
    Player p2 = new Player(this, keyHArrows, 2);
    public SuperObject obj[] = new SuperObject[10];







    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyHArrows);
        this.addKeyListener(keyHWASD);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void setupGame(){
        aSetter.setObject();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            update();
            repaint();

            try {
                Thread.sleep(16);  //Millisekunden
            } catch(Exception e) {
                e.printStackTrace();
            } // end of try
        }
    }

    public void update() {
        p1.update();
        p2.update();
    }

    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        platformM.draw(g2);

        p1.draw(g2);
        p2.draw(g2);


//Objekte zeichnen
        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2,this);
            }
        }

        g2.dispose();





    }
}

