package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    
    //Screen settings
    final int originalTileSize = 16; //16 x 16 tile
    final int scale = 3;

    final int tileSize = originalTileSize*scale; // showed tile size is 48
    final int maxScreenColumn = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenColumn;
    final int screenHeight = tileSize * maxScreenRow;

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
         
        while(gameThread != null) {
           // System.out.println("Game is running");
           // Update
           update();

           //draw location after update
           repaint();

        }
    }

    public void update(){

    }
    //standard version in java
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        //convert graphics to 2d for more functions
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.red);
        g2.fillRect(100, 100, tileSize, tileSize);
        g2.dispose();
    }
}
