package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import entity.Controls;

public class KeyHandlerWASD implements KeyListener, Controls {

    public boolean upPressed, downPressed, leftPressed, rightPressed;


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }

    @Override
    public boolean up(){
        return upPressed;
    }

    @Override
    public boolean down(){
        return downPressed;
    }

    @Override
    public boolean left(){
        return leftPressed;
    }

    @Override
    public boolean right (){
        return rightPressed;
    }

}
