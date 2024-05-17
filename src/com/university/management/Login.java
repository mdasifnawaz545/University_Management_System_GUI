package com.university.management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {
    Connection connection;
    String query = "SELECT * FROM login_details WHERE username=? AND password=?";
    public String name;
    public boolean validation = false;
    JLabel username, password, warning, loading;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton login, reset;

    public Login(Connection connection) {
        this.connection = connection;
        setTitle("Login to KIIT University");
        setLayout(null);
        username = new JLabel("Username");
        password = new JLabel("Password");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        login = new JButton("Login");
        reset = new JButton("Reset");
        username.setBounds(50, 60, 100, 20);
        usernameField.setBounds(175, 60, 200, 30);
        password.setBounds(50, 100, 100, 20);
        passwordField.setBounds(175, 100, 200, 30);
        login.setBounds(70, 170, 100, 30);
        reset.setBounds(200, 170, 100, 30);
        login.setBackground(new Color(144, 238, 144));
        reset.setBackground(new Color(135, 206, 250));
        warning = new JLabel();
        warning.setBounds(80, 220, 300, 20);
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Images/login.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel loginImage = new JLabel(imageIcon1);
        loading = new JLabel();
        loading.setBounds(100, 220, 300, 20);
        loginImage.setBounds(400, 25, 200, 200);
        add(username);
        add(usernameField);
        add(password);
        add(passwordField);
        add(login);
        add(reset);
        add(loginImage);

        reset.addActionListener((ActionEvent e) -> {
            usernameField.setText("");
            passwordField.setText("");
        });
        login.addActionListener((e -> {
            validateUser();
        }));
        add(warning);
        add(loading);
        setSize(650, 300);
        setLocation(350, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void validateUser() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usernameField.getText());
            preparedStatement.setString(2, passwordField.getText());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                name = resultSet.getString("name");
            }
            if (name == null) {
                warning.setText("Username or Password is Incorrect");
            } else {
                loading.setText("Validating...Please Wait!");
                warning.setText("");
                validation = true;
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

    }

}
