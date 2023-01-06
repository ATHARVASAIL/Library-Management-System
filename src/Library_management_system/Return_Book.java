package Library_management_system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class Return_Book extends JFrame implements ActionListener
{

    JLabel l1,l2;
    JTextField Book_id,Student_id;
    JButton Search1,Search2,Return_Book,Cancel,Refresh;
    Font fLabel = new Font("Tahoma", Font.PLAIN,15);
    JScrollPane sp;
    JTable table;
    public static String BOOK_ID;
    public static String BOOK_TITLE;
    public static String STUDENT_ID;
    public static String STUDENT_NAME;
    public static String ISSUE_DATE;
    public static String DUE_DATE;
    int row;
    Return_Book()
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

        //JTextfield
        Book_id = new JTextField();
        Book_id.setBounds(170,40,150,30);
        image.add(Book_id);

        Student_id = new JTextField();
        Student_id.setBounds(650,40,150,30);
        image.add(Student_id);

        //ScrollPane code
        sp =new JScrollPane();
        sp.setBounds(40,100,900,150);
        image.add(sp);

        table = new JTable();
        table.setBounds(40,100,900,150);
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

        Return_Book =new JButton("RETURN");
        Return_Book.setBounds(250,320,130,40);
        Return_Book.addActionListener(this);
        image.add(Return_Book);

        Cancel =new JButton("CANCEL");
        Cancel.setBounds(600,320,130,40);
        Cancel.addActionListener(this);
        image.add(Cancel);

        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/Refresh.png"));//adding image to frame
        Image i5 =i4.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        ImageIcon i6 =new ImageIcon(i5);
        Refresh =new JButton(i6);
        Refresh.setBounds(940,210,40,40);
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
            String str = "select Book_Id,Book_Title,Student_Id,Student_Name,Issue_Date,Due_Date from issued_books;";
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
                STUDENT_ID = table.getModel().getValueAt(row , 2).toString();
                STUDENT_NAME = table.getModel().getValueAt(row , 4).toString();
                ISSUE_DATE = table.getModel().getValueAt(row , 5).toString();
                DUE_DATE = table.getModel().getValueAt(row , 6).toString();
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
                String str="select Book_Id,Book_Title,Student_Id,Student_Name,Issue_Date,Due_Date from issued_books where Book_Id = '"+Book_Id+"';";
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
                String str="select Book_Id,Book_Title,Student_Id,Student_Name,Issue_Date,Due_Date from issued_books where Student_Id = '"+Student_Id+"';";
                ResultSet rs1 = c.s.executeQuery(str);
                table.setModel(DbUtils.resultSetToTableModel(rs1));
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        if(ae.getSource()==Return_Book)
        {
            try {
                TableSelected();
                String book_id =this.BOOK_ID.toString();
                conn c = new conn();
                try {
                    String str = "delete from issued_books where Book_Id = '" + book_id + "';";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Return Book Successfully!!");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            catch(NullPointerException e)
            {
                JOptionPane.showMessageDialog(null, "Please select the row !!");
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
        new Return_Book();
    }
}

