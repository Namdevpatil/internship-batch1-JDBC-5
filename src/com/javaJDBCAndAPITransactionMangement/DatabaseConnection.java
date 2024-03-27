package com.javaJDBCAndAPITransactionMangement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
	
	//database credentials
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL= "jdbc:mysql://localhost:3306/customer_db";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "DeV@1990";
	
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
