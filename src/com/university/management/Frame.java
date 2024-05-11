package com.university.management;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        setTitle("Kalinga Institute of Industrial Technology");
        setVisible(true);
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Images/KIITCampus.jpg"));
        Image imageIcon1 = imageIcon.getImage().getScaledInstance(1275, 700, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(imageIcon1);
        JLabel image = new JLabel(imageIcon2);
        add(image);


//        for (int i = 0; i < 630; i++) {
//            setLocation(i/30,i/15);
//            setSize(i * 2, i);
//            try{
//                Thread.sleep(1);
//            }catch(InterruptedException ie){
//                System.out.println(ie);
//            }
//        }


        int x = 1;
        for (int i = 2; i < 630; i += 4, x += 1) {
            setLocation(400 - ((i + x) / 2), 320 - (i / 2));
            setSize(i + 4 * x, i + x / 2);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }

        try {
            Thread.sleep(3000);
            setVisible(false);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
