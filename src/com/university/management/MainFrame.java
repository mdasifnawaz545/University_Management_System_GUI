package com.university.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame implements ActionListener {
    DBConnection connection = new DBConnection();

    public MyFrame() {

        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Images/KIIT_Campus.jpg"));
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
        JMenuItem uploadMarks=new JMenuItem("Upload Marks");
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
        exit.addActionListener((e) -> {
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
        facultyInfo.addActionListener((e -> new UpdateFacultyPOP("Update Faculty")));
        studentInfo.addActionListener((e -> new UpdateStudentPOP("Update Student")));
        facultyAttendance.addActionListener((e -> new FacultyAttendance()));
        studentAttendance.addActionListener((e -> new StudentAttendance()));
        leaveApply.addActionListener((e -> {
            new ApplyLeave();
        })); //DB Conenection is required.
        leaveDetails.addActionListener((e -> {
            new LeaveDetails();
        })); //DB Conenection is required.

        gradeReport.addActionListener(e -> {new GradeReportPOP();});
        uploadMarks.addActionListener(e -> {new StudentMarksEnter();});

        feeStructure.addActionListener(e -> {new FeeStructure();});
        feeDetails.addActionListener(e -> {new FeePayment();});




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

public class MainFrame {
    public static void main(String args[]) {
        MyFrame myFrame = new MyFrame();
    }
}

