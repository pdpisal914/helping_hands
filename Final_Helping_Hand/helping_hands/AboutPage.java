import java.net.URI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.awt.Desktop;

public class AboutPage extends Application{
    
    public static void About_us(){
          Stage stage = new Stage();
          StackPane root = new StackPane();

          Image backgroundImage = new Image("./Images/62.jpg");
          BackgroundImage background = new BackgroundImage(
          backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT, new BackgroundSize(800, 400, true, true, true, true) );
          Background backgroundWithImage = new Background(background);
          root.setBackground(backgroundWithImage);

          ImageView sir = new ImageView(new Image("./AboutImages/sir.png"));
          sir.setTranslateX(-200);
          sir.setTranslateY(-150);
          sir.setFitHeight(250);
          sir.setFitWidth(350);
          root.getChildren().add(sir);

          ImageView c2w = new ImageView(new Image("./AboutImages/c2w.jpg"));
          c2w.setTranslateX(100);
          c2w.setTranslateY(-250);
          c2w.setFitHeight(50);
          c2w.setFitWidth(50);
          root.getChildren().add(c2w);

          ImageView yt = new ImageView(new Image("./AboutImages/youtube.png"));
          yt.setTranslateX(180);
          yt.setTranslateY(-250);
          yt.setFitHeight(50);
          yt.setFitWidth(50);
          root.getChildren().add(yt);

          ImageView linkedin = new ImageView(new Image("./AboutImages/linkedin.png"));
          linkedin.setTranslateX(260);
          linkedin.setTranslateY(-250);
          linkedin.setFitHeight(50);
          linkedin.setFitWidth(50);
          root.getChildren().add(linkedin);

          ImageView insta = new ImageView(new Image("./AboutImages/instagram.jpg"));
          insta.setTranslateX(340);
          insta.setTranslateY(-250);
          insta.setFitHeight(50);
          insta.setFitWidth(50);
          root.getChildren().add(insta);

          c2w.setOnMouseClicked(e -> openc2w("https://www.core2web.in/"));
          yt.setOnMouseClicked(e -> openyt("https://www.youtube.com/@Core2web"));
          linkedin.setOnMouseClicked(e -> openlinkedin("https://in.linkedin.com/company/core2web-technologies"));
          insta.setOnMouseClicked(e -> openinsta("https://www.instagram.com/core2web/"));

           Text paragraph = new Text("We want to take a moment express our\nheartfelt your expertise and support have\nbeen instrumental in helping us navigating\n through various challenges and achieve \nour goals .We truly appreciate the time and\n effort you've invested in our growth and\ndevelopement...");
         paragraph.setTranslateX(-180);
         paragraph.setTranslateY(150);
         paragraph.setFont(javafx.scene.text.Font.font(20));
         root.getChildren().add(paragraph);

         Text members = new Text("Team Members");
         members.setTranslateX(200);
         members.setTranslateY(-150);
         members.setFont(javafx.scene.text.Font.font("Times New Roman",FontPosture.REGULAR,30));
         root.getChildren().add(members);

         Text membersname = new Text("Shradha Jadhav\nPranav Pisal\nKiran Pawar\nAvishkar\nChaitanya");
         membersname.setTranslateX(200);
         membersname.setTranslateY(-50);
         membersname.setFont(javafx.scene.text.Font.font("Times New Roman",FontPosture.REGULAR,20));
         root.getChildren().add(membersname);
          
          Scene scene = new Scene(root,800,600);
          stage.setScene(scene);
          stage.setTitle("About US");
          stage.show();

    
  }

  public static void openc2w(String url){
         try{
            Desktop.getDesktop().browse(new URI(url));
         }catch(Exception e){
            e.printStackTrace();
         }

  }

  public static void openyt(String url){
         try{
            Desktop.getDesktop().browse(new URI(url));
         }catch(Exception e){
            e.printStackTrace();
         }

  }

  public static void openlinkedin(String url){
         try{
            Desktop.getDesktop().browse(new URI(url));
         }catch(Exception e){
            e.printStackTrace();
         }

  }

  public static void openinsta(String url){
         try{
            Desktop.getDesktop().browse(new URI(url));
         }catch(Exception e){
            e.printStackTrace();
         }

  }

@Override
public void start(Stage primaryStage) throws Exception {
   // TODO Auto-generated method stub
   throw new UnsupportedOperationException("Unimplemented method 'start'");
}
}
  /* 
  public static void main(String [] args){
      launch( args);
  }

  public void start(Stage primaryStage){
         StackPane stackpane = new StackPane();
         ImageView logo = new ImageView(new Image("HelpingHands_logo.jpg"));
         logo.setFitHeight(150);
         logo.setFitWidth(150);
         stackpane.getChildren().add(logo);

         logo.setOnMouseClicked(e ->{
            primaryStage.close();
            About_us();});

         Scene scene = new Scene(stackpane,800,600);
         primaryStage.setScene(scene);
         primaryStage.setTitle("about");
         primaryStage.show();
  }
}*/
