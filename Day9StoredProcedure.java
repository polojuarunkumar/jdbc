import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Scanner;

public class Day9StoredProcedure {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Connection con=null;
        CallableStatement prepCall=null;
        try{
            con=MyConnection.connect();

            prepCall=con.prepareCall("{call countOfDeptValue(?,?)}");
            System.out.println("Enter the department: ");
            String dept=in.nextLine();
            prepCall.setString(1,dept);
            prepCall.registerOutParameter(2, Types.INTEGER);
            prepCall.execute();
            int x =prepCall.getInt(2);
            System.out.println("No of employees in "+dept+" department are: "+x);

            prepCall=con.prepareCall("{call countOfSalaryGreaterThan50000(?,?)}");
            System.out.println("Enter the Salary ");
            int sal=in.nextInt();
            prepCall.setInt(1,sal);
            prepCall.registerOutParameter(2,Types.INTEGER);
            prepCall.execute();
            int y=prepCall.getInt(2);
            System.out.println(y);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
