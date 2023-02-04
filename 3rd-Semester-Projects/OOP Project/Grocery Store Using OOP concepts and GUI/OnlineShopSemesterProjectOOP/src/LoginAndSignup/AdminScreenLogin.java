package LoginAndSignup;

import FileOperations.FileOperationsOnAdmin;
import Manager.AdminScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AdminScreenLogin extends JFrame {


    JPanel p1,p2;
    JLabel jname,jUserName,jPassword,juserNameIcon,jPasswordIcon;
    JPasswordField jPasswordField;
    JTextField tUserName;


    JButton login,signup,admin;

    Image resizedImage;

    File f;



    public AdminScreenLogin(){

        setLayout(null);
        getContentPane().setBackground(Color.CYAN);

        Border blackline = BorderFactory.createRaisedSoftBevelBorder();

        f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\Grocery image.png");
        resizedImage = resizeImage(f,570,300);
        jname = new JLabel(new ImageIcon(resizedImage));
        jname.setBounds(500,50,570,300);


        p1 =new JPanel(null);
        p1.setBounds(630,300,300,80);
        p1.setBackground(new Color(2,200,100));
        p1.setBorder(blackline);
        jUserName = new JLabel("User Name");
        jUserName.setBounds(10,20,100,20);

        tUserName = new JTextField();
        tUserName.setBounds(100,20,150,20);



        f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\username.png");
        resizedImage = resizeImage(f,20,20);
        juserNameIcon = new JLabel(new ImageIcon(resizedImage));
        juserNameIcon.setBounds(270,20,20,20);

        p1.add(jUserName);
        p1.add(tUserName);
        p1.add(juserNameIcon);

        p2 =new JPanel(null);
        p2.setBounds(630,400,300,80);
        p2.setBackground(new Color(230,230,80));
        p2.setBorder(blackline);

        jPassword = new JLabel("Password");
        jPassword.setBounds(10,20,100,20);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(100,20,150,20);



        f = new File("C:\\Users\\abdul\\OneDrive\\Desktop\\Oop Semester project files\\password.png");
        resizedImage = resizeImage(f,20,20);
        jPasswordIcon = new JLabel(new ImageIcon(resizedImage));
        jPasswordIcon.setBounds(270,20,20,20);

        p2.add(jPassword);
        p2.add(jPasswordField);
        p2.add(jPasswordIcon);

        MyActionListener al = new MyActionListener();


        admin = new JButton("Admin");
        admin.setBounds(710,500,150,50);
        admin.addActionListener(al);

        signup = new JButton("Sign Up");
        signup.setBounds(620,600,150,50);
        signup.addActionListener(al);

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



    public class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equals("Log In")){
                new LoginScreenUser();
                dispose();
            }
            else if(e.getActionCommand().equals("Admin")){

                if((FileOperationsOnAdmin.searchUsername(tUserName.getText()))&&(FileOperationsOnAdmin.searchpassword(new String(jPasswordField.getPassword())))){
                            new AdminScreen();
                }
            }
            else if(e.getActionCommand().equals("Sign Up")){
                new SignupScreenUser();
                dispose();
            }


        }


    }


}
