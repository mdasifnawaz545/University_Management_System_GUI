package com.university.management;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentAttendance extends JFrame {

    JComboBox studentList;

    int att;
    JLabel studentlist, attendance;
    JButton search;
    ArrayList<Integer> arrayList = new ArrayList<>();
    Connection connection;
    String allRollQuery = "SELECT (roll) FROM student;";
    String findAttendanceQuery = "SELECT (attendance) FROM student WHERE roll=?;";

    int rollNo;
    String attend = "Total Attendance(%)      -       " + 100;

    public void getAttendance(String atted) {
        attendance = new JLabel(atted);
        attendance.setBounds(20, 25, 350, 15);
        System.out.println(attendance.getText());
        add(attendance);
    }

    ;

    public StudentAttendance(Connection connect) {

        this.connection = connect;
        setTitle("Student Attendance");
        setLayout(null);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(allRollQuery);
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

        studentlist.setBounds(50, 20, 200, 20);
        studentList.setBounds(250, 20, 200, 25);
        search.setBounds(470, 20, 100, 25);


        search.addActionListener((e -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(findAttendanceQuery);
                preparedStatement.setInt(1, Integer.parseInt((String) (studentList.getSelectedItem())));
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    att = resultSet.getInt("attendance");
                }
                resultSet.close();
                preparedStatement.close();
                attend = ("Total Attendance(%)      -       " + att);
                new AttendacePOP(attend);


            } catch (SQLException sqle) {
                System.out.println(sqle);
            }


        }));


        search.setBackground(new Color(144, 238, 144));

        add(studentList);
        add(studentlist);
        add(search);

        setLocation(335, 250);
        setSize(650, 100);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}




