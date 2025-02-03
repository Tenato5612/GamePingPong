/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import maingame.GamePanel;
import maingame.KeyHandler;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JLabel;
/**
 *
 * @author belpg
 */
public class Player1 extends Entity{
    GamePanel gp;
    KeyHandler keyH;   
    JLabel point1 = new JLabel("sim");
    
    public Player1(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;        
        
        solidArea = new Rectangle(0, 0, gp.pDimensionWidth, gp.pDimensionHeight);
        
        setDefaultValues();
    }        
    
    public void setDefaultValues(){
        x = 140;
        y = 192;   
        
        solidArea.x = x;
        solidArea.y = y;
    }        
    
    public void update(){
        if(keyH.upPressed == true){
            y -= speed;
        } else if(keyH.downPressed == true){
            y += speed;
        }
        solidArea.x = x;
        solidArea.y = y;
    }
    
    public void draw(Graphics2D g2){                
        g2.setColor(Color.white);
        g2.fillRect(x, y, gp.pDimensionWidth, gp.pDimensionHeight);                        
        
    }
}
