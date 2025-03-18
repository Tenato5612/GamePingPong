/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import maingame.GamePanel;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
/**
 *
 * @author belpg
 */
public class Bot extends Entity{
    GamePanel gp;
    Ball ball;
    
    public Bot(GamePanel gp, Ball ball){
        this.gp = gp;        
        this.ball = ball;
        
        solidArea = new Rectangle2D.Double(0, 0, gp.pDimensionWidth, gp.pDimensionHeight);
        
        setDefaultValues();
    }
    
    public void setDefaultValues(){
        x = 714;
        y = 192;  
        speed = 6;
    }
    
    public void resetPos(){
        x = 714;
        y = 192;
        
        defaultX = x;
        defaultY = y;
    }
    
    public void setColision(){
        solidArea.setFrame(x, y, gp.pDimensionWidth, gp.pDimensionHeight);
    }
    
    public void update(){
        if(ball.y > y){
            y += speed;
        }
        if(ball.y < y){
            y -= speed;
        }
        
        if(y < 0){            
        
        } else{            
            y -= speed;
        }
        
        if(y > gp.screenHeight - gp.pDimensionHeight){            
            } else{
                y += speed;
            }
    }
    
    public void draw(Graphics2D g2){
        Rectangle2D.Double bot = new Rectangle2D.Double(x, y, gp.pDimensionWidth, gp.pDimensionHeight);
        g2.setColor(Color.RED);
        g2.fill(bot);               
    }
    
}
