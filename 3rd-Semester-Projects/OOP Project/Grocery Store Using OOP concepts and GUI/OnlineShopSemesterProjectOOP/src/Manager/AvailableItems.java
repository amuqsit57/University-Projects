package Manager;

import Classes.Item;
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

public class AvailableItems extends JFrame {

    JPanel pTop, pMiddle, pItem, pItemInside;
    ImageIcon img;
    JLabel jImage, jName, jPrice, jTopIntro, jcart;
    Image resizedImage;
    File f;

    JButton home;
    JButton buyButton, menuButton, chatButton, cartButton;


    public AvailableItems() {
        MyActionListener al = new MyActionListener();


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        ArrayList<Item> items = FileOperationsOnItems.readAllFromFile();


        int itemsSize = items.size();
        System.out.println(itemsSize);
        int n;
        if (itemsSize <= 6) {
            n = 6;
        } else {
            n = (itemsSize / 3) + 1;
//            n = itemsSize;
        }

        pMiddle = new JPanel(new GridLayout(n, 1, 30, 30));
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

            buyButton = new JButton("Buy");
            buyButton.setBounds(50, 150, 100, 40);
            //button properties
            buyButton.setFocusPainted(false);
            buyButton.setBackground(Color.RED);
            buyButton.setForeground(Color.WHITE);
            buyButton.addActionListener(al);


            //using custom library for adding shadow borders
            DropShadowBorder border = new DropShadowBorder();
            border.setFillContentArea(true);
            pItemInside.setBorder(new CompoundBorder(border, new LineBorder(Color.BLACK)));

            pItemInside.add(jImage);
            pItemInside.add(jName);
            pItemInside.add(jPrice);
            pItemInside.add(buyButton);

            pItem.add(pItemInside);

//                pItem.setBackground(Color.black);
            pMiddle.add(pItem);


        }


        JScrollPane jScrollPane = new JScrollPane(pMiddle);
        jScrollPane.setBounds(100, 100, 1380, 750);
        jScrollPane.setBorder(new EmptyBorder(30, 30, 30, 30));
        jScrollPane.setBackground(Color.white);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\home.png");
        resizedImage = resizeImage(f,20,20);
        home = new JButton(new ImageIcon(resizedImage));
        home.setBounds(15,10,35,35);
        home.setText("Home");
        home.addActionListener(al);
        home.setFocusPainted(false);
        home.setBackground(Color.BLACK);
        home.setForeground(Color.WHITE);

        add(jScrollPane);


        setSize(700, 800);
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {


        public void actionPerformed(ActionEvent e){

             if(e.getActionCommand().equals("Home")){
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