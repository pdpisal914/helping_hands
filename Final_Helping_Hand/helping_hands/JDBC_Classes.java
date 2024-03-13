import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

public class JDBC_Classes {
public static FileInputStream fs=null;
    public static void insertData(String userName,String name,String type,String city,File imgFile,String description,String address){

        try {
            // Establish a database connection
            Connection connection = ConnectionProvider.getConnection();

            // Define the SQL query for inserting data
            String sql = "INSERT INTO pinfo (userName,itemName, itemType, cityName, pic, info,address) VALUES (?,?,?,?,?,?,?)";

            // Prepare the statement with parameters
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, type);
            preparedStatement.setString(4,city);
            
            try {
                fs = new FileInputStream(imgFile);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            preparedStatement.setBinaryStream(5,fs, (int)imgFile.length());
           // preparedStatement.setString(5,"C:\\Users\\HP\\OneDrive\\Documents\\header_t-shirts2.avif"); //"/path/to/your/image.jpg");
            preparedStatement.setString(6, description);
            preparedStatement.setString(7, address);

            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                showPopup("Succesfully Data Inserted....");
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Data insertion failed.");
            }

            // Close the resources
            preparedStatement.close();
           // connection.close();

        } catch (SQLException e) {
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
