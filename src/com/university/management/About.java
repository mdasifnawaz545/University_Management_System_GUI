package com.university.management;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    public About() {
        setTitle("About Us");
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Images/KIIT PNG Logo.png"));
        Image image = imageIcon.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel images = new JLabel(imageIcon1);
        images.setBounds(50, 0, 500, 300);
        add(images);
        setSize(650, 500);
        setLocation(340, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
