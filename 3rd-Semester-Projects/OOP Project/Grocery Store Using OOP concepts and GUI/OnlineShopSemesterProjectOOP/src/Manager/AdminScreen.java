package Manager;

import Manager.AddItems;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminScreen extends JFrame {


    JButton addItem;
    JButton removeItem;
    JButton updateItem;
    JButton availableItem;

    JButton inventory;




    public AdminScreen(){

        setLayout(new BorderLayout());

//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        add(new JButton("Button1"), gbc);
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.gridwidth = 2;
//
//        add(new JButton("Button2"), gbc);

        addItem = new JButton("Add Items");
        removeItem = new JButton("Remove Items");
        updateItem = new JButton("Update Items");
        availableItem = new JButton("Available Items");
        inventory = new JButton("Inventory");

        //creating action listener
        myActionListener al = new myActionListener();

        //adding styles to the button
        addItem.setBorder(new RoundedBorder(30));
        addItem.setFocusPainted(false);
        addItem.setOpaque(true);
        addItem.setBackground(new Color(0, 163, 136));
        addItem.setPreferredSize(new Dimension(200, 50));
        addItem.addActionListener(al);

        removeItem.setBorder(new RoundedBorder(30));
        removeItem.setFocusPainted(false);
        removeItem.setOpaque(true);
        removeItem.setBackground(new Color(0, 163, 136));
        removeItem.setPreferredSize(new Dimension(200, 50));
        removeItem.addActionListener(al);

        updateItem.setBorder(new RoundedBorder(30));
        updateItem.setFocusPainted(false);
        updateItem.setOpaque(true);
        updateItem.setBackground(new Color(0, 163, 136));
        updateItem.setPreferredSize(new Dimension(200, 50));
        updateItem.addActionListener(al);

        availableItem.setBorder(new RoundedBorder(30));
        availableItem.setFocusPainted(false);
        availableItem.setOpaque(true);
        availableItem.setBackground(new Color(0, 163, 136));
        availableItem.setPreferredSize(new Dimension(200, 50));
        availableItem.addActionListener(al);

        inventory.setBorder(new RoundedBorder(30));
        inventory.setFocusPainted(false);
        inventory.setOpaque(true);
        inventory.setBackground(new Color(0, 163, 136));
        inventory.setPreferredSize(new Dimension(200, 50));
        inventory.addActionListener(al);

        JPanel pane = new JPanel();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.VERTICAL;
        c.gridwidth = 2;

        c.gridx = 0;
        c.gridy = 0;

        c.insets = new Insets(20,0,0,0);

        pane.add(addItem, c);
        c.gridy = 1;
        pane.add(removeItem, c);
        c.gridy = 2;
        pane.add(updateItem, c);
        c.gridy = 3;
        pane.add(availableItem, c);
        c.gridy = 4;
        pane.add(inventory, c);

        pane.setBackground(new Color(200,20,1));

        add(pane,BorderLayout.CENTER);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);


    }

    public class myActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){

            if(e.getActionCommand().equals("Add Items")){
                dispose();
                new AddItems();

            }
            else if(e.getActionCommand().equals("Remove Items")){
                    new RemoveItem();
                    dispose();
            }
            else if(e.getActionCommand().equals("Update Items")){
                    new UpdateItem();
                dispose();
            }
            else if(e.getActionCommand().equals("Available Items")){
                    new AvailableItems();
                dispose();
            }
            else if(e.getActionCommand().equals("Inventory" )){

                new Inventory();
                dispose();
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

}
