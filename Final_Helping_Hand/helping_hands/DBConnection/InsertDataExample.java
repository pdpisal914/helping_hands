import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataExample {
    public static void main(String[] args) {
        
        try {
            // Establish a database connection
            Connection connection = ConnectionProvider.getConnection();

            // Define the SQL query for inserting data
            String sql = "INSERT INTO prouctinfo (userName, itemName, itemType, cityName, pic, info) VALUES (?, ?, ?, ?, ?, ?)";

            // Prepare the statement with parameters
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Ram");
            preparedStatement.setString(2, "T-shirt");
            preparedStatement.setString(3,"Fashion");
            preparedStatement.setString(4, "Pune");
            preparedStatement.setString(5,"C:\\Users\\HP\\OneDrive\\Documents\\header_t-shirts2.avif"); //"/path/to/your/image.jpg");
            preparedStatement.setString(6, "This is branded t-shirt");

            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Data insertion failed.");
            }

            // Close the resources
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
