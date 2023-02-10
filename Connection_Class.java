package CAB_BOOKING;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connection_Class {

    Connection con;
    Statement stmt;
    //create a connection class

// creating a constructor
    public Connection_Class() {
        try{

            // Register a Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection
            String url="jdbc:mysql://localhost:330/cabproject";
            String username="root";
            String password="Sanan@321";
             con= DriverManager.getConnection(url,username,password);

            //create a statement
            stmt=con.createStatement();
            if (con.isClosed()){
                System.out.println("Successful");
            }
            else {
                System.out.println("Error");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Connection_Class();
    }
}
