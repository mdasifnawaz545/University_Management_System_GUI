package com.university.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

class FeePayment extends JFrame {
    JLabel rollNo, amountDue, title;
    JTextField amountDueField;
    JButton search, pay, cancel;
    JComboBox studentList;

    public FeePayment() {
        setTitle("Fee Payment");
        setLayout(null);

        title = new JLabel("Fee Payment");
        title.setBounds(250, 15, 150, 30);
        title.setFont(new Font("Roboto", 15, 20));
        rollNo = new JLabel("Search Roll Number");
        studentList = new JComboBox();
        search = new JButton("Search");
        search.setBackground(new Color(135, 206, 200));
        amountDue = new JLabel("Total Amount Due");
        amountDueField = new JTextField(15);
        pay = new JButton("Pay Now");
        cancel = new JButton("Cancel");

        rollNo.setBounds(30,70,150,15);
        studentList.setBounds(225,70,200,20);
        search.setBounds(450,67,150,25);
        amountDue.setBounds(130,110,150,15);
        amountDueField.setBounds(260,110,150,20);
        pay.setBounds(110,150,150,25);
        cancel.setBounds(320,150,150,25);
        pay.setBackground(new Color(144, 238, 144));
        cancel.setBackground(new Color(135, 206, 250));

        pay.addActionListener(e -> {
//            Database Code
            JOptionPane.showMessageDialog(null,"Fee Paid Successfully");
        });
        cancel.addActionListener(e -> setVisible(false));

        add(rollNo);
        add(studentList);
        add(search);
        add(amountDue);
        add(amountDueField);
        add(pay);
        add(cancel);
    add(title);


        setVisible(true);
        setLocation(335, 250);
        setSize(650, 250);
    }
}


