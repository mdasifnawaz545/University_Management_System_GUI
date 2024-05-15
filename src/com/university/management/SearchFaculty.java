package com.university.management;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class SearchFaculty extends JFrame {
    Connection connection;
    String allFacultyId="SELECT (faculty_id) FROM faculty;";
    JLabel searchbyId;
    JComboBox FacultyIdList;
    JButton search, add, update, print, back;
    ArrayList<Integer> arrayList=new ArrayList<>();

    public SearchFaculty(Connection connection) {
this.connection=connection;
        setTitle("Search for Faculty");
        setLayout(null);

        try{
            PreparedStatement preparedStatement=connection.prepareStatement(allFacultyId);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                arrayList.add(resultSet.getInt("faculty_id"));
            }
        }catch (SQLException sqlException) {
            System.out.println(sqlException);
        }


        searchbyId = new JLabel("Search Faculty by ID          -       ");
        search = new JButton("Search");
        add = new JButton("Add Faculty");
        update = new JButton("Update");
        print = new JButton("Attendance");
        back = new JButton("Back");
        String array[] = new String[arrayList.size()];
        int i=0;
        for(Iterator<Integer> iterator=arrayList.iterator();iterator.hasNext();){
            array[i++]= String.valueOf(iterator.next());
        }
        FacultyIdList = new JComboBox(array);

        searchbyId.setBounds(70, 15, 350, 15);
        FacultyIdList.setBounds(270, 10, 200, 25);
        search.setBounds(50, 70, 90, 25);
        add.setBounds(160, 70, 110, 25);
        update.setBounds(280, 70, 90, 25);
        print.setBounds(380, 70, 110, 25);
        back.setBounds(510, 70, 90, 25);
        search.setBackground(new Color(144, 238, 144));
        add.setBackground(new Color(144, 238, 144));
        update.setBackground(new Color(144, 238, 144));
        print.setBackground(new Color(144, 238, 144));
        back.setBackground(new Color(135, 206, 250));
        search.setBackground(new Color(135, 206, 250));
        back.addActionListener((e -> setVisible(false)));
        search.addActionListener((e -> {
                new FacultyInformation(Integer.parseInt((String) FacultyIdList.getSelectedItem()),connection);
        }));
        add.addActionListener(e -> {
            new NewFaculty(connection);
        });
        update.addActionListener(e -> {
            new UpdateFaculty(Integer.parseInt((String) FacultyIdList.getSelectedItem()));
        });
        back.addActionListener(e -> setVisible(false));
        print.addActionListener(e -> {
            new FacultyAttendance();
        });
        add(searchbyId);
        add(FacultyIdList);
        add(search);
        add(add);
        add(update);
        add(print);
        add(back);

        setLocation(335, 250);
        setSize(650, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
