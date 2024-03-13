import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPageNew extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public static Stage primaryStage=null;
    static TextField usernameField=null;
    static PasswordField passwordField=null;

    @Override
    public void start(Stage primary) {
        primaryStage=primary;
        primaryStage.setMaximized(true);
        DropShadow dropShadow = new DropShadow();
        primaryStage.setTitle("Login To Helping Hands");

        // Create a BorderPane to hold the HBox
        BorderPane borderPane = new BorderPane();

        // Create an HBox to divide the window into three vertical parts
        HBox hBox = new HBox();

        // Create the Top, Center, and Bottom parts as Text elements
        Text center = new Text("Center");
        Text bottom = new Text("Bottom");

        // Add an image to the Top part
       /*  Image image = new Image("file:C:\\Users\\Pranav Pisal\\helping_hands\\Images\\53.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(600); // Set the width
        imageView.setFitHeight(1000); // Set the height
        */

        // Create images for the left and right sides
        Image leftImage = new Image("./Images/53.jpg");
        ImageView leftImageView = new ImageView(leftImage);
        leftImageView.setFitWidth(650); // Set the width
        leftImageView.setFitHeight(1000); // Set the height

        Image rightImage = new Image("./Images/55.jpg");
        ImageView rightImageView = new ImageView(rightImage);
        rightImageView.setFitWidth(650); // Set the width
        rightImageView.setFitHeight(1000); // Set the height

        GridPane gridPane = new GridPane();
        gridPane.setMinWidth(630);
        gridPane.setMinHeight(1000);
        gridPane.setMaxWidth(630);
        gridPane.setMaxHeight(1000);
        gridPane.setPadding(new Insets(350,0,0,150));
        gridPane.setVgap(25);
       
        gridPane.setStyle("-fx-background-color: white;");
        

        Label usernameLabel = new Label("Email_Id:");
        //usernameLabel.setTextFill(Color.WHITE);
        usernameLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
        usernameField = new TextField();
        usernameField.setPromptText("Enter The Email_Id : ");
        usernameField.setMinSize(200, 35);
        usernameField.addEventFilter(MouseEvent.MOUSE_DRAGGED, event -> {
            usernameField.setEffect(dropShadow);
        });

        // Remove effect when the mouse is dragged out of the TextField
        usernameField.addEventFilter(MouseEvent.MOUSE_EXITED, event -> {
            usernameField.setEffect(null);
        });

        Label passwordLabel = new Label("Password:");
       // passwordLabel.setTextFill(Color.WHITE);
        passwordLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
        passwordField = new PasswordField();
       
        passwordField.setMinSize(200,35);
        passwordField.setPromptText("Enter The Password : ");

         Button loginButton = new Button("Login");
         loginButton.setOnMouseEntered(event -> {
            loginButton.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        loginButton.setOnMouseExited(event -> {
            loginButton.setEffect(null);
        });
         loginButton.setStyle("-fx-font-weight: bold; -fx-font-size: 24px; -fx-font-family: 'Times New Roman'; -fx-background-color: #2BCAD0;");
 /*       loginButton.setOnAction(e -> {
           // loginButton.setEffect(dropShadow);
        String email = usernameField.getText();
        String password = passwordField.getText();
        Connection conn = ConnectionProvider.getConnection();

       
        try {
            // Use a parameterized query to avoid SQL injection
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            ResultSet resultSet = stmt.executeQuery();
            
            if (resultSet.next()) {
                // User with matching email and password found
                Profile_Page_pdp.setUserEmail(email);
                UpdateProfile.setUserEmail(email);
               usernameField.clear();
               passwordField.clear();
               HomePage.homePage();
               
                //showPopup("Login Successful");
                primaryStage.close();
           // C:\Users\Pranav Pisal\OneDrive\Desktop\Final_Helping_Hand\helping_hands\DBConnection\ConnectionProvider.java
            } else {
                // No matching user found
                 usernameField.clear();
               passwordField.clear();
                showPopup("Error: Invalid email or password");
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
             usernameField.clear();
               passwordField.clear();
            showPopup("Error: Login failed");
        }
    });
    */

    loginButton.setOnAction(e->{
        //HomePage.homePage();
        LoginPageNew.JDBC();
    });
    
    Button registerButton = new Button("Register");
     registerButton.setOnMouseEntered(event -> {
            registerButton.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        registerButton.setOnMouseExited(event -> {
            registerButton.setEffect(null);
        });

        registerButton.setStyle("-fx-font-weight: bold; -fx-font-size: 24px; -fx-font-family: 'Times New Roman'; -fx-background-color: #FF0000;");
      //  registerButton.setStyle("-fx-font-size: 24px; -fx-font-family: 'Times New Roman';");
       registerButton.setOnAction(e -> {
            registerButton.setEffect(dropShadow);
            RegistrationPageNew.registrationMethod();    
        
        });

        gridPane.add(usernameLabel, 2, 0);
        gridPane.add(usernameField, 3, 0);
        
        gridPane.add(passwordLabel, 2, 3);
        gridPane.add(passwordField, 3, 3);

        gridPane.add(loginButton, 2, 5);
        gridPane.add(registerButton, 3, 5);



        hBox.getChildren().addAll(leftImageView,gridPane, rightImageView);

        // Set the HBox in the BorderPane's center
        borderPane.setCenter(hBox);

        // Create a Scene and add the BorderPane to it
        Scene scene = new Scene(borderPane, 800, 600);
         

        primaryStage.setScene(scene);
        primaryStage.show();
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

    public static void JDBC(){
        
           // loginButton.setEffect(dropShadow);
        String email = usernameField.getText();
        String password = passwordField.getText();
        Connection conn = ConnectionProvider.getConnection();

       
        try {
            // Use a parameterized query to avoid SQL injection
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            ResultSet resultSet = stmt.executeQuery();
            
            if (resultSet.next()) {
                // User with matching email and password found
                Profile_Page_pdp.setUserEmail(email);
                UpdateProfile.setUserEmail(email);
               //usernameField.clear();
              // passwordField.clear();
               HomePage.homePage();
               
                //showPopup("Login Successful");
                primaryStage.close();
            
            } else {
                // No matching user found
               //  usernameField.clear();
               //passwordField.clear();
                showPopup("Error: Invalid email or password");
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
             //usernameField.clear();
               //passwordField.clear();
            showPopup("Error: Login failed");
        }
    }
}
