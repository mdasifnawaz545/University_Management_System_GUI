package com.university.management;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class FacultyAttendance extends JFrame{

    JComboBox facultyList;

    int att;
    JLabel facultylist, attendance;
    JButton search;
    ArrayList<Integer> arrayList=new ArrayList<>();
    Connection connection;
    String allIdQuery = "SELECT (faculty_id) FROM faculty;";
    String findAttendanceQuery = "SELECT (attendance) FROM faculty WHERE faculty_id=?;";

    int rollNo;
    String attend="Total Attendance(%)      -       " + 100;
    public void getAttendance(String atted){
        attendance = new JLabel(atted);
        attendance.setBounds(20,25,350,15);
        System.out.println(attendance.getText());
        add(attendance);
    };
    public FacultyAttendance(Connection connect) {

        this.connection=connect;
        setTitle("Faculty Attendance");
        setLayout(null);

        try{
            PreparedStatement preparedStatement=connection.prepareStatement(allIdQuery);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                arrayList.add(resultSet.getInt("faculty_id"));
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String array[]=new String[arrayList.size()];
        int i=0;
        for(Iterator<Integer> iterator = arrayList.iterator(); iterator.hasNext();){
            array[i++]= String.valueOf(iterator.next());
        }
        facultyList = new JComboBox(array);
        search = new JButton("Search");
        facultylist = new JLabel("Search Faculty by ID      -       ");

        facultylist.setBounds(50, 20, 200, 20);
        facultyList.setBounds(250, 20, 200, 25);
        search.setBounds(470, 20, 100, 25);


        search.addActionListener((e -> {
            try{
                PreparedStatement preparedStatement=connection.prepareStatement(findAttendanceQuery);
                preparedStatement.setInt(1,Integer.parseInt((String)(facultyList.getSelectedItem())));
                ResultSet resultSet=preparedStatement.executeQuery();
                while (resultSet.next())
                {
                    att=resultSet.getInt("attendance");
                }
                attend = ("Total Attendance(%)      -       " + att);
                new AttendacePOP(attend);


            }catch (SQLException sqle){
                System.out.println(sqle);
            }

        }));
        search.setBackground(new Color(144, 238, 144));

        add(facultyList);
        add(facultylist);
        add(search);
        setLocation(335, 250);
        setSize(650, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}




