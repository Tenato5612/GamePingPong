/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Rectangle;

/**
 *
 * @author belpg
 */
public class Entity {
    public int x;
    public int y;
    public int speed = 4;
    public int pt1, pt2;
    public int pt;
    public int speedX, speedY;
    public Rectangle solidArea = new Rectangle();      
    public int countSpeed = 0;
    public int spawnTimer = 50;
}
