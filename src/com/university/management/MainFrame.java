package com.university.management;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Kalinga Institute of Industrial Technology");
        setVisible(true);
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Images/KIITCampus.jpg"));
        Image imageIcon1 = imageIcon.getImage().getScaledInstance(1275, 700, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(imageIcon1);
        JLabel image = new JLabel(imageIcon2);
        add(image);
        for (int i = 0; i < 630; i++) {
            setLocation(i/30,i/15);
            setSize(i * 2, i);
            try{
                Thread.sleep(1);
            }catch(InterruptedException ie){
                System.out.println(ie);
            }
        }
        try{
            Thread.sleep(5000);
            setVisible(false);
        }catch(InterruptedException ie){
            System.out.println(ie);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JMenuBar menuBar = new JMenuBar();
//        JMenu menu = new JMenu();
//        JMenuItem menuItem = new JMenuItem();
//        JMenuItem submenuItem1 = new JMenuItem();
//        JMenuItem submenuItem2 = new JMenuItem();
//        JMenuItem submenuItem3 = new JMenuItem();
//        JButton newInformation = new JButton("Apply For");
//        JButton newFaculty = new JButton("New Faculty");
//        JButton newStudent = new JButton("New Student");
//        JButton viewInformation = new JButton("View Information");
//        JButton faculty = new JButton("Faculty");
//        JButton student = new JButton("Student");
//        JButton attendence = new JButton("Attendence");
//        JButton leaveApply = new JButton("Apply for Leave");
//        JButton leaveDetails = new JButton("Leave Details");
//        JButton examination = new JButton("Examination");
//        JButton gradeReport = new JButton("Grade Report");
//        JButton feeDetails = new JButton("Fees Details");
//        JButton updateInfo = new JButton("Update Information");
//        JButton tools = new JButton("Tools");
//        JButton about = new JButton("About");
//        JButton exit = new JButton("Exit");


    }
}
