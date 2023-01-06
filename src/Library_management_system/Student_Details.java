package Library_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student_Details extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l5, l6, l7, l8,Student_id,name,dob,gen;
    JTextField  contact, course_name, branch_name;
    JButton update, cancel;
    Font fLabel = new Font("Tahoma", Font.PLAIN, 19);
    //size variables
    int labX = 60;
    int labH = 50;
    int labW = 140;
    int txtX = 220;
    int txth = 40;
    int txtW = 150;

    Student_Details() {
        setSize(500, 600);
        setLocation(500, 200);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Details pic.jpeg"));//adding image to frame
        Image i2 = i1.getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 500, 600);
        add(image);

        l1 = new JLabel("Student_ID:");
        l1.setBounds(labX, 40, labW, labH);
        l1.setForeground(Color.WHITE);
        l1.setFont(fLabel);
        image.add(l1);

        l2 = new JLabel("Name:");
        l2.setBounds(labX, 100, labW, labH);
        l2.setForeground(Color.WHITE);
        l2.setFont(fLabel);
        image.add(l2);

        l3 = new JLabel("D.O.B:");
        l3.setBounds(labX, 160, labW, labH);
        l3.setForeground(Color.WHITE);
        l3.setFont(fLabel);
        image.add(l3);

        l5 = new JLabel("Gender:");
        l5.setBounds(labX, 220, labW, labH);
        l5.setForeground(Color.WHITE);
        l5.setFont(fLabel);
        image.add(l5);

        l6 = new JLabel("course_name:");
        l6.setBounds(labX, 280, labW, labH);
        l6.setForeground(Color.WHITE);
        l6.setFont(fLabel);
        image.add(l6);

        l7 = new JLabel("branch_name:");
        l7.setBounds(labX, 340, labW, labH);
        l7.setForeground(Color.WHITE);
        l7.setFont(fLabel);
        image.add(l7);

        l8 = new JLabel("Contact:");
        l8.setBounds(labX, 400, labW, labH);
        l8.setForeground(Color.WHITE);
        l8.setFont(fLabel);
        image.add(l8);

        //textfields
        Student_id = new JLabel(Student_Update.STUDENT_ID);
        Student_id.setBounds(txtX, 40, txtW, txth);
        Student_id.setForeground(Color.WHITE);
        Student_id.setFont(fLabel);
        image.add(Student_id);

        name = new JLabel(Student_Update.NAME);
        name.setBounds(txtX, 100, txtW, txth);
        name.setForeground(Color.WHITE);
        name.setFont(fLabel);
        image.add(name);

        dob = new JLabel(Student_Update.DOB);
        dob.setBounds(txtX, 160, txtW, txth);
        dob.setForeground(Color.WHITE);
        dob.setFont(fLabel);
        image.add(dob);

        gen = new JLabel(Student_Update.GENDER);
        gen.setBounds(txtX, 220, txtW, txth);
        gen.setForeground(Color.WHITE);
        gen.setFont(fLabel);
        image.add(gen);

        course_name = new JTextField(Student_Update.COURSE_NAME);
        course_name.setBounds(txtX, 280, txtW, txth);
        image.add(course_name);

        branch_name = new JTextField(Student_Update.BRANCH_NAME);
        branch_name.setBounds(txtX, 340, txtW, txth);
        image.add(branch_name);

        contact = new JTextField(Student_Update.CONTACT);
        contact.setBounds(txtX, 400, txtW, txth);
        image.add(contact);

        //button
        update = new JButton("UPDATE");
        update.setBounds(80, 480, 130, 40);
        update.addActionListener(this);
        image.add(update);

        cancel = new JButton("CANCEL");
        cancel.setBounds(260, 480, 130, 40);
        cancel.addActionListener(this);
        image.add(cancel);

        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==update){
                String Course_Name = this.course_name.getText();
                String Branch_Name = this.branch_name.getText();
                String Contact = this.contact.getText();

                conn c = new conn();
                try {
                    String str1 = "update stud_details set course_name = '" + Course_Name + "', branch_name = '" + Branch_Name + "', contact = '" + Contact + "' where  Student_id = '" + Student_Update.STUDENT_ID + "' ; ";
                    c.s.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null, " Data Updated Successfully!!");
                    this.Student_id.setText(null);
                    this.name.setText(null);
                    this.dob.setText(null);
                    this.gen.setText(null);
                    this.course_name.setText(null);
                    this.branch_name.setText(null);
                    this.contact.setText(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        else if (ae.getSource()==cancel)
        {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Student_Details();
    }
}

