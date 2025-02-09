/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maingame;

import javax.swing.JFrame;

/**
 *
 * @author belpg
 */
public class MainGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame window = new JFrame();
                
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Ping Pong");
        
        GamePanel gp = new GamePanel();    
        window.add(gp);                        
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gp.StartGameTh();
    }
    
}
