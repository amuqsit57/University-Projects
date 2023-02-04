package Costumer;

import FileOperations.FileOperationsOnLoginAndSignup;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Edit extends JFrame {
    JPanel p1;

    JButton submit;

    JLabel jName1,jName,jgender,jaddress,jMembership,jUserName,jPassword;
    JTextField tName1,tName,tgender,taddress,tMembership,tUserName,tPassword;
    public Edit(){

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        Border blackline = BorderFactory.createRaisedSoftBevelBorder();

        p1 =new JPanel(null);
        p1.setBounds(130,150,300,500);
        p1.setBackground(new Color(2,200,100));
        p1.setBorder(blackline);


        jName1 = new JLabel("Search Name");
        jName1.setBounds(10,40,100,30);

        tName1 = new JTextField();
        tName1.setBounds(140,40,150,30);


        jName = new JLabel("New Name");
        jName.setBounds(10,80,100,30);


        tName = new JTextField();
        tName.setBounds(140,80,150,30);

        jaddress = new JLabel("New Address");
        jaddress.setBounds(10,120,100,30);

        taddress = new JTextField();
        taddress.setBounds(140,120,150,30);


        jgender = new JLabel("New Gender");
        jgender.setBounds(10,160,100,30);

        tgender = new JTextField();
        tgender.setBounds(140,160,150,30);


        jMembership = new JLabel("New Membership");
        jMembership.setBounds(10,200,100,30);

        tMembership = new JTextField();
        tMembership.setBounds(140,200,150,30);


        jUserName = new JLabel("New Username");
        jUserName.setBounds(10,240,100,30);

        tUserName = new JTextField();
        tUserName.setBounds(140,240,150,30);


        jPassword = new JLabel("New Password");
        jPassword.setBounds(10,280,100,30);

        tPassword = new JTextField();
        tPassword.setBounds(140,280,150,30);

        MyActionListener al =new MyActionListener();

        submit = new JButton("Edit Info");
        submit.addActionListener(al);
        submit.setBounds(100,350,100,50);
        submit.setFocusPainted(false);
        submit.setBackground(Color.WHITE);


        p1.add(jName1);
        p1.add(tName1);


        p1.add(jName);
        p1.add(tName);

        p1.add(jaddress);
        p1.add(taddress);

        p1.add(jgender);
        p1.add(tgender);

        p1.add(jMembership);
        p1.add(tMembership);

        p1.add(jUserName);
        p1.add(tUserName);

        p1.add(jPassword);
        p1.add(tPassword);


        p1.add(submit);

        add(p1);






        setSize(700,800);
        setVisible(true);
    }




    public class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equals("Edit Info")){

                if(!(tUserName.getText().equals(""))){
                    if(!(FileOperationsOnLoginAndSignup.searchUsername(tUserName.getText()))) {
                        FileOperationsOnLoginAndSignup.editUserName(tName1.getText(),tUserName.getText());
                        JOptionPane.showMessageDialog(null,"User Name entered Successfull");

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"User Name Already Exist");
                    }
                }
                if(!(tName.getText().equals(""))){
                        FileOperationsOnLoginAndSignup.editName(tName1.getText(),tName.getText());

                    JOptionPane.showMessageDialog(null,"Name entered Successfull");
                }

                if(!(taddress.getText().equals(""))){
                    FileOperationsOnLoginAndSignup.editAddress(tName1.getText(),taddress.getText());


                    JOptionPane.showMessageDialog(null,"Address entered Successfull");
                }

                if(!(tgender.getText().equals(""))){
                    FileOperationsOnLoginAndSignup.editGender(tName1.getText(),tgender.getText());

                    JOptionPane.showMessageDialog(null,"Gender entered Successfull");
                }

                if(!(tMembership.getText().equals(""))){
                    FileOperationsOnLoginAndSignup.editMembership(tName1.getText(),tMembership.getText());
                    JOptionPane.showMessageDialog(null,"Membership entered Successfull");

                }

                if(!(tPassword.getText().equals(""))){
                    FileOperationsOnLoginAndSignup.editPassword(tName1.getText(),tPassword.getText());
                    JOptionPane.showMessageDialog(null,"Password entered Successfull");

                }

                dispose();
            }
        }

    }


}
