package Ibrahimweb.jdpc_course.deo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBconnection {
    private static final String HOST="localhost";
    private static final int PORT=3306;
    private static final String DB_NAME="db";
    private static final String USERNAME="root";
    private static final String  PASSWORD="";
    //private static  final String url ="jdbc:postgresql:db";
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DB_NAME), USERNAME,PASSWORD);
            //return con;

        } catch (SQLException  | ClassNotFoundException e) {
            System.out.println("Connection ERROR ");
            e.printStackTrace();

        }

        return con;
    }
    }




//ALTER USER 'root'@'localhost' IDENTIFIED BY 'newpassword';



