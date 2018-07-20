package com.pravdakotchestno.visualizer;

import javax.swing.*;
import java.util.ArrayList;

public class Frame extends JFrame{
    private Panel panel;
    private ArrayList<JTextField> octets;

    public Frame(){
        octets = new ArrayList<>();
        for(int i = 0; i<8; i++){
            octets.add(new JTextField());
            octets.get(i).setBounds(4*i+45*i+5,10,45,30);
            add(octets.get(i));
        }

        for(int i = 0; i < 7; i++){
            JLabel label = new JLabel();
            label.setBounds(45*i+4*i+49,10,4,30);
            label.setText(":");
            add(label);
        }

        panel = new Panel();

        add(panel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,550);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
