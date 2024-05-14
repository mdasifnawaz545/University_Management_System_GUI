package com.university.management;

import javax.swing.*;
import java.awt.*;

class GD extends JFrame {
    JLabel title, name, rollNo, semester, cgpa;
    JButton print;
    String sub1, sub2, sub3, sub4, sub5;
    int mar1, mar2, mar3, mar4, mar5;

    JLabel row1, row2, row3, row4, row5;

    public GD() {
        setTitle("Student Grade Report");
        setLayout(null);

        title = new JLabel("Semester Grade Report");
        title.setFont(new Font("Roboto", 10, 15));
        print = new JButton("Print");


        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Images/kisspng-kiit-school-of-rural-management-kiit-technology-bu-logo-5ac78cf4425602.4098442015230271882717.png"));
        Image image = imageIcon.getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel img = new JLabel(imageIcon1);


//     Database Code


        //

        name = new JLabel("Name                     -       " + "");
        rollNo = new JLabel("Roll Number         -       " + "");
        semester = new JLabel("Semester              -       " + "");
        cgpa = new JLabel("SGPA                     -       " + "");
        row1 = new JLabel(sub1 + "              -       " + mar1);
        row2 = new JLabel(sub2 + "              -       " + mar2);
        row3 = new JLabel(sub3 + "              -       " + mar3);
        row4 = new JLabel(sub4 + "              -       " + mar4);
        row5 = new JLabel(sub5 + "              -       " + mar5);
        print.setBackground(new Color(135, 206, 250));

        img.setBounds(135, 15, 150, 100);
        title.setBounds(135, 130, 300, 20);
        name.setBounds(40, 170, 200, 15);
        semester.setBounds(40, 200, 200, 15);
        rollNo.setBounds(40, 230, 200, 15);
        cgpa.setBounds(40, 260, 200, 15);

        row1.setBounds(50, 300, 400, 15);
        row2.setBounds(50, 330, 400, 15);
        row3.setBounds(50, 360, 400, 15);
        row4.setBounds(50, 390, 400, 15);
        row5.setBounds(50, 420, 400, 15);
        print.setBounds(130, 460, 150, 25);

        add(img);
        add(title);
        add(name);
        add(rollNo);
        add(semester);
        add(cgpa);
        add(row1);
        add(row2);
        add(row3);
        add(row4);
        add(row5);
        add(print);


        setLocation(400, 50);
        setSize(450, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

public class GradeReport {
    public static void main(String args[]) {
        GD gd = new GD();

    }
}