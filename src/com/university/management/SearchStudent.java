package com.university.management;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class SearchStudent extends JFrame {
    Connection connection;
    ArrayList <Integer> arrayList=new ArrayList<>();
    JLabel searchbyroll;
    JComboBox StudentRollList;
    JButton downloadImage;
    String allStudent="SELECT (roll) FROM student;";
    JButton search,add,update,print,back;
    public SearchStudent(Connection connection){

        setTitle("Search for Student");
        setLayout(null);


        try{
            PreparedStatement preparedStatement=connection.prepareStatement(allStudent);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                arrayList.add(resultSet.getInt("roll"));
            }
        }catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
        String array[]=new String[arrayList.size()];
        int i=0;
        for(Iterator<Integer> iterator=arrayList.iterator();iterator.hasNext();){
            array[i++]= String.valueOf(iterator.next());
        }

        searchbyroll=new JLabel("Search Student by Roll        -       ");
        search=new JButton("Search");
        add=new JButton("Add Student");
        update=new JButton("Update");
        print=new JButton("Attendance");
        back=new JButton("Back");
        StudentRollList=new JComboBox(array);

        searchbyroll.setBounds(70,15,350,15);
        StudentRollList.setBounds(270,10,200,25);
        search.setBounds(50,70,90,25);
        add.setBounds(160,70,110,25);
        update.setBounds(280,70,90,25);
        print.setBounds(380,70,110,25);
        back.setBounds(510,70,90,25);

        back.addActionListener((e->setVisible(false)));
        search.addActionListener((e -> new StudentInformation(Integer.parseInt((String)StudentRollList.getSelectedItem()),connection)));
        add.addActionListener(e -> new NewStudent(connection));
        update.addActionListener((e -> new UpdateStudent(Integer.parseInt((String)StudentRollList.getSelectedItem()))));
        print.addActionListener(e -> new StudentAttendance(connection));

        search.setBackground(new Color(144, 238, 144));
        add.setBackground(new Color(144, 238, 144));
        update.setBackground(new Color(144, 238, 144));
        print.setBackground(new Color(144, 238, 144));
        back.setBackground(new Color(135, 206, 250));



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
