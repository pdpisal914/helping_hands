import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LimittedData {
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static void main(String[] args) {

        Connection connection = null;
    
        try {
            // Establish the database connection
            connection = ConnectionProvider.getConnection();

            // SQL query to retrieve the first 8 rows of data
            String sql = "SELECT * FROM prouctinfo LIMIT 1";
            preparedStatement = connection.prepareStatement(sql);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Process the results
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String itemName = resultSet.getString("itemName");
                String itemType = resultSet.getString("itemType");
                String cityName = resultSet.getString("cityName");
                // You can retrieve other columns similarly

                System.out.println("ID: " + id);
                System.out.println("User Name: " + userName);
                System.out.println("Item Name: " + itemName);
                System.out.println("Item Type: " + itemType);
                System.out.println("City Name: " + cityName);
                // Output other columns as needed
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
