package about;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class About_us extends Application {

    @Override
    public void start(Stage primaryStage) {
      //  public static void aboutUsPage(){
          //Stage primaryStage = new Stage();
        AnchorPane root = new AnchorPane();
        root.setPrefHeight(695.0);
        root.setPrefWidth(968.0);

        ImageView img1 = new ImageView(new Image(getClass().getResourceAsStream("HPBackground.jpg")));
        img1.setFitHeight(695.0);
        img1.setFitWidth(1073.0);
        img1.setLayoutX(-4.0);
        img1.setPreserveRatio(true);
        root.getChildren().add(img1);

        ImageView img2 = new ImageView(new Image(getClass().getResourceAsStream("sir.png")));
        img2.setFitHeight(233.0);
        img2.setFitWidth(390.0);
        img2.setLayoutX(8.0);
        img2.setLayoutY(13.0);
        img2.setPreserveRatio(true);
        root.getChildren().add(img2);

        ImageView c2w = new ImageView(new Image(getClass().getResourceAsStream("c2w.jpg")));
        c2w.setFitHeight(52.0);
        c2w.setFitWidth(56.0);
        c2w.setLayoutX(506.0);
        c2w.setLayoutY(65.0);
        c2w.setPreserveRatio(true);
        c2w.setMouseTransparent(true);
        root.getChildren().add(c2w);
        Hyperlink hyperlink = new Hyperlink();
        hyperlink.setGraphic(c2w);

        // Set an action to open the website when the hyperlink is clicked
        c2w.setOnMouseClicked(event -> {
            getHostServices().showDocument("https://www.core2web.in/");
        });

        ImageView linkedin = new ImageView(new Image(getClass().getResourceAsStream("linkedin.png")));
        linkedin.setFitHeight(52.0);
        linkedin.setFitWidth(52.0);
        linkedin.setLayoutX(600.0);
        linkedin.setLayoutY(65.0);
        linkedin.setPreserveRatio(true);
        linkedin.setMouseTransparent(true);
        root.getChildren().add(linkedin);

        ImageView insta = new ImageView(new Image(getClass().getResourceAsStream("instagram.jpg")));
        insta.setFitHeight(52.0);
        insta.setFitWidth(56.0);
        insta.setLayoutX(694.0);
        insta.setLayoutY(65.0);
        insta.setPreserveRatio(true);
        insta.setMouseTransparent(true);
        root.getChildren().add(insta);

         ImageView yt = new ImageView(new Image(getClass().getResourceAsStream("youtube.png")));
        yt.setFitHeight(52.0);
        yt.setFitWidth(56.0);
        yt.setLayoutX(788.0);
        yt.setLayoutY(65.0);
        yt.setPreserveRatio(true);
        yt.setMouseTransparent(true);
        root.getChildren().add(yt);
        
        c2w.setOnMouseClicked(event -> {
            openWebpage1("https://www.core2web.in/"); // Replace with your LinkedIn profile URL
        });

        linkedin.setOnMouseClicked(event -> {
            openWebpage2("https://tg.linkedin.com/company/core2web-technologies"); // Replace with your LinkedIn profile URL
        });

        insta.setOnMouseClicked(event -> {
            openWebpage3("https://www.instagram.com/core2web/"); // Replace with your LinkedIn profile URL
        });

        yt.setOnMouseClicked(event -> {
            openWebpage4("https://www.linkedin.com/your_linkedin_profile"); // Replace with your LinkedIn profile URL
        });

        Label labelTeamMembers = createLabel("Team Members :-", 558.0, 167.0, 289.0, 53.0, 36.0);
        root.getChildren().add(labelTeamMembers);

        Label shraddhaLabel = createLabel("Shraddha Jadhav", 600.0, 229.0, 215.0, 35.0, 24.0);
        root.getChildren().add(shraddhaLabel);

        Label pranavLabel = createLabel("Pranav Pisal", 604.0, 273.0, 181.0, 26.0, 24.0);
        root.getChildren().add(pranavLabel);

        Label kiranLabel = createLabel("Kiran Pawar", 604.0, 320.0, 181.0, 28.0, 24.0);
        root.getChildren().add(kiranLabel);

        Label avishkarLabel = createLabel("Avishkar Gaikwad", 604.0, 364.0, 207.0, 35.0, 24.0);
        root.getChildren().add(avishkarLabel);

        Label chaitanyaLabel = createLabel("Chaitanya", 604.0, 414.0, 190.0, 26.0, 24.0);
        root.getChildren().add(chaitanyaLabel);

        Label gratitudeLabel1 = createLabel("We want to take a moment to express our heartfelt", 55.0, 298.0, 338.0, 35.0, 0.0);
        root.getChildren().add(gratitudeLabel1);
        gratitudeLabel1.setFont(new Font(20));

        Label gratitudeLabel2 = createLabel("gratitude for the invaluable guidance you have provided.", 54.0, 337.0, 425.0, 23.0, 0.0);
        root.getChildren().add(gratitudeLabel2);
        gratitudeLabel2.setFont(new Font(20));

        Label gratitudeLabel3 = createLabel("your expertise and support have been instrumental in", 54.0, 370.0, 367.0, 23.0, 0.0);
        root.getChildren().add(gratitudeLabel3);
        gratitudeLabel3.setFont(new Font(20));

        Label gratitudeLabel4 = createLabel("helping us navigate through various challenges and achieve", 54.0, 404.0, 461.0, 21.0, 0.0);
        root.getChildren().add(gratitudeLabel4);
        gratitudeLabel4.setFont(new Font(20));

        Label gratitudeLabel5 = createLabel("our goals. We truly appreciate the time and effort you've", 55.0, 432.0, 379.0, 21.0, 0.0);
        root.getChildren().add(gratitudeLabel5);
        gratitudeLabel5.setFont(new Font(20));

        Label gratitudeLabel6 = createLabel("invested in our growth and development...", 54.0, 462.0, 338.0, 21.0, 0.0);
        root.getChildren().add(gratitudeLabel6);
        gratitudeLabel6.setFont(new Font(20));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Label createLabel(String text, double layoutX, double layoutY, double prefWidth, double prefHeight, double fontSize) {
        Label label = new Label(text);
        label.setLayoutX(layoutX);
        label.setLayoutY(layoutY);
        label.setPrefWidth(prefWidth);
        label.setPrefHeight(prefHeight);
        if (fontSize != 0.0) {
            label.setFont(new Font(fontSize));
        }
        return label;
    }

    public static void CallToStart() {
        About_us obj = new About_us();
        obj.start(new Stage());
    }

    private void openWebpage1(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void openWebpage2(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void openWebpage3(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void openWebpage4(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

   
    


}
