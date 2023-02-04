package Costumer;

import Classes.User;
import LoginAndSignup.LoginScreenUser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Menu extends JFrame {

    JPanel p1,p2;
    JButton edit,logout,orderHistory,home;

    Image resizeImage;

    File f;

    User user;
    public Menu(User user){

        this.user = user;

        setLayout(null);
        setMenu();

        setSize(200,500);
        setVisible(true);
    }

    public void setMenu(){

        p1 = new JPanel(null);
        p1.setBounds(0,0,200,800);

        MyActionListener al = new MyActionListener();


        f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\home.png");
        resizeImage = resizeImage(f,20,20);
        home = new JButton(new ImageIcon(resizeImage));
        home.setBounds(15,10,20,20);
        home.addActionListener(al);
        home.setText("Home");
        home.setFocusPainted(false);
        home.setBackground(Color.BLACK);
        home.setForeground(Color.WHITE);



        orderHistory = new JButton("Order History");
        orderHistory.setBounds(15,100,150,30);
        orderHistory.addActionListener(al);
        orderHistory.setFocusPainted(false);
        orderHistory.setBackground(Color.BLACK);
        orderHistory.setForeground(Color.WHITE);

        edit = new JButton("Edit");
        edit.addActionListener(al);
        edit.setBounds(15,150,150,30);
        edit.setFocusPainted(false);
        edit.setBackground(Color.BLACK);
        edit.setForeground(Color.WHITE);

        logout = new JButton("Log Out");
        logout.addActionListener(al);
        logout.setBounds(15,200,150,30);
        logout.setFocusPainted(false);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);

        p1.add(home);
        p1.add(edit);
        p1.add(orderHistory);
        p1.add(logout);

        add(p1);

    }

    public class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equals("Edit")){

                new Edit();


            }
            else if(e.getActionCommand().equals("Home")){
                new HomeScreen(user);
                dispose();
            }
            else if(e.getActionCommand().equals("Log Out")){
                    new LoginScreenUser();
                    dispose();
            }
            else if(e.getActionCommand().equals("Order History")){

                new OrderHistory(user);

            }


        }


    }

    public Image resizeImage(File file, int width, int height){

        Image img;
        Image resizedImage;
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        resizedImage = img.getScaledInstance(width,height,Image.SCALE_DEFAULT);
        return resizedImage;
    }

}
