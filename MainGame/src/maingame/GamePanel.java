/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maingame;

import entity.Player1;
import entity.Player2;
import entity.Ball;
import entity.Bot;
import entity.Point1;
import entity.Point2;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Graphics;

/**
 *
 * @author belpg
 */
public class GamePanel extends JPanel implements Runnable{
    int tileOriginalSize = 16; // 16x16
    int scale = 3;
    
    public final int tileSize = tileOriginalSize * scale;  // 48 Pixels   
    public final int maxScreenCol = 18;
    public final int maxScreeRow = 12;
    public int screenWidth = tileSize * maxScreenCol; // 864 Pixels
    public final int screenHeight = tileSize * maxScreeRow; // 480 pixels
        
    Thread gameThread;
    Player1 p1;
    Player2 p2;    
    Bot bot;
    Point1 point1;
    Point2 point2;
    StartGame sg;
    public final double pDimensionWidth = tileSize - 25;
    public final double pDimensionHeight = tileSize * 4;
    Ball ball;
    public final double bDimensionHeight = tileSize;
    public final double bDimensionWidth = tileSize;
    KeyHandler keyH = new KeyHandler();     
    
    int stateGame = 0;
    public int stateMode = 0;
    int resetGame = 0;    
    
    int fps = 60;    

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        
        this.p1 = new Player1(this, keyH);
        this.p2 = new Player2(this, keyH);                          
        this.ball = new Ball(this, p1, p2, bot);
        this.bot = new Bot(this, ball);
        this.ball.setBot(this.bot);
        this.point1 = new Point1(this, ball);
        this.point2 = new Point2(this, ball);
        this.sg = new StartGame(this, keyH);
    }
    
    public void StartGameTh(){
        gameThread = new Thread(this);
        gameThread.start();
    }       
    
    @Override
    public void run(){        
        double interval = 1000000000/fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long time = 0;
        int drawCount = 0;
        
        while(gameThread != null){
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / interval;
            time += (currentTime - lastTime);
            lastTime = currentTime;
            if(delta >= 1){               
                update();
                repaint();
                delta--;
                drawCount++;                 
            }
            
            if(time > 1000000000){
                //System.out.println("Fps: " + drawCount);
                drawCount = 0;
                time = 0;
            }                                                  
        }                       
    }
    
    public void update(){
        sg.ClickEvent();
        if(stateGame >= 2){
            p1.update();
            if(stateMode == 1){
                p2.update();         
            }
            if(stateMode == 2){
                bot.update();
            }
            ball.moveBall();                
            ball.colisionCheck();
        }         
        
        if(resetGame == 1){
            p1.resetPos();
            p2.resetPos();
            ball.resetPos();
            bot.resetPos();
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(stateGame >= 2){
            p1.draw(g2);
            if(stateMode == 1){
                p2.draw(g2);
            }
            if(stateMode == 2){
                bot.draw(g2);
            }
            ball.draw(g2);   

            point1.draw(g2);
            point2.draw(g2);

            g2.dispose();    
        }       
        sg.draw(g2);
    }   
}
