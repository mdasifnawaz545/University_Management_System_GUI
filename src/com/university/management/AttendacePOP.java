package com.university.management;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendacePOP extends JFrame {
    Connection connection;
    String attend;

    public AttendacePOP(String attend) {
        this.attend = attend;
        setTitle("Student Attendance");
        setLayout(null);
        JLabel attendace = new JLabel(this.attend);
        attendace.setBounds(60, 25, 350, 15);
        System.out.println(attendace.getText());
        add(attendace);


        setLocation(500, 375);
        setSize(300, 100);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
