package graphics;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Enemy extends graphics{
    public final String TITLE = "GALAGA";
    public final Dimension SIZE = new Dimension(1920, 1080);
    public JFrame frame;
    private boolean isRunning, isDone;
    private Image imgBuffer;
    private BufferedImage enemy1, enemy2, enemy3, enemy4, enemy5;
    private boolean change;
    @SuppressWarnings("unused")
    private Color BROWN;
    @SuppressWarnings("unused")
    private boolean AITurn, UserTurn;
    private Rectangle myRect;
    private Point current;
    private int dx1, dx2, dy1, dy2, dx3, dx4, dy3, dy4, dx5, dx6, dy5, dy6, dx7, dx8, dy7, dy8, dx9, dx10, dy9, dy10;

    public void setChange(boolean change) {
        this.change = change;
    }

    private void loadImages() {

        try {


            enemy2 = ImageIO.read(this.getClass().getResource(""));
            enemy1 = ImageIO.read(this.getClass().getResource(""));
            enemy3 = ImageIO.read(this.getClass().getResource(""));
            enemy4 = ImageIO.read(this.getClass().getResource(""));
            enemy5 = ImageIO.read(this.getClass().getResource(""));



        } catch (IOException ex) {

            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    public Enemy(){

        //set enemy destination coordinates here

        loadImages();
        setChange(true);
        frame = new JFrame();

        frame.setSize(SIZE);
        frame.setTitle(TITLE);
        isRunning = true;
        isDone = false;
        imgBuffer = frame.createImage(SIZE.width, SIZE.height);

    }

    public void EnemyMove(){

    }

    @Override
    public void windowClosing(WindowEvent e) {
        frame.setVisible(false);
        frame.dispose();
        isRunning = false;
    }


    @Override
    public void run() {
        while(isRunning){

            draw();

            if(change){
                setChange(false);

            }
            try{Thread.sleep(50);}
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
        isDone = true;
    }

    private void draw() {


        Graphics2D g2d = (Graphics2D) imgBuffer.getGraphics();



        // g2d.drawImage(enemy1, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, null)
        // g2d.drawImage(enemy2, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, null)
        // g2d.drawImage(enemy3, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, null)
        // g2d.drawImage(enemy4, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, null)
        // g2d.drawImage(enemy5, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, null)


        if(isRunning)
            g2d = (Graphics2D) frame.getGraphics();
        g2d.drawImage(imgBuffer, 0,  0, SIZE.width, SIZE.height, 0, 0, SIZE.width, SIZE.height, null);
        g2d.dispose();
    }}