package com.university.management;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class SearchStudent extends JFrame {
    Connection connection;
    String Query="SELECT (roll) from Student;";
    JLabel searchbyroll;
    JComboBox StudentRollList;
    JButton search,add,update,print,back;
    public SearchStudent(Connection connection){

        setTitle("Search for Student");
        setLayout(null);

        searchbyroll=new JLabel("Search Student by Roll        -       ");
        search=new JButton("Search");
        add=new JButton("Add Student");
        update=new JButton("Update");
        print=new JButton("Print");
        back=new JButton("Back");
        StudentRollList=new JComboBox();

        searchbyroll.setBounds(70,15,350,15);
        StudentRollList.setBounds(270,10,200,25);
        search.setBounds(50,70,90,25);
        add.setBounds(160,70,110,25);
        update.setBounds(280,70,90,25);
        print.setBounds(390,70,90,25);
        back.setBounds(500,70,90,25);

        back.addActionListener((e->setVisible(false)));
        search.addActionListener((e -> new StudentInformation(StudentRollList.getSelectedItem())));


        add(searchbyroll);
        add(StudentRollList);
        add(search);
        add(add);
        add(update);
        add(print);
        add(back);

        setLocation(335,250);
        setSize(650,150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
