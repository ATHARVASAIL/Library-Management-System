package Library_management_system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;

public class New_Student extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l5, l6, l7, l8;
    JTextField name, Student_id, contact, course_name, branch_name;
    JDateChooser dob;
    JButton add, cancel;
    JRadioButton male, female;
    // JDateChooser dob;
    ButtonGroup gen;
    Font fLabel = new Font("Tahoma", Font.PLAIN, 19);
    //size variables
    int labX = 60;
    int labH = 50;
    int labW = 140;
    int txtX = 220;
    int txth = 40;
    int txtW = 150;

    New_Student() {
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
        Student_id = new JTextField();
        Student_id.setBounds(txtX, 40, txtW, txth);
        image.add(Student_id);

        name = new JTextField();
        name.setBounds(txtX, 100, txtW, txth);
        image.add(name);

        dob = new JDateChooser();
        dob.setBounds(txtX, 160, txtW, txth);
        image.add(dob);

        course_name = new JTextField();
        course_name.setBounds(txtX, 280, txtW, txth);
        image.add(course_name);

        branch_name = new JTextField();
        branch_name.setBounds(txtX, 340, txtW, txth);
        image.add(branch_name);

        contact = new JTextField();
        contact.setBounds(txtX, 400, txtW, txth);
        image.add(contact);

        //radiobuttons
        gen = new ButtonGroup();

        male = new JRadioButton("Male");
        male.setBounds(220, 220, 60, txth);
        gen.add(male);
        image.add(male);

        female = new JRadioButton("Female");
        female.setBounds(300, 220, 70, txth);
        gen.add(female);
        image.add(female);

        //button
        add = new JButton("ADD");
        add.setBounds(80, 480, 130, 40);
        add.addActionListener(this);
        image.add(add);

        cancel = new JButton("CANCEL");
        cancel.setBounds(260, 480, 130, 40);
        cancel.addActionListener(this);
        image.add(cancel);

        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == add)
        {
            try {
                String name = this.name.getText();
                String contact = this.contact.getText();
                String Student_id = this.Student_id.getText();
                String branch_name = this.branch_name.getText();
                String course_name = this.course_name.getText();

                //for storing date
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String dob = dateFormat.format(this.dob.getDate());

                String gender = null;
                if (male.isSelected()) {
                    gender = "Male";
                } else if (female.isSelected()) {
                    gender = "Female";
                }
                try {
                    conn c = new conn();
                    String str = "insert into stud_details (Student_id,name,dob,gender,course_name,branch_name,contact) values('" + Student_id + "','" + name + "','" + dob + "','" + gender + "','" + course_name + "','" + branch_name + "','" + contact + "');";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Data Added Successfully!!");
                    this.Student_id.setText(null);
                    this.name.setText(null);
                    this.dob.setCalendar(null);
                    this.male.setSelected(false);
                    this.female.setSelected(false);
                    this.course_name.setText(null);
                    this.branch_name.setText(null);
                    this.contact.setText(null);

                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Something Went Wrong !!");
                }

            }
            catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Please enter whole data!!");
            }

        }
        else if(ae.getSource() ==cancel)
        {
           setVisible(false);
        }
        else
        {
            this.Student_id.setText(null);
            this.name.setText(null);
            this.dob.setCalendar(null);
            this.male.setSelected(false);
            this.female.setSelected(false);
            this.course_name.setText(null);
            this.branch_name.setText(null);
            this.contact.setText(null);
        }
    }

    public static void main(String[] args) {
        new New_Student();
    }
}
