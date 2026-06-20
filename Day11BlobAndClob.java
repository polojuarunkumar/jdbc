import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Day11BlobAndClob {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Connection con=null;
        PreparedStatement pstmt=null;
        try {
            con = MyConnection.connect();
            File f = new File("C:\\Users\\arunk\\Documents\\Frontend\\Programs\\JAVA\\JDBC\\JDBC\\src\\image.jpg");
            FileInputStream fi = new FileInputStream(f);

            String query = "update employee set image=? where empId=?";
            pstmt = con.prepareStatement(query);
            System.out.println("Enter the id:");
            pstmt.setInt(2, in.nextInt());

            pstmt.setBinaryStream(1, fi);
            int x = pstmt.executeUpdate();
            System.out.println("Update " + (x == 1 ? "Yes" : "No"));

            FileReader fr=new FileReader("C:\\Users\\arunk\\Documents\\Frontend\\Programs\\JAVA\\JDBC\\JDBC\\src\\Notes");
            String text="Update employee set text=? where empId=?";
            pstmt=con.prepareStatement(text);
            System.out.println("Enter the id:");
            pstmt.setInt(2,in.nextInt());
            pstmt.setCharacterStream(1,fr);
            int y=pstmt.executeUpdate();
            System.out.println(y);

        } catch (FileNotFoundException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
