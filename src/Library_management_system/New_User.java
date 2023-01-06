package Library_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class New_User extends JFrame implements ActionListener {

    JLabel l1,l2;
    JTextField Name,Student_id;
    JButton NEXT,cancel;
    public static String student_id,name;
    New_User() {
        getContentPane().setBackground(Color.WHITE);
        setBounds(500, 200, 600, 300);

        //Label
        JLabel text = new JLabel("ENTER DETAILS");//adding label
        text.setBounds(210, 0, 400, 50);
        text.setForeground(Color.black);
        text.setFont(new Font("serif",Font.PLAIN,20));
        add(text);

        l1 = new JLabel("Name :");
        l1.setBounds(40, 70, 100, 30);
        add(l1);

        Name = new JTextField();
        Name.setBounds(150, 70, 150, 30);
        add(Name);

        l2 = new JLabel("Student_Id :");
        l2.setBounds(40, 130, 100, 30);
        add(l2);

        Student_id = new JTextField();
        Student_id.setBounds(150,130,150,30);
        add(Student_id);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Profile3.jpg"));//adding image to frame
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 50, 200, 200);
        add(image);

        NEXT = new JButton("Next");//adding login button
        NEXT.setBounds(40, 200, 120, 30);
        NEXT.setBackground(Color.black);
        NEXT.setForeground(Color.WHITE);
        NEXT.addActionListener(this);
        add(NEXT);

        cancel = new JButton("Cancel");//adding cancel button
        cancel.setBounds(200, 200, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == NEXT) {
            String NAME = this.Name.getText();
            String STUDENT_ID = String.valueOf(this.Student_id.getText());
            conn c = new conn();
            try {
                String str1 = " select * from stud_details where name = '" + NAME + "' and Student_id = '" + STUDENT_ID + "';";
                ResultSet rs = c.s.executeQuery(str1);
                if (rs.next()) {
                    student_id = rs.getString("Student_id");
                    name = rs.getString("name");
                    JOptionPane.showMessageDialog(null, "Login successfully");
                    this.setVisible(false);
                    new New_Account();

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login Credentials");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {
        new New_User();
    }
}