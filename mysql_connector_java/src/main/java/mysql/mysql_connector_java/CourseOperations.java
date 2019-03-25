package mysql.mysql_connector_java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CourseOperations{

    public static void printcourses(Connection connection) throws SQLException{
        System.out.println("Creating Statement...");
        Statement stmt = connection.createStatement();
        String sqlQuery = "SELECT * FROM courses";
        ResultSet queryResult = stmt.executeQuery(sqlQuery);

        while(queryResult.next()){
            //retrieve by column name
            int id = queryResult.getInt("Course_id");
            String name = queryResult.getString("Name");
            String teacher = queryResult.getString("Teacher");
            int study_year = queryResult.getInt("Study_year");
            
            //Display values
            System.out.println("course_ID: " + id + ", Name: " + name + ", Teacher: " + teacher + ", Study Year: " + study_year);
            
        }
        queryResult.close();
        stmt.close();
    }

    public static void insert(Connection con, Courses course) throws SQLException{
        String statement = "INSERT INTO courses (Name, Teacher, Study_Year) VALUES (?, ?, ?)";
        PreparedStatement prepSt = con.prepareStatement(statement);

        prepSt.setString(1, course.getName());
        prepSt.setString(2, course.getTeacher());
        prepSt.setInt(3, course.getStudy_year());

        prepSt.executeUpdate();
    }

    public static Courses readcourseValues(){
        Courses course = new Courses();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" + "1 to enter a new course \n" + "0 to quit");

        while(!quit){
            System.out.println("Choose and option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;                    
                    break;
                case 1:
                    System.out.println("Enter course name: ");
                    String name = scanner.nextLine();
                    course.setName(name);
                    System.out.println("Enter course birthday: ");
                    String teacher = scanner.nextLine();
                    course.setTeacher(teacher);
                    System.out.println("Enter course address: ");
                    int study_year = scanner.nextInt();
                    course.setStudy_year(study_year);
                    break;
            
                default:
                    break;
            }
        }
        return course;
    }
    
    public Courses getCourseById(Connection connection, int courseId) throws SQLException {
    	
    	Courses foundCourse = new Courses();
    
        Statement stmt = connection.createStatement();
        String sqlQuery = "SELECT * FROM courses where id=?";
        PreparedStatement prepSt = connection.prepareStatement(sqlQuery);
        prepSt.setInt(1, courseId);
        
        System.out.println("Looking for desired course...");
        ResultSet queryResult = prepSt.executeQuery();
        
        
        while(queryResult.next()){
            //retrieve by column name
            int id = queryResult.getInt("course_id");
            String name = queryResult.getString("Name");
            String teacher = queryResult.getString("Teacher");
            int study_year = queryResult.getInt("Study_year");
            foundCourse.setCourse_id(id);
            foundCourse.setName(name);
            foundCourse.setTeacher(teacher);
            foundCourse.setStudy_year(study_year);
            
            //Display values
            System.out.println("course_ID: " + id + ", Course Name: " + name + ", Teacher: " + teacher + ", Study Year: " + study_year);
            
        }
        queryResult.close();
        prepSt.close();
        
        return foundCourse;
    }
}