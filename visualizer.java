import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class visualizer {

    private static String address="0000:0000:0000:0000:0000:0000:0000:0000";
    private static Frame frame;

    public static void main(String[]args){
        frame = new Frame();
    }

    public static void paintVisualization(Graphics g){
        String octets[] = address.split(":");
        String tempoctets[] = octets;
        for(int i = 0; i < 8; i++){
            String octet = "";
            for(char ch : tempoctets[i].toCharArray()){
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
                    g.fillRect(x * 36, y * 36,36,36);
                }

            }
        }catch(Exception e){
            e.printStackTrace();
            g.setColor(Color.WHITE);
            g.fillRect(0,0,288,288);
        }


    }

    public static void repaintVisualization() {
        address = "";
        for(HexNumberComboBox cb : frame.getOctets()){
            address += (String)cb.getSelectedItem()+":";
        }
        frame.repaintPanel();
    }
}

class Frame extends JFrame{

    private Panel panel;

    private ArrayList<HexNumberComboBox> octets;

    public Frame(){

        octets = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            int comboboxwidth = 90;
            octets.add(new HexNumberComboBox(comboboxwidth * i,10, comboboxwidth,30));
            add(octets.get(i));
        }

        panel = new Panel();
        panel.setBounds(216,131,288,288);
        add(panel);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(720,550);

        setLocationRelativeTo(null);

        setVisible(true);


    }

    public ArrayList<HexNumberComboBox> getOctets(){
        return octets;
    }

    public void repaintPanel() {
        panel.repaint();
    }
}

class Panel extends JPanel implements MouseListener{

    public Panel(){
        addMouseListener(this);
    }

    public void paintComponent(Graphics g){
        visualizer.paintVisualization(g);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX()/36;
        int y = e.getY()/36;
        System.out.println(x+" "+y);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}

class HexNumberComboBox extends JComboBox{
    public HexNumberComboBox(int x, int y, int width, int height){
        super(getItemsArray());
        setBounds(x, y, width, height);
        addActionListener(e->{
            visualizer.repaintVisualization();
        });
    }
    private static String[] getItemsArray(){
        String[] items = new String[65536];
        String[] chars = new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        int i = 0;
        for(String a : chars){
            for(String b : chars){
                for(String c : chars){
                    for(String d : chars){
                        items[i] = a+b+c+d;
                        i++;
                    }
                }
            }
        }
        return items;
    }
}