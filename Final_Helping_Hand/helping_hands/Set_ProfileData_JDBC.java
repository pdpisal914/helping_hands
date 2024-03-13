import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

public class Set_ProfileData_JDBC {
    private static Connection connection = ConnectionProvider.getConnection();

    public static void setUserEmail(String oldEmail, String newEmail) {
        String query = "UPDATE users SET email = ? WHERE email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newEmail);
            preparedStatement.setString(2, oldEmail);
            preparedStatement.executeUpdate();
             showPopup("EmailId Is Succesfully Updated..");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void setUsername(String email, String newUsername) {
        String query = "UPDATE users SET username = ? WHERE email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newUsername);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
            showPopup("UserName Is Succesfully Updated..");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setContactNo(String email, String newContactNo) {
        String query = "UPDATE users SET contact_no = ? WHERE email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newContactNo);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
            showPopup("Contact Is Succesfully Updated..");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setAddress(String email, String newAddress) {
        String query = "UPDATE users SET address = ? WHERE email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newAddress);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
            showPopup("Address Is Succesfully Updated..");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
public static FileInputStream fs=null;
        public static void updateProfilePhoto(String email, File newImageFile) {
            String query = "UPDATE users SET profile_photo = ? WHERE email = ?";
            try {
                // Read the content of the image file
                FileInputStream imageInputStream = new FileInputStream(newImageFile);
                byte[] imageData = new byte[(int) newImageFile.length()];
                imageInputStream.read(imageData);
                imageInputStream.close();
    
                // Prepare and execute the SQL update statement
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setBytes(1, imageData);
                preparedStatement.setString(2, email);
                preparedStatement.executeUpdate();
                showPopup("Profile Photo Is Succesfully Updated..");
                

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    public static void showPopup(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        ButtonType okButton = new ButtonType("OK", ButtonData.OK_DONE);
        alert.getButtonTypes().setAll(okButton);

        Button ok = (Button) alert.getDialogPane().lookupButton(okButton);
        ok.setOnAction(e -> alert.close());

        alert.showAndWait();
    }
}

    
