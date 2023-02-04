package Costumer;

import Classes.User;
import FileOperations.FileOperationsOnItems;
import Classes.Item;

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


public class HomeScreen extends JFrame {

    JPanel pTop,pMiddle ,pItem, pItemInside;
    ImageIcon img;
    JLabel jImage,jName,jPrice,jTopIntro ,jcart;
    JButton buyButton ,menuButton,chatButton,cartButton;
    Image resizedImage;
    File f;
    User user;


    public HomeScreen(User user){

        this.user = user;
        MyActionListener al = new MyActionListener();


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        pTop = new JPanel(null);
        pTop.setBounds(0,0,1920,70);
        pTop.setBackground(new Color(100,189,154));

            jTopIntro = new JLabel("Home");
            jTopIntro.setForeground(Color.white);
            jTopIntro.setBackground(new Color(100,189,154));
            jTopIntro.setBounds(730,20,100, 30);
            jTopIntro.setFont(new Font("Times New Roman", Font.BOLD, 30));

            f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\menu.png");
            menuButton = new JButton("Menu");
            menuButton.setBounds(20,10,50,50);
            resizedImage = resizeImage(f,50,50);
            menuButton.setIcon(new ImageIcon(resizedImage));
            menuButton.setFocusPainted(false);
            menuButton.setBackground(new Color(100,189,154));
            menuButton.addActionListener(al);


            f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\chat.png");
            chatButton = new JButton("Chat");
            chatButton.setBounds(1450,10,50,50);
            resizedImage = resizeImage(f,50,50);
            chatButton.setFocusPainted(false);
            chatButton.setIcon(new ImageIcon(resizedImage));
            chatButton.setBackground(new Color(100,189,154));


            f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\cart.png");
            cartButton = new JButton("Cart");
            cartButton.setBounds(1350,10,50,50);
            resizedImage = resizeImage(f,50,50);
            cartButton.setIcon(new ImageIcon(resizedImage));
            cartButton.setFocusPainted(false);
            cartButton.setBackground(new Color(100,189,154));
            cartButton.addActionListener(al);

            jcart = new JLabel("0");
            jcart.setForeground(Color.BLACK);
            jcart.setBounds(1325,5,40,40);
            jcart.setFont(new Font("Times New Roman", Font.BOLD, 30));
            if(user.getCart() != null) {
                jcart.setText("" + user.getCart().size());
            }

        pTop.add(jTopIntro);
        pTop.add(menuButton);
        pTop.add(chatButton);
        pTop.add(cartButton);
        pTop.add(jcart);




        ArrayList<Item> items = FileOperationsOnItems.readAllFromFile();



        int itemsSize = items.size();
        System.out.println(itemsSize);
        int n;
        if(itemsSize<=6){
            n = 6;
        }
        else{
            n = (itemsSize/3)+1;
//            n = itemsSize;
        }

        pMiddle = new JPanel(new GridLayout(n,3,30,30));
        pMiddle.setBackground(Color.WHITE);

            for(int i = 0 ; i < itemsSize;i++){
                pItem = new JPanel(null);
                pItem.setBounds( new Rectangle(200,200));
                pItem.setBackground(Color.WHITE);
                pItem.setPreferredSize(new Dimension(200,200));
                    pItemInside = new JPanel(null);
                    pItemInside.setBounds(100, 2,200,200);
                    pItemInside.setBackground(Color.WHITE);
                //                    img = new ImageIcon(items.get(0).getImageLocation());
//                    System.out.println(items.get(0).getImageLocation());
                    jImage = new JLabel(img);
//                    jImage.setPreferredSize(new Dimension(150,150));


                    jImage.setSize(120,120);
                    f = new File(items.get(i).getImageLocation());
                    resizedImage = resizeImage(f,120,120);
                    jImage.setIcon(new ImageIcon(resizedImage));
                    jImage.setBounds(50,10,100,100);

//                    jImage.setBounds(10,10,100,100);

                    jName = new JLabel(items.get(i).getName());
                    jPrice = new JLabel("Price: "+items.get(i).getPrice());
                    jName.setBounds(80, 105,100,30);
                    jName.setFont(new Font("Times New Roman", Font.BOLD, 20));;
                    jPrice.setBounds(60, 120,100,30);
                    jPrice.setFont(new Font("Times New Roman", Font.BOLD, 18));

                    buyButton = new JButton("Buy");
                    buyButton.setBounds(50,150 , 100,40);
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
        jScrollPane.setBounds(100,100,1380,750);
        jScrollPane.setBorder(new EmptyBorder(30,30,30,30));
        jScrollPane.setBackground(Color.white);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(pTop);
        add(jScrollPane);


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }


    public class MyActionListener implements ActionListener{


        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equals("Cart")){

                new Cart(user);
            }
            else if(e.getActionCommand().equals("Chat")){

            }


            else if(e.getActionCommand().equals("Menu")){
                new Menu(user);
                dispose();

            }


            else if(e.getActionCommand().equals("Buy")){
                new AddToCart(user);
                dispose();
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
