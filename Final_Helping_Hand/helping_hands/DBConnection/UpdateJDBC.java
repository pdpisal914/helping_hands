import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateJDBC{

    public static void main(String[] args){
        try{
            Connection con = ConnectionProvider.getConnection();

            String q = "update productInfo set itemName=?, itemType=?, cityName=?, info=? where id=?";

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter new item name:");
            String name = br.readLine();
            System.out.println("Enter Intem type:");
            String itemType = br.readLine();
            System.out.println("Enter city name:");
            String city = br.readLine();
            System.out.println("Enter the item info:");
            String info = br.readLine();
            System.out.println("Enter the id");
            int id = Integer.parseInt(br.readLine());

            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setString(3,name);
            pstmt.setString(4,itemType);
            pstmt.setString(5,city);
            pstmt.setString(7,info);
            pstmt.setInt(1,id);

            System.out.println("done...");
            con.close();

        }catch(Exception e){

            e.printStackTrace();
        }
    }
}