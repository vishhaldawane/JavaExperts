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
public class UPDATEueryTest {
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

            conn.setAutoCommit(false); // auto commit mode is OFF, default was true

            //3rd is to decide the query
            //4th run the query and get the output
            PreparedStatement pst = conn.prepareStatement("UPDATE EMPLOYEE SET EMPNAME=?, EMPSAL=? WHERE EMPNO=?");

            Scanner scan1 = new Scanner(System.in);
            Scanner scan2 = new Scanner(System.in);
            Scanner scan3 = new Scanner(System.in);
            Scanner scan4 = new Scanner(System.in);


            System.out.println("Enter new employee name : ");
            String newEmployeeName=scan1.nextLine();

            System.out.println("Enter new employee salary : ");
            int newEmployeeSalary=scan2.nextInt();

            System.out.println("For employee number : ");
            int forEmployeeNumber=scan3.nextInt(); //7566


            pst.setString(1,newEmployeeName);
            pst.setInt(2,newEmployeeSalary);
            pst.setInt(3,forEmployeeNumber);  //data must come from UI /htmlform

            int rows = pst.executeUpdate();

            System.out.println("Are you sure to update this record ?  ");
            String answer =scan4.nextLine();

            if(answer.equalsIgnoreCase("yes")) {
                conn.commit(); // permanent changes
                System.out.println("Record is updated successfully...");
                System.out.println("Rows UPDATED : "+rows);
            }else {
                conn.rollback(); //changes are discarded
                System.out.println("Record is discarded to update...");
            }




            pst.close();
            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
