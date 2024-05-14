package com.university.management;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class ApplyLeave extends JFrame {
    JLabel title, rollNo, date, duration;
    JDateChooser dateChooser;
    JComboBox durationList, rollList;
    JButton submit, cancel;

    public ApplyLeave() {
        setTitle("Leave Apply");
        setLayout(null);

        title = new JLabel("Apply For Leave");
        rollNo = new JLabel("Choose Your Number");
        rollList = new JComboBox();
        dateChooser = new JDateChooser();
        date = new JLabel("Choose a Date");
        duration = new JLabel("Duration of Leave");
        String drn[] = {"Half Day", "Full Day"};
        durationList = new JComboBox(drn);

        submit = new JButton("Submit");
        cancel = new JButton("Cancel");
        cancel.addActionListener((e -> setVisible(false)));
        submit.addActionListener((e -> {
//            Database code for leave
            JOptionPane.showMessageDialog(null,"Leave Approved");
        }));
        title.setFont(new Font("Roboto",20,20));
        title.setBounds(100,30,300,25);
        rollNo.setBounds(30,80,150,15);
        rollList.setBounds(170,80,150,20);
        date.setBounds(30,130,150,15);
        dateChooser.setBounds(170,130,150,20);
        duration.setBounds(30,180,150,15);
        durationList.setBounds(180,170,150,20);
        submit.setBounds(100,230,150,20);
        cancel.setBounds(100,270,150,20);

        add(title);
        add(rollNo);
        add(rollList);
        add(date);
        add(dateChooser);
        add(duration);
        add(durationList);
        add(submit);
        add(cancel);

        setLocation(450, 150);
        setSize(375, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
