package com.university.management;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Random;


class StudentInformation extends JFrame {
    int rollNo;
    Connection connection;
    JPanel panel;
    Blob imageData;
    JButton downloadImage;
    byte[] imgData;
    String Query = "Select * From Student WHERE roll=?";
    JLabel assignedMentor, assignedMentorID, title, name, roll, fatherName, rollField, address, dob, phone, email, classX, classXII, aadhaar, course, branch, studentImage, nameField, dobField, courseField, branchField, fatherNameField, addressField, phoneField, emailField, classXField, classXIIField, aadhaarField;

    public StudentInformation(int rollNo, Connection connect) {
        this.rollNo = rollNo;
        this.connection = connect;
        setTitle("Student");
        setLayout(null);
        title = new JLabel("Student Information");
        title.setFont(new Font("Roboto", 10, 20));
        title.setBounds(250, 10, 400, 20);
        name = new JLabel("Name    :");
        roll = new JLabel("Roll No    :");
        fatherName = new JLabel("Father's Name   :");
        address = new JLabel("Address    :");
        dob = new JLabel("Date of Birth    :");
        phone = new JLabel("Phone    :");
        email = new JLabel("Email ID    :");
        classX = new JLabel("ClassX (%)    :");
        classXII = new JLabel("ClassXII (%)    :");
        aadhaar = new JLabel("Aadhaar No    :");
        course = new JLabel("Course    :");
        branch = new JLabel("Branch    :");
        assignedMentor = new JLabel("Assigned Mentor Id : ");
        int idNo = 1;


        assignedMentorID = new JLabel();
        nameField = new JLabel();
        rollField = new JLabel();
        addressField = new JLabel();
        fatherNameField = new JLabel();
        dobField = new JLabel();
        phoneField = new JLabel();
        classXField = new JLabel();
        classXIIField = new JLabel();
        aadhaarField = new JLabel();
        courseField = new JLabel();
        branchField = new JLabel();
        emailField = new JLabel();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setInt(1, rollNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                assignedMentorID.setText(String.valueOf(resultSet.getInt("assigned_mentor_id")));
                nameField.setText(resultSet.getString("name"));
                rollField.setText(resultSet.getString("roll"));
                addressField.setText(resultSet.getString("address"));
                fatherNameField.setText(resultSet.getString("fathers_name"));
                dobField.setText(resultSet.getString("dob"));
                phoneField.setText(resultSet.getString("phone"));
                classXField.setText(resultSet.getString("class_X"));
                classXIIField.setText(resultSet.getString("class_XII"));
                aadhaarField.setText(resultSet.getString("aadhaar_no"));
                courseField.setText(resultSet.getString("course"));
                branchField.setText(resultSet.getString("branch"));
                emailField.setText(resultSet.getString("email_id"));
                imageData = resultSet.getBlob("image");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
        Random random = new Random();
        long randomValue = Math.abs((random.nextLong() % 9000) + 1000);

        String folderPath = "C:\\Users\\KIIT\\IdeaProjects\\demo\\University Management System\\src\\DBImages\\";
        String filePath = folderPath + "_Student_Image_" + randomValue + ".jpg";
        try {
            imgData = imageData.getBytes(1, (int) imageData.length());
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(imgData);
            fileOutputStream.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        name.setBounds(30, 60, 100, 10);
        assignedMentor.setBounds(450, 60, 200, 15);
        assignedMentorID.setBounds(600, 60, 200, 15);
        roll.setBounds(30, 100, 100, 10);
        fatherName.setBounds(30, 140, 100, 10);
        address.setBounds(30, 180, 100, 10);
        dob.setBounds(30, 220, 100, 10);
        phone.setBounds(30, 260, 100, 10);
        email.setBounds(30, 300, 100, 10);
        classX.setBounds(30, 340, 100, 15);
        classXII.setBounds(30, 380, 100, 15);
        aadhaar.setBounds(30, 420, 100, 10);
        branch.setBounds(30, 460, 100, 10);
        course.setBounds(30, 500, 100, 10);

        nameField.setBounds(200, 55, 200, 25);
        rollField.setBounds(200, 95, 200, 25);
        fatherNameField.setBounds(200, 135, 200, 25);
        addressField.setBounds(200, 175, 200, 25);
        dobField.setBounds(200, 215, 200, 25);
        phoneField.setBounds(200, 255, 200, 25);
        emailField.setBounds(200, 295, 200, 25);
        classXField.setBounds(200, 335, 200, 25);
        classXIIField.setBounds(200, 375, 200, 25);
        aadhaarField.setBounds(200, 415, 200, 25);
        courseField.setBounds(200, 455, 200, 25);
        branchField.setBounds(200, 495, 200, 25);

        ImageIcon imageIcon = new ImageIcon(imgData);
        Image image = imageIcon.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        studentImage = new JLabel(imageIcon1);

        downloadImage = new JButton("Download Image");
        downloadImage.addActionListener((e) -> {
            Random random1 = new Random();
            long randomValue1 = Math.abs((random.nextLong() % 9000) + 1000);
            String folder_Path = "C:\\Users\\KIIT\\IdeaProjects\\demo\\University Management System\\src\\DBImages\\";
            String fileName = folder_Path + "_Database_Images_" + (randomValue) + ".jpg";
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                fileOutputStream.write(imgData);
                fileOutputStream.close();
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
        });

        panel = new JPanel();
        panel.setBounds(400, 80, 325, 410);

        studentImage.setBounds(420, 110, 275, 325);
        downloadImage.setBounds(450, 460, 200, 25);
        Border border = BorderFactory.createLineBorder(new Color(0, 204, 0));

        panel.setBorder(border);
        add(downloadImage);
        panel.add(studentImage);
        add(studentImage);
        add(title);
        add(name);
        add(roll);
        add(roll);
        add(fatherName);
        add(address);
        add(dob);
        add(phone);
        add(email);
        add(classX);
        add(classXII);
        add(aadhaar);
        add(branch);
        add(course);

        add(nameField);
        add(rollField);
        add(fatherNameField);
        add(addressField);
        add(dobField);
        add(phoneField);
        add(aadhaarField);
        add(emailField);
        add(classXField);
        add(classXIIField);
        add(courseField);
        add(branchField);
        add(assignedMentorID);
        add(assignedMentor);


        setSize(750, 600);
        setLocation(250, 80);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}


