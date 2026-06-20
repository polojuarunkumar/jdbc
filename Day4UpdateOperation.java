import java.sql.*;
import java.util.Scanner;

public class Day4UpdateOperation {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        String dept;
        int inc;

        Connection con=null;
//        Statement stmt=null;
        PreparedStatement pstmt=null;

        System.out.println("Enter the Department: ");
        dept=in.nextLine();
        System.out.println("Enter the salary to be incremented: ");
        inc=in.nextInt();

        try{
            con=MyConnection.connect();
//            String query="update `employee` set `salary`=`salary`+555 where `dept`='HR'";
//            stmt=con.createStatement();
//            int x=stmt.executeUpdate(query);
//            if( x!=0){
//                System.out.println("Update Success");
//            }
//            else{
//                System.out.println("Update Failure");
//            }

            String sql="update `employee` set `salary`=`salary`+? where `dept`=?";

            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1,inc);
            pstmt.setString(2,dept);
            System.out.println(pstmt.executeUpdate());

        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
