import java.sql.*;
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
public class InsertQueryTest {
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
            PreparedStatement pst = conn.prepareStatement("insert into employee values (?,?,?)");
            pst.setInt(1,555);
            pst.setString(2,"ROBERT");
            pst.setInt(3,6666);

            int rows = pst.executeUpdate();
            System.out.println("Rows inserted : "+rows);

            pst.close();
            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
