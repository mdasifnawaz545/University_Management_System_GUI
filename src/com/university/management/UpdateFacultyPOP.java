package com.university.management;

import javax.swing.*;

public class UpdateFacultyPOP extends JFrame{

        JComboBox FacultyList;
        JLabel facultylist;
        JButton search;
        String FrameName;
        public UpdateFacultyPOP(String FrameName){
            this.FrameName=FrameName;
            setTitle(FrameName);
            setLayout(null);
            FacultyList=new JComboBox();
            search =new JButton("Search");
            facultylist=new JLabel("Search Faculty by ID          -       ");
            FacultyList=new JComboBox();
            facultylist.setBounds(50,20,200,20);
            FacultyList.setBounds(250,20,200,25);
            search.setBounds(470,20,100,25);

            search.addActionListener((e -> new UpdateFaculty(Integer.parseInt((String) FacultyList.getSelectedItem()))));

            add(FacultyList);
            add(facultylist);
            add(search);

            setLocation(335,250);
            setSize(650,100);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }



