package com.university.management;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class LeaveDetails extends JFrame {

    Connection connection;
    String Query = "SELECT * FROM student_leave WHERE roll=(?) LIMIT 1;";

    String details;
    JLabel title, rollNo;
    JComboBox rollList;
    String allIdQuery = "SELECT (roll) FROM student;";
    ArrayList<Integer> arrayList = new ArrayList<>();
    JLabel Leave_Details;
    JButton search, cancel;

    public LeaveDetails(Connection connect) {
        this.connection = connect;
        setTitle("Leave Details");
        setLayout(null);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(allIdQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(resultSet.getInt("roll"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String array[] = new String[arrayList.size()];
        int i = 0;
        for (Iterator<Integer> iterator = arrayList.iterator(); iterator.hasNext(); ) {
            array[i++] = String.valueOf(iterator.next());
        }

        title = new JLabel("Leave Details");
        rollNo = new JLabel("Select Your Roll Number");
        rollList = new JComboBox(array);

        Leave_Details = new JLabel();
        Leave_Details.setBounds(20, 170, 300, 20);
        search = new JButton("Search");
        cancel = new JButton("Cancel");
        cancel.addActionListener((e -> setVisible(false)));
        search.addActionListener((e -> {
//            Database code for leave
            int rollNumber = Integer.parseInt((String) rollList.getSelectedItem());
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(Query);
                preparedStatement.setInt(1, rollNumber);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    details = ("Leave Details :  " + resultSet.getString("leave_type") + "  -  " + resultSet.getString("leave_date"));
//                    Leave_Details.setText("Leave Details : "+resultSet.getString("leave_date")+"                      -  "+resultSet.getString("leave_type"));
                }
                new LeaveDetailsPOP(details);
//                add(Leave_Details);
            } catch (SQLException sqle) {
                System.out.println(sqle);
            }

        }));
        title.setFont(new Font("Roboto", 20, 20));
        title.setBounds(120, 30, 300, 25);
        rollNo.setBounds(110, 80, 150, 15);
        rollList.setBounds(60, 120, 250, 20);

        search.setBounds(100, 250, 150, 20);
        cancel.setBounds(100, 290, 150, 20);
        search.setBackground(new Color(144, 238, 144));
        cancel.setBackground(new Color(135, 206, 250));

        add(title);
        add(rollNo);
        add(rollList);
        add(search);
        add(cancel);

        setLocation(435, 180);
        setSize(375, 365);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
