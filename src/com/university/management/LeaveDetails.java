package com.university.management;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class LeaveDetails extends JFrame{


        JLabel title, rollNo;
        JComboBox rollList;
        JButton search, cancel;

        public LeaveDetails() {
            setTitle("Leave Details");
            setLayout(null);

            title = new JLabel("Leave Details");
            rollNo = new JLabel("Select Your Roll Number");
            rollList = new JComboBox();


            search = new JButton("Search");
            cancel = new JButton("Cancel");
            cancel.addActionListener((e -> setVisible(false)));
            search.addActionListener((e -> {
//            Database code for leave

            }));
            title.setFont(new Font("Roboto", 20, 20));
            title.setBounds(120, 30, 300, 25);
            rollNo.setBounds(110, 80, 150, 15);
            rollList.setBounds(60, 120, 250, 20);

            search.setBounds(100, 230, 150, 20);
            cancel.setBounds(100, 270, 150, 20);
            search.setBackground(new Color(144, 238, 144));
            cancel.setBackground(new Color(135, 206, 250));

            add(title);
            add(rollNo);
            add(rollList);
            add(search);
            add(cancel);

            setLocation(400, 150);
            setSize(375, 350);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        }}
