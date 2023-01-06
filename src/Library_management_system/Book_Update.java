package Library_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Book_Update extends JFrame implements ActionListener
{
    JTable table;
    JScrollPane sp1;
    JLabel l1,l2;
    JButton Search1,Search2,Update,Delete,Cancel,Refresh;
    JTextField Book_Title,Book_ID;
    Font fLabel = new Font("Tahoma", Font.PLAIN,15);
    public static String BOOK_ID;
    public static String BOOK_TITLE;
    public static String AUTHOR_NAME;
    public static String COST;
    public static String QUANTITY;
    int row;
    Book_Update()
    {
        setSize(1000,500);
        setLocation(300,200);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/LMS5.jpg"));//adding image to frame
        JLabel image= new JLabel(i1);
        image.setBounds(0,0,1000,500);
        add(image);

        l1 = new JLabel("BOOK_ID:");
        l1.setBounds(60,40,140,30);
        l1.setForeground(Color.black);
        l1.setFont(fLabel);
        image.add(l1);

        l2 = new JLabel("BOOK_TITLE:");
        l2.setBounds(530,40,140,30);
        l2.setForeground(Color.black);
        l2.setFont(fLabel);
        image.add(l2);

        Book_ID = new JTextField();
        Book_ID.setBounds(150,40,150,30);
        image.add(Book_ID);

        Book_Title = new JTextField();
        Book_Title.setBounds(650,40,150,30);
        image.add(Book_Title);

        sp1 = new JScrollPane();
        sp1.setBounds(80,100,800,250);
        image.add(sp1);

        table = new JTable();
        table.setBounds(80,100,800,250);
        sp1.setViewportView(table);

        Search1 = new JButton("SEARCH");
        Search1.setBounds(320,40,130,30);
        Search1.addActionListener(this);
        image.add(Search1);

        Search2 = new JButton("SEARCH");
        Search2.setBounds(820,40,130,30);
        Search2.addActionListener(this);
        image.add(Search2);

        Update = new JButton("UPDATE");
        Update.setBounds(150,380,130,40);
        Update.addActionListener(this);
        image.add(Update);

        Delete = new JButton("DELETE");
        Delete.setBounds(420,380,130,40);
        Delete.addActionListener(this);
        image.add(Delete);

        Cancel = new JButton("CANCEL");
        Cancel.setBounds(700,380,130,40);
        Cancel.addActionListener(this);
        image.add(Cancel);

        ImageIcon i2= new ImageIcon(ClassLoader.getSystemResource("icons/Refresh.png"));//adding image to frame
        Image i3 =i2.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        ImageIcon i4 =new ImageIcon(i3);
        Refresh =new JButton(i4);
        Refresh.setBounds(880,310,40,40);
        Refresh.addActionListener(this);
        image.add(Refresh);

        Display_Original();

        setLayout(null);
        setVisible(true);
    }

    void Display_Original()
    {
        try
        {
            conn c=new conn();

            ResultSet rs=c.s.executeQuery("SELECT * FROM book_details");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    void TableSelected(){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row =table.getSelectedRow();
                BOOK_ID = table.getModel().getValueAt(row, 0).toString();
                BOOK_TITLE= table.getModel().getValueAt(row,1).toString();
                AUTHOR_NAME = table.getModel().getValueAt(row , 2).toString();
                COST = table.getModel().getValueAt(row , 3).toString();
                QUANTITY = table.getModel().getValueAt(row , 4).toString();
            }
        });
    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==Search1)
        {
            String book_id = this.Book_ID.getText();
            conn c=new conn();
            try
            {
                String str1 = "select * from book_details where BOOK_ID = '"+book_id+"';";
                ResultSet rs = c.s.executeQuery(str1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        if (ae.getSource()==Search2)
        {
            String book_title = this.Book_Title.getText();
            conn c=new conn();
            try
            {
                String str2 = "select * from book_details where BOOK_TITLE = '"+book_title+"';";
                ResultSet rs = c.s.executeQuery(str2);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        if(ae.getSource()==Update)
        {
            TableSelected();
            new Book_Details();
        }
        if(ae.getSource()==Cancel)
        {
            setVisible(false);
        }
        if(ae.getSource()==Refresh)
        {
            Display_Original();
        }
        if(ae.getSource()==Delete)
        {
            TableSelected();
            try {
            conn c= new conn();
            String book_id =this.BOOK_ID.toString();
            String str1="delete from book_details where BOOK_ID = '"+book_id+"';";
            c.s.executeUpdate(str1);
            JOptionPane.showMessageDialog(null, "Data Has Been Successfully Deleted From Database!!");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

    }
    public static void main(String[] args)
    {
        new Book_Update();
    }

}

