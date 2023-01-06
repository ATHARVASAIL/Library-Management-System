package Library_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_Dashboard extends JFrame implements ActionListener
{
    Admin_Dashboard ()
    {
     setBounds(0,0,1540,820);

     //Background Image
     ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/LMS_DB.jpg"));//adding image to frame
     Image i2 = i1.getImage().getScaledInstance(1540,820,Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image= new JLabel(i3);
     image.setBounds(0,0,1540,820);
     add(image);

     //Label
     JLabel text = new JLabel("WELCOME TO TECHNO LIBRARY");//adding label
     text.setBounds(400, 80, 1000, 90);
     text.setForeground(Color.white);
     text.setFont(new Font("serif",Font.PLAIN,50));
     image.add(text);

     //MenuBar
     JMenuBar mb = new JMenuBar();
     mb.setBounds(0,0,1525,40);
     mb.setBorder(BorderFactory.createLineBorder(Color.black,1));
     mb.setBackground(Color.white);
     image.add(mb);

     //STUDENT MENU
     JMenu s = new JMenu("STUDENTS" );
     s.setForeground(Color.black);
     s.setBorder(BorderFactory.createLineBorder(Color.black,1));
     s.setFont(new Font("serif",Font.PLAIN,15));
     mb.add(s);

     //BOOKS MENU
     JMenu b = new JMenu("BOOKS" );
     b.setForeground(Color.black);
     b.setBorder(BorderFactory.createLineBorder(Color.black,1));
     b.setFont(new Font("serif",Font.PLAIN,15));
     mb.add(b);

     //ORDERS MENU
     JMenu o = new JMenu("ORDERS" );
     o.setForeground(Color.black);
     o.setBorder(BorderFactory.createLineBorder(Color.black,1));
     o.setFont(new Font("serif",Font.PLAIN,15));
     mb.add(o);

     //ADMIN MENU
     JMenu a = new JMenu("ADMIN" );
     a.setForeground(Color.black);
     a.setBorder(BorderFactory.createLineBorder(Color.black,1));
     a.setFont(new Font("serif",Font.PLAIN,15));
     mb.add(Box.createHorizontalGlue());
     mb.add(a);

     //MenuItems
     JMenuItem NS =new JMenuItem("NEW STUDENT");
     NS.addActionListener(this);
     s.add(NS);

     JMenuItem SD =new JMenuItem("STUDENT DETAILS");
     SD.addActionListener(this);
     s.add(SD);

     JMenuItem AB =new JMenuItem("ADD BOOKS");
     AB.addActionListener(this);
     b.add(AB);

     JMenuItem BS =new JMenuItem("BOOK SEARCH");
     BS.addActionListener(this);
     b.add(BS);

     JMenuItem BU =new JMenuItem("BOOK DETAILS");
     BU.addActionListener(this);
     b.add(BU);

     JMenuItem VO =new JMenuItem("VIEW ORDERS");
     VO.addActionListener(this);
     o.add(VO);

     JMenuItem RS =new JMenuItem("RETURN BOOK");
     RS.addActionListener(this);
     o.add(RS);

     JMenuItem LO =new JMenuItem("LOG OUT");
     LO.addActionListener(this);
     a.add(LO);

     setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
     if(ae.getActionCommand().equals("NEW STUDENT"))
     {
      new New_Student();
     }
     else if(ae.getActionCommand().equals("STUDENT DETAILS"))
     {
      new Student_Update();
     }
     else if (ae.getActionCommand().equals("ADD BOOKS"))
     {
      new Add_Books();
     }
     else if (ae.getActionCommand().equals("BOOK SEARCH"))
     {
      new Book_Search();
     }
     else if (ae.getActionCommand().equals("BOOK DETAILS"))
     {
      new Book_Update();
     }
     else if(ae.getActionCommand().equals("VIEW ORDERS"))
     {
      new View_Order();
     }
     else if(ae.getActionCommand().equals("RETURN BOOK"))
     {
      new Return_Book();
     }
     else if (ae.getActionCommand().equals("LOG OUT"))
     {
      setVisible(false);
      new LMS();
     }
    }

    public static void main(String args[])
    {
       new Admin_Dashboard();
    }
}
