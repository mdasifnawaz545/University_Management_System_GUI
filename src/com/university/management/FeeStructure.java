package com.university.management;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;

class FeeStructure extends JFrame {
    JLabel title;
    JTable table;
JButton print;
    public FeeStructure() {
        setTitle("Fee Structure");
        setLayout(null);
        title = new JLabel("Fee Structure");
        title.setFont(new Font("Roboto", 15, 20));
        title.setBounds(475, 20, 150, 25);
        print=new JButton("Print");
        print.setBounds(475,350,150,25);
        print.setBackground(new Color(135, 206, 250));

        String column[] = {"Courses","Semester 1", "Semester 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6", "Semester 7", "Semester 8"};
        String row[][] = {{"B.Tech", "1,75,000", "2,00,000", "2,25,000", "2,50,000", "2,75,000", "3,00,000", "3,25,000", "3,50,000"}, {"BCA", "1,75,000", "2,00,000", "2,25,000", "2,50,000", "2,75,000", "3,00,000", "3,25,000", "3,50,000"}, {"B.Arch", "1,75,000", "2,00,000", "2,25,000", "2,50,000", "2,75,000", "3,00,000", "3,25,000", "3,50,000"}, {"B.Pharm", "1,75,000", "2,00,000", "2,25,000", "2,50,000", "2,75,000", "3,00,000", "3,25,000", "3,50,000"}, {"B.Sc", "1,75,000", "2,00,000", "2,25,000", "2,50,000", "2,75,000", "3,00,000", "3,25,000", "3,50,000"}, {"B.Com", "1,75,000", "2,00,000", "2,25,000", "2,50,000", "2,75,000", "3,00,000", "3,25,000", "3,50,000"}, {"B.A", "1,75,000", "2,00,000", "2,25,000", "2,50,000", "2,75,000", "3,00,000", "3,25,000", "3,50,000"}};

        table = new JTable(row, column);
        table.setBackground(new Color(135, 206, 200));
        JScrollPane scrollPane=new JScrollPane(table);
        scrollPane.setBounds(40,80,1000,230);
        table.setRowHeight(30);

        print.addActionListener(e -> {
            try {
                table.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        });

        add(title);
        add(print);
        add(scrollPane);


        setVisible(true);
        setLocation(80, 110);
        setSize(1100, 450);
    }

}
