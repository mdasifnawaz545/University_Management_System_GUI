package com.university.management;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class UpdateFacultyPOP extends JFrame {
    Connection connection;
    String allIdQuery = "SELECT (faculty_id) FROM faculty;";

    ArrayList<Integer> arrayList = new ArrayList<>();
    JComboBox FacultyList;
    JLabel facultylist;
    JButton search;
    String FrameName;

    public UpdateFacultyPOP(Connection connect) {
        this.connection = connect;
        setTitle("Update Faculty");
        setLayout(null);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(allIdQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(resultSet.getInt("faculty_id"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String array[] = new String[arrayList.size()];
        int i = 0;
        for (Iterator<Integer> iterator = arrayList.iterator(); iterator.hasNext(); ) {
            array[i++] = String.valueOf(iterator.next());
        }


        FacultyList = new JComboBox(array);
        search = new JButton("Search");
        facultylist = new JLabel("Search Faculty by ID          -       ");
        facultylist.setBounds(50, 20, 200, 20);
        FacultyList.setBounds(250, 20, 200, 25);
        search.setBounds(470, 20, 100, 25);
        search.setBackground(new Color(135, 206, 250));

        search.addActionListener((e -> {
            new UpdateFaculty((Integer.parseInt((String) FacultyList.getSelectedItem())), connection);
        }));

        add(FacultyList);
        add(facultylist);
        add(search);


        setLocation(335, 250);
        setSize(650, 100);
        setVisible(true);
//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}



