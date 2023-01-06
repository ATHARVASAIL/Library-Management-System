package Library_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Stu_Login extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton Login,cancel,text2;
    public static String student_id, name, dob, gender,course_name,branch_name,contact;
    Stu_Login()
    {
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        //Label
        JLabel text = new JLabel("STUDENT LOGIN");//adding label
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

        JLabel text1 = new JLabel("New Student Not Yet Register??");//adding label
        text1.setBounds(50, 250, 400, 50);
        text1.setForeground(Color.black);
        text1.setFont(new Font("serif",Font.PLAIN,15));
        add(text1);

        text2 = new JButton("Register Now!!!");//adding label
        text2.setBounds(50, 300, 160, 20);
        text2.setForeground(Color.BLUE);
        text2.setFont(new Font("serif",Font.PLAIN,15));
        text2.addActionListener(this);
        add(text2);

        setBounds(500, 200, 600, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==Login){
            String USERNAME = username.getText();
            String PASSWORD = String.valueOf(password.getPassword());
            conn c = new conn();
            String str = "Select Student_id,name,dob,gender,course_name,branch_name,contact from stud_details where username='"+USERNAME+"'and password='"+PASSWORD+"'";
            try{
                ResultSet rs = c.s.executeQuery(str);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Login credentials Validated");
                    String str1 = "Select Student_id,name,dob,gender,course_name,branch_name,contact from stud_details where username='"+USERNAME+"' and password='"+PASSWORD+"'";
                    ResultSet rs1 = c.s.executeQuery(str1);
                       while(rs1.next()) {
                        student_id = rs1.getString("Student_id");
                        name = rs1.getString("name");
                        dob=rs1.getString("dob");
                        gender=rs1.getString("gender");
                        course_name=rs1.getString("course_name");
                        branch_name=rs1.getString("branch_name");
                        contact=rs1.getString("contact");
                       }
                    new Student_Dashboard().setVisible(true);
                    this.setVisible(false);

                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Login credentials!");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource()== cancel)
        {
            System.exit(0);
        }
        else if (ae.getSource()==text2)
        {
            setVisible(false);
            new New_User();
        }
    }

    public static void main(String args[]) {
        new Stu_Login();
    }
}

