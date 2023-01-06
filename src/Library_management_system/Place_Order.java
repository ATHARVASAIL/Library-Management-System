package Library_management_system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class Place_Order extends JFrame implements ActionListener
{

    JLabel l1,l2,l3,l4,l5,t1,t2,t3;
    JTextField Author_name,Book_Title;
    JButton Search1,Search2,place_order,Cancel,Refresh;
    Font fLabel = new Font("Tahoma", Font.PLAIN,15);
    JScrollPane sp;
    JTable table;
    String BOOK_ID;
    String BOOK_TITLE;
    String AUTHOR_NAME;
    int row;
    Place_Order()
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
        l1 = new JLabel("BOOK_TITLE :");
        l1.setBounds(60,40,140,30);
        l1.setForeground(Color.white);
        l1.setFont(fLabel);
        image.add(l1);

        l2 = new JLabel("AUTHOR_NAME :");
        l2.setBounds(520,40,140,30);
        l2.setForeground(Color.white);
        l2.setFont(fLabel);
        image.add(l2);

        l3 = new JLabel("Student_ID:");
        l3.setBounds(150,220,140,30);
        l3.setForeground(Color.WHITE);
        l3.setFont(fLabel);
        image.add(l3);

        l4 = new JLabel("Name:");
        l4.setBounds(150,280,140,30);
        l4.setForeground(Color.WHITE);
        l4.setFont(fLabel);
        image.add(l4);

        l5 = new JLabel("Contact:");
        l5.setBounds(150,340,140,30);
        l5.setForeground(Color.WHITE);
        l5.setFont(fLabel);
        image.add(l5);

        t1=new JLabel(Stu_Login.student_id);
        t1.setBounds(310,220,140,30);
        t1.setForeground(Color.WHITE);
        t1.setFont(fLabel);
        image.add(t1);

        t2=new JLabel(Stu_Login.name);
        t2.setBounds(310,280,140,30);
        t2.setForeground(Color.WHITE);
        t2.setFont(fLabel);
        image.add(t2);

        t3=new JLabel(Stu_Login.contact);
        t3.setBounds(310,340,140,30);
        t3.setForeground(Color.WHITE);
        t3.setFont(fLabel);
        image.add(t3);

        //JTextfield
        Book_Title = new JTextField();
        Book_Title.setBounds(170,40,150,30);
        image.add(Book_Title);

        Author_name = new JTextField();
        Author_name.setBounds(650,40,150,30);
        image.add(Author_name);

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

        place_order =new JButton("PLACE ORDER");
        place_order.setBounds(600,240,130,30);
        place_order.addActionListener(this);
        image.add(place_order);

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
            String str = "select * from book_details;";
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
            }
        });
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Search1)
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
        if(ae.getSource()==Search2)
        {
            String AUTHOR_NAME = this.Author_name.getText();
            conn c=new conn();
            try{
                String str="select * from book_details where AUTHOR_NAME = '"+AUTHOR_NAME+"';";
                ResultSet rs1 = c.s.executeQuery(str);
                table.setModel(DbUtils.resultSetToTableModel(rs1));
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        if(ae.getSource()==place_order)
        {
            TableSelected();
            try {
                String Student_Id = Stu_Login.student_id;
                String Student_Name = Stu_Login.name;
                String Contact = Stu_Login.contact;
                try {
                    String BOOK_TITLE = this.BOOK_TITLE.toString();
                    String BOOK_ID = this.BOOK_ID.toString();
                    String AUTHOR_NAME = this.AUTHOR_NAME.toString();
                    conn c = new conn();
                    String str = "insert into order_list (Book_Id,Book_Title,Author_Name,Student_Id,Student_Name,Contact) values('" + BOOK_ID + "','" + BOOK_TITLE + "','" + AUTHOR_NAME + "','" + Student_Id + "','" + Student_Name + "','" + Contact + "');";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Data Added Successfully!!");
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Something Went Wrong!!");
                }
            }
            catch (NullPointerException e)
            {
                JOptionPane.showMessageDialog(null, "You Have Already Order A Book !!");
            }
        }

        else if (ae.getActionCommand().equals("CANCEL"))
        {
            setVisible(false);
        }

        else if (ae.getSource()==Refresh)
        {
            Display_Original();
        }
    }

    public static void main(String[] args)
    {
        new Place_Order();
    }
}

