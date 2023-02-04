package Costumer;

import javax.swing.*;
import java.awt.*;

public class Chat extends JFrame {

    JPanel p1,p2;

    JTextField message;
    JButton send;
    public Chat(){


        setLayout(null);





        p1 =new JPanel(null);
        p1.setBounds(0,900,1900,200);
        p1.setBackground(Color.MAGENTA);


        message = new JTextField();
        message.setBounds(200,20,700,100);

        send = new JButton("Send");
        send.setBounds(900,30,100,500);
        send.setFocusPainted(false);


        p1.add(message);
        p1.add(send);

        add(p1);


        p2 = new JPanel();


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }


}
