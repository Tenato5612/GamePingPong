/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import maingame.GamePanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;


/**
 *
 * @author belpg
 */
public final class Ball extends Entity{
    GamePanel gp;    
    Player1 p1;    
    Player2 p2;
    Bot bot;
    Random random = new Random(-5);       
    int stop = 0;
    public Ball(GamePanel gp, Player1 p1, Player2 p2, Bot bot){
        this.gp = gp;        
        this.p1 = p1;
        this.p2 = p2;
        this.bot = bot;
        
        Rectangle solidArea = new Rectangle(0, 0, gp.bDimensionWidth, gp.bDimensionHeight);
        
        setDefaultValues();        
    }        
    
    public void setDefaultValues(){
        y = 262;
        x = 400;        
        indRng = 0;        
        nrgBall = random.nextInt(11) - 5;        
        speedY = 5;
        speedX = 3;
        /*
        y = 5
        x = 3
        */
        

        
        solidArea.x = x;
        solidArea.y = y;
    }        
    
    public void resetPos(){
        x = 400;
        y = 262;
        speedX = 3;
        pt1 = 0;
        pt2 = 0;
        indRng = 0;        
        nrgBall = random.nextInt(11) - 5;   
        countSpeed = 0;
        defaultX = x;
        defaultY = y;
    }
    
    public void moveBall(){ 
        if(indRng == 1){
            nrgBall = random.nextBoolean() ? 3 : -3;  
            speedX = nrgBall;            
            indRng = 0;
        }
        
        x += speedX;
        y += speedY;
        
        if(y <= 0 || y >= gp.screenHeight - gp.bDimensionHeight){
            speedY = -speedY;
        }
        if(x <= 0){
            x = 400;      
            y = 262;
            speedX = 3;            
            pt2++;
            indRng = 1;
            countSpeed = 0;
        }
        
        if(x >= gp.screenWidth - gp.bDimensionWidth){
            x = 400;  
            y = 262;
            speedX = 3;
            pt1++;
            indRng = 1;
            countSpeed = 0;
        }
    }
    
    public void moveGetY(){
        y += speedY;
        if(y <= 0 || y >= gp.screenHeight - gp.bDimensionHeight){
            speedY = -speedY;
        }        
    }

    public int moveY(){
        int centerY = 262;        
        if(moveY < centerY && stop == 0){
            moveY--;
        }
        
        if(moveY <= -52){            
            stop = 1;
        }
        
        if(moveY < centerY && stop == 1){
            moveY++;           
        }
        
        if(moveY > 58){
            stop = 2;
        }
        
        if(stop == 2){
            moveY--;            
        }
        
        return moveY;
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
            speedY = random.nextInt(5, 10);
            System.out.println("speedy: " + speedY);
            countSpeed++;
            if(countSpeed == 5){
                countSpeed = 0;
                speedX++;
            }
        }                
        
        if(gp.stateMode == 1){
            if(solidArea.x < p2.solidArea.x + p2.solidArea.width &&
               solidArea.x + p2.solidArea.width + 25 > p2.solidArea.x && 
               solidArea.y < p2.solidArea.y + p2.solidArea.height &&
               solidArea.y + (p2.solidArea.height - 150) > p2.solidArea.y){
                speedX = -speedX;
                            speedY = random.nextInt(5, 10);
            System.out.println("speedy: " + speedY);
                countSpeed++;
                if(countSpeed == 5){
                     countSpeed = 0;
                     if(speedX < 0){
                         speedX--;
                    } else{
                         speedX++;
                    }
                }
            }   
        }               
        
        if(gp.stateMode == 2){
            if(solidArea.x < bot.solidArea.x + bot.solidArea.width &&
               solidArea.x + bot.solidArea.width + 25 > bot.solidArea.x && 
               solidArea.y < bot.solidArea.y + bot.solidArea.height &&
               solidArea.y + (bot.solidArea.height - 150) > bot.solidArea.y){
                speedX = -speedX;
                countSpeed++;
                if(countSpeed == 5){
                    countSpeed = 0;
                    if(speedX < 0){
                        speedX--;
                    } else{
                        speedX++;
                    }
                
                }
            } 
        }
        

  
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.fillOval(x, y, gp.bDimensionWidth, gp.bDimensionHeight);
        System.out.println("speedX:" + speedX);
    }
    
}
