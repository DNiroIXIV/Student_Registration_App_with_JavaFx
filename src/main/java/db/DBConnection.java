package db;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static DBConnection dbConnection;

    private final List<Student> studentList;

    private DBConnection(){
        studentList = new ArrayList<>();
    }

    public static DBConnection getDbConnection(){
        return dbConnection == null ?  dbConnection = new DBConnection() : dbConnection;
    }

    public List<Student> getStudentList(){
        return studentList;
    }
}
