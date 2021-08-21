import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*

following diagram is NOT of inheritance,it is just a logical flow of understanding


                DriverManager
                   | registerDriver()
                   | getConnection()
                 ------------------
                            |
                           Connection
                           |
              ---------------------------------------
              |             |                   |
          Statement PreparedStatement       CallableStatement
          select     insert/update/delete   procedure/functions

 */
public class DeleteQueryTest {
    public static void main(String[] args) {
        //JDBC - java database connectivity


        try {
        //1st is to load the driver
        System.out.println("Trying to load the driver...");
        DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
        System.out.println("Driver is loaded.....");


            //2nd is to acquire the connection
            System.out.println("Trying to connect to HSQLDB");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydb", "SA","");
            System.out.println("Connected....."+conn);
            

            //3rd is to decide the query
            //4th run the query and get the output
            PreparedStatement pst = conn.prepareStatement("delete from EMPLOYEE  WHERE EMPNO=?");

            Scanner scan1 = new Scanner(System.in);
            System.out.println("For employee number : ");
            int forEmployeeNumber=scan1.nextInt();

            pst.setInt(1,forEmployeeNumber);  //data must come from UI /htmlform

            int rows = pst.executeUpdate();
            System.out.println("Rows DELETED : "+rows);

            pst.close();
            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
