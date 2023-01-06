package Library_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Add_Books extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5;
    JButton add,cancel;
    JTextField BOOK_ID,BOOK_TITLE,AUTHOR_NAME,COST,QUANTITY;
    Font fLabel = new Font("Tahoma", Font.PLAIN,19);
    int labX=60;
    int labH=50;
    int labW=140;
    int txtX = 220;
    int txtW=150;
    int txth=40;

    Add_Books()
    {
        setSize(500,500);
        setLocation(500,200);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/Details pic.jpeg"));//adding image to frame
        Image i2 = i1.getImage().getScaledInstance(500,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,500,600);
        add(image);

        //labels
        l1 = new JLabel("BOOK_ID:");
        l1.setBounds(labX,40,labW,labH);
        l1.setForeground(Color.WHITE);
        l1.setFont(fLabel);
        image.add(l1);

        l2 = new JLabel("BOOK_TITLE:");
        l2.setBounds(labX,100,labW,labH);
        l2.setForeground(Color.WHITE);
        l2.setFont(fLabel);
        image.add(l2);

        l3 = new JLabel("AUTHOR_NAME:");
        l3.setBounds(labX,160,labW,labH);
        l3.setForeground(Color.WHITE);
        l3.setFont(fLabel);
        image.add(l3);

        l4 = new JLabel("COST:");
        l4.setBounds(labX,220,labW,labH);
        l4.setForeground(Color.WHITE);
        l4.setFont(fLabel);
        image.add(l4);

        l5 = new JLabel("QUANTITY:");
        l5.setBounds(labX,280,labW,labH);
        l5.setForeground(Color.WHITE);
        l5.setFont(fLabel);
        image.add(l5);

        //text fields
        BOOK_ID = new JTextField();
        BOOK_ID.setBounds(txtX,40,txtW,txth);
        image.add(BOOK_ID);

        BOOK_TITLE = new JTextField();
        BOOK_TITLE.setBounds(txtX,100,txtW,txth);
        image.add(BOOK_TITLE);

        AUTHOR_NAME = new JTextField();
        AUTHOR_NAME.setBounds(txtX,160,txtW,txth);
        image.add(AUTHOR_NAME);

        COST = new JTextField();
        COST.setBounds(txtX,220,txtW,txth);
        image.add(COST);

        QUANTITY = new JTextField();
        QUANTITY.setBounds(txtX,280,txtW,txth);
        image.add(QUANTITY);

        //button
        add = new JButton("ADD");
        add.setBounds(80,380,130,40);
        add.addActionListener(this);
        image.add(add);

        cancel = new JButton("CANCEL");
        cancel.setBounds(260,380,130,40);
        cancel.addActionListener(this);
        image.add(cancel);

        setLayout(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == add)
        {
            try
            {
                String BOOK_ID = this.BOOK_ID.getText();
                String BOOK_TITLE = this.BOOK_TITLE.getText();
                String AUTHOR_NAME = this.AUTHOR_NAME.getText();
                String COST = this.COST.getText();
                String QUANTITY = this.QUANTITY.getText();
                try
                {
                    conn c = new conn();
                    String str = "insert into book_details(BOOK_ID,BOOK_TITLE,AUTHOR_NAME,COST,QUANTITY) values('" + BOOK_ID + "','" + BOOK_TITLE + "','" + AUTHOR_NAME + "','" + COST + "','" + QUANTITY + "');";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Data Added Successfully!!");
                    this.BOOK_ID.setText(null);
                    this.BOOK_TITLE.setText(null);
                    this.AUTHOR_NAME.setText(null);
                    this.COST.setText(null);
                    this.QUANTITY.setText(null);

                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Book_id already exited!!");
                }
            }
                catch (NullPointerException e)
                {
                    JOptionPane.showMessageDialog(null, "Please enter whole data!!");
                }

        }
         else if (ae.getSource() == cancel)
         {
            setVisible(false);

        }
         else
        {
            this.BOOK_ID.setText(null);
            this.BOOK_TITLE.setText(null);
            this.AUTHOR_NAME.setText(null);
            this.COST.setText(null);
            this.QUANTITY.setText(null);
        }
    }
    public static void main(String[] args) {
        new Add_Books();
    }
}
