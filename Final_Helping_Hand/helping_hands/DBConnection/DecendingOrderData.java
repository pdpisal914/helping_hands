import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DecendingOrderData {
    public static void main(String[] args) {
       /*  String jdbcUrl = "jdbc:mysql://your_database_host:your_database_port/your_database_name";
        String username = "your_username";
        String password = "your_password";  */

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish the database connection
            connection = ConnectionProvider.getConnection();

            // SQL query to retrieve the last 8 rows of data
            String sql = "SELECT * FROM (SELECT * FROM prouctinfo ORDER BY id DESC LIMIT 1) sub ORDER BY id ASC";
            preparedStatement = connection.prepareStatement(sql);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Process the results
            List<String> results = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String itemName = resultSet.getString("itemName");
                String itemType = resultSet.getString("itemType");
                String cityName = resultSet.getString("cityName");
                // You can retrieve other columns similarly

                String result = "ID: " + id + "\n" +
                                "User Name: " + userName + "\n" +
                                "Item Name: " + itemName + "\n" +
                                "Item Type: " + itemType + "\n" +
                                "City Name: " + cityName + "\n";
                // Append other columns as needed

                results.add(result);
            }

            // Print the results in reverse order (last 8 rows)
            for (int i = results.size() - 1; i >= 0; i--) {
                System.out.println(results.get(i));
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
