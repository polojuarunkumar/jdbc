import java.sql.*;
import java.util.Scanner;
public class Day5DeleteOperation {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        Connection con=null;
        PreparedStatement pstmt=null;
        //        Statement stmt=null;
        try{
            con=MyConnection.connect();
//            stmt = con.createStatement();
//            int x=stmt.executeUpdate("delete from `employee` where `empid`=502");
//
//            if(x!=0){
//                System.out.println("Data Deleted "+x);
//            }
//            else{
//                System.out.println("Failure in Deletion");
//            }

            String Query="delete from `employee` where `empId`=?";
            pstmt=con.prepareStatement(Query);
            System.out.println("Enter the EmpId to be deleted");
            int id=in.nextInt();
            pstmt.setInt(1,id);
            System.out.println(pstmt.executeUpdate());

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
