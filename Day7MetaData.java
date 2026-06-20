import java.sql.*;

public class Day7MetaData {

    public static void main(String[] args) {

        Connection con=null;
        Statement stmt=null;
        ResultSet res=null;
        ResultSetMetaData rsmd=null;

        String query="select *from employee";

        try{
            con=MyConnection.connect();

            stmt = con.createStatement();
            res=stmt.executeQuery(query);

            rsmd=res.getMetaData();
            int x=rsmd.getColumnCount();
            System.out.println("No of Columns are: "+x);

            for(int i=1;i<=x;i++){
                System.out.println("Column No: "+i
                        +"\n\tColumn Name: "+rsmd.getColumnName(i)
                        +"\n\tColumn datatype: "+rsmd.getColumnTypeName(i)
                        +"\n\tColumn Nullable: "+(rsmd.isNullable(i)==1?"Yes":"No")
                        +"\n\tIs it is Auto Increment: "+(rsmd.isAutoIncrement(i)?"Yes":"No")
                        +"\n\n");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
