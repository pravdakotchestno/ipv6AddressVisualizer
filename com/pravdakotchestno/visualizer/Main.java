package com.pravdakotchestno.visualizer;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        new Frame();
    }

    public static String changeAddress(String address, int x, int y){
        //TODO
        return address;
    }

    public static void paintVisualization(Graphics g, String address){
        //TODO
        g.setColor(Color.WHITE);
        g.fillRect(6,180,288,288);
        g.setColor(Color.BLACK);
        g.fillRect(6,180,36,36);
    }
}
