package com.tcs.connection;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager 
{
	String serverName = "172.24.137.30";
	String portNumber = "1521";
	String sid = "orcl";
	String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":"
			+ sid;
	String username = "e843589";
	String password = "yckqeHvaB";
	Statement statement = null;
	Connection conn = null;

	public Connection getConnection() {
		try {
			
			// load the JDBC-ODBC Bridge driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// connect to db using DriverManager
			System.out.println("The Jdbc URL is " + url);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException cnfex) {
			System.out.println("Class not found !! " + cnfex);
		} catch (SQLException sqlex) {
			System.out.println("SQL Exception !! " + sqlex);
			sqlex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Exception has occured " + ex);
		}
		return conn;
	}

	public void closeConnection(Connection conn) {
		try {
			if (null != conn) {
				conn.close();
			}
		} catch (SQLException e) {

		}

	}
}
