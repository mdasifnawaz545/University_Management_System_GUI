package com.university.management;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

class NewFaculty extends JFrame {
    Connection connection;
    DatabaseController databaseController;
    JLabel title, imageUpload, name, id, idField, fatherName, address, dob, phone, email, graduation, postGraduation, aadhaar, department, specialization;
    JTextField nameField,imageUploadField, fatherNameField, addressField, phoneField, emailField, graduationField, postGraduationField, aadhaarField;
    JComboBox departmentField, specializationField;
    JButton imageUploadButton;
    JDateChooser dobField;
    JButton submit, cancel;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
    FacultyDBInstance facultyDBInstance = new FacultyDBInstance();
    ArrayList<Integer> arrayList=new ArrayList<>(List.of(0));

    public void increment(){
        arrayList.add((arrayList.get(arrayList.size() - 1)));
    }

    public NewFaculty(Connection connection) {
        String depart[] = {"Computer Science", "IT", "Mechanical", "Civil", "Architecture", "Applied Science",};
        String spec[] = {"AI/ML", "Data Science", "SAP ABAP", "Data Structures", "Electronics", "Computer Application"};
        increment();
        int rollIncrement = arrayList.get(arrayList.size() - 1);
        Random random=new Random();
        long randomValue=Math.abs((random.nextLong() % 9000L) + 10000L);
        this.connection = connection;
        setTitle("Student");
        setLayout(null);
        title = new JLabel("Add New Faculty Information");
        title.setFont(new Font("Roboto", 10, 20));
        title.setBounds(250, 10, 400, 20);
        name = new JLabel("Name");
        id = new JLabel("Faculty ID");
        fatherName = new JLabel("Father's Name");
        address = new JLabel("Address");
        dob = new JLabel("Date of Birth");
        phone = new JLabel("Phone");
        email = new JLabel("Email ID");
        graduation = new JLabel("Graduation (%)");
        postGraduation = new JLabel("PG (%)");
        aadhaar = new JLabel("Aadhaar No");
        specialization = new JLabel("Specialisation");
        department = new JLabel("Department");

        nameField = new JTextField(15);
        idField = new JLabel("19"+(randomValue));
        imageUploadField=new JTextField(15);
        addressField = new JTextField(15);
        fatherNameField = new JTextField(15);
        dobField = new JDateChooser();
        phoneField = new JTextField(15);
        graduationField = new JTextField(15);
        postGraduationField = new JTextField(15);
        aadhaarField = new JTextField(15);
        specializationField = new JComboBox(spec);
        departmentField = new JComboBox(depart);
        emailField = new JTextField(15);
        imageUploadButton = new JButton("Choose File");


        name.setBounds(30, 60, 100, 10);
        id.setBounds(30, 100, 100, 15);
        fatherName.setBounds(30, 140, 100, 10);
        address.setBounds(30, 180, 100, 10);
        dob.setBounds(30, 220, 100, 10);
        phone.setBounds(30, 260, 100, 10);
        email.setBounds(30, 300, 100, 10);
        graduation.setBounds(30, 340, 100, 15);
        postGraduation.setBounds(30, 380, 100, 20);
        aadhaar.setBounds(30, 420, 100, 10);
        specialization.setBounds(30, 460, 100, 15);
        department.setBounds(30, 500, 100, 15);
        imageUpload = new JLabel("Image Upload");
        imageUpload.setBounds(30, 540, 100, 15);

        nameField.setBounds(200, 55, 200, 25);
        idField.setBounds(200, 95, 200, 25);
        fatherNameField.setBounds(200, 135, 200, 25);
        addressField.setBounds(200, 175, 200, 25);
        dobField.setBounds(200, 215, 200, 25);
        phoneField.setBounds(200, 255, 200, 25);
        emailField.setBounds(200, 295, 200, 25);
        graduationField.setBounds(200, 335, 200, 25);
        postGraduationField.setBounds(200, 375, 200, 25);
        aadhaarField.setBounds(200, 415, 200, 25);
        specializationField.setBounds(200, 455, 200, 25);
        departmentField.setBounds(200, 495, 200, 25);
        imageUploadButton.setBounds(200, 535, 200, 25);
        imageUploadField.setBounds(450, 535, 200, 25);

        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Images/image-from-rawpixel-id-10110911-png.png"));
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


        imageUploadButton.addActionListener((e) -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(this);
            File imageFile;
            for (int i = 0; ; i++) {
                if (fileChooser.getSelectedFile() != null) {
                    imageFile = fileChooser.getSelectedFile();
                    imageUploadField.setText(imageFile.getName());
                    try {
                        FileInputStream fileInputStream = new FileInputStream(imageFile.getAbsolutePath());
                        System.out.println(fileInputStream);
                        facultyDBInstance.imageData = new byte[fileInputStream.available()];
                        fileInputStream.read(facultyDBInstance.imageData);
                        System.out.println(facultyDBInstance.imageData);

                    } catch (FileNotFoundException ie) {
                        System.out.println(ie);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;

                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ie) {
                    System.out.println(ie);
                }
            }
        });

        int finalRollIncrement = rollIncrement;
        submit.addActionListener((ActionEvent e) -> {
            facultyDBInstance.facultyID = Integer.parseInt(idField.getText());
            facultyDBInstance.name = nameField.getText();
            facultyDBInstance.fathersName = fatherNameField.getText();
            facultyDBInstance.address = addressField.getText();
            facultyDBInstance.phone = phoneField.getText();
            facultyDBInstance.email = emailField.getText();
            facultyDBInstance.graduation = Integer.parseInt(graduationField.getText());
            facultyDBInstance.postGraduation = Integer.parseInt(postGraduationField.getText());
            facultyDBInstance.aadhaar = aadhaarField.getText();
            facultyDBInstance.department = (String) departmentField.getSelectedItem();
            facultyDBInstance.specialization = (String) specializationField.getSelectedItem();
            facultyDBInstance.dob = ((JTextField) dobField.getDateEditor().getUiComponent()).getText();

            databaseController = new DatabaseController();
            databaseController.InsertToDatabaseFaculty(facultyDBInstance);
//            arrayList.add(finalRollIncrement);


        });
        submit.addActionListener((e -> JOptionPane.showMessageDialog(null, "Added Successfully")
        ));
        add(imageUpload);
        add(imageUploadButton);
        add(title);
        add(submit);
        add(cancel);
        add(name);
        add(id);
        add(fatherName);
        add(address);
        add(dob);
        add(phone);
        add(email);
        add(graduation);
        add(postGraduation);
        add(phone);
        add(aadhaar);
        add(department);
        add(specialization);


        add(nameField);
        add(idField);
        add(fatherNameField);
        add(addressField);
        add(dobField);
        add(phoneField);
        add(aadhaarField);
        add(emailField);
        add(graduationField);
        add(postGraduationField);
        add(departmentField);
        add(specializationField);


        setSize(750, 650);
        setLocation(250, 55);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
