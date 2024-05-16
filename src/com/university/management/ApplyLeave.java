package com.university.management;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class ApplyLeave extends JFrame {
    Connection connection;
    String Query="INSERT INTO student_leave values (?,?,?);";
    String allIdQuery = "SELECT (roll) FROM student;";
    ArrayList <Integer> arrayList=new ArrayList<>();
    JLabel title, rollNo, date, duration;
    JDateChooser dateChooser;
    JComboBox durationList, rollList;
    JButton submit, cancel;

    public ApplyLeave(Connection connect){
        connection=connect;
        setTitle("Leave Apply");
        setLayout(null);


        try{
            PreparedStatement preparedStatement=connection.prepareStatement(allIdQuery);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                arrayList.add(resultSet.getInt("roll"));
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


        title = new JLabel("Apply For Leave");
        rollNo = new JLabel("Choose Your Number");
        rollList = new JComboBox(array);
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
            try{
                PreparedStatement preparedStatement=connection.prepareStatement(Query);
                preparedStatement.setInt(1,Integer.parseInt((String)rollList.getSelectedItem()));
                preparedStatement.setString(2,(String)durationList.getSelectedItem());
                preparedStatement.setString(3,((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
                int rowsAffected = preparedStatement.executeUpdate();
            }catch (SQLException s){
                System.out.println(s);
            }
            JOptionPane.showMessageDialog(null,"Leave Approved");
        }));
        title.setFont(new Font("Roboto",20,20));
        title.setBounds(100,30,300,25);
        rollNo.setBounds(30,80,150,15);
        rollList.setBounds(170,80,150,20);
        date.setBounds(30,130,150,15);
        dateChooser.setBounds(170,130,150,20);
        duration.setBounds(30,180,150,15);
        durationList.setBounds(170,170,150,20);
        submit.setBounds(100,230,150,20);
        cancel.setBounds(100,270,150,20);


        submit.setBackground(new Color(144, 238, 144));
        cancel.setBackground(new Color(135, 206, 250));

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
