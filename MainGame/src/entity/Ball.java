/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import maingame.GamePanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
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
    public Ball(GamePanel gp, Player1 p1, Player2 p2, Bot bot){
        this.gp = gp;        
        this.p1 = p1;
        this.p2 = p2;
        this.bot = bot;
        
        Rectangle2D solidArea = new Rectangle2D.Double(0, 0, gp.bDimensionWidth, gp.bDimensionHeight);               

        setDefaultValues();        
    }        
    
    public void setDefaultValues(){
        y = 262;
        x = 400;
        indRngY = 0;        
        indRngX = 0;        
        nrgBall = random.nextInt(11) - 5;        
        speedY = 5;
        speedX = 3;
    }        
    
    public void resetPos(){
        x = 400;
        y = 262;
        speedX = 3;
        pt1 = 0;
        pt2 = 0;
        indRngX = 0;    
        indRngY = 0;
        nrgBall = random.nextInt(11) - 5;   
        countSpeed = 0;
        defaultX = x;
        defaultY = y;
    }
    
    public void moveBall(){ 
        if(indRngX == 1){
            nrgBall = random.nextBoolean() ? 3 : -3;  
            speedX = nrgBall;            
            indRngX = 0;
        }
        x += speedX;
        y += speedY;
        
        if(y <= 0 || y >= gp.screenHeight - gp.bDimensionHeight){
            speedY = -speedY;
        }
        if(x <= 0){
            x = 400;        
            speedX = 3;
            pt2++;            
            indRngX = 1;            
            countSpeed = 0;
        }
        
        if(x >= gp.screenWidth - gp.bDimensionWidth){
            x = 400;        
            speedX = 3;
            pt1++;           
            indRngX = 1;            
            countSpeed = 0;
        }
    }
    
    public void randomSpeedY(){
        if(indRngY == 1){
            nrgBall = random.nextBoolean() ? 1 : -1;  
            if(nrgBall > 0){
                speedY = +speedY;
            } else if(nrgBall < 0){
                speedY = -speedY;
            }
            indRngY = 0;
        }                
    }
    
    public void setBot(Bot bot) {
        this.bot = bot;
    }
    
    public void setColision(){
        solidArea.setFrame(x, y, gp.bDimensionWidth, gp.bDimensionHeight);
    }
    
    public void colisionCheck(){
        setColision();
        p1.setColision();
        p2.setColision();
        bot.setColision();

        
        if(solidArea.intersects(p1.solidArea)){
            speedX = -speedX;
            indRngY = 1;
            randomSpeedY();
            countSpeed++;
            if(countSpeed == 5){
                countSpeed = 0;
                speedX++;
            }
        }
        
        
        if(gp.stateMode == 1){
            if(solidArea.intersects(p2.solidArea)){
                speedX = -speedX;
                indRngY = 1;
                randomSpeedY();
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
            if(solidArea.intersects(bot.solidArea)){
                speedX = -speedX;
                indRngY = 1;
                randomSpeedY();                
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
        Ellipse2D.Double eliBall = new Ellipse2D.Double(x, y, gp.bDimensionWidth, gp.bDimensionHeight);
        g2.setColor(Color.WHITE);
        g2.fill(eliBall);          
        System.out.println("speedx: " + speedX);
    }
    
}
