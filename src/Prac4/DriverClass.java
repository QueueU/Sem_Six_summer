package Prac4;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverClass {
    
    public static String Driver="com.mysql.jdbc.Driver";
    public static String UserName="root";
    public  static String password="ujash7878";
    public static String Path="jdbc:mysql://localhost:3306/test";

    public static  Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName(DriverClass.Driver);
        Connection con= DriverManager.getConnection(DriverClass.Path,DriverClass.UserName,DriverClass.password);
        return con;

    }
    
}
