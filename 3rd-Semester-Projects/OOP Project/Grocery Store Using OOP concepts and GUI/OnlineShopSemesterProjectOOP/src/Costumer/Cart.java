package Costumer;

import Classes.Item;
import Classes.User;
import FileOperations.FileOperationsOnItems;
import FileOperations.FileOperationsOnLoginAndSignup;
import LoginAndSignup.LoginScreenUser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Cart extends JFrame {

    JPanel pMain,p1;

    JLabel jName,jImage,jQuantity,jPrice,jPriceOfOneItem,jTotalBill;

    Image resizedImage;
    File f;


    JButton home, buy;

    User user;

    public Cart(User user){
        this.user = user;

        setLayout(null);

        MyActionListener al  = new MyActionListener();


        f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\home.png");
        resizedImage = resizeImage(f,20,20);
        home = new JButton(new ImageIcon(resizedImage));
        home.setBounds(15,10,35,35);
        home.setText("Home");
        home.addActionListener(al);
        home.setFocusPainted(false);
        home.setBackground(Color.BLACK);
        home.setForeground(Color.WHITE);


        int cartSize = user.getCart().size();
        int n;
        if(cartSize<5){
            n = 5;
        }
        else{
            n = cartSize;
        }


        pMain = new JPanel(new GridLayout(n,1,20,20));
                pMain.setBounds(100,100,300,600);

                jTotalBill = new JLabel();
                jTotalBill.setText("0");
                jTotalBill.setBounds(400,650,100,20);

                int totalBill=0;
                for(int i = 0 ; i < cartSize;i++){

                    p1 = new JPanel(null);
                    p1.setPreferredSize(new Dimension(300,100));
                    p1.setBackground(Color.yellow);

                    Item item = user.getCart().get(i);

                    jImage = new JLabel();
                    f = new File(item.getImageLocation());
                    resizedImage = resizeImage(f,80,80);
                    jImage.setIcon(new ImageIcon(resizedImage));
                    jImage.setBounds(10,10,80,80);

                    jName = new JLabel(item.getName());
                    jName.setBounds(190,10,100,20);

                    jPrice = new JLabel("Price: "+item.getPrice());
                    jPrice.setBounds(100,40,100,20);

                    jQuantity = new JLabel("Quantity: "+item.getUserQuantity());
                    jQuantity.setBounds(100,60,100,20);

                    int priceOfOneItem =item.getPrice()*item.getUserQuantity();
                    jPriceOfOneItem = new JLabel("T Price "+(priceOfOneItem) +" RS");
                    jPriceOfOneItem.setBounds(260,80,100,20);

                    totalBill = totalBill+priceOfOneItem;

                    p1.add(jName);
                    p1.add(jPrice);
                    p1.add(jImage);
                    p1.add(jQuantity);
                    p1.add(jPriceOfOneItem);

                    pMain.add(p1);


                }

                jTotalBill.setText(""+totalBill+" RS");

        JScrollPane jScrollPane = new JScrollPane(pMain);
        jScrollPane.setBounds(150,50,380,600);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);



        buy = new JButton("Buy");
        buy.setBackground(Color.white);
        buy.setFocusPainted(false);
        buy.addActionListener(al);
        buy.setBounds(200,700,100,50);


        add(home);
        add(jScrollPane);
        add(buy);
        add(jTotalBill);
        setSize(600,800);
        setVisible(true);
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

    public class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e){


             if(e.getActionCommand().equals("Home")){
                 dispose();
                 new HomeScreen(user);

            }
             else if(e.getActionCommand().equals("Buy")){
                 //placing into orders history
                 user.buy();


                 //quantity update of items
                 FileOperationsOnItems.updateItemsQuantity(user.getCart());


                 //Cart Empty
                 user.getCart().clear();

                 FileOperationsOnLoginAndSignup.updateEntireUser(user);


                 JOptionPane.showMessageDialog(null,"Thank u! For Visiting US");

                 dispose();
             }




        }


    }

}
