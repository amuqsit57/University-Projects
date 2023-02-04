package Costumer;

import Classes.Item;
import Classes.User;
import FileOperations.FileOperationsOnItems;
import FileOperations.FileOperationsOnLoginAndSignup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddToCart extends JFrame {

    JPanel p1;

    JButton addToCart;
    JLabel jName, jQuantity;
    JTextField tName, tQuantity;

    Item item;


    User user;
    AddToCart(User user){
        this.user = user;

        MyActionListener al = new MyActionListener();
        setLayout(null);

        p1 = new JPanel(null);
        p1.setBounds(10,20,400,300);
            jName = new JLabel("Item Name");
            jName.setBounds(20,20,100,30);


            tName = new JTextField();
            tName.setBounds(120,20,150,30);

            jQuantity = new JLabel("Quantity");
            jQuantity.setBounds(20,50,100,30);


            tQuantity = new JTextField();
            tQuantity.setBounds(120,50,150,30);

            addToCart = new JButton("Add To Cart");
            addToCart.setBounds(100,100,150,50);
            addToCart.addActionListener(al);
            addToCart.setFocusPainted(false);
            addToCart.setBackground(Color.BLACK);
            addToCart.setForeground(Color.WHITE);

        p1.add(jName);
        p1.add(tName);
        p1.add(jQuantity);
        p1.add(tQuantity);
        p1.add(addToCart);

        add(p1);
        setSize(395,300);
        setVisible(true);


    }

    public class MyActionListener implements ActionListener {


        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equals("Add To Cart")){

                String itemName = tName.getText();
                int quantity = Integer.parseInt(tQuantity.getText());
                if(FileOperationsOnItems.searchItem(itemName)){

                   item = FileOperationsOnItems.findSpecificItem(itemName);
                   if(quantity<=item.getTotalQuantity()){
                       item.setUserQuantity(quantity);
                       user.addToCart(item);
                       FileOperationsOnLoginAndSignup.updateEntireUser(user);
                       new HomeScreen(user);
                       dispose();

                   }
                   else{
                       JOptionPane.showMessageDialog(null,"Invalid quantity");
                   }

                }
                else{
                    JOptionPane.showMessageDialog(null,"Couldnt Find the Item");
                }


            }

        }


    }



}
