package com.university.management;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.Random;


class UpdateStudent extends JFrame {
    int roll;
    String new_address, new_phone, new_email;
    byte imageData[];
    Blob imgData;
    JButton downloadImage, update, cancel;
    Connection connection;
    String Query = "SELECT * FROM student WHERE roll=?";
    String updateQuery = "UPDATE student SET address=? , phone=? , email_id=? WHERE roll=?;";
    String nameDB, idDB, addressDB, fathersNameDB, dobDB, phoneDB, gradDB, pgDB, aadhaarDB, specDB, depDB, emailDB;
    JTextField addressField, phoneField, emailField;
    JLabel address, phone, email, title, name, facultyID, fatherName, idField, dob, graduation, postGraduation, aadhaar, specialization, department, facultyImage, nameField, dobField, specField, deptField, fatherNameField, gradField, postGradField, aadhaarField, imageField;

    public UpdateStudent(int roll, Connection connection) {
        this.roll = roll;
        this.connection = connection;
        setTitle("Student");
        setLayout(null);

        downloadImage = new JButton("Download Image");


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setInt(1, this.roll);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                nameDB = (resultSet.getString("name"));
                idDB = (String.valueOf(resultSet.getInt("roll")));
                addressDB = (resultSet.getString("address"));
                fathersNameDB = (resultSet.getString("fathers_name"));
                dobDB = (resultSet.getString("dob"));
                phoneDB = (resultSet.getString("phone"));
                gradDB = (String.valueOf(resultSet.getFloat("class_X")));
                pgDB = (String.valueOf(resultSet.getFloat("class_XII")));
                aadhaarDB = (resultSet.getString("aadhaar_no"));
                specDB = (resultSet.getString("course"));
                depDB = (resultSet.getString("branch"));
                emailDB = (resultSet.getString("email_id"));
                imgData = resultSet.getBlob("image");
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }

        downloadImage.addActionListener((e) -> {
            Random random = new Random();
            long randomValue = Math.abs((random.nextLong() % 9000) + 1000);
            String folder_Path = "C:\\Users\\KIIT\\IdeaProjects\\demo\\University Management System\\src\\DBImages\\";
            String fileName = folder_Path + "_Database_Images_" + (randomValue);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                fileOutputStream.write(imageData);
                fileOutputStream.close();
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
        });

        Random random = new Random();
        long randomValue = Math.abs((random.nextLong() % 9000) + 1000);
        String folder_Path = "C:\\Users\\KIIT\\IdeaProjects\\demo\\University Management System\\src\\DBImages\\";
        String fileName = folder_Path + "_Database_Images_" + (randomValue);
        try {
            imageData = imgData.getBytes(1, (int) imgData.length());
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(imageData);
            fileOutputStream.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }


        ImageIcon imageIcon = new ImageIcon(imageData);
        Image image = imageIcon.getImage().getScaledInstance(275, 325, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        facultyImage = new JLabel(imageIcon1);
        facultyImage.setBounds(420, 90, 275, 325);
        downloadImage.setBounds(450, 440, 200, 25);

        title = new JLabel("Update Faculty Information");
        title.setFont(new Font("Roboto", 10, 20));
        title.setBounds(250, 10, 400, 25);
        name = new JLabel("Name   :");
        facultyID = new JLabel("Faculty ID   :");
        fatherName = new JLabel("Father's Name   :");
        address = new JLabel("Address   :");
        dob = new JLabel("Date of Birth   :");
        phone = new JLabel("Phone");
        email = new JLabel("Email ID    :");
        graduation = new JLabel("Graduation (%) :");
        postGraduation = new JLabel("PG (%)   :");
        aadhaar = new JLabel("Aadhaar No    :");
        specialization = new JLabel("Specialization  :");
        department = new JLabel("Department    :");

        nameField = new JLabel();
        idField = new JLabel();
        addressField = new JTextField(15);
        fatherNameField = new JLabel();
        dobField = new JLabel();
        phoneField = new JTextField(15);
        gradField = new JLabel();
        postGradField = new JLabel();
        aadhaarField = new JLabel();
        specField = new JLabel();
        deptField = new JLabel();
        emailField = new JTextField(15);

        nameField.setText(nameDB);
        idField.setText(idDB);
        addressField.setText(addressDB);
        fatherNameField.setText(fathersNameDB);
        dobField.setText(dobDB);
        phoneField.setText(phoneDB);
        gradField.setText(gradDB);
        postGradField.setText(pgDB);
        aadhaarField.setText(aadhaarDB);
        specField.setText(specDB);
        deptField.setText(depDB);
        emailField.setText(emailDB);


        name.setBounds(30, 60, 100, 15);
        facultyID.setBounds(30, 100, 100, 15);
        fatherName.setBounds(30, 140, 100, 15);
        address.setBounds(30, 180, 100, 15);
        dob.setBounds(30, 220, 100, 15);
        phone.setBounds(30, 260, 100, 15);
        email.setBounds(30, 300, 100, 15);
        graduation.setBounds(30, 340, 100, 15);
        postGraduation.setBounds(30, 380, 100, 15);
        aadhaar.setBounds(30, 420, 100, 15);
        specialization.setBounds(30, 460, 100, 15);
        department.setBounds(30, 500, 100, 15);

        nameField.setBounds(200, 55, 200, 25);
        idField.setBounds(200, 95, 200, 25);
        fatherNameField.setBounds(200, 135, 200, 25);
        addressField.setBounds(200, 175, 200, 25);
        dobField.setBounds(200, 215, 200, 25);
        phoneField.setBounds(200, 255, 200, 25);
        emailField.setBounds(200, 295, 200, 25);
        gradField.setBounds(200, 335, 200, 25);
        postGradField.setBounds(200, 375, 200, 25);
        aadhaarField.setBounds(200, 415, 200, 25);
        specField.setBounds(200, 455, 200, 25);
        deptField.setBounds(200, 495, 200, 25);

        update = new JButton("Submit");
        cancel = new JButton("Cancel");
        update.setBackground(new Color(144, 238, 144));
        cancel.setBackground(new Color(135, 206, 250));
        update.setBounds(150, 550, 150, 20);
        cancel.setBounds(350, 550, 150, 20);


        cancel.addActionListener(e -> {
            setVisible(false);
        });
        update.addActionListener(e -> {
//    FileInputStream fileInputStream=new FileInputStream()
            new_address = addressField.getText();
            new_phone = phoneField.getText();
            new_email = emailField.getText();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                preparedStatement.setString(1, new_address);
                preparedStatement.setString(2, new_phone);
                preparedStatement.setString(3, new_email);
                preparedStatement.setInt(4, this.roll);
                int rowsAffected = preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException s) {
                System.out.println(s);
            }
            JOptionPane.showMessageDialog(null, "Updated Successfully");

        });

        add(facultyImage);
        add(downloadImage);
        add(title);
        add(name);
        add(facultyID);
        add(idField);
        add(fatherName);
        add(address);
        add(dob);
        add(phone);
        add(email);
        add(graduation);
        add(postGraduation);
        add(aadhaar);
        add(specialization);
        add(department);

        add(nameField);
        add(fatherNameField);
        add(addressField);
        add(dobField);
        add(phoneField);
        add(aadhaarField);
        add(emailField);
        add(gradField);
        add(postGradField);
        add(specField);
        add(deptField);
        add(update);
        add(cancel);


        setSize(750, 620);
        setLocation(250, 80);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

