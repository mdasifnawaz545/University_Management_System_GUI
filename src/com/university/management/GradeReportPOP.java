package com.university.management;

import javax.swing.*;
import java.awt.*;

public class GradeReportPOP extends JFrame {
    JComboBox studentList;
    JLabel studentlist;
    JButton search;

    public GradeReportPOP() {

        setTitle("Grade Report");
        setLayout(null);
        studentList = new JComboBox();
        search = new JButton("Search");
        studentlist = new JLabel("Search Student by Roll      -       ");
        studentList = new JComboBox();
        studentlist.setBounds(50, 20, 200, 20);
        studentList.setBounds(250, 20, 200, 25);
        search.setBounds(470, 20, 100, 25);
        search.setBackground(new Color(135, 206, 250));

        search.addActionListener(e -> {new GradeReport(Integer.parseInt((String) studentList.getSelectedItem()));});

        add(studentList);
        add(studentlist);
        add(search);

        setLocation(335, 250);
        setSize(650, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
