import java.sql.*;
import java.util.Scanner;

public class SelectSingleRecordQueryTest {
    public static void main(String[] args) {
        //JDBC - java database connectivity


        try {
        //1st is to load the driver
        System.out.println("Trying to load the driver...");
        DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
        System.out.println("Driver is loaded.....");

    //MS SQL SERVER --> TWO WAYS TO CONNECT --> VIA WINDOWS AUTHENTICATION
            //OTHER IS USUAL USERNAME AND PASSWORD

            //2nd is to acquire the connection
            System.out.println("Trying to connect to HSQLDB");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydb", "SA","");
            System.out.println("Connected....."+conn);


            Scanner scan1 = new Scanner(System.in);
            System.out.println("For employee number : ");
            int forEmployeeNumber=scan1.nextInt();

            //3rd is to decide the query
            //4th run the query and get the output
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEE WHERE EMPNO="+forEmployeeNumber);

            //5th process the output if required
            if(rs.next()) {
                System.out.println("EMPLOYEE NUMBER : "+rs.getInt(1));
                System.out.println("EMPLOYEE NAME   : "+rs.getString(2));
                System.out.println("EMPLOYEE SALARY : "+rs.getInt(3));
                System.out.println("-----------------------------");
            } else {
                System.out.println("Employee NOT found : "+forEmployeeNumber);
            }
            //6th close the connection
            rs.close();
            st.close();
            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
