import javax.swing.*;
import java.util.ArrayList;

public class visualizer {
    public static void main(String[]args){
        new Frame();
    }
}

class Frame extends JFrame{
    private Panel panel;

    private ArrayList<HexNumberComboBox> octets;

    public Frame(){

        octets = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            octets.add(new HexNumberComboBox(85*i,10,85,30));
            add(octets.get(i));
        }

        for(int i = 0; i < 8; i++){
            JLabel label = new JLabel();
            label.setBounds(85*i+85,10,4,30);
            label.setText(":");
            add(label);
        }

        panel = new Panel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(700,550);

        setLocationRelativeTo(null);

        setVisible(true);

    }
}

class Panel extends JPanel{

}

class HexNumberComboBox extends JComboBox{
    public HexNumberComboBox(int x, int y, int width, int height){
        super(getItemsArray());
        setBounds(x, y, width, height);
        addActionListener(e->{

        });
    }
    private static String[] getItemsArray(){
        String[] items = new String[65536];
        String[] chars = new String[]{"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
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