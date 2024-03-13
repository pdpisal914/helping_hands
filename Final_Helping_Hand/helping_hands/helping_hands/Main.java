import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {

    private static ImageView profileImage;
    private static Scene mainScene; 

    @Override
    public void start(Stage primaryStage) {

        // Create a StackPane as the root layout
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        mainScene=scene;

        // Create a VBox for the left side
        VBox leftVBox = new VBox(20);
        leftVBox.setPrefWidth(200); // Adjust the width as needed
        leftVBox.setStyle("-fx-background-color: lightblue;"); // Set background color

        // Add an ImageView at the top
        ImageView profileImage = new ImageView(new Image("profile.jpg")); // Provide the path to your profile image
        profileImage.setFitWidth(150); // Adjust the image width
        profileImage.setFitHeight(150);
        profileImage.setTranslateX(50);
        profileImage.setTranslateY(50); // Adjust the image height
        leftVBox.getChildren().add(profileImage);

        // Add text for "Experience"
        Text experienceText = new Text("EXPERIENCE");
        experienceText.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
        experienceText.setFill(Color.BLACK);
        experienceText.setTranslateX(60);
        experienceText.setTranslateY(60);
        leftVBox.getChildren().add(experienceText);

        // Add the first ComboBox
        ComboBox<String> comboBox1 = new ComboBox<>();
        comboBox1.setPromptText("Donated list "); 
        comboBox1.getItems().addAll("Option 1", "Option 2", "Option 3");
        comboBox1.setTranslateX(60);
        comboBox1.setTranslateY(60);
        comboBox1.getStyleClass().add("combo-box"); // Add your ComboBox items
        leftVBox.getChildren().add(comboBox1);

        // Add the second ComboBox
        ComboBox<String> comboBox2 = new ComboBox<>();
        comboBox2.setPromptText("Received List "); 
        comboBox2.getItems().addAll("Item A", "Item B", "Item C");
        comboBox2.setTranslateX(60);
        comboBox2.setTranslateY(60);
        comboBox2.getStyleClass().add("combo-box"); // Add your ComboBox items
        leftVBox.getChildren().add(comboBox2);

        Image aboutImage = new Image("aboutlogo.png");
        ImageView aboutImageView = new ImageView(aboutImage);
        aboutImageView.setFitHeight(20);
        aboutImageView.setFitWidth(20);

        Label aboutlabel = new Label("About", aboutImageView);
        aboutlabel.setTranslateX(3);
        aboutlabel.setTranslateY(-250);
        aboutlabel.getStyleClass().add("label");
        //aboutlabel.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));

        Text nameText = new Text("Name");
        nameText.setFont(Font.font("System", FontPosture.ITALIC, 24));
        nameText.setFill(Color.BLACK);
        nameText.setTranslateX(40); 
        nameText.setTranslateY(-200);

        Label loclabel = new Label("Location");
        loclabel.setTranslateX(20);
        loclabel.setTranslateY(-160);
        loclabel.getStyleClass().add("labelvalue");

        Label emailLabel = new Label("Email:");
        Label phoneLabel = new Label("Phone:");
        Label addrLabel = new Label("Address:");

        emailLabel.getStyleClass().add("label");
        phoneLabel.getStyleClass().add("label");
        addrLabel.getStyleClass().add("label");
        
        emailLabel.setTranslateX(1);
        emailLabel.setTranslateY(-40);
        phoneLabel.setTranslateX(1);
        phoneLabel.setTranslateY(40);
        addrLabel.setTranslateX(5);
        addrLabel.setTranslateY(120);

        Label emailValue = new Label("abc@gmail.com");
        Label phoneValue = new Label("9999999999");
        Label addrValue = new Label("Wahlheker properties,\nNarhe,Pune");

        emailValue.getStyleClass().add("labelvalue");
        phoneValue.getStyleClass().add("labelvalue");
        addrValue.getStyleClass().add("labelvalue");
        
        emailValue.setTranslateX(100);
        emailValue.setTranslateY(-40);
        phoneValue.setTranslateX(100);
        phoneValue.setTranslateY(40);
        addrValue.setTranslateX(130);
        addrValue.setTranslateY(135);

        Button editButton = new Button("EditProfile");
        Button homeButton = new Button("HomePage");

        editButton.getStyleClass().add("profile-button");
        homeButton.getStyleClass().add("profile-button");

        editButton.setTranslateX(300);
        editButton.setTranslateY(-250);
        homeButton.setTranslateX(20);
        homeButton.setTranslateY(260);

        editButton.setOnAction(e -> changeScene(primaryStage));
        homeButton.setOnAction(e -> System.out.println("Home"));
        


        // Add the left VBox to the StackPane
        root.getChildren().addAll(leftVBox,aboutlabel,nameText,loclabel,emailLabel,phoneLabel,addrLabel,emailValue,phoneValue,addrValue,editButton,homeButton);
        
        primaryStage.setTitle(" Profile Page");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Profile");
        primaryStage.getIcons().add(new Image("profileicon.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    static Stage stage1=null;
    public static void changeScene(Stage s) {
         stage1 = new Stage();

        StackPane root = new StackPane();

        profileImage = new ImageView(new Image("profile.jpg")); // Provide the path to your profile image
        profileImage.setFitWidth(150); // Adjust the image width
        profileImage.setFitHeight(150);
        profileImage.setTranslateX(10);
        profileImage.setTranslateY(-180);

        Button saveButton = new Button("SAVE");
        saveButton.setTranslateX(350);
        saveButton.setTranslateY(-260);

        Button homeButton2 = new Button("HOMEPAGE");
        homeButton2.setTranslateX(30);
        homeButton2.setTranslateY(270);

        Button profileButton = new Button("CHANGE PROFILE");
        profileButton.setTranslateX(10);
        profileButton.setTranslateY(-60);

        Label nameLabel = new Label("Name:");
        Label emailLabel = new Label("Email:");
        Label phoneLabel = new Label("Phone:");
        Label addrLabel = new Label("Address:");

        nameLabel.getStyleClass().add("label");
        emailLabel.getStyleClass().add("label");
        phoneLabel.getStyleClass().add("label");
        addrLabel.getStyleClass().add("label"); 

        nameLabel.setTranslateX(-120);
        nameLabel.setTranslateY(20);
        emailLabel.setTranslateX(-120);
        emailLabel.setTranslateY(80);
        phoneLabel.setTranslateX(-120);
        phoneLabel.setTranslateY(140);
        addrLabel.setTranslateX(-120);
        addrLabel.setTranslateY(200);

        TextField name = new TextField();
        name.setPrefWidth(200); // Set the preferred width
        name.setPrefHeight(25); // Set the preferred height

        TextField email = new TextField();
        email.setPrefWidth(200); // Set the preferred width
        email.setPrefHeight(25); // Set the preferred height

        TextField phone = new TextField();
        phone.setPrefWidth(200); // Set the preferred width
        phone.setPrefHeight(25); // Set the preferred height

        TextField add = new TextField();
        add.setPrefWidth(200); // Set the preferred width
        add.setPrefHeight(25); // Set the preferred height

          name.setPromptText("Enter name");
          email.setPromptText("Enter email");
          phone.setPromptText("Enter mobile number");
          add.setPromptText("Enter address");
    

        saveButton.getStyleClass().add("profile-button");
        homeButton2.getStyleClass().add("profile-button");
        profileButton.getStyleClass().add("profile-button");

        saveButton.setOnAction(e ->openWindow());
        //homeButton2.setOnAction(e ->);
        profileButton.setOnAction(e -> openFile(stage1));

        VBox vbox = new VBox(36);
        vbox.getChildren().addAll(name,email,phone,add);
        vbox.setPadding(new Insets(310,0,0,25));
        vbox.setMaxWidth(200);

        root.getChildren().addAll(vbox,saveButton,homeButton2,profileButton,profileImage,nameLabel,phoneLabel,addrLabel,emailLabel);
        Scene scene1 = new Scene(root, 800, 600,Color.LIGHTBLUE);
        scene1.getStylesheets().add(Main.class.getResource("styles.css").toExternalForm());
        stage1.setTitle("Edit profile");
        stage1.setScene(scene1);
        stage1.show();

    }
    public static void closemid(){
        stage1.close();

    }

    public static void openFile(Stage stage2){

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image files","*.jpg","*.png","*.gif"));

        File selectedFile = fileChooser.showOpenDialog(stage2);

        if(selectedFile != null){
            Image image = new Image(selectedFile.toURI().toString());
            profileImage.setImage(image);
        }
    }

    public static void openWindow(){
           Stage stage = new Stage();
            
           Button okbutton = new Button("OK");
           okbutton.getStyleClass().add("profile-button");
           okbutton.setTranslateX(0);
           okbutton.setTranslateY(80);

           okbutton.setOnAction(e -> {
            closemid();
            stage.close();
           });

           StackPane stackPane = new StackPane();
           Label label = new Label("Your data has Been saved!!");
           label.setStyle("-fx-font-size:20");

           stackPane.getChildren().addAll(label,okbutton);
           Scene scene = new Scene(stackPane,250,250);
           stage.setScene(scene);
           stage.setTitle("Data saved");
           stage.showAndWait(); 

    }
}

// class DatabaseUtil {
//     private static final String DB_URL = "jdbc:mysql://localhost:3306/helping_hands_db"; // Replace with your database
//                                                                                          // URL
//     private static final String DB_USER = "root"; // Replace with your database username
//     private static final String DB_PASSWORD = "mine0099"; // Replace with your database password

//     public static Connection getConnection() throws SQLException {
//         return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//     }
//}

