package com.university.management;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseController {
    public StudentDBInstance studentDBInstance;
    public FacultyDBInstance facultyDBInstance;
    String Query="INSERT INTO faculty VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    DBConnection connection=new DBConnection();

    public  void InsertToDatabaseStudent(StudentDBInstance studentDBInstance) {
        this.studentDBInstance = studentDBInstance;
    }
    public  void InsertToDatabaseFaculty(FacultyDBInstance facultyDBInstance){
        this.facultyDBInstance=facultyDBInstance;
            try{
                PreparedStatement preparedStatement=connection.connect.prepareStatement(Query);
                preparedStatement.setInt(1,facultyDBInstance.facultyID);
                preparedStatement.setString(2,facultyDBInstance.name);
                preparedStatement.setString(3,facultyDBInstance.fathersName);
                preparedStatement.setString(4,facultyDBInstance.address);
                preparedStatement.setDate(5, Date.valueOf(facultyDBInstance.dob));
                preparedStatement.setInt(6,facultyDBInstance.phone);
                preparedStatement.setString(7,facultyDBInstance.email);
                preparedStatement.setInt(8,facultyDBInstance.graduation);
                preparedStatement.setInt(9,facultyDBInstance.postGraduation);
                preparedStatement.setInt(10,facultyDBInstance.aadhaar);
                preparedStatement.setString(11,facultyDBInstance.specialization);
                preparedStatement.setString(12,facultyDBInstance.department);
                preparedStatement.setBytes(13,facultyDBInstance.imageData);
                preparedStatement.setInt(14,100);

                int rowsAffected=preparedStatement.executeUpdate();

            }catch(SQLException sqle){
                System.out.println(sqle);
            }

        }
    }

