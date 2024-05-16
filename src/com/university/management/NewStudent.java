package com.university.management;

import javax.management.Query;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import com.toedter.calendar.JDateChooser;

class NewStudent extends JFrame {
    Connection connection;
    DatabaseController databaseController;
    StudentDBInstance studentDBInstance = new StudentDBInstance();
    ;
    JLabel assignedMentor, imageUpload, assignedMentorID, title, name, roll, fatherName, rollField, address, dob, phone, email, classX, classXII, aadhaar, mentorID, mentorName;
    JTextField nameField, imageUplaodField, fatherNameField, addressField, phoneField, emailField, classXField, classXIIField, aadhaarField;
    JComboBox courseField, branchField;
    JDateChooser dobField;
    JButton imageUplaodButton;
    JButton submit, cancel;

    String feesAdd="INSERT INTO fees (roll,total_fees,paid_fees,due_fees) VALUES (?,?,?,?);";

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
        assignedMentor = new JLabel("Assigned Mentor Id - ");


        //        MentorId
        int mentorIdDB = 0;
        String QueryId = "SELECT (faculty_id) from faculty LIMIT 1;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QueryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mentorIdDB = resultSet.getInt("faculty_id");
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }


        assignedMentorID = new JLabel(String.valueOf(mentorIdDB));
        imageUpload = new JLabel("Upload Image");

        String courses[] = {"B.Tech", "BCA", "B.Arch", "B.Pharm", "B.Sc", "B.A", "B.Com"};
        String branch[] = {"CSE", "IT", "CSSE", "SCSE", "ECE", "Mechanical", "Civil"};

        AtomicInteger rollNo = new AtomicInteger(1);

        Random random = new Random();
        long randomValue = Math.abs(random.nextLong() % 9000 + 1000);

        nameField = new JTextField(15);
        rollField = new JLabel("2205" + (randomValue));
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
        imageUplaodButton = new JButton("Choose File");


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
        imageUpload.setBounds(30, 540, 100, 15);

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
        imageUplaodButton.setBounds(200, 535, 200, 25);

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

        imageUplaodButton.addActionListener((e) -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(this);
            File imageFile;
            for (int i = 0; ; i++) {
                if (fileChooser.getSelectedFile() != null) {
                    imageFile = fileChooser.getSelectedFile();
                    try {
                        FileInputStream fileInputStream = new FileInputStream(imageFile);
                        studentDBInstance.imageData = new byte[fileInputStream.available()];
                        fileInputStream.read(studentDBInstance.imageData);

                    } catch (FileNotFoundException ie) {
                        System.out.println(ie);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    break;
                }
            }
        });
        submit.addActionListener((ActionEvent e) -> {
            studentDBInstance.name = nameField.getText();
            studentDBInstance.fathersName = fatherNameField.getText();
            studentDBInstance.address = addressField.getText();
            studentDBInstance.phone = (phoneField.getText());
            studentDBInstance.email = emailField.getText();
            studentDBInstance.classX = Float.parseFloat(classXField.getText());
            studentDBInstance.classXII = Float.parseFloat(classXIIField.getText());
            studentDBInstance.aadhaar = (aadhaarField.getText());
            studentDBInstance.course =(String) courseField.getSelectedItem();
            studentDBInstance.branch = (String) branchField.getSelectedItem();
            studentDBInstance.dob = ((JTextField)dobField.getDateEditor().getUiComponent()).getText();
            studentDBInstance.roll = Integer.parseInt(rollField.getText());
            studentDBInstance.assignedMentorID = Integer.parseInt(assignedMentorID.getText());

//            Fees Database instance are added
            try{
                PreparedStatement preparedStatement=connection.prepareStatement(feesAdd);
                preparedStatement.setInt(1,studentDBInstance.roll);
                preparedStatement.setInt(1,2100000);
                preparedStatement.setInt(1,0);
                preparedStatement.setInt(1,2100000);

                int rowsAffected=preparedStatement.executeUpdate();

            }catch(SQLException sqlException){
                System.out.println(sqlException);

            }

//            rollNo.getAndIncrement();
            databaseController = new DatabaseController();
            databaseController.InsertToDatabaseStudent(studentDBInstance);
        });
        submit.addActionListener((e -> JOptionPane.showMessageDialog(null, "Added Successfully")
        ));
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
