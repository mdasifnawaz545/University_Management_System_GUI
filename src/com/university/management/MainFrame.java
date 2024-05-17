package com.university.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

class MainFrame extends JFrame implements ActionListener {
    DBConnection connection = new DBConnection();

    public MainFrame() {

        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Images/KIIT_2.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(1250, 700, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel images = new JLabel(imageIcon1);
        add(images);


        JMenuBar menuBar = new JMenuBar();
        JMenu newInformation = new JMenu("Apply For");
        JMenuItem newFaculty = new JMenuItem("New Faculty");
        JMenuItem newStudent = new JMenuItem("New Student");
        newFaculty.setForeground(new Color(0, 0, 255));
        newStudent.setForeground(new Color(0, 0, 255));
        newInformation.add(newFaculty);
        newInformation.add(newStudent);
        newInformation.setForeground(new Color(0, 204, 0));
        menuBar.add(newInformation);
        JMenu viewInformation = new JMenu("View Information");
        JMenuItem faculty = new JMenuItem("Faculty Information");
        JMenuItem student = new JMenuItem("Student Information");
        faculty.setForeground(new Color(0, 0, 255));
        student.setForeground(new Color(0, 0, 255));
        viewInformation.add(faculty);
        viewInformation.add(student);
        viewInformation.setForeground(new Color(0, 204, 0));
        menuBar.add(viewInformation);
        JMenu attendance = new JMenu("Attendence");
        JMenuItem facultyAttendance = new JMenuItem("Faculty Attendance");
        JMenuItem studentAttendance = new JMenuItem("Student Attendance");
        facultyAttendance.setForeground(new Color(0, 0, 255));
        studentAttendance.setForeground(new Color(0, 0, 255));
        attendance.add(facultyAttendance);
        attendance.add(studentAttendance);
        attendance.setForeground(new Color(0, 204, 0));
        menuBar.add(attendance);
        JMenu leave = new JMenu("Leave");
        JMenuItem leaveApply = new JMenuItem("Apply for Leave");
        JMenuItem leaveDetails = new JMenuItem("Leave Details");
        leaveDetails.setForeground(new Color(0, 0, 255));
        leaveApply.setForeground(new Color(0, 0, 255));
        leave.add(leaveApply);
        leave.add(leaveDetails);
        leave.setForeground(new Color(0, 204, 0));
        menuBar.add(leave);
        JMenu examination = new JMenu("Examination");
        examination.setForeground(new Color(0, 204, 0));
        JMenuItem gradeReport = new JMenuItem("Grade Report");
        JMenuItem uploadMarks = new JMenuItem("Upload Marks");
        gradeReport.setForeground(new Color(0, 0, 255));
        uploadMarks.setForeground(new Color(0, 0, 255));
        examination.add(gradeReport);
        examination.add(uploadMarks);
        menuBar.add(examination);
        JMenu feeDetails = new JMenu("Fee Details");
        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        JMenuItem feePayment = new JMenuItem("Fee Payment");
        feeStructure.setForeground(new Color(0, 0, 255));
        feePayment.setForeground(new Color(0, 0, 255));
        feeDetails.add(feeStructure);
        feeDetails.add(feePayment);
        feeDetails.setForeground(new Color(0, 204, 0));
        menuBar.add(feeDetails);
        JMenu updateInfo = new JMenu("Update Information");
        JMenuItem facultyInfo = new JMenuItem("Faculty Information");
        JMenuItem studentInfo = new JMenuItem("Student Information");
        facultyInfo.setForeground(new Color(0, 0, 255));
        studentInfo.setForeground(new Color(0, 0, 255));
        updateInfo.add(facultyInfo);
        updateInfo.add(studentInfo);
        updateInfo.setForeground(new Color(0, 204, 0));
        menuBar.add(updateInfo);
        JMenu tools = new JMenu("Tools");
        tools.setForeground(new Color(0, 204, 0));
        JMenuItem notepad = new JMenuItem("Notepad");
        JMenuItem calculator = new JMenuItem("Calculator");
        JMenuItem webBrowser = new JMenuItem("Web Browser");
        notepad.setForeground(new Color(0, 0, 255));
        calculator.setForeground(new Color(0, 0, 255));
        webBrowser.setForeground(new Color(0, 0, 255));
        tools.add(notepad);
        tools.add(calculator);
        tools.add(webBrowser);
        menuBar.add(tools);
        JMenu about = new JMenu("About");
        JMenuItem aboutUs = new JMenuItem("About Us");
        aboutUs.setForeground(new Color(0, 0, 255));
        about.add(aboutUs);
        about.setForeground(new Color(0, 0, 255));
        menuBar.add(about);
        JMenu mExit = new JMenu("Exit");
        JMenuItem exit = new JMenuItem("Exit");
        mExit.setForeground(new Color(255, 0, 0));
        mExit.add(exit);
        exit.setForeground(new Color(255, 0, 0));
        menuBar.add(mExit);

//        Icon

        ImageIcon imageIcon2 = new ImageIcon(getClass().getClassLoader().getResource("Images/plus-sign_11656281.png"));
        Image image1 = imageIcon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(image1);
        newInformation.setIcon(imageIcon3);


        ImageIcon imageIcon28 = new ImageIcon(getClass().getClassLoader().getResource("Images/searh_8708741.png"));
        Image image18 = imageIcon28.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon imageIcon38 = new ImageIcon(image18);

        viewInformation.setIcon(imageIcon38);


        ImageIcon imageIcon4 = new ImageIcon(getClass().getClassLoader().getResource("Images/calendars_6787442.png"));
        Image image2 = imageIcon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon imageIcon5 = new ImageIcon(image2);

        attendance.setIcon(imageIcon5);


        ImageIcon imageIcon6 = new ImageIcon(getClass().getClassLoader().getResource("Images/exit_12406857.png"));
        Image image3 = imageIcon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon imageIcon7 = new ImageIcon(image3);

        leave.setIcon(imageIcon7);


        ImageIcon imageIcon8 = new ImageIcon(getClass().getClassLoader().getResource("Images/dna-test_8342741.png"));
        Image image8 = imageIcon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon imageIcon20 = new ImageIcon(image8);

        examination.setIcon(imageIcon20);


        ImageIcon imageIcon9 = new ImageIcon(getClass().getClassLoader().getResource("Images/Fees.jpg"));
        Image image9 = imageIcon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon imageIcon21 = new ImageIcon(image9);

        feeDetails.setIcon(imageIcon21);


        ImageIcon imageIcon24 = new ImageIcon(getClass().getClassLoader().getResource("Images/refresh_8600369.png"));
        Image image188 = imageIcon24.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon imageIcon25 = new ImageIcon(image188);

        updateInfo.setIcon(imageIcon25);


        ImageIcon imageIcon26 = new ImageIcon(getClass().getClassLoader().getResource("Images/maintenance_9784031.png"));
        Image image14 = imageIcon26.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon imageIcon27 = new ImageIcon(image14);

        tools.setIcon(imageIcon27);


        ImageIcon imageIcon2d8 = new ImageIcon(getClass().getClassLoader().getResource("Images/letter-i_11165425.png"));
        Image image31 = imageIcon2d8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon imageIcon29 = new ImageIcon(image31);

        about.setIcon(imageIcon29);


        ImageIcon imageIcon30 = new ImageIcon(getClass().getClassLoader().getResource("Images/log-out_10080391.png"));
        Image image111 = imageIcon30.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon imageIcon31 = new ImageIcon(image111);

        mExit.setIcon(imageIcon31);

        exit.addActionListener((e) -> {
            try {
                connection.connect.close();
                System.out.println("Connection is Closed.");
            } catch (SQLException sqlException) {
                System.out.println(sqlException);
            }
            System.exit(1);
        });
        calculator.addActionListener(this);
        notepad.addActionListener(this);
        webBrowser.addActionListener(this);
        aboutUs.addActionListener((e) -> {
            About about1 = new About();
        });
        newStudent.addActionListener((e -> new NewStudent(connection.connect)));
        newFaculty.addActionListener((e -> new NewFaculty(connection.connect)));
        faculty.addActionListener((e) -> {
            new SearchFaculty(connection.connect);
        });
        student.addActionListener((e) -> {
            new SearchStudent(connection.connect);
        });
        facultyInfo.addActionListener((e -> new UpdateFacultyPOP(connection.connect)));
        studentInfo.addActionListener((e -> new UpdateStudentPOP(connection.connect)));
        facultyAttendance.addActionListener((e -> new FacultyAttendance(connection.connect)));
        studentAttendance.addActionListener((e -> new StudentAttendance(connection.connect)));
        leaveApply.addActionListener((e -> {
            new ApplyLeave(connection.connect);
        })); //DB Conenection is required.
        leaveDetails.addActionListener((e -> {
            new LeaveDetails(connection.connect);
        })); //DB Conenection is required.

        gradeReport.addActionListener(e -> {
            new GradeReportPOP(connection.connect);
        });
        uploadMarks.addActionListener(e -> {
            new StudentMarksEnter(connection.connect);
        });

        feeStructure.addActionListener(e -> {
            new FeeStructure();
        });
        feePayment.addActionListener(e -> {
            new FeePayment(connection.connect);
        });


        setJMenuBar(menuBar);
        setTitle("Welcome to KIIT University");
        setSize(1275, 700);
        setLocation(7, 10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        String actionCmd = ae.getActionCommand();
        if (actionCmd.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (actionCmd.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (actionCmd.equals("Web Browser")) {
            try {
                Runtime.getRuntime().exec("Chrome.exe");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}

//public class MainFrame {
//    public static void main(String args[]) {
//        MyFrame myFrame = new MyFrame();
//    }
//}

