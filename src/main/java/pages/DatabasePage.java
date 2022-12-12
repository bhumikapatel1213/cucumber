package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePage {
	 
	 Connection connection;
	 Statement statement;
	 ResultSet resultSet;
	 String columnValue;
	 
	 public String getDataFromDb(String columnName)  {
	  
	//  set properties for mySQL 
	  try {   
	  Class.forName("com.mysql.cj.jdbc.Driver");   
	  
	  String sqlUsername= "root";
	  String sqlPassword = "root";
	  String sqlUrl = "jdbc:mysql://localhost:3306/juneqa2022";
	  String sqlQurey = "Select * from users;" ;
	  
	//  Create connection to the local database  
	  connection = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
	  
	//  Empowering connection reference variable to execute queries   
	  statement = connection.createStatement(); 
	  
	//  Delivering query  
	  resultSet = statement.executeQuery(sqlQurey);
	  
	  while (resultSet.next()) {
		columnValue = resultSet.getString(columnName);
		return columnValue;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (connection != null) {
				try {
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return columnValue;
	}

}
