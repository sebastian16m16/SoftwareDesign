package mysql.mysql_connector_java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentOperations{

    public static void printStudents(Connection connection) throws SQLException{
        System.out.println("Creating Statement...");
        Statement stmt = connection.createStatement();
        String sqlQuery = "SELECT * FROM student";
        ResultSet queryResult = stmt.executeQuery(sqlQuery);

        while(queryResult.next()){
            //retrieve by column name
            int id = queryResult.getInt("stud_id");
            String name = queryResult.getString("nume");
            String birthday = queryResult.getString("birthday");
            String address = queryResult.getString("address");
            
            //Display values
            System.out.println("ID: " + id + ", Nume: " + name + ", Birthday: " + birthday + ", Address: " + address);
            
        }
        queryResult.close();
        stmt.close();
    }

    public static void insert(Connection con, Student student) throws SQLException{
        String statement = "INSERT INTO student (nume, birthday, address) VALUES (?, ?, ?)";
        PreparedStatement prepSt = con.prepareStatement(statement);

        prepSt.setString(1, student.getNume());
        prepSt.setString(2, student.getBirthday());
        prepSt.setString(3, student.getAddress());

        prepSt.executeUpdate();
    }

    public static Student readStudentValues(){
        Student stud = new Student();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" + "1 to enter a new student \n" + "0 to quit");

        while(!quit){
            System.out.println("Choose and option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;                    
                    break;
                case 1:
                    System.out.println("Enter Student name: ");
                    String name = scanner.nextLine();
                    stud.setNume(name);
                    System.out.println("Enter Student birthday: ");
                    String birthday = scanner.nextLine();
                    stud.setBirthday(birthday);
                    System.out.println("Enter Student address: ");
                    String address = scanner.nextLine();
                    stud.setAddress(address);
                    break;
            
                default:
                    break;
            }
        }
        return stud;
    }
}