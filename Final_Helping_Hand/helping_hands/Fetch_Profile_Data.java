import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.image.Image;

public class Fetch_Profile_Data {
    private static Connection connection = ConnectionProvider.getConnection();
    
    public static Image getProfileImage(String email) {
        try {
    
            // Retrieve the profile image data from the 'users' table by user ID
            String selectQuery = "SELECT profile_photo FROM users WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
    
            if (resultSet.next()) {
                // Read the image data as bytes and create an Image
                byte[] imageBytes = resultSet.getBytes("profile_photo");
                return new Image(new ByteArrayInputStream(imageBytes));
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
    
    

    public static String getUsernameByEmail(String email) {
        String query = "SELECT username FROM users WHERE email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("username");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no match is found.
    }

    public static String getContactNoByEmail(String email) {
        String query = "SELECT contact_no FROM users WHERE email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("contact_no");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no match is found.
    }

    public static String getAddressByEmail(String email) {
        String query = "SELECT address FROM users WHERE email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("address");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no match is found.
    }
}
