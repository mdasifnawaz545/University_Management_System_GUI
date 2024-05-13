package com.university.management;

import javax.swing.*;

public class FacultyAttendance extends JFrame{

        JComboBox studentList;
        JLabel studentlist,attendance;
        JButton search;

        public FacultyAttendance(){

            setTitle("Faculty Attendance");
            setLayout(null);
            studentList=new JComboBox();
            search =new JButton("Search");
            studentlist=new JLabel("Search Faculty by Roll      -       ");
            studentList=new JComboBox();
            studentlist.setBounds(50,20,200,20);
            studentList.setBounds(250,20,200,25);
            search.setBounds(470,20,100,25);


            search.addActionListener((e ->{}));

            add(studentList);
            add(studentlist);
            add(search);

            setLocation(335,250);
            setSize(650,150);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }








