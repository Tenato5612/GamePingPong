/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.geom.Rectangle2D;

/**
 *
 * @author belpg
 */
public class Entity {
    public double x, y;    
    public int xint, yint;
    public double nrgBall;
    public double indRngX, indRngY;
    public double speed = 4;
    public int pt1, pt2;
    public String pt1S, pt2S;
    public double pt;
    public double speedX, speedY;
    public double defaultX, defaultY;
    public Rectangle2D solidArea = new Rectangle2D.Double();
    public double countSpeed = 0;
    public double spawnTimer = 50;
    public double oneClick = 0;
}
