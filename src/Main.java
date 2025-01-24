import com.mysql.cj.Query;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/mydc";

    private static final  String username = "root";

    private static final  String password = "Ayushman@22";
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getException());
        }
        try {
            Connection connection = DriverManager.getConnection( url,username,password);
            Statement statement = connection.createStatement();
//            String query = String.format("INSERT INTO student (name , age , marks)VALUES('%s',%o,%f)","Ayushman",56,72.3);

//            String query = String.format(("UPDATE student SET marks = %f WHERE ID = %d"), 52.6,2);
            String query = "DELETE FROM student  WHERE ID = 1" ;


//           String query = " select * from student";
//           ResultSet resultSet = statement.executeQuery(query);
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected>0) {
//                System.out.println("Value is update is done !");
                System.out.println("Value is DELETED is done !");

            }else {
                System.out.println("Value is not DELETED");
            }

//           while (resultSet.next()){
//               int id = resultSet.getInt("id");
//               String name = resultSet.getNString("name");
//               int age = resultSet.getInt("age");
//               double marks = resultSet.getDouble("marks");
//               System.out.println("id :"+ id+" name:"+name+" age: "+ age+ " marks:"+marks);
//
//
//           }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}