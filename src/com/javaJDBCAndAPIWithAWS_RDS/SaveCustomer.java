package com.javaJDBCAndAPIWithAWS_RDS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SaveCustomer 
{

	public static void main(String[] args) throws SQLException
	{

		Connection connection = null;
		Scanner scanner = null;		

		try
		{			

			//database connection object
			connection = DatabaseConnection.getDatabaseConnection();
			
			while(true)
			{
				//disable the autoCommint of MySQL server.
				connection.setAutoCommit(false);

				scanner = new Scanner(System.in);
				
				System.out.println("Enter customer id: ");
				int id1 = scanner.nextInt();
				
				scanner.nextLine();

				System.out.println("Enter customer name: ");
				String name = scanner.nextLine();

				System.out.println("Enter customer contact: ");
				String contact = scanner.nextLine();

				System.out.println("Enter customer address: ");
				String address = scanner.nextLine();

				//Customer object
				Customer customer = new Customer(id1, name, contact, address);

				//create query for to customer object.
				String query = "insert into customer(customer_id, customer_name, customer_contact, customer_address) values(?, ?, ?, ?)";

				//Query statement object
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				//set values to query statement
				preparedStatement.setInt(1, customer.getCustomerId());
				preparedStatement.setString(2, customer.getCustomerName());
				preparedStatement.setString(3, customer.getCustomerContact());
				preparedStatement.setString(4, customer.getCustomerAddress());

				preparedStatement.executeUpdate();

				System.out.println("\nwant to 'commit/rollback' the customer object?");
				String inputAnswer = scanner.next().toLowerCase();

				if(inputAnswer.equals("commit"))
				{
					connection.commit();
				}
				else if(inputAnswer.equals("rollback"))
				{
					connection.rollback();
				}

				System.out.println("\nwant to save more customer objects? 'yes/no'");
				String response = scanner.next().toLowerCase();

				if(response.equals("no"))
				{
					break;
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{			
			connection.close();	
			scanner.close();
		}


	}

}
