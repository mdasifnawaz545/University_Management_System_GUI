package com.university.management;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

class Student extends JFrame{
    Connection connection;
    JLabel title,name,roll,fatherName,address,dob,phone,email,classX,classXII,aadhaar,mentorID,mentorName;
    JTextField nameField,rollField,fatherNameField,addressField,dobField,phoneField,emailField,classXField,classXIIField,aadhaarField,mentorIDField, mentorNameField;
    JComboBox course,branch;
    JButton submit,reset;
    public Student(){
//        this.connection=connection;
        setTitle("Student");
        setLayout(null);
        title=new JLabel("Add Student Information");
        title.setFont(new Font("Roboto",20,30));
        title.setBounds(200,20,400,25);
        name=new JLabel("Name");
        roll=new JLabel("Roll No");
        fatherName=new JLabel("Father's Name");
        address=new JLabel("Address");
        dob=new JLabel("Date of Birth");
        phone=new JLabel("Phone");
        email=new JLabel("Email ID");
        classX=new JLabel("ClassX (%)");
        classXII=new JLabel("ClassXII (%)");
        aadhaar=new JLabel("Aadhaar No");
        mentorID=new JLabel("Mentor ID");
        mentorName=new JLabel("Mentor Name");

        nameField=new JTextField(15);
        rollField=new JTextField(15);
        addressField=new JTextField(15);
        fatherNameField=new JTextField(15);
        dobField=new JTextField(15);
        phoneField=new JTextField(15);
        classXField=new JTextField(15);
        classXIIField=new JTextField(15);
        aadhaarField=new JTextField(15);
        mentorIDField=new JTextField(15);
        mentorNameField=new JTextField(15);
        emailField=new JTextField(15);



        name.setBounds(30,60+40,100,10);
        roll.setBounds(30,100+40,100,10);
        fatherName.setBounds(30,140+40,100,10);
        address.setBounds(30,180+40,100,10);
        dob.setBounds(30,220+40,100,10);
        phone.setBounds(30,260+40,100,10);
        email.setBounds(30,300+40,100,10);
        classX.setBounds(30,340+40,100,15);
        classXII.setBounds(30,380+40,100,15);
        aadhaar.setBounds(30,420+40,100,10);
        mentorID.setBounds(30,460+40,100,10);
        mentorName.setBounds(30,500+40,100,10);

        nameField.setBounds(200,90,200,25);
        rollField.setBounds(200,90,200,25);
        fatherNameField.setBounds(200,90,200,25);
        addressField.setBounds(200,90,200,25);
        dobField.setBounds(200,90,200,25);
        phoneField.setBounds(200,90,200,25);
        emailField.setBounds(200,90,200,25);
        classXField.setBounds(200,90,200,25);
        classXIIField.setBounds(200,90,200,25);
        mentorIDField.setBounds(200,90,200,25);
        mentorNameField.setBounds(200,90,200,25);


        submit=new JButton("Submit");
        reset=new JButton("Reset");
        submit.setBackground(new Color(144, 238, 144));
        reset.setBackground(new Color(135, 206, 250));
        submit.setBounds(200,570,150,25);
        reset.setBounds(400,570,150,25);



        add(submit);
        add(reset);
        add(name);
        add(roll);
        add(title);
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
        add(nameField);
        add(rollField);
        add(fatherNameField);
        add(addressField);
        add(dobField);
        add(phoneField);
        add(emailField);
        add(classXField);
        add(classXIIField);
        add(mentorNameField);
        add(mentorIDField);


        setSize(750,650);
        setLocation(250,20);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
public class NewStudent{
    public static void main(String a[]){
        Student s=new Student();
    }
}