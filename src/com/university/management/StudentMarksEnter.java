package com.university.management;

import javax.swing.*;
import java.awt.*;

class StudentMarksEnter extends JFrame {
    JLabel title, rollNo, semester, subjects, marks;
    JComboBox rollField, semesterField;
    JButton submit, cancel;
    JTextField sub1, sub2, sub3, sub4, sub5, mar1, mar2, mar3, mar4, mar5;

    public StudentMarksEnter() {
        setTitle("Student Marks Upload");
        setLayout(null);

        title = new JLabel("Upload Student Marks");
        title.setFont(new Font("Roboto", 15, 25));
        rollNo = new JLabel("Select Student Roll No");
        rollField = new JComboBox();
        semester = new JLabel("Select Semester");
        semesterField = new JComboBox();
        subjects = new JLabel("Enter Subject Name");
        marks = new JLabel("Enter Obtained Marks");
        submit = new JButton("Submit");
        cancel = new JButton("Cancel");
        sub1 = new JTextField(15);
        sub2 = new JTextField(15);
        sub3 = new JTextField(15);
        sub4 = new JTextField(15);
        sub5 = new JTextField(15);
        mar1 = new JTextField(15);
        mar2 = new JTextField(15);
        mar3 = new JTextField(15);
        mar4 = new JTextField(15);
        mar5 = new JTextField(15);

        title.setBounds(175, 10, 350, 30);
        rollNo.setBounds(100, 80, 150, 15);
        rollField.setBounds(300, 75, 150, 20);
        semester.setBounds(100, 150, 150, 15);
        semesterField.setBounds(300, 145, 150, 20);

        subjects.setBounds(100, 220, 200, 15);
        marks.setBounds(300, 220, 200, 15);
        sub1.setBounds(100, 270, 150, 20);
        mar1.setBounds(300, 270, 150, 20);
        sub2.setBounds(100, 310, 150, 20);
        mar2.setBounds(300, 310, 150, 20);
        sub3.setBounds(100, 350, 150, 20);
        mar3.setBounds(300, 350, 150, 20);
        sub4.setBounds(100, 390, 150, 20);
        mar4.setBounds(300, 390, 150, 20);
        sub5.setBounds(100, 430, 150, 20);
        mar5.setBounds(300, 430, 150, 20);
        submit.setBounds(100, 490, 150, 25);
        cancel.setBounds(300, 490, 150, 25);
        submit.setBackground(new Color(144, 238, 144));
        cancel.setBackground(new Color(135, 206, 250));
        submit.addActionListener(e -> {
//            Database Code
            JOptionPane.showMessageDialog(null, "Marks Uploaded");
        });
        cancel.addActionListener((e) -> {
            setVisible(false);
        });


        add(title);
        add(rollNo);
        add(rollField);
        add(semester);
        add(semesterField);
        add(sub1);
        add(subjects);
        add(sub2);
        add(sub3);
        add(sub4);
        add(sub5);
        add(marks);
        add(mar1);
        add(mar2);
        add(mar3);
        add(mar4);
        add(mar5);
        add(submit);
        add(cancel);


        setLocation(350, 50);
        setSize(575, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


