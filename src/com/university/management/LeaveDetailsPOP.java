package com.university.management;

import javax.swing.*;
import java.sql.Connection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaveDetailsPOP extends JFrame {
    Connection connection;
    String detail;

    public LeaveDetailsPOP(String details) {
        this.detail = details;
        setTitle("Leave Details");
        setLayout(null);
        JLabel details_leave = new JLabel(this.detail);
        details_leave.setBounds(40, 25, 350, 15);
        System.out.println(details_leave.getText());
        add(details_leave);


        setLocation(450, 355);
        setSize(350, 100);
        setVisible(true);
//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}







