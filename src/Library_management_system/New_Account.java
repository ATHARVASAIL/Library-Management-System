package Library_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class New_Account extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton Login,cancel;
    New_Account()
    {
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        //Label
        JLabel text = new JLabel("NEW STUDENT");//adding label
        text.setBounds(210, 0, 400, 50);
        text.setForeground(Color.black);
        text.setFont(new Font("serif",Font.PLAIN,20));
        add(text);

        JLabel user = new JLabel("Username :");
        user.setBounds(40, 70, 100, 30);
        add(user);

        username = new JTextField();
        username.setBounds(150, 70, 150, 30);
        add(username);

        JLabel pass = new JLabel("Password :");
        pass.setBounds(40, 130, 100, 30);
        add(pass);

        password = new JPasswordField();
        password.setBounds(150, 130, 150, 30);
        add(password);

        Login = new JButton("Login");//adding login button
        Login.setBounds(40, 200, 120, 30);
        Login.setBackground(Color.black);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        cancel = new JButton("Cancel");//adding cancel button
        cancel.setBounds(200, 200, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Login pic.jpg"));//adding image to frame
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370, 50, 200, 200);
        add(image);

        setBounds(500, 200, 600, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==Login)
        {
            String username = this.username.getText();
            String password = String.valueOf(this.password.getPassword());
            conn c= new conn();
            String str = "update stud_details set username = '"+username+"', password = '"+password+"' where  Student_id = '"+New_User.student_id+"' ; ";

            try{
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Data Added Successfully!!");
                this.username.setText(null);
                this.password.setText(null);

            }
            catch(Exception e) {
                System.out.println(e);
            }
            setVisible(false);
            new Stu_Login();

        }
        else if (ae.getSource()== cancel)
        {
            setVisible(false);
            new Stu_Login();
        }
    }

    public static void main(String args[]) {
        new New_Account();
    }
}


