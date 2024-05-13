package com.university.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.concurrent.atomic.AtomicInteger;

import com.toedter.calendar.JDateChooser;

class UpdateFaculty extends JFrame {
    Connection connection;
    DatabaseController databaseController;
    FacultyDBInstance facultyDBInstance;
    JLabel fatherNameField,nameField,imageUpload,gardField, postGradField,specialization,department, aadhaarField,title, name, facultyID, fatherName, IdField, address, dob, phone, email, graduation, postGraduation, aadhaar;
    JTextField  addressField, phoneField, emailField;
    JLabel specField, deptField;
    JLabel dobField;
    JButton imageUplaodButton;
    JButton submit, cancel;
    int id;

    public UpdateFaculty(int id) {
//        this.connection = connection;
        this.id=id;
        setTitle("Faculty");
        setLayout(null);
        title = new JLabel("Update Faculty Information");
        title.setFont(new Font("Roboto", 10, 20));
        title.setBounds(250, 10, 400, 20);
        name = new JLabel("Name");
        facultyID = new JLabel("Roll No");
        fatherName = new JLabel("Father's Name");
        address = new JLabel("Address");
        dob = new JLabel("Date of Birth");
        phone = new JLabel("Phone");
        email = new JLabel("Email ID");
        graduation = new JLabel("ClassX (%)");
        postGraduation = new JLabel("ClassXII (%)");
        aadhaar = new JLabel("Aadhaar No");
        specialization = new JLabel("Course");
        department = new JLabel("Branch");
        imageUpload=new JLabel("Upload Image");


        AtomicInteger rollNo = new AtomicInteger(1);
        nameField = new JLabel();
        IdField = new JLabel("22052736" + (rollNo));
        addressField = new JTextField(15);
        fatherNameField = new JLabel();
        dobField = new JLabel();
        phoneField = new JTextField(15);
        gardField = new JLabel();
        postGradField = new JLabel();
        aadhaarField = new JLabel();
        specField = new JLabel();
        deptField = new JLabel();
        emailField = new JTextField();
        imageUplaodButton=new JButton("Choose File");


        name.setBounds(30, 60, 100, 10);
        IdField.setBounds(30, 100, 100, 10);
        fatherName.setBounds(30, 140, 100, 10);
        address.setBounds(30, 180, 100, 10);
        dob.setBounds(30, 220, 100, 10);
        phone.setBounds(30, 260, 100, 10);
        email.setBounds(30, 300, 100, 10);
        graduation.setBounds(30, 340, 100, 15);
        postGraduation.setBounds(30, 380, 100, 15);
        aadhaar.setBounds(30, 420, 100, 10);
        specialization.setBounds(30, 460, 100, 10);
        department.setBounds(30, 500, 100, 10);
        imageUpload.setBounds(30,540,100,15);

        nameField.setBounds(200, 55, 200, 25);
        IdField.setBounds(200, 95, 200, 25);
        fatherNameField.setBounds(200, 135, 200, 25);
        addressField.setBounds(200, 175, 200, 25);
        dobField.setBounds(200, 215, 200, 25);
        phoneField.setBounds(200, 255, 200, 25);
        emailField.setBounds(200, 295, 200, 25);
        gardField.setBounds(200, 335, 200, 25);
        postGradField.setBounds(200, 375, 200, 25);
        aadhaarField.setBounds(200, 415, 200, 25);
        specField.setBounds(200, 455, 200, 25);
        deptField.setBounds(200, 495, 200, 25);
        imageUplaodButton.setBounds(200,535,200,25);

        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Images/image-from-rawpixel-id-13020188-png.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 425, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel images = new JLabel(imageIcon1);
        images.setBounds(420, 30, 300, 500);
        add(images);

        submit = new JButton("Submit");
        cancel = new JButton("Cancel");
        submit.setBackground(new Color(144, 238, 144));
        cancel.setBackground(new Color(135, 206, 250));
        submit.setBounds(200, 570, 150, 25);
        cancel.setBounds(400, 570, 150, 25);
        cancel.addActionListener((e) -> {
            setVisible(false);
        });
        imageUplaodButton.addActionListener((e)->{
            JFileChooser fileChooser=new JFileChooser();
            fileChooser.showOpenDialog(this);
            File imageFile;
            imageFile=fileChooser.getSelectedFile();
            try {
                FileInputStream fileInputStream = new FileInputStream(imageFile);
                byte imageData[]=new byte[fileInputStream.available()];
                fileInputStream.read(imageData);
                facultyDBInstance.imageData=imageData;

            }catch(FileNotFoundException ie){
                System.out.println(ie);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println(imageFile);
        });
        submit.addActionListener((ActionEvent e) -> {
            facultyDBInstance = new FacultyDBInstance();
            facultyDBInstance.address = addressField.getText();
            facultyDBInstance.phone = Integer.parseInt(phoneField.getText());
            facultyDBInstance.email = emailField.getText();
            databaseController = new DatabaseController();
            databaseController.InsertToDatabaseFaculty(facultyDBInstance);
        });
        add(title);
        add(submit);
        add(cancel);
        add(name);
        add(facultyID);
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
        add(imageUpload);

        add(nameField);
        add(IdField);
        add(fatherNameField);
        add(addressField);
        add(dobField);
        add(phoneField);
        add(aadhaarField);
        add(emailField);
        add(gardField);
        add(postGradField);
        add(specField);
        add(deptField);
        add(imageUplaodButton);

        setSize(750, 650);
        setLocation(250, 55);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}