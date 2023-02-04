package Costumer;

import Classes.Item;
import Classes.User;
import FileOperations.FileOperationsOnItems;
import FileOperations.FileOperationsOnLoginAndSignup;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class OrderHistory extends JFrame {

    JPanel pMain,p1,pOrderNo,pBill;

    JLabel jName,jImage,jQuantity,jPrice,jPriceOfOneItem,jTotalBill,jOrderNo;

    Image resizedImage;

    JButton home;
    File f;

    User user;

    OrderHistory(User user){
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


        int OrdersSize = user.getOrders().size();
        System.out.println(OrdersSize);

        int n=0;
        for(int i = 0 ; i < OrdersSize;i++){

            n = n +(user.getOrders().get(i).size());
        }
        n = n+n*(user.getOrders().size()*2);


        pMain = new JPanel(new GridLayout(n, 1, 20, 20));
        pMain.setBounds(100, 100, 300, 600);

        for(int j = 0 ; j < OrdersSize;j++) {






            pOrderNo = new JPanel(null);
            pOrderNo.setPreferredSize(new Dimension(300, 50));
            pOrderNo.setBackground(Color.orange);

                //initialize label for the orderno
                jOrderNo = new JLabel();
                jOrderNo.setBounds(150,20,100,20);
                jOrderNo.setText("Order No: "+j);


            pOrderNo.add(jOrderNo);

            pMain.add(pOrderNo);

            jTotalBill = new JLabel();
            jTotalBill.setText("0");
            jTotalBill.setBounds(400, 650, 100, 20);


            int cartSize = user.getOrders().get(j).size();

            int totalBill = 0;
            for (int i = 0; i < cartSize; i++) {

                p1 = new JPanel(null);
                p1.setPreferredSize(new Dimension(300, 100));
                p1.setBackground(Color.yellow);

                Item item = user.getOrders().get(j).get(i);

                jImage = new JLabel();
                f = new File(item.getImageLocation());
                resizedImage = resizeImage(f, 80, 80);
                jImage.setIcon(new ImageIcon(resizedImage));
                jImage.setBounds(10, 10, 80, 80);

                jName = new JLabel(item.getName());
                jName.setBounds(190, 10, 100, 20);

                jPrice = new JLabel("Price: " + item.getPrice());
                jPrice.setBounds(100, 40, 100, 20);

                jQuantity = new JLabel("Quantity: " + item.getUserQuantity());
                jQuantity.setBounds(100, 60, 100, 20);

                int priceOfOneItem = item.getPrice() * item.getUserQuantity();
                jPriceOfOneItem = new JLabel("T Price " + (priceOfOneItem) + " RS");
                jPriceOfOneItem.setBounds(260, 80, 100, 20);

                totalBill = totalBill + priceOfOneItem;

                p1.add(jName);
                p1.add(jPrice);
                p1.add(jImage);
                p1.add(jQuantity);
                p1.add(jPriceOfOneItem);

                pMain.add(p1);


            }

            pBill = new JPanel(null);
            pBill.setPreferredSize(new Dimension(300,100));
            pBill.setBackground(Color.CYAN);

                jTotalBill.setText("Bill: " + totalBill + " RS");
                jTotalBill.setBounds(250,30,100,30);

            pBill.add(jTotalBill);
            pMain.add(pBill);
        }
        JScrollPane jScrollPane = new JScrollPane(pMain);
        jScrollPane.setBounds(100,50,380,600);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        add(jScrollPane);

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

        public void actionPerformed(ActionEvent e) {


            if (e.getActionCommand().equals("Home")) {
                dispose();
                new HomeScreen(user);

            }
        }
    }

}
