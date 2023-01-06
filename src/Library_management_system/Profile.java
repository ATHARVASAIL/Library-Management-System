package Library_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile extends JFrame implements ActionListener
{
    JLabel l1, l2, l3,l4 ,l5 , l6, l7,t1,t2,t3,t4,t5,t6,t7;
    JButton Done;
    Font fLabel = new Font("Tahoma", Font.PLAIN,19);
    int labX = 60;
    int labH = 50;
    int labW = 140;
    int txtX = 220;
    int txth = 40;
    int txtW = 150;
    Profile()
    {
        setSize(500,600);
        setLocation(500,200);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/Details pic.jpeg"));//adding image to frame
        Image i2 = i1.getImage().getScaledInstance(500,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,500,600);
        add(image);

        l1 = new JLabel("Student_ID:");
        l1.setBounds(labX,40,labW,labH);
        l1.setForeground(Color.WHITE);
        l1.setFont(fLabel);
        image.add(l1);

        l2 = new JLabel("Name:");
        l2.setBounds(labX,100,labW,labH);
        l2.setForeground(Color.WHITE);
        l2.setFont(fLabel);
        image.add(l2);

        l3 = new JLabel("D.O.B:");
        l3.setBounds(labX,160,labW,labH);
        l3.setForeground(Color.WHITE);
        l3.setFont(fLabel);
        image.add(l3);

        l4 = new JLabel("Gender:");
        l4.setBounds(labX,220,labW,labH);
        l4.setForeground(Color.WHITE);
        l4.setFont(fLabel);
        image.add(l4);

        l5 = new JLabel("course_name:");
        l5.setBounds(labX,280,labW,labH);
        l5.setForeground(Color.WHITE);
        l5.setFont(fLabel);
        image.add(l5);

        l6 = new JLabel("branch_name:");
        l6.setBounds(labX,340,labW,labH);
        l6.setForeground(Color.WHITE);
        l6.setFont(fLabel);
        image.add(l6);

        l7 = new JLabel("Contact:");
        l7.setBounds(labX,400,labW,labH);
        l7.setForeground(Color.WHITE);
        l7.setFont(fLabel);
        image.add(l7);

        t1=new JLabel(Stu_Login.student_id);
        t1.setBounds(txtX,40,txtW,txth);
        t1.setForeground(Color.WHITE);
        t1.setFont(fLabel);
        image.add(t1);

        t2=new JLabel(Stu_Login.name);
        t2.setBounds(txtX,100,txtW,txth);
        t2.setForeground(Color.WHITE);
        t2.setFont(fLabel);
        image.add(t2);

        t3=new JLabel(Stu_Login.dob);
        t3.setBounds(txtX,160,txtW,txth);
        t3.setForeground(Color.WHITE);
        t3.setFont(fLabel);
        image.add(t3);

        t4=new JLabel(Stu_Login.gender);
        t4.setBounds(txtX,220,txtW,txth);
        t4.setForeground(Color.WHITE);
        t4.setFont(fLabel);
        image.add(t4);

        t5=new JLabel(Stu_Login.course_name);
        t5.setBounds(txtX,280,txtW,txth);
        t5.setForeground(Color.WHITE);
        t5.setFont(fLabel);
        image.add(t5);

        t6=new JLabel(Stu_Login.branch_name);
        t6.setBounds(txtX,340,txtW,txth);
        t6.setForeground(Color.WHITE);
        t6.setFont(fLabel);
        image.add(t6);

        t7=new JLabel(Stu_Login.contact);
        t7.setBounds(txtX,400,txtW,txth);
        t7.setForeground(Color.WHITE);
        t7.setFont(fLabel);
        image.add(t7);

        //button
        Done= new JButton("DONE");
        Done.setBounds(180,480,130,40);
        Done.addActionListener(this);
        image.add(Done);


        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Done)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new Profile();
    }
}