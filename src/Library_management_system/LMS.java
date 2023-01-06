package Library_management_system;

//Main Class
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LMS extends JFrame implements ActionListener
{
    JButton ADMIN_LOGIN,Student_Login;
   LMS ()
   {
       setSize(1200,675);//creating frame
       setLocation(150,60);

       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/LMS pic.jpg"));//adding image to frame
       Image i2 = i1.getImage().getScaledInstance(1200,675,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image= new JLabel(i3);
       image.setBounds(0,0,1200,675);
       add(image);

       ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/profile.png"));//adding image to frame
       Image i5 = i4.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
       ImageIcon i6 = new ImageIcon(i5);
       JLabel images= new JLabel(i6);
       images.setBounds(300,380,100,100);
       image.add(images);

       ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("icons/profile.png"));//adding image to frame
       Image i8 = i7.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
       ImageIcon i9 = new ImageIcon(i8);
       JLabel Images= new JLabel(i9);
       Images.setBounds(750,380,100,100);
       image.add(Images);

       JLabel text = new JLabel("LIBRARY MANAGEMENT SYSTEM");//adding label
       text.setBounds(200, 100, 1000, 90);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("serif",Font.PLAIN,50));
       image.add(text);

       ADMIN_LOGIN = new JButton("ADMIN_LOGIN");//adding login button
       ADMIN_LOGIN.setBounds(250,500,200,50);
       ADMIN_LOGIN.setBackground(Color.WHITE);
       ADMIN_LOGIN.setForeground(Color.black);
       ADMIN_LOGIN.addActionListener(this);
       ADMIN_LOGIN.setFont(new Font("serif",Font.PLAIN,20));
       image.add(ADMIN_LOGIN);

       Student_Login = new JButton("STUDENT_LOGIN");//adding login button
       Student_Login.setBounds(700,500,200,50);
       Student_Login.setBackground(Color.WHITE);
       Student_Login.setForeground(Color.black);
       Student_Login.addActionListener(this);
       Student_Login.setFont(new Font("serif",Font.PLAIN,20));
       image.add(Student_Login);

       setVisible(true);
       setLayout(null);
   }

    public void actionPerformed(ActionEvent ae)
    {
       setVisible(false);
       if(ae.getSource() == ADMIN_LOGIN)
       {
           new Admin_Login();
       }
        else if(ae.getSource() == Student_Login)
        {
            new Stu_Login();
        }
    }

    public static void main (String args[])
   {
      new LMS();
   }
}
