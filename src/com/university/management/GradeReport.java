package com.university.management;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GradeReport extends JFrame {
    int rollNumber;
    String sem;
    Connection connection;
    JLabel title, name, rollNo, semester, cgpa;
    JButton print;
    String sub1, sub2, sub3, sub4, sub5;
    int mar1, mar2, mar3, mar4, mar5;

    JLabel row1, row2, row3, row4, row5;
    String marksQuery = "SELECT * FROM grade_report WHERE roll=(?) AND semester=(?);";
    String nameQuery = "SELECT name FROM grade_report JOIN student ON grade_report.roll=student.roll WHERE student.roll=?;";

    String studentName;

    public GradeReport(int rollNumber, String sem, Connection connect) {
        this.connection = connect;
        this.rollNumber = rollNumber;
        this.sem = sem;
        setTitle("Student Grade Report");
        setLayout(null);

        title = new JLabel("Semester Grade Report");
        title.setFont(new Font("Roboto", 10, 15));
        print = new JButton("Back");


        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Images/kisspng-kiit-school-of-rural-management-kiit-technology-bu-logo-5ac78cf4425602.4098442015230271882717.png"));
        Image image = imageIcon.getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel img = new JLabel(imageIcon1);


//     Database Code
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(marksQuery);
            preparedStatement.setInt(1, rollNumber);
            preparedStatement.setString(2, sem);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sub1 = resultSet.getString("sub1");
                sub2 = resultSet.getString("sub2");
                sub3 = resultSet.getString("sub3");
                sub4 = resultSet.getString("sub4");
                sub5 = resultSet.getString("sub5");
                mar1 = resultSet.getInt("mark1");
                mar2 = resultSet.getInt("mark2");
                mar3 = resultSet.getInt("mark3");
                mar4 = resultSet.getInt("mark4");
                mar5 = resultSet.getInt("mark5");
            }
            PreparedStatement preparedStatement1 = connection.prepareStatement(nameQuery);
            preparedStatement1.setInt(1, rollNumber);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
                studentName = resultSet1.getString("name");
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
        float sgpa_sem;
        int g1 = 0, g2=0, g3=0, g4=0, g5=0;
        //
        if ((mar1 | mar2 | mar3 | mar4 | mar5) >= 90) {

            g1 = 10;
        } else if ((mar1 | mar2 | mar3 | mar4 | mar5) >= 80 && (mar1 | mar2 | mar3 | mar4 | mar5) < 90) {

            g2 = 9;
        } else if ((mar1 | mar2 | mar3 | mar4 | mar5) >= 70 && (mar1 | mar2 | mar3 | mar4 | mar5) < 80) {

            g3 = 8;
        } else if ((mar1 | mar2 | mar3 | mar4 | mar5) >= 60 && (mar1 | mar2 | mar3 | mar4 | mar5) < 70) {

            g4 = 7;
        } else if ((mar1 | mar2 | mar3 | mar4 | mar5) >= 50 && (mar1 | mar2 | mar3 | mar4 | mar5) < 60) {

            g4 = 6;
        } else if ((mar1 | mar2 | mar3 | mar4 | mar5) >= 40 && (mar1 | mar2 | mar3 | mar4 | mar5) < 50) {

            g4 = 6;
        } else {
            g5 = 0;
        }

        sgpa_sem = (g1 + g2 + g3 + g4 + g5) / 16f;

        name = new JLabel("Name                     -       " + studentName);
        rollNo = new JLabel("Roll Number         -       " + rollNumber);
        semester = new JLabel("Semester              -       " + sem);
        cgpa = new JLabel("SGPA                     -       " + sgpa_sem);
        row1 = new JLabel(sub1 + "                      -                 " + mar1);
        row2 = new JLabel(sub2 + "                      -                 " + mar2);
        row3 = new JLabel(sub3 + "                      -                 " + mar3);
        row4 = new JLabel(sub4 + "                      -                 " + mar4);
        row5 = new JLabel(sub5 + "                      -                 " + mar5);
        print.setBackground(new Color(135, 206, 250));

        img.setBounds(135, 15, 150, 100);
        title.setBounds(135, 130, 300, 20);
        name.setBounds(110, 170, 300, 15);
        semester.setBounds(110, 200, 200, 15);
        rollNo.setBounds(110, 230, 200, 15);
        cgpa.setBounds(110, 260, 200, 15);

        row1.setBounds(80, 300, 400, 15);
        row2.setBounds(80, 330, 400, 15);
        row3.setBounds(80, 360, 400, 15);
        row4.setBounds(80, 390, 400, 15);
        row5.setBounds(80, 420, 400, 15);
        print.setBounds(130, 460, 150, 25);
        print.addActionListener(e -> {
            setVisible(false);
        });
        add(img);
        add(title);
        add(name);
        add(rollNo);
        add(semester);
        add(cgpa);
        add(row1);
        add(row2);
        add(row3);
        add(row4);
        add(row5);
        add(print);


        setLocation(400, 75);
        setSize(450, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

