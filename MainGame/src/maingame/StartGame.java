/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maingame;

import entity.Entity;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author belpg
 */
public class StartGame extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    
    int multPositionX = x + 270;
    int choosePositionY = y + 380;
    int singPositionX = x + 535;
    String wel = "Ping Pong";
    String multiplayer = "Multiplayer";    
    Font choose = new Font("Arial", Font.PLAIN, 25);

    public StartGame(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        
        setDefaultValues();                
    }
    
    public void setDefaultValues(){
        x = 400;
        y = 100;              
    }
    
    public void Choose(Graphics2D g2){                
        g2.setFont(choose);
        g2.setColor(Color.WHITE);
        g2.drawString(multiplayer, multPositionX, choosePositionY);
        
        g2.setFont(choose);
        g2.setColor(Color.WHITE);
        g2.drawString("Single", singPositionX, y + 280);
    }    
    
    public void ClickEvent(){
        if(keyH.enterPressed == true && oneClick == 0){
            gp.stateGame++;
            oneClick = 1;
            gp.resetGame = 0;
        }
        
        if(keyH.escPressed == true){
            gp.stateGame = 0;
            oneClick = 0;
            gp.resetGame = 1;
        }
        
        if(keyH.pvpPressed == true && oneClick == 1){
            gp.stateMode = 1;
            gp.stateGame++;
            oneClick = 2;
        }
        
        if(keyH.botPressed == true && oneClick == 1){
            gp.stateMode = 2;
            gp.stateGame++;
            oneClick = 2;
        }
    }
    
    public void draw(Graphics2D g2){
        if(gp.stateGame == 0){
            Font startFont = new Font("Arial", Font.PLAIN, 25);
            g2.setFont(startFont);
            g2.setColor(Color.WHITE);
            g2.drawString("PRESS ENTER TO PLAY", x - 100, y + 200);

            Font titleFont = new Font("Arial", Font.PLAIN, 50);
            g2.setFont(titleFont);
            g2.setColor(Color.WHITE);
            g2.drawString(wel, x - 80, y + 150);
        }                
        
        if(gp.stateGame == 1){
            Font playerFont = new Font("Arial", Font.PLAIN, 50);
            g2.setFont(playerFont);
            g2.setColor(Color.WHITE);
            g2.drawString("Choose mode", x - 115, y + 190);
            
            Font descF = new Font("Arial", Font.PLAIN, 20);
            g2.setFont(descF);
            g2.setColor(Color.WHITE);
            g2.drawString("press 1 to multiplayer, or 2 to singleplayer", x - 140, y + 220);
            
            Choose(g2);
        }                     
    }   
}
