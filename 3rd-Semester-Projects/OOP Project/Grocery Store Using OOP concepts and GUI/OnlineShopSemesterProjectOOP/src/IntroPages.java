import javax.swing.*;
import java.awt.*;

public class IntroPages extends JFrame {


    JPanel p1;
    JPanel p2;
    JPanel p2_1;
    JPanel p3;

    JTextField t1;
    JPasswordField passwordField;

    JLabel username;
    JLabel password;

    JButton login;
    JButton signup;
    JButton admin;


    IntroPages(){


        setLayout(new GridLayout(5,1));

        p1 = new JPanel(new BorderLayout());

        p2 = new JPanel(new BorderLayout());
        p2_1 = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        p2_1.add(new JButton("Button1"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;

        p2_1.add(new JButton("Button2"), gbc);

//        p2.add(p2_1,BorderLayout.CENTER);

        p3 = new JPanel(new GridBagLayout());
        add(p1);
        add(p2_1);
        add(p3);

        setSize(1920,1080);
        setVisible(true);



    }


}
