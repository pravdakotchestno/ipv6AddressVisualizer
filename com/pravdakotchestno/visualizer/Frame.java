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
            //octets.get(i).setBounds();
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
