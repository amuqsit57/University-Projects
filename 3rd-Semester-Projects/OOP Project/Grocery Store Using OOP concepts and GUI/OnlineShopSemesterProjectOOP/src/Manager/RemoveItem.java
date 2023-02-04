package Manager;

import Classes.Item;
import FileOperations.FileOperationsOnItems;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class RemoveItem extends JFrame {

    JButton button;
    JPanel topPanelMain,topPanel,uploadPanel,middlePanel,temp,uploadTop, uploadBottom,buttonPanel,imagePanel;
    JLabel topLabel;
    ImageIcon topImage;

    JButton upload,submit;
    Image resizedImage;
    File f;

    JButton home;

    JLabel jAddItem,jName,jId,jPrice,jQuantity,jImage,jImageStatus;
    JTextField tName,tId,tPrice,tQuantity;

    public RemoveItem(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout(100,100));

//        //top panel
//        topPanelMain = new JPanel(new GridLayout(3,1));
        topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        topPanel.setPreferredSize(new Dimension(1920,150));
//        topPanel.setBounds(0,0,1920,100);


        //upload panel
        //Initialize data fields
        jAddItem = new JLabel("Remove Item");

        jName = new JLabel("Name");

        tName = new JTextField();

        //action listener
        MyActionListener al = new MyActionListener();

        //button properties
        submit = new JButton("Submit");
        submit.addActionListener(al);
        submit.setBounds(20,5,100,50);
        submit.setBorder(new RoundedBorder(30));
        submit.setFocusPainted(false);
        submit.setBackground(new Color(238,238,238));


        //data fields set properties
        jName.setHorizontalAlignment(2);

        //Button Panel

        buttonPanel = new JPanel(null);
        buttonPanel.setBounds(0,200,300,300);
        buttonPanel.add(submit);



        uploadTop = new JPanel(new GridLayout(1,1));
        uploadTop.add(jAddItem);

        uploadBottom = new JPanel(new GridLayout(4,2));
        uploadBottom.add(jName);
        uploadBottom.add(tName);


        uploadBottom.add(buttonPanel);


        uploadPanel = new JPanel(null);
        upload = new JButton("Upload");
        uploadPanel.setBackground(Color.WHITE);
        uploadPanel.setPreferredSize(new Dimension(400,500));
        //adding data fields in the panel


        uploadTop.setBounds(new Rectangle(50,10,300,100));
        uploadBottom.setBounds(new Rectangle(50,120,300,300));

        uploadTop.setBorder(new EmptyBorder(10,120,10,10));
        uploadBottom.setBorder(new EmptyBorder(10,10,10,10));

        topImage = new ImageIcon("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\addItemBackground.jpg");
        topLabel = new JLabel(topImage);
        topLabel.setPreferredSize(new Dimension(1920,200));
        topPanel.add(topLabel);


        uploadPanel.add(uploadTop);
        uploadPanel.add(uploadBottom);



        //middle panel
        middlePanel = new JPanel();
        middlePanel.add(uploadPanel);
        middlePanel.setBackground(Color.white);
        middlePanel.setPreferredSize(new Dimension(400,500));






//        topPanelMain.add(topPanel);
        add(topPanel,BorderLayout.NORTH);
        add(middlePanel,BorderLayout.CENTER);
//        add(temp,BorderLayout.SOUTH);
//        add(temp,BorderLayout.EAST);
//        add(temp,BorderLayout.WEST);

//        setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//
//
//        gbc.gridx =0;
//        gbc.gridy =0;
//
//        gbc.gridheight =1;
//        gbc.insets = new Insets(0,0,0,0);
//
//


//        topPanel = new JPanel(new FlowLayout());
//        topImage = new ImageIcon(selectedFile.getAbsolutePath());
//        topLabel = new JLabel(topImage);
//        topLabel.setPreferredSize(new Dimension(1920,200));
//        topPanel.add(topLabel);
//        topPanel.setPreferredSize(new Dimension(1920,200));
//
//        add(topPanel);

//        setExtendedState(JFrame.MAXIMIZED_BOTH);

        f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\home.png");
        resizedImage = resizeImage(f,20,20);
        home = new JButton(new ImageIcon(resizedImage));
        home.setBounds(15,10,35,35);
        home.setText("Home");
        home.addActionListener(al);
        home.setFocusPainted(false);
        home.setBackground(Color.BLACK);
        home.setForeground(Color.WHITE);

        setSize(700,800);
        setVisible(true);


    }

    public class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

          if(e.getActionCommand().equals("Submit")){
//                Item item  = new Item(tName.getText(),tId.getText(),Integer.parseInt(tPrice.getText()),Integer.parseInt(tQuantity.getText()),jImageStatus.getText());
                boolean   flag = FileOperationsOnItems.removeItem(tName.getText());
                if(flag) {
                    JOptionPane.showMessageDialog(null, "Item Removed Successfully");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Item not found ");

                }
          }
          else if (e.getActionCommand().equals("Home")) {
              dispose();
              new AdminScreen();
          }



        }


    }

    public class RoundedBorder implements Border {

        private int radius;


        RoundedBorder(int radius) {
            this.radius = radius;
        }


        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }


        public boolean isBorderOpaque() {
            return true;
        }


        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
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
