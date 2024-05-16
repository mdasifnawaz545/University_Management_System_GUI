package com.university.management;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

class StudentMarksEnter extends JFrame {
    Connection connection;
    JLabel title, rollNo, semester, subjects, marks;
    JComboBox rollField, semesterField;
    JButton submit, cancel;
    String allIdQuery = "SELECT (roll) FROM student;";
    ArrayList<Integer> arrayList=new ArrayList<>();
    JTextField sub1, sub2, sub3, sub4, sub5, mar1, mar2, mar3, mar4, mar5;
String Query="INSERT INTO grade_report VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
    public StudentMarksEnter(Connection connect) {
        this.connection = connect;
        setTitle("Student Marks Upload");
        setLayout(null);


        try{
            PreparedStatement preparedStatement=connection.prepareStatement(allIdQuery);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                arrayList.add(((ResultSet) resultSet).getInt("roll"));
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String array[]=new String[arrayList.size()];
        int i=0;
        for(Iterator<Integer> iterator = arrayList.iterator(); iterator.hasNext();){
            array[i++]= String.valueOf(iterator.next());
        }






        String sem[] = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"};
        title = new JLabel("Upload Student Marks");
        title.setFont(new Font("Roboto", 15, 25));
        rollNo = new JLabel("Select Student Roll No");
        rollField = new JComboBox(array);
        semester = new JLabel("Select Semester");
        semesterField = new JComboBox(sem);
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

            try{
                PreparedStatement preparedStatement=connection.prepareStatement(Query);
                preparedStatement.setInt(1,Integer.parseInt((String)rollField.getSelectedItem()));
                preparedStatement.setString(2,(String)semesterField.getSelectedItem());
                preparedStatement.setString(3,sub1.getText());
                preparedStatement.setString(4,sub2.getText());
                preparedStatement.setString(5,sub3.getText());
                preparedStatement.setString(6,sub4.getText());
                preparedStatement.setString(7,sub5.getText());
                preparedStatement.setInt(8,Integer.parseInt(mar1.getText()));
                preparedStatement.setInt(9,Integer.parseInt(mar2.getText()));
                preparedStatement.setInt(10,Integer.parseInt(mar3.getText()));
                preparedStatement.setInt(11,Integer.parseInt(mar4.getText()));
                preparedStatement.setInt(12,Integer.parseInt(mar5.getText()));

                int rowsAffected=preparedStatement.executeUpdate();

            }catch (SQLException sqle){
                System.out.println(sqle);
            }

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


        setLocation(350, 75);
        setSize(575, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


