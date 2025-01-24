import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Account {
    private static final String url = "jdbc:mysql://localhost:3306/mydc";

    private static final  String username = "root";

    private static final  String password = "Ayushman@22";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
//            System.out.println(e.getException());
        }
        try {
            Connection connection = DriverManager.getConnection( url,username,password);
            String debit_query = "UPDATE account SET balance = balance - ? WHERE account_number = ? " ;
//            String credit_query = "UPDATE account SET balance = balance + ? WHERE account_number = ? " ;
            PreparedStatement debitpreparedStatement = connection.prepareStatement(debit_query);
//            PreparedStatement creditpreparedStatement = connection.prepareStatement(credit_query);
            debitpreparedStatement.setDouble(1,500);





        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
