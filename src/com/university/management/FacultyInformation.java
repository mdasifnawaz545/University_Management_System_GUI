package com.university.management;

import javax.swing.*;
import java.awt.*;


class FacultyInformation extends JFrame {
    int facultyId;
    String Query="Select * From Student WHERE ID=?";
    JLabel title, name, facultyID, fatherName, idField, address, dob, phone, email, graduation, postGraduation, aadhaar, specialization, department,facultyImage,nameField, dobField,specField,deptField,fatherNameField, addressField, phoneField, emailField, gradField, postGradField, aadhaarField;
    public FacultyInformation(int facultyId){
        this.facultyId=facultyId;
        setTitle("Student");
        setLayout(null);
        title = new JLabel("Faculty Information");
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
        addressField = new JLabel();
        fatherNameField = new JLabel();
        dobField = new JLabel();
        phoneField = new JLabel();
        gradField = new JLabel();
        postGradField = new JLabel();
        aadhaarField = new JLabel();
        specField = new JLabel();
        deptField = new JLabel();
        emailField = new JLabel();


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

        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Images/image-from-rawpixel-id-13020188-png.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        facultyImage = new JLabel(imageIcon1);
        facultyImage.setBounds(420, 50, 300, 500);



        add(facultyImage);
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


        setSize(750, 600);
        setLocation(250, 80);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

