import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class JdbcConnectivity {
    public static void main(String[] args) {

        String url="jdbc:mysql://localhost:3306/JDBC";
        String username="root";
        String password="@Arun2004";

        Connection con = null;
        Statement stmt=null;
        ResultSet res=null;

        int Id,Salary;
        String Name,Dept;
        try{
//            //1) load the Driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            //2) Establish the connection with Database
//            //Connection c=DriverManager.getConnection(url,user,password);
//            //url=api:vendor://ip-address:port num/db name;
//            con=DriverManager.getConnection(url,username,password);

            con=MyConnection.connect();

            //3) create the statement
            stmt = con.createStatement();
            res=stmt.executeQuery("select *from employee");

            //4) execute the statement or process the statement
            while(res.next()==true){

                Id=res.getInt(1);
                Name=res.getString(2);
                Dept=res.getString(3);
                Salary=res.getInt(4);

//                System.out.println(Id+"  "+Name+"  "+ Dept+"  "+Salary);
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
