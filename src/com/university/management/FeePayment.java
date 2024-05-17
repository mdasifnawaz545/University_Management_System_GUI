package com.university.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

class FeePayment extends JFrame {
    Connection connection;
    String allIdQuery = "SELECT (roll) FROM student;";

    JLabel rollNo, amountDue, title, amountPay;
    JTextField amountDueField, amountPayField;
    JButton search, pay, cancel;
    JComboBox studentList;
    ArrayList<Integer> arrayList = new ArrayList<>();
    int t_id, rollNumber, total_fees, paid_fees, due_fees;

    String Query1 = "SELECT (due_fees) FROM fees WHERE roll=?;";
    String Query2 = "UPDATE fees SET due_fees=? , paid_fees=? WHERE roll=?;";

    public FeePayment(Connection connect) {
        connection = connect;
        setTitle("Fee Payment");
        setLayout(null);


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(allIdQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(resultSet.getInt("roll"));
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


        amountPay = new JLabel("Pay Amount");
        amountPayField = new JTextField(15);
        title = new JLabel("Fee Payment");
        title.setBounds(250, 15, 150, 30);
        title.setFont(new Font("Roboto", 15, 20));
        rollNo = new JLabel("Search Roll Number");
        studentList = new JComboBox(array);
        search = new JButton("Search");
        search.setBackground(new Color(135, 206, 200));
        amountDue = new JLabel("Total Amount Due");
        amountDueField = new JTextField(15);
        pay = new JButton("Pay Now");
        cancel = new JButton("Cancel");

        rollNo.setBounds(30, 70, 150, 15);
        studentList.setBounds(225, 70, 200, 20);
        search.setBounds(450, 67, 150, 25);
        amountDue.setBounds(50, 110, 150, 15);
        amountDueField.setBounds(180, 110, 150, 20);
        amountPay.setBounds(350, 110, 150, 15);
        amountPayField.setBounds(430, 107, 150, 20);
        pay.setBounds(110, 150, 150, 25);
        cancel.setBounds(320, 150, 150, 25);
        pay.setBackground(new Color(144, 238, 144));
        cancel.setBackground(new Color(135, 206, 250));
        amountDueField.setForeground(Color.RED);

        search.addActionListener(e -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(Query1);
                preparedStatement.setInt(1, (Integer.parseInt((String) studentList.getSelectedItem())));
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    due_fees = (resultSet.getInt("due_fees"));
                }
                resultSet.close();
                preparedStatement.close();
                amountDueField.setText(String.valueOf(due_fees));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });


        pay.addActionListener(e -> {
            int due = ((Integer.parseInt(amountDueField.getText())) - (Integer.parseInt(amountPayField.getText())));
            System.out.println(due); // 200000, if Amount Pay is = 100000.
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(Query2);
                preparedStatement.setInt(1, due);
                preparedStatement.setInt(2, Integer.parseInt(amountPayField.getText()));
                preparedStatement.setInt(3, (Integer.parseInt((String) studentList.getSelectedItem())));
                int rowsAffected = preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException sqlException) {
                System.out.println(sqlException);
            }
//
            JOptionPane.showMessageDialog(null, "Fee Paid Successfully");
        });
        cancel.addActionListener(e -> setVisible(false));

        add(rollNo);
        add(studentList);
        add(search);
        add(amountDue);
        add(amountDueField);
        add(pay);
        add(cancel);
        add(amountPay);
        add(amountPayField);
        add(title);


        setVisible(true);
        setLocation(335, 250);
        setSize(650, 250);
    }
}


