import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Day8ACIDProperties {
    static String url="jdbc:mysql://localhost:3306/JDBC";
    static String username="root";
    static String password="@Arun2004";

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int pin=2004;
        Connection con=null;
        PreparedStatement pstmt_s=null;
        PreparedStatement pstmt_r=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(url,username,password);

            con.setAutoCommit(false);

            String sendQuery="update bank set balance=balance-? where uid=?";

            String receiveQuery="update bank set balance=balance+? where uid=?";

            System.out.println("Enter the amount to send: ");
            int amount=in.nextInt();
            System.out.println("Enter the uid of sender: ");
            int uid=in.nextInt();

            pstmt_s=con.prepareStatement(sendQuery);
            pstmt_s.setInt(1,amount);
            pstmt_s.setInt(2,uid);
            int n1=pstmt_s.executeUpdate();
            System.out.println("Sending money: "+n1);

            System.out.println("Enter the uid of receiver: ");
            uid=in.nextInt();
            pstmt_r=con.prepareStatement(receiveQuery);
            pstmt_r.setInt(1,amount);
            pstmt_r.setInt(2,uid);
            int n2=pstmt_r.executeUpdate();
            System.out.println("Receiving money: "+n2);

            System.out.println("Enter the pin Number: ");
            if(pin==in.nextInt() && n1==1 && n2==1){
                con.commit();
                System.out.println("Success");
            }
            else{
                con.rollback();
                System.out.println("Failure");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
