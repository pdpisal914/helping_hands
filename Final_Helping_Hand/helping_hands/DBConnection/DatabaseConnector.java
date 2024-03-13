import java.sql.*;

public class DatabaseConnector {

    public static Connection connect() {
        return null;
    }

    public static void main(String[] args){

        try{
            // load the driver
            try{
                Class.forName("com.mysql.jdbc.Driver"); //"com.mysql.jdbc.Driver");
            }catch(ClassNotFoundException es){
                es.printStackTrace();
            }
         //  DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // creating the connection
            String url = "jdbc:mysql://localhost:3306/galaxy";
            String username = "root";
            String password = "shraddha#19";

            Connection con = DriverManager.getConnection(url, username, password);

            if(con.isClosed()){

                System.out.println("Connection is closed");
            }else{
                System.out.println("connection is created...");
            }
        }catch(Exception e){

            e.printStackTrace();
        }
    }

}
