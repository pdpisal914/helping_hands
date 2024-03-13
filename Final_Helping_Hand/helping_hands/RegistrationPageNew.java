import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class RegistrationPageNew extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    
    public static void registrationMethod(){
        Stage primaryStage = new Stage();
        DropShadow dropShadow = new DropShadow();
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Register To Helping Hands");

        Image leftImage = new Image("./Images/registration1.png");
        ImageView leftImageView = new ImageView(leftImage);
        leftImageView.setFitWidth(650); // Set the width
        leftImageView.setFitHeight(1000); // Set the height

        Image rightImage = new Image("./Images/registration2.png");
        ImageView rightImageView = new ImageView(rightImage);
        rightImageView.setFitWidth(650); // Set the width
        rightImageView.setFitHeight(1000); // Set the height
       
        BorderPane borderPane = new BorderPane();
        HBox hBox = new HBox();

        GridPane gridPane = new GridPane();
         gridPane.setMinWidth(630);
        gridPane.setMinHeight(1000);
        gridPane.setMaxWidth(630);
        gridPane.setMaxHeight(1000);
        gridPane.setPadding(new Insets(350,0,0,100));
        gridPane.setVgap(30);
        
       
        gridPane.setStyle("-fx-background-color: white;");
        //HBox hbox1 = new HBox(20);
        Label username = new Label("User Name:");
        username.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
        TextField userField = new TextField();
        //hbox1.getChildren().addAll(username,userField);

        //HBox hbox2 = new HBox(20);
        Label emailLabel2 = new Label("Email:");
        emailLabel2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
        TextField emailField2 = new TextField();
        //hbox2.getChildren().addAll(emailLabel2,emailField2);

        //HBox hbox3 = new HBox(20);
        Label mobLabel = new Label("Contact No:");
        mobLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
        TextField mobField = new TextField();
        //hbox3.getChildren().addAll(mobLabel,mobField);

        //HBox hbox4 = new HBox(20);
        Label password = new Label("Password:");
        password.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
        PasswordField passwordField2 = new PasswordField();
        //hbox4.getChildren().addAll(password,passwordField2);

        //HBox hbox5 = new HBox(20);
        Label confirmpassword = new Label("Confirm Password:");
        confirmpassword.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25));
        PasswordField confirmpasswordField = new PasswordField();
       // hbox5.getChildren().addAll(confirmpassword,confirmpasswordField);

        Button submit = new Button("Submit");
        submit.setOnMouseEntered(event -> {
            submit.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        submit.setOnMouseExited(event -> {
            submit.setEffect(null);
        });
        submit.setStyle("-fx-font-weight: bold; -fx-font-size: 24px; -fx-font-family: 'Times New Roman'; -fx-background-color: #00C8E8;");
        submit.setOnAction(e -> {
            submit.setEffect(null);
            String userName = userField.getText();
            String email = emailField2.getText();
            String contactNo = mobField.getText();
            String password1 = passwordField2.getText();
            String confirmPassword = confirmpasswordField.getText();

            userField.clear();
            emailField2.clear();
            mobField.clear();
            passwordField2.clear();
            confirmpasswordField.clear();

            InsertUser.insertUsersData(primaryStage,userName, email, contactNo, password1, confirmPassword);
        });
        Button backButton = new Button("Back");
        backButton.setOnMouseEntered(event -> {
            backButton.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        backButton.setOnMouseExited(event -> {
            backButton.setEffect(null);
        });
        backButton.setStyle("-fx-font-weight: bold; -fx-font-size: 24px; -fx-font-family: 'Times New Roman'; -fx-background-color: #FF0000;");
        backButton.setOnAction(e->{
            backButton.setEffect(dropShadow);
           primaryStage.close();        });

        gridPane.add(username, 0, 0);
        gridPane.add(userField, 1, 0);
        gridPane.add(emailLabel2, 0, 1);
        gridPane.add(emailField2, 1, 1);
        gridPane.add(mobLabel, 0, 2);
        gridPane.add(mobField, 1, 2);
        gridPane.add(password, 0, 3);
        gridPane.add(passwordField2, 1, 3);
        gridPane.add(confirmpassword, 0, 4);
        gridPane.add(confirmpasswordField, 1, 4);
        gridPane.add(submit, 1, 5);
        gridPane.add(backButton,0,5);

        //VBox vbox = new VBox(50);
        //vbox.getChildren().addAll(hbox1,hbox2,hbox3,hbox4,hbox5);
         
        hBox.getChildren().addAll(leftImageView,gridPane, rightImageView);

    // Set the StackPane as the root of your scene
    borderPane.setCenter(hBox);

        // Create a Scene and add the BorderPane to it
        Scene scene = new Scene(borderPane, 800, 600);
       // return scene;
        primaryStage.setScene(scene);
        primaryStage.show();
        //return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }
}

