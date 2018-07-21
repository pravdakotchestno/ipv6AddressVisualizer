package com.pravdakotchestno.visualizer;

import java.awt.*;

public class Main {
    private static String address = "0000:0000:0000:0000:0000:0000:0000:0000";

    public static void main(String[] args) {
        new Frame();
    }

    public static void paintVisualization(Graphics g){
        String octets[] = address.split(":");
        String oldoctets[] = octets;
        for(int i = 0; i < 8; i++){
            String octet = "";
            for(char ch : oldoctets[i].toCharArray()){
                int b = (ch - '0') % 4;
                int a = ((ch - '0') >> 2)%4;
                octet+=(a +""+ b);
            }
            octets[i] = octet;
        }

        try{
            for(int y = 0; y < 8; y++){
                for(int x = 0; x < 8; x++){
                    int currentchar = octets[y].toCharArray()[x]-'0';

                    switch(currentchar) {
                        case 0: {
                            g.setColor(Color.BLACK);
                            break;
                        }
                        case 1: {
                            g.setColor(Color.WHITE);
                            break;
                        }
                        case 2: {
                            g.setColor(Color.RED);
                            break;
                        }
                        case 3: {
                            g.setColor(Color.GREEN);
                            break;
                        }
                        default: {
                            throw new ArithmeticException();
                        }
                    }
                    g.fillRect(x * 50, y * 50 + 130,50,50);
                }

            }
        }catch(Exception e){
            g.setColor(Color.WHITE);
            g.fillRect(0,130,400,400);
        }

    }
    public static void changeOctet(int x, int y){
        //TODO
    }

}
