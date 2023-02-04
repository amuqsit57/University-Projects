import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class IntroPage extends JFrame {


    ImageIcon myImg;
    JLabel myLabel;
    JLabel myLabel2;
    JButton customer;
    JButton admin;

    JPanel p1;

    IntroPage()  {

        // setting image
        myImg = new ImageIcon(this.getClass().getResource("/login.jpg"));
        myLabel = new JLabel(myImg);
        myLabel2 = new JLabel("dfasdfadsfsd");

        myLabel.setSize(1920,1080);

        p1 = new JPanel(null);
        p1.setSize(1920,1080);

        customer = new JButton("Customer");
        admin = new JButton("Admin");
//        customer.setBounds(540,900,50,50);
//        admin.setBounds(540,960,50,50);

        p1.add(myLabel2);
        p1.add(myLabel);
        p1.add(customer);
        p1.add(admin);


        add(p1);


        //        myLabel.setLayout(new GridLayout(3,1));

        //adding buttons





        //
//        myLabel.add(customer);
//        myLabel.add(admin);



        setLocationRelativeTo(null);
        setSize(1920,1080);
        setVisible(true);


    }

}
