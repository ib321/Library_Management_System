package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookDAO {

	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {        
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "root";
        String password = "password";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,username,password);
        return con;
    }
   
	public void newClass() throws ClassNotFoundException, SQLException
	{
		Connection conn=BookDAO.getConnection();
		conn.createStatement();
	}
	
	
	
	
	
}
