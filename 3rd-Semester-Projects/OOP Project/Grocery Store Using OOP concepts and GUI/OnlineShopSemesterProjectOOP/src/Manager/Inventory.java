package Manager;

import Classes.Item;
import Classes.User;
import Costumer.*;
import Costumer.Menu;
import FileOperations.FileOperationsOnItems;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Inventory extends JFrame {


    JPanel pTop, pMiddle, pItem, pItemInside, pData, pItemsSold, pItemsInStock;
    ImageIcon img;
    JLabel jImage, jName, jPrice, jTopIntro, jcart, jStock, j1, j2, j3, jAmountEarned, jAmountSpent;
    JButton menuButton, chatButton, cartButton;
    Image resizedImage;
    File f;


    JButton home;


    public Inventory() {


        MyActionListener al = new MyActionListener();


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        pTop = new JPanel(null);
        pTop.setBounds(0, 0, 1920, 70);
        pTop.setBackground(new Color(100, 189, 154));

        jTopIntro = new JLabel("Inventory");
        jTopIntro.setForeground(Color.white);
        jTopIntro.setBackground(new Color(100, 189, 154));
        jTopIntro.setBounds(730, 20, 200, 30);
        jTopIntro.setFont(new Font("Times New Roman", Font.BOLD, 30));

        f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\menu.png");
        menuButton = new JButton("Menu");
        menuButton.setBounds(20, 10, 50, 50);
        resizedImage = resizeImage(f, 50, 50);
        menuButton.setIcon(new ImageIcon(resizedImage));
        menuButton.setFocusPainted(false);
        menuButton.setBackground(new Color(100, 189, 154));
        menuButton.addActionListener(al);


        f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\chat.png");
        chatButton = new JButton("Chat");
        chatButton.setBounds(1450, 10, 50, 50);
        resizedImage = resizeImage(f, 50, 50);
        chatButton.setFocusPainted(false);
        chatButton.setIcon(new ImageIcon(resizedImage));
        chatButton.setBackground(new Color(100, 189, 154));


        f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\cart.png");
        cartButton = new JButton("Cart");
        cartButton.setBounds(1350, 10, 50, 50);
        resizedImage = resizeImage(f, 50, 50);
        cartButton.setIcon(new ImageIcon(resizedImage));
        cartButton.setFocusPainted(false);
        cartButton.setBackground(new Color(100, 189, 154));
        cartButton.addActionListener(al);

        jcart = new JLabel("0");
        jcart.setForeground(Color.BLACK);
        jcart.setBounds(1325, 5, 40, 40);
        jcart.setFont(new Font("Times New Roman", Font.BOLD, 30));

        pTop.add(jTopIntro);
        pTop.add(menuButton);
        pTop.add(chatButton);
        pTop.add(cartButton);
        pTop.add(jcart);


        ArrayList<Item> items = FileOperationsOnItems.readAllFromFile();


        int itemsSize = items.size();
        System.out.println(itemsSize);
        int n;
        if (itemsSize <= 6) {
            n = 6;
        } else {
            n = (itemsSize / 2) + 1;
//            n = itemsSize;
        }

        pMiddle = new JPanel(new GridLayout(n, 2, 30, 30));
        pMiddle.setBackground(Color.WHITE);

        for (int i = 0; i < itemsSize; i++) {
            pItem = new JPanel(null);
            pItem.setPreferredSize(new Dimension(200, 200));
            pItem.setBackground(Color.WHITE);
            pItem.setPreferredSize(new Dimension(200, 200));
            pItemInside = new JPanel(null);
            pItemInside.setBounds(100, 2, 200, 200);
            pItemInside.setBackground(Color.WHITE);
            //                    img = new ImageIcon(items.get(0).getImageLocation());
//                    System.out.println(items.get(0).getImageLocation());
            jImage = new JLabel(img);
//                    jImage.setPreferredSize(new Dimension(150,150));


            jImage.setSize(120, 120);
            f = new File(items.get(i).getImageLocation());
            resizedImage = resizeImage(f, 120, 120);
            jImage.setIcon(new ImageIcon(resizedImage));
            jImage.setBounds(50, 10, 100, 100);

//                    jImage.setBounds(10,10,100,100);

            jName = new JLabel(items.get(i).getName());
            jPrice = new JLabel("Price: " + items.get(i).getPrice());
            jName.setBounds(80, 105, 100, 30);
            jName.setFont(new Font("Times New Roman", Font.BOLD, 20));
            ;
            jPrice.setBounds(60, 120, 100, 30);
            jPrice.setFont(new Font("Times New Roman", Font.BOLD, 18));

            jStock = new JLabel("In Stock: " + items.get(i).getTotalQuantity());
            jStock.setBounds(50, 150, 100, 40);


            //using custom library for adding shadow borders
            DropShadowBorder border = new DropShadowBorder();
            border.setFillContentArea(true);
            pItemInside.setBorder(new CompoundBorder(border, new LineBorder(Color.BLACK)));

            pItemInside.add(jImage);
            pItemInside.add(jName);
            pItemInside.add(jPrice);
            pItemInside.add(jStock);

            pItem.add(pItemInside);

//                pItem.setBackground(Color.black);
            pMiddle.add(pItem);


        }

//        int i = 0;
//        int count = 0 ;
//        int x = 0 , y = 0 ;
//        while(i<50){
//            if(count ==4){
//                y = y + 220;
//                x = 0;
//                count = 0 ;
//            }
//
//            pItem = new JPanel();
//            pItem.setBounds(x,y,200,200);
//            pItem.setBackground(Color.black);
//            pMiddle.add(pItem);
//            x = x+220;
//            count++;
//            i++;
//
//        }

        JScrollPane jScrollPane = new JScrollPane(pMiddle);
        jScrollPane.setBounds(50, 100, 900, 750);
        jScrollPane.setBorder(new EmptyBorder(30, 30, 30, 30));
        jScrollPane.setBackground(Color.white);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(pTop);
        add(jScrollPane);


        pData = new JPanel(null);
        pData.setBounds(940, 100, 600, 750);
        pData.setBackground(Color.MAGENTA);
        int totalAmountEarned = 0;

        j1 = new JLabel("Specific Earning");
        j1.setBounds(320, 60, 200, 25);
        //Amount earned by selling an item
        pItemsSold = new JPanel(new GridLayout(items.size(), 1));
        pItemsSold.setBackground(new Color(133, 200, 230));
        for (int i = 0; i < items.size(); i++) {
            int singleItemEarning = items.get(i).getSoldItems() * items.get(i).getPrice();
            jStock = new JLabel(items.get(i).getName() + "        :" + (singleItemEarning));
            pItemsSold.add(jStock);
            totalAmountEarned = totalAmountEarned + (singleItemEarning);

        }
        jScrollPane = new JScrollPane(pItemsSold);
        jScrollPane.setBounds(320, 100, 300, 250);
        jScrollPane.setBorder(new EmptyBorder(30, 30, 30, 30));
        jScrollPane.setBackground(Color.white);
        jScrollPane.setForeground(Color.cyan);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pData.add(j1);


        pData.add(jScrollPane);
        jAmountEarned = new JLabel("Total Earnings");
        jAmountEarned.setBounds(400, 500, 200, 100);
        pData.add(jAmountEarned);

        jAmountEarned = new JLabel(totalAmountEarned + " RS");
        jAmountEarned.setBounds(410, 520, 200, 100);
        jAmountEarned.setFont(new Font("Times New Roman", Font.BOLD, 24));
        pData.add(jAmountEarned);
        add(pData);

//
//        jAmountSpent= new JLabel();
//        jAmountSpent.setBounds(200,100,200,100);
//        jAmountSpent.setText();
//        int totalAmountSpent;
//
        j2 = new JLabel("Specific Purchasing Amount ");
        j2.setBounds(50, 400, 200, 25);
        //Amount Spent on Buying an item
        pItemsSold = new JPanel(new GridLayout(items.size(), 1));
        pItemsSold.setBackground(new Color(133, 200, 230));

        for (int i = 0; i < items.size(); i++) {
            jStock = new JLabel(items.get(i).getName() + "        :" + (items.get(i).getTotalQuantity() * items.get(i).getCostPrice()));
            pItemsSold.add(jStock);


        }
        jScrollPane = new JScrollPane(pItemsSold);
        jScrollPane.setBounds(50, 450, 300, 250);
        jScrollPane.setBorder(new EmptyBorder(30, 30, 30, 30));
        jScrollPane.setBackground(Color.white);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pData.add(jScrollPane);
        pData.add(j2);

        add(pData);
        j3 = new JLabel("Specific Items Sold");
        j3.setBounds(20, 60, 200, 25);
        pItemsSold = new JPanel(new GridLayout(items.size(), 1));
        pItemsSold.setBackground(new Color(133, 200, 230));

        for (int i = 0; i < items.size(); i++) {
            jStock = new JLabel(items.get(i).getName() + "        :" + items.get(i).getSoldItems());
            pItemsSold.add(jStock);


        }
        jScrollPane = new JScrollPane(pItemsSold);
        jScrollPane.setBounds(20, 100, 300, 250);
        jScrollPane.setBorder(new EmptyBorder(30, 30, 30, 30));
        jScrollPane.setBackground(Color.white);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pData.add(jScrollPane);
        pData.add(j3);
        add(pData);

        f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\home.png");
        resizedImage = resizeImage(f, 20, 20);
        home = new JButton(new ImageIcon(resizedImage));
        home.setBounds(15, 10, 35, 35);
        home.setText("Home");
        home.addActionListener(al);
        home.setFocusPainted(false);
        home.setBackground(Color.BLACK);
        home.setForeground(Color.WHITE);

        setSize(700, 800);
        setVisible(true);
    }


    public class MyActionListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals("Home")) {
                dispose();
                new AdminScreen();

            }

        }

    }
    public Image resizeImage(File file,int width,int height){

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