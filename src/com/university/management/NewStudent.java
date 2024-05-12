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

class NewStudent extends JFrame {
    Connection connection;
    DatabaseController databaseController;
    StudentDBInstance studentDBInstance;
    JLabel assignedMentor,imageUpload,assignedMentorID,title, name, roll, fatherName, rollField, address, dob, phone, email, classX, classXII, aadhaar, mentorID, mentorName;
    JTextField nameField, imageUplaodField,fatherNameField, addressField, phoneField, emailField, classXField, classXIIField, aadhaarField;
    JComboBox courseField, branchField;
    JDateChooser dobField;
    JButton imageUplaodButton;
    JButton submit, cancel;

    public NewStudent(Connection connection) {
        this.connection = connection;
        setTitle("Student");
        setLayout(null);
        title = new JLabel("Add New Student Information");
        title.setFont(new Font("Roboto", 10, 20));
        title.setBounds(250, 10, 400, 20);
        name = new JLabel("Name");
        roll = new JLabel("Roll No");
        fatherName = new JLabel("Father's Name");
        address = new JLabel("Address");
        dob = new JLabel("Date of Birth");
        phone = new JLabel("Phone");
        email = new JLabel("Email ID");
        classX = new JLabel("ClassX (%)");
        classXII = new JLabel("ClassXII (%)");
        aadhaar = new JLabel("Aadhaar No");
        mentorID = new JLabel("Course");
        mentorName = new JLabel("Branch");
        assignedMentor=new JLabel("Assigned Mentor Id - ");
        int idNo = 1;
        assignedMentorID=new JLabel("190345"+(idNo));
        imageUpload=new JLabel("Upload Image");

        String courses[] = {"B.Tech", "BCA", "B.Arch", "B.Pharm", "B.Sc", "B.A", "B.Com"};
        String branch[] = {"CSE", "IT", "CSSE", "SCSE", "ECE", "Mechanical", "Civil"};

        AtomicInteger rollNo = new AtomicInteger(1);
        nameField = new JTextField(15);
        rollField = new JLabel("22052736" + (rollNo));
        addressField = new JTextField(15);
        fatherNameField = new JTextField(15);
        dobField = new JDateChooser();
        phoneField = new JTextField(15);
        classXField = new JTextField(15);
        classXIIField = new JTextField(15);
        aadhaarField = new JTextField(15);
        courseField = new JComboBox(courses);
        branchField = new JComboBox(branch);
        emailField = new JTextField(15);
        imageUplaodButton=new JButton("Choose File");


        name.setBounds(30, 60, 100, 10);
        assignedMentor.setBounds(450, 60, 200, 10);
        assignedMentorID.setBounds(600, 60, 200, 10);
        roll.setBounds(30, 100, 100, 10);
        fatherName.setBounds(30, 140, 100, 10);
        address.setBounds(30, 180, 100, 10);
        dob.setBounds(30, 220, 100, 10);
        phone.setBounds(30, 260, 100, 10);
        email.setBounds(30, 300, 100, 10);
        classX.setBounds(30, 340, 100, 15);
        classXII.setBounds(30, 380, 100, 15);
        aadhaar.setBounds(30, 420, 100, 10);
        mentorID.setBounds(30, 460, 100, 10);
        mentorName.setBounds(30, 500, 100, 10);
        imageUpload.setBounds(30,540,100,15);

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
                studentDBInstance.imageData=imageData;

            }catch(FileNotFoundException ie){
                System.out.println(ie);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println(imageFile);
        });
        submit.addActionListener((ActionEvent e) -> {
            studentDBInstance = new StudentDBInstance();
            studentDBInstance.name = nameField.getText();
            studentDBInstance.fathersName = fatherNameField.getText();
            studentDBInstance.address = addressField.getText();
            studentDBInstance.phone = Integer.parseInt(phoneField.getText());
            studentDBInstance.email = emailField.getText();
            studentDBInstance.classX = Integer.parseInt(classXField.getText());
            studentDBInstance.classXII = Integer.parseInt(classXIIField.getText());
            studentDBInstance.aadhaar = Integer.parseInt(aadhaarField.getText());
            studentDBInstance.course = courseField.getActionCommand();
            studentDBInstance.branch = branchField.getActionCommand();
            studentDBInstance.dob = dobField.getDateFormatString();
            studentDBInstance.roll = Integer.parseInt(rollField.getName());
            rollNo.getAndIncrement();
            databaseController = new DatabaseController();
            databaseController.InsertToDatabaseStudent(studentDBInstance);
        });
        add(title);
        add(submit);
        add(cancel);
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
        add(mentorID);
        add(mentorName);
add(imageUpload);

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
add(imageUplaodButton);

        setSize(750, 650);
        setLocation(250, 55);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
