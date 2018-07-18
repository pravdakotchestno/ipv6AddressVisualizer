package com.pravdakotchestno.visualizer;

import javax.swing.*;

public class Frame extends JFrame{
    private Panel panel;
    private JTextField octet1;
    private JTextField octet2;
    private JTextField octet3;
    private JTextField octet4;
    private JTextField octet5;
    private JTextField octet6;
    private JTextField octet7;
    private JTextField octet8;

    public Frame(){
        panel = new Panel();

        add(panel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,500);
        setLocationRelativeTo(null);

        setVisible(true);

    }
}
