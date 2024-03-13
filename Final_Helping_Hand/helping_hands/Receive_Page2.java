import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Receive_Page2 extends Application {
    public static Connection connection = ConnectionProvider.getConnection();
    public static String url=null;
    static Stage primaryStage=new Stage();
    public static int userId=-1;
    
   public static void clickOnImage(int id) {
    userId=id;
    String userName = null;
    String productName = null;
    String productType = null;
    String city = null;
    String description = null;
    String address=null;
        // Create a HBox for the main layout
        HBox mainHBox = new HBox();
        mainHBox.setPadding(new Insets(10, 10, 10, 10));
        mainHBox.setSpacing(150);
        mainHBox.setAlignment(Pos.CENTER);

        // Create a background image
        Image backgroundImage = new Image("./Images/20.jpg"); // Specify the path to your background image
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, new BackgroundSize(100, 100, true, true, false, true));
        mainHBox.setBackground(new Background(background));

        // Create a rectangle box
        Rectangle rectangle = new Rectangle(300, 300, Color.WHITE);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(5);
            
       
    
        //ImageIcon icon = Retrive_img_JDBC.getImg(1,connection);
       
        //int id = 4;
   
      
            
        //Access Image From database
        Image img = Retrive_img_JDBC.getImg(id);
        userName=Retrive_img_JDBC.getUserName(id);
        productName = Retrive_img_JDBC.getProductName(id);
        productType=Retrive_img_JDBC.getProductType(id);
        address = Retrive_img_JDBC.getAddress(id);
        description = Retrive_img_JDBC.getDescription(id);


        
      // Image rectangleImage = new Image("file:C:\\Users\\Pranav Pisal\\helping_hands\\Images\\"+url); // Specify the path to your rectangle image
        ImageView imageInRectangle = new ImageView(img);
        rectangle.setFill(new ImagePattern(imageInRectangle.getImage()));
       
        
    
        Button receiveButton = new Button("Receive");
        receiveButton.setPrefSize(120, 40);
        receiveButton.setOnAction(e->deletImage(userId));
        
        // Set font, font size, and background color for the button
        Font buttonFont = Font.font("Times New Roman", FontWeight.BOLD, 18);
        receiveButton.setFont(buttonFont);
        Receive_Page2.applyGlowingEffect(receiveButton);
        receiveButton.setStyle("-fx-background-color: #0053c6; -fx-text-fill: white;");
        
        VBox topLeftHBox = new VBox(50);
        topLeftHBox.getChildren().addAll(rectangle, receiveButton);
        topLeftHBox.setAlignment(Pos.CENTER); // Center align the VBox
        // Create a VBox for the left side of the rectangle
        VBox leftVBox = new VBox();
        leftVBox.setSpacing(30);
        leftVBox.setAlignment(Pos.CENTER);

        // Create and ad 6 HBoxes with labels and output TextFields
        Font boldFont = Font.font("Times New Roman", FontWeight.BOLD, 25);

        HBox hBox1 = new HBox(10);
        Text label1 = new Text("Donator's Name: ");
        label1.setFont(boldFont);
        Text label1OP = new Text(userName);
        label1OP.setFont(boldFont);
        hBox1.getChildren().addAll(label1, label1OP);
        leftVBox.getChildren().add(hBox1);

        HBox hBox2 = new HBox(10);
        Text label2 = new Text("Product Name: ");
        label2.setFont(boldFont);
        Text label2OP = new Text(productName);
        label2OP.setFont(boldFont);
        hBox2.getChildren().addAll(label2, label2OP);
        leftVBox.getChildren().add(hBox2);

        HBox hBox3 = new HBox(10);
        Text label3 = new Text("Product Type: ");
        label3.setFont(boldFont);
        Text label3OP = new Text(productType);
        label3OP.setFont(boldFont);
        hBox3.getChildren().addAll(label3, label3OP);
        leftVBox.getChildren().add(hBox3);

        HBox hBox4 = new HBox(10);
        Text label4 = new Text("Product Address: ");
        label4.setFont(boldFont);
        Text label4OP = new Text(address);
        label4OP.setFont(boldFont);
        hBox4.getChildren().addAll(label4, label4OP);
        leftVBox.getChildren().add(hBox4);

        HBox hBox5 = new HBox(10);
        Text label5 = new Text("Description: ");
        label5.setFont(boldFont);
        Text label5OP = new Text(description);
        label5OP.setFont(boldFont);
        hBox5.getChildren().addAll(label5, label5OP);
        leftVBox.getChildren().add(hBox5);

        // Add components to the main HBox
        mainHBox.getChildren().addAll(topLeftHBox, leftVBox);

        // Create a scene and set it in the stage
        Scene scene = new Scene(mainHBox, 1000, 600);
        primaryStage.setScene(scene);

        // Set the stage title and show it
        primaryStage.setTitle("PRODUCT DETAIL'S");
        primaryStage.show();
    }
    public static void applyGlowingEffect(Button button) {
        // Apply a blend effect to the button
        Blend blend = new Blend(BlendMode.SRC_OVER);
        blend.setTopInput(new GaussianBlur(15)); // Apply a Gaussian blur
        blend.setMode(BlendMode.ADD);

        button.setEffect(blend);

        // Add a hover effect to the button
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setColor(Color.rgb(0, 100, 100, 0.7));
        innerShadow.setChoke(0.0);
        innerShadow.setRadius(10.0);

        button.setOnMouseEntered(event -> {
            button.setEffect(innerShadow);
        });

        button.setOnMouseExited(event -> {
            button.setEffect(blend);
        });
    }
     public static void deletImage(int id){
       // String userNameToDelete = "your_username_here"; // Replace with the username you want to delete.
        Connection connection = ConnectionProvider.getConnection();
            try {
                String deleteQuery = "DELETE FROM pinfo WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                showPopup();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    

     private static void showPopup() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Order Products");
        alert.setHeaderText(null);
        alert.setContentText("Oreder Is Placed Success Fully...\n Thank You");

        alert.showAndWait();
    }
/*     public static void main(String[] args) {
        launch(args);
    }*/
    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }
    
    
}
