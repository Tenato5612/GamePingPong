/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import maingame.GamePanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
/**
 *
 * @author belpg
 */
public final class Ball extends Entity{
    GamePanel gp;    
    Player1 p1;    
    Player2 p2;
    public Ball(GamePanel gp, Player1 p1, Player2 p2){
        this.gp = gp;        
        this.p1 = p1;
        this.p2 = p2;
        
        Rectangle solidArea = new Rectangle(0, 0, gp.bDimensionWidth, gp.bDimensionHeight);
        
        setDefaultValues();        
    }        
    
    public void setDefaultValues(){
        y = 262;
        x = 400;
        speedY = 5;
        speedX = 3;
        solidArea.x = x;
        solidArea.y = y;
    }        
    
    public void moveBall(){        
        x += speedX;
        y += speedY;
        
        if(y <= 0 || y >= gp.screenHeight - gp.bDimensionHeight){
            speedY = -speedY;
        }
        if(x <= 0){
            x = 355;        
            speedX = 3;
            pt2++;
        }
        
        if(x >= gp.screenWidth - gp.bDimensionWidth){
            x = 355;        
            speedX = 3;
            pt1++;
        }
    }
    
    public void colisionCheck(){
        solidArea.x = x;
        solidArea.y = y;
        
        p1.solidArea.x = p1.x;
        p1.solidArea.y = p1.y;
                
        if(solidArea.x < p1.solidArea.x + p1.solidArea.width &&
           solidArea.x + p1.solidArea.width > p1.solidArea.x && 
           solidArea.y < p1.solidArea.y + p1.solidArea.height &&
           solidArea.y + (p1.solidArea.height - 150) > p1.solidArea.y){              
            speedX = -speedX;            
            countSpeed++;
            if(countSpeed == 10){
                countSpeed = 0;
                speedX++;
            }
        }
        
        if(solidArea.x < p2.solidArea.x + p2.solidArea.width &&
           solidArea.x + p2.solidArea.width + 25 > p2.solidArea.x && 
           solidArea.y < p2.solidArea.y + p2.solidArea.height &&
           solidArea.y + (p2.solidArea.height - 150) > p2.solidArea.y){
            speedX = -speedX;
            countSpeed++;
            if(countSpeed == 10){
                countSpeed = 0;
                speedX++;
            }
        }        
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.fillOval(x, y, gp.bDimensionWidth, gp.bDimensionHeight);     
        
        System.out.println("Speed: " + speedX);        
    }
    
}
