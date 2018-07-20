package com.pravdakotchestno.visualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panel extends JPanel implements MouseListener{
    public Panel(){
        addMouseListener(this);
    }
    public void mouseClicked(MouseEvent e) {
        int x = (e.getX())/50;
        int y = (e.getY()-130)/50;
        //TODO
        System.out.println("x = "+x+" y = "+y);
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void paintComponent(Graphics g){
        
        Main.paintVisualization(g,null);
    }
}
