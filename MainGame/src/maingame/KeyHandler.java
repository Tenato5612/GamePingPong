/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maingame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author belpg
 */
public class KeyHandler implements KeyListener{

    public Boolean upPressed = false, downPressed = false, leftPressed = false, rightPressed = false;
    public Boolean setUpPressed = false, setDownPressed = false, setLeftPressed = false, setRightPressed = false;
    public Boolean escPressed = false, enterPressed = false;
    public Boolean pvpPressed = false, botPressed = false;
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }        
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        
        if(code == KeyEvent.VK_UP){
            setUpPressed = true;
        }        
        if(code == KeyEvent.VK_DOWN){
            setDownPressed = true;
        }

        if(code == KeyEvent.VK_ENTER){
            enterPressed = true;
        }        
        if(code == KeyEvent.VK_ESCAPE){
            escPressed = true;
        }
        
        if(code == KeyEvent.VK_1){
            pvpPressed = true;
        }        
        if(code == KeyEvent.VK_2){
            botPressed = true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        
        if(code == KeyEvent.VK_UP){
            setUpPressed = false;
        }        
        if(code == KeyEvent.VK_DOWN){
            setDownPressed = false;
        }

        if(code == KeyEvent.VK_ENTER){
            enterPressed = false;
        }        
        if(code == KeyEvent.VK_ESCAPE){
            escPressed = false;
        }
        
        if(code == KeyEvent.VK_1){
            pvpPressed = false;
        }                
        if(code == KeyEvent.VK_2){
            botPressed = false;
        }
    }
}
