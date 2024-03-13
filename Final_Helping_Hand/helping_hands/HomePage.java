import java.util.ArrayList;

import about.About_us;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomePage extends Application {
   static ScrollPane productScrollPane = new ScrollPane();
   static FlowPane productBoxContainer = new FlowPane();
   static BorderPane root=null;
   static Scene scene=null;
   static Stage primaryStage=null;
   static int flag =0;

    
    public static void homePage() {
       // primaryStageOfLogin.close();
        primaryStage = new Stage();
        DropShadow dropShadow = new DropShadow();
        primaryStage.setMaximized(true);
         root = new BorderPane();
    
         scene = new Scene(root, 800, 600);

        Image backgroundImage = new Image("./Images/43.jpg");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setBackground(new Background(background));

        ImageView logoImageView = new ImageView(new Image("./Images/c2w.png"));
       
        logoImageView.setOnMouseClicked(e->{
            AboutPage.About_us();
        });

       logoImageView.setOnMouseEntered(event -> {
            logoImageView.setEffect(dropShadow);
            
        });
        // Remove the effect when the mouse exits the button
        logoImageView.setOnMouseExited(event -> {
            logoImageView.setEffect(null);
        });
        
        logoImageView.setFitWidth(200);
        logoImageView.setFitHeight(100); // Set the width of the logo image
        //logoImageView.setPreserveRatio(true);

         ImageView profileView = new ImageView(new Image("./Images/profile1.png"));
         profileView.setOnMouseEntered(event -> {
            profileView.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        profileView.setOnMouseExited(event -> {
            profileView.setEffect(null);
        });
        profileView.setFitWidth(100); // Set the width of the logo image
        profileView.setPreserveRatio(true);
        profileView.setOnMouseClicked(e->{
            profileView.setEffect(dropShadow);
            Profile_Page_pdp.profilePage();
        });

        BackgroundFill bgFill = new BackgroundFill(Color.LIGHTSKYBLUE, new CornerRadii(5), null);
        Background bg = new Background(bgFill);
       

        //top area
        HBox topBox = new HBox(10);
        
        topBox.setAlignment(Pos.CENTER);
        TextField searchBar = new TextField();
        searchBar.setPromptText("Search...");
        
        searchBar.setMinSize(300, 40);
        Button Search = new Button("Search");
        Search.setOnMouseEntered(event -> {
            Search.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        Search.setOnMouseExited(event -> {
            Search.setEffect(null);
        });
       // Search.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';"); // Set font size and style
        Search.setMinSize(100, 40);

        Button Home = new Button("Home");
        Home.setOnMouseEntered(event -> {
            Home.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        Home.setOnMouseExited(event -> {
            Home.setEffect(null);
        });
        //Home.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';"); // Set font size and style
        Home.setMinSize(100, 40);

        Button Donate = new Button("DONATE");
        Donate.setOnMouseEntered(event -> {
            Donate.setEffect(dropShadow);
        });
        // Remove the effect when the mouse exits the button
        Donate.setOnMouseExited(event -> {
            Donate.setEffect(null);
        });
        Donate.setMinSize(100,40);


        SplitMenuButton splitMenuButton = new SplitMenuButton();
         splitMenuButton.setBackground(bg);
        splitMenuButton.setText("CITY");
        splitMenuButton.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';"); // Set font size and style

        splitMenuButton.setMinSize(100, 40);

        // Create menu items for the dropdown menu
        MenuItem option1 = new MenuItem("Pune");
        option1.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';"); // Set font size and style
        MenuItem option2 = new MenuItem("Nashik");
        option2.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");
        MenuItem option3 = new MenuItem("Mumbai");
        option3.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");
        MenuItem option4 = new MenuItem("Sambhajinagar");
        option4.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");
        MenuItem option5 = new MenuItem("Ahmednagar");
        option5.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");
        MenuItem option6 = new MenuItem("Ratnagiri");
        option6.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");
        MenuItem option7 = new MenuItem("Alibag");
        option7.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");
        MenuItem option8 = new MenuItem("Satara");
        option8.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");
         MenuItem option9 = new MenuItem("Solapur");
        option8.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");
         MenuItem option10 = new MenuItem("Akola");
        option8.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");

        // Add menu items to the dropdown menu
        splitMenuButton.getItems().addAll(option1, option2, option3, option4, option5, option6, option7, option8,option9,option10);
        option1.setOnAction(e -> setRectangleByCity("Pune"));
        option2.setOnAction(e -> setRectangleByCity("Nashik"));
        option3.setOnAction(e -> setRectangleByCity("Mumbai"));
        option4.setOnAction(e -> setRectangleByCity("Sambhajinagar"));
        option5.setOnAction(e -> setRectangleByCity("Ahmednagar"));
        option6.setOnAction(e -> setRectangleByCity("Ratnagiri"));
        option7.setOnAction(e -> setRectangleByCity("Alibag"));
        option8.setOnAction(e -> setRectangleByCity("Satara"));
        option9.setOnAction(e -> setRectangleByCity("Solapur"));
        option10.setOnAction(e -> setRectangleByCity("Akola"));

        SplitMenuButton allButton = new SplitMenuButton();
        allButton.setBackground(bg);
        allButton.setText("Categories");
        //allButton.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';"); // Set font size and style

        allButton.setMinSize(100, 40);

        MenuItem cat1 = new MenuItem("Fashion");
        cat1.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';"); // Set font size and style
        MenuItem cat2 = new MenuItem("Electronics");
        cat2.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");
        MenuItem cat3 = new MenuItem("Beauty");
        cat3.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");
        MenuItem cat4 = new MenuItem("Mobile");
        cat4.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");
        MenuItem cat5 = new MenuItem("Tablets");
        cat5.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");
        MenuItem cat6 = new MenuItem("Kitchen");
        cat6.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");
        MenuItem cat7 = new MenuItem("Furniture");
        cat7.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");
        MenuItem cat8 = new MenuItem("Grocery");
        cat8.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");
        MenuItem cat9 = new MenuItem("Stationary");
        cat9.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman';");
        allButton.getItems().addAll(cat1,cat2,cat3,cat4,cat5,cat6,cat7,cat8,cat9);
        cat1.setOnAction(e -> setRectangleByItemType("Fashion"));
        cat2.setOnAction(e -> setRectangleByItemType("Electronics"));
        cat3.setOnAction(e -> setRectangleByItemType("Beauty"));
        cat4.setOnAction(e -> setRectangleByItemType("Mobile"));
        cat5.setOnAction(e -> setRectangleByItemType("Tablets"));
        cat6.setOnAction(e -> setRectangleByItemType("Kitchen"));
        cat7.setOnAction(e -> setRectangleByItemType("Furniture"));
        cat8.setOnAction(e -> setRectangleByItemType("Grocery"));
        cat9.setOnAction(e -> setRectangleByItemType("Stationary"));


        Region spacer1 = new Region();
        HBox.setHgrow(spacer1, Priority.ALWAYS);

        // Increase distance between profile icon and All button
        Region spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);
       
        
        /*Search.getStyleClass().add("glowing");
        Home.getStyleClass().add("glowing");
        splitMenuButton.getStyleClass().add("glowing");
        allButton.getStyleClass().add("glowing");
*/
        Search.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-font-family: 'Times New Roman'; -fx-background-color: #00A1E8;");
        Home.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-font-family: 'Times New Roman'; -fx-background-color: #00E8D3;");
        splitMenuButton.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-font-family: 'Times New Roman'; -fx-background-color: #54E800;");
        allButton.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-font-family: 'Times New Roman'; -fx-background-color: #2BCAD0;");
        Donate.setStyle("-fx-font-weight: bold; -fx-font-size: 22px; -fx-font-family: 'Times New Roman'; -fx-background-color: #E88500;");

        Search.setId("searchButton");
        splitMenuButton.setId("cityButton");
        allButton.setId("allButton");
        
        //Search.setOnMouseClicked(e -> openNewWindow("Product " + " Details"));
        Search.setOnMouseClicked(e->{
            Search.setEffect(dropShadow);
            String Text = searchBar.getText();
        setRectangleByItemName(Text);
        });
        splitMenuButton.setOnMouseClicked(e -> openNewWindow("Product " + " Details"));
        allButton.setOnMouseClicked(e -> openNewWindow("Product " + " Details"));
        Home.setOnAction(e -> {
            Home.setEffect(dropShadow);
            setRectangle();
        });
        Donate.setOnAction(e->{
            Donate.setEffect(dropShadow);
            Donation_Page.donatePage();
        });
        
        topBox.getChildren().addAll(logoImageView,spacer1,Home,splitMenuButton, Search, searchBar, allButton,Donate,spacer2,profileView);
        topBox.setPadding(new Insets(20, 10, 50, 10)); // Increased the bottom padding to 50
        
        // Add an image as the background of topBox and position it at the top 
        
        // Create an ImageView and set the image
         // Add at the beginning
       //  topBox.getChildren().addAll(profileView, splitMenuButton, spacer, Search, searchBar, allButton, logoImageView);
        
        root.setTop(topBox);
 
        // Center Area
        //ScrollPane productScrollPane = new ScrollPane();
        productScrollPane.setFitToWidth(true);
        productScrollPane.setStyle("-fx-background: #000000;");

       // FlowPane productBoxContainer = new FlowPane();
        productBoxContainer.setVgap(40);
        productBoxContainer.setHgap(40);
        productBoxContainer.setPadding(new Insets(20));


        // Create rectangles and set images as ImagePatterns
        //HBox largeHBox = new HBox();
        
        //largeHBox.getChildren().add(largeProductBox);

        
        //It Set the All Rect  
        setRectangle();
        
/* 
        int productCount = Retrive_img_JDBC.getTotalCount();
        int pic[]=new int[productCount];

        for (int i = productCount; i >0; i--) {
            Rectangle productBox = new Rectangle(430, 450);
            
            
            Image image = Retrive_img_JDBC.getImg(i);
            productBox.setFill(new ImagePattern(image));


            // Add click event to rectangles to open a new window
            int x =i;
            productBox.setOnMouseClicked(e -> Receive_Page2.clickOnImage( x));
            productBoxContainer.getChildren().addAll(productBox);
        }

        */
        productBoxContainer.setPadding(new Insets(0, 0, 0, 30));
        productScrollPane.setContent(productBoxContainer);
        root.setCenter(productScrollPane);
       // scene.getStylesheets().add(getClass().getResource("glowingButtons.css").toExternalForm());
        
        primaryStage.setTitle("HELPING HANDS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void openNewWindow(String productDetails) {
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.initStyle(StageStyle.UTILITY);

        VBox vbox = new VBox(10);
        Label label = new Label(productDetails);
        vbox.getChildren().addAll(label);

        Scene scene = new Scene(vbox, 300, 200);
        newStage.setScene(scene);
        newStage.show();
    }
   /*  static void setRectangle(){
        if(flag == 1){
            productBoxContainer.getChildren().clear();
        }
        Rectangle largeProductBox = new Rectangle(1830, 400); // Adjust size
        largeProductBox.setTranslateX(10);
        largeProductBox.setTranslateY(8);
         largeProductBox.setStroke(Color.WHITE);
        largeProductBox.setStrokeWidth(5);
        Image pdImage1 = new Image("./Images/landscape.png");
        largeProductBox.setFill(new ImagePattern(pdImage1));
        productBoxContainer.getChildren().add(largeProductBox);
        
    
        int productCount = Retrive_img_JDBC.getTotalCount();
        int pic[]=new int[productCount];

        for (int i = productCount; i >0; i--) {
            Rectangle productBox = new Rectangle(430, 450);
            productBox.setStroke(Color.WHITE);
            productBox.setStrokeWidth(5);
            
            
            
            Image image = Retrive_img_JDBC.getImg(i);
            productBox.setFill(new ImagePattern(image));
            flag=1;

            // Add click event to rectangles to open a new window
            int x =i;
            productBox.setOnMouseClicked(e -> Receive_Page2.clickOnImage( x));
            productBoxContainer.getChildren().addAll(productBox);
        }
    }
    */
    static void setRectangle(){
        if(flag == 1){
            productBoxContainer.getChildren().clear();
        }
        Rectangle largeProductBox = new Rectangle(1830, 400); // Adjust size
        largeProductBox.setTranslateX(10);
        largeProductBox.setTranslateY(8);
         largeProductBox.setStroke(Color.WHITE);
        largeProductBox.setStrokeWidth(5);
        Image pdImage1 = new Image("./Images/landscape.png");
        largeProductBox.setFill(new ImagePattern(pdImage1));
        productBoxContainer.getChildren().add(largeProductBox);
        
    
        ArrayList list = Retrive_img_JDBC.getIdList();
        int count = list.size();

        for (int i = count-1; i >=0; i--) {
            Rectangle productBox = new Rectangle(430, 450);
            productBox.setStroke(Color.WHITE);
            productBox.setStrokeWidth(5);
            
             int ind = (int) list.get(i);
            
            Image image = Retrive_img_JDBC.getImg(ind);
            productBox.setFill(new ImagePattern(image));
            flag=1;

            // Add click event to rectangles to open a new window
            int x =ind;
            productBox.setOnMouseClicked(e -> Receive_Page2.clickOnImage( x));
            productBoxContainer.getChildren().addAll(productBox);
        }
    }
        static void setRectangleByCity(String city){

             productBoxContainer.getChildren().clear();
             
            Rectangle largeProductBox = new Rectangle(1830, 400); // Adjust size
            largeProductBox.setTranslateX(10);
            largeProductBox.setTranslateY(8);
            largeProductBox.setStroke(Color.WHITE);
            largeProductBox.setStrokeWidth(5);
            Image pdImage1 = new Image("./Images/landscape.png");
            largeProductBox.setFill(new ImagePattern(pdImage1));
            productBoxContainer.getChildren().add(largeProductBox);
            
           
           ArrayList list = Retrive_img_JDBC.arrList(city);
            int count = list.size();


        for (int i = count-1; i >=0; i--) {
            int ind = (int) list.get(i);
            Rectangle productBox = new Rectangle(430, 450);
            productBox.setStroke(Color.WHITE);
            productBox.setStrokeWidth(5);
            
            
            Image image = Retrive_img_JDBC.getImg(ind);
            productBox.setFill(new ImagePattern(image));


            // Add click event to rectangles to open a new window
            int x =ind;
            productBox.setOnMouseClicked(e -> Receive_Page2.clickOnImage( x));
            productBoxContainer.getChildren().addAll(productBox);
        }

        }


        static void setRectangleByItemName(String itemName){
            ArrayList list = Retrive_img_JDBC.getBySearch(itemName);
            int count = list.size();
            
           // if(count != 0){
                productBoxContainer.getChildren().clear();
           // }
             
            Rectangle largeProductBox = new Rectangle(1830, 400); // Adjust size
            largeProductBox.setTranslateX(10);
            largeProductBox.setTranslateY(8);
            largeProductBox.setStroke(Color.WHITE);
            largeProductBox.setStrokeWidth(5);
            Image pdImage1 = new Image("./Images/landscape.png");
            largeProductBox.setFill(new ImagePattern(pdImage1));
            productBoxContainer.getChildren().add(largeProductBox);
            
        for (int i = count-1; i >=0; i--) {
            int ind = (int) list.get(i);
            Rectangle productBox = new Rectangle(430, 450);
            productBox.setStroke(Color.WHITE);
            productBox.setStrokeWidth(5); 
            
            Image image = Retrive_img_JDBC.getImg(ind);
            productBox.setFill(new ImagePattern(image));
             // Add click event to rectangles to open a new window
            int x =ind;
            productBox.setOnMouseClicked(e -> Receive_Page2.clickOnImage( x));
            productBoxContainer.getChildren().addAll(productBox);
        }
        if(count == 0){
            showPopup("This Product Is Not Present....!");
        }
        }
       
        static void setRectangleByItemType(String itemType){
            ArrayList list = Retrive_img_JDBC.getByItemType(itemType);
            int count = list.size();
            
           // if(count != 0){
                productBoxContainer.getChildren().clear();
            //}
             
            Rectangle largeProductBox = new Rectangle(1830, 400); // Adjust size
            largeProductBox.setTranslateX(10);
            largeProductBox.setTranslateY(8);
            largeProductBox.setStroke(Color.WHITE);
            largeProductBox.setStrokeWidth(5);
            Image pdImage1 = new Image("./Images/landscape.png");
            largeProductBox.setFill(new ImagePattern(pdImage1));
            productBoxContainer.getChildren().add(largeProductBox);
            
        for (int i = count-1; i >=0; i--) {
            int ind = (int) list.get(i);
            Rectangle productBox = new Rectangle(430, 450);
            productBox.setStroke(Color.WHITE);
            productBox.setStrokeWidth(5); 
            
            Image image = Retrive_img_JDBC.getImg(ind);
            productBox.setFill(new ImagePattern(image));
             // Add click event to rectangles to open a new window
            int x =ind;
            productBox.setOnMouseClicked(e -> Receive_Page2.clickOnImage( x));
            productBoxContainer.getChildren().addAll(productBox);
        }
        if(count == 0){
            showPopup("This Categery Is Not Presnt....!");
        }
        }

        private static void showPopup(String alertText) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Not Found");
            alert.setHeaderText(null);
            alert.setContentText(alertText);
           
            

            alert.showAndWait();
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
