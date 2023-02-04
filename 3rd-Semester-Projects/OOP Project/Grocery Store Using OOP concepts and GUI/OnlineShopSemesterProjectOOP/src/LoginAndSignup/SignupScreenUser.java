package LoginAndSignup;

import Classes.User;
import Costumer.HomeScreen;
import FileOperations.FileOperationsOnLoginAndSignup;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SignupScreenUser extends JFrame {


    JPanel p1,p2;
    JLabel jname,jUserName,jPassword,juserNameIcon,jPasswordIcon;
    JLabel jName,jgender,jaddress,jMembership;
    JTextField tName,tgender,taddress,tMembership;



    JPasswordField jPasswordField;
    JTextField tUserName;


    JButton login,signup,admin;

    Image resizedImage;

    File f;



    public SignupScreenUser(){

        setLayout(null);
        getContentPane().setBackground(Color.CYAN);

        Border blackline = BorderFactory.createRaisedSoftBevelBorder();


        f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\Grocery image.png");
        resizedImage = resizeImage(f,470,200);
        jname = new JLabel(new ImageIcon(resizedImage));
        jname.setBounds(500,20,470,200);


        p1 =new JPanel(null);
        p1.setBounds(630,150,300,200);
        p1.setBackground(new Color(2,200,100));
        p1.setBorder(blackline);


            jName = new JLabel("Name");
            jName.setBounds(10,20,100,20);

            tName = new JTextField();
            tName.setBounds(100,20,150,20);

            jaddress = new JLabel("Address");
            jaddress.setBounds(10,64,100,20);

            taddress = new JTextField();
            taddress.setBounds(100,64,150,20);


            jgender = new JLabel("Gender");
            jgender.setBounds(10,100,100,20);

            tgender = new JTextField();
            tgender.setBounds(100,100,150,20);


            jMembership = new JLabel("Membership");
            jMembership.setBounds(10,150,100,20);

            tMembership = new JTextField();
            tMembership.setBounds(100,150,150,20);

        p1.add(jName);
        p1.add(tName);

        p1.add(jaddress);
        p1.add(taddress);

        p1.add(jgender);
        p1.add(tgender);

        p1.add(jMembership);
        p1.add(tMembership);



        p2 =new JPanel(null);
        p2.setBounds(630,400,300,80);
        p2.setBackground(new Color(230,230,80));
        p2.setBorder(blackline);

        jUserName = new JLabel("User Name");
        jUserName.setBounds(10,20,100,20);

        tUserName = new JTextField();
        tUserName.setBounds(100,20,150,20);



        f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\username.png");
        resizedImage = resizeImage(f,20,20);
        juserNameIcon = new JLabel(new ImageIcon(resizedImage));
        juserNameIcon.setBounds(270,20,20,20);



        jPassword = new JLabel("Password");
        jPassword.setBounds(10,50,100,20);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(100,50,150,20);



        f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\password.png");
        resizedImage = resizeImage(f,20,20);
        jPasswordIcon = new JLabel(new ImageIcon(resizedImage));
        jPasswordIcon.setBounds(270,50,20,20);

        p2.add(jUserName);
        p2.add(tUserName);
        p2.add(juserNameIcon);


        p2.add(jPassword);
        p2.add(jPasswordField);
        p2.add(jPasswordIcon);




        MyActionListener al = new MyActionListener();


        signup = new JButton("Sign Up");
        signup.setBounds(710,500,150,50);
        signup.addActionListener(al);

        admin = new JButton("Admin");
        admin.setBounds(620,600,150,50);
        admin.addActionListener(al);

        login = new JButton("Log In");
        login.setBounds(800,600,150,50);
        login.addActionListener(al);

        login.setBackground(Color.WHITE);
        admin.setBackground(Color.WHITE);
        signup.setBackground(Color.WHITE);



        add(jname);
        add(p1);
        add(p2);
        add(login);
        add(signup);
        add(admin);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
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

    public class MyActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equals("Log In")){
                new LoginScreenUser();
                dispose();
            }
            else if(e.getActionCommand().equals("Admin")){
                new AdminScreenLogin();
                dispose();
            }
            else if(e.getActionCommand().equals("Sign Up")){

                if(FileOperationsOnLoginAndSignup.searchUsername(tUserName.getText())){
                    JOptionPane.showMessageDialog(null,"UserName already exists");
                }
                else {

                    User user = new User(tName.getText(), tgender.getText(), taddress.getText(), Boolean.parseBoolean(tMembership.getText()), tUserName.getText(), new String(jPasswordField.getPassword()));

                    FileOperationsOnLoginAndSignup.writeToFile(user);

                    new HomeScreen(user);
                    dispose();

                }
            }


        }


    }

}
