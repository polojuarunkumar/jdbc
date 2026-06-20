import java.sql.*;
import java.util.Scanner;


public class Day3InsertAcceptingData {
    public static void main(String[] args) {
        Scanner sc1=new Scanner(System.in);
        Scanner sc2=new Scanner(System.in);

        Connection con=null;
        PreparedStatement pstmt=null;

        String url="jdbc:mysql://localhost:3306/JDBC";
        String username="root";
        String password="@Arun2004";

        int Id,Salary;
        String Name,Dept;

        String query="insert into employee values (?,?,?,?)";

        System.out.println("Enter the Id ");
        Id=sc1.nextInt();
        System.out.println("Enter the Name");
        Name=sc2.nextLine();
        System.out.println("Enter the Dept ");
        Dept=sc2.nextLine();
        System.out.println("Enter the Salary");
        Salary=sc1.nextInt();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(url,username,password);
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,Id);
            pstmt.setString(2,Name);
            pstmt.setString(3,Dept);
            pstmt.setInt(4,Salary);

            int x=pstmt.executeUpdate();

        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

    }
}
