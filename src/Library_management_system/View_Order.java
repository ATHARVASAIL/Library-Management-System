package Library_management_system;

import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class View_Order extends JFrame implements ActionListener
{

    JLabel l1,l2,l3,l4;
    JTextField Book_id,Student_id;
    JDateChooser Issue_Date,Due_Date;
    JButton Search1,Search2,Issue_Book,Cancel,Refresh;
    Font fLabel = new Font("Tahoma", Font.PLAIN,15);
    JScrollPane sp;
    JTable table;
    public static String BOOK_ID;
    public static String BOOK_TITLE;
    public static String AUTHOR_NAME;
    public static String STUDENT_ID;
    public static String STUDENT_NAME;
    public static String CONTACT;
    int row;
    View_Order()
    {
        setSize(1000,450);
        setLocation(300,200);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/b12.jpg"));//adding image to frame
        Image i2 = i1.getImage().getScaledInstance(1000,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,1000,450);
        add(image);

        //JLabel
        l1 = new JLabel("BOOK_ID :");
        l1.setBounds(60,40,140,30);
        l1.setForeground(Color.white);
        l1.setFont(fLabel);
        image.add(l1);

        l2 = new JLabel("STUDENT_ID :");
        l2.setBounds(520,40,140,30);
        l2.setForeground(Color.white);
        l2.setFont(fLabel);
        image.add(l2);

        l3 = new JLabel("ISSUE_DATE:");
        l3.setBounds(150,240,140,30);
        l3.setForeground(Color.white);
        l3.setFont(fLabel);
        image.add(l3);

        l4 = new JLabel("DUE_DATE:");
        l4.setBounds(150,320,140,30);
        l4.setForeground(Color.white);
        l4.setFont(fLabel);
        image.add(l4);

        //JTextfield
        Book_id = new JTextField();
        Book_id.setBounds(170,40,150,30);
        image.add(Book_id);

        Student_id = new JTextField();
        Student_id.setBounds(650,40,150,30);
        image.add(Student_id);

        //JDateChooser
        Issue_Date = new JDateChooser();
        Issue_Date.setBounds(260, 240, 150, 30);
        image.add(Issue_Date);

        Due_Date = new JDateChooser();
        Due_Date.setBounds(260, 320, 150, 30);
        image.add(Due_Date);

        //ScrollPane code
        sp =new JScrollPane();
        sp.setBounds(80,100,800,100);
        image.add(sp);

        table = new JTable();
        table.setBounds(80,100,800,100);
        sp.setViewportView(table);

        //JButton
        Search1 = new JButton("SEARCH");
        Search1.setBounds(340,40,130,30);
        Search1.addActionListener(this);
        image.add(Search1);

        Search2 = new JButton("SEARCH");
        Search2.setBounds(820,40,130,30);
        Search2.addActionListener(this);
        image.add(Search2);

        Issue_Book =new JButton("ISSUE BOOK");
        Issue_Book.setBounds(600,240,130,30);
        Issue_Book.addActionListener(this);
        image.add(Issue_Book);

        Cancel =new JButton("CANCEL");
        Cancel.setBounds(600,320,130,30);
        Cancel.addActionListener(this);
        image.add(Cancel);

        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/Refresh.png"));//adding image to frame
        Image i5 =i4.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        ImageIcon i6 =new ImageIcon(i5);
        Refresh =new JButton(i6);
        Refresh.setBounds(880,160,40,40);
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
            String str = "select * from order_list;";
            ResultSet rs = c.s.executeQuery(str);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
            System.out.println(e);
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
                STUDENT_ID = table.getModel().getValueAt(row , 3).toString();
                STUDENT_NAME = table.getModel().getValueAt(row , 4).toString();
                CONTACT = table.getModel().getValueAt(row , 5).toString();
            }
        });
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Search1)
        {
            String Book_Id = this.Book_id.getText();
            conn c=new conn();
            try{
                String str="select * from order_list where Book_Id = '"+Book_Id+"';";
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
            String Student_Id = this.Student_id.getText();
            conn c=new conn();
            try{
                String str="select * from order_list where Student_Id = '"+Student_Id+"';";
                ResultSet rs1 = c.s.executeQuery(str);
                table.setModel(DbUtils.resultSetToTableModel(rs1));
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        if(ae.getSource()==Issue_Book)
        {
            TableSelected();
            try {
                String book_id = this.BOOK_ID.toString();
                String book_title = this.BOOK_TITLE.toString();
                String author_name = this.AUTHOR_NAME.toString();
                String student_id = this.STUDENT_ID.toString();
                String student_name = this.STUDENT_NAME.toString();
                String contact = this.CONTACT.toString();
                //for storing date
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String issue_date = dateFormat.format(this.Issue_Date.getDate());
                String due_date= dateFormat.format(this.Due_Date.getDate());
                conn c= new conn();
                String str = "insert into issued_books (Book_Id,Book_Title,Author_Name,Student_Id,Student_Name,Contact,Issue_Date,Due_Date) values('"+book_id+"','"+book_title+"','"+author_name+"','"+student_id+"','"+student_name+"','"+contact+"','"+issue_date+"','"+due_date+"');";
                String str1="delete from order_list where Student_Id = '"+STUDENT_ID+"';";
                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "Data Added Successfully!!");
            }

            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Please Select The Row!!");
            }

        }
        if(ae.getSource()==Cancel)
        {
            setVisible(false);
        }
        if(ae.getSource()==Refresh)
        {
            Display_Original();
        }
    }

    public static void main(String[] args)
    {
        new View_Order();
    }
}

