package com.university.management;

import javax.swing.*;
import java.awt.*;


class StudentInformation extends JFrame {
    int rollNo;
     String Query="Select * From Student WHERE ID=?";
    JLabel assignedMentor,assignedMentorID,title, name, roll, fatherName, rollField, address, dob, phone, email, classX, classXII, aadhaar, course, branch,studentImage,nameField, dobField,courseField,branchField,fatherNameField, addressField, phoneField, emailField, classXField, classXIIField, aadhaarField;
     public StudentInformation(int rollNo){
         this.rollNo=rollNo;
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
         assignedMentor=new JLabel("Assigned Mentor Id : ");
         int idNo = 1;
         assignedMentorID=new JLabel();


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

         ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Images/image-from-rawpixel-id-13020188-png.png"));
         Image image = imageIcon.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
         ImageIcon imageIcon1 = new ImageIcon(image);
         studentImage = new JLabel(imageIcon1);
         studentImage.setBounds(420, 50, 300, 500);



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
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

}


