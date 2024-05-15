package com.university.management;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseController {
    public StudentDBInstance studentDBInstance;
    public FacultyDBInstance facultyDBInstance;
    String studentInsertQuery = "INSERT INTO student VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    String facultyInsertQuery = "INSERT INTO faculty VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    DBConnection connection = new DBConnection();

    public void InsertToDatabaseStudent(StudentDBInstance studentDBInstance) {
        this.studentDBInstance = studentDBInstance;
        try {
            PreparedStatement preparedStatement = connection.connect.prepareStatement(studentInsertQuery);
            preparedStatement.setInt(1, studentDBInstance.roll);
            preparedStatement.setInt(2, studentDBInstance.assignedMentorID);
            preparedStatement.setString(3, studentDBInstance.name);
            preparedStatement.setString(4, studentDBInstance.fathersName);
            preparedStatement.setString(5, studentDBInstance.address);
            preparedStatement.setString(6, studentDBInstance.dob);
            preparedStatement.setString(7, studentDBInstance.phone);
            preparedStatement.setString(8, studentDBInstance.email);
            preparedStatement.setFloat(9, studentDBInstance.classX);
            preparedStatement.setFloat(10, studentDBInstance.classXII);
            preparedStatement.setString(11, studentDBInstance.aadhaar);
            preparedStatement.setString(12, studentDBInstance.course);
            preparedStatement.setString(13, studentDBInstance.branch);
            preparedStatement.setBytes(14, studentDBInstance.imageData);
            preparedStatement.setInt(15, 100);

            int rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }

    public void InsertToDatabaseFaculty(FacultyDBInstance facultyDBInstance) {
        this.facultyDBInstance = facultyDBInstance;
        try {
            PreparedStatement preparedStatement = connection.connect.prepareStatement(facultyInsertQuery);
            preparedStatement.setInt(1, facultyDBInstance.facultyID);
            preparedStatement.setString(2, facultyDBInstance.name);
            preparedStatement.setString(3, facultyDBInstance.fathersName);
            preparedStatement.setString(4, facultyDBInstance.address);
            preparedStatement.setString(5, (facultyDBInstance.dob));
            preparedStatement.setString(6, facultyDBInstance.phone);
            preparedStatement.setString(7, facultyDBInstance.email);
            preparedStatement.setInt(8, facultyDBInstance.graduation);
            preparedStatement.setInt(9, facultyDBInstance.postGraduation);
            preparedStatement.setString(10, facultyDBInstance.aadhaar);
            preparedStatement.setString(11, facultyDBInstance.specialization);
            preparedStatement.setString(12, facultyDBInstance.department);
            preparedStatement.setBytes(13, facultyDBInstance.imageData);
            preparedStatement.setInt(14, 100);

            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

    }
}

