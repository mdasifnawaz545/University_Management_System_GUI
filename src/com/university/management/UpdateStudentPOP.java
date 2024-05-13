package com.university.management;

import javax.swing.*;

public class UpdateStudentPOP extends JFrame{
    JComboBox studentList;
    JLabel studentlist;
    JButton search;
    String FrameName;
    public UpdateStudentPOP(String FrameName){
        this.FrameName=FrameName;
        setTitle(FrameName);
        setLayout(null);
        studentList=new JComboBox();
        search =new JButton("Search");
        studentlist=new JLabel("Search Student by ROll      -       ");
        studentList=new JComboBox();
        studentlist.setBounds(50,20,200,20);
        studentList.setBounds(250,20,200,25);
        search.setBounds(470,20,100,25);

        search.addActionListener((e -> new UpdateStudent(Integer.parseInt((String) studentList.getSelectedItem()))));

        add(studentList);
        add(studentlist);
        add(search);

        setLocation(335,250);
        setSize(650,100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
