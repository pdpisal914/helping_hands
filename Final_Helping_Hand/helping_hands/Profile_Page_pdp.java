import javafx.application.Application;
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
import javafx.stage.Stage;

public class Profile_Page_pdp extends Application {

    private static Image profileImage;
    static String nameString = null;
    static String emailString =null;
    static String phoneString = null;
    static String addString = null;
    
    public static Rectangle rectangleBox = null;

    
    public static void profilePage() {
        Stage primaryStage = new Stage();
        DropShadow dropShadow = new DropShadow();
        primaryStage.setMaximized(true);
        StackPane stackPane = new StackPane();
        nameString=Fetch_Profile_Data.getUsernameByEmail(emailString);
        phoneString=Fetch_Profile_Data.getContactNoByEmail(emailString);
        addString = Fetch_Profile_Data.getAddressByEmail(emailString);
        profileImage=Fetch_Profile_Data.getProfileImage(emailString);

        

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
        grid.setMinWidth(630);
        grid.setMinHeight(1000);
        grid.setMaxWidth(630);
        grid.setMaxHeight(1000);
        grid.setPadding(new Insets(350,0,0,40));
        grid.setVgap(35);
       
        rectangleBox = new Rectangle(250,250);
        if(profileImage==null){
        profileImage = new Image("./Images/profile.jpg");
        }
        //ImageView profileImageView = new ImageView(profileImage);
        //profileImageView.setFitWidth(300);
        //profileImageView.setFitHeight(300);
        rectangleBox.setStroke(Color.WHITE);
        rectangleBox.setStrokeWidth(5);
        setImage(profileImage);

        Label name = new Label("Name: ");
        name.setStyle("-fx-font-weight: bold; -fx-font-size: 30px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");
        //name.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));

        Text textName = new Text(nameString);
        textName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));

        Label email = new Label("Email-Id: ");
        email.setStyle("-fx-font-weight: bold; -fx-font-size: 30px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");
       // email.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
        Text textEmail = new Text(emailString);
        textEmail.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));

        Label phone = new Label("Mob No :");
        phone.setStyle("-fx-font-weight: bold; -fx-font-size: 30px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");
        //phone.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
        Text textPhone = new Text(phoneString);
        textPhone.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));

        Label address = new Label("Address: ");
        address.setStyle("-fx-font-weight: bold; -fx-font-size: 30px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");
        //address.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
        Text textAddress = new Text(addString);
        textAddress.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
        ComboBox<String> comboBox1 = new ComboBox<>();
        comboBox1.setPromptText("Donate List");
        comboBox1.getItems().addAll("Option 1", "Option 2", "Option 3");
        comboBox1.getStyleClass().add("combo-box");
        comboBox1.setStyle("-fx-font-weight: bold; -fx-font-size: 26px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");

        ComboBox<String> comboBox2 = new ComboBox<>();
        comboBox2.setPromptText("Received List");
        comboBox2.getItems().addAll("Option 1", "Option 2", "Option 3");
        comboBox2.getStyleClass().add("combo-box");
        comboBox2.setStyle("-fx-font-weight: bold; -fx-font-size: 24px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");

        
        grid.add(name, 0, 0);
        grid.add(textName, 1, 0);
        grid.add(email, 0, 1);
        grid.add(textEmail, 1, 1);
        grid.add(phone, 0, 2);
        grid.add(textPhone, 1, 2);
        grid.add(address, 0, 3);
        grid.add(textAddress, 1, 3);

        VBox buttonBox = new VBox(20);
        Button editButton = new Button("Edit Profile");
        editButton.setPrefSize(155,20);
        editButton.setStyle("-fx-font-weight: bold; -fx-font-size: 24px; -fx-font-family: 'Times New Roman'; -fx-background-color: #DB7093;");
        editButton.setOnAction(e->{
            editButton.setEffect(dropShadow);
            UpdateProfile.updateProfileData();
        });
        Button refreshButton = new Button("Refresh");
        refreshButton.setPrefSize(155,20);
        refreshButton.setStyle("-fx-font-weight: bold; -fx-font-size: 24px; -fx-font-family: 'Times New Roman'; -fx-background-color: #F4A460;");
        refreshButton.setOnAction(e->{
             refreshButton.setEffect(dropShadow);
            profilePage();
            primaryStage.close();
        });
       

        Button homeButton = new Button("Homepage");
        homeButton.setPrefSize(155,20);
        homeButton.setStyle("-fx-font-weight: bold; -fx-font-size: 24px; -fx-font-family: 'Times New Roman'; -fx-background-color: #FF6347;");
        homeButton.setOnAction(e->{
             homeButton.setEffect(dropShadow);
            primaryStage.close();
        });
        Button aboutButton = new Button("About");
        aboutButton.setPrefSize(155,20);
        aboutButton.setStyle("-fx-font-weight: bold; -fx-font-size: 24px; -fx-font-family: 'Times New Roman'; -fx-background-color: #20B2AA;");
        
        aboutButton.setOnAction(e->{
             aboutButton.setEffect(dropShadow);
             AboutPage.About_us();
           // primaryStage.close();
        });
        buttonBox.getChildren().addAll(homeButton, editButton,refreshButton,aboutButton);
        buttonBox.setPadding(new Insets(200, 0, 0, 100));

        
        homeButton.setEffect(null); // Initially, no effect on the button
        editButton.setEffect(null); // Initially, no effect on the button
        refreshButton.setEffect(null); // Initially, no effect on the button
        homeButton.setOnMouseEntered(event -> {
            homeButton.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        homeButton.setOnMouseExited(event -> {
            homeButton.setEffect(null);
        });
        // Add the drop shadow effect when the button is clicked
        

        editButton.setOnMouseEntered(event -> {
            editButton.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        editButton.setOnMouseExited(event -> {
            editButton.setEffect(null);
        });
        // Add the drop shadow effect when the button is clicked
        
        refreshButton.setOnMouseEntered(event -> {
            refreshButton.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        refreshButton.setOnMouseExited(event -> {
            refreshButton.setEffect(null);
        });
        // Add the drop shadow effect when the button is clicked
       
        VBox vbox = new VBox();
        vbox.setPrefWidth(400); 
        

        vbox.getChildren().addAll(rectangleBox,comboBox1,comboBox2);
        vbox.setPadding(new Insets(300, 0, 0, 400));

        mainBox.getChildren().addAll(vbox, grid, buttonBox);

        stackPane.getChildren().add(mainBox);

        Scene scene = new Scene(stackPane, 800, 600);

        primaryStage.setTitle("Profile");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("./Images/3.jpg"));
        primaryStage.show();
    }

    public static void setImage(Image image){
        rectangleBox.setFill(new ImagePattern(image));
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
