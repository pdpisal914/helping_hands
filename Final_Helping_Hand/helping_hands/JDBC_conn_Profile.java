import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_conn_Profile {
       private static Connection con;
       public static Connection getConnection(){
         try{
            if(con==null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                con =DriverManager.getConnection("jdbc:mysql://localhost:3306/galaxy", "root", "912004");
            }
         }catch(Exception e){
            e.printStackTrace();
         }
         return con;
       }
}
