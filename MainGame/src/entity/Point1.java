/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import maingame.GamePanel;

import java.awt.Font;
/**
 *
 * @author belpg
 */
public class Point1 extends Entity{
    GamePanel gp;
    Ball ball;
    
    public Point1(GamePanel gp, Ball ball) {
        this.gp = gp;                
        this.ball = ball;
        
        setDefaultValues();
    }
    
    public void setDefaultValues(){
        x = 50;
        y = 50;
        pt = 0;            
    }
    
    public void draw(Graphics2D g2){
        Font font = new Font("Arial", Font.PLAIN, 30);
        g2.setFont(font);
        g2.setColor(Color.WHITE);
        g2.drawString(ball.pt1S, (int) x, (int) y);

    }
}
