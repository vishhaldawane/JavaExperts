package com.example.demo1;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    Connection conn ;
    Statement st;
    ResultSet rs;
    public void init() {

        message = "Hello World!";
        // TODO Auto-generated method stub
        try {
            //1st is to load the driver
            System.out.println("Trying to load the driver...");
            DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
            //DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            System.out.println("Driver is loaded.....");

            //MS SQL SERVER --> TWO WAYS TO CONNECT --> VIA WINDOWS AUTHENTICATION
            //OTHER IS USUAL USERNAME AND PASSWORD

            //2nd is to acquire the connection
            System.out.println("Trying to connect to Oracle");
            conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydb", "SA","");
            //conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:OSE", "scott","tiger");
            System.out.println("Connected....."+conn);

            //3rd is to decide the query
            //4th run the query and get the output

            //6th close the connection


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        System.out.println("doGet invoked...");
       // String source = request.getParameter("sourcecity"); //html variables reading
        //String target = request.getParameter("targetcity"); //html variables reading
       // String jdate = request.getParameter("journeydate"); //html variables reading
       // System.out.println("Client is searching for ..."+source+" to "+target+" on "+jdate);

        try {
            st  = conn.createStatement();
            rs  = st.executeQuery("SELECT * FROM EMPLOYEE");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("columns "+rsmd.getColumnCount());
            for(int i=1;i<=rsmd.getColumnCount();i++) {
                System.out.println("Column name : "+rsmd.getColumnName(i));
            }

            PrintWriter pw = response.getWriter();
            pw.println("hello");

            //5th process the output if required
            pw.println("<table border=5 cellspacing=5 cellpadding=5>");
            while(rs.next()) {
                pw.println("<tr>");
                pw.println("<td>EMPLOYEE NUMBER  </td> <td> "+rs.getInt(1)+"</td>");
                pw.println("<td>EMPLOYEE NAME  </td> <td>"+rs.getString(2)+"</td>");
                pw.println("<td>EMPLOYEE SALARY  </td> <td>"+rs.getString(3)+"</td>");
               // pw.println("<td>FLIGHT DATE    </td> <td>"+rs.getDate(4)+"</td>");
              //  pw.println("<td>FLIGHT AIRLINE </td> <td>"+rs.getString(5)+"</td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void destroy() {
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}