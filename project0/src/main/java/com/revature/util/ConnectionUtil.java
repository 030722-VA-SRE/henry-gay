package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	// reuse this connection instead of creating more connections to the database
	private static Connection con;
	
	// returns a connection if it exists/is open, otherwise creates a connection to the database
	public static Connection getConnection() throws SQLException {
		
		/*-
		 * Create system variables in the System Environment to reference location of database
		 * Authentication handled by username and password set in System Environment
		 */
		
		String url = System.getenv("DB_URL");
		String username = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS");
		
		/*-
		 * Check to see if connection is non-existent OR if connection has been closed.
		 * Attempt to get new connection using System Variables defined above.
		 */
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, username, password);
		}
		return con;
	}

}
