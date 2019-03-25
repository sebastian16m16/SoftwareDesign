package mysql.mysql_connector_java;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class AppSql
{
    public static void main(String[] args )
    {
        Student stud = new Student("Ishtvan Popa", "13/02/1991", "Iulescului");
        Courses course = new Courses(1, "Software Programming", "Popescu Ion", 2014);

        DBConnection conexiune = DBConnection.getConnection();
        
        StudentOperations studentOperations = new StudentOperations();
        CourseOperations courseOperations = new CourseOperations();
        

        try{
            StudentOperations.printStudents(conexiune.connection);
            StudentOperations.insert(conexiune.connection, stud);
            StudentOperations.printStudents(conexiune.connection);
            
            CourseOperations.insert(conexiune.connection, course);
            CourseOperations.printcourses(conexiune.connection);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
