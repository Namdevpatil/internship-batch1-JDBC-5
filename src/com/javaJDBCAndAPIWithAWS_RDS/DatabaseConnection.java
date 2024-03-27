package com.javaJDBCAndAPIWithAWS_RDS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
	
	//database credentials
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL= "jdbc:mysql://my-database.c1os42ssqvau.ap-south-1.rds.amazonaws.com:3306/customer_db";
	private static final String DATABASE_USERNAME = "admin";
	private static final String DATABASE_PASSWORD = "admin12345";
	
	public static Connection getDatabaseConnection() throws SQLException
	{
		
		Connection connection = null;
		
		try
		{
			//load/register driver
			Class.forName(DRIVER_NAME);//type-4 driver/thin driver
			
			//create connection object
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
				
		return connection;
		
	}

}
