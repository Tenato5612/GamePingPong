/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import maingame.GamePanel;

import java.awt.Graphics2D;
import java.awt.Rectangle;
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
        
        solidArea = new Rectangle(0, 0, gp.pDimensionWidth, gp.pDimensionHeight);
        
        setDefaultValues();
    }
    
    public void setDefaultValues(){
        x = 714;
        y = 192;       
        
        solidArea.x = x;
        solidArea.y = y;
    }
    
    public void resetPos(){
        x = 714;
        y = 192;
        
        defaultX = x;
        defaultY = y;
    }
    
    public void update(){
        if(ball.y > y){
            y += speed;
        }
        if(ball.y < y){
            y -= speed + 2;
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
        g2.setColor(Color.RED);
        g2.fillRect(x, y, gp.pDimensionWidth, gp.pDimensionHeight);        
    }
    
}
