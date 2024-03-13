import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javafx.scene.image.Image;

public class Retrive_img_JDBC {
    
    static Connection connection = ConnectionProvider.getConnection();
    public static Image getImg(int id){//int id){

        
        //int id = 1;

        try {
            // Retrieve the image data from the database by ID
            String selectQuery = "SELECT pic FROM pinfo WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Read the image data as bytes and create an Image
                byte[] imageBytes = resultSet.getBytes("pic");
                return new Image(new ByteArrayInputStream(imageBytes));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getUserName(int id) {
        try {
            // Retrieve the username from the database by ID
            String selectQuery = "SELECT username FROM pinfo WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Read the username from the result set
                return resultSet.getString("username");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if the username couldn't be retrieved
   }

    public static String getProductName(int id) {
        try {
            // Retrieve the username from the database by ID
            String selectQuery = "SELECT itemName FROM pinfo WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Read the username from the result set
                return resultSet.getString("itemName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if the username couldn't be retrieved
    }


    public static String getProductType(int id) {
        try {
            // Retrieve the username from the database by ID
            String selectQuery = "SELECT itemType FROM pinfo WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Read the username from the result set
                return resultSet.getString("itemType");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if the username couldn't be retrieved
    }


    public static String getCityName(int id) {
        try {
            // Retrieve the username from the database by ID
            String selectQuery = "SELECT cityName FROM pinfo WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Read the username from the result set
                return resultSet.getString("cityName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if the username couldn't be retrieved
    }

     public static String getAddress(int id) {
        try {
            // Retrieve the username from the database by ID
            String selectQuery = "SELECT address FROM pinfo WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Read the username from the result set
                return resultSet.getString("address");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if the username couldn't be retrieved
    }
public static String getDescription(int id) {
        try {
            // Retrieve the username from the database by ID
            String selectQuery = "SELECT info FROM pinfo WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Read the username from the result set
                return resultSet.getString("info");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if the username couldn't be retrieved
    }

    public static String getReceived(int id) {
        try {
            // Retrieve the username from the database by ID
            String selectQuery = "SELECT received FROM pinfo WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Read the username from the result set
                return resultSet.getString("received");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Return null if the username couldn't be retrieved
    }

    public static int getTotalCount(){
        int count =0;
        try{
            String query = "SELECT * FROM pinfo ";
            Statement stmt=connection.createStatement();
            ResultSet ste = stmt.executeQuery(query);
            while(ste.next()){
                count++;
            }


        }catch(Exception e){
            e.printStackTrace();


        }

        return count;

    }

    public static int getCityCount(String city){
        int count = 0;
        try{
            String query = "SELECT * FROM pinfo ";
            Statement stmt=connection.createStatement();
            ResultSet ste = stmt.executeQuery(query);
            while(ste.next()){
                String tempCity = ste.getString(5);
                if(tempCity.equals(city)){
                count++;
                }
            }


        }catch(Exception e){
            e.printStackTrace();
        }
        return count;
    }

    public static int getItemNameCount(String item){
        int count = 0;
        try{
            String query = "SELECT * FROM pinfo ";
            Statement stmt=connection.createStatement();
            ResultSet ste = stmt.executeQuery(query);
            while(ste.next()){
                String name= ste.getString(3);
               if(item.equals(name)){
                count++;
               }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return count;
    }

    public static int getItemTypeCount(String item){
        int count = 0;
        try{
            String query = "SELECT * FROM pinfo ";
            Statement stmt=connection.createStatement();
            ResultSet ste = stmt.executeQuery(query);
            while(ste.next()){
                String name= ste.getString(4);
               if(item.equals(name)){
                count++;
               }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return count;
    }

    static ArrayList arrList(String cityName){

         ArrayList arr = new ArrayList<>();
        try{
            Connection con = ConnectionProvider.getConnection();
            String query = "select * from pinfo";

            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(query);

            

            while(set.next()){

                String city = set.getString(5);
             
                int id = set.getInt(1);

                if(city.equals(cityName)){
                    arr.add(id);
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return arr;

    }

    static ArrayList getBySearch(String itemName){

         ArrayList arr = new ArrayList<>();
        try{
            Connection con = ConnectionProvider.getConnection();
            String query = "select * from pinfo";

            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(query);

            

            while(set.next()){

                String city = set.getString(3);
             
                int id = set.getInt(1);

                if(city.equals(itemName)){
                    arr.add(id);
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return arr;

    }

     static ArrayList getByItemType(String itemType){

         ArrayList arr = new ArrayList<>();
        try{
            Connection con = ConnectionProvider.getConnection();
            String query = "select * from pinfo";

            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(query);

            

            while(set.next()){

                String city = set.getString(4);
             
                int id = set.getInt(1);

                if(city.equals(itemType)){
                    arr.add(id);
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return arr;

    }

    
    public static ArrayList getIdList(){
        ArrayList idArr = new ArrayList<>();
        try{
            String query = "SELECT id FROM pinfo ";
            Statement stmt = connection.createStatement();
            ResultSet ste = stmt.executeQuery(query);
             int id=0;
            while(ste.next()){
               
                id = ste.getInt("id");
                idArr.add(id);

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return idArr;
    }

}