import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.stage.Stage;

public class InsertUser {
 
   static void insertUsersData(Stage primaryStageOfRegistration,String userName, String email, String contactNo, String password1, String confirmPassword){

       /*  String userName = "shraddha";
        String email = "shraddha@gmail.com";
        String contactNo = "1234567891";
        String password1 = "12345";
        String confirmPassword = "12345"; */
            Connection conn = ConnectionProvider.getConnection();
           
            if (password1.equals(confirmPassword)) {

                try {
                   
                    String sql = "INSERT INTO users (userName, email, contact_no, password) VALUES (?, ?, ?, ?)";
                     PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, userName);
                        stmt.setString(2, email);
                        stmt.setString(3, contactNo);
                        stmt.setString(4, password1);
                       // stmt.executeUpdate();

                        int rowsAffected = stmt.executeUpdate();

                        if(rowsAffected >0){
                           //System.out.println("Registration Successful");
                           LoginPageNew.showPopup("Registration Successful");
                            primaryStageOfRegistration.close();

                        }
                    
                  //  showPopup("Registration Successful");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                   //System.out.println("Rgister failed");
                   LoginPageNew.showPopup("Error: Registration failed");
                  
                }
            } else {
                LoginPageNew.showPopup("Error: Passwords do not match");
               // System.out.println("Password does not match");
            }
    }


}