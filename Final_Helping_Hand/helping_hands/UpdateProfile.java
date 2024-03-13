import java.io.File;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UpdateProfile extends Application {

    private static ImageView profileImage;
    static String nameString = null;
    static String emailString =null;
    static String phoneString = null;
    static String addString = null;
    static File imgFile=null;
    static Rectangle largeProductBox=null;

    
    public static void updateProfileData(){
        
        Stage primaryStage = new Stage();
        DropShadow dropShadow = new DropShadow();
        primaryStage.setMaximized(true);
        StackPane stackPane = new StackPane();
       

        // Background image
        Image backgroundImage = new Image("./Images/61-1.jpg");
        BackgroundImage background = new BackgroundImage(
            backgroundImage,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER, // Center the background image
            new BackgroundSize(
                1, // Width
                1, // Height
                true, // Width As Percentage
                true, // Height As Percentage
                false, // Width And Height Are Absolute
                false // Cover
            )
        );
        stackPane.setBackground(new Background(background));

        HBox mainBox = new HBox();

        GridPane grid = new GridPane();
        grid.setMinWidth(900);
        grid.setMinHeight(1000);
        grid.setMaxWidth(900);
        grid.setMaxHeight(1000);
        grid.setPadding(new Insets(350,0,0,150));
        grid.setVgap(30);
        grid.setHgap(50);
       
         largeProductBox = new Rectangle(300, 300); // Adjust size
        Image profileImage = new Image("./Images/profile.jpg");
        //ImageView profileImageView = new ImageView(profileImage);
        //profileImageView.setFitWidth(300);
        //profileImageView.setFitHeight(300);
        largeProductBox.setStroke(Color.WHITE);
        largeProductBox.setStrokeWidth(5);
        largeProductBox.setOnMouseEntered(event -> {
            largeProductBox.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        largeProductBox.setOnMouseExited(event -> {
            largeProductBox.setEffect(null);
        });
        //Image pdImage = new Image("file:C:\\Users\\Pranav Pisal\\helping_hands\\Images\\landscape.png");
        setImage(profileImage);
        

       /*  Label name = new Label("User Name: ");
        name.setStyle("-fx-font-weight: bold; -fx-font-size: 30px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");
        TextField textName = new TextField();
        textName.setPrefSize(200, 24);
        textName.setPromptText("Enter The Name");
        Button updateName = new Button("Update");
        updateName.setOnAction(e->{
            String newName = textName.getText();
            Set_ProfileData_JDBC.setUsername(emailString, newName);
        });
        updateName.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-font-family: 'Times New Roman'; -fx-background-color: #FFFFFF;");
        */
        Label phone = new Label("Contact No.:");
        phone.setStyle("-fx-font-weight: bold; -fx-font-size: 30px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");
        TextField textPhone = new TextField();
        textPhone.setPrefSize(200, 24);
        textPhone.setPromptText("Enter The Contact No :");
        Button updatePhone = new Button("Update");
        updatePhone.setOnMouseEntered(event -> {
            updatePhone.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        updatePhone.setOnMouseExited(event -> {
            updatePhone.setEffect(null);
        });
        updatePhone.setOnAction(e->{
            updatePhone.setEffect(dropShadow);
            String newPhone = textPhone.getText();
            Set_ProfileData_JDBC.setContactNo(emailString, newPhone);
        });
        updatePhone.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-font-family: 'Times New Roman'; -fx-background-color: #FFFFFF;");
      


        Label address = new Label("Address: ");
        address.setStyle("-fx-font-weight: bold; -fx-font-size: 30px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");
        TextField textAddress = new TextField();
        textAddress.setPrefSize(200, 24);
        textAddress.setPromptText("Enter Address :");
        Button updateAddress = new Button("Update");
         updateAddress.setOnMouseEntered(event -> {
            updateAddress.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        updateAddress.setOnMouseExited(event -> {
            updateAddress.setEffect(null);
        });
        updateAddress.setOnAction(e->{
            updateAddress.setEffect(dropShadow);
            String newAddress = textAddress.getText();
            Set_ProfileData_JDBC.setAddress(emailString, newAddress);
        });
        updateAddress.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-font-family: 'Times New Roman'; -fx-background-color: #FFFFFF;");


        Label email = new Label("EmailId: ");
        email.setStyle("-fx-font-weight: bold; -fx-font-size: 30px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");
        TextField textEmail = new TextField();
        textEmail.setPrefSize(200, 24);
        textEmail.setPromptText("Enter EmailId :");
        Button updateEmail = new Button("Update");
         updateEmail.setOnMouseEntered(event -> {
            updateEmail.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        updateEmail.setOnMouseExited(event -> {
            updateEmail.setEffect(null);
        });
        updateEmail.setOnAction(e->{
            updateEmail.setEffect(dropShadow);
            String newEmail = textEmail.getText();

            Set_ProfileData_JDBC.setUserEmail(emailString, newEmail);
            emailString=newEmail;
        });
        updateEmail.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-font-family: 'Times New Roman'; -fx-background-color: #FFFFFF;");
        
         Button backButton = new Button("Back");
          backButton.setOnMouseEntered(event -> {
            backButton.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        backButton.setOnMouseExited(event -> {
            backButton.setEffect(null);
        });
        backButton.setOnAction(e->{
            backButton.setEffect(dropShadow);
            primaryStage.close();
        });
        backButton.setPrefSize(150, 20);
        backButton.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-font-family: 'Times New Roman'; -fx-background-color: #9932CC;");
        
       
      //  grid.add(name, 0, 0);
        //grid.add(textName, 1, 0);
       // grid.add(updateName,2,0);

        grid.add(email, 0, 0);
        grid.add(textEmail, 1, 0);
        grid.add(updateEmail,2,0);

        grid.add(phone, 0, 1);
        grid.add(textPhone, 1, 1);
        grid.add(updatePhone,2,1);

        grid.add(address, 0, 2);
        grid.add(textAddress, 1, 2);
        grid.add(updateAddress,2,2);

        grid.add(backButton,1,3);



         Button selectImageButton = new Button("Update Profile");
         selectImageButton.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-font-family: 'Times New Roman'; -fx-background-color: #FF8C00;");
          selectImageButton.setOnMouseEntered(event -> {
            selectImageButton.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        selectImageButton.setOnMouseExited(event -> {
            selectImageButton.setEffect(null);
        });
        selectImageButton.setPrefWidth(250);
        selectImageButton.setPrefHeight(30);
        largeProductBox.setOnMouseClicked(e -> {
            largeProductBox.setEffect(dropShadow);
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                Image image = new Image(file.toURI().toString());
               imgFile = file;
                Platform.runLater(() -> {
                    setImage(image);
                });
            }
        });
        selectImageButton.setOnAction(e->{
            selectImageButton.setEffect(dropShadow);
            Set_ProfileData_JDBC.updateProfilePhoto(emailString, imgFile);
        });
       
        VBox vbox = new VBox();
        vbox.setPrefWidth(400); 
        

        vbox.getChildren().addAll(largeProductBox,selectImageButton);
        vbox.setPadding(new Insets(300, 0, 0, 450));

        mainBox.getChildren().addAll(vbox, grid);

        stackPane.getChildren().add(mainBox);

        Scene scene = new Scene(stackPane, 800, 600);

        primaryStage.setTitle("UPDATE PROFILE");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("./Images/3.jpg"));
        primaryStage.show();
    }

    public static void setImage(Image image){
        largeProductBox.setFill(new ImagePattern(image));
    }

    public static void setUserEmail(String email){
        emailString=email;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }

    
}

