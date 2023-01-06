package Library_management_system;

import java.sql.*;
public class conn
{
    Connection c;
    Statement s;
    conn()
    {
        String url = "jdbc:mysql://localhost:3306/lms1";
        String username = "root";
        String password = "Atharva#1234";
        try
        {
            c = DriverManager.getConnection(url, username,password);
            s = c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String[] args)
    {
        new conn();
    }

}