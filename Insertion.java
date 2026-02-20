import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Insertion {
    public static void main(String[] args) {

        String url="jdbc:mysql://localhost:3306/JDBC";
        String username="root";
        String password="@Arun2004";

        Connection con = null;
        Statement stmt=null;
        ResultSet res=null;

        String query="insert into employee values (106,'Dinesh','Business',75000)";

        int Id,Salary;
        String Name,Dept;
        try{
            //Load the Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establish the connection
            con=DriverManager.getConnection(url,username,password);
            //Create the connection
            stmt = con.createStatement();
            //Execute the connection
            res=stmt.executeQuery("select *from employee");

            int x=stmt.executeUpdate(query);
            //Process the information
            while(res.next()==true){

                Id=res.getInt(1);
                Name=res.getString(2);
                Dept=res.getString(3);
                Salary=res.getInt(4);
                System.out.printf("%d %-10s %-10s %d\n",Id,Name,Dept,Salary);
            }
        }
        catch(ClassNotFoundException |SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                res.close();
                stmt.close();
                con.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }

    }
}
