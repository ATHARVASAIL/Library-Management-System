package Library_management_system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Book_Search extends JFrame implements ActionListener
{

    JLabel l1,l2;
    JTextField Book_ID,Book_Title;
    JButton Search1,Search2,Done,Refresh;
    Font fLabel = new Font("Tahoma", Font.PLAIN,15);
    JScrollPane sp;
    JTable table;
    Book_Search()
    {
        setSize(1000,500);
        setLocation(300,200);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/LMS5.jpg"));//adding image to frame
        JLabel image= new JLabel(i1);
        image.setBounds(0,0,1000,500);
        add(image);

        //JLabel
        l1 = new JLabel("BOOK_ID :");
        l1.setBounds(60,40,140,30);
        l1.setForeground(Color.black);
        l1.setFont(fLabel);
        image.add(l1);

        l2 = new JLabel("BOOK_TITLE :");
        l2.setBounds(530,40,140,30);
        l2.setForeground(Color.black);
        l2.setFont(fLabel);
        image.add(l2);

        //JTextfield
        Book_ID = new JTextField();
        Book_ID.setBounds(150,40,150,30);
        image.add(Book_ID);

        Book_Title = new JTextField();
        Book_Title.setBounds(650,40,150,30);
        image.add(Book_Title);

        //ScrollPane code
        sp =new JScrollPane();
        sp.setBounds(80,100,800,250);
        image.add(sp);

        table = new JTable();
        table.setBounds(80,100,800,250);
        sp.setViewportView(table);

        //JButton
        Search1 = new JButton("SEARCH");
        Search1.setBounds(320,40,130,30);
        Search1.addActionListener(this);
        image.add(Search1);

        Search2 = new JButton("SEARCH");
        Search2.setBounds(820,40,130,30);
        Search2.addActionListener(this);
        image.add(Search2);

        Done =new JButton("DONE");
        Done.setBounds(400,380,130,30);
        Done.addActionListener(this);
        image.add(Done);

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
            conn c = new conn();
            String str = "select * from book_details;";
            ResultSet rs = c.s.executeQuery(str);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Search1)
        {
            String BOOK_ID = this.Book_ID.getText();
            conn c=new conn();
            try{
                String str="select * from book_details where BOOK_ID = '"+BOOK_ID+"';";
                ResultSet rs1 = c.s.executeQuery(str);
                table.setModel(DbUtils.resultSetToTableModel(rs1));
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        if(ae.getSource()==Search2)
        {
            String BOOK_TITLE = this.Book_Title.getText();
            conn c=new conn();
            try{
                String str="select * from book_details where BOOK_TITLE = '"+BOOK_TITLE+"';";
                ResultSet rs1 = c.s.executeQuery(str);
                table.setModel(DbUtils.resultSetToTableModel(rs1));
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==Done)
        {
            setVisible(false);
        }
        else if(ae.getSource()==Refresh)
        {
            Display_Original();
        }
    }

    public static void main(String[] args)
    {
        new Book_Search();
    }
}
