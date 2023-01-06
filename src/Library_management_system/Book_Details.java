package Library_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Book_Details extends JFrame implements ActionListener {
    JLabel l1 , l2 ,l3 ,l4 ,l5 ,l6 ,l7 ,l8 ;
    JTextField COST,QUANTITY;
    Font fLabel = new Font("Tahoma", Font.PLAIN,15);
    JButton update,cancel;
    int labX=60;
    int labH=50;
    int labW=140;
    int txtX = 220;
    int txtW=200;
    int txth=40;
    String Cost,Quantity;
    Book_Details(){
        setSize(500,500);
        setLocation(500,200);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/LMS6.jpg"));//adding image to frame
        Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,500,500);
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

        l6 = new JLabel(Book_Update.BOOK_ID);
        l6.setBounds(txtX,40,txtW,txth);
        l6.setForeground(Color.WHITE);
        l6.setFont(fLabel);
        image.add(l6);

        l7 = new JLabel(Book_Update.BOOK_TITLE);
        l7.setBounds(txtX,100,txtW,txth);
        l7.setForeground(Color.WHITE);
        l7.setFont(fLabel);
        image.add(l7);

        l8 = new JLabel(Book_Update.AUTHOR_NAME);
        l8.setBounds(txtX,160,txtW,txth);
        l8.setForeground(Color.WHITE);
        l8.setFont(fLabel);
        image.add(l8);

        //text fields
        COST = new JTextField(Book_Update.COST);
        COST.setBounds(txtX,220,txtW,txth);
        image.add(COST);

        QUANTITY = new JTextField(Book_Update.QUANTITY);
        QUANTITY.setBounds(txtX,280,txtW,txth);
        image.add(QUANTITY);

        //JButtons
        update = new JButton("UPDATE");
        update.setBounds(90,390,120,40);
        update.addActionListener(this);
        image.add(update);

        cancel = new JButton("CANCEL");
        cancel.setBounds(280,390,120,40);
        cancel.addActionListener(this);
        image.add(cancel);

        setLayout(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            Cost = this.COST.getText();
            Quantity = this.QUANTITY.getText();

            conn c = new conn();
            try
            {
                String str1 = "update book_details set COST = '"+Cost+"', QUANTITY = '"+Quantity+"' where  BOOK_ID = '"+Book_Update.BOOK_ID+"' ; ";
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null," Data Updated Successfully!");
                this.l6.setText(null);
                this.l7.setText(null);
                this.l8.setText(null);
                this.COST.setText(null);
                this.QUANTITY.setText(null);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if (ae.getSource()==cancel)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Book_Details();
    }
}

