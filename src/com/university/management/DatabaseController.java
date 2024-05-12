package com.university.management;

public class DatabaseController {
    public StudentDBInstance studentDBInstance;
    public FacultyDBInstance facultyDBInstance;

    public  void InsertToDatabaseStudent(StudentDBInstance studentDBInstance){
        this.studentDBInstance=studentDBInstance;
    }
    public  void InsertToDatabaseFaculty(FacultyDBInstance facultyDBInstance){
        this.facultyDBInstance=facultyDBInstance;
    }
}
