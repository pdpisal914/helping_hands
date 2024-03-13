import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class SelectedData{

    public static void main(String[] args){

        try{
            Connection con = ConnectionProvider.getConnection();
            String query = "select * from productinfo";

            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(query);

            while(set.next()){
                String userName = set.getString(2);
                String itemName = set.getString(3);
                String itemType = set.getString(4);
                String city = set.getString(5);
                String info = set.getString(7);

                System.out.println("userName : "+ userName);
                System.out.println("item Name : "+ itemName);
                System.out.println("item type : "+ itemType);
                System.out.println("city : "+ city);
                System.out.println("Discription : "+ info);

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}