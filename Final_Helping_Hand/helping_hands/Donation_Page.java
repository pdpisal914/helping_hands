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

public class Donation_Page extends Application {

    
    static File imgFile = null;
    static String userName = null;
    static String name = null;
    static String type = null;
    static String city = null;
    static String info = null;
    static String add=null;
    static Rectangle largeProductBox = null;
    static String emailString=null;
    static Stage primaryStage=null;

   // @Override
   // public void start(Stage primaryStage){
    public static void donatePage() {
         primaryStage = new Stage();
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
        grid.setMinWidth(1000);
        grid.setMinHeight(900);
        grid.setMaxWidth(1000);
        grid.setMaxHeight(900);
        grid.setPadding(new Insets(190,0,0,550));
        grid.setVgap(10);
        grid.setHgap(50);
       
         largeProductBox = new Rectangle(300, 300); // Adjust size
        //Image profileImage = new Image("file:C:\\Users\\Pranav Pisal\\helping_hands\\Images\\profile.jpg");
        largeProductBox.setStroke(Color.BLACK);
        largeProductBox.setStrokeWidth(5);
        largeProductBox.setOnMouseEntered(event -> {
            largeProductBox.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        largeProductBox.setOnMouseExited(event -> {
            largeProductBox.setEffect(null);
        });
        //Image pdImage = new Image("file:C:\\Users\\Pranav Pisal\\helping_hands\\Images\\landscape.png");
       // setImage(profileImage);
        
        Label labelId = new Label("Enter Donar Name:");
        labelId.setStyle("-fx-font-weight: bold; -fx-font-size: 25px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");
        labelId.setFont(Font.font("Times New Roman", 18));

        TextField userId = new TextField();
        userId.setPromptText("User Id");
        userId.setPrefWidth(300);
        userId.setPrefHeight(35);

        // Create a Label for the Product Name Input Field
        Label productNameLabel = new Label("Enter Product Name:");
        productNameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 25px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");
        productNameLabel.setFont(Font.font("Times New Roman", 18));

        // Product Name Input Field
        TextField productNameField = new TextField();
        productNameField.setPromptText("Product Name");
        productNameField.setPrefWidth(300);
        productNameField.setPrefHeight(35);

        // Create a Label for the Product Type ComboBox
        Label productTypeLabel = new Label("Select Product Type:");
        productTypeLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 25px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");
        productTypeLabel.setFont(Font.font("Times New Roman", 18));

        // Product Type Dropdown
        ComboBox<String> productTypeComboBox = new ComboBox<>();
        productTypeComboBox.setPromptText("Product Type");
        productTypeComboBox.getItems().addAll("Fashion","Electronics","Beauty","Mobile","Tablets","Kitchen","Furniture", "Grocery", "Stationary");
        productTypeComboBox.setOnAction(e -> type = productTypeComboBox.getValue());

        productTypeComboBox.setPrefWidth(300);
        productTypeComboBox.setPrefHeight(35);

        // Create a Label for the City Name ComboBox
        Label cityNameLabel = new Label("Select City:");
        cityNameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 25px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");
        cityNameLabel.setFont(Font.font("Times New Roman", 18));

        // City Name Dropdown
        ComboBox<String> cityNameComboBox = new ComboBox<>();
        cityNameComboBox.setPromptText("City Name");
        cityNameComboBox.getItems().addAll("Pune","Nashik","Mumbai","Sambhajinagar","Ahmednagar","Ratnagiri","Alibag", "Satara","Solapur","Akola");
        cityNameComboBox.setOnAction(e -> city = cityNameComboBox.getValue());

        cityNameComboBox.setPrefWidth(300);
        cityNameComboBox.setPrefHeight(35);

        Label labelAdd = new Label("Enter Address:");
        labelAdd.setStyle("-fx-font-weight: bold; -fx-font-size: 25px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");
        labelAdd.setFont(Font.font("Times New Roman", 18));

        // Product Name Input Field
        TextField address = new TextField();
        address.setPromptText("Product Name");
        address.setPrefWidth(300);
        address.setPrefHeight(35);

        // Create a Label for the Select Image Button
        Label selectImageLabel = new Label("Upload Product Image:");
        selectImageLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 25px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");
        selectImageLabel.setFont(Font.font("Times New Roman", 18));

        // Select Image Button
        Button selectImageButton = new Button("Select Image");
        selectImageButton.setStyle("-fx-font-weight: bold; -fx-font-size: 24px; -fx-font-family: 'Times New Roman'; -fx-background-color: #EE82EE;");
        selectImageButton.setPrefWidth(300);
        selectImageButton.setPrefHeight(35);
        selectImageButton.setOnAction(e -> {
            selectImageButton.setEffect(dropShadow);
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                Image image = new Image(file.toURI().toString());
               imgFile = file;
                Platform.runLater(() -> {
                    largeProductBox.setFill(new ImagePattern(image));
                });
            }
        });
        selectImageButton.setOnMouseEntered(event -> {
            selectImageButton.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        selectImageButton.setOnMouseExited(event -> {
            selectImageButton.setEffect(null);
        });

        // Create a Label for the Product Description Input Field
        Label productDescriptionLabel = new Label("Enter Product Description:");
        productDescriptionLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 25px; -fx-font-family: 'Times New Roman'; -fx-font-color: #000000;");
        productDescriptionLabel.setFont(Font.font("Times New Roman", 18));

        // Product Description Input Field
        TextField productDescriptionField = new TextField();
        productDescriptionField.setPromptText("Product Description");
        productDescriptionField.setPrefWidth(300);
        productDescriptionField.setPrefHeight(50);

        // Upload Product Button
        Button uploadProductButton = new Button("Donate Product");
        uploadProductButton.setStyle("-fx-font-weight: bold; -fx-font-size: 24px; -fx-font-family: 'Times New Roman'; -fx-background-color: #8A2BE2;");
        uploadProductButton.setPrefWidth(200);
        uploadProductButton.setPrefHeight(50);
      // uploadProductButton.setOnAction(e->JDBC_Classes.insertData(userName,name,type,city,imgName,info));
        uploadProductButton.setOnAction(e -> {
            uploadProductButton.setEffect(dropShadow);
            userName = userId.getText();
            name = productNameField.getText();
            info = productDescriptionField.getText();
            add = address.getText();
            JDBC_Classes.insertData(userName,name,type,city,imgFile,info,add);
         
            
        });
        uploadProductButton.setOnMouseEntered(event -> {
            uploadProductButton.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        uploadProductButton.setOnMouseExited(event -> {
            uploadProductButton.setEffect(null);
        });

        Button homePage = new Button("HomePage");
        homePage.setStyle("-fx-font-weight: bold; -fx-font-size: 24px; -fx-font-family: 'Times New Roman'; -fx-background-color: #DC143C;");
        homePage.setPrefWidth(200);
        homePage.setPrefHeight(50);
        homePage.setOnAction(e->{
            homePage.setEffect(dropShadow);
            primaryStage.close();
        });
        homePage.setOnMouseEntered(event -> {
            homePage.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        homePage.setOnMouseExited(event -> {
            homePage.setEffect(null);
        });


        


       grid.add(labelId,0,0);
       grid.add(userId,0,1);
       grid.add(cityNameLabel,0,2);
       grid.add(cityNameComboBox,0,3);
       grid.add(labelAdd,0,4);
       grid.add(address,0,5);
       grid.add(productNameLabel,0,6);
       grid.add(productNameField,0,7);
       grid.add(productTypeLabel,0,8);
       grid.add(productTypeComboBox,0,9);
       
       grid.add(selectImageLabel,0,10);
       grid.add(selectImageButton,0,11);
       grid.add(productDescriptionLabel,0,12);
       grid.add(productDescriptionField,0,13);


       VBox vbox = new VBox(20);


       vbox.getChildren().addAll(largeProductBox,uploadProductButton,homePage);
        vbox.setPrefWidth(400); 
        
        vbox.setPadding(new Insets(200, 0, 0, 100));

        mainBox.getChildren().addAll(grid,vbox);

        stackPane.getChildren().add(mainBox);

        Scene scene = new Scene(stackPane, 800, 600);

        primaryStage.setTitle("DONATE PRODUCT");
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

