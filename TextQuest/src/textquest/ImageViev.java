package textquest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ImageViev extends JComponent implements KeyListener, ActionListener {
    Image grass = new ImageIcon("Files\\Map.png").getImage();
    Rectangle rectangle = new Rectangle();


    public void paint(Graphics g){
        Graphics2D gr = (Graphics2D)g;
        gr.drawImage(grass, 0,0,null);
    }

    public static void img(){
        ImageViev t = new ImageViev();
        JFrame f = new JFrame("Map");
        f.setSize(800, 550);
        f.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        f.addKeyListener(t);
        f.add(new ImageViev());
        f.add(t);
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
