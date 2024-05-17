package com.university.management;

import javax.management.Query;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

class GradeReportClass {
    String sub1, sub2, sub3, sub4, sub5;
    int mark1, mark2, mark3, mark4, mark5;
}

public class GradeReportPOP extends JFrame {
    String allIdQuery = "SELECT (roll) FROM student;";
    GradeReportClass gradeDetails = new GradeReportClass();
    ArrayList<Integer> arrayList = new ArrayList<>();
    JComboBox studentList;
    JComboBox semesterList;
    JLabel studentlist;
    JButton search;
    Connection connection;

    public GradeReportPOP(Connection connect) {
        connection = connect;
        setTitle("Grade Report");
        setLayout(null);

        String sem[] = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"};
        semesterList = new JComboBox(sem);
        semesterList.setBounds(445, 20, 150, 25);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(allIdQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(resultSet.getInt("roll"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String array[] = new String[arrayList.size()];
        int i = 0;
        for (Iterator<Integer> iterator = arrayList.iterator(); iterator.hasNext(); ) {
            array[i++] = String.valueOf(iterator.next());
        }

        studentList = new JComboBox(array);
        search = new JButton("Search");
        studentlist = new JLabel("Search Student by Roll      -       ");
        studentlist.setBounds(40, 20, 200, 20);
        studentList.setBounds(230, 20, 200, 25);
        search.setBounds(600, 20, 100, 25);
        search.setBackground(new Color(135, 206, 250));

        search.addActionListener(e -> {
            new GradeReport(Integer.parseInt((String) studentList.getSelectedItem()), (String) semesterList.getSelectedItem(), connection);
            setVisible(false);
        });

        add(studentList);
        add(studentlist);
        add(search);
        add(semesterList);

        setLocation(320, 270);
        setSize(750, 100);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
