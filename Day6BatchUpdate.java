import java.sql.*;
import java.util.Scanner;

public class Day6BatchUpdate {
    public static void main(String[] args) {
        Scanner sc1=new Scanner(System.in);
        Scanner sc2=new Scanner(System.in);
        Connection con=null;
        PreparedStatement pstmt=null;
        String q="insert into `employee` value (?,?,?,?)";

        String empName,dept,ch;
        int empId,salary;
        try{
            con=MyConnection.connect();

            pstmt=con.prepareStatement(q);
            for(;;){
                System.out.println("Enter the EmpId: ");
                empId=sc2.nextInt();
                System.out.println("Enter the EmpName: ");
                empName=sc1.nextLine();
                System.out.println("Enter the Dept: ");
                dept=sc1.nextLine();
                System.out.println("Enter the Salary");
                salary=sc2.nextInt();

                pstmt.setInt(1,empId);
                pstmt.setString(2,empName);
                pstmt.setString(3,dept);
                pstmt.setInt(4,salary);

                pstmt.addBatch();
                System.out.println("Do you want to insert more (y/n");
                ch=sc1.next();
                if(ch.equals("n")){
                    break;
                }
            }
            int a[]=pstmt.executeBatch();
            for(int x:a){
                System.out.println(x);
            }
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
}
